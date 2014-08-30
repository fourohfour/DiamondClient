/*     */ package players;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JPanel;
/*     */ import maps.Area;
/*     */ import maps.AreaList;
/*     */ 
/*     */ public class Player
/*     */   implements Serializable
/*     */ {
/*     */   private int bubbleItemId;
/*     */   private int id;
/*     */   private String username;
/*     */   private int currentMapId;
/*     */   private BufferedImage playerIMG;
/*     */   private int positionX;
/*     */   private int positionY;
/*     */   private int lastPositionX;
/*     */   private int lastPositionY;
/*  32 */   private String chat = "";
/*  33 */   private boolean loggedIn = true;
/*     */   private int energy;
/*  35 */   private String lastDirection = "right";
/*     */   private String playerAction;
/*  37 */   private int globalLevel = 0;
/*     */   private boolean inCombat;
/*  39 */   private int lastHitTaken = -1;
/*     */   private int hitpoints;
/*     */   private int maxHitPoints;
/*  43 */   private int playerRights = 0;
/*  44 */   private int xpDifference = 0;
/*     */   private int attackBonus;
/*     */   private int defenceBonus;
/*  50 */   private boolean canWalk = true;
/*     */ 
/*  53 */   List<Flag> flags = new CopyOnWriteArrayList();
/*     */   private PlayerEquipement playerEquipement;
/*     */ 
/*     */   public Player(int id, int bubble_id, String username, int currentMapId, int positionX, int positionY, String playerIMG, PlayerEquipement playerEquipement)
/*     */   {
/*  59 */     this.id = id;
/*  60 */     this.username = username;
/*  61 */     this.currentMapId = currentMapId;
/*  62 */     this.positionX = positionX;
/*  63 */     this.bubbleItemId = bubble_id;
/*  64 */     this.positionY = positionY;
/*  65 */     this.playerEquipement = new PlayerEquipement();
/*  66 */     this.playerAction = "";
/*     */     try
/*     */     {
/*  70 */       this.playerIMG = ImageIO.read(new File(playerIMG));
/*     */     } catch (IOException e) {
/*  72 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setPlayerGraphic(String pathIMG)
/*     */   {
/*     */     try {
/*  79 */       this.playerIMG = ImageIO.read(new File(pathIMG));
/*     */     } catch (IOException e) {
/*  81 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public BufferedImage getPlayerGraphic()
/*     */   {
/*  87 */     return this.playerIMG;
/*     */   }
/*     */ 
/*     */   public void setCanWalk(boolean b)
/*     */   {
/*  92 */     this.canWalk = b;
/*     */   }
/*     */ 
/*     */   public boolean getCanWalk()
/*     */   {
/*  97 */     return this.canWalk;
/*     */   }
/*     */ 
/*     */   public void setPlayerAction(String s)
/*     */   {
/* 102 */     this.playerAction = s;
/*     */   }
/*     */ 
/*     */   public String getPlayerAction()
/*     */   {
/* 107 */     return this.playerAction;
/*     */   }
/*     */ 
/*     */   public BufferedImage getPlayerGraphicPanel()
/*     */   {
/* 124 */     JPanel panel = this.playerEquipement.generatePlayer();
/*     */ 
/* 126 */     int w = panel.getWidth();
/* 127 */     int h = panel.getHeight();
/* 128 */     BufferedImage bi = new BufferedImage(w, h, 6);
/* 129 */     Graphics2D g = bi.createGraphics();
/* 130 */     panel.printAll(g);
/* 131 */     return bi;
/*     */   }
/*     */ 
/*     */   public PlayerEquipement getPlayerEquipement()
/*     */   {
/* 137 */     return this.playerEquipement;
/*     */   }
/*     */ 
/*     */   public synchronized int getX()
/*     */   {
/* 142 */     return this.positionX;
/*     */   }
/*     */ 
/*     */   public int getY()
/*     */   {
/* 147 */     return this.positionY;
/*     */   }
/*     */ 
/*     */   public void telePlayer(int x, int y)
/*     */   {
/* 152 */     this.positionX = x;
/* 153 */     this.positionY = y;
/*     */   }
/*     */ 
/*     */   public int getYAtFeet()
/*     */   {
/* 158 */     return this.positionY + 66;
/*     */   }
/*     */ 
/*     */   public int getXAtFeet() {
/* 162 */     return this.positionX + 15;
/*     */   }
/*     */ 
/*     */   public String getUsername()
/*     */   {
/* 167 */     return this.username;
/*     */   }
/*     */ 
/*     */   public int getPlayerMapId()
/*     */   {
/* 172 */     return this.currentMapId;
/*     */   }
/*     */ 
/*     */   public void setChat(String msg)
/*     */   {
/* 177 */     this.chat = msg;
/*     */   }
/*     */ 
/*     */   public String getChat()
/*     */   {
/* 182 */     return this.chat;
/*     */   }
/*     */ 
/*     */   public void setLoggedIn(boolean b)
/*     */   {
/* 187 */     this.loggedIn = b;
/*     */   }
/*     */ 
/*     */   public void logOut()
/*     */   {
/* 193 */     this.loggedIn = false;
/*     */   }
/*     */ 
/*     */   public boolean isLoggedIn()
/*     */   {
/* 199 */     return this.loggedIn;
/*     */   }
/*     */ 
/*     */   public void movePlayer(String direction)
/*     */   {
/* 205 */     if (direction == null) {
/* 206 */       return;
/*     */     }
/* 208 */     if (this.canWalk)
/*     */     {
/* 210 */       this.playerAction = "";
/*     */ 
/* 212 */       int playerSpeed = 6;
/*     */ 
/* 215 */       if (getY() > 511)
/*     */       {
/* 217 */         this.positionY = 510;
/* 218 */         return;
/*     */       }
/* 220 */       if (getY() < 0)
/*     */       {
/* 222 */         this.positionY = 1;
/* 223 */         return;
/*     */       }
/*     */ 
/* 226 */       if (getX() < 0)
/*     */       {
/* 228 */         this.positionX = 1;
/* 229 */         return;
/*     */       }
/*     */ 
/* 232 */       if (getX() > 770)
/*     */       {
/* 234 */         this.positionX = 769;
/* 235 */         return;
/*     */       }
/*     */ 
/* 240 */       AreaList.getInstance().getArea(this.currentMapId).doAction(getXAtFeet(), getYAtFeet());
/*     */ 
/* 242 */       if (direction.equals("up"))
/*     */       {
/* 244 */         if (AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet(), getYAtFeet() - 10)) {
/* 245 */           this.positionY -= playerSpeed;
/*     */         }
/*     */       }
/* 248 */       if (direction.equals("topLeft"))
/*     */       {
/* 250 */         if ((AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet(), getYAtFeet() - 10)) && (AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet() - 10, getYAtFeet())))
/*     */         {
/* 252 */           this.positionY -= (int)(playerSpeed / 1.5D);
/* 253 */           this.positionX -= (int)(playerSpeed / 1.5D);
/*     */         }
/*     */       }
/*     */ 
/* 257 */       if (direction.equals("topRight"))
/*     */       {
/* 259 */         if ((AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet(), getYAtFeet() - 10)) && (AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet() + 10, getYAtFeet())))
/*     */         {
/* 261 */           this.positionY -= (int)(playerSpeed / 1.5D);
/* 262 */           this.positionX += (int)(playerSpeed / 1.5D);
/*     */         }
/*     */       }
/*     */ 
/* 266 */       if (direction.equals("downLeft"))
/*     */       {
/* 268 */         if ((AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet(), getYAtFeet() + 10)) && (AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet() - 10, getYAtFeet())))
/*     */         {
/* 270 */           this.positionY += (int)(playerSpeed / 1.5D);
/* 271 */           this.positionX -= (int)(playerSpeed / 1.5D);
/*     */         }
/*     */       }
/*     */ 
/* 275 */       if (direction.equals("downRight"))
/*     */       {
/* 277 */         if ((AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet(), getYAtFeet() + 10)) && (AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet() + 10, getYAtFeet())))
/*     */         {
/* 279 */           this.positionY += (int)(playerSpeed / 1.5D);
/* 280 */           this.positionX += (int)(playerSpeed / 1.5D);
/*     */         }
/*     */       }
/*     */ 
/* 284 */       if (direction.equals("down"))
/*     */       {
/* 286 */         if (AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet(), getYAtFeet() + 10)) {
/* 287 */           this.positionY += playerSpeed;
/*     */         }
/*     */       }
/* 290 */       if (direction.equals("left"))
/*     */       {
/* 292 */         if (AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet() - 10, getYAtFeet())) {
/* 293 */           this.positionX -= playerSpeed;
/*     */         }
/*     */       }
/* 296 */       if (direction.equals("right"))
/*     */       {
/* 298 */         if (AreaList.getInstance().getArea(this.currentMapId).canWalkThere(getXAtFeet() + 10, getYAtFeet())) {
/* 299 */           this.positionX += playerSpeed;
/*     */         }
/*     */       }
/* 302 */       PlayerList.getInstance().overwritePlayer(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void cancelMovePlayer()
/*     */   {
/*     */   }
/*     */ 
/*     */   public int getId()
/*     */   {
/* 313 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setMapId(int mapid)
/*     */   {
/* 318 */     this.currentMapId = mapid;
/*     */   }
/*     */ 
/*     */   public int getBubbleItemId() {
/* 322 */     return this.bubbleItemId;
/*     */   }
/*     */ 
/*     */   public void setBubbleItemId(int bubbleItemId) {
/* 326 */     this.bubbleItemId = bubbleItemId;
/*     */   }
/*     */ 
/*     */   public int getEnergy() {
/* 330 */     return this.energy;
/*     */   }
/*     */ 
/*     */   public void setEnergy(int energy) {
/* 334 */     this.energy = energy;
/*     */   }
/*     */ 
/*     */   public String getLastDirection() {
/* 338 */     return this.lastDirection;
/*     */   }
/*     */ 
/*     */   public void setLastDirection(String lastDirection) {
/* 342 */     this.lastDirection = lastDirection;
/*     */   }
/*     */ 
/*     */   public int getGlobaLevel() {
/* 346 */     return this.globalLevel;
/*     */   }
/*     */ 
/*     */   public void setGlobalLevel(int globaLevel) {
/* 350 */     this.globalLevel = globaLevel;
/*     */   }
/*     */ 
/*     */   public int getXpDifference() {
/* 354 */     return this.xpDifference;
/*     */   }
/*     */ 
/*     */   public void setXpDifference(int xpDifference) {
/* 358 */     this.xpDifference = xpDifference;
/*     */   }
/*     */ 
/*     */   public void lowerCaseUsername() {
/* 362 */     this.username = this.username.toLowerCase();
/*     */   }
/*     */ 
/*     */   public void setFlags(String flagsData)
/*     */   {
/* 367 */     StringTokenizer flagsDataTokenized = new StringTokenizer(flagsData, "~");
/*     */ 
/* 369 */     while (flagsDataTokenized.hasMoreElements())
/*     */     {
/* 371 */       StringTokenizer flagsDataUnfromated = new StringTokenizer((String)flagsDataTokenized.nextElement(), "=");
/* 372 */       String flagName = (String)flagsDataUnfromated.nextElement();
/* 373 */       String flagValue = (String)flagsDataUnfromated.nextElement();
/* 374 */       this.flags.add(new Flag(flagName, flagValue));
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getFlagValue(String flagName)
/*     */   {
/* 381 */     for (Flag f : this.flags)
/*     */     {
/* 383 */       if (f.getFlagName().equalsIgnoreCase(flagName)) {
/* 384 */         return f.getFlagValue();
/*     */       }
/*     */     }
/* 387 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isInCombat() {
/* 391 */     return this.inCombat;
/*     */   }
/*     */ 
/*     */   public void setInCombat(boolean inCombat)
/*     */   {
/* 396 */     if (inCombat)
/*     */     {
/* 398 */       setCanWalk(false);
/* 399 */       this.lastDirection = null;
/*     */     }
/*     */     else
/*     */     {
/* 403 */       setCanWalk(true);
/*     */     }
/*     */ 
/* 406 */     this.inCombat = inCombat;
/*     */   }
/*     */ 
/*     */   public int getLastHitTaken() {
/* 410 */     return this.lastHitTaken;
/*     */   }
/*     */ 
/*     */   public void setLastHitTaken(int lastHitTaken) {
/* 414 */     this.lastHitTaken = lastHitTaken;
/*     */   }
/*     */ 
/*     */   public int getHitpoints() {
/* 418 */     return this.hitpoints;
/*     */   }
/*     */ 
/*     */   public void setHitpoints(int hitpoints) {
/* 422 */     this.hitpoints = hitpoints;
/*     */   }
/*     */ 
/*     */   public int getMaxHitPoints() {
/* 426 */     return this.maxHitPoints;
/*     */   }
/*     */ 
/*     */   public void setMaxHitPoints(int maxHitPoints) {
/* 430 */     this.maxHitPoints = maxHitPoints;
/*     */   }
/*     */ 
/*     */   public int getAttackBonus() {
/* 434 */     return this.attackBonus;
/*     */   }
/*     */ 
/*     */   public void setAttackBonus(int attackBonus) {
/* 438 */     this.attackBonus = attackBonus;
/*     */   }
/*     */ 
/*     */   public int getDefenceBonus() {
/* 442 */     return this.defenceBonus;
/*     */   }
/*     */ 
/*     */   public void setDefenceBonus(int defenceBonus) {
/* 446 */     this.defenceBonus = defenceBonus;
/*     */   }
/*     */ 
/*     */   public int getLastPositionX() {
/* 450 */     return this.lastPositionX;
/*     */   }
/*     */ 
/*     */   public void setLastPositionX(int lastPositionX) {
/* 454 */     this.lastPositionX = lastPositionX;
/*     */   }
/*     */ 
/*     */   public int getLastPositionY() {
/* 458 */     return this.lastPositionY;
/*     */   }
/*     */ 
/*     */   public void setLastPositionY(int lastPositionY) {
/* 462 */     this.lastPositionY = lastPositionY;
/*     */   }
/*     */ 
/*     */   public int getPlayerRights() {
/* 466 */     return this.playerRights;
/*     */   }
/*     */ 
/*     */   public void setPlayerRights(int playerRights) {
/* 470 */     this.playerRights = playerRights;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.Player
 * JD-Core Version:    0.6.2
 */