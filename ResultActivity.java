package com.example.pomodictionary;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private MediaPlayer player;
  @Override
  public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_result);
    final int position = getIntent().getIntExtra("position", 0);    
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
  
} 
