import java.util.*;

public class SimRace {

    private static final int anz_autos = 5;
    private static final int strecke = 250;

    public static void main(String[] args) {

        System.out.println("Rennen starten");

        System.out.println("Cars erstellen");
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < anz_autos; i++) {
            System.out.println("Cars adden");
            cars.add(new Car("Wagen " + i, strecke));
        }
        for (Car car : cars) {
            System.out.println("Cars parallel starten");
            car.start();
        }

        System.out.println("Warten auf das Ende von dem Rennen");
        for (Car car : cars) {
            try {
                car.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Rennen vorbei");
        List<Car> sortedCars = cars.stream()
                .sorted(Comparator.comparing(Car::getZeit).reversed())
                .toList();

        int place = 1;
        System.out.println("**** Endstand ****");
        for (Car car : sortedCars) {
            System.out.println(place + ". Platz: " + car.toString() + " Zeit: " + car.getZeit());
            place++;
        }

    }
}