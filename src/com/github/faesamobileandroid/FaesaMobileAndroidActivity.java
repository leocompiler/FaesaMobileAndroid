package com.github.faesamobileandroid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class FaesaMobileAndroidActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String url = "http://aluno.faesa.br/sistema/NotasFaltas/Default.aspx";
       // String url = "http://www.terra.com.br";
        String buffer;
		try {
			buffer = RequestServer.requisitarDadosHttpGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			buffer = e.toString();
		}
		int start = buffer.indexOf(" <div id=\"ctl00_ContentPlaceHolder1_UpdatePanel1\">"); 
		int end = buffer.indexOf("<!-- FIM - MIOLO-->");
		String resp = "<html>"+buffer.substring(start, end)+"</html>";
		//resp = resp.replace("#", "%23");
		resp = resp.replace("%", "%25");
		resp = resp.replace("\\", "%27");
		resp = resp.replace("?", "%3f");
		
        WebView web = (WebView)findViewById(R.id.webView1);
        
        web.loadData(resp, "text/html","UTF-8");
        
        
    }
    
     
    
}