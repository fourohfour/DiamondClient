/*    */ package players;
/*    */ 
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.security.PublicKey;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Config
/*    */ {
/*    */   public static final String CLIENT_VERSION = "0.61";
/* 13 */   public static String recentUpdates = "CLIENT VERSION 0.61<br /><br />* New xp system and curve.<br />Better chant system, hold tab for history";
/*    */   public static final String SERVER_IP = "38.89.137.25";
/*    */   public static final int SERVER_PORT = 3336;
/* 20 */   public static boolean canWalkThroughWalls = true;
/*    */ 
/* 22 */   public static boolean displayPlayers = true;
/*    */ 
/* 24 */   public static PublicKey PUBLIC_KEY = null;
/*    */   public static String USERNAME;
/*    */   public static final int REFRESH_RATE = 50;
/* 29 */   public static boolean playerIsMoving = false;
/*    */   public static String lastPlayerDirection;
/*    */   public static final String CACHE_URL = "";
/* 35 */   public static String itemAmountHexColor = "#FFFF00";
/*    */ 
/* 37 */   public static boolean debugMode = true;
/*    */   public static final String PUBLIC_KEY_FILE = "publickey";
/* 44 */   public static ArrayList<String> notWalkableAreas = new ArrayList();
/* 45 */   public static String mapName = null;
/* 46 */   public static boolean shopIsOpen = false;
/*    */ 
/*    */   public static void saveNotWalkableToFile()
/*    */   {
/*    */     try
/*    */     {
/* 53 */       PrintWriter writer = new PrintWriter("areaWalakbleConfig.txt", "UTF-8");
/*    */ 
/* 55 */       for (String s : notWalkableAreas) {
/* 56 */         writer.println(mapName + s);
/*    */       }
/* 58 */       writer.close();
/*    */     }
/*    */     catch (FileNotFoundException e) {
/* 61 */       e.printStackTrace();
/*    */     } catch (UnsupportedEncodingException e) {
/* 63 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 67 */     System.out.println("Succesfully saved file");
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.Config
 * JD-Core Version:    0.6.2
 */