/*    */ package ru.hogoshi.bezier;
/*    */ 
/*    */ public class Point
/*    */ {
/*    */   private double x;
/*    */   private double y;
/*    */   
/*    */   public Point(double x, double y) {
/*  9 */     setX(x);
/* 10 */     setY(y);
/*    */   }
/*    */   
/*    */   public Point(Point point) {
/* 14 */     setX(point.getX());
/* 15 */     setY(point.getY());
/*    */   }
/*    */   
/*    */   public Point copy() {
/* 19 */     return new Point(this);
/*    */   }
/*    */   
/*    */   public Point move(double x, double y) {
/* 23 */     setX(x);
/* 24 */     setY(y);
/*    */     
/* 26 */     return this;
/*    */   }
/*    */   
/*    */   public Point scale(double x, double y) {
/* 30 */     setX(getX() * x);
/* 31 */     setY(getY() * y);
/*    */     
/* 33 */     return this;
/*    */   }
/*    */   
/*    */   public Point scale(double scale) {
/* 37 */     setX(getX() * scale);
/* 38 */     setY(getY() * scale);
/*    */     
/* 40 */     return this;
/*    */   }
/*    */   
/*    */   public Point add(double x, double y) {
/* 44 */     setX(getX() + x);
/* 45 */     setY(getY() + y);
/*    */     
/* 47 */     return this;
/*    */   }
/*    */   
/*    */   public Point set(Point point) {
/* 51 */     setX(point.getX());
/* 52 */     setY(point.getY());
/*    */     
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   public Point add(Point point) {
/* 58 */     setX(getX() + point.getX());
/* 59 */     setY(getY() + point.getY());
/*    */     
/* 61 */     return this;
/*    */   }
/*    */   
/*    */   public double getX() {
/* 65 */     return this.x;
/*    */   }
/*    */   
/*    */   public double getY() {
/* 69 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setX(double x) {
/* 73 */     this.x = x;
/*    */   }
/*    */   
/*    */   public void setY(double y) {
/* 77 */     this.y = y;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aanil\Downloads\Animations-4.0.jar!\ru\hogoshi\bezier\Point.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */