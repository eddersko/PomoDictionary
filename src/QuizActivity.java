package com.example.jano_shojin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.northpomo.janoshojin.R;

public class QuizActivity extends Activity {
 
 private MediaPlayer player;
 int correct;
 int categoryNumber;
 GridView gridView;
 ArrayList<Item> gridArray = new ArrayList<Item>();
 CustomGridViewAdapter customGridAdapter;
   
 @Override
 public void onCreate(Bundle bundle) {
     super.onCreate(bundle);
     setContentView(R.layout.activity_main); // change to the quiz view
  categoryNumber = getIntent().getIntExtra("position", 0);
  String[] categories = Word.getCategories();
     getActionBar().setHomeButtonEnabled(true);
     String category = categories[categoryNumber];
     Random random = new Random();
  setTitle("Back to Home");

  int[] interval = Word.getCategoryInterval(category);
     int start = interval[0];
     int end = interval[1]; 
     correct = start + random.nextInt(end - start + 1);
        
     Set<Integer> set = new HashSet();
        set.add(correct);
        
        while (set.size() < 3) {
            set.add(start + random.nextInt(end-start + 1));
        }
        
        final int size = set.size();
        int n = 0;
        final int[] quiz = new int[size];
        
        for (Integer i: set) {
         quiz[n] = i;
         n++;
        }
  
        for (int i = 0; i < size; i++) { 
   //Bitmap image = decodeSampledBitmapFromResource(getResources(), Word.getImage(quiz[i]), 250, 250);
   BitmapFactory.Options options = new BitmapFactory.Options();
   Bitmap image = BitmapFactory.decodeResource(getResources(), Word.getImage(quiz[i]), options); 
   gridArray.add(new Item(image, Word.getEnglish(quiz[i]), ""));
  }

  gridView = (GridView) findViewById(R.id.gridView1);
  customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
  gridView.setAdapter(customGridAdapter);
  playSound(Word.getSound(correct));
  final Context ctx = this;
  
     gridView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
          if (player != null) {
           player.stop();
           player.release();
          }
       playSound(Word.getSound(correct));
       gridArray = new ArrayList<Item>();
       for (int i = 0; i < size; i++) {
        if (quiz[i] != correct) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            Bitmap image = BitmapFactory.decodeResource(getResources(), Word.getImage(quiz[i]), options); 
            image = adjustOpacity(image, 90);
        //Bitmap image = adjustOpacity(decodeSampledBitmapFromResource(getResources(), Word.getImage(quiz[i]), 250, 250), 90);
        gridArray.add(new Item(image, Word.getEnglish(quiz[i]), Word.getPomo(quiz[i])));
        }
        else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            Bitmap image = BitmapFactory.decodeResource(getResources(), Word.getImage(quiz[i]), options); 
         //Bitmap image = decodeSampledBitmapFromResource(getResources(), Word.getImage(quiz[i]), 250, 250);
         image = scaleCenterCrop(image, 250, 250);
         image = addWhiteBorder(image, 10);
         gridArray.add(new Item(image, Word.getEnglish(quiz[i]), Word.getPomo(quiz[i])));
        }
       }
       BitmapFactory.Options options = new BitmapFactory.Options();
       Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.try_again, options); 
       gridArray.add(new Item(image, "", ""));
       customGridAdapter = new CustomGridViewAdapter(ctx, R.layout.row_grid, gridArray);
       gridView.setAdapter(customGridAdapter);
       gridView.setOnItemClickListener(new OnItemClickListener() {
              public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
               if (player != null) {
                player.stop();
                player.release();
               }
               if (position == 3) {
                //Intent intent11 = new Intent(ctx, QuizActivity.class);
                //intent11.putExtra("position", categoryNumber); 
                //startActivity(intent11);
                Intent quizIntent = new Intent(ctx, QuizActivity.class);
                quizIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                quizIntent.putExtra("position", categoryNumber); 
                startActivity(quizIntent); 
            //playSound(Word.getSound(correct));
            
              } else {
               playSound(Word.getSound(quiz[position]));
              }
               
              }
          });
         }
     });
   }
   
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.quiz_activity_actions, menu);
       return super.onCreateOptionsMenu(menu);
   }
   
   @Override
   public void onBackPressed() {
       if (player != null) {
        player.stop();
        player.release();
       }
    	  super.onBackPressed();
   }
   
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       // Handle presses on the action bar items
       switch (item.getItemId()) {
       case android.R.id.home:            
          if (player != null) {
           player.stop();
           player.release();
          }
          Intent homeIntent = new Intent(this, MenuActivity.class);
          homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(homeIntent);           
          break;          
           case R.id.action_sound:
            if (player == null) {
            playSound(Word.getSound(correct));
            }
               break;
          case R.id.action_cancel:
           if (player != null) {
            player.stop();
            player.release();
           }
     	  super.onBackPressed();
     	  break;
           default:
               return super.onOptionsItemSelected(item);
       }
       return true;
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
   
   public static Bitmap grayScaleImage(Bitmap src) {
    // constant factors
    final double GS_RED = 0.299;
    final double GS_GREEN = 0.587;
    final double GS_BLUE = 0.114;
   
    // create output bitmap
    Bitmap bmOut = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
    // pixel information
    int A, R, G, B;
    int pixel;
   
    // get image size
    int width = src.getWidth();
    int height = src.getHeight();
   
    // scan through every single pixel
    for(int x = 0; x < width; ++x) {
     for(int y = 0; y < height; ++y) {
      // get one pixel color
      pixel = src.getPixel(x, y);
      // retrieve color of all channels
      A = Color.alpha(pixel);
      R = Color.red(pixel);
      G = Color.green(pixel);
      B = Color.blue(pixel);
      // take conversion up to one single value
      R = G = B = (int)(GS_RED * R + GS_GREEN * G + GS_BLUE * B);
      // set new pixel color to output bitmap
      bmOut.setPixel(x, y, Color.argb(A, R, G, B));
     }
    }
   
    // return final image
    return bmOut;
   }
   
   private Bitmap adjustOpacity(Bitmap bitmap, int opacity) {
    
       Bitmap mutableBitmap = bitmap.isMutable()
                              ? bitmap
                              : bitmap.copy(Bitmap.Config.ARGB_8888, true);
       Canvas canvas = new Canvas(mutableBitmap);
       int colour = (opacity & 0xFF) << 24;
       canvas.drawColor(colour, PorterDuff.Mode.DST_IN);
       return mutableBitmap;
   }
   
   private Bitmap addWhiteBorder(Bitmap bmp, int borderSize) {
      Bitmap bmpWithBorder = Bitmap.createBitmap(bmp.getWidth() + borderSize * 2, bmp.getHeight() + borderSize * 2, bmp.getConfig());
      Canvas canvas = new Canvas(bmpWithBorder);
      canvas.drawColor(Color.YELLOW);
      canvas.drawBitmap(bmp, borderSize, borderSize, null);
      return bmpWithBorder;
  }
   
   public Bitmap scaleCenterCrop(Bitmap source, int newHeight, int newWidth) {
      int sourceWidth = source.getWidth();
      int sourceHeight = source.getHeight();

      // Compute the scaling factors to fit the new height and width, respectively.
      // To cover the final image, the final scaling will be the bigger 
      // of these two.
      float xScale = (float) newWidth / sourceWidth;
      float yScale = (float) newHeight / sourceHeight;
      float scale = Math.max(xScale, yScale);

      // Now get the size of the source bitmap when scaled
      float scaledWidth = scale * sourceWidth;
      float scaledHeight = scale * sourceHeight;

      // Let's find out the upper left coordinates if the scaled bitmap
      // should be centered in the new size give by the parameters
      float left = (newWidth - scaledWidth) / 2;
      float top = (newHeight - scaledHeight) / 2;

      // The target rectangle for the new, scaled version of the source bitmap will now
      // be
      RectF targetRect = new RectF(left, top, left + scaledWidth, top + scaledHeight);

      // Finally, we create a new bitmap of the specified size and draw our new,
      // scaled bitmap onto it.
      Bitmap dest = Bitmap.createBitmap(newWidth, newHeight, source.getConfig());
      Canvas canvas = new Canvas(dest);
      canvas.drawBitmap(source, null, targetRect, null);

      return dest;
  }
}