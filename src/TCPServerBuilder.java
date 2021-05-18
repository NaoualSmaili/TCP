import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServerBuilder{
    ServerSocket ss ;
    Socket s ;
    InetSocketAddress isA ;



    TCPServerBuilder() {
        ss = null;
        s = null;
        isA = null;
    }

    protected void setSocket() throws IOException {
        this.isA = new InetSocketAddress("localhost", 8083);
        this.ss = new ServerSocket(this.isA.getPort());
    }

}
