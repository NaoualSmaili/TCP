import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;

public class TCPMessage extends TCPBuffer{
    /**
     * The (simple) text write method.
     */
    void writeMessage(OutputStream out, String msOut) throws IOException {
        if ((out != null) & (msOut != null)) {
            fillChar(msOut);
            out.write(buffer);
            out.flush();
            clearBuffer();
        }
    }

    private void fillChar(String msOut) {
        if (msOut != null)
            if (msOut.length() < buffer.length)
                for (int i = 0; i < msOut.length(); i++)
                    buffer[i] = (byte) msOut.charAt(i);
    }

    void clearBuffer() {
        Arrays.fill(buffer, (byte) 0);
    }

    /**
     * The (simple) text read method.
     */
    String readMessage(InputStream in) throws IOException {
        if (in != null) {
            in.read(buffer);
            count = count();
            if (count > 0)
                return new String(buffer, 0, count);
        }
        return null;
    }

    private int count;

    protected int count() {
        for (int i = 0; i < buffer.length; i++)
            if (buffer[i] == 0)
                return i;
        return buffer.length;
    }

    void loopWriteMessage(OutputStream out, int loop) throws IOException {
        for(int i=0;i<loop;i++) {
            fillAtRandom(buffer);
            out.write(buffer);
            out.flush();
        }
    }
    private void fillAtRandom(byte[] buffer) {
        for(int i=0; i<buffer.length; i++)
            buffer[i] = (byte)r.nextInt(256);
    }
    private Random r = new Random();


    private long n;
    private long scount;
    void loopReadMessage(InputStream in) throws IOException {
        this.n = this.count = 0;
        this.scount = 0L;

        do {
            this.count = in.read(this.buffer);
            if (this.count > 0) {
                this.scount += this.count;
                ++this.n;
            }
        } while(this.count > 0);

        System.out.println("read \t" + this.kb(this.scount) + "\t Kbytes \t" + this.n + "\t loops");
    }
    private double kb(long l) {
        return Math.rint((double)l * 10000.0D / 1024.0D) / 10000.0D;
    }
    private double mb(long l) {
        return Math.rint((double)l * 10000.0D / 1048576.0D) / 10000.0D;
    }
}
