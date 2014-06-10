package com.example.pomodictionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class AboutActivity extends Activity {
	
	  @Override
	  public void onCreate(Bundle bundle) {
	    super.onCreate(bundle);
	    setContentView(R.layout.activity_about);
        setTitle("About This Application");

	    ImageView image1 = (ImageView) findViewById(R.id.elenor);
	    image1.setImageResource(R.drawable.elenor);
	    
	    ImageView image2 = (ImageView) findViewById(R.id.edna);
	    image2.setImageResource(R.drawable.edna);
	    
	    String htmlText = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String myData = "This language app is part of a project to archive and make available materials on the Northern Pomo language, collected over 25 years. These material exist due to the dedication and work of Edna Campbell Guerrero and Elenor Stevenson Gonzales, both native speakers of Northern Pomo. This app was designed by Elodie Paquette, implemented in iOS by Elodie Paquette and Josh Leibsly, and implemented in Android by Edwin Ko. It was supported in part by a grant from the NEH/NSF Documenting Endangered Languages program (FN-50107-12) to Catherine O&apos;Connor, which is gratefully acknowledged. Views expressed in this material are the work of the authors, and do not necessarily reflect the views of the U.S. National Science Foundation or National Endowment for the Humanities. This material may not be sold.";
        
        WebView webView = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDefaultFontSize(19);
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
        webView.setBackgroundColor(0x00000000);
	  }
	  
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
		    MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.menu.about_actions, menu);
		    return super.onCreateOptionsMenu(menu);
		}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    // Handle presses on the action bar items
		    switch (item.getItemId()) {
		      case android.R.id.home:             
		          Intent intent = new Intent(this, MainActivity.class);  
		          startActivity(intent);            
		          break; 
		        case R.id.action_cancel:
			        Intent intent22 = new Intent(this, MainActivity.class);  
			        startActivity(intent22);            
		        	break;
		        default:
		            return super.onOptionsItemSelected(item);
		    }
		    return true;
		}
}
