/*     */ package Game;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Panel;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.io.PrintWriter;
/*     */ import java.net.Socket;
/*     */ import java.util.List;
/*     */ import javax.swing.JFrame;
/*     */ import players.Config;
/*     */ import players.Player;
/*     */ import players.PlayerList;
/*     */ 
/*     */ public class Interface extends JFrame
/*     */   implements Runnable
/*     */ {
/*  22 */   private String clientChat = "";
/*     */   private String title;
/*     */   private int sizex;
/*     */   private int sizey;
/*     */ 
/*     */   public Interface(String title, int sizex, int sizey)
/*     */   {
/*  31 */     super("Game Screen");
/*  32 */     this.title = title;
/*  33 */     this.sizex = sizex;
/*  34 */     this.sizey = sizey;
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/*  39 */     super.setTitle(this.title);
/*     */ 
/*  42 */     super.setSize(this.sizex, this.sizey);
/*  43 */     super.addKeyListener(new KeyListener()
/*     */     {
/*     */       public void keyTyped(KeyEvent e)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyPressed(KeyEvent e)
/*     */       {
/*  56 */         Interface.this.clientChat += e.getKeyChar();
/*     */ 
/*  62 */         if ((e.getKeyCode() == 10) && (Interface.this.clientChat.length() == 1))
/*     */         {
/*  64 */           Interface.this.clientChat = "";
/*  65 */           return;
/*     */         }
/*     */ 
/*  68 */         if ((e.getKeyCode() == 10) && (Interface.this.clientChat.length() > 1))
/*     */         {
/*  71 */           Interface.this.clientChat = "";
/*     */         }
/*     */ 
/*  74 */         Interface.this.repaint();
/*     */       }
/*     */     });
/*  80 */     super.addMouseListener(new MouseListener()
/*     */     {
/*     */       public void mouseReleased(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mousePressed(MouseEvent e)
/*     */       {
/*     */         try
/*     */         {
/*  90 */           Player currentPlayer = PlayerList.getInstance().getPlayer(Config.USERNAME);
/*  91 */           Socket socket = Game.getInstance().getServerSocket();
/*     */ 
/*  93 */           PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
/*  94 */           out.println("COMMAND=move;USERNAME=" + currentPlayer.getUsername() + ";X=" + e.getX() + ";Y=" + e.getY());
/*     */         }
/*     */         catch (Exception e1)
/*     */         {
/* 100 */           e1.printStackTrace();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void mouseExited(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseEntered(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseClicked(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 123 */     Panel panel = new Panel();
/* 124 */     panel.setBackground(Color.decode("#669966"));
/* 125 */     add(panel);
/* 126 */     super.setVisible(true);
/* 127 */     new Thread(this).start();
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/* 133 */     super.paint(g);
/*     */ 
/* 136 */     List<Player> players = PlayerList.getInstance().getPlayers();
/* 137 */     for (Player p : players)
/*     */     {
/* 139 */       if (p.getUsername().equals(Config.USERNAME))
/* 140 */         g.setColor(Color.BLUE);
/*     */       else {
/* 142 */         g.setColor(Color.WHITE);
/*     */       }
/* 144 */       g.fillRect(p.getX(), p.getY(), 50, 50);
/*     */ 
/* 146 */       g.setColor(Color.BLACK);
/* 147 */       g.drawRect(p.getX(), p.getY(), 50, 50);
/* 148 */       g.drawString(p.getUsername(), p.getX(), p.getY() - 10);
/*     */ 
/* 150 */       if (!p.getChat().equals(" "))
/*     */       {
/* 152 */         g.setColor(Color.YELLOW);
/* 153 */         g.drawString(p.getChat(), p.getX(), p.getY() - 30);
/* 154 */         g.setColor(Color.BLACK);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 159 */     g.drawString(Config.USERNAME + " :", 10, 550);
/* 160 */     g.setColor(Color.YELLOW);
/* 161 */     g.drawString(this.clientChat + "|", 50, 550);
/* 162 */     g.setColor(Color.BLACK);
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*     */     while (true)
/*     */     {
/* 169 */       repaint();
/*     */       try {
/* 171 */         Thread.sleep(50L);
/*     */       } catch (InterruptedException e) {
/* 173 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     Game.Interface
 * JD-Core Version:    0.6.2
 */