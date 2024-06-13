package simplewebwithjava.server;

public class RequestDTO {
    private String requestMethod;
    private String uri;
    private String httpVersion;

    public RequestDTO(final String requestMethod, final String uri, final String httpVersion) {
        this.requestMethod = requestMethod;
        this.uri = uri;
        this.httpVersion = httpVersion;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getUri() {
        return uri;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}
