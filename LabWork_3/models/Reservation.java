package LabWork_3.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Reservation {
    private final String phoneNumber;
    private final Cottage cottage;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Reservation(String phoneNumber, Cottage cottage, LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
        this.phoneNumber = Objects.requireNonNull(phoneNumber, "Phone number cannot be null.");
        this.cottage = Objects.requireNonNull(cottage, "Cottage cannot be null.");
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public long getNumberOfNights() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    public double getTotalPrice() {
        double total = 0;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            total += cottage.getPricePerNight(date);
        }
        return total;
    }

    @Override
    public String toString() {
        return "Reservation for " + phoneNumber +
                " from " + startDate + " to " + endDate +
                " in " + cottage +
                ", Total Price: $" + getTotalPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return phoneNumber.equals(that.phoneNumber) &&
                cottage.equals(that.cottage) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, cottage, startDate, endDate);
    }
}
