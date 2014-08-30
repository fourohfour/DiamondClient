/*     */ package GUI.smithing;
/*     */ 
/*     */ import connections.Command;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import players.Item;
/*     */ import players.ItemList;
/*     */ 
/*     */ public class SmithingGUI extends JPanel
/*     */ {
/*  23 */   int sizeX = 785;
/*  24 */   int sizeY = 400;
/*     */ 
/*     */   public SmithingGUI getSmithingGui(String barUsed)
/*     */   {
/*  35 */     setBounds(5, 40, this.sizeX, this.sizeY);
/*  36 */     setLayout(new FlowLayout());
/*     */ 
/*  40 */     if (barUsed.equals("bronze"))
/*     */     {
/*  42 */       add(addRow(2, "10 bronze bars", 1));
/*  43 */       add(addRow(13, "10 bronze bars", 3));
/*  44 */       add(addRow(47, "20 bronze bars", 8));
/*  45 */       add(addRow(57, "30 bronze bars", 15));
/*  46 */       add(addRow(36, "30 bronze bars", 17));
/*  47 */       add(addRow(52, "50 bronze bars", 18));
/*     */     }
/*  49 */     else if (barUsed.equals("iron"))
/*     */     {
/*  51 */       add(addRow(3, "10 iron bars", 5));
/*  52 */       add(addRow(14, "10 iron bars", 7));
/*  53 */       add(addRow(48, "20 iron bars", 15));
/*  54 */       add(addRow(58, "30 iron bars", 21));
/*  55 */       add(addRow(37, "30 iron bars", 25));
/*  56 */       add(addRow(53, "50 iron bars", 28));
/*     */     }
/*  58 */     else if (barUsed.equals("silver"))
/*     */     {
/*  60 */       add(addRow(4, "10 silver bars", 15));
/*  61 */       add(addRow(15, "10 silver bars", 18));
/*  62 */       add(addRow(49, "20 silver bars", 25));
/*  63 */       add(addRow(59, "30 silver bars", 30));
/*  64 */       add(addRow(38, "30 silver bars", 32));
/*  65 */       add(addRow(54, "50 silver bars", 38));
/*     */     }
/*     */ 
/*  68 */     JButton closeButton = new JButton("                     X                     ");
/*  69 */     closeButton.setForeground(Color.white);
/*  70 */     closeButton.setBackground(Color.black);
/*  71 */     closeButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/*  75 */         SmithingGUI.this.setVisible(false);
/*  76 */         SmithingGUI.this.removeAll();
/*     */       }
/*     */     });
/*  80 */     add(closeButton);
/*     */ 
/*  82 */     return this;
/*     */   }
/*     */ 
/*     */   private JPanel addRow(int itemId, String material, int level)
/*     */   {
/*  88 */     final Item itemToSmith = ItemList.getInstance().getItem(itemId);
/*     */ 
/*  90 */     JPanel row = new JPanel();
/*  91 */     row.setLayout(new BorderLayout(200, 50));
/*  92 */     row.setSize(785, 50);
/*  93 */     row.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/*     */ 
/*  95 */     JLabel lblItem = new JLabel();
/*  96 */     String urlIMG = itemToSmith.getIMGUrl();
/*  97 */     lblItem.setIcon(new ImageIcon(urlIMG));
/*     */ 
/*  99 */     JLabel lblMaterial = new JLabel(material);
/*     */ 
/* 101 */     JButton btnSmith = new JButton("Smith (Level Req: " + level + ")");
/* 102 */     btnSmith.setBackground(Color.black);
/* 103 */     btnSmith.setForeground(Color.WHITE);
/* 104 */     btnSmith.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 108 */         Command.getInstance().sendCommand("smith", "id=" + itemToSmith.getId());
/*     */       }
/*     */     });
/* 113 */     row.add(lblItem, "West");
/* 114 */     row.add(lblMaterial, "Center");
/* 115 */     row.add(btnSmith, "East");
/*     */ 
/* 117 */     JScrollPane jp = new JScrollPane(
/* 118 */       this, 
/* 119 */       22, 
/* 120 */       30);
/*     */ 
/* 123 */     return row;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.smithing.SmithingGUI
 * JD-Core Version:    0.6.2
 */