import java.lang.reflect.Array;

public class MonitoredArray {

    public final int length;
    private final int[] array;
    private boolean[] wasRead;
    private boolean[] wasWritten;
    MonitoredArray(int arraySize){
        this.length = arraySize;
        array = new int[arraySize];
        wasRead = new boolean[arraySize];
        wasWritten = new boolean[arraySize];
    }

    public void set(int index, int value){
        wasWritten[index] = true;
        array[index] = value;
    }

    public void setSilently(int index, int value){
        array[index] = value;
    }

    public int get(int index){
        wasRead[index] = true;
        return array[index];
    }

    public int getSilently(int index){
        return array[index];
    }

    public boolean[] getWasRead() {
        boolean[] currentWasRead = wasRead;
        wasRead = new boolean[length];
        return currentWasRead;
    }

    public boolean[] getWasWritten() {
        boolean[] currentWasWritten = wasWritten;
        wasWritten = new boolean[length];
        return currentWasWritten;
    }
}
