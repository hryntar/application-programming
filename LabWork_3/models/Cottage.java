package LabWork_3.models;

import LabWork_3.exceptions.CottageNotAvailableException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cottage {
    private final CottageCategory category;
    private int maxGuests;
    private final double pricePerNight;
    private final List<Amenity> amenities;
    private final BookingCalendar calendar;

    public Cottage(CottageCategory category, int maxGuests, double pricePerNight) {
        this.category = category;
        this.maxGuests = maxGuests;
        this.pricePerNight = pricePerNight;
        this.amenities = new ArrayList<>();
        this.calendar = new BookingCalendar();
    }

    public void addAmenity(Amenity amenity) {
        if (amenity.getType() != AmenityType.COTTAGE) {
            throw new IllegalArgumentException("Only COTTAGE amenities can be added.");
        }
        amenities.add(amenity);
        maxGuests += amenity.getExtraGuests();
    }

    public boolean isAvailableForPeriod(LocalDate start, LocalDate end) {
        return calendar.isAvailable(start, end);
    }

    public void bookForPeriod(LocalDate start, LocalDate end) throws CottageNotAvailableException {
        if (!isAvailableForPeriod(start, end)) {
            throw new CottageNotAvailableException("Cottage is not available for the selected dates.");
        }
        calendar.bookDates(start, end);
    }

    public double getPricePerNight(LocalDate date) {
        if (isLowSeason(date)) {
            return pricePerNight * 0.8;
        }
        return pricePerNight;
    }

    private boolean isLowSeason(LocalDate date) {
        int month = date.getMonthValue();
        return month == 11 || month == 3;
    }

    public CottageCategory getCategory() {
        return category;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    @Override
    public String toString() {
        return category + " Cottage (Max Guests: " + maxGuests +
                ", Price per Night: $" + pricePerNight + ")";
    }
}
