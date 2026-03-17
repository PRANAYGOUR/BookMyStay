
import java.util.*;
class Service {

    private String serviceName;
    private double cost;

    public Service(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}
class AddOnServiceManager {

    private Map<String, List<Service>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {

        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {

        List<Service> services = servicesByReservation.get(reservationId);

        if (services == null) {
            return 0.0;
        }

        double total = 0;

        for (Service s : services) {
            total += s.getCost();
        }

        return total;
=======
/*
 @version 2.1
 */

abstract class Room {


    protected int numberOfBeds;


    protected int squareFeet;

    protected double pricePerNight;


    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }


    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}




class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
>>>>>>> 1d8606467f59575d980d7c76c59fef1ef35561fd
    }
}

public class BookMyStay {

    public static void main(String[] args) {


        System.out.println("Add-On Service Selection");

        String reservationId = "Single-1";

        AddOnServiceManager manager = new AddOnServiceManager();
        manager.addService(reservationId, new Service("Breakfast", 500));
        manager.addService(reservationId, new Service("Spa", 1000));

        double totalCost = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);

        System.out.println("Hotel Room Initialization\n");

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);

    }
}