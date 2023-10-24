package dasz;

import java.util.*;

public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        List<long[]> result = new ArrayList<>();
        long totalSum = 0;
        for (int i = 1; i <= n; i++) {
            totalSum += i;
        }
        long minRange = (totalSum - 2 * n) / n;
        long halfRange = (long) Math.sqrt(totalSum);
        outer:
        for (long i = minRange; i < halfRange; i++) {
            for (long j = halfRange; j < n; j++) {
                if (i * j > totalSum - i - j) continue outer;
                if (i * j == (totalSum - i - j)) {
                    result.add(new long[]{i, j});
                    result.add(new long[]{j, i});
                    continue outer;
                }
                if (((j + 100) * i) < (totalSum - i - j)) j += 100;
            }
        }
        result.sort(Comparator.comparingLong(arr -> arr[0]));
        return result;
    }
}