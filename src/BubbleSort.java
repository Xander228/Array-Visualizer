public class BubbleSort {

    public static void sort(){
        MonitoredArray arr = ArrayPanel.array;
        boolean sorted = false;
        while (ArrayPanel.panelState == Constants.PanelStates.SORT_PHASE)
        {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++){
                if (arr.get(i) > arr.get(i + 1)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1,temp);
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