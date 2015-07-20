package net.fagner.trf5.inventario2013;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TecladoActivity extends Activity {
	public static final int TECLADO_REQUEST_CODE = 3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teclado);
		Button outros = (Button) findViewById(R.id.teclado_button);
		
		   outros.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	EditText outrostexto = (EditText) findViewById(R.id.tecladotexto_edittext);
		        	if (outrostexto.getText().toString().equals("")) {
		        		Intent intent = getIntent();
		        		setResult(RESULT_CANCELED, intent);
		        	} else {
		        	Intent intent = getIntent();
		          	intent.putExtra("tombo", outrostexto.getText().toString());
		        	setResult(RESULT_OK, intent);}
		        	finish();
		        }
	    });
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teclado, menu);
		return true;
	}
	   public void onCancel(View view) {
		   finish();
		}
}
