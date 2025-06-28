import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        Service service = new Service();
        Calendar cal = Calendar.getInstance();
        
        try {
            
            service.setRoom(1, RoomType.STANDARD, 1000);
            service.setRoom(2, RoomType.JUNIOR, 2000);
            service.setRoom(3, RoomType.SUITE, 3000);
            
            
            service.setUser(1, 5000);
            service.setUser(2, 10000);
            
            
            cal.set(2026, Calendar.JUNE, 30);
            Date d1 = cal.getTime();
            cal.set(2026, Calendar.JULY, 7);
            Date d2 = cal.getTime();
            service.bookRoom(1, 2, d1, d2); 
            
            cal.set(2026, Calendar.JULY, 7);
            Date d3 = cal.getTime();
            cal.set(2026, Calendar.JUNE, 30);
            Date d4 = cal.getTime();
            service.bookRoom(1, 2, d3, d4); 
            
            cal.set(2026, Calendar.JULY, 7);
            Date d5 = cal.getTime();
            cal.set(2026, Calendar.JULY, 8);
            Date d6 = cal.getTime();
            service.bookRoom(1, 1, d5, d6); 
            
            cal.set(2026, Calendar.JULY, 7);
            Date d7 = cal.getTime();
            cal.set(2026, Calendar.JULY, 9);
            Date d8 = cal.getTime();
            service.bookRoom(2, 1, d7, d8); 
            
            cal.set(2026, Calendar.JULY, 7);
            Date d9 = cal.getTime();
            cal.set(2026, Calendar.JULY, 8);
            Date d10 = cal.getTime();
            service.bookRoom(2, 3, d9, d10); 
            // Update room
            service.setRoom(1, RoomType.SUITE, 10000);
            
            // Print results
            service.printAll();
            System.out.println();
            service.printAllUsers();
            
        } catch (Exception e) {
            System.out.println("Application error: " + e.getMessage());
        }
    }
}

