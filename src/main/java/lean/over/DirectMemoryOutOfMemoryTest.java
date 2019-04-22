package lean.over;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirectMemoryOutOfMemoryTest {

    public static void main(String[] args) {
        List<ByteBuffer> buffers = new ArrayList<>();

        while (true) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
            buffers.add(buffer);
        }

    }
}
