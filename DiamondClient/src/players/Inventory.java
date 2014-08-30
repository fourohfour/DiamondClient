/*    */ package players;
/*    */ 
/*    */ import GUI.GamePanel;
/*    */ import GUI.bank.BankGUI;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Inventory
/*    */ {
/*  9 */   private ArrayList<Item> inventorySlots = new ArrayList();
/* 10 */   private static Inventory inventory = null;
/*    */ 
/*    */   public static Inventory getInstance()
/*    */   {
/* 20 */     if (inventory == null) {
/* 21 */       inventory = new Inventory();
/*    */     }
/* 23 */     return inventory;
/*    */   }
/*    */ 
/*    */   public void setInventoryItems(ArrayList<Item> items)
/*    */   {
/* 29 */     boolean refreshInventory = false;
/*    */ 
/* 31 */     if (this.inventorySlots.size() != items.size()) {
/* 32 */       refreshInventory = true;
/*    */     }
/*    */     else {
/* 35 */       for (int i = 0; i < this.inventorySlots.size(); i++)
/*    */       {
/* 37 */         if (((Item)this.inventorySlots.get(i)).getAmount() != ((Item)items.get(i)).getAmount()) {
/* 38 */           refreshInventory = true;
/*    */         }
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 44 */     this.inventorySlots = items;
/* 45 */     if (refreshInventory)
/*    */     {
/* 47 */       if (GamePanel.getInstance().getBankGUI() != null)
/* 48 */         GamePanel.getInstance().getBankGUI().refreshBank();
/*    */     }
/*    */   }
/*    */ 
/*    */   public ArrayList<Item> getInventoryItems()
/*    */   {
/* 54 */     return this.inventorySlots;
/*    */   }
/*    */ 
/*    */   public Item getInventoryItem(int itemId)
/*    */   {
/* 60 */     for (Item i : this.inventorySlots)
/*    */     {
/* 62 */       if (i.getId() == itemId) {
/* 63 */         return i;
/*    */       }
/*    */     }
/* 66 */     return null;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.Inventory
 * JD-Core Version:    0.6.2
 */