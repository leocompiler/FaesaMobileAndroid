package com.github.faesamobileandroid.view;

 
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.faesamobileandroid.ControllerPrincipal;
import com.github.faesamobileandroid.R;
import com.github.faesamobileandroid.data.Estudante;
import com.github.faesamobileandroid.data.Materia;

public class NotasFaltas extends Activity{
	private List<Materia> materiaNotas ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ControllerPrincipal controller = new ControllerPrincipal(this,new Handler());
		controller.consultarNotasFaltas();
	}
	
	
	
	public void setGridView(Estudante estudante){
		setContentView(R.layout.aluno_notasfaltas);
		materiaNotas = estudante.getListMaterias();
		
		ArrayAdapter<Materia> adaptador = new ArrayAdapter<Materia>(this,R.layout.lista_item_personalizado, materiaNotas) {
			public View getView(int position, View convertView,ViewGroup parent) {
				Materia materia = materiaNotas.get(position);
		          String notas ="";
		          for(int i = 0 ; i<materia.getNota().size();i++){
		          	notas += "|"+materia.getNota().get(i)+"";
		          }
		         String tmp = materia.getNome()+"\n"+notas+"|"+materia.getQuantFaltas()+"|"+materia.getQuantFaltasOcorridas()+"|";

				View view = super.getView(position, convertView, parent);
				((TextView) view).setText(tmp);
				 	          
		          
				return view;
			}
		};
		ListView lista = (ListView) findViewById(R.id.listView1);
		lista.setAdapter(adaptador);
		
	}
}
