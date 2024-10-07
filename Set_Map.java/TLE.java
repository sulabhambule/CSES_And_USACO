import java.io.*;
import java.util.*;

public class TLE {
  public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
  static long MOD = (long) (1e9 + 7);
  static FastReader in = new FastReader();

  public static void main(String[] args) throws Exception {
    Accepted();
    out.close();
  }

  private static void Accepted() {
    int n = in.nextInt();
    long m = in.nextLong();

    long[][] arr = new long[n][2]; // To store flavor and spiciness
    for (int i = 0; i < n; i++) {
      arr[i][0] = in.nextLong(); // flavor
      arr[i][1] = in.nextLong(); // spiciness
    }

    // TreeMap to maintain spiciness frequencies
    TreeMap<Long, Integer> spicinessMap = new TreeMap<>();
    long flavorSum = 0;
    long minSpiciness = Long.MAX_VALUE;

    int left = 0;
    for (int right = 0; right < n; right++) {
      flavorSum += arr[right][0];
      spicinessMap.put(arr[right][1], spicinessMap.getOrDefault(arr[right][1], 0) + 1);

      // Shrink the window from the left if flavorSum >= m
      while (flavorSum >= m) {
        minSpiciness = Math.min(minSpiciness, spicinessMap.lastKey());
        // Remove the left element from the window
        flavorSum -= arr[left][0];
        spicinessMap.put(arr[left][1], spicinessMap.get(arr[left][1]) - 1);
        if (spicinessMap.get(arr[left][1]) == 0) {
          spicinessMap.remove(arr[left][1]);  // Remove the spiciness value if its count is zero
        }
        left++;
      }
    }

    // Output the minimum spiciness found
    System.out.println(minSpiciness);
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
