package com.pluralsight;

import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[20];
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        while (true) {
            showMenu();
            int choice = scan.nextInt();
            if (choice == 6) {
                break;
            }
            switch (choice) {
                case 1:
                    listAllVehicles(vehicles);
                    break;
                case 2:
                    searchByMakeModel(vehicles);
                    break;
                case 3:
                    searchByPriceRange(vehicles);
                    break;
                case 4:
                    searchByColor(vehicles);
                    break;
                case 5:
                    addVehicle(vehicles);
                    break;
                default:
                    System.out.println("That menu option is not implemented yet. Sorry!");
            }
            System.out.println();
        }
    }

    static void showMenu() {
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by make/model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");
        System.out.println();
        System.out.print("Enter your command: ");
    }

    static void listAllVehicles(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                System.out.println(vehicle);
            }
        }
    }

    static void searchByMakeModel(Vehicle[] vehicles) {
        System.out.print("Enter Make / Model: ");
        String makeModel = readLine();
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                if (vehicle.getMakeModel().toLowerCase().contains(makeModel.toLowerCase())) {
                    System.out.println(vehicle);
                }
            }
        }
    }
    static void searchByPriceRange(Vehicle[] vehicles) {
        System.out.print("Enter Bottom of Price Range: ");
        float bottom = scan.nextFloat();
        System.out.print("Enter Top of Price Range: ");
        float top = scan.nextFloat();
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                if (vehicle.getPrice() >= bottom && vehicle.getPrice() <= top) {
                    System.out.println(vehicle);
                }
            }
        }
    }
    static void searchByColor(Vehicle[] vehicles) {
        System.out.print("Enter Color: ");
        String color = readLine();
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                if (vehicle.getColor().toLowerCase().contains(color.toLowerCase())) {
                    System.out.println(vehicle);
                }
            }
        }
    }

    static void addVehicle(Vehicle[] vehicles) {
        System.out.print("Enter a vehicle ID: ");
        long id = scan.nextLong();
        System.out.print("Enter a make / model: ");
        String makeModel = readLine();
        System.out.print("Enter a color: ");
        String color = readLine();
        System.out.print("Enter an odometer reading: ");
        int odometerReading = scan.nextInt();
        System.out.print("Enter a price: ");
        float price = scan.nextFloat();

        Vehicle newVehicle = new Vehicle(
                id,
                makeModel,
                color,
                odometerReading,
                price
        );

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = newVehicle;
                return;
            }
        }
        System.out.println("Failed to add vehicle. Out of available slots.");
    }

    static String readLine() {
        String line = scan.nextLine();
        if (line.isBlank()) {
            line = scan.nextLine();
        }
        return line;
    }
}
