package net.fagner.trf5.inventario2013;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class OutrosActivity extends Activity {
	 public static final int TIME_ENTRY_REQUEST_CODE = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_outros);
		
		Button outros = (Button) findViewById(R.id.outrostexto_button);
		
		   outros.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	EditText outrost = (EditText) findViewById(R.id.tecladotexto_edittext);
		        	if (outrost.getText().toString().equals("")) {
		        		Intent intent = getIntent();
		        		setResult(RESULT_CANCELED, intent);	
		        	} else {
		        	
		        	Intent intent = getIntent();
		        	
		        	Bundle b = intent.getExtras();
			        		        			        	
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "19");
		        	intent.putExtra("outros", outrost.getText().toString());
		        	intent.putExtra("situacao", b.getString("situacao"));
		        	setResult(RESULT_OK, intent);}
		        	finish();
		        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.outros, menu);
		return true;
	}
	   public void onCancel(View view) {
		   finish();
		}
}
