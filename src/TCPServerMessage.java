import java.io.IOException;

class TCPServerMessage extends TCPServerBuilder implements Runnable {
    private String msIn;

    public TCPServerMessage() {
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
        } catch (Exception var4) {
            try {
                this.ss.close();
            } catch (IOException e) {
            }

            System.out.println("Exception TCPServerMessage");
        }
    }
}
