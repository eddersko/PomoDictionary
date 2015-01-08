package com.example.jano_shojin;

import java.util.ArrayList;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.northpomo.janoshojin.R;

public class MainActivity extends Activity {
 
 GridView gridView;
 ArrayList<Item> gridArray = new ArrayList<Item>();
 CustomGridViewAdapter customGridAdapter;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main); 
     getActionBar().setHomeButtonEnabled(true);
  int option = getIntent().getIntExtra("option", 0); 

  setTitle("Back to Home");

  String[] categories = Word.getCategories();
  
  Map<String, Integer> map = Word.getCategoryMap();
  if (option == 2) {
  map = Word.getQuizCategoryMap();
  }
  
  for (int i = 0; i < categories.length; i++) {
	  // check heap
   //Bitmap image = decodeSampledBitmapFromResource(getResources(), map.get(categories[i]), 250, 250);
   	// check heap
   BitmapFactory.Options options = new BitmapFactory.Options();
   Bitmap image = BitmapFactory.decodeResource(getResources(), map.get(categories[i]), options);    
   gridArray.add(new Item(image, categories[i], ""));
  }

  
  
  gridView = (GridView) findViewById(R.id.gridView1);
  customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
  gridView.setAdapter(customGridAdapter);
  final Context ctx = this;
  
  if (option == 1) {
     gridView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
          Intent intent = new Intent(ctx, GridActivity.class); 
          intent.putExtra("position", position); 
          startActivity(intent);
         }
     });
  } else {
   
      gridView.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
           Intent intent = new Intent(ctx, QuizActivity.class); 
           intent.putExtra("position", position); 
           startActivity(intent);
          }
      });

  }
 }
 
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {  
     MenuInflater inflater = getMenuInflater();
     inflater.inflate(R.menu.main_activity_actions, menu);
     return super.onCreateOptionsMenu(menu);
 }
 
 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
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
 
   @Override
   public void onBackPressed() {
       Intent homeIntent = new Intent(this, MenuActivity.class);
       homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       startActivity(homeIntent);  
   }

}