import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zehaeva on 12/2/2016.
 */
public class AESCrypt {
    private KeyGenerator _keygen;
    private SecretKey _secret_key;
    private Cipher _cypher;

    public AESCrypt() {
        try {
            this._keygen = KeyGenerator.getInstance("AES");
            this._keygen.init(256);

            this._secret_key = this._keygen.generateKey();

            this._cypher = Cipher.getInstance("AES");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public byte[] encrypt(String corpus) {
        byte[] my_return = new byte[0];

        try {
            this._cypher.init(Cipher.ENCRYPT_MODE, this._secret_key);
            my_return = this._cypher.doFinal(corpus.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return my_return;
    }

    public String decrypt(byte[] corpus) {
        byte[] my_return = new byte[0];
        try {
            this._cypher.init(Cipher.DECRYPT_MODE, this._secret_key);
            my_return = this._cypher.doFinal(corpus);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return my_return.toString();
    }

}
