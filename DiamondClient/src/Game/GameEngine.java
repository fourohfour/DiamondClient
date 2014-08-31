/*     */ package Game;
/*     */ 
/*     */ import GUI.GamePanel;
/*     */ import GUI.InventoryGUI;
/*     */ import connections.Command;
/*     */ import players.Config;
/*     */ import players.Player;
/*     */ import players.PlayerList;
/*     */ 
/*     */ public class GameEngine extends Thread
/*     */ {
/*  13 */   private Game game = null;
/*  14 */   private boolean gameIsRunning = false;
/*  15 */   private boolean GameEngineRunningThread = true;
/*  16 */   int secondTimerTick = 0;
/*     */ 
/*  18 */   int chatInterval = 0;
/*     */ 
/*     */   public GameEngine(Game game) {
/*  21 */     this.game = game;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*  28 */     Player player = PlayerList.getInstance().getPlayer(Config.USERNAME);
/*  29 */     while (this.GameEngineRunningThread)
/*     */     {
/*     */       try
/*     */       {
/*  33 */         Thread.sleep(50L);
/*  34 */         this.secondTimerTick += 50;
/*     */ 
/*  36 */         if (this.secondTimerTick == 1000)
/*     */         {
/*  38 */           oneSecondTick();
/*  39 */           this.secondTimerTick = 0;
/*     */         }
/*     */ 
/*  42 */         if (PlayerList.getInstance().getLocalPlayer().getCanWalk())
/*     */         {
/*  44 */           if ((player.getLastPositionX() != player.getX()) || (player.getLastPositionY() != player.getY()))
/*     */           {
/*  46 */             Command.getInstance().sendCommand("move", "X=" + player.getX() + ";Y=" + player.getY());
/*  47 */             player.setLastPositionX(player.getX());
/*  48 */             player.setLastPositionY(player.getY());
/*     */           }
/*     */ 
/*  52 */           if (Config.playerIsMoving) {
/*  53 */             player.movePlayer(Config.lastPlayerDirection);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*  59 */         if ((player.getChat().length() > 0) && (this.chatInterval == 0)) {
/*  60 */           this.chatInterval = 100;
/*     */         }
/*  62 */         if (this.chatInterval > 0)
/*     */         {
/*  64 */           this.chatInterval -= 1;
/*  65 */           if (this.chatInterval == 0) {
/*  66 */             player.setChat("");
/*     */           }
/*     */         }
/*  69 */         GamePanel.getInstance().refresh();
/*     */       }
/*     */       catch (InterruptedException e)
/*     */       {
/*  73 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void oneSecondTick() {
/*  79 */     GamePanel.getInstance().getInventory().refreshItems();
/*     */   }
/*     */ 
/*     */   public void runGameEngine(boolean b)
/*     */   {
/*  84 */     this.gameIsRunning = b;
/*     */     try {
/*  86 */       if (!this.gameIsRunning)
/*  87 */         interrupt();
/*     */     } catch (Throwable e) {
/*  89 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isGameEngineRunningThread()
/*     */   {
/*  95 */     return this.GameEngineRunningThread;
/*     */   }
/*     */ 
/*     */   public void setGameEngineRunningThread(boolean gameEngineRunningThread)
/*     */   {
/* 100 */     this.GameEngineRunningThread = gameEngineRunningThread;
/*     */   }
/*     */ }