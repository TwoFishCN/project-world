package lean.coded;

import java.util.Base64;

/**
 * TODO just toy code
 * 通过简单异或实现对原文进行加密转义
 */
@Deprecated
public class XorCrypt {

    public String encrypt(String source, String password) {
        byte[] xorResult = xor(source.getBytes(), password.getBytes());
        return Base64.getEncoder().encodeToString(xorResult);
    }

    public String decrypt(String encrypted, String password) {
        byte[] bytes = Base64.getDecoder().decode(encrypted);
        byte[] xorResult = xor(bytes, password.getBytes());
        return new String(xorResult);
    }

    public byte[] xor(byte[] source, byte[] password) {

        int sourceLength = source.length;
        int passwordLength = password.length;

        byte[] result = new byte[sourceLength];

        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (source[i % sourceLength] ^ password[i % passwordLength]);
        }

        return result;
    }
}
