public class BubbleSortII {

    public static void run(){
        int[] arr = ArrayPanel.array;
        boolean sorted = false;
        while (ArrayPanel.panelState == Constants.PanelStates.SORT_PHASE)
        {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++){
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
                if (ArrayPanel.panelState != Constants.PanelStates.SORT_PHASE) return;
                try {
                    Thread.sleep(1);
                }
                catch (Exception e) {
                }
            }
            if (sorted) ArrayPanel.panelState = Constants.PanelStates.IDLE_PHASE;
        }
    }
}