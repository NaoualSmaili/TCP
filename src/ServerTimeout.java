import java.io.IOException;
import java.net.Socket;

class ServerTimeout extends TCPClientBuilder implements Runnable {
    private String msIn;

    ServerTimeout(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            s.setSoTimeout(2000);
            setStreamBuffer(this.s.getReceiveBufferSize());
            sInfo("s2", this.s);
            in = s.getInputStream();
            msIn = readMessage(this.in);
            in.close();
            s.close();
        } catch (IOException e) {
            System.out.println("IOException ServerTimeout");
        }
    }
}