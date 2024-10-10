import java.io.*;
import java.util.*;

// Author : Sulabh Ambule
public class Palindrome_reorder {

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
    String s = in.next();
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      count[ch - 'A']++;
    }
    int odd = 0;
    for (int i = 0; i < 26; i++) {
      if (count[i] % 2 == 1) {
        odd++;
      }
    }
    if (s.length() % 2 == 0 && odd > 0) {
      System.out.println("NO SOLUTION");
      return;
    }

    if (s.length() % 2 == 1 && odd != 1) {
      System.out.println("NO SOLUTION");
      return;
    }

    int n = s.length();
    char[] arr = new char[n];
    int i = 0;
    int j = n - 1;
    for (int l = 0; l < 26; l++) {
      if (count[l] == 0)
        continue;
      if (count[l] % 2 == 0) {
        while (count[l] > 0) {
          arr[i] = (char) (l + 'A');
          arr[j] = (char) (l + 'A');
          i++;
          j--;
          count[l] -= 2;
        }
      } else {
        while (count[l] > 1) {
          arr[i] = (char) (l + 'A');
          arr[j] = (char) (l + 'A');
          i++;
          j--;
          count[l] -= 2;
        }
        arr[n / 2] = (char) (l + 'A');
      }
    }

    out.println(String.valueOf(arr));
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
