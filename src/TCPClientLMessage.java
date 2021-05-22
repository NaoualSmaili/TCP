import java.io.IOException;

public class TCPClientLMessage extends TCPClientBuilder implements Runnable{
    public TCPClientLMessage() {
    }
    public void run() {
        try {
            this.setSocket();
            System.out.println("TCPClientLMsg launched ...");
            this.out = this.s.getOutputStream();
            this.loopWriteMessage(this.out, 65536);
            out.flush();
            this.out.close();
            this.s.close();
        } catch (IOException e) {
            System.out.println("Exception TCPClientLMessage");
        }

    }
}
