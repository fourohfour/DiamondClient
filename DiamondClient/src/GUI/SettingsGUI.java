/*     */ package GUI;
/*     */ 
/*     */ import Game.Listeners;
/*     */ import java.awt.Color;
/*     */ import java.awt.Desktop;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLayeredPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class SettingsGUI extends JLayeredPane
/*     */ {
/*  19 */   private boolean settingsIsOpen = false;
/*     */   JPanel settingsPanel;
/*  22 */   private final int SIZE_X = 130;
/*  23 */   private final int SIZE_Y = 300;
/*     */ 
/*     */   public SettingsGUI()
/*     */   {
/*  27 */     setLayout(null);
/*  28 */     setBounds(2, 40, 130, 300);
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/*  33 */     this.settingsPanel = new JPanel();
/*  34 */     this.settingsPanel.setLayout(null);
/*  35 */     this.settingsPanel.setBounds(0, 0, 130, 300);
/*  36 */     this.settingsPanel.setBackground(Color.decode("#D7D7D7"));
/*     */ 
/*  38 */     setLayout(new FlowLayout());
/*  39 */     setLayer(this.settingsPanel, 1);
/*  40 */     add(this.settingsPanel);
/*  41 */     setVisible(this.settingsIsOpen);
/*     */ 
/*  43 */     addOptions();
/*     */   }
/*     */ 
/*     */   public void addOptions()
/*     */   {
/*  48 */     JButton subcribe = new JButton("Subscribe");
/*  49 */     subcribe.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*     */         try {
/*  53 */           Desktop.getDesktop().browse(new URI("http://www.diamondhunt.co/mmo/membership.php"));
/*     */         }
/*     */         catch (IOException localIOException)
/*     */         {
/*     */         }
/*     */         catch (URISyntaxException localURISyntaxException)
/*     */         {
/*     */         }
/*     */       }
/*     */     });
/*  59 */     subcribe.setSize(80, 20);
/*     */ 
/*  62 */     subcribe.setBackground(Color.darkGray);
/*  63 */     subcribe.setForeground(Color.yellow);
/*  64 */     setLayer(subcribe, 2);
/*  65 */     add(subcribe);
/*     */ 
/*  68 */     JButton droptables = new JButton("Drop tables");
/*  69 */     droptables.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*     */         try {
/*  73 */           Desktop.getDesktop().browse(new URI("http://www.diamondhunt.co/mmo/npc-drops.php"));
/*     */         }
/*     */         catch (IOException localIOException)
/*     */         {
/*     */         }
/*     */         catch (URISyntaxException localURISyntaxException)
/*     */         {
/*     */         }
/*     */       }
/*     */     });
/*  79 */     droptables.setSize(80, 20);
/*     */ 
/*  82 */     droptables.setBackground(Color.darkGray);
/*  83 */     droptables.setForeground(Color.yellow);
/*  84 */     setLayer(droptables, 2);
/*  85 */     add(droptables);
/*     */ 
/*  88 */     JButton hiscores = new JButton("Highscores");
/*  89 */     hiscores.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*     */         try {
/*  93 */           Desktop.getDesktop().browse(new URI("http://www.diamondhunt.co/mmo/highscores/overall.php"));
/*     */         }
/*     */         catch (IOException localIOException)
/*     */         {
/*     */         }
/*     */         catch (URISyntaxException localURISyntaxException)
/*     */         {
/*     */         }
/*     */       }
/*     */     });
/*  99 */     hiscores.setSize(80, 20);
/*     */ 
/* 102 */     hiscores.setBackground(Color.darkGray);
/* 103 */     hiscores.setForeground(Color.yellow);
/* 104 */     setLayer(hiscores, 2);
/* 105 */     add(hiscores);
/*     */ 
/* 107 */     JButton diamondStats = new JButton("Diamond Statistics");
/* 108 */     diamondStats.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*     */         try {
/* 112 */           Desktop.getDesktop().browse(new URI("http://www.diamondhunt.co/mmo/diamonds_stats.php"));
/*     */         }
/*     */         catch (IOException localIOException)
/*     */         {
/*     */         }
/*     */         catch (URISyntaxException localURISyntaxException)
/*     */         {
/*     */         }
/*     */       }
/*     */     });
/* 118 */     diamondStats.setSize(120, 20);
/*     */ 
/* 120 */     JButton reddit = new JButton("Subreddit");
/* 121 */     reddit.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*     */         try {
/* 125 */           Desktop.getDesktop().browse(new URI("www.reddit.com/r/diamondhunt"));
/*     */         }
/*     */         catch (IOException localIOException)
/*     */         {
/*     */         }
/*     */         catch (URISyntaxException localURISyntaxException)
/*     */         {
/*     */         }
/*     */       }
/*     */     });
/* 131 */     reddit.setSize(80, 20);
/*     */ 
/* 134 */     reddit.setBackground(Color.darkGray);
/* 135 */     reddit.setForeground(Color.yellow);
/* 136 */     setLayer(reddit, 2);
/* 137 */     add(reddit);
/*     */ 
/* 139 */     diamondStats.setBackground(Color.darkGray);
/* 140 */     diamondStats.setForeground(Color.yellow);
/* 141 */     setLayer(diamondStats, 2);
/* 142 */     add(diamondStats);
/*     */ 
/* 144 */     JButton logout = new JButton("Log out");
/* 145 */     logout.setSize(80, 20);
/*     */ 
/* 147 */     logout.setBackground(Color.darkGray);
/* 148 */     logout.setForeground(Color.yellow);
/* 149 */     logout.addActionListener(Listeners.logout);
/* 150 */     setLayer(logout, 2);
/* 151 */     add(logout);
/*     */   }
/*     */ 
/*     */   public void toggleSettings() {
/* 155 */     if (this.settingsIsOpen) {
/* 156 */       this.settingsIsOpen = false;
/*     */     }
/*     */     else {
/* 159 */       this.settingsIsOpen = true;
/*     */     }
/*     */ 
/* 162 */     setVisible(this.settingsIsOpen);
/*     */ 
/* 164 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void forceClose()
/*     */   {
/* 169 */     this.settingsIsOpen = false;
/* 170 */     setVisible(this.settingsIsOpen);
/* 171 */     revalidate();
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.SettingsGUI
 * JD-Core Version:    0.6.2
 */