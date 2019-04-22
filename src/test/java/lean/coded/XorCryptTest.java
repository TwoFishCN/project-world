package lean.coded;

import org.junit.Assert;
import org.junit.Test;

public class XorCryptTest {

    @Test
    public void encryptAndDecrypt() {
        XorCrypt encoder = new XorCrypt();

        String source = "这是一段明文数据";
        String password = "password";

        String encoded = encoder.encrypt(source, password);
        String decoded = encoder.decrypt(encoded, password);

        Assert.assertEquals(decoded, source);
    }
}
