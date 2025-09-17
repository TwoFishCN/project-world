package com.project.world.hutool;


import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;

/**
 * RSA 测试
 *
 * @author hwwei
 * @since 2025/9/12 09:20
 */
public class AsymmetricExample {
    public static void main(String[] args) {
        // 1. 生成RSA密钥对
        KeyPair keyPair = SecureUtil.generateKeyPair("SM2");

        // 2. 创建非对称加密对象（传入私钥和公钥）
//        String privateKey = Base64.encode(keyPair.getPrivate().getEncoded());
//        String publicKey = Base64.encode(keyPair.getPublic().getEncoded());

        String privateKey = "X3tgd4r6+IIuipAkhqG1I2x3shqyKYTTKuZkI0ro4ZU=";
        String publicKey = "BDlj7OO/7n7KjIJn1My+RpIp2ZXUxBLB/itNoCTY+Vl4cR7S7/9vnGxtzp2AWiw/ZJb5my90JjWNhE76V1jRcbg=";

        System.out.println("私钥秘钥：" + privateKey);
        System.out.println("公钥秘钥：" + publicKey);

        // 3. 要加密的数据
        String content = "System.out.println";

        // 4. 用公钥加密
        SM2 sm2 = SmUtil.sm2(null, publicKey);
        byte[] encryptByPrivate = sm2.encrypt(content.getBytes(StandardCharsets.UTF_8), KeyType.PublicKey);
        String encryptStr = Base64.encode(encryptByPrivate);
        System.out.println("公钥加密后：" + encryptStr);

        // 5. 用私钥解密
        SM2 sm22 = SmUtil.sm2(privateKey, null);
        byte[] decryptByPublic = sm22.decrypt(Base64.decode(encryptStr), KeyType.PrivateKey);
        String decryptStr = new String(decryptByPublic, StandardCharsets.UTF_8);
        System.out.println("私钥解密后：" + decryptStr);
    }
}