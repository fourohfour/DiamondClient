/*    */ package players;
/*    */ 
/*    */ import GUI.ShopGui;
/*    */ import java.io.PrintStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.CopyOnWriteArrayList;
/*    */ 
/*    */ public class ShopList
/*    */   implements Serializable
/*    */ {
/* 14 */   private static ShopList shopList = null;
/*    */ 
/* 16 */   public List<Shop> shops = new CopyOnWriteArrayList();
/*    */ 
/*    */   public static ShopList getInstance()
/*    */   {
/* 25 */     if (shopList == null) {
/* 26 */       shopList = new ShopList();
/*    */     }
/* 28 */     return shopList;
/*    */   }
/*    */ 
/*    */   public void setShops(ArrayList<Shop> shops)
/*    */   {
/* 33 */     this.shops = shops;
/*    */   }
/*    */ 
/*    */   public ShopGui getOpenShopGui()
/*    */   {
/* 38 */     for (Shop s : this.shops)
/*    */     {
/* 40 */       if ((s.isOpen()) && (s.getShopGui() != null)) {
/* 41 */         return s.getShopGui();
/*    */       }
/*    */     }
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */   public Shop getShop(int id)
/*    */   {
/* 49 */     for (Shop s : this.shops)
/*    */     {
/* 51 */       if (s.getShopId() == id) {
/* 52 */         return s;
/*    */       }
/*    */     }
/* 55 */     return null;
/*    */   }
/*    */ 
/*    */   public void addShop(Shop shop)
/*    */   {
/* 60 */     this.shops.add(shop);
/*    */   }
/*    */ 
/*    */   public boolean shopIsOpen()
/*    */   {
/* 65 */     for (Shop s : this.shops)
/*    */     {
/* 67 */       System.out.println(s.isOpen());
/* 68 */       if (s.isOpen())
/* 69 */         return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */ 
/*    */   public List<Shop> getShops()
/*    */   {
/* 76 */     return this.shops;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.ShopList
 * JD-Core Version:    0.6.2
 */