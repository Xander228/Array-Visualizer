public class AlegSort
{

    public static void sort(){
        //sort(ArrayPanel.array);

    }
    public static void sort(int[] arr)
    {
        int N = arr.length;

        //if the array is of length 1, it is already sorted
        if (N < 2) { return; }

        int m = N/2;

        // Split the array into two halves
        int[] l = new int[m];
        int[] r = new int[N-m];

        // Create the left and right arrays
        System.arraycopy(arr, 0, l, 0, m);
        System.arraycopy(arr, m, r, 0, N - m);

        // Sort the left and right arrays via recursion
        // Which leads to the ends of the arrays.
        sort(l);
        sort(r);

        // Merge the left and right arrays
        merge(arr, l, r);

    }

    public static void merge(int[] arr, int[] l, int[] r)
    {
        int i = 0, j = 0, k = 0;

        // i is the index of the left array
        // j is the index of the right array
        // k is the index of the merged array

        while (i < l.length && j < r.length)
        {
            // If the left array is smaller than the right array
            // Add the left array to the merged array
            if (l[i] <= r[j])
            {
                arr[k] = l[i];
                i++;

            }
            // If the right array is smaller than the left array
            //Add the right array to the merged array
            else
            {
                arr[k] = r[j];
                j++;

            }
            k++;
            try {
                Util.sleepNanos(Constants.SORT_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

        }
        // Copy the remaining elements of the left array
        if (i < l.length)
        {
            System.arraycopy(l, i, arr, k, l.length - i);
        }
        // Copy the remaining elements of the right array
        else
        {
            System.arraycopy(r, j, arr, k, r.length - j);
        }
    }
}
