package com.example.finalexam;

public class Course {

    private int crn;

    private int seats;
    private int enrolled;

    public int getCrn() {
        return crn;
    }

    public int getSeats() {
        return seats;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }
}
