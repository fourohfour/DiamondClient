/*    */ package Game;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Misc
/*    */ {
/*    */   public static int random(int num)
/*    */   {
/* 12 */     Random rand = new Random();
/*    */ 
/* 16 */     int randomNum = rand.nextInt(num - 0 + 1) + 0;
/*    */ 
/* 18 */     return randomNum;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     Game.Misc
 * JD-Core Version:    0.6.2
 */