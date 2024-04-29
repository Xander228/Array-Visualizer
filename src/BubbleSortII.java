public class BubbleSortII {

    static public void run(int[] arr){
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++){
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }
}