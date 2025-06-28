import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Service {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();
    
    void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        try {
            if (roomPricePerNight < 0) {
                throw new IllegalArgumentException("Room price cannot be negative");
            }
            
            Room existingRoom = null;
            for (Room r : rooms) {
                if (r.roomNumber == roomNumber) {
                    existingRoom = r;
                    break;
                }
            }
            
            if (existingRoom != null) {
                existingRoom.roomType = roomType;
                existingRoom.pricePerNight = roomPricePerNight;
            } else {
                rooms.add(new Room(roomNumber, roomType, roomPricePerNight));
            }
        } catch (Exception e) {
            System.out.println("Error setting room: " + e.getMessage());
        }
    }
    
    void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        try {
            if (checkIn == null || checkOut == null) {
                throw new IllegalArgumentException("Check-in and check-out dates cannot be null");
            }
            
            if (checkIn.compareTo(checkOut) >= 0) {
                throw new IllegalArgumentException("Invalid dates: Check-in must be before check-out");
            }

            User user = null;
            for (User u : users) {
                if (u.userId == userId) {
                    user = u;
                    break;
                }
            }
            
            Room room = null;
            for (Room r : rooms) {
                if (r.roomNumber == roomNumber) {
                    room = r;
                    break;
                }
            }
            
            if (user == null) {
                throw new IllegalArgumentException("User with ID " + userId + " not found");
            }
            
            if (room == null) {
                throw new IllegalArgumentException("Room with number " + roomNumber + " not found");
            }
            
            long nights = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);
            if (nights <= 0) {
                throw new IllegalArgumentException("Invalid booking period");
            }
            
            int totalCost = (int)nights * room.pricePerNight;
            
            if (user.balance < totalCost) {
                throw new IllegalArgumentException("Insufficient balance. Required: " + totalCost + ", Available: " + user.balance);
            }
            
            // Check availbility
            for (Booking b : bookings) {
                if (b.roomNumber == roomNumber) {
                    if (!(checkOut.compareTo(b.checkIn) <= 0 || checkIn.compareTo(b.checkOut) >= 0)) {
                        throw new IllegalStateException("Room is not available for the specified period");
                    }
                }
            }
            
            bookings.add(new Booking(userId, roomNumber, checkIn, checkOut, totalCost,
                                   room.roomType, room.pricePerNight, user.balance));
            user.balance -= totalCost;
            System.out.println("Booking successful");
            
        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
    
    void setUser(int userId, int balance) {
        try {
            if (balance < 0) {
                throw new IllegalArgumentException("Balance cannot be negative");
            }
            
            User existingUser = null;
            for (User u : users) {
                if (u.userId == userId) {
                    existingUser = u;
                    break;
                }
            }
            
            if (existingUser != null) {
                existingUser.balance = balance;
            } else {
                users.add(new User(userId, balance));
            }
        } catch (Exception e) {
            System.out.println("Error setting user: " + e.getMessage());
        }
    }
    
    void printAll() {
        try {
            System.out.println("=== ROOMS (Latest to Oldest) ===");
            rooms.sort((r1, r2) -> r2.createdDate.compareTo(r1.createdDate));
            for (Room r : rooms) {
                System.out.println("Room " + r.roomNumber + ", Type: " + r.roomType + ", Price: " + r.pricePerNight);
            }
            
            System.out.println("\n=== BOOKINGS (Latest to Oldest) ===");
            bookings.sort((b1, b2) -> b2.bookingDate.compareTo(b1.bookingDate));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Booking b : bookings) {
                System.out.println("User " + b.userId + ", Room " + b.roomNumber + 
                                 ", CheckIn: " + sdf.format(b.checkIn) + 
                                 ", CheckOut: " + sdf.format(b.checkOut) + 
                                 ", Cost: " + b.totalCost +
                                 ", RoomType: " + b.roomTypeAtBooking +
                                 ", RoomPrice: " + b.roomPriceAtBooking +
                                 ", UserBalance: " + b.userBalanceAtBooking);
            }
        } catch (Exception e) {
            System.out.println("Error printing data: " + e.getMessage());
        }
    }
    
    void printAllUsers() {
        try {
            System.out.println("=== USERS (Latest to Oldest) ===");
            users.sort((u1, u2) -> u2.createdDate.compareTo(u1.createdDate));
            for (User u : users) {
                System.out.println("User " + u.userId + ", Balance: " + u.balance);
            }
        } catch (Exception e) {
            System.out.println("Error printing users: " + e.getMessage());
        }
    }
    
}