import java.io.IOException;

public class TCPServerFile extends TCPServerBuilder implements Runnable {
    private String msIn;
    public TCPServerFile() {

    }

    public void run() {
        try {
            this.setSocket();
            System.out.println("TCPServerFile launched ...");

            while(true) {
                s = ss.accept();
                s.setSoTimeout(1000);
                setStreamBuffer(s.getReceiveBufferSize());
                System.out.println("ServerFile transfering ...\t" + this.s.getInetAddress().toString() + "\t" + this.s.getPort());
                out = s.getOutputStream();
                transfer(out, "C://Users//user//Desktop//Lamia//TCP//db-small.xml");
                out.close();
                s.close();
                System.out.println("ServerFile transfer done ...\t" + this.s.getInetAddress().toString() + "\t" + this.s.getPort());

            }
        } catch (IOException e) {
            try {
                this.ss.close();
            } catch (IOException exception) {
            }

            System.out.println("Exception TCPServerFile");
        }
    }
}
