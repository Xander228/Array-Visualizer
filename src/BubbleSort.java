public class BubbleSort implements Sort{
    int i;
    boolean sorted;

    BubbleSort(){
        i = 0;
        sorted = false;
    }
    public boolean run(int[] arr){
        if (!(i < arr.length - 1)) {
            i = 0;
            if(sorted) return true;
            sorted = true;
        }
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            sorted = false;
        }
        i++;
        return false;
    }
}
