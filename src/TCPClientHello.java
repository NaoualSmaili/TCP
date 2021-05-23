import java.io.IOException;

class TCPClientHello extends TCPClientBuilder implements Runnable {
    public TCPClientHello() {
    }

    public void run() {
        try {
            System.out.println("TCPClientHello launched ...");
            setSocket();
            System.out.println("Hello, the client is connected");
            s.close();
        }
        catch(IOException e)
        { System.out.println("IOException TCPClientHello"); }
    }
}