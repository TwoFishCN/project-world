package com.project.world.lean.coded;

import java.util.*;

/**
 * 针对纯英文文本的xor加密破解
 * 基于空格字符在xor的特殊表现, 可以通过大量密码本来猜解密文
 *
 * doc: 利用重复使用key的流加密密文，来破解目标密文
 *
 * 1. 理解加密解密算法
 * 题目是要求我们利用多条密文( Ci ,i∈[1,10])来破译目标密文(p)，而已有的密文是利用stream cypher(EkEk)来进行加密，加密用的密钥(k)是重复使用的。
 * 同时，stream cypher是理论课上讲的XOR（异或）运算的加密，即利用一个足够长的key与我们的明文p进行一一异或，得到最后的c。即关系如下：
 * c=p⨁k
 * c=p⨁k
 * 2. 分析加密、解密过程的突破口
 * 突破口1：利用XOR（异或）运算的性质
 * 我们已知异或运算有以下性质：
 * A⨁B=C⇒A⨁C=B或B⨁C=A
 * A⨁B=C⇒A⨁C=B或B⨁C=A
 *
 * 套入我们上面的加密/解密算法中：
 * C⨁P=K和K⨁C=P
 * C⨁P=K和K⨁C=P
 *
 * 如果我们获得了密文C，通过一定方式解密出来明文P，那么即可简单得到我们的密钥K，接下来只要密钥不变，我们就可以无障碍地破解密文C同时还可以得到
 * C1⨁C2=(P1⨁K)⨁(P2⨁K)=P1⨁P2
 * C1⨁C2=(P1⨁K)⨁(P2⨁K)=P1⨁P2
 *
 * 这一条特性，使得我们对密文的处理可以跳过了密钥K的处理，使得结果变成明文的异或结果，一旦我们利用明文的相关特点，即可破解明文.
 *
 * 构建明文之间的异或关系，查找此关系即可得知目标位可能的数据内容，通过简单分析即可找出密文表达的内容
 *
 */
public class XorCrackBySpace {

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

        cipherText = xor(passwordByte, cipherText);

        for (byte[] bytes : cipherText) {
            for (byte aByte : bytes) {
                if (Character.isLetter(aByte) || Character.isSpaceChar(aByte)) {
                    System.out.print((char) aByte);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();

        }

        System.out.println(new String(passwordByte));

    }

    public static List<byte[]> xor(byte[] passwordByte, List<byte[]> cipherText) {
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
//        return String.valueOf((char) xor).matches("[\\S|\\s]+");
        return Character.isLetterOrDigit(xor) || Character.isSpaceChar(xor);
    }

}
