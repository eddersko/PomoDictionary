package com.example.jano_shojin;


import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.northpomo.janoshojin.R;

public class MenuActivity extends Activity {
 
   @Override
   public void onCreate(Bundle bundle) {
     super.onCreate(bundle);
     setContentView(R.layout.activity_menu);
     // set title
     setTitle("Title");
     final Context ctx = this;
        final TextView about= (TextView) findViewById(R.id.about);
        final TextView words=(TextView) findViewById(R.id.words);
        final TextView quiz=(TextView) findViewById(R.id.quiz);
        final TextView contact=(TextView) findViewById(R.id.contact);
        about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
             about.setTextColor(Color.GRAY);
               Intent intent = new Intent(ctx, AboutActivity.class); 
               startActivity(intent);
            }
        });
        words.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
             words.setTextColor(Color.GRAY);
               Intent intent = new Intent(ctx, MainActivity.class); 
          intent.putExtra("option", 1); 
               startActivity(intent);
            }
        });
        quiz.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
             quiz.setTextColor(Color.GRAY);
               Intent intent = new Intent(ctx, MainActivity.class); 
          intent.putExtra("option", 2); 
               startActivity(intent);
            }
        });
        contact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
             contact.setTextColor(Color.GRAY);
               Intent intent = new Intent(ctx, ContactActivity.class); 
               startActivity(intent);
            }
        });     
   }
   /*
   @Override
   public void onBackPressed() { 
   }
   */
}