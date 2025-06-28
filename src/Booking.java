import java.util.Date;

class Booking {
    int userId;
    int roomNumber;
    Date checkIn;
    Date checkOut;
    int totalCost;
    Date bookingDate;
    RoomType roomTypeAtBooking;
    int roomPriceAtBooking;
    int userBalanceAtBooking;
    
    Booking(int userId, int roomNumber, Date checkIn, Date checkOut, 
            int totalCost, RoomType roomType, int roomPrice, int userBalance) {
        this.userId = userId;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalCost = totalCost;
        this.bookingDate = new Date();
        this.roomTypeAtBooking = roomType;
        this.roomPriceAtBooking = roomPrice;
        this.userBalanceAtBooking = userBalance;
    }
}