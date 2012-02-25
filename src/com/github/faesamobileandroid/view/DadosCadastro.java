package com.github.faesamobileandroid.view;

import com.github.faesamobileandroid.ControllerPrincipal;
import com.github.faesamobileandroid.R;
import com.github.faesamobileandroid.data.Estudante;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;

public class DadosCadastro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.aluno_dados);
		super.onCreate(savedInstanceState);
		ControllerPrincipal controllerPrincipal = new ControllerPrincipal(this, new Handler());
		controllerPrincipal.consultarDadosAluno();
	}
	
	public void setTelaDadosAluno(Estudante estudante){
		EditText editDescricao = (EditText)findViewById(R.id.descricao);
		String textDescricao = "Nome:"+estudante.getNome() ;
		textDescricao += "\nEndereço:"+estudante.getCadastro().getEndereco() ;
		textDescricao += "\nComplemento:"+estudante.getCadastro().getComplemento() ;
		textDescricao += "\nBairro:"+estudante.getCadastro().getBairro();
		textDescricao += "\nCidade:"+estudante.getCadastro().getCidade() ;
		textDescricao += "\nEstado:"+estudante.getCadastro().getEstado() ;
		textDescricao += "\nCEP:"+estudante.getCadastro().getCep();
		
		editDescricao.setText(textDescricao);
	}
}
