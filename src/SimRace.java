import java.util.ArrayList;
import java.util.List;

public class SimRace {

    private static final int autos = 5;
    private static final int runden = 5;
    public static void main(String[] args) {

        for (int i = 0; i < autos; i++) {
            Car car = new Car(runden);
            car.start();
        }
    }
}