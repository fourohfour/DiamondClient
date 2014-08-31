/*    */ package players;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class SkillList
/*    */ {
/*  7 */   private static SkillList skillList = null;
/*  8 */   private ArrayList<Skill> skills = new ArrayList();
/*    */   
/*    */   public static SkillList getInstance()
/*    */   {
/* 17 */     if (skillList == null) {
/* 18 */       skillList = new SkillList();
/*    */     }
/* 20 */     return skillList;
/*    */   }
/*    */ 
/*    */   public void addGameSkill(Skill s)
/*    */   {
/* 27 */     this.skills.add(s);
/*    */   }
/*    */ 
/*    */   public ArrayList<Skill> getSkills()
/*    */   {
/* 32 */     return this.skills;
/*    */   }
/*    */ 
/*    */   public void setSkills(ArrayList<Skill> skills)
/*    */   {
/* 37 */     this.skills = skills;
/*    */   }
/*    */ }