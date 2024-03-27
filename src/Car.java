import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Thread{

    private int rundenZahl;
    private int zeit = 0;


    public Car(int zahl){
        this.rundenZahl = zahl;
    }

    @Override
    public void run() {
        for (int j = 0; j < rundenZahl; j++) {
            int i = ThreadLocalRandom.current().nextInt(0, 100 +1);
            try {
                zeit = zeit + i;
                sleep(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getZeit() {
        return zeit;
    }

}
