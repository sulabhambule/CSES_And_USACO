import java.io.*;
import java.util.TreeSet;

public class Sliding_Median {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] input = in.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    String[] arrInput = in.readLine().split(" ");
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(arrInput[i]);
    }

    TreeSet<Integer> low = new TreeSet<>(
        (a, b) -> arr[a] == arr[b] ? a - b : Long.compare(arr[a], arr[b]));
    TreeSet<Integer> high = new TreeSet<>(
        (a, b) -> arr[a] == arr[b] ? a - b : Long.compare(arr[a], arr[b]));

    long[] ans = new long[n - k + 1];

    for (int i = 0; i < n; i++) {
      // Add current element's index to low
      low.add(i);

      // Move the largest in low to high
      high.add(low.pollLast());

      // Balance the sets (low should have one more element if k is odd)
      if (low.size() < high.size()) {
        low.add(high.pollFirst());
      }

      // When the window reaches size k, calculate the median
      if (i >= k - 1) {
        int idx = i - k + 1;
        ans[idx] = arr[low.last()];

        // Remove the element going out of the window
        if (!low.remove(i - k + 1)) {
          high.remove(i - k + 1);
        }
      }
    }

    // Output the results
    for (long num : ans) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
