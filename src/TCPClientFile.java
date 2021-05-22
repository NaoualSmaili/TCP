import java.io.IOException;

public class TCPClientFile extends TCPClientBuilder implements Runnable{

    public TCPClientFile() {

    }

    public void run() {
        try {
            this.setSocket();
            System.out.println("TCPClientFile launched ...");
            this.in = this.s.getInputStream();
            this.write(this.in, "C:\\Users\\user\\Desktop\\Lamia\\TCP\\db-small.xml");
            System.out.println("TCPClientFile file received ...");
            this.in.close();
            this.s.close();
        } catch (IOException e) {
            System.out.println("Exception TCPClientFile");
        }

    }
}
