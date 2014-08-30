/*    */ package players;
/*    */ 
/*    */ public class Flag
/*    */ {
/*    */   private String flagName;
/*    */   private String flagValue;
/*    */ 
/*    */   public Flag(String name, String value)
/*    */   {
/* 10 */     this.flagName = name;
/* 11 */     this.flagValue = value;
/*    */   }
/*    */ 
/*    */   public String getFlagName() {
/* 15 */     return this.flagName;
/*    */   }
/*    */   public void setFlagName(String flagName) {
/* 18 */     this.flagName = flagName;
/*    */   }
/*    */   public String getFlagValue() {
/* 21 */     return this.flagValue;
/*    */   }
/*    */   public void setFlagValue(String flagValue) {
/* 24 */     this.flagValue = flagValue;
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.Flag
 * JD-Core Version:    0.6.2
 */