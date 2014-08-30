/*     */ package GUI.brewing;
/*     */ 
/*     */ import connections.Command;

/*     */ import java.awt.Color;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;

/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;

/*     */ import players.Item;
/*     */ import players.ItemList;
/*     */ 
/*     */ public class BrewingGUI extends JPanel
/*     */ {
/*     */   private JPanel firstIngredientChosenPanel;
/*     */   private JPanel secondIngredientChosenPanel;
/*  27 */   private int firstIngredientChosen = -1;
/*  28 */   private int secondIngredientChosen = -1;
/*     */ 
/* 182 */   private MouseAdapter mouseClickAdapterPrimary = new MouseAdapter()
/*     */   {
/*     */     public void mousePressed(MouseEvent e)
/*     */     {
/* 187 */       BrewingGUI.this.firstIngredientChosenPanel.removeAll();
/* 188 */       int itemIdClicked = Integer.parseInt(((JLabel)e.getSource()).getName());
/*     */ 
/* 190 */       JLabel chosenImg = new JLabel();
/* 191 */       ImageIcon image = new ImageIcon(ItemList.getInstance().getItem(itemIdClicked).getIMGUrl());
/* 192 */       chosenImg.setIcon(image);
/* 193 */       chosenImg.setBounds(0, 0, 50, 50);
/* 194 */       BrewingGUI.this.firstIngredientChosenPanel.add(chosenImg);
/* 195 */       BrewingGUI.this.setFirstIngredientChosen(itemIdClicked);
/*     */     }
/* 182 */   };
/*     */ 
/* 199 */   private MouseAdapter mouseClickAdapterSecondary = new MouseAdapter()
/*     */   {
/*     */     public void mousePressed(MouseEvent e)
/*     */     {
/* 204 */       BrewingGUI.this.secondIngredientChosenPanel.removeAll();
/* 205 */       int itemIdClicked = Integer.parseInt(((JLabel)e.getSource()).getName());
/*     */ 
/* 207 */       JLabel chosenImg = new JLabel();
/* 208 */       ImageIcon image = new ImageIcon(ItemList.getInstance().getItem(itemIdClicked).getIMGUrl());
/* 209 */       chosenImg.setIcon(image);
/* 210 */       chosenImg.setBounds(0, 0, 50, 50);
/* 211 */       BrewingGUI.this.secondIngredientChosenPanel.add(chosenImg);
/* 212 */       BrewingGUI.this.setSecondIngredientChosen(itemIdClicked);
/*     */     }
/* 199 */   };
/*     */ 
/*     */   public BrewingGUI getBrewingGUI()
/*     */   {
/*  38 */     setLayout(null);
/*  39 */     setBounds(5, 40, 780, 400);
/*     */ 
/*  41 */     JPanel leafsPanel = new JPanel();
/*  42 */     leafsPanel.setLayout(new FlowLayout(0));
/*  43 */     leafsPanel.setBounds(10, 60, 300, 300);
/*  44 */     leafsPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
/*  45 */     leafsPanel.setBackground(Color.white);
/*     */ 
/*  47 */     JPanel secondaryIngrediencePanel = new JPanel();
/*  48 */     secondaryIngrediencePanel.setLayout(new FlowLayout(0));
/*  49 */     secondaryIngrediencePanel.setBounds(350, 60, 300, 300);
/*  50 */     secondaryIngrediencePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
/*  51 */     secondaryIngrediencePanel.setBackground(Color.white);
/*     */ 
/*  54 */     JLabel leafTitle = new JLabel("Choose Leaf");
/*  55 */     leafTitle.setBounds(100, 10, 100, 20);
/*  56 */     add(leafTitle);
/*     */ 
/*  58 */     JLabel secondaryIngTitle = new JLabel("Choose Secondary Ingredient");
/*  59 */     secondaryIngTitle.setBounds(400, 10, 220, 20);
/*  60 */     add(secondaryIngTitle);
/*     */ 
/*  63 */     JButton closeButton = new JButton("X");
/*  64 */     closeButton.setBounds(720, 10, 40, 40);
/*  65 */     closeButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  68 */         BrewingGUI.this.close();
/*     */       }
/*     */     });
/*  71 */     add(closeButton);
/*     */ 
/*  74 */     JLabel greenLeaf = new JLabel();
/*  75 */     int greenLeafItemId = 93;
/*  76 */     ImageIcon greenLeafImg = new ImageIcon(ItemList.getInstance().getItem(greenLeafItemId).getIMGUrl());
/*  77 */     greenLeaf.setName(String.valueOf(greenLeafItemId));
/*  78 */     greenLeaf.addMouseListener(this.mouseClickAdapterPrimary);
/*  79 */     greenLeaf.setIcon(greenLeafImg);
/*  80 */     leafsPanel.add(greenLeaf);
/*     */ 
/*  82 */     JLabel limeLeaf = new JLabel();
/*  83 */     int limeLeafItemId = 94;
/*  84 */     ImageIcon limeLeafImg = new ImageIcon(ItemList.getInstance().getItem(limeLeafItemId).getIMGUrl());
/*  85 */     limeLeaf.setIcon(limeLeafImg);
/*  86 */     limeLeaf.setName(String.valueOf(limeLeafItemId));
/*  87 */     limeLeaf.addMouseListener(this.mouseClickAdapterPrimary);
/*  88 */     leafsPanel.add(limeLeaf);
/*     */ 
/*  90 */     JLabel redLeaf = new JLabel();
/*  91 */     int redLeafItemId = 95;
/*  92 */     ImageIcon redLeafImg = new ImageIcon(ItemList.getInstance().getItem(redLeafItemId).getIMGUrl());
/*  93 */     redLeaf.setIcon(redLeafImg);
/*  94 */     redLeaf.setName(String.valueOf(redLeafItemId));
/*  95 */     redLeaf.addMouseListener(this.mouseClickAdapterPrimary);
/*  96 */     leafsPanel.add(redLeaf);
/*     */ 
/*  98 */     JLabel goldLeaf = new JLabel();
/*  99 */     int goldLeafItemId = 96;
/* 100 */     ImageIcon goldLeafImg = new ImageIcon(ItemList.getInstance().getItem(goldLeafItemId).getIMGUrl());
/* 101 */     goldLeaf.setIcon(goldLeafImg);
/* 102 */     goldLeaf.setName(String.valueOf(goldLeafItemId));
/* 103 */     goldLeaf.addMouseListener(this.mouseClickAdapterPrimary);
/* 104 */     leafsPanel.add(goldLeaf);
/*     */ 
/* 106 */     JLabel crystalLeaf = new JLabel();
/* 107 */     int crystalLeafItemId = 97;
/* 108 */     ImageIcon crystalLeafImg = new ImageIcon(ItemList.getInstance().getItem(crystalLeafItemId).getIMGUrl());
/* 109 */     crystalLeaf.setIcon(crystalLeafImg);
/* 110 */     crystalLeaf.setName(String.valueOf(crystalLeafItemId));
/* 111 */     crystalLeaf.addMouseListener(this.mouseClickAdapterPrimary);
/* 112 */     leafsPanel.add(crystalLeaf);
/*     */ 
/* 115 */     JLabel grain = new JLabel();
/* 116 */     int grainItemId = 9;
/* 117 */     ImageIcon grainImg = new ImageIcon(ItemList.getInstance().getItem(grainItemId).getIMGUrl());
/* 118 */     grain.setIcon(grainImg);
/* 119 */     grain.setName(String.valueOf(grainItemId));
/* 120 */     grain.addMouseListener(this.mouseClickAdapterSecondary);
/* 121 */     secondaryIngrediencePanel.add(grain);
/*     */ 
/* 123 */     JLabel redMushroom = new JLabel();
/* 124 */     int redMushroomItemId = 10;
/* 125 */     ImageIcon redMushroomImg = new ImageIcon(ItemList.getInstance().getItem(redMushroomItemId).getIMGUrl());
/* 126 */     redMushroom.setIcon(redMushroomImg);
/* 127 */     redMushroom.setName(String.valueOf(redMushroomItemId));
/* 128 */     redMushroom.addMouseListener(this.mouseClickAdapterSecondary);
/* 129 */     secondaryIngrediencePanel.add(redMushroom);
/*     */ 
/* 131 */     JLabel blueMushroom = new JLabel();
/* 132 */     int blueMushroomItemId = 114;
/* 133 */     ImageIcon blueMushroomImg = new ImageIcon(ItemList.getInstance().getItem(blueMushroomItemId).getIMGUrl());
/* 134 */     blueMushroom.setIcon(blueMushroomImg);
/* 135 */     blueMushroom.setName(String.valueOf(blueMushroomItemId));
/* 136 */     blueMushroom.addMouseListener(this.mouseClickAdapterSecondary);
/* 137 */     secondaryIngrediencePanel.add(blueMushroom);
/*     */ 
/* 139 */     JLabel greenMushroom = new JLabel();
/* 140 */     int greenMushroomItemId = 115;
/* 141 */     ImageIcon greenMushroomImg = new ImageIcon(ItemList.getInstance().getItem(greenMushroomItemId).getIMGUrl());
/* 142 */     greenMushroom.setIcon(greenMushroomImg);
/* 143 */     greenMushroom.setName(String.valueOf(greenMushroomItemId));
/* 144 */     greenMushroom.addMouseListener(this.mouseClickAdapterSecondary);
/* 145 */     secondaryIngrediencePanel.add(greenMushroom);
/*     */ 
/* 147 */     this.firstIngredientChosenPanel = new JPanel();
/* 148 */     this.firstIngredientChosenPanel.setLayout(null);
/* 149 */     this.firstIngredientChosenPanel.setBounds(700, 100, 50, 50);
/* 150 */     this.firstIngredientChosenPanel.setBackground(Color.white);
/* 151 */     this.firstIngredientChosenPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
/*     */ 
/* 153 */     JLabel plusSign = new JLabel("+");
/* 154 */     plusSign.setBounds(715, 160, 20, 20);
/* 155 */     plusSign.setFont(new Font("Serif", 1, 30));
/* 156 */     add(plusSign);
/*     */ 
/* 158 */     this.secondIngredientChosenPanel = new JPanel();
/* 159 */     this.secondIngredientChosenPanel.setLayout(null);
/* 160 */     this.secondIngredientChosenPanel.setBounds(700, 200, 50, 50);
/* 161 */     this.secondIngredientChosenPanel.setBackground(Color.white);
/* 162 */     this.secondIngredientChosenPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
/*     */ 
/* 164 */     JButton mixButton = new JButton("Mix");
/* 165 */     mixButton.setBounds(680, 300, 80, 30);
/* 166 */     mixButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 169 */         BrewingGUI.this.mix(BrewingGUI.this.firstIngredientChosen, BrewingGUI.this.secondIngredientChosen);
/*     */       }
/*     */     });
/* 172 */     add(mixButton);
/*     */ 
/* 174 */     add(leafsPanel);
/* 175 */     add(secondaryIngrediencePanel);
/* 176 */     add(this.firstIngredientChosenPanel);
/* 177 */     add(this.secondIngredientChosenPanel);
/*     */ 
/* 179 */     return this;
/*     */   }
/*     */ 
/*     */   public void mix(int leafId, int secondId)
/*     */   {
/* 219 */     if ((leafId != -1) || (secondId != -1))
/* 220 */       Command.getInstance().sendCommand("brew", "primary=" + leafId + ";secondary=" + secondId + ";");
/*     */   }
/*     */ 
/*     */   public void close()
/*     */   {
/* 225 */     removeAll();
/* 226 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   public int getFirstIngredientChosen() {
/* 230 */     return this.firstIngredientChosen;
/*     */   }
/*     */ 
/*     */   public void setFirstIngredientChosen(int firstIngredientChosen) {
/* 234 */     this.firstIngredientChosen = firstIngredientChosen;
/*     */   }
/*     */ 
/*     */   public int getSecondIngredientChosen() {
/* 238 */     return this.secondIngredientChosen;
/*     */   }
/*     */ 
/*     */   public void setSecondIngredientChosen(int secondIngredientChosen) {
/* 242 */     this.secondIngredientChosen = secondIngredientChosen;
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     GUI.brewing.BrewingGUI
 * JD-Core Version:    0.6.2
 */