package net.fagner.trf5.inventario2013;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class ItensActivity extends Activity {
	 public static final int TIME_ENTRY_REQUEST_CODE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_itens);
		
		Intent intent2 = getIntent();
    	
    	Bundle b2 = intent2.getExtras();
        
    	TextView TextView2 = (TextView) findViewById(R.id.tombotelavalor_textview);
    	
    	TextView2.setText(b2.getString("tombo"));
			
		ImageButton monitor = (ImageButton) findViewById(R.id.monitor_button);
		   monitor.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "0");
		        	intent.putExtra("outros", "monitor");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });
		   
			
		   ImageButton estabilizador = (ImageButton) findViewById(R.id.estabilizador_button);
		   estabilizador.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "1");
		        	intent.putExtra("outros", "estabilizador");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });
		   
		   ImageButton impressora = (ImageButton) findViewById(R.id.impressora_button);
		   impressora.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "2");
		        	intent.putExtra("outros", "impressora");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });
		  
		   
		   ImageButton telefone = (ImageButton) findViewById(R.id.telefone_button);
		   telefone.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "3");
		        	intent.putExtra("outros", "telefone");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });
		   
		   ImageButton gabinete = (ImageButton) findViewById(R.id.gabinete_button);
		   gabinete.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "4");
		        	intent.putExtra("outros", "gabinete");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });
		   
		   ImageButton nobreak = (ImageButton) findViewById(R.id.nobreak_button);
		   nobreak.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "5");
		        	intent.putExtra("outros", "nobreak");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });
		   ImageButton scanner = (ImageButton) findViewById(R.id.scanner_button);
		   scanner.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "6");
		        	intent.putExtra("outros", "scanner");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });
		   
		   ImageButton fax = (ImageButton) findViewById(R.id.fax_button);
		   fax.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "7");
		        	intent.putExtra("outros", "fax");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });
		   ImageButton cadeira = (ImageButton) findViewById(R.id.cadeira_button);
		   cadeira.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "8");
		        	intent.putExtra("outros", "cadeira");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });		   		   
		   ImageButton mesa = (ImageButton) findViewById(R.id.mesa_button);
		   mesa.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "9");
		        	intent.putExtra("outros", "mesa");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });		   		   
		   
		   ImageButton mesaapoio = (ImageButton) findViewById(R.id.mesaapoio_button);
		   mesaapoio.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "10");
		        	intent.putExtra("outros", "mesa de apoio");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });			   
		   
		   ImageButton gaveteiro = (ImageButton) findViewById(R.id.gaveteiro_button);
		   gaveteiro.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "11");
		        	intent.putExtra("outros", "gaveteiro");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });			   
		   		   
		   ImageButton sofa2lugares = (ImageButton) findViewById(R.id.sofa_button);
		   sofa2lugares.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "12");
		        	intent.putExtra("outros", "sofa 2 lugares");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });		 
		   
		   ImageButton estacaotrabalho = (ImageButton) findViewById(R.id.estacaotrabalho_button);
		   estacaotrabalho.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "13");
		        	intent.putExtra("outros", "estacao de trabalho");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });		 
		     
		   ImageButton armario = (ImageButton) findViewById(R.id.armario_button);
		   armario.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "14");
		        	intent.putExtra("outros", "armario");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });		 
		   
		   ImageButton estante = (ImageButton) findViewById(R.id.estante_button);
		   estante.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "15");
		        	intent.putExtra("outros", "estante");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });		 
		    
		   ImageButton livro = (ImageButton) findViewById(R.id.livro_button);
		   livro.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "16");
		        	intent.putExtra("outros", "livro");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });			   
		   ImageButton quadro = (ImageButton) findViewById(R.id.quadro_button);
		   quadro.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "17");
		        	intent.putExtra("outros", "quadro");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });			   
		   		   
		   ImageButton microondas = (ImageButton) findViewById(R.id.microondas_button);
		   microondas.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
		        	int selectedOption = radioGroup.getCheckedRadioButtonId();
		        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
		        	Intent intent = getIntent();
		        	Bundle b = intent.getExtras();
		        	intent.putExtra("tombo", b.getString("tombo"));
		        	intent.putExtra("objeto", "18");
		        	intent.putExtra("outros", "microondas");
		        	intent.putExtra("situacao", radioGenderButton.getText());
		        	setResult(RESULT_OK, intent);
		        	finish();
	
		        }
		    });			   
	   
	
				ImageButton outros = (ImageButton) findViewById(R.id.outrostexto_button);
				   outros.setOnClickListener(new View.OnClickListener() {
				        @Override
				        public void onClick(View v) {
				        	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.situacao_button);
				        	
				        	int selectedOption = radioGroup.getCheckedRadioButtonId();
				        	
				        	RadioButton radioGenderButton = (RadioButton) findViewById(selectedOption);
				        	
				        	Intent intent = getIntent();
				        	
				        	Bundle b = intent.getExtras();
				       				        	
				        	Intent intent1 = new Intent(ItensActivity.this, OutrosActivity.class);
				        	
				        	intent1.putExtra("tombo", b.getString("tombo"));
				        	
				        	intent1.putExtra("situacao",radioGenderButton.getText());
				        	
				        	startActivityForResult(intent1, TIME_ENTRY_REQUEST_CODE);
				        }
			    });		   
				 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.itens, menu);
		return true;
	}
   public void onCancel(View view) {
   finish();
}
   
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   	
   	if (requestCode == TIME_ENTRY_REQUEST_CODE) {
   		if (resultCode == RESULT_OK) {
   			String tombo = data.getStringExtra("tombo");
   			String objeto = data.getStringExtra("objeto");
   			String outros = data.getStringExtra("outros");
   			String situacao = data.getStringExtra("situacao");
   			//timeTrackerAdapter.addTimeRecord( new TimeRecord(time, notes));
   			//timeTrackerAdapter.notifyDataSetChanged();
   			Intent intent = getIntent();
         	intent.putExtra("tombo", tombo);
   			intent.putExtra("objeto", "19");
        	intent.putExtra("outros", outros);
        	intent.putExtra("situacao", situacao);
        	setResult(RESULT_OK, intent);
        	finish();
   		} else {finish();}
   		}
   	}
     
}
