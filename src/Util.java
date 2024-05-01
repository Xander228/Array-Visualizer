public class Util {
    public static void sleepNanos (long nanoDuration) throws InterruptedException {
        final long end = System.nanoTime() + nanoDuration;
        if(Thread.currentThread().isInterrupted()) throw new InterruptedException();
        long timeLeft = nanoDuration;
        do {
            Thread.yield();
            timeLeft = end - System.nanoTime();
        } while (timeLeft > 0);
    }
}
