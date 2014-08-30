/*    */ package GUI;
/*    */ 
/*    */ import javax.swing.JFrame;
/*    */ import players.Config;
/*    */ import players.PlayerList;
/*    */ 
/*    */ public class GUI extends JFrame
/*    */ {
/* 14 */   private static GUI gui = null;
/*    */ 
/* 16 */   private final int FRAME_SIZE_X = 800;
/* 17 */   private final int FRAME_SIZE_Y = 600;
/*    */ 
/* 19 */   private final String FRAME_TITLE = "Diamond Hunt - Version 0.61";
/*    */   private LaunchPanel startupPanel;
/*    */ 
/*    */   public static GUI getInstance()
/*    */   {
/* 32 */     if (gui == null) {
/* 33 */       gui = new GUI();
/*    */     }
/* 35 */     return gui;
/*    */   }
/*    */ 
/*    */   public void init()
/*    */   {
/* 40 */     setSize(800, 600);
/* 41 */     setTitle("Diamond Hunt - Version 0.61");
/* 42 */     setDefaultCloseOperation(3);
/* 43 */     setResizable(false);
/* 44 */     this.startupPanel = new LaunchPanel();
/* 45 */     setContentPane(this.startupPanel);
/* 46 */     setVisible(true);
/* 47 */     this.startupPanel.startup();
/*    */   }
/*    */ 
/*    */   public void loadGame()
/*    */   {
/* 57 */     remove(this.startupPanel);
/*    */ 
/* 59 */     setContentPane(GamePanel.getInstance());
/* 60 */     revalidate();
/*    */   }
/*    */ 
/*    */   public void dropClient()
/*    */   {
/* 65 */     PlayerList.getInstance().logoutPlayer(PlayerList.getInstance().getPlayer(Config.USERNAME));
/* 66 */     remove(GamePanel.getInstance());
/* 67 */     this.startupPanel = new LaunchPanel();
/* 68 */     setContentPane(this.startupPanel);
/* 69 */     this.startupPanel.startup();
/* 70 */     revalidate();
/*    */   }
/*    */ 
/*    */   public LaunchPanel getLaunchPanel()
/*    */   {
/* 76 */     return this.startupPanel;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.GUI
 * JD-Core Version:    0.6.2
 */