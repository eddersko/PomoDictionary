package com.example.pomodictionary;

import java.util.ArrayList;
import java.util.Map;

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

public class MainActivity extends Activity {
	
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		setTitle("Northern Pomo Dictionary");
		
		String[] categories = Word.getCategories();
		Map<String, Integer> map = Word.getCategoryMap();
		
		for (int i = 0; i < categories.length; i++) {
			Bitmap image = decodeSampledBitmapFromResource(getResources(), map.get(categories[i]), 250, 250);
			gridArray.add(new Item(image, categories[i], ""));
		}

		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
		final Context ctx = this;
		
	    gridView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	Intent intent = new Intent(ctx, GridActivity.class); 
	        	intent.putExtra("position", position); 
	        	startActivity(intent);
	        }
	    });
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
	        case R.id.action_about:
	            Intent intent = new Intent(this, AboutActivity.class);
	            startActivity(intent);
	            break;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	    return true;
	}
	
	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {

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
