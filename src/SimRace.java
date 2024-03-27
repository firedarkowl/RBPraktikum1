import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimRace {

    private static final int autos = 5;
    private static final int runden = 5;

    private static Map<String, Integer> plätze = new HashMap<>();
    public static void main(String[] args) {

        for (int i = 0; i < autos; i++) {
            Car car = new Car(runden);
            car.start();
            try {
                car.join();
                plätze.put(car.getName(), car.getZeit());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        /*plätze.forEach((k, v) -> {
            System.out.println(k +" "+ v);
        });*/

        List<Map.Entry<String, Integer>> tmp = plätze.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();
        tmp.forEach(e -> System.out.println(e));
    }
}