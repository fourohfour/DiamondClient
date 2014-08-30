/*     */ package connections;
/*     */ 
/*     */ import GUI.Chat;
/*     */ import GUI.GamePanel;
/*     */ import GUI.InputBox;
/*     */ import GUI.InventoryGUI;
/*     */ import GUI.ShopGui;
/*     */ import GUI.SkillsGUI;
/*     */ import Game.Game;
/*     */ import Game.GameEngine;
/*     */ import java.awt.Desktop;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.net.Socket;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import npc.GroundItem;
/*     */ import npc.GroundItemList;
/*     */ import npc.NPC;
/*     */ import npc.NPCList;
/*     */ import players.Bank;
/*     */ import players.Config;
/*     */ import players.Inventory;
/*     */ import players.Item;
/*     */ import players.ItemList;
/*     */ import players.Player;
/*     */ import players.PlayerEquipement;
/*     */ import players.PlayerList;
/*     */ import players.Shop;
/*     */ import players.ShopList;
/*     */ import players.Skill;
/*     */ import players.SkillList;
/*     */ 
/*     */ public class ClientNetwork extends Thread
/*     */ {
/*  39 */   private Socket socket = null;
/*  40 */   private Game game = null;
/*  41 */   private boolean firstPositionLoaded = false;
/*  42 */   String shopRefreshFlag = null;
/*     */   private GameEngine gameEngine;
/*  45 */   private boolean clientNetworkThreadRunning = true;
/*     */ 
/*     */   public ClientNetwork()
/*     */   {
/*  49 */     this.game = Game.getInstance();
/*  50 */     this.game.setClient(this);
/*     */   }
/*     */ 
/*     */   private boolean verifyPassword(char[] password1, char[] password2)
/*     */   {
/*  57 */     boolean passwordMatch = true;
/*     */ 
/*  59 */     if (password1.length != password2.length) {
/*  60 */       passwordMatch = false;
/*     */     }
/*     */     else {
/*  63 */       for (int i = 0; i < password1.length; i++)
/*     */       {
/*  65 */         if (password1[i] != password2[i]) {
/*  66 */           passwordMatch = false;
/*     */         }
/*     */       }
/*     */     }
/*  70 */     return passwordMatch;
/*     */   }
/*     */ 
/*     */   public String attemptingToConnect(String username, char[] password)
/*     */   {
/*  76 */     Config.USERNAME = username.toLowerCase();
/*  77 */     String serverResponse = null;
/*     */ 
/*  80 */     Player player = new Player(0, -1, username, 0, 193, 423, "cache/graphics/sprites/character.png", null);
/*  81 */     PlayerList.getInstance().overwritePlayer(player);
/*     */     try
/*     */     {
/*  85 */       String actualPassword = "";
/*     */ 
/*  87 */       for (int i = 0; i < password.length; i++)
/*     */       {
/*  89 */         actualPassword = actualPassword + password[i];
/*     */       }
/*     */ 
/*  92 */       String rawStringToSend = username + "," + actualPassword + "," + "0.61";
/*     */ 
/*  94 */       byte[] encryptedBytesToSend = PublicKeyManager.encrypt(rawStringToSend, Config.PUBLIC_KEY);
/*  95 */       int byteLength = encryptedBytesToSend.length;
/*     */ 
/*  99 */       this.socket = new Socket("38.89.137.25", 3336);
/* 100 */       DataOutputStream outputStream = new DataOutputStream(this.socket.getOutputStream());
/* 101 */       outputStream.writeInt(byteLength);
/* 102 */       outputStream.write(encryptedBytesToSend);
/* 103 */       outputStream.flush();
/*     */ 
/* 107 */       BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
/*     */ 
/* 110 */       serverResponse = inputBuffer.readLine();
/* 111 */       System.out.println(serverResponse);
/*     */     }
/*     */     catch (UnknownHostException e) {
/* 114 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 116 */       System.out.println("Server offline");
/* 117 */       return "Server Offline";
/*     */     }
/*     */ 
/* 121 */     if (serverResponse.equalsIgnoreCase("INVALIDPASSWORDORUSERNAME"))
/*     */     {
/* 123 */       return "You username or password is incorrect.";
/*     */     }
/* 125 */     if (serverResponse.equalsIgnoreCase("ALREADYLOGGEDIN"))
/*     */     {
/* 127 */       return "Your account is already logged in. OH OH!";
/*     */     }
/* 129 */     if (serverResponse.equalsIgnoreCase("VERSIONERROR"))
/*     */     {
/*     */       try {
/* 132 */         Desktop.getDesktop().browse(new URI("http://www.diamondhunt.co/mmo/play.php"));
/*     */       } catch (IOException localIOException1) {
/*     */       } catch (URISyntaxException localURISyntaxException) {
/*     */       }
/* 136 */       return "This client is outdated, please download the newest version.";
/*     */     }
/*     */ 
/* 139 */     if (serverResponse.equalsIgnoreCase("GRANTED"))
/*     */     {
/* 141 */       start();
/*     */ 
/* 144 */       this.game.setSocket(this.socket);
/* 145 */       this.game.init();
/* 146 */       this.gameEngine = new GameEngine(this.game);
/* 147 */       this.gameEngine.start();
/*     */ 
/* 149 */       return username;
/*     */     }
/*     */ 
/* 152 */     return "ERROR - CONTACT ADMIN";
/*     */   }
/*     */ 
/*     */   public String attemptingToConnectNewAccount(String username, char[] password, char[] passwordConfirm)
/*     */   {
/* 160 */     if (username.length() < 3)
/*     */     {
/* 162 */       return "Your username must contain at least 3 characters.";
/*     */     }
/*     */ 
/* 165 */     if (password.length < 6)
/*     */     {
/* 167 */       return "Password is too short, minimum 6 characters.";
/*     */     }
/*     */ 
/* 170 */     if (!verifyPassword(password, passwordConfirm))
/*     */     {
/* 173 */       System.out.println("Wrong password");
/* 174 */       return "Passwords do not match";
/*     */     }
/*     */ 
/* 178 */     Pattern p = Pattern.compile("^[0-9a-zA-Z\\s]*$");
/* 179 */     boolean hasSpecialChar = p.matcher(username).find();
/*     */ 
/* 181 */     if (!hasSpecialChar) {
/* 182 */       return "Your username can only be letters , numbers, and spaces.";
/*     */     }
/* 184 */     String actualPassword = "";
/*     */ 
/* 186 */     for (int i = 0; i < password.length; i++)
/*     */     {
/* 188 */       actualPassword = actualPassword + password[i];
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 195 */       String rawStringToSend = "NEW=" + username + "," + actualPassword;
/*     */ 
/* 197 */       byte[] encryptedBytesToSend = PublicKeyManager.encrypt(rawStringToSend, Config.PUBLIC_KEY);
/* 198 */       int byteLength = encryptedBytesToSend.length;
/*     */ 
/* 202 */       this.socket = new Socket("38.89.137.25", 3336);
/* 203 */       DataOutputStream outputStream = new DataOutputStream(this.socket.getOutputStream());
/* 204 */       outputStream.writeInt(byteLength);
/* 205 */       outputStream.write(encryptedBytesToSend);
/* 206 */       outputStream.flush();
/*     */ 
/* 210 */       BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
/*     */ 
/* 214 */       String serverResponse = in.readLine();
/* 215 */       System.out.println(serverResponse);
/*     */ 
/* 217 */       if (serverResponse.equals("ERROR=Username already exsists!")) {
/* 218 */         return "This username has already been taken.";
/*     */       }
/* 220 */       if (serverResponse.equals("USERCREATED")) {
/* 221 */         attemptingToConnect(username, password);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (UnknownHostException e)
/*     */     {
/* 227 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 229 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 234 */     return "";
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 239 */     while (this.clientNetworkThreadRunning)
/*     */     {
/*     */       try
/*     */       {
/* 243 */         Thread.sleep(50L);
/*     */       } catch (InterruptedException e) {
/* 245 */         e.printStackTrace(); getAllPlayerDataFromServer();
/*     */       }
/* 247 */       getAllPlayerDataFromServer();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void getAllPlayerDataFromServer()
/*     */   {
/*     */     try
/*     */     {
/* 259 */       BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
/*     */ 
/* 262 */       String command = in.readLine();
/*     */ 
/* 264 */       if (command.equals("REQUESTING_UPDATE"))
/*     */       {
/* 266 */         InputBox inputBox = new InputBox();
/* 267 */         inputBox.setTitleAndMessage("SERVER UPDATE!", "Please restart your client to apply new updates.");
/* 268 */         inputBox.setNumberOfOptions(0);
/* 269 */         inputBox.init(false);
/* 270 */         GamePanel.getInstance().openInputBox(inputBox);
/* 271 */         Thread.sleep(50000L);
/*     */       }
/*     */ 
/* 277 */       StringTokenizer rawTokenized = new StringTokenizer(command, "\\");
/*     */ 
/* 280 */       StringTokenizer allPlayersData = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 283 */       StringTokenizer allNPCData = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 286 */       StringTokenizer allGroundItemData = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 289 */       StringTokenizer uniquePlayersData = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 292 */       StringTokenizer bankData = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 295 */       StringTokenizer skillsData = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 298 */       StringTokenizer serverMessages = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 301 */       StringTokenizer playerEnergy = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 304 */       StringTokenizer flags = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 307 */       StringTokenizer shops = new StringTokenizer((String)rawTokenized.nextElement(), ";");
/*     */ 
/* 310 */       while (allPlayersData.hasMoreElements())
/*     */       {
/* 312 */         StringTokenizer playersTokenize = new StringTokenizer((String)allPlayersData.nextElement(), "~");
/* 313 */         int id = Integer.parseInt((String)playersTokenize.nextElement());
/* 314 */         String username = (String)playersTokenize.nextElement();
/* 315 */         int playerRights = Integer.parseInt((String)playersTokenize.nextElement());
/* 316 */         int hp = Integer.parseInt((String)playersTokenize.nextElement());
/* 317 */         int maxhp = Integer.parseInt((String)playersTokenize.nextElement());
/* 318 */         int lastHitTaken = Integer.parseInt((String)playersTokenize.nextElement());
/* 319 */         int mapid = Integer.parseInt((String)playersTokenize.nextElement());
/* 320 */         String StringInCombat = (String)playersTokenize.nextElement();
/* 321 */         boolean playerIsInCombat = false;
/*     */ 
/* 323 */         if (StringInCombat.equals("true")) {
/* 324 */           playerIsInCombat = true;
/*     */         }
/* 326 */         String isLoggedIn = (String)playersTokenize.nextElement();
/*     */ 
/* 328 */         int movex = Integer.parseInt((String)playersTokenize.nextElement());
/* 329 */         int movey = Integer.parseInt((String)playersTokenize.nextElement());
/* 330 */         String lastDirection = (String)playersTokenize.nextElement();
/* 331 */         int globalLevel = Integer.parseInt((String)playersTokenize.nextElement());
/* 332 */         String chat = (String)playersTokenize.nextElement();
/*     */ 
/* 334 */         int headId = Integer.parseInt((String)playersTokenize.nextElement());
/* 335 */         int bodyId = Integer.parseInt((String)playersTokenize.nextElement());
/* 336 */         int legsId = Integer.parseInt((String)playersTokenize.nextElement());
/* 337 */         int bootsId = Integer.parseInt((String)playersTokenize.nextElement());
/*     */ 
/* 340 */         int weaponId = Integer.parseInt((String)playersTokenize.nextElement());
/* 341 */         int shieldId = Integer.parseInt((String)playersTokenize.nextElement());
/* 342 */         int necklaceId = Integer.parseInt((String)playersTokenize.nextElement());
/*     */ 
/* 344 */         int bubbleItemId = Integer.parseInt((String)playersTokenize.nextElement());
/*     */ 
/* 346 */         Player player = new Player(id, bubbleItemId, username, mapid, movex, movey, "cache/graphics/sprites/character.png", null);
/* 347 */         player.setLastDirection(lastDirection);
/* 348 */         player.setGlobalLevel(globalLevel);
/* 349 */         player.getPlayerEquipement().setAll(headId, bodyId, legsId, bootsId, weaponId, shieldId, necklaceId);
/* 350 */         player.setInCombat(playerIsInCombat);
/* 351 */         player.setLastHitTaken(lastHitTaken);
/* 352 */         player.setHitpoints(hp);
/* 353 */         player.setMaxHitPoints(maxhp);
/* 354 */         player.setPlayerRights(playerRights);
/* 355 */         if (chat.length() > 0) {
/* 356 */           player.setChat(chat);
/*     */         }
/*     */ 
/* 359 */         if (GamePanel.getInstance().getChat() != null) {
/* 360 */           GamePanel.getInstance().getChat().addToChatBox(Config.USERNAME + ":" + chat, "regular player");
/*     */         }
/*     */ 
/* 365 */         if (isLoggedIn.equals("false")) {
/* 366 */           player.logOut();
/*     */         }
/*     */ 
/* 369 */         if (username.equals(Config.USERNAME))
/*     */         {
/* 371 */           Player clientPlayer = PlayerList.getInstance().getPlayer(Config.USERNAME);
/*     */ 
/* 375 */           clientPlayer.setInCombat(playerIsInCombat);
/*     */ 
/* 377 */           if (playerIsInCombat) {
/* 378 */             clientPlayer.telePlayer(movex, movey);
/*     */           }
/* 380 */           clientPlayer.setHitpoints(hp);
/* 381 */           clientPlayer.setMaxHitPoints(maxhp);
/* 382 */           clientPlayer.setPlayerRights(playerRights);
/* 383 */           clientPlayer.setLastHitTaken(lastHitTaken);
/*     */ 
/* 386 */           if (!this.firstPositionLoaded)
/*     */           {
/* 388 */             clientPlayer.telePlayer(movex, movey);
/* 389 */             this.firstPositionLoaded = true;
/*     */           }
/*     */ 
/* 392 */           if (clientPlayer.getPlayerMapId() != mapid)
/*     */           {
/* 394 */             clientPlayer.setMapId(mapid);
/* 395 */             clientPlayer.telePlayer(movex, movey);
/* 396 */             clientPlayer.setCanWalk(true);
/* 397 */             GamePanel.getInstance().setLoading(false);
/*     */           }
/*     */ 
/* 400 */           clientPlayer.setGlobalLevel(globalLevel);
/* 401 */           clientPlayer.getPlayerEquipement().setAll(headId, bodyId, legsId, bootsId, weaponId, shieldId, necklaceId);
/* 402 */           clientPlayer.setBubbleItemId(bubbleItemId);
/*     */         }
/* 404 */         if (!username.equals(Config.USERNAME))
/* 405 */           PlayerList.getInstance().overwritePlayer(player);
/*     */       }
/*     */       StringTokenizer npcDataUnformated;
/* 408 */       for (; allNPCData.hasMoreElements(); 
/* 412 */         npcDataUnformated.hasMoreElements())
/*     */       {
/* 410 */         npcDataUnformated = new StringTokenizer((String)allNPCData.nextElement(), "=");
/*     */ 
/* 414 */         StringTokenizer npcDataSpecific = new StringTokenizer((String)npcDataUnformated.nextElement(), "~");
/*     */ 
/* 418 */         int npcUniqueId = Integer.parseInt((String)npcDataSpecific.nextElement());
/* 419 */         String isSpawnString = (String)npcDataSpecific.nextElement();
/* 420 */         int npcMapId = Integer.parseInt((String)npcDataSpecific.nextElement());
/* 421 */         int x = Integer.parseInt((String)npcDataSpecific.nextElement());
/* 422 */         int y = Integer.parseInt((String)npcDataSpecific.nextElement());
/* 423 */         int currentHP = Integer.parseInt((String)npcDataSpecific.nextElement());
/* 424 */         int maxHp = Integer.parseInt((String)npcDataSpecific.nextElement());
/* 425 */         String StringisInCombat = (String)npcDataSpecific.nextElement();
/* 426 */         String lastDirection = (String)npcDataSpecific.nextElement();
/* 427 */         int lastHitTaken = Integer.parseInt((String)npcDataSpecific.nextElement());
/*     */ 
/* 431 */         boolean isInCombat = false;
/* 432 */         boolean isSpawned = false;
/*     */ 
/* 434 */         if (StringisInCombat.equals("true")) {
/* 435 */           isInCombat = true;
/*     */         }
/* 437 */         if (isSpawnString.equals("true")) {
/* 438 */           isSpawned = true;
/*     */         }
/*     */ 
/* 441 */         NPC npc = NPCList.getInstance().getNpc(npcUniqueId);
/* 442 */         if (npc != null)
/*     */         {
/* 444 */           npc.setMapId(npcMapId);
/* 445 */           npc.setPosX(x);
/* 446 */           npc.setPosY(y);
/* 447 */           npc.setCurrentHP(currentHP);
/* 448 */           npc.setMaxHP(maxHp);
/* 449 */           npc.setInCombat(isInCombat);
/* 450 */           npc.setLastDirection(lastDirection);
/* 451 */           npc.setLastHitTaken(lastHitTaken);
/* 452 */           npc.setSpawned(isSpawned);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 458 */       ArrayList groundItems = new ArrayList();
/* 459 */       int currentGroundItemSize = GroundItemList.getInstance().getGroundItems().size();
/*     */       StringTokenizer groundDataUnformated;
/* 460 */       for (; allGroundItemData.hasMoreElements(); 
/* 464 */         groundDataUnformated.hasMoreElements())
/*     */       {
/* 462 */         groundDataUnformated = new StringTokenizer((String)allGroundItemData.nextElement(), "=");

/* 466 */         StringTokenizer groundItemSpecificToken = new StringTokenizer((String)groundDataUnformated.nextElement(), "~");
/*     */ 
/* 468 */         int itemId = Integer.parseInt((String)groundItemSpecificToken.nextElement());
/* 469 */         int itemAmount = Integer.parseInt((String)groundItemSpecificToken.nextElement());
/* 470 */         int mapId = Integer.parseInt((String)groundItemSpecificToken.nextElement());
/* 471 */         int x = Integer.parseInt((String)groundItemSpecificToken.nextElement());
/* 472 */         int y = Integer.parseInt((String)groundItemSpecificToken.nextElement());
/*     */ 
/* 474 */         GroundItem gi = new GroundItem(itemId, itemAmount, mapId, x, y, null);
/* 475 */         groundItems.add(gi);
/*     */       }
/*     */ 
/* 478 */       GroundItemList.getInstance().setGroundItems(groundItems);
/*     */ 
/* 480 */       if (currentGroundItemSize != GroundItemList.getInstance().getGroundItems().size()) {
/* 481 */         GamePanel.getInstance().refreshGroundItems();
/*     */       }
/*     */ 
/* 485 */       ArrayList inventory = new ArrayList();
/*     */       StringTokenizer itemsTokenize;
/* 486 */       for (; uniquePlayersData.hasMoreElements(); 
/* 493 */         itemsTokenize.hasMoreTokens())
/*     */       {
/* 489 */         itemsTokenize = new StringTokenizer((String)uniquePlayersData.nextElement(), "~");
/*     */ 
/*     */ 
/* 495 */         String rawInventoryString = (String)itemsTokenize.nextElement();
/* 496 */         StringTokenizer inventoryTokenized = new StringTokenizer(rawInventoryString, "=");
/* 497 */         Item item = ItemList.getInstance().getItem(Integer.parseInt((String)inventoryTokenized.nextElement()));
/* 498 */         item.addAmount(Integer.parseInt((String)inventoryTokenized.nextElement()));
/* 499 */         inventory.add(item);
/*     */       }
/*     */ 
/* 503 */       boolean refreshInventory = false;
/* 504 */       if (inventory.size() != Inventory.getInstance().getInventoryItems().size()) {
/* 505 */         refreshInventory = true;
/*     */       }
/* 507 */       Inventory.getInstance().setInventoryItems(inventory);
/*     */ 
/* 512 */       ArrayList bank = new ArrayList();
/*     */       StringTokenizer bankTokenize;
/* 513 */       for (; bankData.hasMoreElements(); 
/* 520 */         bankTokenize.hasMoreTokens())
/*     */       {
/* 516 */         bankTokenize = new StringTokenizer((String)bankData.nextElement(), "~");
/*     */ 
/* 523 */         String rawBankString = (String)bankTokenize.nextElement();
/* 524 */         StringTokenizer bankTokenized = new StringTokenizer(rawBankString, "=");
/* 525 */         Item item = ItemList.getInstance().getItem(Integer.parseInt((String)bankTokenized.nextElement()));
/* 526 */         item.forceAddAmount(Integer.parseInt((String)bankTokenized.nextElement()));
/* 527 */         bank.add(item);
/*     */       }
/*     */ 
/* 532 */       Bank.getInstance().setBankItems(bank);
/*     */ 
/* 534 */       while (skillsData.hasMoreElements())
/*     */       {
/* 536 */         StringTokenizer skillsTokenized = new StringTokenizer((String)skillsData.nextElement(), "~");
/*     */ 
/* 538 */         ArrayList<Skill> skills = new ArrayList<Skill>();
/*     */         String skillName;
/*     */         int skillLevel;
/* 541 */         while (skillsTokenized.hasMoreTokens())
/*     */         {
/* 543 */           String rawSkillsToken = (String)skillsTokenized.nextElement();
/* 544 */           StringTokenizer skillTokenized = new StringTokenizer(rawSkillsToken, "=");
/* 545 */           skillName = (String)skillTokenized.nextElement();
/* 546 */           skillLevel = Integer.parseInt((String)skillTokenized.nextElement());
/* 547 */           int skillXP = Integer.parseInt((String)skillTokenized.nextElement());
/* 548 */           skills.add(new Skill(skillName, skillLevel, skillXP));
/*     */         }
/*     */ 
/* 552 */         int currentXp = 0;
/* 553 */         for (Skill s : SkillList.getInstance().getSkills()) {
/* 554 */           currentXp += s.getXp();
/*     */         }
/* 556 */         int newXp = 0;
/* 557 */         for (Skill s : skills) {
/* 558 */           newXp += s.getXp();
/*     */         }
/* 560 */         int xpDif = 0;
/* 561 */         if (currentXp != newXp) {
/* 562 */           xpDif = newXp - currentXp;
/*     */         }
/* 564 */         SkillList.getInstance().setSkills(skills);
/*     */ 
/* 566 */         if (xpDif != 0) {
/* 567 */           PlayerList.getInstance().getPlayer(Config.USERNAME).setXpDifference(xpDif);
/*     */         }
/* 569 */         GamePanel.getInstance().getSkillsGUI().refreshSkills(skills);
/*     */       }
/*     */ 
/* 573 */       while (serverMessages.hasMoreElements())
/*     */       {
/* 575 */         StringTokenizer serverMessagesTokenized = new StringTokenizer((String)serverMessages.nextElement(), "~");
/*     */ 
/* 578 */         String message = null;
/* 579 */         while (serverMessagesTokenized.hasMoreTokens())
/*     */         {
/* 582 */           message = (String)serverMessagesTokenized.nextElement();
/*     */         }
/*     */ 
/* 586 */         if (message.startsWith("CMD=")) {
/* 587 */           Command.getInstance().commandRecieved(message.substring(4));
/*     */         }
/*     */         else {
/* 590 */           if ((GamePanel.getInstance().getChat().getLastServerMessage() == null) && (!message.equals("ignoreme"))) {
/* 591 */             GamePanel.getInstance().getChat().addServerMessage(message, null);
/*     */           }
/* 593 */           if ((!message.equals(GamePanel.getInstance().getChat().getLastServerMessage())) && (!message.equals("ignoreme"))) {
/* 594 */             GamePanel.getInstance().getChat().addServerMessage(message, null);
/*     */           }
/*     */         }
/*     */       }
/* 598 */       while (playerEnergy.hasMoreElements())
/*     */       {
/* 600 */         StringTokenizer stats = new StringTokenizer((String)playerEnergy.nextElement(), "~");
/*     */ 
/* 602 */         int energy = Integer.parseInt((String)stats.nextElement());
/* 603 */         int attackBonus = Integer.parseInt((String)stats.nextElement());
/* 604 */         int defenceBonus = Integer.parseInt((String)stats.nextElement());
/*     */ 
/* 606 */         PlayerList.getInstance().getPlayer(Config.USERNAME).setEnergy(energy);
/* 607 */         PlayerList.getInstance().getPlayer(Config.USERNAME).setAttackBonus(attackBonus);
/* 608 */         PlayerList.getInstance().getPlayer(Config.USERNAME).setDefenceBonus(defenceBonus);
/*     */       }
/*     */ 
/* 611 */       while (flags.hasMoreElements())
/*     */       {
/* 613 */         String flagsData = (String)flags.nextElement();
/*     */ 
/* 615 */         if (!flagsData.equalsIgnoreCase("NOFLAGS")) {
/* 616 */           PlayerList.getInstance().getPlayer(Config.USERNAME).setFlags(flagsData);
/*     */         }
/*     */       }
/*     */ 
/* 620 */       List oldShop = ShopList.getInstance().getShops();
/*     */ 
/* 624 */       ArrayList shopArrayList = new ArrayList();
/*     */       StringTokenizer shopSetUnformated;
/* 625 */       for (; shops.hasMoreElements(); 
/* 630 */         shopSetUnformated.hasMoreElements())
/*     */       {
/* 627 */         String shopsUnformated = (String)shops.nextElement();
/* 628 */         shopSetUnformated = new StringTokenizer(shopsUnformated, "~");
/*     */ 
/* 632 */         StringTokenizer shopSet = new StringTokenizer((String)shopSetUnformated.nextElement(), "=");
/* 633 */         Shop shop = new Shop();
/* 634 */         while (shopSet.hasMoreElements())
/*     */         {
/* 637 */           String value = (String)shopSet.nextElement();
/*     */ 
/* 639 */           if (value.startsWith("ID")) {
/* 640 */             shop.setShopId(Integer.parseInt(value.substring(2)));
/*     */           }
/*     */           else {
/* 643 */             int itemId = Integer.parseInt(value);
/* 644 */             int amount = Integer.parseInt((String)shopSet.nextElement());
/* 645 */             shop.addItem(itemId, amount);
/*     */           }
/*     */         }
/*     */ 
/* 649 */         shopArrayList.add(shop);
/*     */       }
/*     */ 
/* 652 */       if (shopArrayList.size() > 0) {
/* 653 */         ShopList.getInstance().setShops(shopArrayList);
/*     */       }
/*     */ 
/* 658 */       boolean refreshShop = false;
/*     */ 
/* 660 */       if (oldShop.size() != shopArrayList.size())
/*     */       {
/* 662 */         System.out.println("in");
/* 663 */         if (GamePanel.getInstance().getShopGui() != null) {
/* 664 */           GamePanel.getInstance().getShopGui().refreshPanel();
/*     */         }
/*     */       }
/*     */ 
/* 668 */       if (refreshInventory)
/*     */       {
/* 670 */         if (GamePanel.getInstance().getShopGui() != null) {
/* 671 */           GamePanel.getInstance().getShopGui().refreshPanel();
/*     */         }
/* 673 */         GamePanel.getInstance().getInventory().refreshItems();
/*     */       }
/*     */ 
/* 678 */       PlayerList.getInstance().checkForLogouts();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 684 */       e.printStackTrace();
/*     */     }
/*     */     catch (Exception e) {
/* 687 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isClientNetworkThreadRunning()
/*     */   {
/* 694 */     return this.clientNetworkThreadRunning;
/*     */   }
/*     */ 
/*     */   public void setClientNetworkThreadRunning(boolean clientNetworkThreadRunning)
/*     */   {
/* 699 */     this.clientNetworkThreadRunning = clientNetworkThreadRunning;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     connections.ClientNetwork
 * JD-Core Version:    0.6.2
 */