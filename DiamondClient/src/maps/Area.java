/*     */ package maps;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import players.Config;
/*     */ 
/*     */ public class Area
/*     */ {
/*     */   private int id;
/*     */   private String mapName;
/*     */   private String terrainURL;
/*  14 */   private ArrayList<Walkable> walkable = new ArrayList();
/*  15 */   private List<ActionSpace> action = new CopyOnWriteArrayList();
/*     */ 
/*     */   public Area(int id, String mapName, String terrainURL)
/*     */   {
/*  19 */     this.id = id;
/*  20 */     this.mapName = mapName;
/*  21 */     this.terrainURL = terrainURL;
/*     */   }
/*     */ 
/*     */   public int getId() {
/*  25 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(int id) {
/*  29 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getMapName() {
/*  33 */     return this.mapName;
/*     */   }
/*     */ 
/*     */   public void setMapName(String mapName) {
/*  37 */     this.mapName = mapName;
/*     */   }
/*     */ 
/*     */   public String getTerrainURL() {
/*  41 */     return this.terrainURL;
/*     */   }
/*     */ 
/*     */   public void setTerrainURL(String terrainURL) {
/*  45 */     this.terrainURL = terrainURL;
/*     */   }
/*     */ 
/*     */   public boolean canWalkThere(int x, int y)
/*     */   {
/*  51 */     if (Config.canWalkThroughWalls) {
/*  52 */       return true;
/*     */     }
/*  54 */     boolean walkable = true;
/*     */ 
/*  59 */     for (Walkable w : this.walkable)
/*     */     {
/*  62 */       if ((x >= w.getLowX()) && (y <= w.getLowY()) && (x <= w.getHighX()) && (y >= w.getHighY())) {
/*  63 */         walkable = false;
/*     */       }
/*     */     }
/*  66 */     return walkable;
/*     */   }
/*     */ 
/*     */   public void doAction(int x, int y)
/*     */   {
/*  75 */     for (ActionSpace a : this.action)
/*     */     {
/*  78 */       if ((x >= a.getLowX()) && (y <= a.getLowY()) && (x <= a.getHighX()) && (y >= a.getHighY()))
/*     */       {
/*  80 */         AreaList.applyAction(a.getActionName(), a.isOnTouch());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setWalkable(ArrayList<Walkable> walkable)
/*     */   {
/*  91 */     this.walkable = walkable;
/*     */   }
/*     */ 
/*     */   public ArrayList<Walkable> getWalkable()
/*     */   {
/*  96 */     return this.walkable;
/*     */   }
/*     */ 
/*     */   public void setAction(ArrayList<ActionSpace> action) {
/* 100 */     this.action = action;
/*     */   }
/*     */ 
/*     */   public List<ActionSpace> getAction()
/*     */   {
/* 105 */     return this.action;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     maps.Area
 * JD-Core Version:    0.6.2
 */