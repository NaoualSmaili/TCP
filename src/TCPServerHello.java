import java.io.IOException;

public class TCPServerHello extends TCPServerBuilder implements Runnable{
    public TCPServerHello() {

    }

    public void run() {
        try {
            this.setSocket();
            System.out.println("TCPServer launched ...");

            while(true) {
                this.s = this.ss.accept();
                System.out.println("Hello, the server accepts");
                this.s.close();
            }
        } catch (IOException e) {
            System.out.println("IOException TCPServerHello");
        }
    }
}
