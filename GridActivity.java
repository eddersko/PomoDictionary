package com.example.pomodictionary;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * @author manish.s
 * Edited by Edwin Ko
 */

public class GridActivity extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;
	String category;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);// implement
		int position = getIntent().getIntExtra("position", 0);
		String[] categories = Word.getCategories();
	    getActionBar().setHomeButtonEnabled(true);

		category = categories[position];
		final int[] interval = Word.getCategoryInterval(category);
		setTitle(category);
		// int n = Word.getCategoryCount();
		for (int i = interval[0]; i <= interval[1]; i++) {
			//Bitmap image = BitmapFactory.decodeSampleBitmapFromResource(this.getResources(), Word.getImage(i));
			
			Bitmap image = decodeSampledBitmapFromResource(getResources(), Word.getImage(i), 250, 250);
			gridArray.add(new Item(image, Word.getPomo(i), Word.getEnglish(i)));

		}

		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
		final Context ctx = this;
	    gridView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	Intent intent = new Intent(ctx, ResultActivity.class);
	        	intent.putExtra("position", interval[0] + position);
	        	startActivity(intent);
	}
	    });
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
	          Intent intent = new Intent(this, MainActivity.class);  
	          startActivity(intent);            
	          break; 
	        case R.id.action_quiz:
	        	Intent intent11 = new Intent(this, QuizActivity.class);
	        	intent11.putExtra("category", category);
	            startActivity(intent11);
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
	
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
}
