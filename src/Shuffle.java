public class Shuffle {

    public static void run(){
        MonitoredArray array = ArrayPanel.array;

        for(int i = 0; i < (int)Math.pow(array.length, 2); i++) {
            int index1 = (int) (Math.random() * array.length);
            int index2 = (int) (Math.random() * array.length);
            int buffer = array.get(index1); //Copy the value of index1
            array.set(index1, array.get(index2)); //Write index2 to index1
            array.set(index2, buffer); //Write the original value of index1 to index2
            if (ArrayPanel.panelState != Constants.PanelStates.SHUFFLE_PHASE) return;
        }
        ArrayPanel.panelState = Constants.PanelStates.IDLE_PHASE;
    }
}
