/*     */ package npc;
/*     */ 
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import players.Player;
/*     */ 
/*     */ public class NPC
/*     */ {
/*     */   private int uniqueId;
/*     */   private String name;
/*     */   private String desc;
/*     */   private int maxHP;
/*     */   private int currentHP;
/*     */   private int level;
/*     */   private boolean inCombat;
/*     */   private int posX;
/*     */   private int posY;
/*     */   private int mapId;
/*     */   private BufferedImage npcIMG;
/*     */   private String lastDirection;
/*     */   private Player playerInCombatWith;
/*     */   private int lastHitTaken;
/*  29 */   private boolean isSpawned = false;
/*     */ 
/*     */   public NPC(int uniqueId, String name, String desc, int maxHP, int currentHP, int level, boolean inCombat, int mapId, int posX, int posY)
/*     */   {
/*  33 */     this.uniqueId = uniqueId;
/*  34 */     this.name = name;
/*  35 */     this.desc = desc;
/*  36 */     this.level = level;
/*     */ 
/*  39 */     String npcIMG = name.toLowerCase();
/*  40 */     npcIMG = npcIMG.replace(" ", "_");
/*     */     try
/*     */     {
/*  43 */       BufferedImage temp = ImageIO.read(new File("cache/graphics/npc/" + npcIMG + ".png"));
/*  44 */       BufferedImage convertedImg = new BufferedImage(temp.getWidth(), temp.getHeight(), 6);
/*  45 */       convertedImg.getGraphics().drawImage(temp, 0, 0, null);
/*  46 */       this.npcIMG = convertedImg;
/*     */     } catch (IOException e) {
/*  48 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public NPC()
/*     */   {
/*     */   }
/*     */ 
/*     */   public int getUniqueId()
/*     */   {
/*  58 */     return this.uniqueId;
/*     */   }
/*     */ 
/*     */   public void setUniqueId(int uniqueId) {
/*  62 */     this.uniqueId = uniqueId;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  66 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  70 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getDesc() {
/*  74 */     return this.desc;
/*     */   }
/*     */ 
/*     */   public void setDesc(String desc) {
/*  78 */     this.desc = desc;
/*     */   }
/*     */ 
/*     */   public int getMaxHP() {
/*  82 */     return this.maxHP;
/*     */   }
/*     */ 
/*     */   public void setMaxHP(int maxHP) {
/*  86 */     this.maxHP = maxHP;
/*     */   }
/*     */ 
/*     */   public int getCurrentHP() {
/*  90 */     return this.currentHP;
/*     */   }
/*     */ 
/*     */   public void setCurrentHP(int currentHP) {
/*  94 */     this.currentHP = currentHP;
/*     */   }
/*     */ 
/*     */   public int getLevel() {
/*  98 */     return this.level;
/*     */   }
/*     */ 
/*     */   public void setLevel(int level) {
/* 102 */     this.level = level;
/*     */   }
/*     */ 
/*     */   public boolean isInCombat() {
/* 106 */     return this.inCombat;
/*     */   }
/*     */ 
/*     */   public void setInCombat(boolean inCombat) {
/* 110 */     this.inCombat = inCombat;
/*     */   }
/*     */ 
/*     */   public int getPosX() {
/* 114 */     return this.posX;
/*     */   }
/*     */ 
/*     */   public void setPosX(int posX) {
/* 118 */     this.posX = posX;
/*     */   }
/*     */ 
/*     */   public int getPosY() {
/* 122 */     return this.posY;
/*     */   }
/*     */ 
/*     */   public void setPosY(int posY) {
/* 126 */     this.posY = posY;
/*     */   }
/*     */ 
/*     */   public BufferedImage getNpcIMG() {
/* 130 */     return this.npcIMG;
/*     */   }
/*     */ 
/*     */   public void setNpcIMG(BufferedImage npcIMG) {
/* 134 */     this.npcIMG = npcIMG;
/*     */   }
/*     */ 
/*     */   public int getMapId() {
/* 138 */     return this.mapId;
/*     */   }
/*     */ 
/*     */   public void setMapId(int mapId) {
/* 142 */     this.mapId = mapId;
/*     */   }
/*     */ 
/*     */   public BufferedImage getGraphic()
/*     */   {
/* 148 */     return this.npcIMG;
/*     */   }
/*     */ 
/*     */   public String getLastDirection() {
/* 152 */     if (this.lastDirection == null) {
/* 153 */       return "right";
/*     */     }
/* 155 */     return this.lastDirection;
/*     */   }
/*     */ 
/*     */   public void setLastDirection(String lastDirection) {
/* 159 */     if (lastDirection == null)
/* 160 */       lastDirection = "right";
/* 161 */     this.lastDirection = lastDirection;
/*     */   }
/*     */ 
/*     */   public Player getPlayerInCombatWith() {
/* 165 */     return this.playerInCombatWith;
/*     */   }
/*     */ 
/*     */   public void setPlayerInCombatWith(Player playerInCombatWith) {
/* 169 */     this.playerInCombatWith = playerInCombatWith;
/*     */   }
/*     */ 
/*     */   public int getLastHitTaken() {
/* 173 */     return this.lastHitTaken;
/*     */   }
/*     */ 
/*     */   public void setLastHitTaken(int listHitTaken) {
/* 177 */     this.lastHitTaken = listHitTaken;
/*     */   }
/*     */ 
/*     */   public boolean isSpawned() {
/* 181 */     return this.isSpawned;
/*     */   }
/*     */ 
/*     */   public void setSpawned(boolean isSpawned) {
/* 185 */     this.isSpawned = isSpawned;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     npc.NPC
 * JD-Core Version:    0.6.2
 */