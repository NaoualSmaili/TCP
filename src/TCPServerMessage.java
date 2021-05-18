import java.io.IOException;

class TCPServerLMsg extends TCPServerBuilder implements Runnable {
    private String msIn;

    public TCPServerLMsg() {
    }

    public void run() {
        try {
            this.setSocket();
            System.out.println("TCPServerMessage launched ...");

            while(true) {
                this.s = this.ss.accept();
                this.in = this.s.getInputStream();
                this.msIn = this.readMessage(this.in);
                System.out.println(this.msIn);
                this.in.close();
                this.s.close();
            }
        } catch (IOException e) {
            try {
                this.ss.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("Exception TCPServerLMsg");
        }
    }
}
