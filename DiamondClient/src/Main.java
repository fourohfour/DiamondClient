/*    */ import GUI.GUI;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.security.PublicKey;
/*    */ 
/*    */ public class Main
/*    */ {
/*    */   public static void main(String[] args)
/*    */     throws FileNotFoundException, IOException, ClassNotFoundException
/*    */   {
/* 18 */     ObjectInputStream inputStream = null;
/* 19 */     inputStream = new ObjectInputStream(new FileInputStream("cache/public.key"));
/* 20 */     PublicKey publicKey = (PublicKey)inputStream.readObject();
/* 21 */     inputStream.close();
/* 22 */     players.Config.PUBLIC_KEY = publicKey;
/*    */ 
/* 24 */     GUI.getInstance().init();
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     Main
 * JD-Core Version:    0.6.2
 */