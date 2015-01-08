package com.example.jano_shojin;


import android.graphics.Bitmap;

/**
 * @author manish.s
 * Edited by Edwin Ko
 */

public class Item {
 
 Bitmap image;
 String title;
 String string;

 public Item(Bitmap image, String title, String string) {
  super();
  this.image = image;
  this.title = title;
  this.string = string;
 }
 
 public Bitmap getImage() {
  return image;
 }
 
 public void setImage(Bitmap image) {
  this.image = image;
 }
 
 public String getTitle() {
  return title;
 }
 
 public void setTitle(String title) {
  this.title = title;
 }
 
 public String getString() {
  return string;
 }
 
 public void setString(String string)  {
  this.string = string;
 }

}