/*    */ package connections;
/*    */ 
/*    */ import GUI.GamePanel;
/*    */ import GUI.bank.BankGUI;
/*    */ import Game.Game;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.net.Socket;
/*    */ import players.Config;
/*    */ import players.Player;
/*    */ import players.PlayerList;
/*    */ 
/*    */ public class Command
/*    */ {
/* 16 */   private static Command command = null;
/* 17 */   private static String lastCommandRecieved = null;
/* 18 */   private int counter = 0;
/*    */ 
/*    */   public static Command getInstance()
/*    */   {
/* 26 */     if (command == null) {
/* 27 */       command = new Command();
/*    */     }
/* 29 */     return command;
/*    */   }
/*    */ 
/*    */   public void sendCommand(String commandName, String commandSyntax)
/*    */   {
/* 34 */     if (commandName.equalsIgnoreCase("openbank")) {
/* 35 */       GamePanel.getInstance().closeAllMenus();
/*    */     }
/* 37 */     if (commandName.startsWith("openShop")) {
/* 38 */       GamePanel.getInstance().closeAllMenus();
/*    */     }
/*    */     try
/*    */     {
/* 42 */       Socket socket = Game.getInstance().getServerSocket();
/* 43 */       String rawStringToSend = "COMMAND=" + commandName + ";USERID=" + Config.USERNAME + ";" + commandSyntax;
/*    */ 
/* 45 */       byte[] encryptedBytesToSend = PublicKeyManager.encrypt(rawStringToSend, Config.PUBLIC_KEY);
/* 46 */       int byteLength = encryptedBytesToSend.length;
/*    */ 
/* 48 */       DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
/* 49 */       outputStream.writeInt(byteLength);
/* 50 */       outputStream.write(encryptedBytesToSend);
/* 51 */       outputStream.flush();
/*    */     }
/*    */     catch (IOException e) {
/* 54 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void teleportPlayer(int map, int x, int y)
/*    */   {
/* 60 */     Config.canWalkThroughWalls = false;
/* 61 */     GamePanel.getInstance().setLoading(true);
/* 62 */     PlayerList.getInstance().getPlayer(Config.USERNAME).setCanWalk(false);
/* 63 */     x -= 15;
/* 64 */     y -= 65;
/*    */ 
/* 67 */     PlayerList.getInstance().getLocalPlayer().telePlayer(x, y);
/*    */ 
/* 69 */     sendCommand("teleport", "MAP=" + map + ";" + "X=" + x + ";" + "Y=" + y);
/*    */   }
/*    */ 
/*    */   public void commandRecieved(String cmd)
/*    */   {
/* 74 */     if (lastCommandRecieved == null)
/*    */     {
/* 76 */       applyCommand(cmd);
/*    */     }
/* 78 */     else if (!lastCommandRecieved.equalsIgnoreCase(cmd)) {
/* 79 */       applyCommand(cmd);
/*    */     }
/* 81 */     lastCommandRecieved = cmd;
/*    */   }
/*    */ 
/*    */   private void applyCommand(String cmd)
/*    */   {
/* 88 */     System.out.println(cmd);
/*    */ 
/* 90 */     if (cmd.equals("openbank"))
/* 91 */       GamePanel.getInstance().getBankGUI().openBank();
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     connections.Command
 * JD-Core Version:    0.6.2
 */