static void selectionSort(int a[]) { // O(n^2) | auxSpace O(1) | it requires less copying, in contrast to quick, merge sort..
                                     // not stable
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j])
                    min = j;
            }
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

// Worst complexity: n^2
// Average complexity: n^2
// Best complexity: n^2
// Space complexity: 1
