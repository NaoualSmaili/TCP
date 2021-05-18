import java.io.IOException;

class TCPClientLMsg extends TCPClientBuilder implements Runnable {
    public TCPClientLMsg() {
    }

    public void run() {
        try {
            this.setSocket();

            this.out = this.s.getOutputStream();
            this.writeMessage(this.out, this.msOut);
            out.flush();
            this.out.close();

            this.s.close();
        } catch (IOException e) {
            System.out.println("Exception TCPClientLMsg");
        }

    }
}