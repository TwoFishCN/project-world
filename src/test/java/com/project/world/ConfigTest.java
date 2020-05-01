package com.project.world;

import com.project.world.property.ConfigProperty;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConfigTest {

    @Autowired
    private ConfigProperty configProperty;

    @Test
    public void test() {
        String result = configProperty.getSelf().getMapping().get("abc");
        Assertions.assertThat(result).isEqualTo("hello");
    }
}
