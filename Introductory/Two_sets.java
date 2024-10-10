import java.io.*;
import java.util.*;
// Author : Sulabh Ambule

public class Two_sets {
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
   * 
   * || JAI SHREE RAM ||
   * 
   * 
   */
  private static void Accepted() {
    int n = in.nextInt();
    long sum = (long) n * (n + 1) / 2;
    if (sum % 2 == 1) {
      out.println("NO");
    } else {
      out.println("YES");
      long targetSum = sum / 2;
      List<Integer> set1 = new ArrayList<>();
      List<Integer> set2 = new ArrayList<>();

      for (int i = n; i >= 1; i--) {
        if (targetSum >= i) {
          set1.add(i);
          targetSum -= i;
        } else {
          set2.add(i);
        }
      }

      out.println(set1.size());
      for (int num : set1) {
        out.print(num + " ");
      }
      out.println();

      out.println(set2.size());
      for (int num : set2) {
        out.print(num + " ");
      }
      out.println();
    }
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

  // static class Pair {
  // long first;
  // long second
  // Pair(long f, long s) {
  // this.first = f;
  // this.second = s;
  // }
  // }

  static class Pair implements Comparable<Pair> {
    long first;
    long second;

    Pair(long first, long x) {
      this.first = first;
      this.second = x;
    }

    @Override
    public int compareTo(Pair other) {
      return Long.compare(this.second, other.second);
    }
  }

}