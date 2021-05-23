import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServerTimeout extends TCPServerBuilder implements Runnable {
    public void run() {
        try {
            ss = new ServerSocket(8083);
            ss.setSoTimeout(timer);
            while (true) {
                s = ss.accept();
                new Thread(new ServerTimeout(s)).start();
            }
        } catch (IOException e) {
            System.out.println("IOException TCPServerTimeout");
        }
    }

    private ServerSocket ss;
    private Socket s;

}