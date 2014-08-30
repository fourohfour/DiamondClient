/*    */ package players;
/*    */ 
/*    */ public class Skill
/*    */ {
/*    */   private String name;
/*    */   private int level;
/*    */   private int xp;
/*    */ 
/*    */   public Skill(String name, int level, int xp)
/*    */   {
/* 13 */     this.name = name;
/* 14 */     this.level = level;
/* 15 */     this.xp = xp;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 19 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 23 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public int getLevel() {
/* 27 */     return XPTable.getLevel(this.xp);
/*    */   }
/*    */ 
/*    */   public void setLevel(int level) {
/* 31 */     this.level = level;
/*    */   }
/*    */ 
/*    */   public int getXp() {
/* 35 */     return this.xp;
/*    */   }
/*    */ 
/*    */   public void setXp(int xp) {
/* 39 */     this.xp = xp;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.Skill
 * JD-Core Version:    0.6.2
 */