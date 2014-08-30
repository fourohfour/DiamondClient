/*     */ package GUI;
/*     */ 
/*     */ import connections.Command;

/*     */ import java.awt.Color;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;

/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;

/*     */ import players.Item;
/*     */ import players.ItemList;
/*     */ import players.Shop;
/*     */ import players.ShopList;
/*     */ 
/*     */ public class ShopGui extends JPanel
/*     */ {
/*     */   private int shopId;
/*  32 */   private ArrayList<Item> itemsForSell = new ArrayList();
/*  33 */   private int sizeX = 785;
/*  34 */   private int sizeY = 400;
/*     */   private Shop shop;
/*     */   private JPanel loadInputBox;
/*  38 */   private InventoryGUI inventory = null;
/*     */ 
/*     */   public ShopGui()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ShopGui getShopGui() {
/*  45 */     if (isVisible()) {
/*  46 */       return this;
/*     */     }
/*  48 */     return null;
/*     */   }
/*     */ 
/*     */   public ShopGui(Shop shop)
/*     */   {
/*  53 */     this.shopId = shop.getShopId();
/*  54 */     this.itemsForSell = shop.getShopItems();
/*  55 */     this.shop = shop;
/*  56 */     players.Config.shopIsOpen = true;
/*  57 */     this.shop.setShopGui(this);
/*  58 */     init();
/*     */   }
/*     */ 
/*     */   public void setShopItems(ArrayList<Item> items)
/*     */   {
/*  63 */     this.itemsForSell = items;
/*     */   }
/*     */ 
/*     */   public void refreshPanel()
/*     */   {
/*  68 */     setShopItems(ShopList.getInstance().getShop(this.shopId).getShopItems());
/*     */ 
/*  70 */     init();
/*  71 */     this.inventory.refreshItems();
/*  72 */     this.inventory.refreshShopItems(this);
/*  73 */     this.inventory.repaint();
/*  74 */     this.inventory.validate();
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/*  82 */     removeAll();
/*  83 */     setLayout(null);
/*  84 */     setBounds(5, 40, this.sizeX, this.sizeY);
/*  85 */     setBackground(Color.WHITE);
/*  86 */     setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/*     */ 
/*  88 */     JPanel shopAreaPanel = new JPanel(new FlowLayout());
/*  89 */     shopAreaPanel.setBackground(Color.GRAY);
/*  90 */     shopAreaPanel.setBounds(288, 40, 485, this.sizeY - 50);
/*  91 */     add(shopAreaPanel);
/*     */ 
/*  93 */     this.inventory = new InventoryGUI(true);
/*  94 */     this.inventory.init();
/*  95 */     this.inventory.setLocation(10, 40);
/*  96 */     this.inventory.refreshShopItems(this);
/*  97 */     add(this.inventory);
/*     */ 
/*  99 */     JButton close = new JButton("x");
/* 100 */     close.setBackground(Color.black);
/* 101 */     close.setForeground(Color.white);
/* 102 */     close.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent arg0)
/*     */       {
/* 106 */         players.Config.shopIsOpen = false;
/* 107 */         ShopGui.this.shop.setShopGui(null);
/* 108 */         ShopGui.this.setVisible(false);
/* 109 */         ShopGui.this.removeAll();
/*     */       }
/*     */     });
/* 112 */     close.setBounds(745, 5, 30, 30);
/* 113 */     add(close);
/*     */ 
/* 115 */     for (final Item i : this.itemsForSell)
/*     */     {
/* 117 */       JPanel itemPanel = new JPanel(new FlowLayout());
/* 118 */       itemPanel.setSize(80, 50);
/* 119 */       itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/*     */ 
/* 121 */       itemPanel.addMouseListener(new MouseAdapter()
/*     */       {
/*     */         public void mousePressed(MouseEvent e)
/*     */         {
/* 125 */           ShopGui.this.loadInputBox(i.getId(), true);
/*     */         }
/*     */       });
/* 130 */       JLabel itemAmount = new JLabel(String.valueOf(i.getAmount()));
/* 131 */       JLabel itemPicture = new JLabel();
/* 132 */       itemPicture.setIcon(new ImageIcon(i.getIMGUrl()));
/*     */ 
/* 134 */       itemPanel.add(itemAmount);
/* 135 */       itemPanel.add(itemPicture);
/*     */ 
/* 137 */       itemPanel.revalidate();
/* 138 */       itemPanel.repaint();
/*     */ 
/* 140 */       shopAreaPanel.add(itemPanel);
/*     */     }
/*     */ 
/* 143 */     shopAreaPanel.revalidate();
/* 144 */     shopAreaPanel.repaint();
/*     */   }
/*     */ 
/*     */   public int getSizeX()
/*     */   {
/* 149 */     return this.sizeX;
/*     */   }
/*     */ 
/*     */   public void setSizeX(int sizeX) {
/* 153 */     this.sizeX = sizeX;
/*     */   }
/*     */ 
/*     */   public int getSizeY() {
/* 157 */     return this.sizeY;
/*     */   }
/*     */ 
/*     */   public void setSizeY(int sizeY) {
/* 161 */     this.sizeY = sizeY;
/*     */   }
/*     */ 
/*     */   public void loadInputBox(final int itemId, final boolean buying)
/*     */   {
/* 167 */     if (this.loadInputBox != null)
/* 168 */       this.loadInputBox.removeAll();
/*     */     else {
/* 170 */       this.loadInputBox = new JPanel(new FlowLayout());
/*     */     }
/* 172 */     this.loadInputBox.setVisible(true);
/* 173 */     this.loadInputBox.setBackground(Color.cyan);
/* 174 */     this.loadInputBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/* 175 */     this.loadInputBox.setBounds(10, 295, 245, 100);
/*     */ 
/* 177 */     String msg = "";
/*     */ 
/* 179 */     if (buying)
/* 180 */       msg = "<html>How many " + ItemList.getInstance().getItem(itemId).getName() + "'s<br> do you want to buy? <b>(-" + ItemList.getInstance().getItem(itemId).getHighValue() + " Coins)</b></html>";
/*     */     else {
/* 182 */       msg = "<html>How many " + ItemList.getInstance().getItem(itemId).getName() + "'s<br> do you want to sell? <b>(+" + (int)(ItemList.getInstance().getItem(itemId).getHighValue() * 0.6D) + " Coins)</b></html>";
/*     */     }
/* 184 */     JLabel message = new JLabel(msg);
/*     */ 
/* 187 */     final JTextField txtAmount = new JTextField();
/* 188 */     txtAmount.setText("1");
/* 189 */     txtAmount.setColumns(10);
/*     */ 
/* 191 */     String buttonText = "";
/*     */ 
/* 193 */     if (buying)
/* 194 */       buttonText = "Buy";
/*     */     else {
/* 196 */       buttonText = "Sell";
/*     */     }
/* 198 */     JButton btn = new JButton(buttonText);
/* 199 */     btn.setBackground(Color.BLACK);
/* 200 */     btn.setForeground(Color.WHITE);
/*     */ 
/* 202 */     btn.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 206 */         int amount = 0;
/*     */         try
/*     */         {
/* 209 */           amount = Integer.parseInt(txtAmount.getText()); } catch (Exception e1) {
/* 210 */           e1.printStackTrace();
/*     */         }
/* 212 */         if (amount > 0)
/*     */         {
/* 214 */           if (buying)
/*     */           {
/* 216 */             Command.getInstance().sendCommand("BUY", "SHOPID=" + ShopGui.this.shopId + ";ITEMID=" + itemId + ";AMOUNT=" + amount);
/*     */           }
/*     */           else
/*     */           {
/* 220 */             Command.getInstance().sendCommand("SELL", "SHOPID=" + ShopGui.this.shopId + ";ITEMID=" + itemId + ";AMOUNT=" + amount);
/*     */           }
/*     */         }
/*     */ 
/* 224 */         ShopGui.this.loadInputBox.setVisible(false);
/*     */       }
/*     */     });
/* 230 */     this.loadInputBox.add(message);
/* 231 */     this.loadInputBox.add(txtAmount);
/* 232 */     this.loadInputBox.add(btn);
/*     */ 
/* 234 */     this.loadInputBox.revalidate();
/* 235 */     this.loadInputBox.repaint();
/*     */ 
/* 237 */     add(this.loadInputBox);
/*     */ 
/* 239 */     revalidate();
/* 240 */     repaint();
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.ShopGui
 * JD-Core Version:    0.6.2
 */