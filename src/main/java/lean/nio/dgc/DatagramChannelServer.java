package lean.nio.dgc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelServer {
    public static void main(String[] args) throws IOException {

        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));


        while (true) {
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            channel.receive(buf);

            System.out.println(buf.toString());

            String value = new String(buf.array());

            System.out.println("Got value : " + value);
            if (value.contains("shutdown")) {
                break;
            }
        }
    }
}
