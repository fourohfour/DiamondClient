/*     */ package GUI;
/*     */ 
/*     */ import connections.Command;
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JPanel;
/*     */ import players.Config;
/*     */ import players.Player;
/*     */ import players.PlayerList;
/*     */ 
/*     */ public class Chat extends JPanel
/*     */ {
/*  25 */   private String chatClient = "";
/*     */ 
/*  27 */   private ArrayList<String> chatHistory = new ArrayList();
/*  28 */   private ArrayList<String> serverMessages = new ArrayList();
/*  29 */   boolean mouseOverChat = false;
/*     */ 
/*  31 */   private boolean viewChatHistory = false;
/*     */ 
/*     */   public Chat()
/*     */   {
/*  35 */     init();
/*     */   }
/*     */ 
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/*  41 */     Graphics2D g2d = (Graphics2D)g;
/*     */ 
/*  43 */     if (!this.mouseOverChat)
/*     */     {
/*  45 */       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); g2d.setComposite(AlphaComposite.getInstance(3, 0.3F));
/*     */     }
/*     */     else
/*     */     {
/*  49 */       g2d.setComposite(AlphaComposite.getInstance(3, 0.9F));
/*     */     }
/*     */ 
/*  52 */     g2d.setColor(Color.BLACK);
/*     */ 
/*  54 */     if (this.viewChatHistory)
/*     */     {
/*  56 */       g2d.fillRect(0, 0, 500, 300);
/*  57 */       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
/*  58 */       g.setColor(Color.black);
/*     */     }
/*     */     else
/*     */     {
/*  62 */       g2d.fillRect(0, 0, 500, 100);
/*     */ 
/*  65 */       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); g2d.setComposite(AlphaComposite.getInstance(3, 0.3F));
/*  66 */       g2d.setColor(Color.YELLOW);
/*  67 */       g2d.fillRect(0, 105, 500, 20);
/*     */ 
/*  69 */       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
/*  70 */       g.setColor(Color.black);
/*     */ 
/*  73 */       g.drawString(Config.USERNAME + ": " + this.chatClient, 5, 120);
/*     */     }
/*     */ 
/*  79 */     g.setColor(Color.white);
/*  80 */     paintChatHistory(g);
/*     */   }
/*     */ 
/*     */   private void paintChatHistory(Graphics g)
/*     */   {
/*  86 */     Font font = new Font("System", 1, 13);
/*  87 */     g.setFont(font);
/*     */ 
/*  89 */     BufferedImage icon = null;
/*  90 */     String yellMessage = null;
/*  91 */     String chatMessage = null;
/*     */ 
/*  93 */     int x = 5;
/*  94 */     int y = 96;
/*     */ 
/*  96 */     if (this.viewChatHistory)
/*     */     {
/*  98 */       x = 5;
/*  99 */       y = 290;
/*     */     }
/*     */ 
/* 102 */     for (int i = this.serverMessages.size() - 1; i >= 0; i--)
/*     */     {
/* 105 */       if (((String)this.serverMessages.get(i)).startsWith("yell="))
/*     */       {
/* 108 */         yellMessage = ((String)this.serverMessages.get(i)).substring(5);
/*     */ 
/* 110 */         if (yellMessage.startsWith("[OWNER]"))
/*     */         {
/* 112 */           yellMessage = yellMessage.substring(7);
/*     */           try {
/* 114 */             icon = ImageIO.read(new File("cache/graphics/icons/ownercrown.png"));
/*     */           } catch (IOException e) {
/* 116 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         }
/* 120 */         else if (yellMessage.startsWith("[MEMBERS]"))
/*     */         {
/* 122 */           yellMessage = yellMessage.substring(9);
/*     */           try {
/* 124 */             icon = ImageIO.read(new File("cache/graphics/icons/members.png"));
/*     */           } catch (IOException e) {
/* 126 */             e.printStackTrace();
/*     */           }
/*     */ 
/*     */         }
/* 130 */         else if (yellMessage.startsWith("[ULTRA]"))
/*     */         {
/* 132 */           yellMessage = yellMessage.substring(7);
/*     */           try {
/* 134 */             icon = ImageIO.read(new File("cache/graphics/icons/ultramembers.png"));
/*     */           } catch (IOException e) {
/* 136 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 141 */       if (((String)this.serverMessages.get(i)).startsWith("loggedinmsg="))
/*     */       {
/* 143 */         yellMessage = ((String)this.serverMessages.get(i)).substring(12);
/* 144 */         g.setColor(Color.ORANGE);
/*     */       }
/* 146 */       if (((String)this.serverMessages.get(i)).startsWith("red="))
/*     */       {
/* 148 */         yellMessage = ((String)this.serverMessages.get(i)).substring(4);
/* 149 */         g.setColor(Color.RED);
/*     */       }
/* 151 */       if (((String)this.serverMessages.get(i)).startsWith("green="))
/*     */       {
/* 153 */         yellMessage = ((String)this.serverMessages.get(i)).substring(6);
/* 154 */         g.setColor(Color.GREEN);
/*     */       }
/* 156 */       if (((String)this.serverMessages.get(i)).startsWith("purple="))
/*     */       {
/* 158 */         yellMessage = ((String)this.serverMessages.get(i)).substring(7);
/* 159 */         g.setColor(Color.CYAN);
/*     */       }
/* 161 */       if (((String)this.serverMessages.get(i)).startsWith("[MEMBERS]"))
/*     */       {
/* 163 */         chatMessage = ((String)this.serverMessages.get(i)).substring(9);
/*     */         try {
/* 165 */           icon = ImageIO.read(new File("cache/graphics/icons/members.png"));
/*     */         } catch (IOException e) {
/* 167 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 170 */       if (((String)this.serverMessages.get(i)).startsWith("[ULTRA]"))
/*     */       {
/* 172 */         chatMessage = ((String)this.serverMessages.get(i)).substring(7);
/*     */         try {
/* 174 */           icon = ImageIO.read(new File("cache/graphics/icons/ultramembers.png"));
/*     */         } catch (IOException e) {
/* 176 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 179 */       if (((String)this.serverMessages.get(i)).startsWith("[OWNER]"))
/*     */       {
/* 181 */         chatMessage = ((String)this.serverMessages.get(i)).substring(7);
/*     */         try {
/* 183 */           icon = ImageIO.read(new File("cache/graphics/icons/ownercrown.png"));
/*     */         } catch (IOException e) {
/* 185 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */ 
/* 189 */       if (yellMessage != null)
/*     */       {
/* 191 */         if (icon != null)
/*     */         {
/* 193 */           g.drawImage(icon, x, y - 12, null);
/* 194 */           g.drawString(yellMessage, x + 20, y);
/* 195 */           icon = null;
/*     */         }
/*     */         else {
/* 198 */           g.drawString(yellMessage, x, y);
/*     */         }
/*     */       }
/* 201 */       else if (chatMessage != null)
/*     */       {
/* 203 */         if (icon != null)
/*     */         {
/* 205 */           g.drawImage(icon, x, y - 12, null);
/* 206 */           g.drawString(chatMessage, x + 20, y);
/* 207 */           icon = null;
/* 208 */           chatMessage = null;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 213 */         g.drawString((String)this.serverMessages.get(i), x, y);
/*     */       }
/* 215 */       g.setColor(Color.WHITE);
/* 216 */       y -= 15;
/*     */ 
/* 218 */       yellMessage = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/* 225 */     setLayout(null);
/* 226 */     setBounds(20, 440, 500, 150);
/*     */   }
/*     */ 
/*     */   public void setClientChat(String chat)
/*     */   {
/* 242 */     this.chatClient = chat;
/*     */   }
/*     */ 
/*     */   public void appendToChat(String letter)
/*     */   {
/* 247 */     this.chatClient += letter;
/*     */   }
/*     */ 
/*     */   public void applyBackSpace()
/*     */   {
/* 252 */     if (this.chatClient.length() > 0)
/* 253 */       this.chatClient = this.chatClient.substring(0, this.chatClient.length() - 1);
/*     */   }
/*     */ 
/*     */   public void sendChatToServer()
/*     */   {
/* 258 */     if (this.chatClient.length() > 0)
/*     */     {
/* 260 */       if (this.chatClient.startsWith("/command"))
/* 261 */         GamePanel.getInstance().startUpMessage();
/* 262 */       if (this.chatClient.equals("/brew"))
/* 263 */         GamePanel.getInstance().openBrewingInterface();
/* 264 */       if (this.chatClient.equals("/stuck"))
/* 265 */         Command.getInstance().teleportPlayer(0, 173, 445);
/* 266 */       if (!this.chatClient.startsWith("/")) {
/* 267 */         PlayerList.getInstance().getPlayer(Config.USERNAME).setChat(this.chatClient);
/*     */       }
/* 269 */       if (this.chatClient.startsWith("//"))
/*     */       {
/* 271 */         Config.mapName = this.chatClient.substring(2);
/* 272 */         Config.saveNotWalkableToFile();
/*     */       }
/*     */ 
/* 276 */       if (this.chatClient.startsWith("~"))
/*     */       {
/* 278 */         GamePanel.getInstance().openBrewingInterface();
/*     */       }
/*     */ 
/* 281 */       Command.getInstance().sendCommand("chat", "message=" + this.chatClient + ";");
/*     */     }
/*     */ 
/* 284 */     this.chatClient = "";
/*     */   }
/*     */ 
/*     */   public void addToChatBox(String s, String type)
/*     */   {
/* 289 */     if (s.equals(" ")) {
/* 290 */       return;
/*     */     }
/* 292 */     if (type.equals("regular player"))
/*     */     {
/* 294 */       boolean existsInArrayList = false;
/*     */ 
/* 296 */       for (String history : this.chatHistory)
/*     */       {
/* 298 */         if (history.equalsIgnoreCase(s)) {
/* 299 */           existsInArrayList = true;
/*     */         }
/*     */       }
/* 302 */       if (!existsInArrayList)
/* 303 */         this.chatHistory.add(s);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addServerMessage(String message, String type)
/*     */   {
/* 319 */     this.serverMessages.add(message);
/*     */ 
/* 321 */     if (this.serverMessages.size() > 40) {
/* 322 */       this.serverMessages.remove(0);
/*     */     }
/* 324 */     System.out.println(this.serverMessages.size());
/*     */   }
/*     */ 
/*     */   public String getLastServerMessage()
/*     */   {
/* 329 */     if (this.serverMessages.size() > 0) {
/* 330 */       return (String)this.serverMessages.get(this.serverMessages.size() - 1);
/*     */     }
/* 332 */     return null;
/*     */   }
/*     */ 
/*     */   public void toggleMouseOverChat()
/*     */   {
/* 337 */     if (this.mouseOverChat)
/* 338 */       this.mouseOverChat = false;
/*     */     else
/* 340 */       this.mouseOverChat = true;
/*     */   }
/*     */ 
/*     */   public void setViewChatHistory(boolean b)
/*     */   {
/* 345 */     if (!b)
/* 346 */       setBounds(20, 440, 500, 150);
/*     */     else {
/* 348 */       setBounds(20, 250, 500, 300);
/*     */     }
/* 350 */     this.viewChatHistory = b;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.Chat
 * JD-Core Version:    0.6.2
 */