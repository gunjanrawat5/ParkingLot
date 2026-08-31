# Parking Lot Management System

A Java-based **Low-Level Design (LLD)** implementation of a parking lot management system.

The project models the core workflows of a multi-floor parking facility, including parking spot management, vehicle entry, ticket generation, spot assignment, billing, and vehicle exit. It is structured using separate **controller, service, repository, and model layers** to keep business logic modular and maintainable.

## Features

* Multi-floor parking lot initialization
* Configurable number of parking spots per floor
* Entry and exit gates with assigned operators
* Vehicle registration and lookup
* Parking ticket generation
* Automatic parking spot assignment
* Parking spot availability tracking
* Parking lot capacity tracking
* Bill generation
* Pluggable spot-assignment strategies
* Pluggable bill-calculation strategies
* Repository abstraction for storing and retrieving domain entities

## System Design

The application follows a layered architecture:

```text
Controller
    |
    v
Service
    |
    v
Repository
    |
    v
Domain Models
```

### Controller Layer

Acts as the entry point for parking lot operations and delegates business logic to the appropriate services.

Examples:

* `ParkingLotController`
* `TicketController`
* `BillController`

### Service Layer

Contains the core business logic of the application.

Examples:

* `ParkingLotService`
* `TicketService`
* `BillService`
* `VehicleService`

### Repository Layer

Provides an abstraction for storing and retrieving application entities such as parking lots, vehicles, tickets, spots, floors, and gates.

### Model Layer

Represents the primary entities in the parking lot domain.

Key models include:

```text
ParkingLot
ParkingFloor
ParkingSpot
ParkingGate
ParkingTicket
Vehicle
Operator
Bill
Payment
```

## Design Patterns

### Strategy Pattern

The project uses the **Strategy Pattern** for logic that may require multiple implementations.

#### Parking Spot Assignment

```text
SpotAssignmentStrategy
        |
        +-- LinearSpotAssignmentStrategy
```

`TicketService` obtains a parking spot assignment strategy through `SpotAssignmentStrategyFactory` and uses it to find an appropriate spot for a vehicle.

This allows new assignment algorithms to be introduced without changing the ticket-generation workflow.

Possible future strategies could include:

* Nearest available spot
* Cheapest parking tier
* Vehicle-type-specific allocation
* Load balancing across floors

#### Bill Calculation

```text
BillCalculationStrategy
        |
        +-- LinearBillCalculationStrategy
```

Billing logic is similarly separated using `BillCalculationStrategy` and `BillCalculationStrategyFactory`.

Additional pricing strategies could therefore be added independently, such as:

* Hourly pricing
* Weekend pricing
* Surge pricing
* Vehicle-specific pricing
* Parking-tier-based pricing

## Parking Flow

A typical vehicle entry flow is:

```text
Vehicle arrives
      |
      v
Check whether vehicle exists
      |
      v
Find available parking spot
      |
      v
Generate parking ticket
      |
      v
Mark parking spot as TAKEN
      |
      v
Decrease available parking capacity
```

When a ticket is generated, the system records information such as the vehicle, assigned parking spot, entry gate, operator, and entry time.

## Parking Lot Initialization

The parking lot can be initialized with a configurable number of:

* Floors
* Parking spots per floor

During initialization, the application creates entry and exit gates, parking floors, and parking spots.

The total capacity is calculated as:

```text
Total Capacity = Number of Floors × Spots Per Floor
```

Each newly created parking spot starts with an `AVAILABLE` status.

## Parking Spot Status

Parking spots can represent different availability states.

For example:

```text
AVAILABLE
TAKEN
```

When a ticket is issued:

```text
AVAILABLE -> TAKEN
```

The parking lot's available-slot count is updated accordingly.

## Project Structure

```text
ParkingLot/
│
└── src/
    │
    ├── controller/
    │   ├── BillController.java
    │   ├── ParkingLotController.java
    │   └── TicketController.java
    │
    ├── exception/
    │
    ├── model/
    │   ├── constants/
    │   ├── Bill.java
    │   ├── Operator.java
    │   ├── ParkingFloor.java
    │   ├── ParkingGate.java
    │   ├── ParkingLot.java
    │   ├── ParkingSpot.java
    │   ├── ParkingTicket.java
    │   ├── Payment.java
    │   └── Vehicle.java
    │
    ├── repository/
    │
    ├── service/
    │   ├── strategy/
    │   │   ├── BillCalculationStrategy.java
    │   │   ├── BillCalculationStrategyFactory.java
    │   │   ├── LinearBillCalculationStrategy.java
    │   │   ├── LinearSpotAssignmentStrategy.java
    │   │   ├── SpotAssignmentStrategy.java
    │   │   └── SpotAssignmentStrategyFactory.java
    │   │
    │   ├── BillService.java
    │   ├── ParkingLotService.java
    │   ├── TicketService.java
    │   └── VehicleService.java
    │
    └── Main.java
```

## Technologies

* **Java**
* Object-Oriented Programming
* Low-Level System Design
* Repository Pattern
* Strategy Pattern
* Factory Pattern

## Running the Project

Clone the repository:

```bash
git clone https://github.com/gunjanrawat5/ParkingLot.git
```

Navigate into the project:

```bash
cd ParkingLot
```

Compile the Java source:

```bash
javac -d out $(find src -name "*.java")
```

Run the application:

```bash
java -cp out Main
```

Alternatively, the project can be opened and executed directly using an IDE such as IntelliJ IDEA.

## Design Goals

This project focuses primarily on demonstrating:

* Object-oriented design
* Separation of concerns
* Extensible business logic
* Domain modeling
* Design patterns
* Clean service and repository boundaries

Rather than tightly coupling spot assignment or billing rules to the main parking workflow, those behaviors are abstracted behind strategies so the system can evolve as requirements change.

## Future Improvements

Potential extensions include:

* Support for multiple vehicle types and compatible parking spots
* Multiple parking spot tiers
* Dynamic pricing strategies
* Payment processing
* Persistent database storage
* REST APIs using Spring Boot
* Concurrent vehicle entry and exit handling
* Reservation support
* Automated unit and integration tests
* Multiple parking lots
* Admin dashboards and real-time occupancy monitoring

## Author

**Gunjan Rawat**

GitHub: [gunjanrawat5](https://github.com/gunjanrawat5)
