/*    */ package players;
/*    */ 
/*    */ import GUI.ShopGui;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Shop
/*    */ {
/*    */   private int shopId;
/* 10 */   private boolean isOpen = false;
/*    */   private ShopGui shopGui;
/* 14 */   private ArrayList<Item> shopItems = new ArrayList();
/*    */ 
/*    */   public Shop()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Shop(int shopId, ArrayList<Item> shopItems)
/*    */   {
/* 23 */     this.shopId = shopId;
/* 24 */     this.shopItems = shopItems;
/*    */   }
/*    */ 
/*    */   public int getShopId() {
/* 28 */     return this.shopId;
/*    */   }
/*    */   public void setShopId(int shopId) {
/* 31 */     this.shopId = shopId;
/*    */   }
/*    */   public ArrayList<Item> getShopItems() {
/* 34 */     return this.shopItems;
/*    */   }
/*    */   public void setShopItems(ArrayList<Item> shopItems) {
/* 37 */     this.shopItems = shopItems;
/*    */   }
/*    */ 
/*    */   public void addItem(int id, int amm)
/*    */   {
/* 42 */     Item i = ItemList.getInstance().getItem(id);
/* 43 */     i.setAmount(amm);
/* 44 */     this.shopItems.add(i);
/*    */   }
/*    */ 
/*    */   public boolean isOpen() {
/* 48 */     return this.isOpen;
/*    */   }
/*    */ 
/*    */   public void setOpen(boolean isOpen) {
/* 52 */     this.isOpen = isOpen;
/*    */   }
/*    */ 
/*    */   public ShopGui getShopGui() {
/* 56 */     return this.shopGui;
/*    */   }
/*    */ 
/*    */   public void setShopGui(ShopGui shopGui) {
/* 60 */     this.shopGui = shopGui;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.Shop
 * JD-Core Version:    0.6.2
 */