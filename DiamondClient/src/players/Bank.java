/*    */ package players;
/*    */ 
/*    */ import GUI.GamePanel;
/*    */ import GUI.InventoryGUI;
/*    */ import GUI.bank.BankGUI;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Bank
/*    */ {
/*  9 */   private ArrayList<Item> bankItems = new ArrayList();
/* 10 */   private static Bank bank = null;
/*    */ 
/*    */   public static Bank getInstance()
/*    */   {
/* 19 */     if (bank == null) {
/* 20 */       bank = new Bank();
/*    */     }
/* 22 */     return bank;
/*    */   }
/*    */ 
/*    */   public ArrayList<Item> getItems()
/*    */   {
/* 27 */     return this.bankItems;
/*    */   }
/*    */ 
/*    */   public void setBankItems(ArrayList<Item> items)
/*    */   {
/* 32 */     boolean refreshBank = false;
/*    */ 
/* 34 */     if (this.bankItems.size() != items.size()) {
/* 35 */       refreshBank = true;
/*    */     }
/*    */     else {
/* 38 */       for (int i = 0; i < this.bankItems.size(); i++)
/*    */       {
/* 40 */         if (((Item)this.bankItems.get(i)).getAmount() != ((Item)items.get(i)).getAmount()) {
/* 41 */           refreshBank = true;
/*    */         }
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 47 */     this.bankItems = items;
/*    */ 
/* 49 */     if (refreshBank)
/*    */     {
/* 51 */       GamePanel.getInstance().getBankGUI().refreshBank();
/* 52 */       GamePanel.getInstance().getInventory().refreshItemsToBank();
/*    */     }
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.Bank
 * JD-Core Version:    0.6.2
 */