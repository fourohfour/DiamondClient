/*     */ package players;
/*     */ 
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class PlayerEquipement
/*     */ {
/*     */   private int headId;
/*     */   private int bodyId;
/*     */   private int legsId;
/*     */   private int bootsId;
/*     */   private int weaponId;
/*     */   private int shieldId;
/*     */   private int necklaceId;
/*     */ 
/*     */   public PlayerEquipement()
/*     */   {
/*  21 */     this.headId = -1;
/*  22 */     this.bodyId = -1;
/*  23 */     this.legsId = -1;
/*  24 */     this.bootsId = -1;
/*  25 */     this.weaponId = -1;
/*  26 */     this.shieldId = -1;
/*  27 */     this.necklaceId = -1;
/*     */   }
/*     */ 
/*     */   public PlayerEquipement(int headId, int bodyId, int legsId, int bootsId, int weaponId, int shieldId, int necklaceId)
/*     */   {
/*  32 */     this.headId = headId;
/*  33 */     this.bodyId = bodyId;
/*  34 */     this.legsId = legsId;
/*  35 */     this.bootsId = bootsId;
/*  36 */     this.weaponId = weaponId;
/*  37 */     this.shieldId = shieldId;
/*  38 */     this.necklaceId = necklaceId;
/*     */   }
/*     */ 
/*     */   public int getHeadId() {
/*  42 */     return this.headId;
/*     */   }
/*     */ 
/*     */   public void setHeadId(int headId) {
/*  46 */     this.headId = headId;
/*     */   }
/*     */ 
/*     */   public int getBodyId() {
/*  50 */     return this.bodyId;
/*     */   }
/*     */ 
/*     */   public void setBodyId(int bodyId) {
/*  54 */     this.bodyId = bodyId;
/*     */   }
/*     */ 
/*     */   public int getLegsId() {
/*  58 */     return this.legsId;
/*     */   }
/*     */ 
/*     */   public void setLegsId(int legsId) {
/*  62 */     this.legsId = legsId;
/*     */   }
/*     */ 
/*     */   public int getBootsId() {
/*  66 */     return this.bootsId;
/*     */   }
/*     */ 
/*     */   public void setBootsId(int bootsId) {
/*  70 */     this.bootsId = bootsId;
/*     */   }
/*     */ 
/*     */   public int getWeaponId() {
/*  74 */     return this.weaponId;
/*     */   }
/*     */ 
/*     */   public void setWeaponId(int weaponId) {
/*  78 */     this.weaponId = weaponId;
/*     */   }
/*     */ 
/*     */   public int getShieldId() {
/*  82 */     return this.shieldId;
/*     */   }
/*     */ 
/*     */   public void setShieldId(int shieldId) {
/*  86 */     this.shieldId = shieldId;
/*     */   }
/*     */ 
/*     */   public int getNecklaceId() {
/*  90 */     return this.necklaceId;
/*     */   }
/*     */ 
/*     */   public void setNecklaceId(int necklaceId) {
/*  94 */     this.necklaceId = necklaceId;
/*     */   }
/*     */ 
/*     */   public void setAll(int headId, int bodyId, int legsId, int bootsId, int weaponId, int shieldId, int necklaceId)
/*     */   {
/*  99 */     this.headId = headId;
/* 100 */     this.bodyId = bodyId;
/* 101 */     this.legsId = legsId;
/* 102 */     this.bootsId = bootsId;
/* 103 */     this.weaponId = weaponId;
/* 104 */     this.shieldId = shieldId;
/* 105 */     this.necklaceId = necklaceId;
/*     */   }
/*     */ 
/*     */   public JPanel generatePlayer()
/*     */   {
/* 110 */     JPanel panel = new JPanel();
/* 111 */     panel.setSize(45, 110);
/*     */ 
/* 115 */     JLabel shield = createShield(this.shieldId);
/* 116 */     shield.setBounds(0, 35, shield.getWidth(), shield.getHeight());
/* 117 */     panel.add(shield);
/*     */ 
/* 120 */     JLabel head = createHead(this.headId);
/* 121 */     head.setBounds(2, 0, head.getWidth(), head.getHeight());
/* 122 */     panel.add(head);
/*     */ 
/* 125 */     JLabel weapon = createWeapon(this.weaponId);
/* 126 */     weapon.setBounds(16, 40, weapon.getWidth(), weapon.getHeight());
/* 127 */     panel.add(weapon);
/*     */ 
/* 130 */     JLabel body = createBody(this.bodyId);
/* 131 */     body.setBounds(1, 26, body.getWidth(), body.getHeight());
/* 132 */     panel.add(body);
/*     */ 
/* 135 */     JLabel boots = createBoots(this.bootsId);
/* 136 */     boots.setBounds(3, 70, boots.getWidth(), boots.getHeight());
/* 137 */     panel.add(boots);
/*     */ 
/* 140 */     JLabel legs = createLegs(this.legsId);
/* 141 */     legs.setBounds(0, 45, legs.getWidth(), legs.getHeight());
/* 142 */     panel.add(legs);
/*     */ 
/* 144 */     panel.setOpaque(false);
/* 145 */     return panel;
/*     */   }
/*     */ 
/*     */   private JLabel createShield(int id)
/*     */   {
/* 150 */     JLabel shield = new JLabel();
/* 151 */     shield.setSize(25, 50);
/*     */ 
/* 153 */     ImageIcon img = new ImageIcon("cache/graphics/sprites/" + id + ".png");
/*     */ 
/* 155 */     shield.setIcon(img);
/*     */ 
/* 157 */     return shield;
/*     */   }
/*     */ 
/*     */   public JLabel createHead(int id)
/*     */   {
/* 162 */     JLabel head = new JLabel();
/* 163 */     head.setSize(25, 50);
/*     */ 
/* 165 */     ImageIcon img = null;
/*     */ 
/* 167 */     if (id == -1)
/* 168 */       img = new ImageIcon("cache/graphics/sprites/head1.png");
/*     */     else {
/* 170 */       img = new ImageIcon("cache/graphics/sprites/" + id + ".png");
/*     */     }
/* 172 */     head.setIcon(img);
/*     */ 
/* 174 */     return head;
/*     */   }
/*     */ 
/*     */   public JLabel createBody(int id)
/*     */   {
/* 179 */     JLabel body = new JLabel();
/* 180 */     body.setSize(25, 50);
/* 181 */     ImageIcon img = null;
/*     */ 
/* 183 */     if (id == -1)
/* 184 */       img = new ImageIcon("cache/graphics/sprites/body1.png");
/*     */     else {
/* 186 */       img = new ImageIcon("cache/graphics/sprites/" + id + ".png");
/*     */     }
/* 188 */     body.setIcon(img);
/*     */ 
/* 190 */     return body;
/*     */   }
/*     */ 
/*     */   public JLabel createLegs(int id)
/*     */   {
/* 195 */     JLabel legs = new JLabel();
/* 196 */     legs.setSize(25, 50);
/* 197 */     ImageIcon img = null;
/*     */ 
/* 199 */     if (id == -1)
/* 200 */       img = new ImageIcon("cache/graphics/sprites/legs1.png");
/*     */     else {
/* 202 */       img = new ImageIcon("cache/graphics/sprites/" + id + ".png");
/*     */     }
/* 204 */     legs.setIcon(img);
/*     */ 
/* 206 */     return legs;
/*     */   }
/*     */ 
/*     */   public JLabel createBoots(int id)
/*     */   {
/* 211 */     JLabel boots = new JLabel();
/* 212 */     boots.setSize(25, 25);
/* 213 */     switch (id)
/*     */     {
/*     */     case 2:
/* 217 */       break;
/*     */     default:
/* 219 */       ImageIcon img = new ImageIcon("cache/graphics/sprites/boots1.png");
/* 220 */       boots.setIcon(img);
/*     */     }
/*     */ 
/* 225 */     return boots;
/*     */   }
/*     */ 
/*     */   public JLabel createWeapon(int id)
/*     */   {
/* 233 */     JLabel weapon = new JLabel();
/* 234 */     weapon.setSize(25, 25);
/* 235 */     ImageIcon img = new ImageIcon("cache/graphics/sprites/" + id + ".png");
/* 236 */     weapon.setIcon(img);
/*     */ 
/* 238 */     return weapon;
/*     */   }
/*     */ 
/*     */   public boolean isEquiped(int id)
/*     */   {
/* 243 */     boolean isEquiped = false;
/*     */ 
/* 245 */     if (this.headId == id)
/* 246 */       isEquiped = true;
/* 247 */     else if (this.bodyId == id)
/* 248 */       isEquiped = true;
/* 249 */     else if (this.legsId == id)
/* 250 */       isEquiped = true;
/* 251 */     else if (this.bootsId == id)
/* 252 */       isEquiped = true;
/* 253 */     else if (this.weaponId == id)
/* 254 */       isEquiped = true;
/* 255 */     else if (this.shieldId == id)
/* 256 */       isEquiped = true;
/* 257 */     else if (this.necklaceId == id) {
/* 258 */       isEquiped = true;
/*     */     }
/* 260 */     return isEquiped;
/*     */   }
/*     */ 
/*     */   public String getEquipeType(int id)
/*     */   {
/* 265 */     String type = "none";
/*     */ 
/* 267 */     if (this.headId == id)
/* 268 */       type = "head";
/* 269 */     else if (this.bodyId == id)
/* 270 */       type = "body";
/* 271 */     else if (this.legsId == id)
/* 272 */       type = "legs";
/* 273 */     else if (this.bootsId == id)
/* 274 */       type = "boots";
/* 275 */     else if (this.weaponId == id)
/* 276 */       type = "weapon";
/* 277 */     else if (this.shieldId == id)
/* 278 */       type = "shield";
/* 279 */     else if (this.necklaceId == id) {
/* 280 */       type = "necklace";
/*     */     }
/* 282 */     return type;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.PlayerEquipement
 * JD-Core Version:    0.6.2
 */