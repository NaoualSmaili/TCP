public class Test {
    public Test() {
    }

    public static void Q2(String[] args) {
        new Thread(new TCPServerHello()).start();
        new Thread(new TCPClientHello()).start();
    }

    public static void Q3(String[] args) {
        new Thread(new TCPServerInfo()).start();
        new Thread(new TCPClientInfo()).start();
    }

    public static void Q5(String[] args) {
        new Thread(new TCPServerLMsg()).start();
        new Thread(new TCPClientLMsg()).start();
    }

    public static void main(String[] args) {
        new Thread(new TCPServerTimeout()).start();
        new Thread(new TCPClientTimeout()).start();
    }


}
