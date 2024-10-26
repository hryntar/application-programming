package LabWork_3.services;

import LabWork_3.exceptions.*;
import LabWork_3.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelService {
    private final List<Amenity> hotelAmenities;
    private final List<Cottage> cottages;
    private final List<Reservation> reservations;

    public HotelService() {
        this.hotelAmenities = new ArrayList<>();
        this.cottages = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addHotelAmenity(Amenity amenity) {
        if (amenity.getType() != AmenityType.HOTEL) {
            throw new IllegalArgumentException("Only HOTEL amenities can be added to the hotel.");
        }
        hotelAmenities.add(amenity);
    }

    public void addCottage(Cottage cottage) {
        cottages.add(cottage);
    }

    public void makeReservation(String phoneNumber, Cottage cottage, LocalDate start, LocalDate end)
            throws CottageNotAvailableException, DuplicateReservationException {

        boolean hasExistingReservation = reservations.stream()
                .anyMatch(r -> r.getPhoneNumber().equals(phoneNumber));
        if (hasExistingReservation) {
            throw new DuplicateReservationException("This phone number already has a reservation.");
        }

        if (!cottage.isAvailableForPeriod(start, end)) {
            throw new CottageNotAvailableException("Cottage is not available for the selected dates.");
        }

        reservations.add(new Reservation(phoneNumber, cottage, start, end));
    }

    public List<Cottage> getCottagesByCategory(CottageCategory category) {
        return cottages.stream()
                .filter(cottage -> cottage.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<Cottage> getCottagesByAmenity(Amenity amenity) {
        return cottages.stream()
                .filter(cottage -> cottage.getAmenities().contains(amenity))
                .collect(Collectors.toList());
    }

    public double getTotalIncome() {
        return reservations.stream()
                .mapToDouble(Reservation::getTotalPrice)
                .sum();
    }

    public double getTotalExpenses() {
        double hotelExpenses = hotelAmenities.stream()
                .mapToDouble(Amenity::getPrice)
                .sum();

        double cottageExpenses = cottages.stream()
                .flatMap(cottage -> cottage.getAmenities().stream())
                .mapToDouble(Amenity::getPrice)
                .sum();

        return hotelExpenses + cottageExpenses;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
