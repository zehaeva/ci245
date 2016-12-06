import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by zehaeva on 12/2/2016.
 */
public class AESCrypt {
    private SecretKeySpec _key_spec;
    private Cipher _cypher;

    public AESCrypt() {
        try {
            this._key_spec = new SecretKeySpec("my key here 1234".getBytes(), "AES");

            this._cypher = Cipher.getInstance("AES");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String corpus) {
        byte[] my_return = null;

        try {
            this._cypher.init(Cipher.ENCRYPT_MODE, this._key_spec);
            my_return = this._cypher.doFinal(corpus.getBytes());
            return Base64.getEncoder().encodeToString(my_return);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String corpus) {
        byte[] my_return = null;

        try {
            this._cypher.init(Cipher.DECRYPT_MODE, this._key_spec);
            my_return = this._cypher.doFinal(Base64.getDecoder().decode(corpus));
            return new String(my_return);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

}
