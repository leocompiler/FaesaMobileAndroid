package com.github.faesamobileandroid.view;

 
import com.github.faesamobileandroid.ControllerPrincipal;
import com.github.faesamobileandroid.R;
import com.github.faesamobileandroid.data.Estudante;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class NotasFaltas extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.aluno_notasfaltas);
		super.onCreate(savedInstanceState);
		ControllerPrincipal controller = new ControllerPrincipal(this,new Handler());
		controller.consultarNotasFaltas();
	}
	
	
	
	public void setGridView(Estudante estudante){
		GridView grid = (GridView)findViewById(R.id.gridView1);
		grid.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView textView = new TextView(NotasFaltas.this);
				textView.setText("M");
				return textView;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 20;
			}
		});
		setContentView(grid);
		
	}
}
