
import java.io.*;
import java.util.*;

// Author: Sulabh Ambule
public class exponentiation2 {
  public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
  static long MOD = (long) (1e9 + 7);
  // static long MOD = 998244353;
  static FastReader in = new FastReader();

  public static void main(String[] args) throws Exception {
    // int cf = in.nextInt();
    // while (cf-- > 0) {
    Accepted();
    // }
    out.flush();
    out.close();
  }
  /*
   * 
   * || जय श्री राम ||
   * 
   */

  private static void Accepted() {
    long n = in.nextLong();
    for (int i = 0; i < n; i++) {
      long a = in.nextLong();
      long b = in.nextLong();
      long c = in.nextLong();

      // Calculate b^c % (MOD - 1) using binPow
      long bd = binPow(b, c, MOD - 1);

      // Calculate a^bd % MOD
      long result = binPow(a, bd, MOD);
      out.println(result);
    }
  }

  static long binPow(long a, long b, long MOD) {
    long result = 1;
    a = a % MOD; // in case 'a' is larger than MOD

    while (b > 0) {
      if ((b & 1) == 1) {
        result = (result * a) % MOD;
      }
      a = (a * a) % MOD;
      b >>= 1;
    }
    return result;
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
