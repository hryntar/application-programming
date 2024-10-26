package LabWork_3.models;

public enum Amenity {
    WIFI("WiFi", 10, 0, AmenityType.COTTAGE),
    KITCHEN("Kitchen", 20, 0, AmenityType.COTTAGE),
    BABY_CRIB("Baby Crib", 25, 1, AmenityType.COTTAGE),
    FIREPLACE("Fireplace", 50, 0, AmenityType.COTTAGE),
    TERRACE("Terrace", 30, 0, AmenityType.COTTAGE),

    SPA("SPA", 100, 0, AmenityType.HOTEL),
    PARKING("Parking", 30, 0, AmenityType.HOTEL),
    POOL("Pool", 70, 0, AmenityType.HOTEL),
    GYM("Gym", 50, 0, AmenityType.HOTEL),
    RESTAURANT("Restaurant", 120, 0, AmenityType.HOTEL);

    private final String name;
    private final double price;
    private final int extraGuests;
    private final AmenityType type;

    Amenity(String name, double price, int extraGuests, AmenityType type) {
        this.name = name;
        this.price = price;
        this.extraGuests = extraGuests;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getExtraGuests() {
        return extraGuests;
    }

    public AmenityType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ", +" + extraGuests + " guests)";
    }
}