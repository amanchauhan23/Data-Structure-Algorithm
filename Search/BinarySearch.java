// Iterative Binary Search

int iterativeBS(int a[], int val) { // O(logN) | auxSpace O(1)
        if (a.length == 0)
            return -1;
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // it computes floor
            if (a[mid] == val)
                return mid;
            if (a[mid] < val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }


// Recursive Binary Search

int recursiveBS(int a[], int val, int low, int high) { // O(logN) | auxSpace O(logN) | height is ceil of Log2N
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (a[mid] == val)
            return mid;
        if (a[mid] < val)
            return recursiveBS(a, val, mid + 1, high);
        else
            return recursiveBS(a, val, low, mid - 1);
    }
