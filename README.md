# Bus Reservation System

A Java-based console application designed to automate and streamline the day-to-day operations of a public or private bus transportation service. The system replaces manual ticket booking and fleet logging with a structured, object-oriented solution to manage buses, seat availability, passenger bookings, and ticket cancellations.

---

## Group Details & Contributions

| Student ID | Name |
| :--- | :--- |
| PS/2022/325 | T.Gajanan |
| PS/2023/232 | M.R.Rishad |
| PS/2023/400 | M.A.Ahamed |
| PS/2023/277 | T.Vakeeshan |
| PS/2023/021 | R.Ravikumar |

---

## Prerequisites

* **Java Development Kit (JDK):** Version 8 or higher (Java 11, 17, or 21 recommended).
* **Text Editor or IDE:** Any basic text editor, or an Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans.

---

## How to Run Step-by-Step

Since the application is written in standard Java files using a package structure, you can compile and launch it directly from your terminal:

1. **Navigate to your root project directory** (the directory containing the `bus_reservation_system` folder).
2. **Compile all Java classes:**
```bash
   javac bus_reservation_system/*.java
```
## Key Features & OOP Principles

System Features
Menu-Driven Interface: A clean, console-based control center allowing navigation through booking, cancellations, and administration logs.
Admin Authentication Layer: Secures sensitive operational actions, ensuring that only authenticated users can expand the fleet.
Dynamic Seat Allocation & Availability Checking: Validates ticket orders against current capacity limits before modifying a trip's vacancy profile.
Ticket Cancellation Workflow: Allows dynamic removals from active logs, completely restoring the allocated capacity back onto the assigned bus.

## OOP Principles Demonstrated
Inheritance: Implemented across core profiles where specialized subclasses inherit attributes from common roots (e.g., Passenger extending User, and Bus extending Vehicle).
Polymorphism: Displayed through dynamic method overriding, such as distinct implementations of abstract declarations like displayInfo() and display().
Encapsulation: Realized by locking critical member variables using state access flags (private, protected) and restricting direct state mutability through explicit routines.
Abstraction: Achieved via abstract base configurations (User and Vehicle) that enforce essential functional shapes while hiding domain execution details.

## System Architecture
The program environment relies on the interaction of the following classes:

User (Base Class): Abstract definition managing general profile identities.  
Passenger: Inherited profile handling specific passenger contact points.  
Admin: System actor profile containing local verification logic to protect restricted submenus.  
Vehicle (Base Class): Abstract model holding foundational data elements like numbers and capacities.  
Bus: Specialized sub-entity containing custom attributes like travel routes, pricing indexes, and seating state reducers. 
Booking: The transactional connection object pairing a single passenger to their seat reservation details. 
AvailabilityChecker: Dedicated helper class utilizing functional lookups to manage fleet and vacancy state validation.  
MainSystem: App entry terminal holding the runtime menu context loops and console input parsing.

## Current Limitations & Future Scope
Limitations

Operates completely inside a command-line environment without a visual Graphical User Interface (GUI).  
Relies on temporary runtime execution memory (ArrayList); data resets completely every time the app closes.  
Relies on basic text matching for cancellation lookups, which could cause collision conflicts if multiple passengers share identical names.  
Lacks configuration for complex transit variables such as scheduled departures, unique timestamps, or distinct travel dates

Future Enhancements

Integrating database persistence frameworks (like JDBC with MySQL or SQLite) to save records across sessions.  
Developing a visual Graphical User Interface (GUI) or web application frontend.  
Adding a more secure database-driven password authentication platform instead of hardcoded admin credentials.  
Supporting multi-passenger dependencies, unique digital ticket ID generations, and simulated payment workflows.
