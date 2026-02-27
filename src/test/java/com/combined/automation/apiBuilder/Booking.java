package com.combined.automation.apiBuilder;

import com.combined.automation.pageObjects.API.BookingBuilder1;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Booking {
//    private String firstname = "Sarath";
//    private String lastname = "Kumar";
//    private int totalprice = 150;
//    private boolean depositpaid = true;
//    private String checkin = "2025-01-01";
//    private String checkin = "2025-01-07";
//    private Booking(){};
    @JsonProperty("firstname")
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String checkin;
    private String checkout ;
    @JsonProperty("bookingdates")
    private Map<String, String> bookingdates;
    public Booking(){}

    public static class BookingBuilder{

    private String firstname = "Sarath";
    private String lastname = "Kumar";
    private int totalprice = 150;
    private boolean depositpaid = true;
    private String checkin = "2025-01-01";
    private String checkout = "2025-01-07";

    public BookingBuilder(){}

        public BookingBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public BookingBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public BookingBuilder setTotalprice(int totalprice) {
            this.totalprice = totalprice;
            return this;
        }

        public BookingBuilder setDepositpaid(boolean depositpaid) {
            this.depositpaid = depositpaid;
            return this;
        }

        public BookingBuilder setCheckin(String checkin) {
            this.checkin = checkin;
            return this;
        }

        public BookingBuilder checkout(String checkout) {
            this.checkout = checkout;
            return this;
        }

        public Booking build()
        {
            Booking b=new Booking();
            b.firstname=this.firstname;
            System.out.println(firstname);
            b.lastname      = this.lastname;
            b.totalprice    = this.totalprice;
            b.depositpaid   = this.depositpaid;
            Map<String, String> dates = new HashMap<>();
            dates.put("checkin",  this.checkin);
            dates.put("checkout", this.checkout);
            b.bookingdates=dates;
            System.out.println(b.lastname );
            System.out.println("the object value is+ "+b);
        return b;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

//    public String getCheckin() {
//        return checkin;
//    }
//
//    public String getCheckout() {
//        return checkout;
//    }

    public Map<String, String> getBookingDates() {
        return bookingdates;
    }
}
