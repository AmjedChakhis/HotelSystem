# Hotel Reservation System 🏨

A minimalistic hotel reservation management system built in Java and OOP principles that manages hotel rooms, user accounts, and booking operations .


## ✨ Features

### Core Functionality
- **Room Management**: Create, update, and manage hotel rooms with different types (Standard, Junior, Suite)
- **User Management**: Handle user accounts with balance tracking
- **Booking System**: Complete reservation system with date validation and conflict detection
- **Comprehensive Validation**: Input validation with proper exception handling

### Key Capabilities
-  **Room Availability Checking**: Prevents double bookings with date overlap detection
-  **Balance Validation**: Ensures users have sufficient funds before booking
-  **Historical Data Preservation**: Maintains original booking terms even after room updates
-  **Flexible Room Updates**: Modify room properties without affecting existing bookings
-  **Comprehensive Reporting**: View all rooms, bookings, and users sorted by creation date

## 🏗️ System Architecture

The system follows an architecture with three main entities:

```
┌─────────────┐    ┌──────────────┐    ┌─────────────┐
│    Room     │    │     User     │    │   Booking   │
├─────────────┤    ├──────────────┤    ├─────────────┤
│ roomNumber  │    │ userId       │    │ userId      │
│ roomType    │    │ balance      │    │ roomNumber  │
│ pricePerNight│   │ createdDate  │    │ checkIn     │
│ createdDate │    └──────────────┘    │ checkOut    │
└─────────────┘                        │ totalCost   │
                                       │ snapshots   │
                                       └─────────────┘
```

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **Git** for cloning the repository
- **Command line terminal** or **IDE** (IntelliJ IDEA, Eclipse, VS Code)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/AmjedChakhis/HotelSystem
   ```

2. **Navigate to the project directory**
   ```bash
   cd HotelSystem
   ```

## 🏃‍♂️ Running the Application

### Option 1: Command Line Compilation and Execution

1. **Compile the Java files**
   ```bash
   javac *.java
   ```

2. **Run the application**
   ```bash
   java App
   ```

### Option 2: IDE Execution

1. **Import the project** into your preferred IDE
2. **Open** `Service.java`
3. **Run** the main method


## 💡 Usage Examples

### Creating a Room
```java
service.setRoom(101, RoomType.STANDARD, 1500);
// Creates room 101 as Standard type with price 1500 per night
```

### Adding a User
```java
service.setUser(1001, 5000);
// Creates user with ID 1001 and balance 5000
```

### Making a Booking
```java
Calendar cal = Calendar.getInstance();
cal.set(2026, Calendar.AUGUST, 15);
Date checkIn = cal.getTime();
cal.set(2026, Calendar.AUGUST, 18);
Date checkOut = cal.getTime();

service.bookRoom(1001, 101, checkIn, checkOut);
// Books room 101 for user 1001 from Aug 15-18, 2026
```

### Viewing System Data
```java
service.printAll();        // Shows all rooms and bookings
service.printAllUsers();   // Shows all users
```

### Exception Handling
- **IllegalArgumentException**: Invalid input parameters
- **IllegalStateException**: Business rule violations
- **Automatic recovery**: System continues operation after errors

