
import java.io.*;
import java.util.*;

// Author: Sulabh Ambule
public class counting_divisor {
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
    int N = (int) 1e6;
    int[] spf = new int[(int) 1e6 + 1];
    for (int i = 1; i < 1e6 + 1; i++) {
      spf[i] = i;
    }

    for (int i = 2; i * i <= N; i++) {
      if (spf[i] == i) {
        for (int j = i * i; j <= N; j += i) {
          if (spf[j] == j) {
            spf[j] = i;
          }
        }
      }
    }

    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      long x = in.nextLong();

      long ans = fun(x, spf);
      System.out.println(ans);
    }

  }

  private static long fun(long x, int[] spf) {
    long div = 1;
    while (x != 1) {
      int sf = spf[(int) x];
      int count = 0;
      while (x % sf == 0) {
        x /= sf;
        count++;
      }
      div *= (count + 1);
    }

    return div;
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
