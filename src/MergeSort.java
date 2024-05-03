public class MergeSort {
    static int i;
    static boolean sorted;

    static MonitoredArray arr;


    public static void sort() {
        arr = ArrayPanel.array;
        i = 0;
        sorted = false;
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(MonitoredArray arr, int startIndex, int endIndex)
    {
        try {
            Util.sleepNanos(Constants.SORT_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        if ((endIndex - startIndex) < 2)
        {
            if (arr.get(startIndex) > arr.get(endIndex))
            {
                int temp = arr.get(startIndex);
                arr.set(startIndex, arr.get(endIndex));
                arr.set(endIndex, temp);
            }
            return;
        }

        MergeSort mergeSort = new MergeSort();
        int midPoint = (startIndex + endIndex) / 2;
        mergeSort.sort(arr, startIndex, midPoint);
        mergeSort.sort(arr, midPoint + 1, endIndex);
        int indexA = startIndex;
        int indexB = midPoint + 1;
        int auxIndex = 0;
        int[] auxArray = new int[endIndex + 1 - startIndex];
        while (indexA <= midPoint && indexB <= endIndex)
        {
            if (arr.get(indexA) < arr.get(indexB)) {
                auxArray[auxIndex] = arr.get(indexA);
                indexA++;
            } else
            {
                auxArray[auxIndex] = arr.get(indexB);
                indexB++;
            }
            auxIndex++;
            try {
                Util.sleepNanos(Constants.SORT_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (indexA <= midPoint) while (auxIndex < auxArray.length)
        {
            auxArray[auxIndex] = arr.get(indexA);
            indexA++;
            auxIndex++;
        }
        else while (auxIndex < auxArray.length)
        {
            auxArray[auxIndex] = arr.get(indexB);
            indexB++;
            auxIndex++;
            try {
                Util.sleepNanos(Constants.SORT_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        for (int i = 0; i < auxArray.length; i++)
        {
            arr.set(startIndex + i, auxArray[i]);
            try {
                Util.sleepNanos(Constants.SORT_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        return;
    }
}
