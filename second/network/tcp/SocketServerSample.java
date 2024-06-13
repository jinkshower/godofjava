package second.network.tcp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerSample {

    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
//        sample.startServer();
        sample.startReplyServer();
    }

    private void startReplyServer() {
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(9999);//9999포트로 서버소켓 생성

            while (true) {
                System.out.println("Server : Waiting for request");
                client = server.accept(); // 클라이언트 요청 대기 연결 완료시 client에 소켓 할당
                System.out.println("Server : Accepted");

                OutputStream stream = client.getOutputStream();
                BufferedOutputStream out = new BufferedOutputStream(stream);

                byte[] bytes = "OK".getBytes();
                out.write(bytes);
                out.close();
                stream.close();
                client.close(); //소켓 사용 종료 명시
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void startServer() {
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(9999);//9999포트로 서버소켓 생성

            while (true) {
                System.out.println("Server : Waiting for request");
                client = server.accept(); // 클라이언트 요청 대기 연결 완료시 client에 소켓 할당
                System.out.println("Server : Accepted");

                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));//소켓에서 데이터 받기 위해 bufferedReader사용

                String data = null;
                StringBuilder receivedData = new StringBuilder();

                while ((data = in.readLine()) != null) {
                    receivedData.append(data);
                }
                System.out.println("Received data : " + receivedData);
                in.close();
                stream.close();
                client.close(); //소켓 사용 종료 명시

                if (receivedData != null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("-----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
