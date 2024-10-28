/*    */ package ru.hogoshi.bezier;
/*    */ 
/*    */ public abstract class Bezier
/*    */ {
/*  5 */   private final Point start = new Point(0.0D, 0.0D);
/*  6 */   private final Point end = new Point(1.0D, 1.0D);
/*    */   
/*    */   private Point point2;
/*    */   private Point point3;
/*    */   
/*    */   public Bezier(Point point2, Point point3) {
/* 12 */     setPoint2(point2);
/* 13 */     setPoint3(point3);
/*    */   }
/*    */   
/*    */   public Bezier() {}
/*    */   
/*    */   public abstract double getValue(double paramDouble);
/*    */   
/*    */   public Point getStart() {
/* 21 */     return this.start;
/*    */   }
/*    */   
/*    */   public Point getEnd() {
/* 25 */     return this.end;
/*    */   }
/*    */   
/*    */   public void setPoint2(Point point2) {
/* 29 */     this.point2 = point2;
/*    */   }
/*    */   
/*    */   public void setPoint3(Point point3) {
/* 33 */     this.point3 = point3;
/*    */   }
/*    */   
/*    */   public Point getPoint2() {
/* 37 */     return this.point2;
/*    */   }
/*    */   
/*    */   public Point getPoint3() {
/* 41 */     return this.point3;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aanil\Downloads\Animations-4.0.jar!\ru\hogoshi\bezier\Bezier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */