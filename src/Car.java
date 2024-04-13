import java.util.Random;


public class Car extends Thread{

    private final int rundenZahl;
    private int zeit = 0;
    private final String name;

    public Car(String name, int zahl){
        this.name = name;
        this.rundenZahl = zahl;
    }

    @Override
    public void run() {
        for (int j = 0; j < rundenZahl; j++) {
            int i = new Random().nextInt(100);
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

    @Override
    public String toString() {
        return name;
    }

}
