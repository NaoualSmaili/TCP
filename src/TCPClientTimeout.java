import java.io.InputStream;

public class TCPClientTimeout extends TCPClientBuilder implements Runnable {
    private String msIn;
    InputStream in;

    TCPClientTimeout() {
    }

    public void run() {
        try {
            this.setSocket();
            this.sInfo("c1", this.s);
            this.in = this.s.getInputStream();
            this.msIn = this.readMessage(this.in);
            this.in.close();
            this.s.close();
        } catch (Exception var2) {
            System.out.println("Exception TCPClientTimeout");
        }

    }
}
