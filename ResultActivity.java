package com.example.pomodictionary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
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
    	getActionBar().setHomeButtonEnabled(true);
    	setTitle(Word.getPomo(position) + ": " + Word.getEnglish(position));

    	position = getIntent().getIntExtra("position", 0);    
    	playSound(Word.getSound(position));
    	
    	ImageView image = (ImageView) findViewById(R.id.imageView1);
    	image.setImageResource(Word.getImage(position));
    	
    	TextView english = (TextView) findViewById(R.id.textView2);
    	english.setText(Word.getEnglish(position));
    	
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
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.result_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		
	    	case android.R.id.home:            
	          Intent intent = new Intent(this, MainActivity.class);  
	          if (player != null) {
	        		player.stop();
	        		player.release();
	        	}
	          startActivity(intent);            
	          break; 
	       
	    	case R.id.action_about:	        
	        	TextView textview = new TextView(this);
	        	textview.setText(Word.getDescription(position));
	        	textview.setBackgroundColor(Color.parseColor("#363636"));
	        	textview.setGravity(0);
	        	textview.setTextColor(Color.WHITE);
	        	textview.setPadding(10,10,10,10);
	        	final Toast toast = new Toast(this);
	        	toast.setView(textview);
	        	toast.setDuration(toast.LENGTH_SHORT);
	        	toast.show();
	        	new CountDownTimer(3000, 1000) {
	        	    public void onTick(long millisUntilFinished) {toast.show();}
	        	    public void onFinish() {toast.show();}
	        	}.start();
	            break;
	        
	    	case R.id.action_cancel:
	        	Intent intent11 = new Intent(this, GridActivity.class);
	        	String[] categories = Word.getCategories();
	        	int category = 0;
	        	
	        	for (int i = 0; i < categories.length; i++) {
	        		if (Word.getCategory(position).equals(categories[i])) {
	        			category = i;
	        		}
	        	}   
	        	intent11.putExtra("position", category);
	        	if (player != null) {
	        		player.stop();
	        		player.release();
	        	}
	        	startActivity(intent11);
	        	break;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	    return true;
	}
} 
