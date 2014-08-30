/*     */ package players;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ public class PlayerList
/*     */   implements Serializable
/*     */ {
/*  13 */   private static PlayerList playerlist = null;
/*     */ 
/*  15 */   public List<Player> playersLoggedIn = new CopyOnWriteArrayList();
/*     */ 
/*     */   public Player getLocalPlayer()
/*     */   {
/*  24 */     return getPlayer(Config.USERNAME);
/*     */   }
/*     */ 
/*     */   public static PlayerList getInstance()
/*     */   {
/*  29 */     if (playerlist == null) {
/*  30 */       playerlist = new PlayerList();
/*     */     }
/*  32 */     return playerlist;
/*     */   }
/*     */ 
/*     */   public void playerLogin(Player player)
/*     */   {
/*  37 */     this.playersLoggedIn.add(player);
/*     */   }
/*     */ 
/*     */   public List<Player> getPlayers()
/*     */   {
/*  42 */     return this.playersLoggedIn;
/*     */   }
/*     */ 
/*     */   public void setPlayers(ArrayList<Player> players)
/*     */   {
/*  47 */     this.playersLoggedIn = players;
/*     */   }
/*     */ 
/*     */   public Player getPlayer(String username)
/*     */   {
/*  52 */     for (Player p : this.playersLoggedIn)
/*     */     {
/*  54 */       if (p.getUsername().equals(username))
/*  55 */         return p;
/*     */     }
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */   public void overwritePlayer(Player player)
/*     */   {
/*  62 */     player.lowerCaseUsername();
/*     */ 
/*  64 */     if (this.playersLoggedIn.size() == 0)
/*     */     {
/*  66 */       this.playersLoggedIn.add(player);
/*  67 */       return;
/*     */     }
/*     */ 
/*  70 */     boolean playerExists = false;
/*     */ 
/*  72 */     for (Player p : this.playersLoggedIn)
/*     */     {
/*  74 */       if (p.getId() == player.getId())
/*     */       {
/*  76 */         playerExists = true;
/*     */ 
/*  78 */         this.playersLoggedIn.remove(p);
/*  79 */         this.playersLoggedIn.add(player);
/*     */       }
/*     */     }
/*     */ 
/*  83 */     if (!playerExists)
/*  84 */       this.playersLoggedIn.add(player);
/*     */   }
/*     */ 
/*     */   public void checkForLogouts()
/*     */   {
/*  91 */     for (Player p : this.playersLoggedIn)
/*     */     {
/*  93 */       if (!p.isLoggedIn())
/*  94 */         this.playersLoggedIn.remove(p);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void logoutPlayer(Player player)
/*     */   {
/* 100 */     for (int i = 0; i > this.playersLoggedIn.size(); i++)
/*     */     {
/* 102 */       if (((Player)this.playersLoggedIn.get(i)).getId() == player.getId())
/*     */       {
/* 104 */         this.playersLoggedIn.remove(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.PlayerList
 * JD-Core Version:    0.6.2
 */