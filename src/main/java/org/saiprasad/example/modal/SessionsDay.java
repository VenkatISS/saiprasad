package org.saiprasad.example.modal;

public enum SessionsDay {
    MNDAY {
        @Override
        public String toString() {
            return "Monday";
        }
    },
    WDNSDAY {
        @Override
        public String toString() {
            return "Wednesday";
        }
    },
    FDAY {
        @Override
        public String toString() {
            return "Friday";
        }
    },
    SATDAY {
        @Override
        public String toString() {
            return "Saturday";
        }
    }
}
