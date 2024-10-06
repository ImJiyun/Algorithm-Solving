import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        sb.append("Hello World!");
        
        bw.write(sb.toString());
        bw.close();
    }
}
