package com.github.faesamobileandroid.view;

import com.github.faesamobileandroid.ControllerPrincipal;
import com.github.faesamobileandroid.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

public class HistoricoEscolar extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ControllerPrincipal controller = new ControllerPrincipal(this, new Handler());
		controller.consultarHistorico();
	}
	
	public void setWebView(String bufferHtml){
		setContentView(R.layout.aluno_historico_escolar);
		
		String resp = "<html>"+bufferHtml+"</html>";
		//resp = resp.replace("#", "%23");
		resp = resp.replace("%", "%25");
		resp = resp.replace("\\", "%27");
		resp = resp.replace("?", "%3f");

		WebView webview = (WebView)findViewById(R.id.webView1);
		webview.loadData(resp, "text/html","UTF-8");
	}
}
