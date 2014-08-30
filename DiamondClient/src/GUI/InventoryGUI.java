/*     */ package GUI;
/*     */ 
/*     */ import GUI.bank.BankGUI;
/*     */ import connections.Command;

/*     */ import java.awt.Color;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Font;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;

/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JLayeredPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.ToolTipManager;

/*     */ import players.Config;
/*     */ import players.Inventory;
/*     */ import players.Item;
/*     */ import players.Player;
/*     */ import players.PlayerEquipement;
/*     */ import players.PlayerList;
/*     */ 
/*     */ public class InventoryGUI extends JLayeredPane
/*     */ {
/*  25 */   private boolean inventoryIsOpen = false;
/*     */   JPanel inventorySlotsPanel;
/*     */ 
/*     */   public InventoryGUI()
/*     */   {
/*     */   }
/*     */ 
/*     */   public InventoryGUI(boolean visisble)
/*     */   {
/*  35 */     this.inventoryIsOpen = true;
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/*  41 */     setLayout(null);
/*  42 */     setBounds(2, 40, 250, 250);
/*     */ 
/*  44 */     this.inventorySlotsPanel = new JPanel();
/*  45 */     this.inventorySlotsPanel.setLayout(null);
/*  46 */     this.inventorySlotsPanel.setBounds(0, 0, 250, 250);
/*  47 */     setLayer(this.inventorySlotsPanel, 2);
/*  48 */     this.inventorySlotsPanel.setOpaque(false);
/*     */ 
/*  50 */     initInventory();
/*     */   }
/*     */ 
/*     */   public void initInventory()
/*     */   {
/*  55 */     String backgroundURL = "cache/graphics/backgrounds/inventorybackground.png";
/*     */ 
/*  57 */     JLabel backgroundLabel = new JLabel();
/*  58 */     backgroundLabel.setIcon(new ImageIcon(backgroundURL));
/*  59 */     backgroundLabel.setBounds(0, 0, 250, 250);
/*  60 */     add(backgroundLabel);
/*     */ 
/*  63 */     add(this.inventorySlotsPanel);
/*  64 */     setVisible(this.inventoryIsOpen);
/*     */   }
/*     */ 
/*     */   public void toggleInventory()
/*     */   {
/*  69 */     if (this.inventoryIsOpen) {
/*  70 */       this.inventoryIsOpen = false;
/*     */     }
/*     */     else {
/*  73 */       this.inventoryIsOpen = true;
/*  74 */       refreshItems();
/*     */     }
/*     */ 
/*  77 */     setVisible(this.inventoryIsOpen);
/*     */ 
/*  79 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void forceClose()
/*     */   {
/*  84 */     this.inventoryIsOpen = false;
/*  85 */     setVisible(this.inventoryIsOpen);
/*  86 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void refreshItems()
/*     */   {
/*  91 */     this.inventorySlotsPanel.removeAll();
/*  92 */     ArrayList<Item> items = Inventory.getInstance().getInventoryItems();
/*  93 */     int counter = 1;
/*  94 */     ToolTipManager.sharedInstance().setInitialDelay(0);
/*  95 */     for (final Item i : items)
/*     */     {
/* 100 */       String toolTipText = i.getName();
/*     */ 
/* 102 */       if (i.isWieldable())
/*     */       {
/* 104 */         if (!PlayerList.getInstance().getPlayer(Config.USERNAME).getPlayerEquipement().isEquiped(i.getId()))
/* 105 */           toolTipText = toolTipText + " (Click to use)";
/*     */         else
/* 107 */           toolTipText = toolTipText + "(Click to unequip)";
/*     */       }
/* 109 */       if (!i.isStackable())
/*     */       {
/* 111 */         JLabel item = new JLabel();
/* 112 */         item.setIcon(new ImageIcon(i.getIMGUrl()));
/* 113 */         item.setName(String.valueOf(i.getId()));
/* 114 */         item.setBounds(getItemBounds(counter));
/*     */ 
/* 117 */         item.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mousePressed(MouseEvent e) {
/* 120 */             InventoryGUI.this.clicksItem(i.getId());
/*     */           }
/*     */ 
/*     */           public void mouseEntered(MouseEvent e)
/*     */           {
/* 125 */             if (i.isWieldable())
/* 126 */               InventoryGUI.this.setCursor(new Cursor(12));
/*     */           }
/*     */ 
/*     */           public void mouseExited(MouseEvent e)
/*     */           {
/* 132 */             if (i.isWieldable())
/* 133 */               InventoryGUI.this.setCursor(new Cursor(0));
/*     */           }
/*     */         });
/* 138 */         item.setToolTipText(toolTipText);
/* 139 */         this.inventorySlotsPanel.add(item);
/* 140 */         this.inventorySlotsPanel.revalidate();
/* 141 */         this.inventorySlotsPanel.repaint();
/*     */       }
/*     */       else
/*     */       {
/* 149 */         JLabel itemAmount = new JLabel(String.valueOf(i.getAmount()));
/* 150 */         itemAmount.setForeground(Color.YELLOW);
/* 151 */         itemAmount.setFont(new Font("Serif", 1, 14));
/* 152 */         Rectangle rect = getItemBounds(counter);
/* 153 */         itemAmount.setBounds(rect.x + 1, rect.y - 45, 100, 100);
/* 154 */         this.inventorySlotsPanel.add(itemAmount);
/*     */ 
/* 156 */         JLabel item = new JLabel();
/* 157 */         item.setToolTipText(toolTipText);
/*     */ 
/* 159 */         item.setIcon(new ImageIcon(i.getIMGUrl()));
/* 160 */         item.setName(String.valueOf(i.getId()));
/* 161 */         item.setBounds(getItemBounds(counter));
/* 162 */         this.inventorySlotsPanel.add(item);
/*     */       }
/*     */ 
/* 165 */       counter++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void refreshShopItems(final ShopGui shopGui)
/*     */   {
/* 174 */     this.inventorySlotsPanel.removeAll();
/* 175 */     ArrayList<Item> items = Inventory.getInstance().getInventoryItems();
/* 176 */     int counter = 1;
/* 177 */     ToolTipManager.sharedInstance().setInitialDelay(0);
/* 178 */     for (final Item i : items)
/*     */     {
/* 183 */       String toolTipText = "Click to view the value of this item.";
/*     */ 
/* 186 */       if (!i.isStackable())
/*     */       {
/* 188 */         JLabel item = new JLabel();
/* 189 */         item.setIcon(new ImageIcon(i.getIMGUrl()));
/* 190 */         item.setName(String.valueOf(i.getId()));
/* 191 */         item.setBounds(getItemBounds(counter));
/*     */ 
/* 194 */         item.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mousePressed(MouseEvent e) {
/* 197 */             shopGui.loadInputBox(i.getId(), false);
/*     */           }
/*     */         });
/* 202 */         item.setToolTipText(toolTipText);
/* 203 */         this.inventorySlotsPanel.add(item);
/* 204 */         this.inventorySlotsPanel.revalidate();
/* 205 */         this.inventorySlotsPanel.repaint();
/*     */       }
/*     */       else
/*     */       {
/* 211 */         JLabel item = new JLabel();
/* 212 */         item.setToolTipText(toolTipText);
/*     */ 
/* 214 */         item.setIcon(new ImageIcon(i.getIMGUrl()));
/* 215 */         item.setName(String.valueOf(i.getId()));
/* 216 */         item.setBounds(getItemBounds(counter));
/* 217 */         this.inventorySlotsPanel.add(item);
/*     */ 
/* 219 */         JLabel itemAmount = new JLabel(String.valueOf(i.getAmount()));
/* 220 */         itemAmount.setForeground(Color.YELLOW);
/* 221 */         itemAmount.setFont(new Font("Serif", 1, 14));
/* 222 */         Rectangle rect = getItemBounds(counter);
/* 223 */         itemAmount.setBounds(rect.x + 1, rect.y - 45, 100, 100);
/* 224 */         this.inventorySlotsPanel.add(itemAmount);
/*     */       }
/*     */ 
/* 227 */       counter++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void clicksItem(int itemId)
/*     */   {
/* 235 */     Item clickedItem = Inventory.getInstance().getInventoryItem(itemId);
/*     */ 
/* 239 */     if (itemId == 42)
/*     */     {
/* 241 */       GamePanel.getInstance().openBrewingInterface();
/* 242 */       return;
/*     */     }
/*     */ 
/* 245 */     if (clickedItem.isWieldable())
/*     */     {
/* 247 */       if (!clickedItem.isWielded())
/* 248 */         Command.getInstance().sendCommand("toggle-equipe", "itemId=" + itemId);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void refreshItemsToBank()
/*     */   {
/* 254 */     this.inventorySlotsPanel.removeAll();
/* 255 */     ArrayList<Item> items = Inventory.getInstance().getInventoryItems();
/* 256 */     int counter = 1;
/* 257 */     for (final Item i : items)
/*     */     {
/* 259 */       if (!i.isStackable())
/*     */       {
/* 261 */         JLabel item = new JLabel();
/* 262 */         item.setIcon(new ImageIcon(i.getIMGUrl()));
/* 263 */         item.setName(String.valueOf(i.getId()));
/* 264 */         item.setBounds(getItemBounds(counter));
/*     */ 
/* 267 */         item.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mousePressed(MouseEvent e) {
/* 270 */             GamePanel.getInstance().getBankGUI().depositItem(i.getId());
/*     */           }
/*     */         });
/* 274 */         this.inventorySlotsPanel.add(item);
/*     */       }
/*     */       else
/*     */       {
/* 280 */         JLabel item = new JLabel();
/*     */ 
/* 282 */         item.setIcon(new ImageIcon(i.getIMGUrl()));
/* 283 */         item.setName(String.valueOf(i.getId()));
/* 284 */         item.setBounds(getItemBounds(counter));
/*     */ 
/* 287 */         item.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mousePressed(MouseEvent e) {
/* 290 */             GamePanel.getInstance().getBankGUI().depositItem(i.getId());
/*     */           }
/*     */         });
/* 294 */         this.inventorySlotsPanel.add(item);
/*     */ 
/* 296 */         JLabel itemAmount = new JLabel(String.valueOf(i.getAmount()));
/* 297 */         itemAmount.setForeground(Color.decode(Config.itemAmountHexColor));
/* 298 */         itemAmount.setFont(new Font("Serif", 1, 14));
/* 299 */         Rectangle rect = getItemBounds(counter);
/* 300 */         itemAmount.setBounds(rect.x + 1, rect.y - 45, 100, 100);
/* 301 */         this.inventorySlotsPanel.add(itemAmount);
/*     */       }
/*     */ 
/* 304 */       counter++;
/*     */     }
/*     */ 
/* 307 */     this.inventorySlotsPanel.revalidate();
/* 308 */     this.inventorySlotsPanel.repaint();
/*     */   }
/*     */ 
/*     */   public Rectangle getItemBounds(int slot)
/*     */   {
/* 313 */     Rectangle rect = new Rectangle();
/* 314 */     switch (slot)
/*     */     {
/*     */     case 1:
/* 317 */       rect.setBounds(0, 0, 50, 50);
/* 318 */       break;
/*     */     case 2:
/* 321 */       rect.setBounds(50, 0, 50, 50);
/* 322 */       break;
/*     */     case 3:
/* 325 */       rect.setBounds(100, 0, 50, 50);
/* 326 */       break;
/*     */     case 4:
/* 329 */       rect.setBounds(150, 0, 50, 50);
/* 330 */       break;
/*     */     case 5:
/* 333 */       rect.setBounds(200, 0, 50, 50);
/* 334 */       break;
/*     */     case 6:
/* 337 */       rect.setBounds(0, 50, 50, 50);
/* 338 */       break;
/*     */     case 7:
/* 341 */       rect.setBounds(50, 50, 50, 50);
/* 342 */       break;
/*     */     case 8:
/* 345 */       rect.setBounds(100, 50, 50, 50);
/* 346 */       break;
/*     */     case 9:
/* 349 */       rect.setBounds(150, 50, 50, 50);
/* 350 */       break;
/*     */     case 10:
/* 353 */       rect.setBounds(200, 50, 50, 50);
/* 354 */       break;
/*     */     case 11:
/* 357 */       rect.setBounds(0, 100, 50, 50);
/* 358 */       break;
/*     */     case 12:
/* 361 */       rect.setBounds(50, 100, 50, 50);
/* 362 */       break;
/*     */     case 13:
/* 365 */       rect.setBounds(100, 100, 50, 50);
/* 366 */       break;
/*     */     case 14:
/* 369 */       rect.setBounds(150, 100, 50, 50);
/* 370 */       break;
/*     */     case 15:
/* 373 */       rect.setBounds(200, 100, 50, 50);
/* 374 */       break;
/*     */     case 16:
/* 377 */       rect.setBounds(0, 150, 50, 50);
/* 378 */       break;
/*     */     case 17:
/* 381 */       rect.setBounds(50, 150, 50, 50);
/* 382 */       break;
/*     */     case 18:
/* 385 */       rect.setBounds(100, 150, 50, 50);
/* 386 */       break;
/*     */     case 19:
/* 389 */       rect.setBounds(150, 150, 50, 50);
/* 390 */       break;
/*     */     case 20:
/* 393 */       rect.setBounds(200, 150, 50, 50);
/* 394 */       break;
/*     */     case 21:
/* 397 */       rect.setBounds(0, 200, 50, 50);
/* 398 */       break;
/*     */     case 22:
/* 401 */       rect.setBounds(50, 200, 50, 50);
/* 402 */       break;
/*     */     case 23:
/* 405 */       rect.setBounds(100, 200, 50, 50);
/* 406 */       break;
/*     */     case 24:
/* 409 */       rect.setBounds(150, 200, 50, 50);
/* 410 */       break;
/*     */     case 25:
/* 413 */       rect.setBounds(200, 200, 50, 50);
/*     */     }
/*     */ 
/* 417 */     return rect;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.InventoryGUI
 * JD-Core Version:    0.6.2
 */