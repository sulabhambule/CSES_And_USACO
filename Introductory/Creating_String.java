import java.io.*;
import java.util.*;

// Author : Sulabh Ambule
public class Creating_String {

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
    char[] arr = s.toCharArray();

    Set<String> perm = new HashSet<>();
    boolean[] used = new boolean[s.length()];

    generateP(arr, used, new StringBuilder(), perm);
    List<String> sortedPerm = new ArrayList<>(perm);
    Collections.sort(sortedPerm);

    out.println(perm.size());
    for(String p : sortedPerm) {
      out.println(p);
    }

  }

  private static void generateP(char[] arr, boolean[] used, StringBuilder current, Set<String> result) {
    if(current.length() == arr.length) {
      result.add(current.toString());
      return;
    }

    for(int i = 0; i < arr.length; i++) {
      if(!used[i]) {
        used[i] = true;
        current.append(arr[i]);
        generateP(arr, used, current, result);
        current.deleteCharAt(current.length() - 1);
        used[i] = false;
      }
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
