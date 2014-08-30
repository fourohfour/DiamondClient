/*    */ package connections;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.security.KeyFactory;
/*    */ import java.security.PrivateKey;
/*    */ import java.security.PublicKey;
/*    */ import java.security.spec.X509EncodedKeySpec;
/*    */ import javax.crypto.Cipher;
/*    */ 
/*    */ public class PublicKeyManager
/*    */ {
/*    */   public static PublicKey getPublicKey()
/*    */   {
/*    */     try
/*    */     {
/* 20 */       String publicKey = "126353465633243148237090282245462010450182008874022002077456290007581641636339910195128631142343009679702799178701186534112028015425233271964941489509677582505598227331728554865729209441026634300319771430997083576944354054961460943085641194348671718153063034855382854924326697987997646650076500120533266801569";
/* 21 */       byte[] keyBytes = publicKey.getBytes();
/*    */ 
/* 23 */       X509EncodedKeySpec spec = 
/* 24 */         new X509EncodedKeySpec(keyBytes);
/* 25 */       KeyFactory kf = KeyFactory.getInstance("RSA");
/* 26 */       return kf.generatePublic(spec);
/*    */     } catch (Exception e) {
/* 28 */       e.printStackTrace();
/*    */ 
/* 30 */       System.out.println("null");
/*    */     }
/* 32 */     return null;
/*    */   }
/*    */ 
/*    */   public static byte[] encrypt(String text, PublicKey key)
/*    */   {
/* 39 */     byte[] cipherText = null;
/*    */     try
/*    */     {
/* 42 */       Cipher cipher = Cipher.getInstance("RSA");
/*    */ 
/* 44 */       cipher.init(1, key);
/* 45 */       cipherText = cipher.doFinal(text.getBytes());
/*    */     } catch (Exception e) {
/* 47 */       e.printStackTrace();
/*    */     }
/* 49 */     return cipherText;
/*    */   }
/*    */ 
/*    */   public static String decrypt(byte[] text, PrivateKey key) {
/* 53 */     byte[] dectyptedText = null;
/*    */     try
/*    */     {
/* 56 */       Cipher cipher = Cipher.getInstance("RSA");
/*    */ 
/* 59 */       cipher.init(2, key);
/* 60 */       dectyptedText = cipher.doFinal(text);
/*    */     }
/*    */     catch (Exception ex) {
/* 63 */       ex.printStackTrace();
/*    */     }
/*    */ 
/* 66 */     return new String(dectyptedText);
/*    */   }
/*    */ }

/* Location:           X:\Stuff\Jack\Downloads\Diamond Hunt V0.601\clientnew.jar
 * Qualified Name:     connections.PublicKeyManager
 * JD-Core Version:    0.6.2
 */