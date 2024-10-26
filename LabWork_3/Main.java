package LabWork_3;

import LabWork_3.models.*;
import LabWork_3.exceptions.*;
import LabWork_3.services.HotelService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();

        System.out.println("Adding hotel amenities...");
        hotelService.addHotelAmenity(Amenity.SPA);
        hotelService.addHotelAmenity(Amenity.PARKING);
        hotelService.addHotelAmenity(Amenity.POOL);
        hotelService.addHotelAmenity(Amenity.GYM);

        System.out.println("Creating cottages...");
        Cottage standardCottage = new Cottage(CottageCategory.STANDARD, 2, 150);
        Cottage luxuryCottage = new Cottage(CottageCategory.LUXURY, 4, 300);
        Cottage familyCottage = new Cottage(CottageCategory.FAMILY, 6, 250);

        System.out.println("Adding amenities to cottages...");
        standardCottage.addAmenity(Amenity.WIFI);
        standardCottage.addAmenity(Amenity.BABY_CRIB);

        luxuryCottage.addAmenity(Amenity.FIREPLACE);
        luxuryCottage.addAmenity(Amenity.KITCHEN);

        familyCottage.addAmenity(Amenity.WIFI);
        familyCottage.addAmenity(Amenity.TERRACE);

        hotelService.addCottage(standardCottage);
        hotelService.addCottage(luxuryCottage);
        hotelService.addCottage(familyCottage);

        System.out.println("\nCottages in the LUXURY category:");
        List<Cottage> luxuryCottages = hotelService.getCottagesByCategory(CottageCategory.LUXURY);
        luxuryCottages.forEach(System.out::println);

        try {
            System.out.println("\nCreating reservations...");
            hotelService.makeReservation(
                    "+380123456789",
                    standardCottage,
                    LocalDate.of(2024, Month.NOVEMBER, 1),
                    LocalDate.of(2024, Month.NOVEMBER, 5)
            );
            System.out.println("Reservation for standard cottage successful!");

            hotelService.makeReservation(
                    "+380987654321",
                    luxuryCottage,
                    LocalDate.of(2024, Month.DECEMBER, 1),
                    LocalDate.of(2024, Month.DECEMBER, 3)
            );
            System.out.println("Reservation for luxury cottage successful!");

            hotelService.makeReservation(
                    "+380123456789",
                    familyCottage,
                    LocalDate.of(2024, Month.NOVEMBER, 6),
                    LocalDate.of(2024, Month.NOVEMBER, 8)
            );
        } catch (CottageNotAvailableException | DuplicateReservationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAll reservations:");
        hotelService.getReservations().forEach(System.out::println);

        System.out.println("\nTotal Income: $" + hotelService.getTotalIncome());

        System.out.println("Total Expenses: $" + hotelService.getTotalExpenses());

        boolean isAvailable = standardCottage.isAvailableForPeriod(
                LocalDate.of(2024, Month.NOVEMBER, 10),
                LocalDate.of(2024, Month.NOVEMBER, 15)
        );
        System.out.println("\nIs standard cottage available from Nov 10 to Nov 15? " + isAvailable);
    }
}

