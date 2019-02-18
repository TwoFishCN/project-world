package nio.selecter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;

public class SelectorClient {
    public static void main(String[] args) throws IOException {
        System.out.println(SelectionKey.OP_READ | SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE);
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

        channel.send(buf, new InetSocketAddress("localhost", 9998));
        channel.close();
    }
}
