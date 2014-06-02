package com.example.pomodictionary;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends Activity {
	private MediaPlayer player;
	private int position;
	
  @Override
  public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_result);
    position = getIntent().getIntExtra("position", 0);    
    ImageView image = (ImageView) findViewById(R.id.imageView1);
    image.setImageResource(Word.getImage(position));
    TextView english = (TextView) findViewById(R.id.textView2);
    english.setText(Word.getEnglish(position));
    setTitle(Word.getPomo(position) + ": " + Word.getEnglish(position));
    TextView pomo = (TextView) findViewById(R.id.textView1);
    pomo.setText(Word.getPomo(position));
    image.setOnClickListener(new View.OnClickListener() {
        public void onClick(View arg0) {
      if (player == null) {
         playSound(Word.getSound(position));
      }
        }
       });
  }
  
  private void playSound(Integer sound) {
	     player = MediaPlayer.create(this, sound);
	     player.start();
	     player.setOnCompletionListener(new OnCompletionListener() {
	   
	   @Override
	   public void onCompletion(MediaPlayer mp) {
	    player.release();
	    player = null;
	   }
	  });
	    }
  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
    	if (!(Word.getDescription(position).equals(""))) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
    	} else {
    		return false;
    	}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_about:
	        	//Toast.makeText(getApplicationContext(), Word.getDescription(position),Toast.LENGTH_LONG).show();
	        	
	        	
	        	TextView textview = new TextView(this);
	        	textview.setText(Word.getDescription(position));
	        	textview.setBackgroundColor(Color.parseColor("#363636"));
	        	textview.setGravity(0);
	        	textview.setTextColor(Color.WHITE);
	        	textview.setPadding(10,10,10,10);
	        	Toast toast = new Toast(this);
	        	toast.setView(textview);
	        	toast.setDuration(Toast.LENGTH_LONG);
	        	toast.show();
	            break;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	    return true;
	}
  
} 
