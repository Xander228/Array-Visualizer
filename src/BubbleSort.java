public class BubbleSort {

    public static void sort(){
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
                    Util.sleepNanos(Constants.SORT_SLEEP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

            }
            if (sorted) ArrayPanel.panelState = Constants.PanelStates.IDLE_PHASE;
        }
    }
}