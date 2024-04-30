public class Shuffle {

    public static void run(){
        int[] array = ArrayPanel.array;

        for(int i = 0; i < (int)Math.pow(array.length, 2); i++) {
            int index1 = (int) (Math.random() * array.length);
            int index2 = (int) (Math.random() * array.length);
            int buffer = array[index1]; //Copy the value of index1
            array[index1] = array[index2]; //Write index2 to index1
            array[index2] = buffer; //Write the original value of index1 to index2
            if (ArrayPanel.panelState != Constants.PanelStates.SHUFFLE_PHASE) return;
        }
        ArrayPanel.panelState = Constants.PanelStates.IDLE_PHASE;
    }
}
