/*     */ package players;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ public class Item
/*     */ {
/*     */   private String name;
/*     */   private String description;
/*     */   private String imgURL;
/*     */   private int id;
/*     */   private int value;
/*     */   private int highValue;
/*     */   private boolean stackable;
/*     */   private boolean wieldable;
/*     */   private boolean isWielded;
/*  23 */   private int amount = 0;
/*     */   private BufferedImage image;
/*     */ 
/*     */   public Item(int id, String name, String desc, String imgURL, int value, boolean stackable, boolean wieldable)
/*     */   {
/*  28 */     this.id = id;
/*  29 */     this.name = name;
/*  30 */     this.description = desc;
/*  31 */     this.imgURL = imgURL;
/*  32 */     this.value = value;
/*  33 */     this.highValue = ((int)(value * 1.2D));
/*  34 */     this.stackable = stackable;
/*  35 */     this.wieldable = wieldable;
/*     */     try
/*     */     {
/*  39 */       this.image = ImageIO.read(new File(imgURL));
/*     */     } catch (IOException e) {
/*  41 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*  45 */   public Item(int id) { this.id = id; }
/*     */ 
/*     */ 
/*     */   public Item(int id, String name, String ignore, String desc, String imgURL, int value, boolean stackable, boolean wieldable)
/*     */   {
/*  51 */     this.id = id;
/*  52 */     this.name = name;
/*  53 */     this.description = desc;
/*  54 */     this.imgURL = imgURL;
/*  55 */     this.value = value;
/*  56 */     this.highValue = ((int)(value * 1.2D));
/*  57 */     this.stackable = stackable;
/*  58 */     this.wieldable = wieldable;
/*     */     try
/*     */     {
/*  62 */       this.image = ImageIO.read(new File(imgURL));
/*     */     } catch (IOException e) {
/*  64 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*  68 */   public void addAmount(int am) { if (this.stackable)
/*  69 */       this.amount += am;
/*     */   }
/*     */ 
/*     */   public String getIMGUrl()
/*     */   {
/*  77 */     return this.imgURL;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  81 */     return this.name;
/*     */   }
/*     */ 
/*     */   public int getAmount() {
/*  85 */     return this.amount;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  89 */     this.name = name;
/*     */   }
/*     */   public String getDescription() {
/*  92 */     return this.description;
/*     */   }
/*     */   public void setDescription(String description) {
/*  95 */     this.description = description;
/*     */   }
/*     */   public int getId() {
/*  98 */     return this.id;
/*     */   }
/*     */   public void setId(int id) {
/* 101 */     this.id = id;
/*     */   }
/*     */   public int getValue() {
/* 104 */     return this.value;
/*     */   }
/*     */   public void setValue(int value) {
/* 107 */     this.value = value;
/*     */   }
/*     */   public int getHighValue() {
/* 110 */     return this.highValue;
/*     */   }
/*     */   public void setHighValue(int highValue) {
/* 113 */     this.highValue = highValue;
/*     */   }
/*     */ 
/*     */   public boolean isStackable()
/*     */   {
/* 118 */     return this.stackable;
/*     */   }
/*     */   public boolean isWieldable() {
/* 121 */     return this.wieldable;
/*     */   }
/*     */ 
/*     */   public void forceAddAmount(int amm) {
/* 125 */     this.amount += amm;
/*     */   }
/*     */   public boolean isWielded() {
/* 128 */     return this.isWielded;
/*     */   }
/*     */   public void setWielded(boolean isWielded) {
/* 131 */     this.isWielded = isWielded;
/*     */   }
/*     */   public BufferedImage getImage() {
/* 134 */     return this.image;
/*     */   }
/*     */   public void setAmount(int amm) {
/* 137 */     this.amount = amm;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.Item
 * JD-Core Version:    0.6.2
 */