public class QuickSort
{

    static int[] arr;
    static public void sort()
    {
        //arr = ArrayPanel.array;
        sort(arr, 0, arr.length - 1);
    }

    static public void sort(int[] arr, int startIndex, int endIndex)
    {

        int pivotIndex = (int)Math.floor(Math.random()*(endIndex + 1 - startIndex) + startIndex);
        int pivot = arr[pivotIndex];

        arr[pivotIndex] = arr[endIndex];
        arr[endIndex] = pivot;

        int indexA = startIndex;
        int indexB = endIndex;

        while (indexA != indexB)
        {
            if (arr[indexA] > pivot){
                indexB--;
                int temp = arr[indexB];
                arr[indexB] = arr[indexA];
                arr[indexA] = temp;
            } else indexA++;
            try {
                Util.sleepNanos(Constants.SORT_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }

        if (indexB - 1 != endIndex)
        {
            int temp = arr[indexB];
            arr[indexB] = arr[endIndex];
            arr[endIndex] = temp;
        }

        if (indexA - startIndex > 1) sort(arr, startIndex, indexA - 1);
        if (endIndex - indexB > 1) sort(arr, indexB + 1, endIndex);
    }
}
