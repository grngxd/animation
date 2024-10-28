/*    */ package ru.hogoshi.bezier.list;
/*    */ 
/*    */ import ru.hogoshi.bezier.Bezier;
/*    */ import ru.hogoshi.bezier.Point;
/*    */ 
/*    */ public class CubicBezier
/*    */   extends Bezier
/*    */ {
/*    */   public double getValue(double t) {
/* 10 */     double dt = 1.0D - t;
/* 11 */     double dt2 = dt * dt;
/* 12 */     double t2 = t * t;
/*    */     
/* 14 */     Point temp = getPoint2().copy();
/*    */     
/* 16 */     return getStart().copy()
/* 17 */       .scale(dt2, dt)
/* 18 */       .add(temp.scale(3.0D * dt2 * t))
/* 19 */       .add(temp.set(getPoint3()).scale(3.0D * dt * t2))
/* 20 */       .add(temp.set(getEnd()).scale(t2 * t))
/* 21 */       .getY();
/*    */   }
/*    */   
/*    */   public static class Builder {
/* 25 */     private CubicBezier bezier = new CubicBezier();
/*    */     
/*    */     public Builder(CubicBezier bezier) {
/* 28 */       this.bezier = bezier;
/*    */     }
/*    */     
/*    */     public Builder() {}
/*    */     
/*    */     public Builder setPoint2(Point point) {
/* 34 */       this.bezier.setPoint2(point);
/*    */       
/* 36 */       return this;
/*    */     }
/*    */     
/*    */     public Builder setPoint3(Point point) {
/* 40 */       this.bezier.setPoint3(point);
/*    */       
/* 42 */       return this;
/*    */     }
/*    */     
/*    */     public CubicBezier build() {
/* 46 */       return this.bezier;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aanil\Downloads\Animations-4.0.jar!\ru\hogoshi\bezier\list\CubicBezier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */