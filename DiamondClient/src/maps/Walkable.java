/*    */ package maps;
/*    */ 
/*    */ public class Walkable
/*    */ {
/*    */   private int lowX;
/*    */   private int highX;
/*    */   private int lowY;
/*    */   private int highY;
/*    */ 
/*    */   public Walkable(int lowX, int lowY, int highX, int highY)
/*    */   {
/* 12 */     this.lowX = lowX;
/* 13 */     this.lowY = lowY;
/* 14 */     this.highX = highX;
/* 15 */     this.highY = highY;
/*    */   }
/*    */ 
/*    */   public int getLowX() {
/* 19 */     return this.lowX;
/*    */   }
/*    */ 
/*    */   public void setLowX(int lowX) {
/* 23 */     this.lowX = lowX;
/*    */   }
/*    */ 
/*    */   public int getHighX() {
/* 27 */     return this.highX;
/*    */   }
/*    */ 
/*    */   public void setHighX(int highX) {
/* 31 */     this.highX = highX;
/*    */   }
/*    */ 
/*    */   public int getLowY() {
/* 35 */     return this.lowY;
/*    */   }
/*    */ 
/*    */   public void setLowY(int lowY) {
/* 39 */     this.lowY = lowY;
/*    */   }
/*    */ 
/*    */   public int getHighY() {
/* 43 */     return this.highY;
/*    */   }
/*    */ 
/*    */   public void setHighY(int highY) {
/* 47 */     this.highY = highY;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     maps.Walkable
 * JD-Core Version:    0.6.2
 */