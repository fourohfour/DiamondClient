/*    */ package npc;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import players.Player;
/*    */ 
/*    */ public class GroundItemList
/*    */ {
/* 10 */   private static GroundItemList groundItemList = null;
/* 11 */   private ArrayList<GroundItem> groundItems = new ArrayList();
/*    */ 
/*    */   public static GroundItemList getInstance()
/*    */   {
/* 20 */     if (groundItemList == null) {
/* 21 */       groundItemList = new GroundItemList();
/*    */     }
/* 23 */     return groundItemList;
/*    */   }
/*    */ 
/*    */   public ArrayList<GroundItem> getGroundItems()
/*    */   {
/* 28 */     return this.groundItems;
/*    */   }
/*    */ 
/*    */   public void addGroundItem(int itemId, int itemAmount, int mapid, int x, int y, Player p)
/*    */   {
/* 33 */     GroundItem groundItem = new GroundItem(itemId, itemAmount, mapid, x, y, p);
/* 34 */     this.groundItems.add(groundItem);
/*    */   }
/*    */ 
/*    */   public void setGroundItems(ArrayList<GroundItem> groundItems)
/*    */   {
/* 39 */     this.groundItems = groundItems;
/*    */   }
/*    */ 
/*    */   public String getGroundItemValues()
/*    */   {
/* 44 */     String output = "";
/*    */     GroundItem localGroundItem;
/* 46 */     for (Iterator localIterator = this.groundItems.iterator(); localIterator.hasNext(); localGroundItem = (GroundItem)localIterator.next());
/* 50 */     return output;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     npc.GroundItemList
 * JD-Core Version:    0.6.2
 */