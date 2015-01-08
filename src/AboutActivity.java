package com.example.jano_shojin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import com.northpomo.janoshojin.R;

public class AboutActivity extends Activity {
 
   @Override
   public void onCreate(Bundle bundle) {
     super.onCreate(bundle);
     setContentView(R.layout.activity_about);
        setTitle("Back to Home");
     getActionBar().setHomeButtonEnabled(true);

     ImageView image1 = (ImageView) findViewById(R.id.elenor);
     image1.setImageResource(R.drawable.elenor);
     
     ImageView image2 = (ImageView) findViewById(R.id.edna);
     image2.setImageResource(R.drawable.edna);
     
     String htmlText = "<html><body style=\"text-align:justify\"> %s </body></Html>";
     	
     	// insert data
     
        String myData = "<p>Insert text here.</p>";
        
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
  public void onBackPressed() {
      Intent homeIntent = new Intent(this, MenuActivity.class);
      homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      startActivity(homeIntent);  
  }

  
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
      // Handle presses on the action bar items
      switch (item.getItemId()) {
        case android.R.id.home:             
        	  Intent homeIntent = new Intent(this, MenuActivity.class);
              homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(homeIntent);          
            break; 
          case R.id.action_cancel:
              Intent homeIntent2 = new Intent(this, MenuActivity.class);
              homeIntent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(homeIntent2);  
        	  break;
          default:
              return super.onOptionsItemSelected(item);
      }
      return true;
  }
}