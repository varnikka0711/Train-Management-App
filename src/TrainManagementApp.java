public class TrainManagementApp {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ---- Passenger Bogie ----
    static class PassengerBogie {
        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    // ---- MAIN METHOD ----
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("======================================");

        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + sleeper.getType() + " -> " + sleeper.getCapacity());

            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);
            System.out.println("Created Bogie: " + invalid.getType() + " -> " + invalid.getCapacity());

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("UC14 exception handling completed...");
    }
}