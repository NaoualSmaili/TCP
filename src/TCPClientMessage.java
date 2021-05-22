import java.io.IOException;

class TCPClientMessage extends TCPClientBuilder implements Runnable {
    private String msIn;
    private String msOut = "Aujourd'hui, TP ASR Java.";

    public TCPClientMessage() {
    }

    public void run() {
        try {
            this.setSocket();
            this.out = this.s.getOutputStream();
            this.writeMessage(this.out, this.msOut);
            this.out.close();
            this.s.close();
        } catch (IOException e) {
            System.out.println("Exception TCPClientMessage");
        }

    }
}