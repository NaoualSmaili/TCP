import java.io.IOException;

public class TCPServerLMessage extends TCPServerBuilder implements Runnable{
    private String msIn;

    public TCPServerLMessage() {
    }

    public void run() {
        try {
            this.setSocket();
            System.out.println("TCPServerLMessage launched ...");

            while(true){
                this.s = this.ss.accept();
                s.setSoTimeout(1000);
                setStreamBuffer(this.s.getReceiveBufferSize());
                this.in = this.s.getInputStream();
                this.loopReadMessage(this.in);
                this.in.close();
                this.s.close();
            }
        } catch (IOException e) {
            try {
                this.ss.close();
            } catch (IOException exception) {
            }

            System.out.println("Exception TCPServerLMessage");
        }
    }
}
