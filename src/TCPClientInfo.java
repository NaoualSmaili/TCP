import java.io.IOException;

class TCPClientInfo extends TCPClientBuilder implements Runnable{
    TCPClientInfo() {
    }

    public void run() {
        try {
            this.setSocket();
            this.sInfo("The client following the socket acceptance", this.s);
            this.s.close();
            this.sInfo("The client closes the socket", this.s);
        } catch (IOException e) {
            System.out.println("Exception TCPClientInfo");
        }

    }
}
