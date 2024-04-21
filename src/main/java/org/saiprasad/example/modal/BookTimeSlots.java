package org.saiprasad.example.modal;

public enum BookTimeSlots {
    From2PMTo3PM {
        @Override
        public String toString() {
            return "2:00 PM - 3:00 PM";
        }
    },
    From3PMTo4PM {
        @Override
        public String toString() {
            return "3:00 PM - 4:00 PM";
        }
    },
    From4PMTo5PM {
        @Override
        public String toString() {
            return "4:00 PM - 5:00 PM";
        }
    },
    From5PMTo6PM {
        @Override
        public String toString() {
            return "5:00 PM - 6:00 PM";
        }
    },
    From6PMTo7PM {
        @Override
        public String toString() {
            return "6:00 PM - 7:00 PM";
        }
    },
}
