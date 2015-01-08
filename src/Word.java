package com.example.jano_shojin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import android.util.Log;
import com.northpomo.janoshojin.R;

public class Word {
 
// returns length of items
 public static int  getCount() {
  Log.i("count", "" + mThumbIds.length);
  return mThumbIds.length;
 }

 // returns image
 public static Integer getImage(int position){
     return mThumbIds[position];
  }
 
// location of all images in R.drawable
private static Integer[] mThumbIds = {};
 
// returns sound of item
public static Integer getSound(int position) {
 return sounds[position];
}

// category of all items
private static String[] categories = {};

// returns category of item
public static String getCategory(int position) {
 return categories[position];
}

// returns all categories, and items within each category
public static String[] getCategories() {
 
 Set<String> set = new HashSet<String>(Arrays.asList(categories));
 String[] categories = new String[set.size() + 1];
 int n = 0;
 
 for (String s: set) {
  categories[n] = s;
  n++;
 }
 
 categories[n] = "all";
 return categories;
}

// returns items in category
public static int[] getCategoryInterval(String str) {
 
 int[] interval = new int[2];
 
 if (str.equals("all")) {
  interval[1] = getCount()-1;
  return interval;
 }
 
 boolean start = false;
 
 for (int i = 0; i < categories.length; i++) {
  if (!start && str.equals(categories[i])) {
   interval[0] = i;
   start = true;
  } else if (start && !(str.equals(categories[i]))) {
   interval[1] = i - 1;
   return interval;
  }  
 }
 
 interval[1] = categories.length - 1;
 return interval;
}

// returns category and image
public static Map<String, Integer> getCategoryMap() {
 Map<String, Integer> map = new HashMap<String, Integer>();
 
 return map;
}

// returns category and image (quiz)
public static Map<String, Integer> getQuizCategoryMap() {
 Map<String, Integer> map = new HashMap<String, Integer>();

 return map;
}

// location of all sounds in R.raw
private static Integer[] sounds = {};
 
// returns English of item
public static String getEnglish(int position) {
 return english[position];
}
 
// returns N. Pomo orthograph of item
public static String getPomo(int position) {
 return pomo[position];
}

// all N. Pomo orthographs  of items
private static String[] pomo = {};

// all English of items
private static String[] english = {};

// all descriptions (source) of items
private static String[] description = {};

// returns description of item
public static String getDescription(int position) {
 return description[position];
}

}