package com.github.faesamobileandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

 
import com.github.faesamobileandroid.data.Estudante;
import com.github.faesamobileandroid.data.RespostaAutenticacao;
import com.github.faesamobileandroid.data.RespostaDadosCadastro;
import com.github.faesamobileandroid.data.RespostaMateriasNotasFaltas;
import com.github.faesamobileandroid.data.ServiceFaesaOnline;
import com.github.faesamobileandroid.data.Sessao;
import com.github.faesamobileandroid.view.DadosCadastro;
import com.github.faesamobileandroid.view.NotasFaltas;

public class ControllerPrincipal {
	
	
	private static ServiceFaesaOnline service ;
	private static Estudante estudante  = new Estudante(); ;
	private static Sessao sessaoEstudante  = new Sessao();
	private Handler handler ;
	private Context context ;
	private ProgressDialog progress ; 
 
	public ControllerPrincipal(Context context , Handler handler){
		service = new ServiceFaesaOnline();
		this.handler = handler;
		this.context= context;
	}
	
	public void invokerWorksHandler(Runnable run){
		this.handler.post(run);
	}
	
	public void invokerWorks(Runnable run){
		new Thread(run).start();
	}
	private void  progressDialogShow(){
		invokerWorksHandler(new Runnable() {
			
			@Override
			public void run() {
				progress = ProgressDialog.show(context, "", "Carregando...");
			}
		});
		 
	}
	
	private void progressDialogDismiss(){
		invokerWorksHandler(new Runnable() {
			
			@Override
			public void run() {
				progress.dismiss();	
			}
		});
	}
	public void initSessao(){
		try {
			sessaoEstudante = service.sessionFaesaOnline();
			estudante.setSessao(sessaoEstudante);
		} catch (Exception e) {
			exibirMessagem("Erro:\n"+e.toString());
		}
	}
	public void autenticacao(final String matricula , final String senha ){
		invokerWorks(new Runnable() {
			
			@Override
			public void run() {
				estudante.setMatricula(matricula);
				estudante.setSenha(senha);
				progressDialogShow();
				try {
					
					RespostaAutenticacao resposta = service.autenticarFaesaOnline(estudante);
					FaesaMobileAndroidActivity activity = (FaesaMobileAndroidActivity)ControllerPrincipal.this.context ;
					if(resposta != null){
						if(resposta.isAutenticado()){
							estudante = resposta.getEstudante() ;
							activity.autorizacaoAprovado();
						}
					}
					else{
						String tmp = 	"O número de Matrícula ou Senha inseridos são inválidos.\n" +
										"Tente novamente!\n" +
										"Caso não consiga, clique em Esqueci minha senha e aguarde " +
										"que sua senha será enviada para o seu e-mail.";
						exibirMessagem(tmp);
					}
					
				} catch (Exception e) {
					progressDialogDismiss();
					exibirMessagem("Erro:\n"+e.toString());
				}
				progressDialogDismiss();
			}
		});
	}
	
	public void consultarNotasFaltas(){
		try {
			RespostaMateriasNotasFaltas resposta = service.materiasNotasFaltasFaesaOnline(estudante);
			estudante.setListMaterias(resposta.getListMateria());
			
			NotasFaltas activityDadosCadastro = (NotasFaltas)context ;
			activityDadosCadastro.setGridView(estudante);
		
		} catch (Exception e) {
			exibirMessagem("Erro:\n"+e.toString());
		}
	}

	public void consultarDadosAluno(){
		try {
			RespostaDadosCadastro resposta = service.dadosCadastroFaesaOnline(estudante);
			estudante.setCadastro(resposta.getDadosCadastro());
			DadosCadastro activityDadosCadastro = (DadosCadastro)context ;
			activityDadosCadastro.setTelaDadosAluno(estudante);
		
		} catch (Exception e) {
			exibirMessagem("Erro:\n"+e.toString());
		}
	}
	public void exibirMessagem(final String msg){
		invokerWorksHandler(new Runnable() {
			
			@Override
			public void run() {
				Toast.makeText(context, msg,Toast.LENGTH_LONG).show();
			}
		});
	}
	
}
