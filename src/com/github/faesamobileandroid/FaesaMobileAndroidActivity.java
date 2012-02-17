package com.github.faesamobileandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.faesamobileandroid.view.MenuPrincipal;

public class FaesaMobileAndroidActivity extends Activity {

	private ControllerPrincipal controller ;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autenticacao);

        controller = new ControllerPrincipal();
        controller.initSessao();
    
        Button button = (Button)findViewById(R.id.buttonEntrar);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText matriculaTextView = (EditText)findViewById(R.id.editText1);
				EditText senhaTextView = (EditText)findViewById(R.id.editText2);
				
				controller.autenticacao(matriculaTextView.getText().toString(),senhaTextView.getText().toString());
				
			}
		});
        
    }
    
    
    public void popUpMensagemRetornoController(String msg){
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Aviso!")
		   .setMessage(msg)
		   .setCancelable(false)
		   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
			   public void onClick(DialogInterface dialog, int id) {
			    	
			   }
		   });
		 AlertDialog alertDialog = builder.create();
		alertDialog.show();	
    }
    
	public void autorizacaoAprovado(){
		startActivity(new Intent(this,MenuPrincipal.class));
	}
    
     
    
}