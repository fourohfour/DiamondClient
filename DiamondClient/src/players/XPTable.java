/*    */ package players;
/*    */ 
/*    */ public class XPTable
/*    */ {
/*    */   public static int getLevel(int currentXP)
/*    */   {
/*  8 */     int[] levels = new int[99];
/*    */ 
/* 10 */     int xpGap = 30;
/* 11 */     int currentLevel = 1;
/* 12 */     for (int i = 0; i < levels.length; i++)
/*    */     {
/* 14 */       if (xpGap <= currentXP) {
/* 15 */         currentLevel = i + 1;
/*    */       }
/* 17 */       levels[i] = xpGap;
/* 18 */       xpGap = (int)(100.0D + Math.pow(i + 1, 3.5D));
/*    */     }
/*    */ 
/* 21 */     return currentLevel;
/*    */   }
/*    */ 
/*    */   public static int getXpRequiredToLevelUp(int level)
/*    */   {
/* 26 */     int[] levels = new int[99];
/*    */ 
/* 28 */     int xpGap = 30;
/* 29 */     int xpNeeeded = 0;
/*    */ 
/* 31 */     for (int i = 0; i < levels.length; i++)
/*    */     {
/* 33 */       levels[i] = xpGap;
/* 34 */       xpGap = (int)(100.0D + Math.pow(i + 1, 3.5D));
/*    */     }
/*    */ 
/* 37 */     for (int i = 0; i < levels.length; i++)
/*    */     {
/* 39 */       levels[i] = xpGap;
/* 40 */       xpGap = (int)(100.0D + Math.pow(i + 1, 3.5D));
/*    */ 
/* 42 */       if (level == i + 1)
/*    */       {
/* 44 */         xpNeeeded = levels[(i + 1)];
/* 45 */         break;
/*    */       }
/*    */     }
/*    */ 
/* 49 */     return xpNeeeded;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.XPTable
 * JD-Core Version:    0.6.2
 */