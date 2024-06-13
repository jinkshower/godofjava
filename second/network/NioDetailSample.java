package second.network;

import java.nio.IntBuffer;

public class NioDetailSample {

    public static void main(String[] args) {
        NioDetailSample sample = new NioDetailSample();
        sample.checkBuffer();
    }

    private void checkBuffer() {
        try {
            IntBuffer buffer = IntBuffer.allocate(1024);
            for (int loop = 0; loop < 100; loop++) {
                buffer.put(loop);
            }
            System.out.println("buffer.capacity() = " + buffer.capacity());
            System.out.println("buffer.limit() = " + buffer.limit());
            System.out.println("buffer.position = " + buffer.position());
            buffer.flip();
            System.out.println("buffer flipped");
            System.out.println("buffer.limit() = " + buffer.limit());
            System.out.println("buffer.position() = " + buffer.position());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
