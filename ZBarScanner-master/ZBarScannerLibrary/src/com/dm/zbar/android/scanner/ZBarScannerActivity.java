package com.dm.zbar.android.scanner;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import net.sourceforge.zbar.Config;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.SymbolSet;

public class ZBarScannerActivity extends Activity implements Camera.PreviewCallback, ZBarConstants {
	private boolean isLighOn = false;
    private static final String TAG = "ZBarScannerActivity";
    private CameraPreview mPreview;
    private Camera mCamera;
    private Camera camera1;
    private ImageScanner mScanner;
    private Handler mAutoFocusHandler;
    private boolean mPreviewing = true;

    static {
        System.loadLibrary("iconv");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isCameraAvailable()) {
            // Cancel request if there is no rear-facing camera.
            cancelRequest();
            return;
        }

        // Hide the window title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        

        // Create and configure the ImageScanner;
        
        
    
        
        // Create a RelativeLayout container that will hold a SurfaceView,
        // and set it as the content of our activity.
        Button bt = new Button(this);
        bt.setText("LUZ");
        bt.setOnClickListener(new OnClickListener() {
        	@Override
			public void onClick(View arg0) {
 
				if (isLighOn) {
                    //onPause();
					getCamera();
					Parameters p = mCamera.getParameters();
     				p.setFlashMode(Parameters.FLASH_MODE_OFF);
					mCamera.setParameters(p);
			        
					//mCamera.stopPreview();
					isLighOn = false;
					//onResume();
 
				} else {
                    //onPause();
					getCamera();
					Parameters p = mCamera.getParameters();
					p.setFlashMode(Parameters.FLASH_MODE_TORCH);
 					mCamera.setParameters(p);
 			        
 			        //mPreview.setCamera(mCamera);
 			        //mPreview.showSurfaceView();
 					//mCamera.stopPreview();
					isLighOn = true;
                    //onResume();
 
				}

			}
		});

        mAutoFocusHandler = new Handler();
        setupScanner();
        mPreview = new CameraPreview(this, this, autoFocusCB);
        setContentView(mPreview);
        addContentView(bt, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }
    
    private void getCamera() {
        if (mCamera == null) {
            try {
                mCamera = Camera.open();
                Parameters p1 = mCamera.getParameters();
            } catch (RuntimeException e) {

            }
        }
    }

    public void setupScanner() {
        mScanner = new ImageScanner();
        mScanner.setConfig(0, Config.X_DENSITY, 3);
        mScanner.setConfig(0, Config.Y_DENSITY, 3);

        int[] symbols = getIntent().getIntArrayExtra(SCAN_MODES);
        if (symbols != null) {
            mScanner.setConfig(Symbol.NONE, Config.ENABLE, 0);
            for (int symbol : symbols) {
                mScanner.setConfig(symbol, Config.ENABLE, 1);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Open the default i.e. the first rear facing camera.
        mCamera = Camera.open();
        if(mCamera == null) {
            // Cancel request if mCamera is null.
            cancelRequest();
            return;
        }

        mPreview.setCamera(mCamera);
        mPreview.showSurfaceView();

        mPreviewing = true;
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Because the Camera object is a shared resource, it's very
        // important to release it when the activity is paused.
        if (mCamera != null) {
            mPreview.setCamera(null);
            mCamera.cancelAutoFocus();
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            mCamera.release();

            // According to Jason Kuang on http://stackoverflow.com/questions/6519120/how-to-recover-camera-preview-from-sleep,
            // there might be surface recreation problems when the device goes to sleep. So lets just hide it and
            // recreate on resume
            mPreview.hideSurfaceView();

            mPreviewing = false;
            mCamera = null;
        }
    }

    public boolean isCameraAvailable() {
        PackageManager pm = getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    public void cancelRequest() {
        Intent dataIntent = new Intent();
        dataIntent.putExtra(ERROR_INFO, "Camera unavailable");
        setResult(Activity.RESULT_CANCELED, dataIntent);
        finish();
    }

    public void onPreviewFrame(byte[] data, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size size = parameters.getPreviewSize();

        Image barcode = new Image(size.width, size.height, "Y800");
        barcode.setData(data);

        int result = mScanner.scanImage(barcode);

        if (result != 0) {
        	
        	   //Size size1 = camera.getParameters().getPreviewSize(); 
        	   //final int w = size1.width; 
        	   //final int h = size1.height;
        	   //final YuvImage image = new YuvImage(data, ImageFormat.NV21, w, h, null);
        	   //ByteArrayOutputStream os = new ByteArrayOutputStream(data.length);
        	   //if(!image.compressToJpeg(new Rect(0, 0, w, h), 100, os)){
        	        //return;
        	    //}
        	   //byte[] tmp = os.toByteArray();
        	    //Bitmap bmp = BitmapFactory.decodeByteArray(tmp, 0,tmp.length); 
        	    //FileHelper fileHelper = new FileHelper();
        	    //fileHelper.storeInSD(bmp);  	
        	
            mCamera.cancelAutoFocus();
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            mPreviewing = false;
            SymbolSet syms = mScanner.getResults();
            for (Symbol sym : syms) {
                String symData = sym.getData();
                if (!TextUtils.isEmpty(symData)) {
                    Intent dataIntent = new Intent();
                    dataIntent.putExtra(SCAN_RESULT, symData);
                    dataIntent.putExtra(SCAN_RESULT_TYPE, sym.getType());
                    setResult(Activity.RESULT_OK, dataIntent);
                    finish();
                    break;
                }
            }
        }
    }
    private Runnable doAutoFocus = new Runnable() {
        public void run() {
            if(mCamera != null && mPreviewing) {
                mCamera.autoFocus(autoFocusCB);
            }
        }
    };

    // Mimic continuous auto-focusing
    Camera.AutoFocusCallback autoFocusCB = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean success, Camera camera) {
            mAutoFocusHandler.postDelayed(doAutoFocus, 1000);
        }
    };
}
