package net.fagner.trf5.inventario2013;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetorActivity extends Activity {
	private TimeTrackerDatabaseHelper databaseHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setor);
		databaseHelper = new TimeTrackerDatabaseHelper(this);
		final EditText setorvalor = (EditText) findViewById(R.id.setor_edittext);
		final EditText salavalor = (EditText) findViewById(R.id.sala_edittext);
		final EditText andarvalor = (EditText) findViewById(R.id.andar_edittext);
	    final EditText inventariantevalor = (EditText) findViewById(R.id.inventariante_edittext);
		final String[] temps=databaseHelper.buscadadosinventariada(databaseHelper.buscainventariadamaisrecente());
		setorvalor.setText(temps[0]);
		salavalor.setText(temps[1]);
		andarvalor.setText(temps[2]);
		inventariantevalor.setText(temps[3]);
	       Button digitar = (Button) findViewById(R.id.salvarsetor_button);
			   digitar.setOnClickListener(new View.OnClickListener() {
			        @Override
			        public void onClick(View v) {

			        	
			        	if	(setorvalor.getText().toString().equals("") || salavalor.getText().toString().equals("") || andarvalor.getText().toString().equals("") || inventariantevalor.getText().toString().equals("")) {
			        
			        	AlertDialog.Builder builder = new AlertDialog.Builder(SetorActivity.this);

			            builder.setTitle("Setor");
			            builder.setMessage("Campo(s) vazio(s).");

			            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			                public void onClick(DialogInterface dialog, int which) {
			                     
			                	dialog.dismiss();
			                    //databaseHelper.deletaTombo(0);
			                    //timeTrackerAdapter.notifyDataSetChanged();
			                }

			            });

			            AlertDialog alert = builder.create();
			            alert.show();
						        	
			        } else if (setorvalor.getText().toString().equals(temps[0]) && salavalor.getText().toString().equals(temps[1]) && andarvalor.getText().toString().equals(temps[2]) && inventariantevalor.getText().toString().equals(temps[3])) {
			        	
				        
			        	AlertDialog.Builder builder = new AlertDialog.Builder(SetorActivity.this);

			            builder.setTitle("Setor");
			            builder.setMessage("Favor alterar algum campo.");

			            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			                public void onClick(DialogInterface dialog, int which) {
			                     
			                	dialog.dismiss();
			                    //databaseHelper.deletaTombo(0);
			                    //timeTrackerAdapter.notifyDataSetChanged();
			                }

			            });

			            AlertDialog alert = builder.create();
			            alert.show();	
						        	
			        } else {
			        Intent intent = getIntent();
			        intent.putExtra("setor", setorvalor.getText().toString());
			        intent.putExtra("sala", salavalor.getText().toString());
			        intent.putExtra("inventariante", inventariantevalor.getText().toString());
			        setResult(RESULT_OK, intent);
			        databaseHelper.insereinventariada(setorvalor.getText().toString(), salavalor.getText().toString(), Integer.parseInt(andarvalor.getText().toString()), inventariantevalor.getText().toString());
			        finish();
			        }}
			    });
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setor, menu);
		return true;
	}
	   public void onCancel(View view) {
		   finish();
		}
}
