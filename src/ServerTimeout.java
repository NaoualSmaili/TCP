import java.io.IOException;
import java.net.Socket;

class ServerTimeout implements Runnable {
    private Socket s;

    ServerTimeout(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            s.setSoTimeout(2000);
            /** read operation, to do … */

            s.close();
        } catch (IOException e) {
            System.out.println("IOException ServerTimeout");
        }
    }
}