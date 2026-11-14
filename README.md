# Car Rental Backend
Backend API for a Car Rental system build with Jave $ Spring Boot.
Users can browse cars, book cars, and admins can manage the fleet.


## Tech Stack
- Jave 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 / MySQL
- Maven

## Entities
- **Car**: brand, model, year, fuelType, transmission, pricePerDay, available
- **User**: firstName, lastName, email, password, phone, role (USER / ADMIN)
- **Booking**: user, car, startDate, endDate, totalCost, status

## Relationships
- User -> Booking: one-to-Many
- Car → Booking: One-to-Many
- Booking → User / Car: Many-to-One

## How to Run
```bash
./mvnw spring-boot:run

## Author
Sekou S Seh
GitHub: https//git.com.sehsekou98