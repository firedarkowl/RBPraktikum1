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
        //System.out.println(this.getName()+ " erstellt");
        for (int j = 0; j < rundenZahl; j++) {
            int i = ThreadLocalRandom.current().nextInt(0, 100 +1);
            try {
                zeit = zeit + i;
                sleep(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
//            System.out.println(this.getName()+ " fertig");
//            System.out.println(this.getZeit()+ " Zeit");

            /*for (Map.Entry<String, Integer> entry:plätze.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }*/
            //join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public int getZeit() {
        return zeit;
    }

}
