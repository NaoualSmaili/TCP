import java.io.*;

public class TCPFile extends TCPMessage{
    private int count;
    private FileInputStream in;
    private StringBuffer msIn = new StringBuffer();
    private FileOutputStream out;

    TCPFile() {
    }

    void transfer(OutputStream var1, String var2) throws IOException {
        this.in = new FileInputStream(var2);

        do {
            this.count = this.in.read(this.buffer);
            if (this.count > 0) {
                var1.write(this.buffer, 0, this.count);
                var1.flush();
            }
        } while(this.count > 0);

        this.in.close();
    }

    void print(InputStream var1) throws IOException {
        this.count = 0;

        do {
            this.count = var1.read(this.buffer);
            if (this.count > 0) {
                for(int var2 = 0; var2 < this.count; ++var2) {
                    this.msIn.append((char)this.buffer[var2]);
                }

                System.out.println(this.msIn);
                this.msIn.delete(0, this.msIn.length());
            }
        } while(this.count > 0);

    }

    void write(InputStream var1, String var2) throws IOException {
        this.out = new FileOutputStream(var2);
        this.count = 0;

        do {
            this.count = var1.read(this.buffer);
            if (this.count > 0) {
                this.out.write(this.buffer, 0, this.count);
            }
        } while(this.count > 0);

        this.out.close();
    }
}
