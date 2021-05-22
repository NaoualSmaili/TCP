import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServerBuilder extends TCPFile{
    ServerSocket ss ;
    Socket s ;
    InetSocketAddress isA ;
    InputStream in;
    final int timer = 5000;

    TCPServerBuilder() {
        ss = null;
        s = null;
        isA = null;
    }

    protected void setSocket() throws IOException {
        this.isA = new InetSocketAddress("localhost", 8083);
        this.ss = new ServerSocket(this.isA.getPort());
        //this.s.setSoTimeout(timer);
        setStreamBuffer(ss.getReceiveBufferSize());
    }

}
