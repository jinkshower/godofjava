package second.network.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class SocketClientSample {

    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
//        sample.sendSocketSample();
        sample.sendAndReceiveSocketData("I liked java at " + new Date());
    }

    private void sendAndReceiveSocketData(final String data) {
        Socket socket = null;

        try {
            System.out.println("Client:Connecting");
            socket=new Socket("127.0.0.1",9999); // 1)
            System.out.println("Client:Connect status="+socket.isConnected());

            Thread.sleep(1000);

            byte[] readByte=new byte[256];
            InputStream stream=socket.getInputStream();
            BufferedInputStream in=
                new BufferedInputStream(stream);

            in.read(readByte);
            System.out.println("Client:received data="+new String(readByte).trim());
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendSocketSample() {
        for (int i = 0; i < 3; i++) {
            sendSocketData("I liked java at " + new Date());
        }
        sendSocketData("EXIT");
    }

    private void sendSocketData(final String data) {
        Socket socket = null;

        try {
            System.out.println("Client:Connecting");
            socket = new Socket("127.0.0.1", 9999); // 로컬 호스트의 9999포트로 소켓 생성
            System.out.println("Client:Connect status = " + socket.isConnected());

            Thread.sleep(1000);
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);

            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("Client : Sent data");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
