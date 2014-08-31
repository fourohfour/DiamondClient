/*    */ package Game;
/*    */ 
/*    */ import GUI.GUI;
/*    */ import GUI.GamePanel;
/*    */ import connections.ClientNetwork;
/*    */ import java.net.Socket;
/*    */ import maps.AreaList;
/*    */ import npc.NPCList;
/*    */ import players.ItemList;
/*    */ 
/*    */ public class Game
/*    */ {
/* 20 */   private static Game game = null;
/*    */   private ClientNetwork client;
/* 23 */   private Socket socket = null;
/*    */   private boolean threadLoopRuning;
/*    */ 
/*    */   public static Game getInstance()
/*    */   {
/* 34 */     if (game == null) {
/* 35 */       game = new Game();
/*    */     }
/* 37 */     return game;
/*    */   }
/*    */ 
/*    */   public void setClient(ClientNetwork c)
/*    */   {
/* 42 */     this.client = c;
/*    */   }
/*    */ 
/*    */   public ClientNetwork getClientNetwork()
/*    */   {
/* 47 */     return this.client;
/*    */   }
/*    */ 
/*    */   public void setSocket(Socket socket)
/*    */   {
/* 52 */     this.socket = socket;
/*    */   }
/*    */ 
/*    */   public Socket getServerSocket()
/*    */   {
/* 57 */     return this.socket;
/*    */   }
/*    */ 
/*    */   public void init()
/*    */   {
/* 62 */     AreaList.getInstance().loadAreas();
/* 63 */     ItemList.getInstance().loadItems();
/* 64 */     NPCList.getInstance().loadNPCS();
/* 65 */     GamePanel.getInstance().loadFishingSpots();
/* 66 */     GUI.getInstance().loadGame();
/* 67 */     GamePanel.getInstance().startUp();
/*    */   }
/*    */ }