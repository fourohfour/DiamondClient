/*     */ package players;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class ItemList
/*     */ {
/*   7 */   private static ItemList itemList = null;
/*   8 */   private ArrayList<Item> items = new ArrayList();
/*     */ 
/*     */   public static ItemList getInstance()
/*     */   {
/*  17 */     if (itemList == null) {
/*  18 */       itemList = new ItemList();
/*     */     }
/*  20 */     return itemList;
/*     */   }
/*     */ 
/*     */   public void addGameItem(Item item)
/*     */   {
/*  25 */     this.items.add(item);
/*     */   }
/*     */ 
/*     */   public ArrayList<Item> getAllItems()
/*     */   {
/*  30 */     return this.items;
/*     */   }
/*     */ 
/*     */   public Item getItem(int id)
/*     */   {
/*  37 */     for (Item item : this.items)
/*     */     {
/*  39 */       if (item.getId() == id)
/*     */       {
/*  41 */         Item i = new Item(item.getId(), item.getName(), item.getDescription(), item.getIMGUrl(), item.getValue(), item.isStackable(), item.isWieldable());
/*  42 */         return i;
/*     */       }
/*     */     }
/*     */ 
/*  46 */     return null;
/*     */   }
/*     */ 
/*     */   public Item getItem(Item itemObj)
/*     */   {
/*  51 */     for (Item item : this.items)
/*     */     {
/*  53 */       if (itemObj.getId() == item.getId()) {
/*  54 */         return item;
/*     */       }
/*     */     }
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */   public void loadItems()
/*     */   {
/*  63 */     addGameItem(new Item(0, "Wooden Pickaxe", "A very weak pickaxe.", "cache/graphics/items/wooden_pickaxe.png", 5, false, true));
/*  64 */     addGameItem(new Item(1, "Stone Pickaxe", "A weak pickaxe.", "cache/graphics/items/stone_pickaxe.png", 30, false, true));
/*  65 */     addGameItem(new Item(2, "Bronze Pickaxe", "A basic pickaxe.", "cache/graphics/items/bronze_pickaxe.png", 100, false, true));
/*  66 */     addGameItem(new Item(3, "Iron Pickaxe", "An advanced basic pickaxe.", "cache/graphics/items/iron_pickaxe.png", 5000, false, true));
/*  67 */     addGameItem(new Item(4, "Silver Pickaxe", "A solid pickaxe.", "cache/graphics/items/silver_pickaxe.png", 1000, false, true));
/*  68 */     addGameItem(new Item(5, "Gold Pickaxe", "A very solid pickaxe.", "cache/graphics/items/gold_pickaxe.png", 20000, false, true));
/*  69 */     addGameItem(new Item(6, "Titanium Pickaxe", "A super solid pickaxe.", "cache/graphics/items/titanium_pickaxe.png", 50000, false, true));
/*  70 */     addGameItem(new Item(7, "Diamond Pickaxe", "An extemely powerful and valuable pickaxe.", "cache/graphics/items/diamond_pickaxe.png", 200000, false, true));
/*     */ 
/*  72 */     addGameItem(new Item(8, "Coins", "Shiny!", "cache/graphics/items/coins.png", 0, true, false));
/*  73 */     addGameItem(new Item(9, "Wheat", "The main ingredient in bread.", "cache/graphics/items/wheat.png", 1, false, false));
/*  74 */     addGameItem(new Item(10, "Red Mushroom", "An ingredient for food or potions.", "cache/graphics/items/red_mushroom.png", 12, false, false));
/*     */ 
/*  77 */     addGameItem(new Item(11, "Wooden axe", "A very weak axe.", "cache/graphics/items/wooden_axe.png", 5, false, true));
/*  78 */     addGameItem(new Item(12, "Stone axe", "A weak axe.", "cache/graphics/items/stone_axe.png", 30, false, true));
/*  79 */     addGameItem(new Item(13, "Bronze axe", "A basic axe.", "cache/graphics/items/bronze_axe.png", 100, false, true));
/*  80 */     addGameItem(new Item(14, "Iron axe", "An advanced basic axe.", "cache/graphics/items/iron_axe.png", 5000, false, true));
/*  81 */     addGameItem(new Item(15, "Silver axe", "A solid axe.", "cache/graphics/items/silver_axe.png", 1000, false, true));
/*  82 */     addGameItem(new Item(16, "Gold axe", "A very solid axe.", "cache/graphics/items/gold_axe.png", 20000, false, true));
/*  83 */     addGameItem(new Item(17, "Titanium axe", "A super solid axe.", "cache/graphics/items/titanium_axe.png", 50000, false, true));
/*  84 */     addGameItem(new Item(18, "Diamond axe", "An extemely powerful and valuable axe.", "cache/graphics/items/diamond_axe.png", 200000, false, true));
/*     */ 
/*  86 */     addGameItem(new Item(19, "Stone", "This can be mined from a specific rock.", "cache/graphics/items/stone.png", 1, false, false));
/*  87 */     addGameItem(new Item(20, "Copper ore", "This can be mined from a specific rock.", "cache/graphics/items/copper_ore.png", 5, false, false));
/*  88 */     addGameItem(new Item(21, "Iron ore", "This can be mined from a specific rock.", "cache/graphics/items/iron_ore.png", 20, false, false));
/*  89 */     addGameItem(new Item(22, "Siver ore", "This can be mined from a specific rock.", "cache/graphics/items/silver_ore.png", 100, false, false));
/*  90 */     addGameItem(new Item(23, "Gold ore", "This can be mined from a specific rock.", "cache/graphics/items/gold_ore.png", 1000, false, false));
/*  91 */     addGameItem(new Item(24, "Titanium ore", "This can be mined from a specific rock.", "cache/graphics/items/titanium_ore.png", 5000, false, false));
/*     */ 
/*  93 */     addGameItem(new Item(25, "Mage Hat", "A Witches hat.", "cache/graphics/items/mage_hat.png", 120, false, true));
/*     */ 
/*  95 */     addGameItem(new Item(26, "Logs", "This item is obtained by chopping a specific tree.", "cache/graphics/items/logs.png", 3, false, false));
/*  96 */     addGameItem(new Item(27, "Oak Logs", "This item is obtained by chopping a specific tree.", "cache/graphics/items/oak_logs.png", 10, false, false));
/*  97 */     addGameItem(new Item(28, "Willow Logs", "This item is obtained by chopping a specific tree.", "cache/graphics/items/willow_logs.png", 30, false, false));
/*  98 */     addGameItem(new Item(29, "Maple Logs", "This item is obtained by chopping a specific tree.", "cache/graphics/items/maple_logs.png", 30, false, false));
/*  99 */     addGameItem(new Item(30, "Frozen Logs", "This item is obtained by chopping a specific tree.", "cache/graphics/items/frozen_logs.png", 30, false, false));
/*     */ 
/* 101 */     addGameItem(new Item(31, "Hammer", "Used for smithing and crafting.", "cache/graphics/items/hammer.png", 50, false, false));
/*     */ 
/* 103 */     addGameItem(new Item(32, "Bronze Shield", "shield", "Gives you armour bonus.", "cache/graphics/items/bronze_shield.png", 100, false, true));
/* 104 */     addGameItem(new Item(33, "Iron Shield", "shield", "Gives you armour bonus.", "cache/graphics/items/iron_shield.png", 300, false, true));
/* 105 */     addGameItem(new Item(34, "Silver Shield", "shield", "Gives you armour bonus.", "cache/graphics/items/silver_shield.png", 1000, false, true));
/* 106 */     addGameItem(new Item(35, "Gold Shield", "shield", "Gives you armour bonus.", "cache/graphics/items/gold_shield.png", 10000, false, true));
/* 107 */     addGameItem(new Item(68, "Titanium Shield", "shield", "Gives you armour bonus.", "cache/graphics/items/titanium_shield.png", 100000, false, true));
/*     */ 
/* 109 */     addGameItem(new Item(36, "Bronze Sword", "weapon", "Gives you attack bonus.", "cache/graphics/items/bronze_sword.png", 150, false, true));
/* 110 */     addGameItem(new Item(37, "Iron Sword", "weapon", "Gives you attack bonus.", "cache/graphics/items/iron_sword.png", 1500, false, true));
/* 111 */     addGameItem(new Item(38, "Silver Sword", "weapon", "Gives you attack bonus.", "cache/graphics/items/silver_sword.png", 5000, false, true));
/* 112 */     addGameItem(new Item(39, "Gold Sword", "weapon", "Gives you attack bonus.", "cache/graphics/items/gold_sword.png", 29000, false, true));
/* 113 */     addGameItem(new Item(40, "Titanium Sword", "weapon", "Gives you attack bonus.", "cache/graphics/items/titanium_sword.png", 145000, false, true));
/*     */ 
/* 115 */     addGameItem(new Item(41, "Empty Flask", "other", "Used to hold liquids, can be filled with water.", "cache/graphics/items/empty_flask.png", 25, false, false));
/* 116 */     addGameItem(new Item(42, "Water Flask", "other", "Used to hold liquids, can be filled with water.", "cache/graphics/items/water_flask.png", 30, false, false));
/* 117 */     addGameItem(new Item(43, "Blue Flask", "other", "Does something.", "cache/graphics/items/blue_flask.png", 30, false, false));
/* 118 */     addGameItem(new Item(44, "Red Flask", "other", "Does something.", "cache/graphics/items/red_flask.png", 30, false, false));
/*     */ 
/* 120 */     addGameItem(new Item(45, "Standard Wand", "other", "Magic bonus increases when equiped.", "cache/graphics/items/wand.png", 5000, false, true));
/* 121 */     addGameItem(new Item(46, "Wizards Hat", "other", "Magic bonus increases when equiped.", "cache/graphics/items/wizards_hat.png", 50000, false, true));
/*     */ 
/* 123 */     addGameItem(new Item(47, "Bronze Helmet", "head", "Great protection.", "cache/graphics/items/bronze_helmet.png", 500, false, true));
/* 124 */     addGameItem(new Item(48, "Iron Helmet", "head", "Great protection.", "cache/graphics/items/iron_helmet.png", 1200, false, true));
/* 125 */     addGameItem(new Item(49, "Silver Helmet", "head", "Great protection.", "cache/graphics/items/silver_helmet.png", 14200, false, true));
/* 126 */     addGameItem(new Item(50, "Gold Helmet", "head", "Great protection.", "cache/graphics/items/gold_helmet.png", 34000, false, true));
/* 127 */     addGameItem(new Item(51, "Titanium Helmet", "head", "Great protection.", "cache/graphics/items/titanium_helmet.png", 120000, false, true));
/*     */ 
/* 129 */     addGameItem(new Item(52, "Bronze Platebody", "body", "Great protection.", "cache/graphics/items/bronze_platebody.png", 2400, false, true));
/* 130 */     addGameItem(new Item(53, "Iron Platebody", "body", "Great protection.", "cache/graphics/items/iron_platebody.png", 5000, false, true));
/* 131 */     addGameItem(new Item(54, "Silver Platebody", "body", "Great protection.", "cache/graphics/items/silver_platebody.png", 24000, false, true));
/* 132 */     addGameItem(new Item(55, "Gold Platebody", "body", "Great protection.", "cache/graphics/items/gold_platebody.png", 101000, false, true));
/* 133 */     addGameItem(new Item(56, "Titanium Platebody", "body", "Great protection.", "cache/graphics/items/titanium_platebody.png", 241000, false, true));
/*     */ 
/* 135 */     addGameItem(new Item(57, "Bronze Platelegs", "legs", "Great protection.", "cache/graphics/items/bronze_platelegs.png", 2000, false, true));
/* 136 */     addGameItem(new Item(58, "Iron Platelegs", "legs", "Great protection.", "cache/graphics/items/iron_platelegs.png", 3500, false, true));
/* 137 */     addGameItem(new Item(59, "Silver Platelegs", "legs", "Great protection.", "cache/graphics/items/silver_platelegs.png", 15500, false, true));
/* 138 */     addGameItem(new Item(60, "Gold Platelegs", "legs", "Great protection.", "cache/graphics/items/gold_platelegs.png", 88000, false, true));
/* 139 */     addGameItem(new Item(61, "Titanium Platelegs", "legs", "Great protection.", "cache/graphics/items/titanium_platelegs.png", 201000, false, true));
/*     */ 
/* 141 */     addGameItem(new Item(62, "Bronze Bar", "other", "A mettal bar.", "cache/graphics/items/bronze_bar.png", 20, true, false));
/* 142 */     addGameItem(new Item(63, "Iron Bar", "other", "A mettal bar.", "cache/graphics/items/iron_bar.png", 50, true, false));
/* 143 */     addGameItem(new Item(64, "Silver Bar", "other", "A mettal bar.", "cache/graphics/items/silver_bar.png", 200, true, false));
/* 144 */     addGameItem(new Item(65, "Gold Bar", "other", "A mettal bar.", "cache/graphics/items/gold_bar.png", 2500, true, false));
/* 145 */     addGameItem(new Item(66, "Titanium Bar", "other", "A mettal bar.", "cache/graphics/items/titanium_bar.png", 7500, true, false));
/*     */ 
/* 147 */     addGameItem(new Item(67, "Beta Shirt", "body", "Discontinued on september 15th, this shirt was given to the early players.", "cache/graphics/items/test_shirt.png", 500, false, true));
/*     */ 
/* 149 */     addGameItem(new Item(69, "Cooked Shrimp", "other", "Heals 2 hp.", "cache/graphics/items/cooked_shrimp.png", 50, false, true));
/*     */ 
/* 151 */     addGameItem(new Item(70, "Sapphire", "other", "Shiny!", "cache/graphics/items/sapphire.png", 1200, false, false));
/* 152 */     addGameItem(new Item(71, "Emerald", "other", "Shiny!", "cache/graphics/items/emerald.png", 12000, false, false));
/* 153 */     addGameItem(new Item(72, "Ruby", "other", "Shiny!", "cache/graphics/items/ruby.png", 86000, false, false));
/* 154 */     addGameItem(new Item(73, "Diamond", "other", "VERY Shiny!", "cache/graphics/items/diamond.png", 100000, false, false));
/*     */ 
/* 156 */     addGameItem(new Item(74, "Sapphire Ring", "other", "A shiny ring.", "cache/graphics/items/sapphire_ring.png", 1800, false, false));
/* 157 */     addGameItem(new Item(75, "Emerald Ring", "other", "A shiny ring.", "cache/graphics/items/emerald_ring.png", 18000, false, false));
/* 158 */     addGameItem(new Item(76, "Ruby Ring", "other", "A shiny ring.", "cache/graphics/items/ruby_ring.png", 96000, false, false));
/* 159 */     addGameItem(new Item(77, "Diamond Ring", "other", "A very shiny ring.", "cache/graphics/items/diamond_ring.png", 120000, false, false));
/*     */ 
/* 162 */     addGameItem(new Item(78, "Fishing Net", "other", "Find a fishing spot to use this.", "cache/graphics/items/net.png", 5, false, false));
/* 163 */     addGameItem(new Item(79, "Raw Shrimp", "other", "I should cook this before eating it.", "cache/graphics/items/raw_shrimp.png", 8, false, false));
/* 164 */     addGameItem(new Item(80, "Fishing Rod", "other", "You need bait to use this.", "cache/graphics/items/fishing_rod.png", 78, false, false));
/* 165 */     addGameItem(new Item(81, "Fishing Bait", "other", "Can be used with a fishing rod.", "cache/graphics/items/fishing_bait.png", 3, true, false));
/* 166 */     addGameItem(new Item(82, "Burnt Shrimp", "other", "Useless.", "cache/graphics/items/burnt_shrimp.png", 0, false, false));
/*     */ 
/* 168 */     addGameItem(new Item(83, "Common Chest", "other", "Open it so see what's inside!", "cache/graphics/items/common_chest.png", 1, false, true));
/* 169 */     addGameItem(new Item(84, "Uncommon Chest", "other", "Open it so see what's inside!", "cache/graphics/items/uncommon_chest.png", 1, false, true));
/* 170 */     addGameItem(new Item(85, "Rare Chest", "other", "Open it so see what's inside!", "cache/graphics/items/rare_chest.png", 1, false, true));
/* 171 */     addGameItem(new Item(86, "Very Rare Chest", "other", "Open it so see what's inside!", "cache/graphics/items/veryrare_chest.png", 1, false, true));
/*     */ 
/* 173 */     addGameItem(new Item(87, "Raw Sardine", "other", "I should cook this before I eat it.", "cache/graphics/items/raw_sardine.png", 13, false, false));
/* 174 */     addGameItem(new Item(88, "Cooked Sardine", "other", "Heals 4 hitpoints.", "cache/graphics/items/cooked_sardine.png", 100, false, true));
/* 175 */     addGameItem(new Item(89, "Burnt Sardine", "other", "I woudln't eat this!", "cache/graphics/items/burnt_sardine.png", 1, false, false));
/*     */ 
/* 177 */     addGameItem(new Item(90, "Raw Tuna", "other", "I should cook this before I eat it.", "cache/graphics/items/raw_tuna.png", 13, false, false));
/* 178 */     addGameItem(new Item(91, "Cooked Tuna", "other", "Heals 6 hitpoints.", "cache/graphics/items/cooked_tuna.png", 100, false, true));
/* 179 */     addGameItem(new Item(92, "Burnt Tuna", "other", "I woudln't eat this!", "cache/graphics/items/burnt_tuna.png", 1, false, false));
/*     */ 
/* 181 */     addGameItem(new Item(93, "Green Leaf", "other", "Used for making potions (Brewing)", "cache/graphics/items/green_leaf.png", 5, false, false));
/* 182 */     addGameItem(new Item(94, "Lime Leaf", "other", "Used for making potions (Brewing)", "cache/graphics/items/lime_leaf.png", 50, false, false));
/* 183 */     addGameItem(new Item(95, "Red Leaf", "other", "Used for making potions (Brewing)", "cache/graphics/items/red_leaf.png", 150, false, false));
/* 184 */     addGameItem(new Item(96, "Gold Leaf", "other", "Used for making potions (Brewing)", "cache/graphics/items/gold_leaf.png", 200, false, false));
/* 185 */     addGameItem(new Item(97, "Crystal Leaf", "other", "Used for making potions (Brewing)", "cache/graphics/items/crystal_leaf.png", 1000, false, false));
/*     */ 
/* 187 */     addGameItem(new Item(98, "Strength Potion (3)", "other", "I can drink this", "cache/graphics/items/strength_potion.png", 1000, false, true));
/* 188 */     addGameItem(new Item(99, "Strength Potion (2)", "other", "I can drink this", "cache/graphics/items/strength_potion.png", 666, false, true));
/* 189 */     addGameItem(new Item(100, "Strength Potion (1)", "other", "I can drink this", "cache/graphics/items/strength_potion.png", 333, false, true));
/*     */ 
/* 191 */     addGameItem(new Item(101, "Defence Potion (3)", "other", "I can drink this", "cache/graphics/items/defence_potion.png", 1000, false, false));
/* 192 */     addGameItem(new Item(102, "Defence Potion (2)", "other", "I can drink this", "cache/graphics/items/defence_potion.png", 666, false, false));
/* 193 */     addGameItem(new Item(103, "Defence Potion (1)", "other", "I can drink this", "cache/graphics/items/defence_potion.png", 333, false, false));
/*     */ 
/* 195 */     addGameItem(new Item(104, "Smithing Potion (3)", "other", "I can drink this", "cache/graphics/items/smithing_potion.png", 1000, false, false));
/* 196 */     addGameItem(new Item(105, "Smithing Potion (2)", "other", "I can drink this", "cache/graphics/items/smithing_potion.png", 666, false, false));
/* 197 */     addGameItem(new Item(106, "Smithing Potion (1)", "other", "I can drink this", "cache/graphics/items/smithing_potion.png", 333, false, false));
/*     */ 
/* 199 */     addGameItem(new Item(107, "Energy Potion (3)", "other", "I can drink this", "cache/graphics/items/energy_potion.png", 1000, false, false));
/* 200 */     addGameItem(new Item(108, "Energy Potion (2)", "other", "I can drink this", "cache/graphics/items/energy_potion.png", 666, false, false));
/* 201 */     addGameItem(new Item(109, "Energy Potion (1)", "other", "I can drink this", "cache/graphics/items/energy_potion.png", 333, false, false));
/*     */ 
/* 203 */     addGameItem(new Item(110, "Cooking Potion (3)", "other", "I can drink this", "cache/graphics/items/cooking_potion.png", 1000, false, false));
/* 204 */     addGameItem(new Item(111, "Cooking Potion (2)", "other", "I can drink this", "cache/graphics/items/cooking_potion.png", 666, false, false));
/* 205 */     addGameItem(new Item(112, "Cooking Potion (1)", "other", "I can drink this", "cache/graphics/items/cooking_potion.png", 333, false, false));
/*     */ 
/* 207 */     addGameItem(new Item(113, "Bad Mix", "other", "I should empty this out", "cache/graphics/items/bad_mix.png", 0, false, false));
/*     */ 
/* 209 */     addGameItem(new Item(114, "Blue Mushroom", "other", "Can be used for brewing", "cache/graphics/items/blue_mushroom.png", 50, false, false));
/* 210 */     addGameItem(new Item(115, "Tall Green Mushroom", "other", "Can be used for brewing", "cache/graphics/items/green_mushroom.png", 50, false, false));
/*     */ 
/* 212 */     addGameItem(new Item(116, "Needle", "other", "Can be used for making clothes", "cache/graphics/items/needle.png", 1, false, true));
/* 213 */     addGameItem(new Item(117, "Thread", "other", "Can be used for making clothes", "cache/graphics/items/thread.png", 1, true, false));
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     players.ItemList
 * JD-Core Version:    0.6.2
 */