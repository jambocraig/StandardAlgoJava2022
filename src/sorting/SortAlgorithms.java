package sorting;

public class SortAlgorithms {
    public static void bubble(int[] arr) {
        // outer loop iterates n - 1 times
        for (int i = 0; i < arr.length - 1; i++) {
            // no swap detection
            boolean swap = false;
            // inner loop shortens by 1 on each run
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // swap
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            // detect no swap to end method call
            if (!swap) {
                return;
            }
        }
    }


    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pos = i;
            int value = arr[pos];
            while (pos > 0 && value < arr[pos - 1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = value;
        }
    }

    public static void merge(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];
            System.arraycopy(arr, 0, left, 0, left.length);
            System.arraycopy(arr, left.length, right, 0, right.length);
            merge(left);
            merge(right);

            int pos = 0, lPos = 0, rPos = 0;
            while (lPos < left.length && rPos < right.length) {
                if (left[lPos] < right[rPos]) {
                    arr[pos] = left[lPos];
                    lPos++;
                } else {
                    arr[pos] = right[rPos];
                    rPos++;
                }
                pos++;
            }

            while (lPos < left.length) {
                arr[pos] = left[lPos];
                lPos++;
                pos++;
            }

            while (rPos < right.length) {
                arr[pos] = right[rPos];
                rPos++;
                pos++;
            }
        }
    }

    // this method to allow simple initial method call in main program
    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quicksort(arr, start, pIndex - 1);
            quicksort(arr, pIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /* taken from
    Algorithms
    FOURTH EDITION
    Robert Sedgewick and Kevin Wayne */

    /*
    using 5, 1, 9, 4
    lo = 0 hi = 3
    call partition2 (arr, 0 , 3) which
        i = 0
        j = 4
        pivot = 5


     */
    public static void quicksort2(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition2(a, lo, hi);           // Partition (see page 291).
        quicksort2(a, lo, j - 1);            // Sort left part a[lo .. j-1].
        quicksort2(a, j + 1, hi);            // Sort right part a[j+1 .. hi].
    }

    private static int partition2(int[] a, int lo, int hi) {  // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1;            // left and right scan indices
        int pivot = a[lo];            // partitioning item
        while (true) {  // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], pivot)) if (i == hi) break;
            while (less(pivot, a[--j])) if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j); // Put pivot = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi]
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    public static void populate(int[] arr) {
        int num;
        for (int i = 0; i < arr.length; i++) {
            num = (int) (Math.random() * arr.length);
            arr[i] = num;
        }
    }
}



