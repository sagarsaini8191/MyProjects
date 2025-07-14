# 🏨 Hotel Booking Microservices System

This is a **Spring Boot-based Microservices Project** for managing hotel bookings and user ratings, inspired by scalable architectures like those used by hotel and travel platforms.

---

## 📦 Modules (Microservices)

| Service Name      | Description                                      |
|-------------------|--------------------------------------------------|
| **ApiGateway**    | Central entry point using Spring Cloud Gateway   |
| **UserService**   | Manages user profiles and associated data        |
| **HotelService**  | Manages hotel info, details, CRUD operations     |
| **RatingService** | Manages user ratings for hotels                  |
| **ServiceRegistry** | Eureka Server for service discovery            |

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3
- Spring Cloud (Eureka, Gateway)
- REST APIs
- Maven
- MySQL
- Lombok
- MapStruct 
- Swagger 
- IntelliJ IDEA
- Api GateWay
- Feign Client
  

---

## 🔧 Project Architecture

                         +--------------------+
                         |    API Gateway     |
                         +---------+----------+
                                   |
        -----------------------------------------------------
        |                     |                     |        |
+----------------+  +------------------+  +----------------+  +--------------------+
|  User Service  |  |  Hotel Service   |  |  Rating Service|  |  Service Registry  |
+-------+--------+  +--------+---------+  +--------+-------+  +--------------------+
        |                    |                     |
        |                    |                     |
        v                    v                     v
+---------------+   +------------------+   +------------------+
| user_service  |   | hotel_service_db |   | rating_service_db|
|    MySQL DB   |   |     MySQL DB     |   |     MySQL DB     |
+---------------+   +------------------+   +------------------+

