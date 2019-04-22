package lean.nio.selecter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class SelectorServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        DatagramChannel channelOne = DatagramChannel.open();
        channelOne.configureBlocking(false);
        channelOne.socket().bind(new InetSocketAddress(9999));

        DatagramChannel channelTwo = DatagramChannel.open();
        channelTwo.configureBlocking(false);
        channelTwo.socket().bind(new InetSocketAddress(9998));

        Selector selector = Selector.open();
        SelectionKey keyOne = channelOne.register(selector, SelectionKey.OP_READ);
        SelectionKey keyTwo = channelTwo.register(selector, SelectionKey.OP_READ);

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    System.out.println("key.isAcceptable");
                } else if (key.isConnectable()) {
                    System.out.println("key.isConnectable");
                } else if (key.isWritable()) {
                    System.out.println("key.isWritable");
                    Thread.sleep(2000);
                } else if (key.isReadable()) {
                    ByteBuffer buf = ByteBuffer.allocate(48);
                    buf.clear();
                    ((DatagramChannel) key.channel()).receive(buf);
                    String value = new String(buf.array());

                    System.out.println("Got value : " + value);

                }


                keyIterator.remove();
            }
        }
    }
}
