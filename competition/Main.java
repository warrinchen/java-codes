import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ProbA solver = new ProbA();
        solver.solve(in.nextInt(), in, out);
        out.flush();
        out.close();
    }

    static class ProbA {
        int n, k;
        String s;

        public void solve(int testCases, InputReader in, PrintWriter out) {
            for (int i = 0; i < testCases; ++i) {
                n = in.nextInt();
                k = in.nextInt();
                s = in.next();
                out.println(process(n, k, s));
            }
        }

        private int process(int n, int k, String s) {
            if (n < 2 || k < 1)
                return 1;
            if (isHuiwen(s))
                return 1;
            return 2;
        }

        private boolean isHuiwen(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; ++i) {
                if (s.charAt(i) != s.charAt(len - 1 - i))
                    return false;
            }
            return true;
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}