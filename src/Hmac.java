import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hmac {

    private static final String HMAC_ALGO = "HmacSHA256";

    private final byte[] bytes = new byte[16];

    public byte[] getBytes(){
        return bytes;
    }

    public static String bytesToHex(byte [] bytes){
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b: bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public byte[] generateKey(){
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }

    public byte[] encrypt(int compChoice) throws NoSuchAlgorithmException, InvalidKeyException {

        Mac signer = Mac.getInstance(HMAC_ALGO);
        SecretKeySpec keySpec = new SecretKeySpec(generateKey(), HMAC_ALGO);
        signer.init(keySpec);

        return signer.doFinal(Integer.toString(compChoice).getBytes(StandardCharsets.UTF_8));
    }
}
