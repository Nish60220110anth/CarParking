public enum ParkingSpotRequired {

    /**
     *
     */
    COMPACT {
        @Override
        public String toString() {
            return "Compact";
        }
    },

    /**
     *
     */
    LARGE {
        @Override
        public String toString() {
            return "Large";
        }
    },

    /**
     *
     */
    HANDICAPPED {
        @Override
        public String toString() {
            return "HandiCap";
        }
    },

    /**
     *
     */
    MOTORBIKE {
        @Override
        public String toString() {
            return "MotorBike";
        }
    },

    /**
     *
     */
    ELECTRIC {
        @Override
        public String toString() {
            return "Electric";
        }
    },

    /**
     *
     */
    AMBULANCE {
        @Override
        public String toString() {
            return "Ambulance";
        }
    },

    /**
     *
     */
    FIREENGINE {
        @Override
        public String toString() {
            return "Fire-Engine";
        }
    };

}
