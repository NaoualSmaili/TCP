import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

class TCPClientBuilder extends TCPFile{
    Socket s;
    InetSocketAddress isA;
    OutputStream out ;
    InputStream in;
    final int timer = 5000;

    TCPClientBuilder() {
        s = null;
        isA = null;
    }

    protected void setSocket() throws IOException {
        isA = new InetSocketAddress("localhost", 8083);
        s = new Socket(isA.getHostName(), isA.getPort());
        //this.s.setSoTimeout(timer);
        this.setStreamBuffer(this.s.getReceiveBufferSize());
    }
}