package com.combined.automation.pageObjects.API;

public class BookingBuilder1 {

    // Converted key/value pairs into private fields with assigned default values
    private String firstname = "Sarath";
    private String lastname = "Kumar";
    private int totalprice = 150;
    private boolean depositpaid = true;
    private BookingDates bookingdates = new BookingDates("2025-01-01", "2025-01-07");

    // No-arg constructor (keeps default values)
    public BookingBuilder1() {
    }

    // Constructor that sets only firstname
    public BookingBuilder1(String firstname) {
        this.firstname = firstname;
    }

    // All-args constructor
    public BookingBuilder1(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDates bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }

    // Getters and setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "BookingBuilder{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                '}';
    }

    public static BookingBuilder1 build()
    {
        return new BookingBuilder1();
    }

    // Nested class for booking dates
    public static class BookingDates {
        private String checkin;
        private String checkout;

        public BookingDates() {
        }

        public BookingDates(String checkin, String checkout) {
            this.checkin = checkin;
            this.checkout = checkout;
        }

        public String getCheckin() {
            return checkin;
        }

        public void setCheckin(String checkin) {
            this.checkin = checkin;
        }

        public String getCheckout() {
            return checkout;
        }

        public void setCheckout(String checkout) {
            this.checkout = checkout;
        }

        @Override
        public String toString() {
            return "BookingDates{" +
                    "checkin='" + checkin + '\'' +
                    ", checkout='" + checkout + '\'' +
                    '}';
        }
    }

}
