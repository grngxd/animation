/*     */ package ru.hogoshi;
/*     */ 
/*     */ import ru.hogoshi.bezier.Bezier;
/*     */ import ru.hogoshi.bezier.list.CubicBezier;
/*     */ import ru.hogoshi.util.Easing;
/*     */ import ru.hogoshi.util.Easings;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Animation
/*     */ {
/*     */   private long start;
/*     */   private double duration;
/*     */   private double fromValue;
/*     */   private double toValue;
/*     */   private double value;
/*  37 */   private Easing easing = Easings.NONE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   private Bezier bezier = (Bezier)new CubicBezier();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private AnimationType type = AnimationType.EASING;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean debug = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation animate(double valueTo, double duration) {
/*  61 */     return animate(valueTo, duration, Easings.NONE, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation animate(double valueTo, double duration, Easing easing) {
/*  72 */     return animate(valueTo, duration, easing, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation animate(double valueTo, double duration, Bezier bezier) {
/*  83 */     return animate(valueTo, duration, bezier, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation animate(double valueTo, double duration, boolean safe) {
/*  94 */     return animate(valueTo, duration, Easings.NONE, safe);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation animate(double valueTo, double duration, Easing easing, boolean safe) {
/* 106 */     if (check(safe, valueTo)) {
/* 107 */       if (isDebug()) System.out.println("Animate cancelled due to target val equals from val"); 
/* 108 */       return this;
/*     */     } 
/*     */     
/* 111 */     setType(AnimationType.EASING)
/* 112 */       .setEasing(easing)
/* 113 */       .setDuration(duration * 1000.0D)
/* 114 */       .setStart(System.currentTimeMillis())
/* 115 */       .setFromValue(getValue())
/* 116 */       .setToValue(valueTo);
/*     */     
/* 118 */     if (isDebug()) System.out.println("#animate {\n    to value: " + getToValue() + "\n    from value: " + getValue() + "\n    duration: " + getDuration() + "\n}");
/*     */     
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation animate(double valueTo, double duration, Bezier bezier, boolean safe) {
/* 132 */     if (check(safe, valueTo)) {
/* 133 */       if (isDebug()) System.out.println("Animate cancelled due to target val equals from val"); 
/* 134 */       return this;
/*     */     } 
/*     */     
/* 137 */     setType(AnimationType.BEZIER)
/* 138 */       .setBezier(bezier)
/* 139 */       .setDuration(duration * 1000.0D)
/* 140 */       .setStart(System.currentTimeMillis())
/* 141 */       .setFromValue(getValue())
/* 142 */       .setToValue(valueTo);
/*     */     
/* 144 */     if (isDebug()) System.out.println("#animate {\n    to value: " + getToValue() + "\n    from value: " + getValue() + "\n    duration: " + getDuration() + "\n    type: " + getType().name() + "\n}");
/*     */     
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update() {
/* 155 */     boolean alive = isAlive();
/*     */     
/* 157 */     if (alive) {
/* 158 */       if (getType().equals(AnimationType.BEZIER)) {
/* 159 */         setValue(interpolate(getFromValue(), getToValue(), getBezier().getValue(calculatePart())));
/*     */       } else {
/* 161 */         setValue(interpolate(getFromValue(), getToValue(), getEasing().ease(calculatePart())));
/*     */       } 
/*     */     } else {
/* 164 */       setStart(0L);
/* 165 */       setValue(getToValue());
/*     */     } 
/*     */     
/* 168 */     return alive;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAlive() {
/* 177 */     return !isDone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 186 */     return (calculatePart() >= 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double calculatePart() {
/* 195 */     return (System.currentTimeMillis() - getStart()) / getDuration();
/*     */   }
/*     */   
/*     */   public boolean check(boolean safe, double valueTo) {
/* 199 */     return (safe && isAlive() && (valueTo == getFromValue() || valueTo == getToValue() || valueTo == getValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double interpolate(double start, double end, double pct) {
/* 206 */     return start + (end - start) * pct;
/*     */   }
/*     */   
/*     */   public long getStart() {
/* 210 */     return this.start;
/*     */   }
/*     */   
/*     */   public double getDuration() {
/* 214 */     return this.duration;
/*     */   }
/*     */   
/*     */   public double getFromValue() {
/* 218 */     return this.fromValue;
/*     */   }
/*     */   
/*     */   public double getToValue() {
/* 222 */     return this.toValue;
/*     */   }
/*     */   
/*     */   public double getValue() {
/* 226 */     return this.value;
/*     */   }
/*     */   
/*     */   public boolean isDebug() {
/* 230 */     return this.debug;
/*     */   }
/*     */   
/*     */   public AnimationType getType() {
/* 234 */     return this.type;
/*     */   }
/*     */   
/*     */   public Easing getEasing() {
/* 238 */     return this.easing;
/*     */   }
/*     */   
/*     */   public Bezier getBezier() {
/* 242 */     return this.bezier;
/*     */   }
/*     */   
/*     */   public Animation setStart(long start) {
/* 246 */     this.start = start;
/*     */     
/* 248 */     return this;
/*     */   }
/*     */   
/*     */   public Animation setDuration(double duration) {
/* 252 */     this.duration = duration;
/*     */     
/* 254 */     return this;
/*     */   }
/*     */   
/*     */   public Animation setFromValue(double fromValue) {
/* 258 */     this.fromValue = fromValue;
/*     */     
/* 260 */     return this;
/*     */   }
/*     */   
/*     */   public Animation setToValue(double toValue) {
/* 264 */     this.toValue = toValue;
/*     */     
/* 266 */     return this;
/*     */   }
/*     */   
/*     */   public Animation setValue(double value) {
/* 270 */     this.value = value;
/*     */     
/* 272 */     return this;
/*     */   }
/*     */   
/*     */   public Animation setEasing(Easing easing) {
/* 276 */     this.easing = easing;
/*     */     
/* 278 */     return this;
/*     */   }
/*     */   
/*     */   public Animation setDebug(boolean debug) {
/* 282 */     this.debug = debug;
/*     */     
/* 284 */     return this;
/*     */   }
/*     */   
/*     */   public Animation setBezier(Bezier bezier) {
/* 288 */     this.bezier = bezier;
/*     */     
/* 290 */     return this;
/*     */   }
/*     */   
/*     */   public Animation setType(AnimationType type) {
/* 294 */     this.type = type;
/*     */     
/* 296 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aanil\Downloads\Animations-4.0.jar!\ru\hogoshi\Animation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */