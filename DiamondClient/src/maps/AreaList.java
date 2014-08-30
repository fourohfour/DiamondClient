/*     */ package maps;
/*     */ 
/*     */ import GUI.GamePanel;
/*     */ import GUI.InputBox;
/*     */ import GUI.ShopGui;
/*     */ import connections.Command;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import players.Config;
/*     */ import players.Player;
/*     */ import players.PlayerList;
/*     */ import players.ShopList;
/*     */ 
/*     */ public class AreaList
/*     */ {
/*  16 */   private HashMap<Integer, Area> areas = new HashMap();
/*  17 */   private static AreaList areaLoading = null;
/*     */ 
/*     */   public static AreaList getInstance()
/*     */   {
/*  26 */     if (areaLoading == null) {
/*  27 */       areaLoading = new AreaList();
/*     */     }
/*  29 */     return areaLoading;
/*     */   }
/*     */ 
/*     */   public void loadAreas()
/*     */   {
/*  36 */     Area startingArea0 = new Area(0, "Starting Area", "cache/graphics/tiles/0.png");
/*  37 */     startingArea0.getWalkable().add(new Walkable(2, 222, 421, 1));
/*  38 */     startingArea0.getWalkable().add(new Walkable(416, 352, 701, 197));
/*  39 */     startingArea0.getWalkable().add(new Walkable(679, 205, 714, 0));
/*  40 */     startingArea0.getWalkable().add(new Walkable(619, 571, 800, 476));
/*  41 */     startingArea0.getWalkable().add(new Walkable(736, 495, 792, 3));
/*  42 */     startingArea0.getAction().add(new ActionSpace("teleportToStartingBankAndInn", 520, 69, 604, 4, true));
/*  43 */     startingArea0.getAction().add(new ActionSpace("climbLadder", 491, 409, 632, 280, false));
/*  44 */     startingArea0.getAction().add(new ActionSpace("climbDownLadder", 498, 245, 626, 164, false));
/*  45 */     this.areas.put(Integer.valueOf(startingArea0.getId()), startingArea0);
/*     */ 
/*  48 */     Area startingArea1 = new Area(1, "Camp 1", "cache/graphics/tiles/1.png");
/*  49 */     startingArea1.getAction().add(new ActionSpace("teleportFromCamp1ToCamp2", 233, 70, 327, 0, true));
/*  50 */     startingArea1.getAction().add(new ActionSpace("teleportToStartingMiningArea", 1, 343, 41, 268, true));
/*  51 */     startingArea1.getAction().add(new ActionSpace("teleportToStartingBank", 383, 316, 417, 258, true));
/*  52 */     startingArea1.getAction().add(new ActionSpace("teleportToStartingInn", 608, 318, 640, 257, true));
/*  53 */     startingArea1.getAction().add(new ActionSpace("cook", 240, 343, 344, 233, false));
/*  54 */     startingArea1.getWalkable().add(new Walkable(324, 320, 382, 39));
/*  55 */     startingArea1.getWalkable().add(new Walkable(323, 251, 481, 38));
/*  56 */     startingArea1.getWalkable().add(new Walkable(417, 317, 481, 37));
/*  57 */     startingArea1.getWalkable().add(new Walkable(95, 460, 517, 415));
/*  58 */     startingArea1.getWalkable().add(new Walkable(40, 535, 476, 479));
/*  59 */     startingArea1.getWalkable().add(new Walkable(710, 541, 793, 325));
/*  60 */     startingArea1.getWalkable().add(new Walkable(543, 321, 605, 71));
/*  61 */     startingArea1.getWalkable().add(new Walkable(608, 255, 667, 66));
/*  62 */     startingArea1.getWalkable().add(new Walkable(640, 318, 704, 64));
/*  63 */     this.areas.put(Integer.valueOf(startingArea1.getId()), startingArea1);
/*     */ 
/*  66 */     Area bankStartingArea = new Area(2, "Bank 1", "cache/graphics/tiles/2.png");
/*  67 */     this.areas.put(Integer.valueOf(bankStartingArea.getId()), bankStartingArea);
/*  68 */     bankStartingArea.getAction().add(new ActionSpace("teleportToStartingAreaFromBank", 350, 570, 504, 541, true));
/*  69 */     bankStartingArea.getAction().add(new ActionSpace("openbank", 253, 499, 336, 255, false));
/*  70 */     bankStartingArea.getAction().add(new ActionSpace("openbank", 253, 293, 604, 254, false));
/*  71 */     bankStartingArea.getAction().add(new ActionSpace("openbank", 527, 565, 602, 255, false));
/*     */ 
/*  75 */     Area mineStartingArea3 = new Area(3, "Path 1", "cache/graphics/tiles/3.png");
/*  76 */     mineStartingArea3.getAction().add(new ActionSpace("teleportToStartingAreaFromMine", 768, 380, 793, 297, true));
/*  77 */     mineStartingArea3.getAction().add(new ActionSpace("teleportToStartingArea", 595, 567, 704, 521, true));
/*  78 */     mineStartingArea3.getAction().add(new ActionSpace("mineStone", 294, 368, 443, 239, false));
/*  79 */     mineStartingArea3.getAction().add(new ActionSpace("mineCopper", 308, 485, 427, 415, false));
/*  80 */     mineStartingArea3.getAction().add(new ActionSpace("chopTree", 162, 231, 438, 35, false));
/*  81 */     mineStartingArea3.getAction().add(new ActionSpace("fishShrimp", 128, 351, 193, 274, false));
/*  82 */     mineStartingArea3.getWalkable().add(new Walkable(315, 341, 351, 302));
/*  83 */     mineStartingArea3.getWalkable().add(new Walkable(358, 341, 395, 302));
/*  84 */     mineStartingArea3.getWalkable().add(new Walkable(387, 319, 428, 284));
/*  85 */     mineStartingArea3.getWalkable().add(new Walkable(342, 307, 386, 270));
/*  86 */     mineStartingArea3.getWalkable().add(new Walkable(324, 464, 410, 426));
/*  87 */     mineStartingArea3.getWalkable().add(new Walkable(390, 64, 763, -5));
/*  88 */     mineStartingArea3.getWalkable().add(new Walkable(544, 159, 587, 39));
/*  89 */     mineStartingArea3.getWalkable().add(new Walkable(643, 223, 762, 30));
/*  90 */     mineStartingArea3.getWalkable().add(new Walkable(93, 193, 162, 87));
/*  91 */     mineStartingArea3.getWalkable().add(new Walkable(164, 190, 268, 31));
/*  92 */     mineStartingArea3.getWalkable().add(new Walkable(98, 194, 225, 114));
/*  93 */     mineStartingArea3.getWalkable().add(new Walkable(262, 219, 309, 175));
/*  94 */     mineStartingArea3.getWalkable().add(new Walkable(232, 202, 335, 61));
/*  95 */     mineStartingArea3.getWalkable().add(new Walkable(326, 189, 371, 160));
/*  96 */     mineStartingArea3.getWalkable().add(new Walkable(297, 162, 401, 24));
/*  97 */     mineStartingArea3.getWalkable().add(new Walkable(443, 161, 485, 120));
/*  98 */     mineStartingArea3.getWalkable().add(new Walkable(222, 289, 259, 251));
/*  99 */     mineStartingArea3.getWalkable().add(new Walkable(185, 385, 228, 344));
/* 100 */     mineStartingArea3.getWalkable().add(new Walkable(250, 386, 294, 346));
/* 101 */     mineStartingArea3.getWalkable().add(new Walkable(-10, 600, 257, 384));
/* 102 */     mineStartingArea3.getWalkable().add(new Walkable(230, 600, 288, 436));
/* 103 */     mineStartingArea3.getWalkable().add(new Walkable(-10, 475, 156, 224));
/* 104 */     mineStartingArea3.getWalkable().add(new Walkable(-10, 269, 104, 146));
/* 105 */     mineStartingArea3.getWalkable().add(new Walkable(-10, 96, 161, -5));
/* 106 */     this.areas.put(Integer.valueOf(mineStartingArea3.getId()), mineStartingArea3);
/*     */ 
/* 109 */     Area InngArea4 = new Area(4, "Inn 1", "cache/graphics/tiles/4.png");
/* 110 */     InngArea4.getAction().add(new ActionSpace("teleportToStartingAreaFRomInn", 347, 580, 505, 531, true));
/* 111 */     InngArea4.getAction().add(new ActionSpace("sleep", 216, 562, 321, 315, false));
/* 112 */     InngArea4.getAction().add(new ActionSpace("sleep", 536, 565, 643, 297, false));
/* 113 */     this.areas.put(Integer.valueOf(InngArea4.getId()), InngArea4);
/*     */ 
/* 116 */     Area areaCamp2 = new Area(5, "Camp 2", "cache/graphics/tiles/5.png");
/* 117 */     areaCamp2.getAction().add(new ActionSpace("teleportFromCamp2ToCamp1", 221, 590, 327, 506, true));
/* 118 */     areaCamp2.getWalkable().add(new Walkable(-10, 255, 135, 95));
/* 119 */     areaCamp2.getWalkable().add(new Walkable(127, 188, 219, 39));
/* 120 */     areaCamp2.getWalkable().add(new Walkable(222, 140, 282, 42));
/* 121 */     areaCamp2.getWalkable().add(new Walkable(254, 187, 390, 35));
/* 122 */     areaCamp2.getWalkable().add(new Walkable(387, 177, 487, -5));
/* 123 */     areaCamp2.getAction().add(new ActionSpace("teleportFromCamp2ToGeneralStore1", 216, 191, 267, 112, true));
/* 124 */     areaCamp2.getWalkable().add(new Walkable(471, 95, 588, -5));
/* 125 */     areaCamp2.getWalkable().add(new Walkable(528, 177, 805, -5));
/* 126 */     areaCamp2.getWalkable().add(new Walkable(671, 392, 805, 176));
/* 127 */     areaCamp2.getWalkable().add(new Walkable(452, 468, 805, 398));
/* 128 */     areaCamp2.getWalkable().add(new Walkable(665, 416, 805, 346));
/* 129 */     areaCamp2.getWalkable().add(new Walkable(394, 600, 534, 517));
/* 130 */     areaCamp2.getAction().add(new ActionSpace("fixBridge", 619, 333, 695, 240, false));
/* 131 */     areaCamp2.getAction().add(new ActionSpace("fishSardine", 588, 225, 692, 154, false));
/* 132 */     areaCamp2.getWalkable().add(new Walkable(507, 516, 564, 455));
/* 133 */     areaCamp2.getWalkable().add(new Walkable(443, 432, 683, 372));
/* 134 */     areaCamp2.getAction().add(new ActionSpace("teleportFromCamp2ToBlacksmith1", 487, 178, 532, 96, true));
/* 135 */     areaCamp2.getAction().add(new ActionSpace("teleportFrom5to8", 2, 403, 42, 33, true));
/*     */ 
/* 138 */     this.areas.put(Integer.valueOf(areaCamp2.getId()), areaCamp2);
/*     */ 
/* 140 */     Area InngArea7 = new Area(7, "Path 2", "cache/graphics/tiles/7.png");
/* 141 */     this.areas.put(Integer.valueOf(InngArea7.getId()), InngArea7);
/*     */ 
/* 143 */     Area InngArea8 = new Area(8, "Path 3", "cache/graphics/tiles/8.png");
/* 144 */     InngArea8.getAction().add(new ActionSpace("teleportFrom8to9", 315, 80, 429, 3, true));
/* 145 */     InngArea8.getAction().add(new ActionSpace("teleportFrom8to5", 761, 296, 789, 222, true));
/* 146 */     InngArea8.getAction().add(new ActionSpace("teleportFrom8to15", 4, 350, 49, 226, true));
/* 147 */     InngArea8.getAction().add(new ActionSpace("fillVialsWater", 36, 260, 165, 121, false));
/* 148 */     InngArea8.getAction().add(new ActionSpace("chopTree", 473, 172, 609, 7, false));
/* 149 */     InngArea8.getAction().add(new ActionSpace("chopTree", 632, 198, 760, 28, false));
/* 150 */     InngArea8.getAction().add(new ActionSpace("chopTree", 442, 417, 579, 252, false));
/* 151 */     InngArea8.getAction().add(new ActionSpace("chopTree", 639, 518, 769, 338, false));
/*     */ 
/* 153 */     InngArea8.getAction().add(new ActionSpace("chopTree", -10, 162, 126, 10, false));
/* 154 */     this.areas.put(Integer.valueOf(InngArea8.getId()), InngArea8);
/*     */ 
/* 156 */     Area InngArea9 = new Area(9, "Cave Entrance 1", "cache/graphics/tiles/9.png");
/* 157 */     InngArea9.getAction().add(new ActionSpace("teleportFrom9to8", 245, 570, 361, 529, true));
/* 158 */     InngArea9.getAction().add(new ActionSpace("teleportFrom9to13", 504, 138, 558, 60, true));
/*     */ 
/* 161 */     this.areas.put(Integer.valueOf(InngArea9.getId()), InngArea9);
/*     */ 
/* 163 */     Area blacksmith1 = new Area(10, "Blacksmith 1", "cache/graphics/tiles/blacksmith_1.png");
/* 164 */     blacksmith1.getWalkable().add(new Walkable(350, 209, 560, 63));
/* 165 */     blacksmith1.getWalkable().add(new Walkable(517, 252, 805, 190));
/* 166 */     blacksmith1.getWalkable().add(new Walkable(669, 447, 805, 312));
/* 167 */     blacksmith1.getWalkable().add(new Walkable(703, 332, 745, 193));
/* 168 */     blacksmith1.getAction().add(new ActionSpace("teleportFromBlacksmith1ToCamp2", 347, 580, 489, 554, true));
/* 169 */     blacksmith1.getAction().add(new ActionSpace("smelt", 351, 245, 525, 192, false));
/* 170 */     blacksmith1.getAction().add(new ActionSpace("smith", 4, 153, 240, 27, false));
/* 171 */     blacksmith1.getWalkable().add(new Walkable(-10, 130, 204, 62));
/* 172 */     this.areas.put(Integer.valueOf(blacksmith1.getId()), blacksmith1);
/*     */ 
/* 174 */     Area generalStore1 = new Area(11, "General Store 1", "cache/graphics/tiles/general_store_1.png");
/* 175 */     generalStore1.getWalkable().add(new Walkable(-10, 600, 274, 321));
/* 176 */     generalStore1.getWalkable().add(new Walkable(454, 393, 528, 308));
/* 177 */     generalStore1.getWalkable().add(new Walkable(268, 336, 589, 265));
/* 178 */     generalStore1.getWalkable().add(new Walkable(498, 600, 779, 247));
/* 179 */     generalStore1.getAction().add(new ActionSpace("openShop1", 409, 436, 503, 322, false));
/* 180 */     generalStore1.getAction().add(new ActionSpace("teleportFromGeneralStore1ToCamp2", 331, 580, 440, 553, true));
/* 181 */     this.areas.put(Integer.valueOf(generalStore1.getId()), generalStore1);
/*     */ 
/* 183 */     Area path4 = new Area(12, "Path 4", "cache/graphics/tiles/path_4.png");
/* 184 */     path4.getWalkable().add(new Walkable(-10, 600, 250, 321));
/* 185 */     path4.getWalkable().add(new Walkable(247, 352, 360, 321));
/* 186 */     path4.getWalkable().add(new Walkable(-10, 264, 350, 223));
/* 187 */     path4.getWalkable().add(new Walkable(-10, 226, 283, 98));
/* 188 */     path4.getWalkable().add(new Walkable(105, 106, 253, 64));
/* 189 */     path4.getWalkable().add(new Walkable(659, 408, 805, 321));
/* 190 */     path4.getWalkable().add(new Walkable(124, 78, 187, -5));
/* 191 */     path4.getWalkable().add(new Walkable(349, 190, 585, 20));
/* 192 */     path4.getWalkable().add(new Walkable(581, 182, 805, 63));
/* 193 */     path4.getWalkable().add(new Walkable(700, 80, 780, -5));
/* 194 */     path4.getWalkable().add(new Walkable(354, 486, 422, 443));
/* 195 */     path4.getWalkable().add(new Walkable(239, 600, 543, 513));
/* 196 */     path4.getWalkable().add(new Walkable(509, 523, 553, 460));
/* 197 */     path4.getWalkable().add(new Walkable(454, 471, 805, 385));
/* 198 */     path4.getWalkable().add(new Walkable(536, 600, 684, 471));
/* 199 */     path4.getWalkable().add(new Walkable(674, 244, 805, 80));
/* 200 */     path4.getWalkable().add(new Walkable(581, 182, 805, 74));
/* 201 */     path4.getAction().add(new ActionSpace("teleportFromPath4ToCamp2", 0, 335, 29, 252, true));
/* 202 */     path4.getAction().add(new ActionSpace("teleportFrom12To16", 745, 342, 793, 227, true));
/* 203 */     path4.getAction().add(new ActionSpace("chopOakTree", 287, 225, 597, 41, false));
/* 204 */     path4.getAction().add(new ActionSpace("fishTuna", 441, 392, 549, 336, false));
/* 205 */     this.areas.put(Integer.valueOf(path4.getId()), path4);
/*     */ 
/* 207 */     Area area13 = new Area(13, "Cave 1", "cache/graphics/tiles/13.png");
/* 208 */     area13.getAction().add(new ActionSpace("teleportFrom13to9", 316, 570, 455, 510, true));
/* 209 */     area13.getAction().add(new ActionSpace("teleportFrom13to14", 540, 78, 586, 8, true));
/* 210 */     this.areas.put(Integer.valueOf(area13.getId()), area13);
/*     */ 
/* 212 */     Area area14 = new Area(14, "Cave 1.1", "cache/graphics/tiles/14.png");
/* 213 */     area14.getAction().add(new ActionSpace("teleportFrom14to13", 410, 569, 457, 505, true));
/* 214 */     area14.getAction().add(new ActionSpace("mineIron", 670, 243, 789, 141, false));
/* 215 */     this.areas.put(Integer.valueOf(area14.getId()), area14);
/*     */ 
/* 217 */     Area area15 = new Area(15, "Path 5", "cache/graphics/tiles/15.png");
/* 218 */     area15.getAction().add(new ActionSpace("teleportFrom15to8", 741, 384, 792, 282, true));
/* 219 */     this.areas.put(Integer.valueOf(area15.getId()), area15);
/*     */ 
/* 221 */     Area area16 = new Area(16, "Outside Mining Guild", "cache/graphics/tiles/16.png");
/* 222 */     area16.getAction().add(new ActionSpace("teleportFrom16To12", 0, 330, 76, 209, true));
/* 223 */     area16.getAction().add(new ActionSpace("enterMiningGuild", 315, 265, 434, 188, true));
/* 224 */     area16.getAction().add(new ActionSpace("trainMiningGuild", 674, 458, 778, 341, true));
/* 225 */     this.areas.put(Integer.valueOf(area16.getId()), area16);
/*     */ 
/* 227 */     Area area17 = new Area(17, "Mining Guild 1", "cache/graphics/tiles/17.png");
/* 228 */     area17.getAction().add(new ActionSpace("teleportFrom17To18", 120, 332, 176, 249, true));
/* 229 */     area17.getAction().add(new ActionSpace("teleportFrom17To16", 345, 80, 460, 0, true));
/* 230 */     area17.getAction().add(new ActionSpace("smelt", 597, 97, 762, 0, false));
/* 231 */     area17.getAction().add(new ActionSpace("sleep", 98, 106, 204, 4, false));
/* 232 */     this.areas.put(Integer.valueOf(area17.getId()), area17);
/*     */ 
/* 234 */     Area area18 = new Area(18, "Mining Guild 12", "cache/graphics/tiles/18.png");
/* 235 */     area18.getAction().add(new ActionSpace("mineCopper", 558, 246, 659, 146, false));
/* 236 */     area18.getAction().add(new ActionSpace("mineCopper", 278, 569, 466, 495, false));
/* 237 */     area18.getAction().add(new ActionSpace("mineIron", 222, 209, 417, 122, false));
/* 238 */     area18.getAction().add(new ActionSpace("mineSilver", 0, 568, 75, 423, false));
/* 239 */     area18.getAction().add(new ActionSpace("teleportFrom18To17", 155, 173, 202, 111, true));
/* 240 */     this.areas.put(Integer.valueOf(area18.getId()), area18);
/*     */   }
/*     */ 
/*     */   public Area getArea(int areaId)
/*     */   {
/* 245 */     return (Area)this.areas.get(Integer.valueOf(areaId));
/*     */   }
/*     */ 
/*     */   public static void applyAction(String actionName, boolean onTouch)
/*     */   {
/* 250 */     Player player = PlayerList.getInstance().getPlayer(Config.USERNAME);
/*     */ 
/* 252 */     if (actionName.startsWith("teleport"))
/*     */     {
/* 254 */       teleportPlayer(actionName);
/*     */     }
/*     */     else
/* 257 */       player.setPlayerAction(actionName);
/*     */   }
/*     */ 
/*     */   public static void teleportPlayer(String tele)
/*     */   {
/* 264 */     PlayerList.getInstance().getPlayer(Config.USERNAME).setCanWalk(false);
/*     */ 
/* 267 */     if (tele.equalsIgnoreCase("teleportToStartingBankAndInn")) {
/* 268 */       Command.getInstance().teleportPlayer(3, 644, 479);
/*     */     }
/* 270 */     if (tele.equalsIgnoreCase("teleportToStartingArea")) {
/* 271 */       Command.getInstance().teleportPlayer(0, 560, 109);
/*     */     }
/* 273 */     if (tele.equalsIgnoreCase("teleportToStartingMiningArea")) {
/* 274 */       Command.getInstance().teleportPlayer(3, 720, 334);
/*     */     }
/* 276 */     if (tele.equalsIgnoreCase("teleportToStartingAreaFromMine")) {
/* 277 */       Command.getInstance().teleportPlayer(1, 52, 300);
/*     */     }
/* 279 */     if (tele.equalsIgnoreCase("teleportToStartingBank")) {
/* 280 */       Command.getInstance().teleportPlayer(2, 425, 493);
/*     */     }
/* 282 */     if (tele.equalsIgnoreCase("teleportToStartingAreaFromBank")) {
/* 283 */       Command.getInstance().teleportPlayer(1, 395, 359);
/*     */     }
/* 285 */     if (tele.equalsIgnoreCase("teleportToStartingInn")) {
/* 286 */       Command.getInstance().teleportPlayer(4, 430, 503);
/*     */     }
/* 288 */     if (tele.equalsIgnoreCase("teleportToStartingAreaFRomInn")) {
/* 289 */       Command.getInstance().teleportPlayer(1, 621, 368);
/*     */     }
/* 291 */     if (tele.equalsIgnoreCase("teleportFromCamp1ToCamp2")) {
/* 292 */       Command.getInstance().teleportPlayer(5, 268, 503);
/*     */     }
/* 294 */     if (tele.equalsIgnoreCase("teleportFromCamp2ToCamp1")) {
/* 295 */       Command.getInstance().teleportPlayer(1, 277, 80);
/*     */     }
/* 297 */     if (tele.equalsIgnoreCase("teleportFromCamp2ToBlacksmith1")) {
/* 298 */       Command.getInstance().teleportPlayer(10, 381, 501);
/*     */     }
/* 300 */     if (tele.equalsIgnoreCase("teleportFromBlacksmith1ToCamp2")) {
/* 301 */       Command.getInstance().teleportPlayer(5, 506, 219);
/*     */     }
/* 303 */     if (tele.equalsIgnoreCase("teleportFromCamp2ToGeneralStore1")) {
/* 304 */       Command.getInstance().teleportPlayer(11, 392, 527);
/*     */     }
/* 306 */     if (tele.equalsIgnoreCase("teleportFromGeneralStore1ToCamp2")) {
/* 307 */       Command.getInstance().teleportPlayer(5, 235, 233);
/*     */     }
/* 309 */     if (tele.equalsIgnoreCase("teleportFromPath4ToCamp2")) {
/* 310 */       Command.getInstance().teleportPlayer(5, 622, 296);
/*     */     }
/* 312 */     if (tele.equalsIgnoreCase("teleportFrom5to8")) {
/* 313 */       Command.getInstance().teleportPlayer(8, 740, 268);
/*     */     }
/* 315 */     if (tele.equalsIgnoreCase("teleportFrom8to9")) {
/* 316 */       Command.getInstance().teleportPlayer(9, 307, 506);
/*     */     }
/* 318 */     if (tele.equalsIgnoreCase("teleportFrom9to8")) {
/* 319 */       Command.getInstance().teleportPlayer(8, 377, 125);
/*     */     }
/* 321 */     if (tele.equalsIgnoreCase("teleportFrom8to5")) {
/* 322 */       Command.getInstance().teleportPlayer(5, 47, 369);
/*     */     }
/* 324 */     if (tele.equalsIgnoreCase("teleportFrom9to13")) {
/* 325 */       Command.getInstance().teleportPlayer(13, 386, 502);
/*     */     }
/* 327 */     if (tele.equalsIgnoreCase("teleportFrom13to9")) {
/* 328 */       Command.getInstance().teleportPlayer(9, 527, 184);
/*     */     }
/* 330 */     if (tele.equalsIgnoreCase("teleportFrom13to14")) {
/* 331 */       Command.getInstance().teleportPlayer(14, 429, 503);
/*     */     }
/* 333 */     if (tele.equalsIgnoreCase("teleportFrom14to13")) {
/* 334 */       Command.getInstance().teleportPlayer(13, 563, 109);
/*     */     }
/* 336 */     if (tele.equalsIgnoreCase("teleportFrom8to15")) {
/* 337 */       Command.getInstance().teleportPlayer(15, 698, 337);
/*     */     }
/* 339 */     if (tele.equalsIgnoreCase("teleportFrom15to8")) {
/* 340 */       Command.getInstance().teleportPlayer(8, 101, 294);
/*     */     }
/* 342 */     if (tele.equalsIgnoreCase("teleportFrom12to16")) {
/* 343 */       Command.getInstance().teleportPlayer(16, 99, 275);
/*     */     }
/* 345 */     if (tele.equalsIgnoreCase("teleportFrom16to12")) {
/* 346 */       Command.getInstance().teleportPlayer(12, 732, 291);
/*     */     }
/* 348 */     if (tele.equalsIgnoreCase("teleportFrom17to18")) {
/* 349 */       Command.getInstance().teleportPlayer(18, 176, 249);
/*     */     }
/* 351 */     if (tele.equalsIgnoreCase("teleportFrom18to17")) {
/* 352 */       Command.getInstance().teleportPlayer(17, 140, 207);
/*     */     }
/* 354 */     if (tele.equalsIgnoreCase("teleportFrom17to16"))
/* 355 */       Command.getInstance().teleportPlayer(16, 368, 287);
/*     */   }
/*     */ 
/*     */   public static void applyPlayerAction(String action)
/*     */   {
/* 360 */     Player p = PlayerList.getInstance().getPlayer(Config.USERNAME);
/* 361 */     p.setPlayerAction("");
/*     */ 
/* 365 */     if (action.startsWith("openShop"))
/*     */     {
/* 367 */       int shopId = Integer.parseInt(action.substring(8));
/* 368 */       GamePanel.getInstance().openShop(new ShopGui(ShopList.getInstance().getShop(shopId)));
/*     */     }
/* 370 */     if (action.equals("climbLadder"))
/*     */     {
/* 372 */       p.telePlayer(545, 98);
/* 373 */       p.setPlayerAction("");
/*     */     }
/* 375 */     else if (action.equals("climbDownLadder"))
/*     */     {
/* 377 */       p.telePlayer(558, 448);
/* 378 */       p.setPlayerAction("");
/*     */     }
/* 380 */     else if (action.equals("fixBridge"))
/*     */     {
/* 382 */       if (PlayerList.getInstance().getPlayer(Config.USERNAME).getFlagValue("fixedBridgeCamp2") != null)
/*     */       {
/* 384 */         p.setCanWalk(false);
/* 385 */         Command.getInstance().teleportPlayer(12, 44, 291);
/*     */       }
/*     */       else
/*     */       {
/* 389 */         InputBox input = new InputBox();
/* 390 */         input.setTitleAndMessage("Repair Bridge?", "To repair the bridge, you need a hammer with 5 bronze bars.");
/* 391 */         input.setNumberOfOptions(1);
/* 392 */         input.setOption("Fix", 0, "fixCamp2Bridge");
/* 393 */         input.init(false);
/* 394 */         GamePanel.getInstance().openInputBox(input);
/*     */       }
/*     */ 
/*     */     }
/* 398 */     else if (action.equals("smelt"))
/*     */     {
/* 401 */       InputBox inputbox = new InputBox();
/* 402 */       inputbox.setTitleAndMessage("Smelting", "Which ore do you wish to smelt in to bars?");
/* 403 */       inputbox.setNumberOfOptions(5);
/* 404 */       inputbox.setOption("Smelt Copper Ore", 0, "smelt_copper");
/* 405 */       inputbox.setOption("Smelt Iron Ore", 1, "smelt_iron");
/* 406 */       inputbox.setOption("Smelt Silver Ore", 2, "smelt_silver");
/* 407 */       inputbox.setOption("Smelt Gold Ore", 3, "smelt_gold");
/* 408 */       inputbox.setOption("Smelt Titanium Ore", 4, "smelt_titanium");
/* 409 */       inputbox.init(false);
/* 410 */       GamePanel.getInstance().openInputBox(inputbox);
/*     */     }
/* 412 */     else if (action.equals("smith"))
/*     */     {
/* 415 */       InputBox inputbox = new InputBox();
/* 416 */       inputbox.setTitleAndMessage("Smelting", "What type of bar do you with to use?");
/* 417 */       inputbox.setNumberOfOptions(5);
/* 418 */       inputbox.setOption("Bronze", 0, "smith_bronze");
/* 419 */       inputbox.setOption("Iron", 1, "smith_iron");
/* 420 */       inputbox.setOption("Silver", 2, "smith_silver");
/* 421 */       inputbox.setOption("Gold", 3, "smith_gold");
/* 422 */       inputbox.setOption("Titanium", 4, "smith_titanium");
/* 423 */       inputbox.init(false);
/* 424 */       GamePanel.getInstance().openInputBox(inputbox);
/*     */     }
/* 426 */     else if (action.equals("enterMiningGuild"))
/*     */     {
/* 428 */       InputBox inputbox = new InputBox();
/* 429 */       inputbox.setTitleAndMessage("Mining Guild", "You must have a mining level of at least 35 to enter the guild.");
/* 430 */       inputbox.setNumberOfOptions(1);
/* 431 */       inputbox.setOption("Enter", 0, "enterMiningGuild");
/* 432 */       inputbox.init(false);
/* 433 */       GamePanel.getInstance().openInputBox(inputbox);
/*     */     }
/* 435 */     else if (action.equals("trainMiningGuild"))
/*     */     {
/* 437 */       InputBox inputbox = new InputBox();
/* 438 */       inputbox.setTitleAndMessage("Train Operator", "Hello ! Would you like to ride the train to the desert?  It only costs 1000 coins.<br /><br /><b>Warning: Monsters level 30+ roam the desert</b>");
/* 439 */       inputbox.setNumberOfOptions(1);
/* 440 */       inputbox.setOption("Take me there!", 0, "rideTrainToDesert");
/* 441 */       inputbox.init(true);
/* 442 */       GamePanel.getInstance().openInputBox(inputbox);
/*     */     }
/*     */     else {
/* 445 */       Command.getInstance().sendCommand(action, "");
/*     */     }
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     maps.AreaList
 * JD-Core Version:    0.6.2
 */