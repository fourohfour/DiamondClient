/*     */ package GUI;
/*     */ 
/*     */ import connections.Command;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ import players.Config;
/*     */ 
/*     */ public class InputBox extends JPanel
/*     */ {
/*     */   private String title;
/*     */   private String message;
/*     */   private String[] options;
/*     */   private String[] idWhenOptionLicked;
/*  25 */   private int sizeX = 537;
/*  26 */   private int sizeY = 237;
/*     */   private JLabel msg;
/*     */ 
/*     */   public void setNumberOfOptions(int numberOfOptions)
/*     */   {
/*  36 */     this.options = new String[numberOfOptions];
/*  37 */     this.idWhenOptionLicked = new String[numberOfOptions];
/*     */   }
/*     */ 
/*     */   public void setOption(String s, int index, String id)
/*     */   {
/*  42 */     this.options[index] = s;
/*  43 */     this.idWhenOptionLicked[index] = id;
/*     */   }
/*     */ 
/*     */   public void setTitleAndMessage(String title, String msg)
/*     */   {
/*  48 */     this.title = title;
/*  49 */     this.message = msg;
/*     */   }
/*     */ 
/*     */   public void init(boolean longMessage)
/*     */   {
/*  58 */     setLayout(new BoxLayout(this, 1));
/*  59 */     setSize(this.sizeX, this.sizeY);
/*     */ 
/*  62 */     Border paddingBorderTitle1 = BorderFactory.createLineBorder(null);
/*  63 */     Border paddingBorderTitle2 = BorderFactory.createEmptyBorder(10, 100, 10, 100);
/*     */ 
/*  65 */     JLabel jtitle = new JLabel(this.title);
/*  66 */     jtitle.setFont(new Font("Serif", 1, 18));
/*  67 */     jtitle.setAlignmentX(0.5F);
/*  68 */     jtitle.setSize(this.sizeX, 50);
/*  69 */     jtitle.setBorder(BorderFactory.createCompoundBorder(paddingBorderTitle1, paddingBorderTitle2));
/*     */ 
/*  71 */     this.msg = null;
/*     */ 
/*  73 */     if (longMessage)
/*     */     {
/*  75 */       StringBuilder sb = new StringBuilder(64);
/*  76 */       sb.append("<html>").append(this.message).append("</html>");
/*  77 */       this.msg = new JLabel(sb.toString());
/*     */     }
/*     */     else {
/*  80 */       this.msg = new JLabel(this.message);
/*     */     }
/*     */ 
/*  83 */     this.msg.setAlignmentX(0.5F);
/*  84 */     this.msg.setBorder(new EmptyBorder(20, 20, 20, 20));
/*  85 */     add(jtitle);
/*  86 */     add(this.msg);
/*  87 */     for (int i = 0; i < this.options.length; i++)
/*     */     {
/*  89 */       final int index = i;
/*     */ 
/*  91 */       final JLabel option = new JLabel(this.options[i]);
/*  92 */       option.setAlignmentX(0.5F);
/*     */ 
/*  94 */       option.addMouseListener(new MouseAdapter()
/*     */       {
/*     */         public void mouseExited(MouseEvent e)
/*     */         {
/*  98 */           option.setForeground(Color.black);
/*     */         }
/*     */ 
/*     */         public void mouseEntered(MouseEvent e)
/*     */         {
/* 103 */           option.setForeground(Color.red);
/*     */         }
/*     */ 
/*     */         public void mouseClicked(MouseEvent e)
/*     */         {
/* 108 */           InputBox.this.optionClicked(InputBox.this.idWhenOptionLicked[index]);
/* 109 */           if (!InputBox.this.idWhenOptionLicked[index].equals("recent_updates"))
/* 110 */             InputBox.this.closeBox();
/*     */         }
/*     */       });
/* 115 */       add(option);
/*     */     }
/*     */ 
/* 120 */     final JLabel closeLBL = new JLabel("Cancel");
/* 121 */     closeLBL.setAlignmentX(0.5F);
/*     */ 
/* 123 */     closeLBL.addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mouseExited(MouseEvent e)
/*     */       {
/* 127 */         closeLBL.setForeground(Color.black);
/*     */       }
/*     */ 
/*     */       public void mouseEntered(MouseEvent e)
/*     */       {
/* 132 */         closeLBL.setForeground(Color.red);
/*     */       }
/*     */ 
/*     */       public void mouseClicked(MouseEvent e)
/*     */       {
/* 137 */         InputBox.this.closeBox();
/*     */       }
/*     */     });
/* 144 */     add(closeLBL);
/*     */   }
/*     */ 
/*     */   private void closeBox()
/*     */   {
/* 150 */     setVisible(false);
/* 151 */     removeAll();
/*     */   }
/*     */ 
/*     */   public void optionClicked(String identifier)
/*     */   {
/* 157 */     if (identifier.startsWith("smelt"))
/*     */     {
/* 159 */       int oreIdToSmelt = -1;
/*     */ 
/* 161 */       if (identifier.equals("smelt_copper"))
/* 162 */         oreIdToSmelt = 20;
/* 163 */       else if (identifier.equals("smelt_iron"))
/* 164 */         oreIdToSmelt = 21;
/* 165 */       else if (identifier.equals("smelt_iron"))
/* 166 */         oreIdToSmelt = 22;
/* 167 */       else if (identifier.equals("smelt_gold"))
/* 168 */         oreIdToSmelt = 23;
/* 169 */       else if (identifier.equals("smelt_titanium")) {
/* 170 */         oreIdToSmelt = 24;
/*     */       }
/* 172 */       Command.getInstance().sendCommand("smelt", "ore=" + oreIdToSmelt);
/*     */     }
/* 174 */     else if (identifier.startsWith("smith"))
/*     */     {
/* 176 */       GamePanel.getInstance().openSmithingInterface(identifier.substring(6));
/*     */     }
/* 178 */     else if (identifier.equals("fixCamp2Bridge"))
/*     */     {
/* 180 */       Command.getInstance().sendCommand("fixCamp2Bridge", "fixCamp2Bridge");
/*     */     }
/* 182 */     else if (identifier.equals("recent_updates"))
/*     */     {
/* 184 */       StringBuilder sb = new StringBuilder(64);
/* 185 */       sb.append("<html>").append(Config.recentUpdates).append("</html>");
/* 186 */       this.msg.setText(sb.toString());
/*     */     }
/* 189 */     else if (!identifier.equalsIgnoreCase("Cancel")) {
/* 190 */       Command.getInstance().sendCommand(identifier, "");
/*     */     }
/*     */   }
/*     */ 
/* 194 */   public int getSizeX() { return this.sizeX; }
/*     */ 
/*     */   public void setSizeX(int sizeX)
/*     */   {
/* 198 */     this.sizeX = sizeX;
/*     */   }
/*     */ 
/*     */   public int getSizeY() {
/* 202 */     return this.sizeY;
/*     */   }
/*     */ 
/*     */   public void setSizeY(int sizeY) {
/* 206 */     this.sizeY = sizeY;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.InputBox
 * JD-Core Version:    0.6.2
 */