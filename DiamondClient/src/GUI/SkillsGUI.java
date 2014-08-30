/*     */ package GUI;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;

/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JLayeredPane;
/*     */ import javax.swing.JPanel;

/*     */ import players.Config;
/*     */ import players.Player;
/*     */ import players.PlayerList;
/*     */ import players.Skill;
/*     */ import players.SkillList;
/*     */ import players.XPTable;
/*     */ 
/*     */ public class SkillsGUI extends JLayeredPane
/*     */ {
/*  19 */   private boolean skillsIsOpen = false;
/*     */   JPanel skillsPanel;
/*  22 */   private final int SIZE_X = 300;
/*  23 */   private final int SIZE_Y = 400;
/*     */ 
/*     */   public SkillsGUI()
/*     */   {
/*  27 */     setLayout(null);
/*  28 */     setBounds(2, 40, 300, 400);
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/*  33 */     this.skillsPanel = new JPanel();
/*  34 */     this.skillsPanel.setLayout(null);
/*  35 */     this.skillsPanel.setBounds(0, 0, 300, 400);
/*  36 */     this.skillsPanel.setBackground(Color.decode("#D7D7D7"));
/*     */ 
/*  38 */     setLayer(this.skillsPanel, 1);
/*  39 */     add(this.skillsPanel);
/*  40 */     setVisible(this.skillsIsOpen);
/*     */   }
/*     */ 
/*     */   public void refreshSkills(ArrayList<Skill> skills)
/*     */   {
/*  45 */     this.skillsPanel.removeAll();
/*     */ 
/*  47 */     JLabel skillNameTitle = new JLabel("Skill");
/*  48 */     JLabel skillLevelTitle = new JLabel("Level");
/*  49 */     JLabel skillXpTitle = new JLabel("XP");
/*     */ 
/*  51 */     skillNameTitle.setBounds(10, 5, 40, 15);
/*  52 */     skillLevelTitle.setBounds(120, 5, 40, 15);
/*  53 */     skillXpTitle.setBounds(175, 5, 20, 15);
/*     */ 
/*  55 */     this.skillsPanel.add(skillNameTitle);
/*  56 */     this.skillsPanel.add(skillLevelTitle);
/*  57 */     this.skillsPanel.add(skillXpTitle);
/*     */ 
/*  60 */     int y = 40;
/*  61 */     int globalLevel = 0;
/*  62 */     int globalXp = 0;
/*     */ 
/*  64 */     for (Skill s : skills)
/*     */     {
/*  67 */       JLabel skillName = new JLabel(s.getName());
/*  68 */       JLabel skillLevel = new JLabel(String.valueOf(s.getLevel()));
/*  69 */       JLabel skillXP = new JLabel(s.getXp() + "/" + XPTable.getXpRequiredToLevelUp(s.getLevel()));
/*     */ 
/*  71 */       skillName.setBounds(5, y, 90, 15);
/*  72 */       skillLevel.setBounds(120, y, 90, 15);
/*  73 */       skillXP.setBounds(175, y, 120, 15);
/*     */ 
/*  75 */       this.skillsPanel.add(skillName);
/*  76 */       this.skillsPanel.add(skillLevel);
/*  77 */       this.skillsPanel.add(skillXP);
/*     */ 
/*  79 */       y += 20;
/*     */ 
/*  81 */       globalLevel += s.getLevel();
/*  82 */       globalXp += s.getXp();
/*     */     }
/*     */ 
/*  86 */     JLabel skillName = new JLabel("Global");
/*  87 */     JLabel skillLevel = new JLabel(String.valueOf(globalLevel));
/*  88 */     JLabel skillXP = new JLabel(String.valueOf(globalXp));
/*     */ 
/*  90 */     skillName.setBounds(5, y, 90, 15);
/*  91 */     skillLevel.setBounds(120, y, 90, 15);
/*  92 */     skillXP.setBounds(175, y, 120, 15);
/*     */ 
/*  94 */     this.skillsPanel.add(skillName);
/*  95 */     this.skillsPanel.add(skillLevel);
/*  96 */     this.skillsPanel.add(skillXP);
/*     */ 
/*  99 */     y += 30;
/*     */ 
/* 101 */     JLabel hpTitle = new JLabel("Life Points");
/* 102 */     JLabel hpLevel = new JLabel(PlayerList.getInstance().getPlayer(Config.USERNAME).getHitpoints() + "/" + PlayerList.getInstance().getPlayer(Config.USERNAME).getMaxHitPoints());
/* 103 */     hpTitle.setFont(new Font("System", 1, 12));
/* 104 */     hpLevel.setFont(new Font("System", 1, 12));
/*     */ 
/* 106 */     hpTitle.setForeground(Color.red);
/* 107 */     hpLevel.setForeground(Color.red);
/*     */ 
/* 109 */     hpTitle.setBounds(5, y, 90, 15);
/* 110 */     hpLevel.setBounds(120, y, 90, 15);
/*     */ 
/* 112 */     this.skillsPanel.add(hpTitle);
/* 113 */     this.skillsPanel.add(hpLevel);
/*     */ 
/* 115 */     y += 20;
/*     */ 
/* 117 */     JLabel attackBonusTitle = new JLabel("Attack Bonus");
/* 118 */     JLabel attackBonusValue = new JLabel(String.valueOf(PlayerList.getInstance().getPlayer(Config.USERNAME).getAttackBonus()));
/* 119 */     attackBonusTitle.setFont(new Font("System", 1, 12));
/* 120 */     attackBonusValue.setFont(new Font("System", 1, 12));
/*     */ 
/* 122 */     attackBonusTitle.setBounds(5, y, 90, 15);
/* 123 */     attackBonusValue.setBounds(120, y, 90, 15);
/*     */ 
/* 125 */     this.skillsPanel.add(attackBonusTitle);
/* 126 */     this.skillsPanel.add(attackBonusValue);
/*     */ 
/* 128 */     y += 20;
/*     */ 
/* 130 */     JLabel defenceBonusTitle = new JLabel("Defence Bonus");
/* 131 */     JLabel defenceBonusValue = new JLabel(String.valueOf(PlayerList.getInstance().getPlayer(Config.USERNAME).getDefenceBonus()));
/* 132 */     defenceBonusTitle.setFont(new Font("System", 1, 12));
/* 133 */     defenceBonusValue.setFont(new Font("System", 1, 12));
/*     */ 
/* 135 */     defenceBonusTitle.setBounds(5, y, 90, 15);
/* 136 */     defenceBonusValue.setBounds(120, y, 90, 15);
/*     */ 
/* 138 */     this.skillsPanel.add(defenceBonusTitle);
/* 139 */     this.skillsPanel.add(defenceBonusValue);
/*     */ 
/* 142 */     y += 30;
/*     */ 
/* 144 */     JLabel energyTitle = new JLabel("Energy");
/* 145 */     JLabel energyLevel = new JLabel(PlayerList.getInstance().getPlayer(Config.USERNAME).getEnergy() + "%");
/* 146 */     energyTitle.setFont(new Font("System", 1, 12));
/* 147 */     energyLevel.setFont(new Font("System", 1, 12));
/*     */ 
/* 149 */     energyTitle.setForeground(Color.decode("#B2B200"));
/* 150 */     energyLevel.setForeground(Color.decode("#B2B200"));
/*     */ 
/* 152 */     energyTitle.setBounds(5, y, 90, 15);
/* 153 */     energyLevel.setBounds(120, y, 90, 15);
/*     */ 
/* 155 */     this.skillsPanel.add(energyTitle);
/* 156 */     this.skillsPanel.add(energyLevel);
/*     */   }
/*     */ 
/*     */   public void toggleSkills()
/*     */   {
/* 162 */     if (this.skillsIsOpen) {
/* 163 */       this.skillsIsOpen = false;
/*     */     }
/*     */     else {
/* 166 */       this.skillsIsOpen = true;
/* 167 */       refreshSkills(SkillList.getInstance().getSkills());
/*     */     }
/*     */ 
/* 170 */     setVisible(this.skillsIsOpen);
/*     */ 
/* 172 */     revalidate();
/*     */   }
/*     */ 
/*     */   public void forceClose()
/*     */   {
/* 177 */     this.skillsIsOpen = false;
/* 178 */     setVisible(this.skillsIsOpen);
/* 179 */     revalidate();
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.SkillsGUI
 * JD-Core Version:    0.6.2
 */