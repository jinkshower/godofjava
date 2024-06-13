package simplewebwithjava;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        int port = 9000;
        server.start(port);
    }

    private final int BUFFER_SIZE = 2048;

    public void start(int port) {
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Start Server");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted");

                InputStream request = new BufferedInputStream(socket.getInputStream());
                byte[] receivedBytes = new byte[BUFFER_SIZE];
                request.read(receivedBytes);
                String requestData = new String(receivedBytes).trim();
                System.out.println("RequestData=\n" + requestData);
                System.out.println("--------------");

                PrintStream response = new PrintStream(socket.getOutputStream());
                response.println("HTTP/1.1 200 OK");
                response.println("Content-Type: text/html");
                response.println();
                response.print("It is working");
                response.flush();
                response.close();
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
