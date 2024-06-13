package simplewebwithjava.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class ResponseManager {

    private final Socket socket;
    private final RequestDTO requestDTO;

    public ResponseManager(final Socket socket, RequestDTO requestDTO) {
        this.socket = socket;
        this.requestDTO = requestDTO;
    }

    public void writeResponse() {
        String uri = requestDTO.getUri();
        if (uri.equals("/")) {
            writeDefaultResponse();
        } else if (uri.equals("/today")){
            writeTodayResponse();
        }
    }

    private void writeTodayResponse() {
        try {
            PrintStream response = new PrintStream(socket.getOutputStream());
            response.println("HTTP/1.1 200 OK");
            response.println("Content-Type: text/html");
            response.println();
            response.print("Today is" + new Date());
            response.flush();
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeDefaultResponse() {
        try {
            PrintStream response = new PrintStream(socket.getOutputStream());
            response.println("HTTP/1.1 200 OK");
            response.println("Content-Type: text/html");
            response.println();
            response.print("It is working");
            response.flush();
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
