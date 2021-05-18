import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

class TCPClientBuilder extends TCPMessage{
    Socket s;
    InetSocketAddress isA;
    OutputStream out ;
    String msOut = "Aujourd'hui, TP ASR Java." ;

    TCPClientBuilder() {
        s = null;
        isA = null;
    }

    protected void setSocket() throws IOException {
        isA = new InetSocketAddress("localhost", 8083);
        s = new Socket(isA.getHostName(), isA.getPort());
        this.setStreamBuffer(this.s.getReceiveBufferSize());
    }
}