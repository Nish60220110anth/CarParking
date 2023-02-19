public enum VehicleType {
    CAR {
        String temp = "Car";

        @Override
        public String toString() {
            return temp;
        }

    },
    TRUCK {
        String temp = "Truck";

        @Override
        public String toString() {
            return temp;
        }

    },
    VAN {
        String temp = "Van";

        @Override
        public String toString() {
            return temp;
        }

    },
    MOTORBIKE {
        String temp = "MotorBike";

        @Override
        public String toString() {
            return temp;
        }

    },
    ELECTRIC {
        String temp = "Electic";

        @Override
        public String toString() {
            return temp;
        }
    },
    AMBULANCE {
        @Override
        public String toString() {
            return "Ambulance";
        }
    },
    FIREENGINE {
        @Override
        public String toString() {
            return "Fire Engine";
        }
    };

}
