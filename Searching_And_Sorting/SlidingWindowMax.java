import java.io.*;
import java.util.TreeSet;

public class SlidingWindowMax {
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

        // Two TreeSets to store indices of elements in two halves
        TreeSet<Integer> low = new TreeSet<>(
                (a, b) -> arr[a] == arr[b] ? a - b : Long.compare(arr[a], arr[b]));
        TreeSet<Integer> high = new TreeSet<>(
                (a, b) -> arr[a] == arr[b] ? a - b : Long.compare(arr[a], arr[b]));

        // Sums of the two parts (lowS for the smaller half, highS for the larger half)
        long lowSum = 0;
        long highSum = 0;

        long[] costs = new long[n - k + 1];

        for (int i = 0; i < n; i++) {
            // Add current element's index to low
            low.add(i);
            lowSum += arr[i];

            // Move the largest element in low to high
            int idx = low.pollLast();
            lowSum -= arr[idx];
            high.add(idx);
            highSum += arr[idx];

            // Balance the sets (low should have one more element if k is odd)
            if (low.size() < high.size()) {
                int idx2 = high.pollFirst();
                highSum -= arr[idx2];
                low.add(idx2);
                lowSum += arr[idx2];
            }

            // When the window reaches size k, calculate the cost
            if (i >= k - 1) {
                // Median is the largest element in 'low'
                long median = arr[low.last()];

                // Calculate total cost
                long costLow = median * low.size() - lowSum;
                long costHigh = highSum - median * high.size();
                costs[i - k + 1] = costLow + costHigh;

                // Remove the element going out of the window
                int outIdx = i - k + 1;
                if (!low.remove(outIdx)) {
                    high.remove(outIdx);
                    highSum -= arr[outIdx];
                } else {
                    lowSum -= arr[outIdx];
                }

                // Balance the sets again after removal
                if (low.size() < high.size()) {
                    int idx2 = high.pollFirst();
                    highSum -= arr[idx2];
                    low.add(idx2);
                    lowSum += arr[idx2];
                }
            }
        }

        // Output the results
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (long cost : costs) {
            out.write(cost + " ");
        }
        out.flush();
    }
}
