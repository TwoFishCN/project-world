package com.project.world.lean.nio.dgc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClient {
    public static void main(String[] args) throws IOException {
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();

        DatagramChannel channel = DatagramChannel.open();

        channel.send(buf, new InetSocketAddress("localhost", 9999));

        buf.clear();
        buf.put("shutdown".getBytes());
        buf.flip();

        channel.send(buf, new InetSocketAddress("localhost", 9999));
        channel.close();
    }
}
