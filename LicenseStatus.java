public enum LicenseStatus {

    /**
     *
     */
    ACTIVE {
        String temp = "Active";

        @Override
        public String toString() {
            return temp;
        }
    },

    /**
     *
     */
    BANNED {
        String temp = "Banned";

        @Override
        public String toString() {
            return temp;
        }
    },

    /**
     *
     */
    EXPIRED {
        String temp = "Expired";

        @Override
        public String toString() {
            return temp;
        }
    },

    /**
     *
     */
    NOLICENSE {
        String temp = "No License";

        @Override
        public String toString() {
            return temp;
        }
    };
}
