/*     */ package GUI;
/*     */ 
/*     */ import Game.Listeners;
/*     */ import java.awt.Color;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JLayeredPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class LaunchPanel extends JLayeredPane
/*     */ {
/*  25 */   private JProgressBar progressBar = null;
/*  26 */   Image backgroundIMG = null;
/*     */   private JTextField txtUsername;
/*     */   private JPasswordField txtPassword;
/*     */   private JTextField txtCreateUsername;
/*     */   private JPasswordField txtCreatePassword;
/*     */   private JPasswordField txtConfirmPassword;
/*     */   private JPanel errorPanel;
/*     */   private JLabel errorMessage;
/*     */   private JButton btnLogin;
/*  49 */   private final String backgroundIMGPath = "cache/login/background.jpg";
/*  50 */   private final String loginBackgroundIMGPath = "cache/login/loginbackground.jpg";
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void startup()
/*     */   {
/*  70 */     loadBackground();
/*  71 */     progressBar();
/*  72 */     loadShowLogin();
/*  73 */     initErrorMessage();
/*     */   }
/*     */ 
/*     */   private void initErrorMessage()
/*     */   {
/*  78 */     this.errorPanel = new JPanel();
/*  79 */     this.errorPanel.setBackground(Color.black);
/*  80 */     this.errorPanel.setLayout(new FlowLayout());
/*  81 */     this.errorPanel.setBounds(200, 120, 430, 50);
/*  82 */     this.errorPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
/*  83 */     setLayer(this.errorPanel, 2);
/*     */ 
/*  86 */     this.errorMessage = new JLabel("You suck fat cock");
/*  87 */     this.errorMessage.setForeground(Color.red);
/*  88 */     this.errorPanel.add(this.errorMessage);
/*  89 */     this.errorPanel.setVisible(false);
/*  90 */     add(this.errorPanel);
/*     */   }
/*     */ 
/*     */   public void showError(String error)
/*     */   {
/*  95 */     if (error.length() > 0)
/*     */     {
/*  97 */       this.errorMessage.setText(error);
/*  98 */       this.errorPanel.setVisible(true);
/*     */     }
/*     */     else {
/* 101 */       this.errorPanel.setVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void loadBackground()
/*     */   {
/* 110 */     ImageIcon imgIcon = new ImageIcon("cache/login/background.jpg");
/* 111 */     JLabel label = new JLabel();
/* 112 */     label.setIcon(imgIcon);
/* 113 */     label.setBounds(0, -13, 800, 600);
/* 114 */     setLayer(label, 1);
/*     */ 
/* 116 */     add(label);
/* 117 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void progressBar()
/*     */   {
/* 127 */     this.progressBar = new JProgressBar();
/* 128 */     this.progressBar.setValue(0);
/*     */ 
/* 130 */     this.progressBar.setStringPainted(true);
/*     */ 
/* 132 */     this.progressBar.setForeground(Color.RED);
/* 133 */     this.progressBar.setString("Loading, please wait.");
/* 134 */     this.progressBar.setBounds(100, 300, 600, 40);
/*     */ 
/* 136 */     setLayer(this.progressBar, 2);
/* 137 */     add(this.progressBar, "South");
/*     */ 
/* 139 */     while (this.progressBar.getValue() < 100)
/*     */     {
/*     */       try {
/* 142 */         Thread.sleep(5L);
/*     */       } catch (InterruptedException e) {
/* 144 */         e.printStackTrace();
/*     */       }
/*     */ 
/* 147 */       this.progressBar.setValue(this.progressBar.getValue() + 1);
/*     */     }
/*     */ 
/* 150 */     remove(this.progressBar);
/* 151 */     revalidate();
/* 152 */     repaint();
/*     */   }
/*     */ 
/*     */   public void loadShowLogin()
/*     */   {
/* 158 */     JLayeredPane loginPanel = new JLayeredPane();
/*     */ 
/* 161 */     ImageIcon imgIcon = new ImageIcon("cache/login/loginbackground.jpg");
/* 162 */     JLabel backgroundLabel = new JLabel();
/* 163 */     loginPanel.setLayer(backgroundLabel, 1);
/* 164 */     backgroundLabel.setIcon(imgIcon);
/* 165 */     backgroundLabel.setBounds(2, 2, 421, 296);
/*     */ 
/* 167 */     loginPanel.setBounds(200, 200, 425, 300);
/* 168 */     loginPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
/* 169 */     loginPanel.add(backgroundLabel);
/*     */ 
/* 171 */     JLabel lblLogin = new JLabel("Login");
/* 172 */     lblLogin.setBounds(80, 0, 75, 75);
/* 173 */     lblLogin.setFont(new Font("Serif", 1, 18));
/* 174 */     loginPanel.setLayer(lblLogin, 2);
/* 175 */     lblLogin.setForeground(Color.WHITE);
/* 176 */     loginPanel.add(lblLogin);
/*     */ 
/* 178 */     JLabel lblCreateAndLogin = new JLabel("Create Account");
/* 179 */     lblCreateAndLogin.setBounds(250, 0, 300, 75);
/* 180 */     lblCreateAndLogin.setFont(new Font("Serif", 1, 18));
/* 181 */     loginPanel.setLayer(lblCreateAndLogin, 2);
/* 182 */     lblCreateAndLogin.setForeground(Color.WHITE);
/* 183 */     loginPanel.add(lblCreateAndLogin);
/*     */ 
/* 185 */     JLabel lblUsername = new JLabel("Username:");
/* 186 */     loginPanel.setLayer(lblUsername, 2);
/* 187 */     lblUsername.setBounds(30, 65, 150, 25);
/* 188 */     lblUsername.setForeground(Color.WHITE);
/* 189 */     loginPanel.add(lblUsername);
/*     */ 
/* 191 */     this.txtUsername = new JTextField();
/* 192 */     loginPanel.setLayer(this.txtUsername, 2);
/* 193 */     this.txtUsername.setBounds(30, 85, 150, 25);
/* 194 */     loginPanel.add(this.txtUsername);
/*     */ 
/* 196 */     JLabel lblPassword = new JLabel("Password:");
/* 197 */     loginPanel.setLayer(lblPassword, 2);
/* 198 */     lblPassword.setBounds(30, 130, 150, 25);
/* 199 */     lblPassword.setForeground(Color.WHITE);
/* 200 */     loginPanel.add(lblPassword);
/*     */ 
/* 202 */     this.txtPassword = new JPasswordField();
/* 203 */     loginPanel.setLayer(this.txtPassword, 2);
/* 204 */     this.txtPassword.setBounds(30, 150, 150, 25);
/* 205 */     loginPanel.add(this.txtPassword);
/*     */ 
/* 207 */     JLabel lblChooseUsername = new JLabel("Choose Username:");
/* 208 */     loginPanel.setLayer(lblChooseUsername, 2);
/* 209 */     lblChooseUsername.setBounds(230, 65, 150, 25);
/* 210 */     lblChooseUsername.setForeground(Color.WHITE);
/* 211 */     loginPanel.add(lblChooseUsername);
/*     */ 
/* 213 */     this.txtCreateUsername = new JTextField();
/* 214 */     loginPanel.setLayer(this.txtCreateUsername, 2);
/* 215 */     this.txtCreateUsername.setBounds(230, 85, 150, 25);
/* 216 */     loginPanel.add(this.txtCreateUsername);
/*     */ 
/* 218 */     JLabel lblChoosePassword = new JLabel("Choose Password:");
/* 219 */     loginPanel.setLayer(lblChoosePassword, 2);
/* 220 */     lblChoosePassword.setBounds(230, 130, 150, 25);
/* 221 */     lblChoosePassword.setForeground(Color.WHITE);
/* 222 */     loginPanel.add(lblChoosePassword);
/*     */ 
/* 224 */     this.txtCreatePassword = new JPasswordField();
/* 225 */     loginPanel.setLayer(this.txtCreatePassword, 2);
/* 226 */     this.txtCreatePassword.setBounds(230, 150, 150, 25);
/* 227 */     loginPanel.add(this.txtCreatePassword);
/*     */ 
/* 229 */     JLabel lblConfirmPassowrd = new JLabel("Confirm Password:");
/* 230 */     loginPanel.setLayer(lblConfirmPassowrd, 2);
/* 231 */     lblConfirmPassowrd.setBounds(230, 190, 150, 25);
/* 232 */     lblConfirmPassowrd.setForeground(Color.WHITE);
/* 233 */     loginPanel.add(lblConfirmPassowrd);
/*     */ 
/* 235 */     this.txtConfirmPassword = new JPasswordField();
/* 236 */     loginPanel.setLayer(this.txtConfirmPassword, 2);
/* 237 */     this.txtConfirmPassword.setBounds(230, 210, 150, 25);
/* 238 */     loginPanel.add(this.txtConfirmPassword);
/*     */ 
/* 240 */     this.btnLogin = new JButton("Login");
/* 241 */     this.btnLogin.setBounds(10, 260, 400, 30);
/* 242 */     this.btnLogin.setBackground(Color.YELLOW);
/* 243 */     this.btnLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/* 244 */     this.btnLogin.setOpaque(true);
/* 245 */     this.btnLogin.addActionListener(Listeners.loginClicked);
/* 246 */     loginPanel.setLayer(this.btnLogin, 2);
/* 247 */     loginPanel.add(this.btnLogin);
/*     */ 
/* 249 */     setLayer(loginPanel, 2);
/* 250 */     add(loginPanel);
/*     */   }
/*     */ 
/*     */   public String getUsername()
/*     */   {
/* 255 */     return this.txtUsername.getText();
/*     */   }
/*     */ 
/*     */   public String getNewUsername()
/*     */   {
/* 260 */     return this.txtCreateUsername.getText();
/*     */   }
/*     */ 
/*     */   public char[] getNewPassword()
/*     */   {
/* 265 */     return this.txtCreatePassword.getPassword();
/*     */   }
/*     */ 
/*     */   public char[] getConfirmedPassword()
/*     */   {
/* 270 */     return this.txtConfirmPassword.getPassword();
/*     */   }
/*     */ 
/*     */   public void setErrorMessage(String msg)
/*     */   {
/* 275 */     showError(msg);
/*     */   }
/*     */ 
/*     */   public char[] getPassword()
/*     */   {
/* 281 */     return this.txtPassword.getPassword();
/*     */   }
/*     */ 
/*     */   public JButton getLoginButton()
/*     */   {
/* 286 */     return this.btnLogin;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.LaunchPanel
 * JD-Core Version:    0.6.2
 */