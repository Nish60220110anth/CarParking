public enum TypeOfCurrency {
    DOLLAR {
        @Override
        public String toString() {
            return "Dollars";
        }
    },
    YEN {
        @Override
        public String toString() {
            return "Yen";
        }
    },
    POUND {
        @Override
        public String toString() {
            return "Pound";
        }
    },
    EURO {
        @Override
        public String toString() {
            return "Euro";
        }

    },
    RUPEES {
        @Override
        public String toString() {
            return "Rupees";
        }
    };

}
