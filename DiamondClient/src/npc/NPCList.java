/*    */ package npc;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class NPCList
/*    */ {
/* 10 */   private static NPCList npcList = null;
/* 11 */   private ArrayList<NPC> npcs = new ArrayList();
/*    */ 
/*    */   public static NPCList getInstance()
/*    */   {
/* 20 */     if (npcList == null) {
/* 21 */       npcList = new NPCList();
/*    */     }
/* 23 */     return npcList;
/*    */   }
/*    */ 
/*    */   public NPC getNpc(int uniqueId)
/*    */   {
/* 28 */     for (NPC n : this.npcs)
/*    */     {
/* 30 */       if (n.getUniqueId() == uniqueId) {
/* 31 */         return n;
/*    */       }
/*    */     }
/* 34 */     System.out.println("ERROR - UNIQUE NPC NOT FOUND");
/* 35 */     return null;
/*    */   }
/*    */ 
/*    */   public void overwriteNPC(NPC n)
/*    */   {
/* 40 */     for (int i = 0; i < this.npcs.size(); i++)
/*    */     {
/* 42 */       if (n.getUniqueId() == ((NPC)this.npcs.get(i)).getUniqueId())
/*    */       {
/* 44 */         this.npcs.set(i, n);
/* 45 */         return;
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void loadNPCS()
/*    */   {
/* 53 */     this.npcs.add(new NPC(0, "Small Bug", "A small bug", 2, 2, 2, false, 0, 100, 400));
/* 54 */     this.npcs.add(new NPC(1, "Wolf", "A small Wolf", 5, 5, 6, false, 12, 380, 266));
/* 55 */     this.npcs.add(new NPC(2, "Wolf", "A small Wolf", 5, 5, 6, false, 12, 542, 315));
/* 56 */     this.npcs.add(new NPC(5, "Small Bug", "A small bug", 2, 2, 2, false, 3, 555, 258));
/*    */ 
/* 58 */     this.npcs.add(new NPC(3, "Wolf", "A small Wolf", 5, 5, 6, false, 14, 50, 199));
/* 59 */     this.npcs.add(new NPC(4, "Wolf", "A small Wolf", 5, 5, 6, false, 14, 40, 265));
/* 60 */     this.npcs.add(new NPC(6, "Wolf", "A small Wolf", 5, 5, 6, false, 14, 50, 365));
/* 61 */     this.npcs.add(new NPC(7, "Wolf", "A small Wolf", 5, 5, 6, false, 14, 470, 400));
/* 62 */     this.npcs.add(new NPC(8, "Wolf", "A small Wolf", 5, 5, 6, false, 14, 473, 309));
/*    */ 
/* 64 */     this.npcs.add(new NPC(9, "Buffalo", "A Buffalo", 35, 35, 42, false, 15, 150, 76));
/*    */ 
/* 66 */     this.npcs.add(new NPC(10, "Small Bug", "A small bug", 2, 2, 2, false, 5, 151, 264));
/*    */ 
/* 68 */     this.npcs.add(new NPC(11, "Aqualex", "A water based npc", 18, 18, 18, false, 8, 308, 228));
/* 69 */     this.npcs.add(new NPC(12, "Aqualex", "A water based npc", 18, 18, 18, false, 8, 57, 322));
/* 70 */     this.npcs.add(new NPC(13, "Aqualex", "A water based npc", 18, 18, 18, false, 8, 596, 323));
/*    */   }
/*    */ 
/*    */   public ArrayList<NPC> getNPCS()
/*    */   {
/* 78 */     return this.npcs;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     npc.NPCList
 * JD-Core Version:    0.6.2
 */