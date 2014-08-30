/*     */ package Game;
/*     */ 
/*     */ import GUI.Chat;
/*     */ import GUI.GUI;
/*     */ import GUI.GamePanel;
/*     */ import GUI.LaunchPanel;
/*     */ import connections.ClientNetwork;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import maps.AreaList;
/*     */ import players.Config;
/*     */ import players.Player;
/*     */ import players.PlayerList;
/*     */ 
/*     */ public class Listeners
/*     */ {
/*  21 */   static int rightClickCounter = 0;
/*  22 */   static int x1 = -1;
/*  23 */   static int y1 = -1;
/*     */ 
/*  25 */   public static ActionListener loginClicked = new ActionListener()
/*     */   {
/*     */     public void actionPerformed(ActionEvent e)
/*     */     {
/*  31 */       if (GUI.getInstance().getLaunchPanel().getNewUsername().length() > 0)
/*     */       {
/*  33 */         ClientNetwork clientNetwork = new ClientNetwork();
/*  34 */         String errorMessage = clientNetwork.attemptingToConnectNewAccount(GUI.getInstance().getLaunchPanel().getNewUsername(), GUI.getInstance().getLaunchPanel().getNewPassword(), GUI.getInstance().getLaunchPanel().getConfirmedPassword());
/*  35 */         GUI.getInstance().getLaunchPanel().setErrorMessage(errorMessage);
/*     */       }
/*     */       else
/*     */       {
/*  39 */         ClientNetwork clientNetwork = new ClientNetwork();
/*  40 */         String errorMessage = clientNetwork.attemptingToConnect(GUI.getInstance().getLaunchPanel().getUsername(), GUI.getInstance().getLaunchPanel().getPassword());
/*  41 */         GUI.getInstance().getLaunchPanel().setErrorMessage(errorMessage);
/*     */       }
/*     */     }
/*  25 */   };
/*     */ 
/*  47 */   public static MouseListener gamePanelMouseClick = new MouseListener()
/*     */   {
/*     */     public void mouseReleased(MouseEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mousePressed(MouseEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mouseExited(MouseEvent e) {
/*     */     }
/*     */ 
/*     */     public void mouseEntered(MouseEvent e) {
/*     */     }
/*     */ 
/*     */     public void mouseClicked(MouseEvent e) {
/*  64 */       if ((e.getX() >= 20) && (e.getY() <= 539) && (e.getX() <= 519) && (e.getY() >= 441)) {
/*  65 */         GamePanel.getInstance().getChat().toggleMouseOverChat();
/*     */       }
/*     */ 
/*  68 */       if (e.getButton() == 3)
/*     */       {
/*  71 */         if ((Listeners.x1 == -1) && (Listeners.y1 == -1))
/*     */         {
/*  74 */           Listeners.x1 = e.getX();
/*     */ 
/*  76 */           if (Listeners.x1 <= 7) {
/*  77 */             Listeners.x1 = -10;
/*     */           }
/*  79 */           Listeners.y1 = e.getY();
/*     */ 
/*  81 */           if (Listeners.y1 >= 566)
/*  82 */             Listeners.y1 = 600;
/*     */         }
/*     */         else
/*     */         {
/*  86 */           int x2 = e.getX();
/*  87 */           int y2 = e.getY();
/*     */ 
/*  89 */           if (x2 >= 790) {
/*  90 */             x2 = 805;
/*     */           }
/*  92 */           if (y2 <= 5) {
/*  93 */             y2 = -5;
/*     */           }
/*  95 */           String areaNotWalkable = ".getWalkable().add(new Walkable(" + Listeners.x1 + ", " + Listeners.y1 + ", " + x2 + ", " + y2 + "));";
/*  96 */           System.out.println(areaNotWalkable);
/*  97 */           Config.notWalkableAreas.add(areaNotWalkable);
/*  98 */           Listeners.x1 = -1;
/*  99 */           Listeners.y1 = -1;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 104 */       System.out.println("X: " + e.getX() + " Y: " + e.getY());
/*     */     }
/*  47 */   };
/*     */ 
/* 107 */   public static KeyListener keyboardInput = new KeyListener()
/*     */   {
/* 109 */     private final Set<Integer> pressed = new HashSet();
/*     */ 
/*     */     public void keyTyped(KeyEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void keyReleased(KeyEvent e)
/*     */     {
/* 117 */       if (e.getKeyCode() == 9) {
/* 118 */         GamePanel.getInstance().getChat().setViewChatHistory(false);
/*     */       }
/* 120 */       if ((e.getKeyCode() == 40) || (e.getKeyCode() == 38) || (e.getKeyCode() == 37) || (e.getKeyCode() == 39)) {
/* 121 */         this.pressed.remove(Integer.valueOf(e.getKeyCode()));
/*     */       }
/* 123 */       if (this.pressed.size() <= 0) {
/* 124 */         Config.playerIsMoving = false;
/*     */       }
/*     */       else
/*     */       {
/* 128 */         String direction = null;
/*     */ 
/* 130 */         for (Iterator localIterator = this.pressed.iterator(); localIterator.hasNext(); ) { int key = ((Integer)localIterator.next()).intValue();
/*     */ 
/* 132 */           if (key == 40) {
/* 133 */             direction = "down";
/*     */           }
/* 135 */           if (key == 38) {
/* 136 */             direction = "up";
/*     */           }
/* 138 */           if (key == 37)
/*     */           {
/* 140 */             direction = "left";
/* 141 */             PlayerList.getInstance().getPlayer(Config.USERNAME).setLastDirection("left");
/*     */           }
/*     */ 
/* 144 */           if (key == 39)
/*     */           {
/* 146 */             direction = "right";
/* 147 */             PlayerList.getInstance().getPlayer(Config.USERNAME).setLastDirection("right");
/*     */           }
/*     */         }
/*     */ 
/* 151 */         Config.lastPlayerDirection = direction;
/*     */       }
/*     */     }
/*     */ 
/*     */     public void keyPressed(KeyEvent e)
/*     */     {
/* 157 */       boolean isChatting = true;
/* 158 */       String direction = null;
/* 159 */       if ((e.getKeyCode() == 40) || (e.getKeyCode() == 38) || (e.getKeyCode() == 37) || (e.getKeyCode() == 39))
/*     */       {
/* 161 */         this.pressed.add(Integer.valueOf(e.getKeyCode()));
/* 162 */         Config.playerIsMoving = true;
/* 163 */         isChatting = false;
/*     */       }
/*     */ 
/* 167 */       if (this.pressed.size() > 1)
/*     */       {
/* 169 */         boolean topArrow = false;
/* 170 */         boolean bottomArrow = false;
/* 171 */         boolean leftArrow = false;
/* 172 */         boolean rightArrow = false;
/*     */ 
/* 174 */         for (Iterator localIterator = this.pressed.iterator(); localIterator.hasNext(); ) { int keyCode = ((Integer)localIterator.next()).intValue();
/*     */ 
/* 176 */           if (keyCode == 39)
/* 177 */             rightArrow = true;
/* 178 */           if (keyCode == 37)
/* 179 */             leftArrow = true;
/* 180 */           if (keyCode == 40)
/* 181 */             bottomArrow = true;
/* 182 */           if (keyCode == 38) {
/* 183 */             topArrow = true;
/*     */           }
/*     */         }
/* 186 */         if ((topArrow) && (leftArrow)) {
/* 187 */           direction = "topLeft";
/*     */         }
/* 189 */         if ((topArrow) && (rightArrow)) {
/* 190 */           direction = "topRight";
/*     */         }
/* 192 */         if ((bottomArrow) && (rightArrow)) {
/* 193 */           direction = "downRight";
/*     */         }
/* 195 */         if ((bottomArrow) && (leftArrow))
/* 196 */           direction = "downLeft";
/*     */       }
/*     */       else
/*     */       {
/* 200 */         if (e.getKeyCode() == 40) {
/* 201 */           direction = "down";
/*     */         }
/* 203 */         if (e.getKeyCode() == 38) {
/* 204 */           direction = "up";
/*     */         }
/* 206 */         if (e.getKeyCode() == 37)
/*     */         {
/* 208 */           direction = "left";
/* 209 */           PlayerList.getInstance().getPlayer(Config.USERNAME).setLastDirection("left");
/*     */         }
/*     */ 
/* 212 */         if (e.getKeyCode() == 39)
/*     */         {
/* 214 */           direction = "right";
/* 215 */           PlayerList.getInstance().getPlayer(Config.USERNAME).setLastDirection("right");
/*     */         }
/*     */       }
/*     */ 
/* 219 */       Config.lastPlayerDirection = direction;
/*     */ 
/* 222 */       if (e.getKeyCode() == 17)
/*     */       {
/* 224 */         AreaList.applyPlayerAction(PlayerList.getInstance().getPlayer(Config.USERNAME).getPlayerAction());
/*     */       }
/*     */ 
/* 229 */       if (e.getKeyCode() == 9) {
/* 230 */         GamePanel.getInstance().getChat().setViewChatHistory(true);
/*     */       }
/*     */ 
/* 233 */       if (isChatting)
/*     */       {
/* 236 */         if ((e.getKeyCode() == 9) || (e.getKeyCode() == 92) || (e.getKeyCode() == 16) || (e.getKeyCode() == 18) || (e.getKeyCode() == 17) || (e.getKeyCode() == 20) || (e.getKeyCode() == 524) || (e.getKeyCode() == 112) || (e.getKeyCode() == 113) || (e.getKeyCode() == 114) || (e.getKeyCode() == 115) || (e.getKeyCode() == 116) || (e.getKeyCode() == 117) || (e.getKeyCode() == 118) || (e.getKeyCode() == 119) || (e.getKeyCode() == 120) || (e.getKeyCode() == 121) || (e.getKeyCode() == 122) || (e.getKeyCode() == 123) || (e.getKeyCode() == 144) || (e.getKeyCode() == 35) || (e.getKeyCode() == 155) || (e.getKeyCode() == 144) || (e.getKeyCode() == 36) || (e.getKeyCode() == 33) || (e.getKeyCode() == 145) || (e.getKeyCode() == 19) || (e.getKeyCode() == 525))
/*     */         {
/* 238 */           return;
/*     */         }
/* 240 */         if (e.getKeyCode() == 8) {
/* 241 */           GamePanel.getInstance().getChat().applyBackSpace();
/* 242 */         } else if (e.getKeyCode() == 10)
/*     */         {
/* 244 */           GamePanel.getInstance().getChat().sendChatToServer();
/*     */         }
/*     */         else
/*     */         {
/* 248 */           char letterTyped = e.getKeyChar();
/* 249 */           GamePanel.getInstance().getChat().appendToChat(String.valueOf(letterTyped));
/*     */         }
/*     */       }
/*     */     }
/* 107 */   };
/*     */ 
/* 257 */   public static MouseListener inventoryMenu = new MouseListener()
/*     */   {
/*     */     public void mouseReleased(MouseEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mousePressed(MouseEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mouseExited(MouseEvent e) {
/* 268 */       GamePanel.getInstance().resetBackground("inventory");
/*     */     }
/*     */ 
/*     */     public void mouseEntered(MouseEvent e) {
/* 272 */       GamePanel.getInstance().changeBackgroundMenu("inventory");
/*     */     }
/*     */ 
/*     */     public void mouseClicked(MouseEvent e) {
/* 276 */       GamePanel.getInstance().toggleInventory();
/*     */     }
/* 257 */   };
/*     */ 
/* 280 */   public static MouseListener skillsMenu = new MouseListener()
/*     */   {
/*     */     public void mouseReleased(MouseEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mousePressed(MouseEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mouseExited(MouseEvent e) {
/* 291 */       GamePanel.getInstance().resetBackground("skills");
/*     */     }
/*     */ 
/*     */     public void mouseEntered(MouseEvent e) {
/* 295 */       GamePanel.getInstance().changeBackgroundMenu("skills");
/*     */     }
/*     */ 
/*     */     public void mouseClicked(MouseEvent e) {
/* 299 */       GamePanel.getInstance().toggleSkills();
/*     */     }
/* 280 */   };
/*     */ 
/* 304 */   public static MouseListener settingsMenu = new MouseListener()
/*     */   {
/*     */     public void mouseReleased(MouseEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mousePressed(MouseEvent e)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mouseExited(MouseEvent e) {
/* 315 */       GamePanel.getInstance().resetBackground("settings");
/*     */     }
/*     */ 
/*     */     public void mouseEntered(MouseEvent e) {
/* 319 */       GamePanel.getInstance().changeBackgroundMenu("settings");
/*     */     }
/*     */ 
/*     */     public void mouseClicked(MouseEvent e) {
/* 323 */       GamePanel.getInstance().toggleSettings();
/*     */     }
/* 304 */   };
/*     */ 
/* 328 */   public static MouseListener mouseInput = new MouseListener()
/*     */   {
/*     */     public void mouseReleased(MouseEvent e) {
/* 331 */       System.out.println("mouse listener");
/*     */     }
/*     */ 
/*     */     public void mousePressed(MouseEvent e) {
/* 335 */       System.out.println("mouse listener");
/*     */     }
/*     */ 
/*     */     public void mouseExited(MouseEvent e) {
/* 339 */       System.out.println("mouse listener");
/*     */     }
/*     */ 
/*     */     public void mouseEntered(MouseEvent e) {
/* 343 */       System.out.println("mouse listener");
/*     */     }
/*     */ 
/*     */     public void mouseClicked(MouseEvent e) {
/* 347 */       System.out.println("mouse listener");
/*     */     }
/* 328 */   };
/*     */ 
/* 351 */   public static ActionListener logout = new ActionListener()
/*     */   {
/*     */     public void actionPerformed(ActionEvent e)
/*     */     {
/* 356 */       System.exit(0);
/*     */     }
/* 351 */   };
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     Game.Listeners
 * JD-Core Version:    0.6.2
 */