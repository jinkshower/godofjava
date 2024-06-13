package simplewebwithjava.server;

import java.net.Socket;

public class RequestHandler extends Thread {

    private Socket socket;

    public RequestHandler(final Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        RequestManager requestManager = new RequestManager(socket);
        RequestDTO requestDTO = requestManager.readRequest();

        ResponseManager responseManager = new ResponseManager(socket, requestDTO);
        responseManager.writeResponse();
    }
}
