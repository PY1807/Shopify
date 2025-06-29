# Shopify

A Spring Boot application implementing a basic e‑commerce backend for managing products, categories, images, users, orders, and order items. 

---

## Overview

- **Language & Frameworks:** Java 17, Spring Boot, Spring Data JPA
- **Database:** MySQL
- **Endpoints prefix:** `/api/v1`

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL server (or compatible)
- Git

### Setup & Installation

1. **Clone Repository**
   ```bash
   git clone https://github.com/PY1807/Shopify.git
   cd Shopify

2. Go to src/main/resources/application.properties
    Now,replace the port number,username and password at the required places.
3. Open MySQL Workbench, terminal, or any MySQL client, and run:
    ```bash
    CREATE DATABASE shopify;
4. **Run Application**
   ```bash
   mvn clean install
   mvn spring-boot:run

### Database Tables
 cart,
 cart_item,
 category,
 image,
 order_item,
 orders product,
 user

   
