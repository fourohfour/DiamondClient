/*     */ package GUI.bank;
/*     */ 
/*     */ import GUI.GamePanel;
/*     */ import GUI.InventoryGUI;
/*     */ import GUI.misc.InputBox;
/*     */ import connections.Command;

/*     */ import java.awt.Color;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.PrintStream;

/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;

/*     */ import players.Bank;
/*     */ import players.Inventory;
/*     */ import players.Item;
/*     */ import players.ItemList;
/*     */ 
/*     */ public class BankGUI extends JPanel
/*     */ {
/*     */   private InventoryGUI inventory;
/*     */   private JPanel bankPage1Panel;
/*     */   private JPanel bankPage2Panel;
/*     */   private JPanel bankPage3Panel;
/*     */   private JPanel bankPage4Panel;
/*  39 */   InputBox depositInputBox = null;
/*     */   private boolean bankIsOpen;
/* 220 */   private ActionListener closeBankListener = new ActionListener()
/*     */   {
/*     */     public void actionPerformed(ActionEvent e)
/*     */     {
/* 224 */       BankGUI.this.bankIsOpen = false;
/* 225 */       BankGUI.this.setVisible(BankGUI.this.bankIsOpen);
/* 226 */       Command.getInstance().sendCommand("closebank", "");
/*     */     }
/* 220 */   };
/*     */ 
/*     */   public BankGUI()
/*     */   {
/*  45 */     setLayout(null);
/*  46 */     setBounds(5, 40, 790, 400);
/*  47 */     setBackground(Color.GRAY);
/*     */ 
/*  49 */     JButton closeButton = new JButton("X");
/*  50 */     closeButton.setBackground(Color.black);
/*  51 */     closeButton.setForeground(Color.WHITE);
/*  52 */     closeButton.addActionListener(this.closeBankListener);
/*  53 */     closeButton.setBounds(740, 5, 45, 20);
/*  54 */     add(closeButton);
/*     */ 
/*  56 */     JButton page1Button = new JButton("1");
/*  57 */     page1Button.setBackground(Color.black);
/*  58 */     page1Button.setForeground(Color.WHITE);
/*  59 */     page1Button.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  62 */         BankGUI.this.switchBankPage(1);
/*     */       }
/*     */     });
/*  65 */     page1Button.setBounds(323, 10, 45, 20);
/*  66 */     add(page1Button);
/*     */ 
/*  69 */     JButton page2Button = new JButton("2");
/*  70 */     page2Button.setBackground(Color.black);
/*  71 */     page2Button.setForeground(Color.WHITE);
/*  72 */     page2Button.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  75 */         BankGUI.this.switchBankPage(2);
/*     */       }
/*     */     });
/*  79 */     page2Button.setBounds(370, 10, 45, 20);
/*  80 */     add(page2Button);
/*     */ 
/*  82 */     this.bankIsOpen = false;
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/*  89 */     this.inventory = new InventoryGUI(true);
/*  90 */     this.inventory.init();
/*  91 */     add(this.inventory);
/*  92 */     setVisible(this.bankIsOpen);
/*     */ 
/*  94 */     this.bankPage1Panel = new JPanel(new FlowLayout(0));
/*  95 */     this.bankPage1Panel.setBounds(285, 40, 455, 350);
/*  96 */     this.bankPage1Panel.setBackground(Color.decode("#CECECE"));
/*  97 */     add(this.bankPage1Panel);
/*  98 */     this.bankPage1Panel.setVisible(true);
/*     */ 
/* 100 */     this.bankPage2Panel = new JPanel(new FlowLayout(0));
/* 101 */     this.bankPage2Panel.setBounds(285, 40, 455, 350);
/* 102 */     this.bankPage2Panel.setBackground(Color.decode("#CECECE"));
/* 103 */     add(this.bankPage2Panel);
/* 104 */     this.bankPage2Panel.setVisible(false);
/*     */   }
/*     */ 
/*     */   public void switchBankPage(int page)
/*     */   {
/* 110 */     this.bankPage1Panel.setVisible(false);
/* 111 */     this.bankPage2Panel.setVisible(false);
/*     */ 
/* 113 */     if (page == 1) {
/* 114 */       this.bankPage1Panel.setVisible(true);
/*     */     }
/* 116 */     if (page == 2)
/* 117 */       this.bankPage2Panel.setVisible(true);
/*     */   }
/*     */ 
/*     */   public synchronized void refreshBank()
/*     */   {
/* 122 */     this.inventory.refreshItemsToBank();
/* 123 */     this.bankPage1Panel.removeAll();
/* 124 */     this.bankPage2Panel.removeAll();
/*     */ 
/* 126 */     int counter = 0;
/* 127 */     for (Item i : Bank.getInstance().getItems())
/*     */     {
/* 129 */       counter++;
/* 130 */       final int itemId = i.getId();
/*     */ 
/* 132 */       JPanel itemPanelSlot = new JPanel();
/* 133 */       itemPanelSlot.setLayout(new FlowLayout(0));
/* 134 */       itemPanelSlot.setSize(70, 50);
/* 135 */       itemPanelSlot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/* 136 */       itemPanelSlot.setBackground(Color.white);
/*     */ 
/* 138 */       JLabel itemPicture = new JLabel();
/* 139 */       itemPicture.setName(String.valueOf(i.getId()));
/* 140 */       itemPicture.setIcon(new ImageIcon(i.getIMGUrl()));
/*     */ 
/* 142 */       JLabel itemAmount = new JLabel(String.valueOf(i.getAmount()));
/*     */ 
/* 145 */       itemPanelSlot.add(itemAmount);
/* 146 */       itemPanelSlot.add(itemPicture);
/*     */ 
/* 151 */       if (counter <= 25)
/* 152 */         this.bankPage1Panel.add(itemPanelSlot);
/*     */       else {
/* 154 */         this.bankPage2Panel.add(itemPanelSlot);
/*     */       }
/*     */ 
/* 157 */       itemPicture.addMouseListener(new MouseAdapter()
/*     */       {
/*     */         public void mousePressed(MouseEvent e) {
/* 160 */           GamePanel.getInstance().getBankGUI().withdrawItem(itemId);
/*     */         }
/*     */       });
/*     */     }
/* 164 */     this.bankPage1Panel.repaint();
/* 165 */     this.bankPage1Panel.revalidate();
/*     */   }
/*     */ 
/*     */   private void withdrawItem(int itemId)
/*     */   {
/* 171 */     Item item = ItemList.getInstance().getItem(itemId);
/*     */ 
/* 173 */     if (this.depositInputBox != null) {
/* 174 */       remove(this.depositInputBox);
/*     */     }
/* 176 */     this.depositInputBox = new InputBox("# of " + item.getName() + "'s to widthdraw?", 5, 300, 250, 65, "Withdraw Item");
/* 177 */     this.depositInputBox.init();
/* 178 */     this.depositInputBox.listenWithdraw(itemId);
/* 179 */     this.depositInputBox.listenWithdrawEnter(itemId);
/* 180 */     add(this.depositInputBox);
/* 181 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void depositItem(int id)
/*     */   {
/* 186 */     Item item = Inventory.getInstance().getInventoryItem(id);
/*     */ 
/* 188 */     if (this.depositInputBox != null) {
/* 189 */       remove(this.depositInputBox);
/*     */     }
/* 191 */     this.depositInputBox = new InputBox("# of " + item.getName() + "'s to deposit?", 5, 300, 250, 65, "Bank Item");
/* 192 */     this.depositInputBox.init();
/* 193 */     this.depositInputBox.listen(id);
/* 194 */     this.depositInputBox.listenDepositEnter(id);
/* 195 */     add(this.depositInputBox);
/* 196 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void confirmDepositItem(int id, String amm)
/*     */   {
/*     */     try
/*     */     {
/* 203 */       int amount = Integer.parseInt(amm);
/* 204 */       remove(this.depositInputBox);
/* 205 */       Command.getInstance().sendCommand("bank", "itemId=" + id + ";" + "amount=" + amount);
/* 206 */       GamePanel.getInstance().getBankGUI().refreshBank();
/* 207 */       GamePanel.getInstance().getInventory().refreshItemsToBank();
/* 208 */       GamePanel.getInstance().getInventory().refreshItems();
/*     */     } catch (Exception e) {
/* 210 */       System.out.println(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void openBank() {
/* 215 */     this.bankIsOpen = true;
/* 216 */     this.inventory.refreshItemsToBank();
/* 217 */     setVisible(this.bankIsOpen);
/*     */   }
/*     */ 
/*     */   public void confirmWithdrawItem(int id, String amm)
/*     */   {
/*     */     try
/*     */     {
/* 234 */       int amount = Integer.parseInt(amm);
/* 235 */       remove(this.depositInputBox);
/* 236 */       Command.getInstance().sendCommand("withdrawbank", "itemId=" + id + ";" + "amount=" + amount);
/* 237 */       GamePanel.getInstance().getBankGUI().refreshBank();
/* 238 */       GamePanel.getInstance().getInventory().refreshItemsToBank();
/* 239 */       GamePanel.getInstance().getInventory().refreshItems();
/*     */     } catch (Exception e) {
/* 241 */       System.out.println(e.getMessage());
/*     */     }
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.bank.BankGUI
 * JD-Core Version:    0.6.2
 */