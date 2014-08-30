/*    */ package maps;
/*    */ 
/*    */ public class ActionSpace
/*    */ {
/*    */   private String actionName;
/*    */   private int lowX;
/*    */   private int highX;
/*    */   private int lowY;
/*    */   private int highY;
/*    */   private boolean onTouch;
/*    */ 
/*    */   public ActionSpace(String actionName, int lowX, int lowY, int highX, int highY, boolean onTouch)
/*    */   {
/* 14 */     setActionName(actionName);
/* 15 */     this.lowX = lowX;
/* 16 */     this.lowY = lowY;
/* 17 */     this.highX = highX;
/* 18 */     this.highY = highY;
/* 19 */     this.onTouch = onTouch;
/*    */   }
/*    */ 
/*    */   public int getLowX() {
/* 23 */     return this.lowX;
/*    */   }
/*    */ 
/*    */   public void setLowX(int lowX) {
/* 27 */     this.lowX = lowX;
/*    */   }
/*    */ 
/*    */   public int getHighX() {
/* 31 */     return this.highX;
/*    */   }
/*    */ 
/*    */   public void setHighX(int highX) {
/* 35 */     this.highX = highX;
/*    */   }
/*    */ 
/*    */   public int getLowY() {
/* 39 */     return this.lowY;
/*    */   }
/*    */ 
/*    */   public void setLowY(int lowY) {
/* 43 */     this.lowY = lowY;
/*    */   }
/*    */ 
/*    */   public int getHighY() {
/* 47 */     return this.highY;
/*    */   }
/*    */ 
/*    */   public void setHighY(int highY) {
/* 51 */     this.highY = highY;
/*    */   }
/*    */ 
/*    */   public boolean isOnTouch() {
/* 55 */     return this.onTouch;
/*    */   }
/*    */ 
/*    */   public String getActionName() {
/* 59 */     return this.actionName;
/*    */   }
/*    */ 
/*    */   public void setActionName(String actionName) {
/* 63 */     this.actionName = actionName;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     maps.ActionSpace
 * JD-Core Version:    0.6.2
 */