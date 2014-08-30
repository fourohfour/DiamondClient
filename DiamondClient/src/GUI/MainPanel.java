/*     */ package GUI;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JLayeredPane;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class MainPanel extends JLayeredPane
/*     */ {
/*  21 */   private JProgressBar progressBar = null;
/*  22 */   Image backgroundIMG = null;
/*     */ 
/*  25 */   private final String backgroundIMGPath = "cache/login/background.jpg";
/*  26 */   private final String loginBackgroundIMGPath = "cache/login/loginbackground.jpg";
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void startup()
/*     */   {
/*  41 */     loadBackground();
/*  42 */     progressBar();
/*     */   }
/*     */ 
/*     */   public void loadBackground()
/*     */   {
/*  49 */     ImageIcon imgIcon = new ImageIcon("cache/login/background.jpg");
/*  50 */     JLabel label = new JLabel();
/*  51 */     label.setIcon(imgIcon);
/*  52 */     label.setBounds(0, -13, 800, 600);
/*  53 */     setLayer(label, 1);
/*     */ 
/*  55 */     add(label);
/*  56 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void progressBar()
/*     */   {
/*  66 */     this.progressBar = new JProgressBar();
/*  67 */     this.progressBar.setValue(0);
/*     */ 
/*  69 */     this.progressBar.setStringPainted(true);
/*     */ 
/*  71 */     this.progressBar.setForeground(Color.RED);
/*  72 */     this.progressBar.setString("Loading, please wait.");
/*  73 */     this.progressBar.setBounds(100, 300, 600, 40);
/*     */ 
/*  75 */     setLayer(this.progressBar, 2);
/*  76 */     add(this.progressBar, "South");
/*     */ 
/*  78 */     while (this.progressBar.getValue() < 100)
/*     */     {
/*     */       try {
/*  81 */         Thread.sleep(5L);
/*     */       }
/*     */       catch (InterruptedException e) {
/*  84 */         e.printStackTrace();
/*     */       }
/*     */ 
/*  87 */       this.progressBar.setValue(this.progressBar.getValue() + 1);
/*     */     }
/*     */ 
/*  90 */     System.out.print(32332);
/*  91 */     remove(this.progressBar);
/*  92 */     revalidate();
/*  93 */     repaint();
/*     */ 
/*  95 */     loadShowLogin();
/*     */   }
/*     */ 
/*     */   public void loadShowLogin()
/*     */   {
/* 100 */     JLayeredPane loginPanel = new JLayeredPane();
/*     */ 
/* 103 */     ImageIcon imgIcon = new ImageIcon("cache/login/loginbackground.jpg");
/* 104 */     JLabel backgroundLabel = new JLabel();
/* 105 */     loginPanel.setLayer(backgroundLabel, 1);
/* 106 */     backgroundLabel.setIcon(imgIcon);
/* 107 */     backgroundLabel.setBounds(2, 2, 421, 296);
/*     */ 
/* 109 */     loginPanel.setBounds(200, 200, 425, 300);
/* 110 */     loginPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
/* 111 */     loginPanel.add(backgroundLabel);
/*     */ 
/* 113 */     JLabel lblLogin = new JLabel("Login");
/* 114 */     lblLogin.setBounds(80, 0, 75, 75);
/* 115 */     lblLogin.setFont(new Font("Serif", 1, 18));
/* 116 */     loginPanel.setLayer(lblLogin, 2);
/* 117 */     lblLogin.setForeground(Color.WHITE);
/* 118 */     loginPanel.add(lblLogin);
/*     */ 
/* 120 */     JLabel lblCreateAndLogin = new JLabel("Create Account");
/* 121 */     lblCreateAndLogin.setBounds(250, 0, 300, 75);
/* 122 */     lblCreateAndLogin.setFont(new Font("Serif", 1, 18));
/* 123 */     loginPanel.setLayer(lblCreateAndLogin, 2);
/* 124 */     lblCreateAndLogin.setForeground(Color.WHITE);
/* 125 */     loginPanel.add(lblCreateAndLogin);
/*     */ 
/* 127 */     JLabel lblUsername = new JLabel("Username:");
/* 128 */     loginPanel.setLayer(lblUsername, 2);
/* 129 */     lblUsername.setBounds(30, 65, 150, 25);
/* 130 */     lblUsername.setForeground(Color.WHITE);
/* 131 */     loginPanel.add(lblUsername);
/*     */ 
/* 133 */     JTextField txtUsername = new JTextField();
/* 134 */     loginPanel.setLayer(txtUsername, 2);
/* 135 */     txtUsername.setBounds(30, 85, 150, 25);
/* 136 */     loginPanel.add(txtUsername);
/*     */ 
/* 138 */     JLabel lblPassword = new JLabel("Password:");
/* 139 */     loginPanel.setLayer(lblPassword, 2);
/* 140 */     lblPassword.setBounds(30, 130, 150, 25);
/* 141 */     lblPassword.setForeground(Color.WHITE);
/* 142 */     loginPanel.add(lblPassword);
/*     */ 
/* 144 */     JPasswordField txtPassword = new JPasswordField();
/* 145 */     loginPanel.setLayer(txtPassword, 2);
/* 146 */     txtPassword.setBounds(30, 150, 150, 25);
/* 147 */     loginPanel.add(txtPassword);
/*     */ 
/* 149 */     JLabel lblChooseUsername = new JLabel("Choose Username:");
/* 150 */     loginPanel.setLayer(lblChooseUsername, 2);
/* 151 */     lblChooseUsername.setBounds(230, 65, 150, 25);
/* 152 */     lblChooseUsername.setForeground(Color.WHITE);
/* 153 */     loginPanel.add(lblChooseUsername);
/*     */ 
/* 155 */     JTextField txtCreateUsername = new JTextField();
/* 156 */     loginPanel.setLayer(txtCreateUsername, 2);
/* 157 */     txtCreateUsername.setBounds(230, 85, 150, 25);
/* 158 */     loginPanel.add(txtCreateUsername);
/*     */ 
/* 160 */     JLabel lblChoosePassword = new JLabel("Choose Password:");
/* 161 */     loginPanel.setLayer(lblChoosePassword, 2);
/* 162 */     lblChoosePassword.setBounds(230, 130, 150, 25);
/* 163 */     lblChoosePassword.setForeground(Color.WHITE);
/* 164 */     loginPanel.add(lblChoosePassword);
/*     */ 
/* 166 */     JPasswordField txtCreatePassword = new JPasswordField();
/* 167 */     loginPanel.setLayer(txtCreatePassword, 2);
/* 168 */     txtCreatePassword.setBounds(230, 150, 150, 25);
/* 169 */     loginPanel.add(txtCreatePassword);
/*     */ 
/* 171 */     JLabel lblConfirmPassowrd = new JLabel("Confirm Password:");
/* 172 */     loginPanel.setLayer(lblConfirmPassowrd, 2);
/* 173 */     lblConfirmPassowrd.setBounds(230, 190, 150, 25);
/* 174 */     lblConfirmPassowrd.setForeground(Color.WHITE);
/* 175 */     loginPanel.add(lblConfirmPassowrd);
/*     */ 
/* 177 */     JPasswordField txtConfirmPassword = new JPasswordField();
/* 178 */     loginPanel.setLayer(txtConfirmPassword, 2);
/* 179 */     txtConfirmPassword.setBounds(230, 210, 150, 25);
/* 180 */     loginPanel.add(txtConfirmPassword);
/*     */ 
/* 182 */     JButton btnLogin = new JButton("Login");
/* 183 */     btnLogin.setBounds(10, 260, 400, 30);
/* 184 */     btnLogin.setBackground(Color.YELLOW);
/* 185 */     btnLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/* 186 */     btnLogin.setOpaque(true);
/* 187 */     loginPanel.setLayer(btnLogin, 2);
/* 188 */     loginPanel.add(btnLogin);
/*     */ 
/* 190 */     setLayer(loginPanel, 2);
/* 191 */     add(loginPanel);
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.MainPanel
 * JD-Core Version:    0.6.2
 */