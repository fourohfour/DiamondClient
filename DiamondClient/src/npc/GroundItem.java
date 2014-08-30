/*    */ package npc;
/*    */ 
/*    */ import players.Player;
/*    */ 
/*    */ public class GroundItem
/*    */ {
/* 10 */   private Player p = null;
/*    */   private int itemId;
/*    */   private int itemAmount;
/*    */   private int mapId;
/*    */   private int x;
/*    */   private int y;
/*    */ 
/*    */   public GroundItem(int itemId, int itemAmount, int mapid, int x, int y, Player p)
/*    */   {
/* 21 */     setItemId(itemId);
/* 22 */     setItemAmount(itemAmount);
/* 23 */     this.p = p;
/* 24 */     setMapId(mapid);
/* 25 */     setX(x);
/* 26 */     setY(y);
/*    */   }
/*    */ 
/*    */   public int getMapId() {
/* 30 */     return this.mapId;
/*    */   }
/*    */ 
/*    */   public void setMapId(int mapId) {
/* 34 */     this.mapId = mapId;
/*    */   }
/*    */ 
/*    */   public int getX() {
/* 38 */     return this.x;
/*    */   }
/*    */ 
/*    */   public void setX(int x) {
/* 42 */     this.x = x;
/*    */   }
/*    */ 
/*    */   public int getY() {
/* 46 */     return this.y;
/*    */   }
/*    */ 
/*    */   public void setY(int y) {
/* 50 */     this.y = y;
/*    */   }
/*    */ 
/*    */   public int getItemAmount() {
/* 54 */     return this.itemAmount;
/*    */   }
/*    */ 
/*    */   public void setItemAmount(int itemAmount) {
/* 58 */     this.itemAmount = itemAmount;
/*    */   }
/*    */ 
/*    */   public int getItemId() {
/* 62 */     return this.itemId;
/*    */   }
/*    */ 
/*    */   public void setItemId(int itemId) {
/* 66 */     this.itemId = itemId;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     npc.GroundItem
 * JD-Core Version:    0.6.2
 */