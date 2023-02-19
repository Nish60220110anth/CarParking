public enum TransactionType {

    /**
     *
     */
    CASH {
        @Override
        public String toString() {
            return "Cash";
        }
    },
    PAYTM {
        @Override
        public String toString() {
            return "PayTM";
        }
    },
    PAYPAL {
        @Override
        public String toString() {
            return "PayPal";
        }
    },
    GOOGLEPAY {
        @Override
        public String toString() {
            return "GooglePay";
        }
    },
    CREDITCARD {
        @Override
        public String toString() {
            return "Credit Card";
        }
    },
    DEBITCARD {
        @Override
        public String toString() {
            return "Debit Card";
        }
    },
    MASTERCARD {
        @Override
        public String toString() {
            return "Master Card";
        }
    };
}
