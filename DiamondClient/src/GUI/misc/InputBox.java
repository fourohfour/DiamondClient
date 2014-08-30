/*     */ package GUI.misc;
/*     */ 
/*     */ import GUI.GamePanel;
/*     */ import GUI.bank.BankGUI;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class InputBox extends JPanel
/*     */ {
/*     */   private String title;
/*     */   private String btnText;
/*     */   private Rectangle bounds;
/*     */   private String input;
/*     */   JButton btn;
/*     */   JTextField txtInput;
/*     */ 
/*     */   public InputBox(String title, int positionx, int positiony, int width, int height, String btnText)
/*     */   {
/*  35 */     this.title = title;
/*  36 */     this.bounds = new Rectangle(positionx, positiony, width, height);
/*  37 */     this.btnText = btnText;
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/*  46 */     JLabel lblTitle = new JLabel();
/*  47 */     lblTitle.setText(this.title);
/*     */ 
/*  50 */     this.txtInput = new JTextField() {
/*     */       public void addNotify() {
/*  52 */         super.addNotify();
/*  53 */         requestFocus();
/*     */       }
/*     */     };
/*  56 */     this.txtInput.setSize(50, 20);
/*  57 */     this.txtInput.setText("1");
/*     */ 
/*  60 */     this.btn = new JButton(this.btnText);
/*     */ 
/*  62 */     setLayout(new BorderLayout());
/*  63 */     setBackground(Color.green);
/*  64 */     setBounds(this.bounds);
/*  65 */     add(lblTitle, "North");
/*  66 */     add(this.txtInput, "Center");
/*  67 */     add(this.btn, "South");
/*     */   }
/*     */ 
/*     */   public String listen(final int id)
/*     */   {
/*  75 */     this.btn.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/*  79 */         InputBox.this.input = InputBox.this.txtInput.getText();
/*  80 */         GamePanel.getInstance().getBankGUI().confirmDepositItem(id, InputBox.this.input);
/*     */       }
/*     */     });
/*  84 */     return this.input;
/*     */   }
/*     */ 
/*     */   public String listenWithdraw(final int id)
/*     */   {
/*  89 */     this.btn.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/*  93 */         InputBox.this.input = InputBox.this.txtInput.getText();
/*  94 */         GamePanel.getInstance().getBankGUI().confirmWithdrawItem(id, InputBox.this.input);
/*     */       }
/*     */     });
/*  98 */     return this.input;
/*     */   }
/*     */ 
/*     */   public String listenWithdrawEnter(final int id)
/*     */   {
/* 103 */     this.txtInput.addKeyListener(new KeyListener()
/*     */     {
/*     */       public void keyTyped(KeyEvent e)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent e)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyPressed(KeyEvent e)
/*     */       {
/* 115 */         if (e.getKeyCode() == 10)
/*     */         {
/* 117 */           InputBox.this.input = InputBox.this.txtInput.getText();
/* 118 */           GamePanel.getInstance().getBankGUI().confirmWithdrawItem(id, InputBox.this.input);
/*     */         }
/*     */       }
/*     */     });
/* 123 */     return this.input;
/*     */   }
/*     */ 
/*     */   public String listenDepositEnter(final int id)
/*     */   {
/* 128 */     this.txtInput.addKeyListener(new KeyListener()
/*     */     {
/*     */       public void keyTyped(KeyEvent e)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent e)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyPressed(KeyEvent e)
/*     */       {
/* 140 */         if (e.getKeyCode() == 10)
/*     */         {
/* 142 */           InputBox.this.input = InputBox.this.txtInput.getText();
/* 143 */           GamePanel.getInstance().getBankGUI().confirmDepositItem(id, InputBox.this.input);
/*     */         }
/*     */       }
/*     */     });
/* 148 */     return this.input;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.misc.InputBox
 * JD-Core Version:    0.6.2
 */