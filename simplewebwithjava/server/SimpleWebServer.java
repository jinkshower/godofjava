package simplewebwithjava.server;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {

    public static void main(String[] args) {
        SimpleWebServer server = new SimpleWebServer();
        int port = 9000;
        server.run(port);
    }

    public void run(int port) {
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Start Server");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted");

                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();;
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
