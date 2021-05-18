import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

class TCPBuffer extends TCPInfo {
    protected byte[] buffer;
    private final int size = 8192;

    /**
     * The set method for the buffer.
     */
    void setStreamBuffer(int size) {
        if (size > 0)
            buffer = new byte[size];
        else
            buffer = new byte[this.size];
    }

    byte[] getStreamBuffer() {
        return this.buffer;
    }

}