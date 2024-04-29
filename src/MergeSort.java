public class MergeSort {
    int i;
    boolean sorted;

    MergeSort(){
        i = 0;
        sorted = false;
    }
    public boolean run(int[] arr){

        return false;
    }

    public void sort(int[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int startIndex, int endIndex)
    {
        if ((endIndex - startIndex) < 2)
        {
            if (arr[startIndex] > arr[endIndex])
            {
                int temp = arr[startIndex];
                arr[startIndex] = arr[endIndex];
                arr[endIndex] = temp;
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
            if (arr[indexA] < arr[indexB]) {
                auxArray[auxIndex] = arr[indexA];
                indexA++;
            } else
            {
                auxArray[auxIndex] = arr[indexB];
                indexB++;
            }
            auxIndex++;
        }
        if (indexA <= midPoint) while (auxIndex < auxArray.length)
        {
            auxArray[auxIndex] = arr[indexA];
            indexA++;
            auxIndex++;
        }
        else while (auxIndex < auxArray.length)
        {
            auxArray[auxIndex] = arr[indexB];
            indexB++;
            auxIndex++;
        }
        for (int i = 0; i < auxArray.length; i++)
        {
            arr[startIndex + i] = auxArray[i];
        }
        return;
    }
}
