package LabWork_3.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingCalendar {
    private final Set<LocalDate> bookedDates;

    public BookingCalendar() {
        this.bookedDates = new HashSet<>();
    }

    public boolean isAvailable(LocalDate start, LocalDate end) {
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            if (bookedDates.contains(date)) {
                return false;
            }
        }
        return true;
    }

    public void bookDates(LocalDate start, LocalDate end) {
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            bookedDates.add(date);
        }
    }

    public List<LocalDate> getBookedDates() {
        return bookedDates.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Booked Dates: " + getBookedDates();
    }
}
