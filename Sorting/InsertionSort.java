static void insertionSort(int a[]) { // O(n^2) | auxSpace O(1) | stable sort
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && temp < a[j]) { // temp <=, will make it unstable
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

// Worst complexity: n^2
// Average complexity: n^2
// Best complexity: n
// Space complexity: 1
