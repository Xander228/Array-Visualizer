public class QuickSort
{

    static MonitoredArray arr;
    static public void sort()
    {
        arr = ArrayPanel.array;
        sort(arr, 0, arr.length - 1);
    }

    static public void sort(MonitoredArray arr, int startIndex, int endIndex)
    {

        int pivotIndex = (int)Math.floor(Math.random()*(endIndex + 1 - startIndex) + startIndex);
        int pivot = arr.get(pivotIndex);

        arr.set(pivotIndex, arr.get(endIndex));
        arr.set(endIndex, pivot);

        int indexA = startIndex;
        int indexB = endIndex;

        while (indexA != indexB)
        {
            if (arr.get(indexA) > pivot){
                indexB--;
                int temp = arr.get(indexB);
                arr.set(indexB, arr.get(indexA));
                arr.set(indexA, temp);
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
            int temp = arr.get(indexB);
            arr.set(indexB, arr.get(endIndex));
            arr.set(endIndex, temp);
        }

        if (indexA - startIndex > 1) sort(arr, startIndex, indexA - 1);
        if (endIndex - indexB > 1) sort(arr, indexB + 1, endIndex);
    }
}
