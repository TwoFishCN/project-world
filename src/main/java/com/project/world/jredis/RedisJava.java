package com.project.world.jredis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;

import java.util.concurrent.ExecutionException;

public class RedisJava {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //连接本地的 Redis 服务
        RedisURI uri = RedisURI.builder().withHost("192.168.31.44").withPort(6379).build();
        RedisClient jedis = RedisClient.create(uri);
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.connect().async().ping());
    }
}
