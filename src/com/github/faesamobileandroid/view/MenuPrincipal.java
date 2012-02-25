package com.github.faesamobileandroid.view;



import java.util.ArrayList;
import java.util.List;
 

import com.github.faesamobileandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuPrincipal extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.menu_principal);
		super.onCreate(savedInstanceState);
		ListView listaPrincipal = (ListView)findViewById(R.id.listmenuprincipal);
		
		List<String> listDados = new ArrayList<String>();
		listDados.add("Dados Cadastral");
		listDados.add("Notas e Faltas");
		listDados.add("Histórico");
		listDados.add("Extrato/2ª Via Boleto");
		listDados.add("Estagios/Empregos");
		
		ArrayAdapter <String> adaptador = new ArrayAdapter <String>(this,R.layout.lista_item_personalizado, listDados);
		listaPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0,View arg1, int arg2, long arg3) {
				iniciarProximoActivy(arg2);
			}

		});
		
		listaPrincipal.setAdapter(adaptador);
	}
	
	public void iniciarProximoActivy(int indice){
		switch (indice) {
		case 0:
			startActivity(new Intent(this, DadosCadastro.class));
			break;
		case 1:
			startActivity(new Intent(this, NotasFaltas.class));
			break;
		case 2:
			startActivity(new Intent(this, DadosCadastro.class));
			break;
		case 3:
			startActivity(new Intent(this, DadosCadastro.class));
			break;
		case 4:
			startActivity(new Intent(this, DadosCadastro.class));
			break;			

		default:
			break;
		}
	}
	
	
	
}
