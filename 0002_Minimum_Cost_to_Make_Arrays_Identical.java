import java.util.*;

class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long initialCost = 0;
        for (int i = 0; i < arr.length; i++) {
            initialCost += Math.abs(arr[i] - brr[i]);
        }

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        int[] sortedBrr = Arrays.copyOf(brr, brr.length);

        Arrays.sort(sortedArr);
        Arrays.sort(sortedBrr);
        boolean isMappingPreserved = true;
        HashMap<Integer, Integer> originalMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            originalMap.put(arr[i], brr[i]);
        }
        for (int i = 0; i < sortedArr.length; i++) {
            if (originalMap.getOrDefault(sortedArr[i], Integer.MIN_VALUE) != sortedBrr[i]) {
                isMappingPreserved = false;
                break;
            }
        }
        long sortedCost = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            sortedCost += Math.abs(sortedArr[i] - sortedBrr[i]);
        }
        if (!isMappingPreserved) {
            sortedCost += k;
        }
        return Math.min(initialCost, sortedCost);
    }
}
