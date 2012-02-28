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
		super.onCreate(savedInstanceState);
		ControllerPrincipal controllerPrincipal = new ControllerPrincipal(this, new Handler());
		controllerPrincipal.consultarDadosAluno();
	}
	
	public void setTelaDadosAluno(Estudante estudante){
		setContentView(R.layout.aluno_dados);
		EditText editDescricao = (EditText)findViewById(R.id.descricao);
		String textDescricao ="Nome: "+estudante.getNome() ;
		textDescricao += "\n\nEndereço: "+estudante.getCadastro().getEndereco() ;
		textDescricao += "\n\nComplemento: "+estudante.getCadastro().getComplemento() ;
		textDescricao += "\n\nBairro: "+estudante.getCadastro().getBairro();
		textDescricao += "\n\nCidade: "+estudante.getCadastro().getCidade() ;
		textDescricao += "\n\nEstado: "+estudante.getCadastro().getEstado() ;
		textDescricao += "\n\nCEP: "+estudante.getCadastro().getCep();
		
		editDescricao.setText(textDescricao);
	}
}
