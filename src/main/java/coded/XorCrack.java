package coded;

import java.util.*;

public class XorCrack {

    public static void main(String[] args) {
        XorCrypt crypt = new XorCrypt();

        String password = "password";

        List<String> plainText = new ArrayList<>();
        plainText.add("We can factor the number 15 with quantum computers. We can also factor the number 15 with a dog trained to bark three times - Robert Harley");
        plainText.add("Euler would probably enjoy that now his theorem becomes a corner stone of crypto - Annonymous on Euler's theorem");
        plainText.add("The nice thing about Keeyloq is now we cryptographers can drive a lot of fancy cars - Dan Boneh");
        plainText.add("The ciphertext produced by a weak encryption algorithm looks as good as ciphertext produced by a strong encryption algorithm - Philip Zimmermann");
        plainText.add("You don't want to buy a set of car keys from a guy who specializes in stealing cars - Marc Rotenberg commenting on Clipper");
        plainText.add("There are two types of cryptography - that which will keep secrets safe from your little sister, and that which will keep secrets safe from your government - government");
        plainText.add("There are two types of cyptography: one that allows the Government to use brute force to break the code, and one that requires the Government to use brute force ll keep secret");
        plainText.add("We can see the point where the chip is unhappy if a wrong bit is sent and consumes more power from the environment - Adi Shamir");
        plainText.add("A (private-key)  encryption scheme states 3 algorithms, namely a procedure for generating keys, a procedure for encrypting, and a procedure for decrypting.");

        List<byte[]> cipherText = new ArrayList<>();
        for (String text : plainText) {
            byte[] cipherBytes = Base64.getDecoder().decode(crypt.encrypt(text, password));
            cipherText.add(cipherBytes);
        }

        int maxPassLen = 0;
        for (byte[] bytes : cipherText) {
            maxPassLen = bytes.length > maxPassLen ? bytes.length : maxPassLen;
        }
        byte[] passwordByte = new byte[maxPassLen];

        for (byte[] cipherByte : cipherText) {
            for (int cipherByteIndex = 0; cipherByteIndex < cipherByte.length; cipherByteIndex++) {
                if (isSpace(cipherByteIndex, cipherByte, cipherText)) {
                    passwordByte[cipherByteIndex] = (byte) (cipherByte[cipherByteIndex] ^ 0x20);
                }
            }
        }

        cipherText = xor(password, cipherText);

        for (byte[] bytes : cipherText) {
            System.out.println(new String(bytes));
        }

        System.out.println(new String(passwordByte));

    }

    public static List<byte[]> xor(String password, List<byte[]> cipherText) {
        byte[] passwordByte = password.getBytes();
        XorCrypt crypt = new XorCrypt();
        List<byte[]> cipherBytes = new ArrayList<>();

        for (byte[] bytes : cipherText) {
            cipherBytes.add(crypt.xor(bytes, passwordByte));
        }

        return cipherBytes;
    }

    public static boolean isSpace(int cipherByteIndex, byte[] cipherByte, List<byte[]> cipherText) {
        for (byte[] otherCipherByte : cipherText) {
            if (Arrays.equals(cipherByte, otherCipherByte)) {
                continue;
            }

            if (cipherByte.length <= cipherByteIndex || otherCipherByte.length <= cipherByteIndex) {
                return false;
            }

            if (!isSpace(cipherByteIndex, cipherByte, otherCipherByte)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSpace(int cipherByteIndex, byte[] cipherByte, byte[] otherCipherByte) {
        int xor = cipherByte[cipherByteIndex] ^ 0x20 ^ otherCipherByte[cipherByteIndex];
        return Character.isLetter(xor) || Character.isSpaceChar(xor);
    }

}
