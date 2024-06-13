package second.network;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioSample {

    public static void main(String[] args) {
        NioSample sample = new NioSample();
        sample.basicWriteAndRead();
    }

    public void basicWriteAndRead() {
        String fileName = "/Users/person/Documents/godofjava/text/nio.txt";
        try {
            writeFile(fileName, "My first NIO sample");
            readFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String fileName, String data) throws Exception {
        // 파일을 쓰기 위한 FileChannel 생성
        FileChannel channel = new FileOutputStream(fileName).getChannel();
        byte[] byteData = data.getBytes();
        // ByteBuffer에 데이터를 쓴다.
        ByteBuffer buffer = ByteBuffer.wrap(byteData);
        // FileChannel을 통해 데이터를 파일에 쓴다.
        channel.write(buffer);
        channel.close();
    }

    public void readFile(String fileName) throws Exception {
        // Read data from file
        FileChannel channel = new FileInputStream(fileName).getChannel();
        // ByteBuffer에 초기 크기 지정
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        //buffer에 담겨있는 데이터의 가장 앞으로 이동함.
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char)buffer.get());
        }
        channel.close();
    }
}
