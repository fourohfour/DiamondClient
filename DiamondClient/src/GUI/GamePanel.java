/*     */ package GUI;
/*     */ 
/*     */ import GUI.bank.BankGUI;
/*     */ import GUI.brewing.BrewingGUI;
/*     */ import GUI.smithing.SmithingGUI;
/*     */ import Game.Listeners;
/*     */ import connections.Command;
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Color;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import maps.ActionSpace;
/*     */ import maps.Area;
/*     */ import maps.AreaList;
/*     */ import npc.GroundItem;
/*     */ import npc.GroundItemList;
/*     */ import npc.NPC;
/*     */ import npc.NPCList;
/*     */ import players.Config;
/*     */ import players.Item;
/*     */ import players.ItemList;
/*     */ import players.Player;
/*     */ import players.PlayerList;
/*     */ import players.Skill;
/*     */ import players.SkillList;
/*     */ 
/*     */ public class GamePanel extends JPanel
/*     */ {
/*  47 */   private static GamePanel gamePanel = null;
/*  48 */   private BufferedImage backgroundAreaIMG = null;
/*  49 */   private boolean backgroundImageLoaded = false;
/*     */ 
/*  51 */   private int lastMapId = -1;
/*     */ 
/*  53 */   Chat chat = null;
/*     */ 
/*  56 */   private boolean gameLoading = false;
/*     */ 
/*  59 */   private Color backgroundColor = Color.decode("#CECEDE");
/*  60 */   private Color backgroundColorHover = Color.decode("#FFFFFF");
/*     */ 
/*  63 */   private JPanel inventoryButtonPanel = null;
/*  64 */   private JPanel skillsButtonPanel = null;
/*  65 */   private JPanel settingsButtonPanel = null;
/*     */ 
/*  68 */   private InventoryGUI inventoryPanel = null;
/*  69 */   private SkillsGUI skillsPanel = null;
/*  70 */   private SettingsGUI settingsPanel = null;
/*     */ 
/*  73 */   private BankGUI bankPanel = null;
/*     */ 
/*  75 */   private int playerRefreshCounter = 0;
/*     */ 
/*  78 */   private JButton retreatFromCombatButton = null;
/*     */   BufferedImage actionIMG;
/*     */   BufferedImage hitSplat0IMG;
/*     */   BufferedImage hitSplatIMG;
/*     */   private ShopGui shopGui;
/*  89 */   ArrayList<JLabel> itemsDroppedLBL = new ArrayList();
/*     */   private JPanel shrimpFishingSpotMap3;
/*  95 */   private boolean firstLogin = true;
/*  96 */   private int counterForXp = 0;
/*  97 */   private int lastXpToDraw = 0;
/*  98 */   private String xpDif = "";
/*     */ 
/*     */   private GamePanel()
/*     */   {
/* 104 */     setLayout(null);
/*     */   }
/*     */ 
/*     */   public static GamePanel getInstance()
/*     */   {
/* 109 */     if (gamePanel == null) {
/* 110 */       gamePanel = new GamePanel();
/*     */     }
/* 112 */     return gamePanel;
/*     */   }
/*     */ 
/*     */   public void refreshRetreatButton()
/*     */   {
/* 118 */     Player p = PlayerList.getInstance().getPlayer(Config.USERNAME);
/*     */ 
/* 120 */     if (p.isInCombat())
/*     */     {
/* 122 */       if (p.getY() < 60)
/* 123 */         this.retreatFromCombatButton.setBounds(p.getX() - 30, p.getY() + 70, 70, 25);
/*     */       else
/* 125 */         this.retreatFromCombatButton.setBounds(p.getX() - 30, p.getY() - 30, 70, 25);
/* 126 */       this.retreatFromCombatButton.setVisible(true);
/*     */     }
/*     */     else {
/* 129 */       this.retreatFromCombatButton.setVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/* 135 */     super.paintComponent(g);
/*     */ 
/* 138 */     Player player = null;
/* 139 */     Font font = new Font("System", 1, 15);
/* 140 */     g.setFont(font);
/*     */ 
/* 143 */     if (!this.gameLoading)
/*     */     {
/* 146 */       player = PlayerList.getInstance().getLocalPlayer();
/*     */ 
/* 149 */       if (this.lastMapId != player.getPlayerMapId()) {
/* 150 */         loadArea(player.getPlayerMapId());
/*     */       }
/* 152 */       this.lastMapId = player.getPlayerMapId();
/* 153 */       g.drawImage(this.backgroundAreaIMG, 0, 0, null);
/*     */ 
/* 156 */       if ((player.getPlayerMapId() == 5) && (player.getFlagValue("fixedBridgeCamp2") != null))
/*     */       {
/* 158 */         g.setColor(Color.orange);
/* 159 */         g.fillRect(700, 269, 95, 40);
/* 160 */         g.setColor(Color.black);
/*     */       }
/*     */ 
/* 164 */       if (Config.debugMode)
/*     */       {
/* 166 */         g.setColor(Color.red);
/* 167 */         g.drawString("X: " + player.getX() + " ", 700, 500);
/* 168 */         g.drawString("Y: " + player.getY() + " ", 700, 530);
/* 169 */         g.setColor(Color.black);
/*     */       }
/*     */ 
/* 173 */       if ((player.getXpDifference() > 0) || (this.counterForXp > 0))
/*     */       {
/* 176 */         if (!this.firstLogin)
/*     */         {
/* 178 */           if ((player.getXpDifference() > 0) && (this.counterForXp > 0))
/*     */           {
/* 180 */             this.lastXpToDraw += player.getXpDifference();
/*     */           }
/*     */ 
/* 183 */           if (this.lastXpToDraw == 0)
/*     */           {
/* 185 */             this.lastXpToDraw = player.getXpDifference();
/* 186 */             this.counterForXp = 100;
/*     */           }
/*     */ 
/* 189 */           int x = player.getX();
/* 190 */           int y = player.getY();
/*     */ 
/* 192 */           this.xpDif = ("+ " + this.lastXpToDraw + "XP");
/* 193 */           player.setXpDifference(0);
/* 194 */           this.counterForXp -= 1;
/* 195 */           if (this.counterForXp == 0)
/*     */           {
/* 197 */             this.lastXpToDraw = 0;
/*     */           }
/*     */ 
/* 200 */           g.setColor(Color.green);
/* 201 */           g.drawString(this.xpDif, x, y + 20);
/* 202 */           g.setColor(Color.black);
/*     */         }
/*     */         else
/*     */         {
/* 206 */           player.setXpDifference(0);
/* 207 */           this.firstLogin = false;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 214 */       g.setColor(Color.YELLOW);
/* 215 */       g.drawString(AreaList.getInstance().getArea(player.getPlayerMapId()).getMapName(), 117, 16);
/* 216 */       g.setColor(Color.BLACK);
/*     */ 
/* 220 */       List<Player> players = PlayerList.getInstance().getPlayers();
/* 221 */       for (Player p : players)
/*     */       {
/* 223 */         if ((p.isLoggedIn()) && (p.getPlayerMapId() == PlayerList.getInstance().getPlayer(Config.USERNAME).getPlayerMapId()))
/*     */         {
/* 225 */           refreshPaintPlayerPosition(g, p);
/* 226 */           refreshPaintPlayerCombat(g, p);
/* 227 */           refreshPaintPlayerChat(g, p);
/* 228 */           refreshPaintPlayerLabels(g, p);
/* 229 */           refreshPaintPlayerBubble(g, p);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 234 */       for (NPC n : NPCList.getInstance().getNPCS())
/*     */       {
/* 236 */         if ((PlayerList.getInstance().getPlayer(Config.USERNAME).getPlayerMapId() == n.getMapId()) && (n.isSpawned()))
/*     */         {
/* 238 */           int x = n.getPosX();
/* 239 */           int y = n.getPosY();
/* 240 */           int width = n.getGraphic().getWidth();
/* 241 */           int height = n.getGraphic().getHeight();
/*     */ 
/* 243 */           int npcCombatLevel = n.getLevel();
/* 244 */           int playerCombatLevel = -1;
/* 245 */           String npcTitle = n.getName() + " - " + npcCombatLevel;
/*     */ 
/* 247 */           for (Skill s : SkillList.getInstance().getSkills())
/*     */           {
/* 249 */             if (s.getName().equalsIgnoreCase("combat"))
/*     */             {
/* 251 */               playerCombatLevel = s.getLevel();
/*     */             }
/*     */           }
/*     */ 
/* 255 */           int levelDif = playerCombatLevel - npcCombatLevel;
/*     */ 
/* 257 */           if (levelDif <= -30)
/* 258 */             g.setColor(Color.decode("#4C0000"));
/* 259 */           else if (levelDif <= -8)
/* 260 */             g.setColor(Color.red);
/* 261 */           else if (levelDif <= 0)
/* 262 */             g.setColor(Color.orange);
/* 263 */           else if (levelDif > 0)
/* 264 */             g.setColor(Color.yellow);
/* 265 */           else if (levelDif >= 10) {
/* 266 */             g.setColor(Color.green);
/*     */           }
/*     */ 
/* 270 */           g.setColor(Color.black);
/*     */ 
/* 272 */           BufferedImage npcImage = null;
/* 273 */           width = n.getGraphic().getWidth();
/*     */ 
/* 275 */           if (n.getLastDirection().equalsIgnoreCase("right"))
/* 276 */             npcImage = n.getGraphic();
/* 277 */           else if (n.getLastDirection().equalsIgnoreCase("left"))
/* 278 */             npcImage = getFlippedImage(n.getGraphic());
/*     */           else {
/* 280 */             npcImage = n.getGraphic();
/*     */           }
/* 282 */           g.drawString(npcTitle, n.getPosX(), n.getPosY());
/* 283 */           g.drawImage(npcImage, x, y, width, height, null);
/*     */ 
/* 285 */           if (n.isInCombat())
/*     */           {
/* 287 */             int widthHealthBar = 45;
/*     */ 
/* 290 */             double perc = (n.getCurrentHP()) / (n.getMaxHP());
/* 291 */             int widthDamage = (int)(widthHealthBar - perc * widthHealthBar);
/* 292 */             g.setColor(Color.GREEN);
/* 293 */             g.fillRect(x, n.getPosY() - 20, widthHealthBar, 8);
/* 294 */             g.setColor(Color.RED);
/* 295 */             g.fillRect(x + widthHealthBar - widthDamage, n.getPosY() - 20, widthDamage, 8);
/* 296 */             g.setColor(Color.black);
/*     */ 
/* 299 */             if (n.getLastHitTaken() != -1)
/*     */             {
/* 301 */               if (n.getLastHitTaken() > 0)
/* 302 */                 g.drawImage(this.hitSplatIMG, x, y, null);
/*     */               else {
/* 304 */                 g.drawImage(this.hitSplat0IMG, x, y, null);
/*     */               }
/* 306 */               g.setColor(Color.white);
/* 307 */               g.drawString(String.valueOf(n.getLastHitTaken()), x + 10, y + 17);
/* 308 */               g.setColor(Color.black);
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 318 */       if ((player.getPlayerAction().length() > 0) && (player.getBubbleItemId() == -1))
/*     */       {
/* 320 */         g.drawImage(this.actionIMG, player.getX(), player.getY() - 60, null);
/* 321 */         if (player.getPlayerMapId() == 0)
/*     */         {
/* 323 */           g.setColor(Color.WHITE);
/* 324 */           g.fillRect(player.getX() + 20, player.getY() - 80, 200, 25);
/* 325 */           g.setColor(Color.RED);
/* 326 */           g.drawString("HIT 'CTRL' TO TRIGGER AN ACTION", player.getX() + 20, player.getY() - 60);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 334 */       g.setColor(Color.BLACK);
/* 335 */       g.setFont(new Font("default", 1, 40));
/* 336 */       g.fillRect(0, 0, 800, 600);
/* 337 */       g.setColor(Color.WHITE);
/* 338 */       g.drawString("Loading...", 300, 300);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void loadListeners()
/*     */   {
/* 347 */     setFocusable(true);
/* 348 */     requestFocusInWindow();
/* 349 */     setFocusTraversalKeysEnabled(false);
/* 350 */     addKeyListener(Listeners.keyboardInput);
/* 351 */     addMouseListener(Listeners.gamePanelMouseClick);
/*     */   }
/*     */ 
/*     */   public void loadArea(int mapId)
/*     */   {
/*     */     try
/*     */     {
/* 360 */       this.backgroundAreaIMG = ImageIO.read(new File(AreaList.getInstance().getArea(mapId).getTerrainURL()));
/*     */     } catch (IOException e) {
/* 362 */       e.printStackTrace();
/* 363 */     }refreshGroundItems();
/* 364 */     repaint();
/*     */   }
/*     */ 
/*     */   public void refreshPaintPlayerChat(Graphics g, Player p)
/*     */   {
/* 369 */     if (p.getChat().length() > 0)
/*     */     {
/* 371 */       int chatPositionY = p.getY() - 4;
/*     */ 
/* 373 */       if (p.isInCombat()) {
/* 374 */         chatPositionY -= 35;
/*     */       }
/* 376 */       g.setColor(Color.YELLOW);
/* 377 */       g.drawString(p.getChat(), p.getX() - 10, chatPositionY);
/* 378 */       g.setColor(Color.BLACK);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void refreshPaintPlayerLabels(Graphics g, Player p)
/*     */   {
/* 385 */     if (p.getUsername().equalsIgnoreCase("smitty"))
/*     */     {
/* 387 */       BufferedImage crownImg = null;
/*     */       try
/*     */       {
/* 390 */         crownImg = ImageIO.read(new File("cache/graphics/icons/ownercrown.png")); } catch (IOException e) {
/* 391 */         e.printStackTrace();
/*     */       }
/* 393 */       if ((crownImg != null) && (!p.isInCombat()))
/* 394 */         g.drawImage(crownImg, p.getX() - 30, p.getY() - 4, null);
/*     */     }
/* 396 */     else if ((p.getPlayerRights() == 1) || (p.getPlayerRights() == 3))
/*     */     {
/* 398 */       BufferedImage crownImg = null;
/*     */       try
/*     */       {
/* 401 */         crownImg = ImageIO.read(new File("cache/graphics/icons/members.png")); } catch (IOException e) {
/* 402 */         e.printStackTrace();
/*     */       }
/* 404 */       if ((crownImg != null) && (!p.isInCombat()))
/* 405 */         g.drawImage(crownImg, p.getX() - 30, p.getY() - 4, null);
/*     */     }
/* 407 */     else if ((p.getPlayerRights() == 2) || (p.getPlayerRights() == 4))
/*     */     {
/* 409 */       BufferedImage crownImg = null;
/*     */       try
/*     */       {
/* 412 */         crownImg = ImageIO.read(new File("cache/graphics/icons/ultramembers.png")); } catch (IOException e) {
/* 413 */         e.printStackTrace();
/*     */       }
/* 415 */       if ((crownImg != null) && (!p.isInCombat())) {
/* 416 */         g.drawImage(crownImg, p.getX() - 30, p.getY() - 4, null);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 422 */     if (!p.isInCombat())
/* 423 */       g.drawString(p.getUsername() + " (" + p.getGlobaLevel() + ")", p.getX() - 10, p.getY() + 10);
/*     */   }
/*     */ 
/*     */   public void refreshPaintPlayerPosition(Graphics g, Player p)
/*     */   {
/* 431 */     int x = p.getX();
/* 432 */     int y = p.getY();
/*     */ 
/* 435 */     int width = 45;
/* 436 */     int height = 110;
/*     */ 
/* 438 */     BufferedImage playerImage = p.getPlayerGraphicPanel();
/*     */ 
/* 440 */     if (p.getLastDirection() != null)
/*     */     {
/* 442 */       if (p.getLastDirection().equalsIgnoreCase("right"))
/* 443 */         playerImage = p.getPlayerGraphicPanel();
/* 444 */       else if (p.getLastDirection().equalsIgnoreCase("left")) {
/* 445 */         playerImage = getFlippedImage(p.getPlayerGraphicPanel());
/*     */       }
/*     */     }
/* 448 */     g.drawImage(playerImage, x, y, width, height, null);
/*     */   }
/*     */ 
/*     */   public BufferedImage getFlippedImage(BufferedImage bi) {
/* 452 */     BufferedImage flipped = new BufferedImage(
/* 453 */       bi.getWidth(), 
/* 454 */       bi.getHeight(), 
/* 455 */       bi.getType());
/* 456 */     AffineTransform tran = AffineTransform.getTranslateInstance(bi.getWidth(), 0.0D);
/* 457 */     AffineTransform flip = AffineTransform.getScaleInstance(-1.0D, 1.0D);
/* 458 */     tran.concatenate(flip);
/*     */ 
/* 460 */     Graphics2D g = flipped.createGraphics();
/* 461 */     g.setTransform(tran);
/* 462 */     g.drawImage(bi, 0, 0, null);
/* 463 */     g.dispose();
/*     */ 
/* 465 */     return flipped;
/*     */   }
/*     */ 
/*     */   public void refreshPaintPlayerBubble(Graphics g, Player p)
/*     */   {
/* 470 */     if (p.getBubbleItemId() >= 0)
/*     */     {
/* 472 */       Graphics2D g2d = (Graphics2D)g;
/* 473 */       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); g2d.setComposite(AlphaComposite.getInstance(3, 0.7F));
/* 474 */       g2d.setColor(Color.GRAY);
/* 475 */       g2d.fillOval(p.getX() - 20, p.getY() - 80, 60, 60);
/* 476 */       g.drawImage(ItemList.getInstance().getItem(p.getBubbleItemId()).getImage(), p.getX() - 15, p.getY() - 75, null);
/* 477 */       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
/* 478 */       g2d.setColor(Color.BLACK);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void refreshPaintPlayerCombat(Graphics g, Player p) {
/* 483 */     int x = p.getX();
/* 484 */     int y = p.getY();
/*     */ 
/* 489 */     if (p.isInCombat())
/*     */     {
/* 491 */       int widthHealthBar = 45;
/*     */ 
/* 493 */       int hitPoints = p.getHitpoints();
/* 494 */       if (hitPoints < 0) {
/* 495 */         hitPoints = 0;
/*     */       }
/*     */ 
/* 498 */       double perc = (hitPoints) / (p.getMaxHitPoints());
/* 499 */       int widthDamage = (int)(widthHealthBar - perc * widthHealthBar);
/* 500 */       g.setColor(Color.GREEN);
/* 501 */       g.fillRect(x - 10, y, widthHealthBar, 8);
/* 502 */       g.setColor(Color.RED);
/* 503 */       g.fillRect(x + widthHealthBar - widthDamage - 10, y, widthDamage, 8);
/* 504 */       g.setColor(Color.black);
/*     */ 
/* 507 */       if (p.getLastHitTaken() != -1)
/*     */       {
/* 509 */         if (p.getLastHitTaken() > 0)
/* 510 */           g.drawImage(this.hitSplatIMG, x, y + 40, null);
/*     */         else {
/* 512 */           g.drawImage(this.hitSplat0IMG, x, y + 40, null);
/*     */         }
/* 514 */         g.setColor(Color.white);
/* 515 */         g.drawString(String.valueOf(p.getLastHitTaken()), x + 10, y + 58);
/* 516 */         g.setColor(Color.black);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void refreshGroundItems()
/*     */   {
/* 528 */     for (JLabel lbl : this.itemsDroppedLBL)
/*     */     {
/* 530 */       remove(lbl);
/*     */     }
/*     */ 
/* 533 */     for (GroundItem g : GroundItemList.getInstance().getGroundItems())
/*     */     {
/* 535 */       if (g.getMapId() == PlayerList.getInstance().getPlayer(Config.USERNAME).getPlayerMapId())
/*     */       {
/* 537 */         Item item = ItemList.getInstance().getItem(g.getItemId());
/* 538 */         item.setAmount(g.getItemAmount());
/*     */ 
/* 540 */         JLabel groundItem = new JLabel();
/* 541 */         groundItem.setIcon(new ImageIcon(item.getIMGUrl()));
/* 542 */         groundItem.setBounds(g.getX(), g.getY(), 50, 50);
/* 543 */         add(groundItem);
/*     */ 
/* 545 */         AreaList.getInstance().getArea(g.getMapId()).getAction().add(new ActionSpace("pickup-" + g.getItemId() + "-" + g.getItemAmount(), g.getX() - 10, g.getY() + 60, g.getX() + 60, g.getY() - 10, false));
/* 546 */         this.itemsDroppedLBL.add(groundItem);
/*     */       }
/*     */     }
/* 549 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void toggleInventory()
/*     */   {
/* 556 */     this.skillsPanel.forceClose();
/* 557 */     this.settingsPanel.forceClose();
/* 558 */     this.inventoryPanel.toggleInventory();
/*     */   }
/*     */ 
/*     */   public InventoryGUI getInventory()
/*     */   {
/* 563 */     return this.inventoryPanel;
/*     */   }
/*     */ 
/*     */   public void openSmithingInterface(String barUsed)
/*     */   {
/* 568 */     SmithingGUI smithGUI = new SmithingGUI();
/* 569 */     smithGUI.getSmithingGui(barUsed);
/* 570 */     smithGUI.setVisible(true);
/* 571 */     add(smithGUI);
/* 572 */     revalidate();
/* 573 */     repaint();
/*     */   }
/*     */ 
/*     */   public void openBrewingInterface()
/*     */   {
/* 578 */     BrewingGUI brewingGUI = new BrewingGUI();
/* 579 */     JPanel brewingPanel = brewingGUI.getBrewingGUI();
/* 580 */     brewingPanel.setVisible(true);
/* 581 */     add(brewingPanel);
/* 582 */     revalidate();
/* 583 */     repaint();
/*     */   }
/*     */ 
/*     */   public void refreshFishingSpots(int mapId)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void loadFishingSpots()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void openInputBox(InputBox inputBox)
/*     */   {
/* 615 */     inputBox.setBounds(150, 219, inputBox.getSizeX(), inputBox.getSizeY());
/* 616 */     add(inputBox);
/* 617 */     inputBox.revalidate();
/* 618 */     revalidate();
/* 619 */     repaint();
/* 620 */     inputBox.repaint();
/*     */   }
/*     */ 
/*     */   public void openShop(ShopGui shopGui)
/*     */   {
/* 625 */     this.shopGui = shopGui;
/* 626 */     shopGui.setBounds(5, 40, shopGui.getSizeX(), shopGui.getSizeY());
/* 627 */     add(shopGui);
/* 628 */     shopGui.revalidate();
/* 629 */     revalidate();
/* 630 */     repaint();
/* 631 */     shopGui.repaint();
/*     */   }
/*     */ 
/*     */   public void closeAllMenus()
/*     */   {
/* 637 */     this.inventoryPanel.forceClose();
/* 638 */     this.settingsPanel.forceClose();
/* 639 */     this.skillsPanel.forceClose();
/*     */   }
/*     */ 
/*     */   public void toggleSkills()
/*     */   {
/* 645 */     this.inventoryPanel.forceClose();
/* 646 */     this.settingsPanel.forceClose();
/* 647 */     this.skillsPanel.toggleSkills();
/*     */   }
/*     */ 
/*     */   public void toggleSettings()
/*     */   {
/* 653 */     this.inventoryPanel.forceClose();
/* 654 */     this.skillsPanel.forceClose();
/* 655 */     this.settingsPanel.toggleSettings();
/*     */   }
/*     */ 
/*     */   public void loadMenuPanels()
/*     */   {
/* 662 */     this.inventoryPanel = new InventoryGUI();
/* 663 */     this.inventoryPanel.init();
/* 664 */     add(this.inventoryPanel);
/*     */ 
/* 667 */     this.skillsPanel = new SkillsGUI();
/* 668 */     this.skillsPanel.init();
/* 669 */     add(this.skillsPanel);
/*     */ 
/* 672 */     this.settingsPanel = new SettingsGUI();
/* 673 */     this.settingsPanel.init();
/* 674 */     add(this.settingsPanel);
/*     */ 
/* 677 */     this.bankPanel = new BankGUI();
/* 678 */     this.bankPanel.init();
/* 679 */     add(this.bankPanel);
/*     */     try
/*     */     {
/* 684 */       this.actionIMG = ImageIO.read(new File("cache/graphics/icons/action.png"));
/* 685 */       this.hitSplat0IMG = ImageIO.read(new File("cache/graphics/icons/hitsplat0.png"));
/* 686 */       this.hitSplatIMG = ImageIO.read(new File("cache/graphics/icons/hitsplat.png"));
/*     */     } catch (IOException e) {
/* 688 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void loadMenuButtons()
/*     */   {
/* 697 */     String inventoryIconUrl = "cache/graphics/icons/inventory.png";
/* 698 */     String skillsIconUrl = "cache/graphics/icons/skills.png";
/* 699 */     String settingsIconUrl = "cache/graphics/icons/settings.png";
/*     */ 
/* 702 */     this.inventoryButtonPanel = new JPanel();
/* 703 */     this.inventoryButtonPanel.setLayout(null);
/* 704 */     this.inventoryButtonPanel.setBounds(0, 0, 35, 35);
/* 705 */     this.inventoryButtonPanel.setBackground(this.backgroundColor);
/* 706 */     this.inventoryButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/* 707 */     this.inventoryButtonPanel.addMouseListener(Listeners.inventoryMenu);
/* 708 */     this.inventoryButtonPanel.setCursor(new Cursor(12));
/*     */ 
/* 710 */     JLabel inventoryIMG = new JLabel();
/*     */ 
/* 712 */     inventoryIMG.setBounds(0, 0, 35, 35);
/* 713 */     inventoryIMG.setIcon(new ImageIcon(inventoryIconUrl));
/* 714 */     this.inventoryButtonPanel.add(inventoryIMG);
/* 715 */     add(this.inventoryButtonPanel);
/*     */ 
/* 719 */     this.skillsButtonPanel = new JPanel();
/* 720 */     this.skillsButtonPanel.setLayout(null);
/* 721 */     this.skillsButtonPanel.setBounds(36, 0, 35, 35);
/* 722 */     this.skillsButtonPanel.setBackground(this.backgroundColor);
/* 723 */     this.skillsButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/* 724 */     this.skillsButtonPanel.addMouseListener(Listeners.skillsMenu);
/* 725 */     this.skillsButtonPanel.setCursor(new Cursor(12));
/*     */ 
/* 727 */     JLabel skillsIMG = new JLabel();
/*     */ 
/* 729 */     skillsIMG.setBounds(2, 0, 35, 35);
/* 730 */     skillsIMG.setIcon(new ImageIcon(skillsIconUrl));
/* 731 */     this.skillsButtonPanel.add(skillsIMG);
/* 732 */     add(this.skillsButtonPanel);
/*     */ 
/* 736 */     this.settingsButtonPanel = new JPanel();
/* 737 */     this.settingsButtonPanel.setLayout(null);
/* 738 */     this.settingsButtonPanel.setBounds(72, 0, 35, 35);
/* 739 */     this.settingsButtonPanel.setBackground(this.backgroundColor);
/* 740 */     this.settingsButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
/* 741 */     this.settingsButtonPanel.addMouseListener(Listeners.settingsMenu);
/* 742 */     this.settingsButtonPanel.setCursor(new Cursor(12));
/*     */ 
/* 744 */     JLabel settingsIMG = new JLabel();
/*     */ 
/* 746 */     settingsIMG.setBounds(2, 0, 35, 35);
/* 747 */     settingsIMG.setIcon(new ImageIcon(settingsIconUrl));
/* 748 */     this.settingsButtonPanel.add(settingsIMG);
/* 749 */     add(this.settingsButtonPanel);
/*     */ 
/* 751 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void changeBackgroundMenu(String menuName)
/*     */   {
/* 758 */     if (menuName.equals("inventory"))
/*     */     {
/* 760 */       this.inventoryButtonPanel.setBackground(this.backgroundColorHover);
/* 761 */       this.inventoryButtonPanel.repaint();
/*     */     }
/* 763 */     else if (menuName.equals("skills"))
/*     */     {
/* 765 */       this.skillsButtonPanel.setBackground(this.backgroundColorHover);
/* 766 */       this.skillsButtonPanel.repaint();
/*     */     }
/* 768 */     else if (menuName.equals("settings"))
/*     */     {
/* 770 */       this.settingsButtonPanel.setBackground(this.backgroundColorHover);
/* 771 */       this.settingsButtonPanel.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void resetBackground(String menuName)
/*     */   {
/* 778 */     if (menuName.equals("inventory"))
/*     */     {
/* 780 */       this.inventoryButtonPanel.setBackground(this.backgroundColor);
/* 781 */       this.inventoryButtonPanel.repaint();
/*     */     }
/* 783 */     else if (menuName.equals("skills"))
/*     */     {
/* 785 */       this.skillsButtonPanel.setBackground(this.backgroundColor);
/* 786 */       this.skillsButtonPanel.repaint();
/*     */     }
/* 789 */     else if (menuName.equals("settings"))
/*     */     {
/* 791 */       this.settingsButtonPanel.setBackground(this.backgroundColor);
/* 792 */       this.settingsButtonPanel.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void refresh()
/*     */   {
/* 799 */     refreshRetreatButton();
/* 800 */     repaint();
/*     */   }
/*     */ 
/*     */   public void loadChat()
/*     */   {
/* 806 */     this.chat = new Chat();
/* 807 */     add(this.chat);
/*     */   }
/*     */ 
/*     */   public Chat getChat()
/*     */   {
/* 812 */     return this.chat;
/*     */   }
/*     */ 
/*     */   public void startUp()
/*     */   {
/* 820 */     loadMenuButtons();
/* 821 */     loadMenuPanels();
/* 822 */     loadChat();
/* 823 */     loadListeners();
/* 824 */     loadRetreatButton();
/*     */ 
/* 826 */     startUpMessage();
/*     */   }
/*     */ 
/*     */   public void startUpMessage()
/*     */   {
/* 834 */     InputBox inputBox = new InputBox();
/* 835 */     inputBox.setTitleAndMessage("Command List", "<span style='color:red;'>/yell [msg] (/y)</span> - talk to the whole server.<br /><span style='color:red;'>/brew</span> - Brewing Intervace<br /><span style='color:red;'>/stuck</span> - if your stuck, this will free you.<br /><span style='color:red;'>/fight [playername]</span> - You fight another player, you do NOT lose items on death in pvp.<br /><span style='color:red;'>/players</span> - shows how many players currently logged in.<br /><span style='color:red;'>/stats [playername]</span> - display player stats.<br /><span style='color:red;'>/trade [playername]</span> - coming soon.");
/* 836 */     inputBox.setNumberOfOptions(1);
/* 837 */     inputBox.setOption("View Recent Updates", 0, "recent_updates");
/*     */ 
/* 839 */     inputBox.init(true);
/* 840 */     openInputBox(inputBox);
/*     */   }
/*     */ 
/*     */   private void loadRetreatButton()
/*     */   {
/* 845 */     this.retreatFromCombatButton = new JButton("Run");
/* 846 */     this.retreatFromCombatButton.setBackground(Color.black);
/* 847 */     this.retreatFromCombatButton.setForeground(Color.white);
/* 848 */     this.retreatFromCombatButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 852 */         if (PlayerList.getInstance().getPlayer(Config.USERNAME).isInCombat())
/* 853 */           Command.getInstance().sendCommand("retreat", "");
/*     */       }
/*     */     });
/* 856 */     add(this.retreatFromCombatButton);
/*     */   }
/*     */ 
/*     */   public BankGUI getBankGUI()
/*     */   {
/* 862 */     return this.bankPanel;
/*     */   }
/*     */ 
/*     */   public void setLoading(boolean b) {
/* 866 */     this.gameLoading = b;
/*     */   }
/*     */ 
/*     */   public SkillsGUI getSkillsGUI()
/*     */   {
/* 871 */     return this.skillsPanel;
/*     */   }
/*     */ 
/*     */   public ShopGui getShopGui() {
/* 875 */     return this.shopGui;
/*     */   }
/*     */ 
/*     */   public void setShopGui(ShopGui shopGui) {
/* 879 */     this.shopGui = shopGui;
/*     */   }
/*     */ }