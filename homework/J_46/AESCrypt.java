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
    private IvParameterSpec _iv;
    private SecretKeySpec _key_spec;
    private KeyGenerator _keygen;
    private SecretKey _secret_key;
    private Cipher _cypher;

    public AESCrypt() {
        try {
            this._iv = new IvParameterSpec("myInitVector1234".getBytes("UTF-8"));
            this._key_spec = new SecretKeySpec("my key here 1234".getBytes("UTF-8"), "AES");

            this._cypher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String corpus) {
        byte[] my_return = new byte[16];

        try {
            this._cypher.init(Cipher.ENCRYPT_MODE, this._key_spec, this._iv);
            my_return = this._cypher.doFinal(corpus.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(my_return);
    }

    public String decrypt(String corpus) {
        byte[] my_return = new byte[16];
        try {
            this._cypher.init(Cipher.DECRYPT_MODE, this._key_spec, this._iv);
            my_return = this._cypher.doFinal(Base64.getDecoder().decode(corpus));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return my_return.toString();
    }

}
