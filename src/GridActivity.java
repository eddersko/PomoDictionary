package com.example.jano_shojin;


import java.util.ArrayList;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.northpomo.janoshojin.R;

/**
 * @author manish.s
 * Edited by Edwin Ko
 */

public class GridActivity extends Activity {
 GridView gridView;
 ArrayList<Item> gridArray = new ArrayList<Item>();
 CustomGridViewAdapter customGridAdapter;
 String category;
 private ProgressDialog progressDialog;
 final Context ctx = this;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  
  setContentView(R.layout.activity_main);// implement
  int position = getIntent().getIntExtra("position", 0);
  String[] categories = Word.getCategories();
     getActionBar().setHomeButtonEnabled(true);

  category = categories[position];
  
  if (category.equals("all")) {
  
  new LoadViewTask().execute();
  } else {
   final int[] interval = Word.getCategoryInterval(category);
   setTitle("Back to Home");
   // int n = Word.getCategoryCount();
   for (int i = interval[0]; i <= interval[1]; i++) {    
    //Bitmap image = decodeSampledBitmapFromResource(getResources(), Word.getImage(i), 250, 250);
    //gridArray.add(new Item(image, Word.getPomo(i), Word.getEnglish(i)));
    
    BitmapFactory.Options options = new BitmapFactory.Options();
    Bitmap image = BitmapFactory.decodeResource(getResources(), Word.getImage(i), options); 
    //Bitmap image = decodeSampledBitmapFromResource(getResources(), Word.getImage(i), 250, 250);
    gridArray.add(new Item(image, Word.getPomo(i), Word.getEnglish(i)));

   }

   gridView = (GridView) findViewById(R.id.gridView1);
   customGridAdapter = new CustomGridViewAdapter(ctx, R.layout.row_grid, gridArray);
   gridView.setAdapter(customGridAdapter);
      gridView.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
           Intent intent = new Intent(ctx, ResultActivity.class);
           intent.putExtra("position", interval[0] + position);
           startActivity(intent);
  }
      });
      
  }
 }
 
 private class LoadViewTask extends AsyncTask<Void, Integer, Void> {
  
  @Override
  protected void onPreExecute() {
      progressDialog = ProgressDialog.show(GridActivity.this,"Loading...", "Loading application View, please wait...", false, false);  
  }
  
  @Override
  protected Void doInBackground(Void... params) {
   /* This is just a code that delays the thread execution 4 times, 
             * during 850 milliseconds and updates the current progress. This 
             * is where the code that is going to be executed on a background 
             * thread must be placed. 
             */  
            try  
            {  
                //Get the current thread's token  
                synchronized (this)  
                {  
                    //Initialize an integer (that will act as a counter) to zero  
                    int counter = 0;  
                    //While the counter is smaller than four  
                    while(counter <= 1)  
                    {  
                        //Wait 850 milliseconds  
                        this.wait(150);  
                        //Increment the counter  
                        counter++;  
                        //Set the current progress.  
                        //This value is going to be passed to the onProgressUpdate() method.  
                        publishProgress(counter*25);  
                    }  
                }  
            }  
            catch (InterruptedException e)  
            {  
                e.printStackTrace();  
            }  
            return null; 
  }
  
  @Override
  protected void onProgressUpdate(Integer... values) {
   progressDialog.setProgress(values[0]);

  }
  
  @Override
  protected void onPostExecute(Void result) {
   

  final int[] interval = Word.getCategoryInterval(category);
  setTitle("Back to Home");
  // int n = Word.getCategoryCount();
  for (int i = interval[0]; i <= interval[1]; i++) {
  //Bitmap image = BitmapFactory.decodeSampleBitmapFromResource(this.getResources(), Word.getImage(i));
   BitmapFactory.Options options = new BitmapFactory.Options();
   Bitmap image = BitmapFactory.decodeResource(getResources(), Word.getImage(i), options); 
   //Bitmap image = decodeSampledBitmapFromResource(getResources(), Word.getImage(i), 250, 250);
   gridArray.add(new Item(image, Word.getPomo(i), Word.getEnglish(i)));

  }

  gridView = (GridView) findViewById(R.id.gridView1);
  customGridAdapter = new CustomGridViewAdapter(ctx, R.layout.row_grid, gridArray);
  gridView.setAdapter(customGridAdapter);
     gridView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
          Intent intent = new Intent(ctx, ResultActivity.class);
          intent.putExtra("position", interval[0] + position);
          startActivity(intent);
 }
     });
     
     progressDialog.dismiss();
 }
 }

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
     MenuInflater inflater = getMenuInflater();
     inflater.inflate(R.menu.grid_activity_actions, menu);
     return super.onCreateOptionsMenu(menu);
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
       	  super.onBackPressed();           
          break;
         default:
             return super.onOptionsItemSelected(item);
     }
     return true;
 }
 /*
 @Override
 public void onBackPressed() {
  Intent intent = new Intent(this, MainActivity.class); 
     intent.putExtra("option", 1); 
     startActivity(intent);
   }
*/
}