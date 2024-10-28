/*     */ package ru.hogoshi.util;
/*     */ 
/*     */ public final class Easings
/*     */ {
/*     */   public static final double c1 = 1.70158D;
/*     */   public static final double c2 = 2.5949095D;
/*     */   public static final double c3 = 2.70158D;
/*     */   public static final double c4 = 2.0943951023931953D;
/*     */   public static final double c5 = 1.3962634015954636D;
/*     */   public static final Easing NONE;
/*     */   
/*     */   static {
/*  13 */     NONE = (value -> value);
/*  14 */   } public static final Easing QUAD_IN = powIn(2);
/*  15 */   public static final Easing QUAD_OUT = powOut(2);
/*  16 */   public static final Easing QUAD_BOTH = powBoth(2.0D);
/*     */   
/*  18 */   public static final Easing CUBIC_IN = powIn(3);
/*  19 */   public static final Easing CUBIC_OUT = powOut(3);
/*  20 */   public static final Easing CUBIC_BOTH = powBoth(3.0D);
/*     */   
/*  22 */   public static final Easing QUART_IN = powIn(4);
/*  23 */   public static final Easing QUART_OUT = powOut(4);
/*  24 */   public static final Easing QUART_BOTH = powBoth(4.0D);
/*     */   
/*  26 */   public static final Easing QUINT_IN = powIn(5);
/*  27 */   public static final Easing QUINT_OUT = powOut(5); public static final Easing SINE_IN; public static final Easing SINE_OUT; public static final Easing SINE_BOTH; public static final Easing CIRC_IN; public static final Easing CIRC_OUT;
/*  28 */   public static final Easing QUINT_BOTH = powBoth(5.0D); public static final Easing CIRC_BOTH; public static final Easing ELASTIC_IN; public static final Easing ELASTIC_OUT; public static final Easing ELASTIC_BOTH;
/*     */   static {
/*  30 */     SINE_IN = (value -> 1.0D - Math.cos(value * Math.PI / 2.0D));
/*  31 */     SINE_OUT = (value -> Math.sin(value * Math.PI / 2.0D));
/*  32 */     SINE_BOTH = (value -> -(Math.cos(Math.PI * value) - 1.0D) / 2.0D);
/*     */     
/*  34 */     CIRC_IN = (value -> 1.0D - Math.sqrt(1.0D - Math.pow(value, 2.0D)));
/*  35 */     CIRC_OUT = (value -> Math.sqrt(1.0D - Math.pow(value - 1.0D, 2.0D)));
/*  36 */     CIRC_BOTH = (value -> (value < 0.5D) ? ((1.0D - Math.sqrt(1.0D - Math.pow(2.0D * value, 2.0D))) / 2.0D) : ((Math.sqrt(1.0D - Math.pow(-2.0D * value + 2.0D, 2.0D)) + 1.0D) / 2.0D));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  44 */     ELASTIC_IN = (value -> 
/*  45 */       (value == 0.0D || value == 1.0D) ? value : (Math.pow(-2.0D, 10.0D * value - 10.0D) * Math.sin((value * 10.0D - 10.75D) * 2.0943951023931953D)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     ELASTIC_OUT = (value -> 
/*  52 */       (value == 0.0D || value == 1.0D) ? value : (Math.pow(2.0D, -10.0D * value) * Math.sin((value * 10.0D - 0.75D) * 2.0943951023931953D) + 1.0D));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     ELASTIC_BOTH = (value -> 
/*  59 */       (value == 0.0D || value == 1.0D) ? value : ((value < 0.5D) ? (-(Math.pow(2.0D, 20.0D * value - 10.0D) * Math.sin((20.0D * value - 11.125D) * 1.3962634015954636D)) / 2.0D) : (Math.pow(2.0D, -20.0D * value + 10.0D) * Math.sin((20.0D * value - 11.125D) * 1.3962634015954636D) / 2.0D + 1.0D)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     EXPO_IN = (value -> (value != 0.0D) ? Math.pow(2.0D, 10.0D * value - 10.0D) : value);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     EXPO_OUT = (value -> (value != 1.0D) ? (1.0D - Math.pow(2.0D, -10.0D * value)) : value);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     EXPO_BOTH = (value -> 
/*  82 */       (value == 0.0D || value == 1.0D) ? value : ((value < 0.5D) ? (Math.pow(2.0D, 20.0D * value - 10.0D) / 2.0D) : ((2.0D - Math.pow(2.0D, -20.0D * value + 10.0D)) / 2.0D)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     BACK_IN = (value -> 2.70158D * Math.pow(value, 3.0D) - 1.70158D * Math.pow(value, 2.0D));
/*  91 */     BACK_OUT = (value -> 1.0D + 2.70158D * Math.pow(value - 1.0D, 3.0D) + 1.70158D * Math.pow(value - 1.0D, 2.0D));
/*  92 */     BACK_BOTH = (value -> (value < 0.5D) ? (Math.pow(2.0D * value, 2.0D) * (7.189819D * value - 2.5949095D) / 2.0D) : ((Math.pow(2.0D * value - 2.0D, 2.0D) * (3.5949095D * (value * 2.0D - 2.0D) + 2.5949095D) + 2.0D) / 2.0D));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     BOUNCE_OUT = (x -> {
/*     */         double n1 = 7.5625D;
/*     */ 
/*     */ 
/*     */         
/*     */         double d1 = 2.75D;
/*     */ 
/*     */ 
/*     */         
/*     */         return (x < 1.0D / d1) ? (n1 * Math.pow(x, 2.0D)) : ((x < 2.0D / d1) ? (n1 * Math.pow(x - 1.5D / d1, 2.0D) + 0.75D) : ((x < 2.5D / d1) ? (n1 * Math.pow(x - 2.25D / d1, 2.0D) + 0.9375D) : (n1 * Math.pow(x - 2.625D / d1, 2.0D) + 0.984375D)));
/*     */       });
/*     */ 
/*     */     
/* 112 */     BOUNCE_IN = (value -> 1.0D - BOUNCE_OUT.ease(1.0D - value));
/* 113 */     BOUNCE_BOTH = (value -> (value < 0.5D) ? ((1.0D - BOUNCE_OUT.ease(1.0D - 2.0D * value)) / 2.0D) : ((1.0D + BOUNCE_OUT.ease(2.0D * value - 1.0D)) / 2.0D));
/*     */   }
/*     */   public static final Easing EXPO_IN; public static final Easing EXPO_OUT;
/*     */   public static final Easing EXPO_BOTH;
/*     */   public static final Easing BACK_IN;
/*     */   public static final Easing BACK_OUT;
/*     */   public static final Easing BACK_BOTH;
/*     */   public static final Easing BOUNCE_OUT;
/*     */   public static final Easing BOUNCE_IN;
/*     */   public static final Easing BOUNCE_BOTH;
/*     */   
/*     */   public static Easing powIn(double n) {
/* 125 */     return value -> Math.pow(value, n);
/*     */   }
/*     */   
/*     */   public static Easing powIn(int n) {
/* 129 */     return powIn(n);
/*     */   }
/*     */   
/*     */   public static Easing powOut(double n) {
/* 133 */     return value -> 1.0D - Math.pow(1.0D - value, n);
/*     */   }
/*     */   
/*     */   public static Easing powOut(int n) {
/* 137 */     return powOut(n);
/*     */   }
/*     */   
/*     */   public static Easing powBoth(double n) {
/* 141 */     return value -> (value < 0.5D) ? (Math.pow(2.0D, n - 1.0D) * Math.pow(value, n)) : (1.0D - Math.pow(-2.0D * value + 2.0D, n) / 2.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aanil\Downloads\Animations-4.0.jar!\ru\hogosh\\util\Easings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */