public class Main {
    public static void main(String[] args) {
        CarRent kensejlCarRent = new CarRent();
        kensejlCarRent.addCar("e36");
        kensejlCarRent.addCar("v40");
        kensejlCarRent.addCar("Renault");
        kensejlCarRent.addCar("Ford");

        Driver kuba = new Driver();
        kensejlCarRent.borrow("v40", kuba);
        System.out.println("Kuba has " + kuba.howManyRentedCars() + " rented cars.");
    }
}

class Driver {

    int currentlyBorrowedCars = 0;

    int howManyRentedCars() {
        return currentlyBorrowedCars;
    }

    void carHasBeenRented() {
        currentlyBorrowedCars++;
    }
}

class CarRent {

    int numberOfCars = 0;

    void returnCar(String carToBeReturned) {
        numberOfCars++;
    }

    void borrow(String carToBeBorrow, Driver carForGivenDriver) {
        if (numberOfCars > 0) {
            numberOfCars--;
            carForGivenDriver.carHasBeenRented();
        } else {
            System.out.println("Cannot borrow car : no free cars!");
        }
    }

    int howManyFreeCars() {
        return numberOfCars;
    }

    void addCar(String carToBeAdded) {
        numberOfCars++;
    }

}