import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

public class TripleDESEncrypterExample {

/**
 * * @param secretKey a secret key given by AsiaMax
 * * @param ivStr a initialization vector given by AsiaMax
 * * @param encryptedMsg the target encrypted message
 * * @return a decryption message of encrpytedMsg
 * 
 */
    public static String decrypt(String secretKey,String ivStr, String encryptedMsg) {

        try {

            SecretKey key = new SecretKeySpec(secretKey.getBytes(Charset.forName("UTF-8")), "DESede");
            IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes(Charset.forName("UTF-8")));

            byte[] decoded64 = Base64.decodeBase64(encryptedMsg);
            Cipher decipher = Cipher.getInstance("DESede/CFB8/NoPadding");
            decipher.init(Cipher.DECRYPT_MODE, key, iv);
            final byte[] plainText = decipher.doFinal(decoded64);

            return new String(plainText, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }

}