package simplewebwithjava.server;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.Socket;

public class RequestManager {
    private static final int BUFFER_SIZE = 2048;

    private Socket socket;

    public RequestManager(final Socket socket) {
        this.socket = socket;
    }

    public RequestDTO readRequest() {
        RequestDTO requestDTO = null;

        try {
            InputStream request = new BufferedInputStream(socket.getInputStream());
            byte[] receivedBytes = new byte[BUFFER_SIZE];
            request.read(receivedBytes);
            String requestData = new String(receivedBytes).trim();
            String[] split = parse(requestData);
            requestDTO = toRequestDTO(split);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return requestDTO;
    }

    private RequestDTO toRequestDTO(final String[] split) {
        String[] tokens = split[0].split(" ");
        String method = tokens[0];
        String uri = tokens[1];
        String version = tokens[2];
        return new RequestDTO(method, uri, version);
    }

    private String[] parse(final String requestData) {
        return requestData.split("\n");
    }
}
