package com.project.world.lean.coded;


import org.springframework.util.Assert;

public class XorCryptTest {

    public void encryptAndDecrypt() {
        XorCrypt encoder = new XorCrypt();

        String source = "这是一段明文数据";
        String password = "password";

        String encoded = encoder.encrypt(source, password);
        String decoded = encoder.decrypt(encoded, password);

        Assert.isTrue(decoded.equals(source), "断言失败");
    }
}
