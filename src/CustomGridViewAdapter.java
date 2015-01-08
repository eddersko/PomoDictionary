package com.example.jano_shojin;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.northpomo.janoshojin.R;

/**
 * @author manish.s
 * Edited by Edwin Ko
 */

public class CustomGridViewAdapter extends ArrayAdapter<Item> {
 
 Context context;
 int layoutResourceId;
 ArrayList<Item> data = new ArrayList<Item>();

 public CustomGridViewAdapter(Context context, int layoutResourceId,
   ArrayList<Item> data) {
  super(context, layoutResourceId, data);
  this.layoutResourceId = layoutResourceId;
  this.context = context;
  this.data = data;
 }

 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
  
  View row = convertView;
  RecordHolder holder = null;
  Item item = data.get(position);
  
  if (row == null) {
   LayoutInflater inflater = ((Activity) context).getLayoutInflater();
   row = inflater.inflate(layoutResourceId, parent, false);
   holder = new RecordHolder();
   
   holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
   holder.txtString = (TextView) row.findViewById(R.id.item_text2);
   holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
   row.setTag(holder);
  } else {
   holder = (RecordHolder) row.getTag();
  }
  
  holder.txtTitle.setText(item.getTitle());
  
  if (!(item.getString().equals(""))) {
   holder.txtString.setText(item.getString());
  }
  
  holder.imageItem.setImageBitmap(item.getImage());
  return row;
 }
 
 static class RecordHolder {
  ImageView imageItem;
  TextView txtTitle;
  TextView txtString;
 }
}