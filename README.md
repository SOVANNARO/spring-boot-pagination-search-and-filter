# 🌟 Spring Boot Pagination, Search, and Filter

This project demonstrates a Spring Boot application with RESTful API endpoints for managing products, including pagination, search, and filter capabilities. 🚀

## 📁 Project Structure

```json
spring-boot-pagination-search-and-filter/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── tutorials/
│   │   │           ├── config/
│   │   │           │   └── OpenApiConfig.java 🔧
│   │   │           ├── controller/
│   │   │           │   └── ProductController.java 🖥️
│   │   │           ├── dto/
│   │   │           │   └── ProductDTO.java 📝
│   │   │           ├── entity/
│   │   │           │   └── Product.java 📦
│   │   │           ├── mapper/
│   │   │           │   └── ProductMapper.java 🗺️
│   │   │           ├── repository/
│   │   │           │   └── ProductRepository.java 🗃️
│   │   │           ├── response/
│   │   │           │   └── ApiResponse.java 📩
│   │   │           ├── service/
│   │   │           │   ├── ProductService.java 🛠️
│   │   │           │   └── ProductServiceImpl.java 🛠️
│   │   │           └── SpringBootPaginationSearchAndFilterApplication.java 🚀
│   │   └── resources/
│   │       └── application.properties ⚙️
│   └── test/
│       └── java/
│           └── org/
│               └── tutorials/
│                   └── SpringBootPaginationSearchAndFilterApplicationTests.java 🧪
├── pom.xml 📦
├── mvnw 🏗️
└── mvnw.cmd 🏗️
```

## 🌐 API Endpoints

### 📋 Get All Products (with pagination, search, and filter)

```bash
curl --request GET \
  --url 'http://localhost:8080/api/products?page=0&size=10&name=phone&category=Electronics&minPrice=500&maxPrice=1000' \
  --header 'Content-Type: application/json'
```

### 🆕 Create a Product

```json
curl --request POST \
  --url http://localhost:8080/api/products \
  --header 'Content-Type: application/json' \
  --data '{
    "name": "New Smartphone",
    "description": "Latest model smartphone",
    "price": 999.99,
    "category": "Electronics"
}'
```

### 🔍 Get a Product by ID

```json
curl --request GET \
--url http://localhost:8080/api/products/1 \
--header 'Content-Type: application/json'
```

### 🔄 Update a Product

```json
curl --request PUT \
--url http://localhost:8080/api/products/1 \
--header 'Content-Type: application/json' \
--data '{
"name": "Updated Smartphone",
"description": "Latest model smartphone with updates",
"price": 1099.99,
"category": "Electronics"
}'
```

### 🗑️ Delete a Product

```json
curl --request DELETE \
--url http://localhost:8080/api/products/1 \
--header 'Content-Type: application/json'
```

### 📄 Response Format

All API responses follow this format:

```json
{
  "code": "S0001",
  "message": "Success.",
  "data": {
    "rows": [
      {
        "id": 1,
        "name": "Smartphone",
        "description": "Latest model",
        "price": 999.99,
        "category": "Electronics"
      }
    ],
    "page": {
      "pageNumber": 0,
      "pageSize": 10,
      "totalElements": 1,
      "totalPages": 1
    }
  },
  "traceId": "some-uuid-here"
}
```

For error responses, the format is similar, but with an error code and message:

```json
{
  "code": "E0001",
  "message": "Product not found",
  "data": null,
  "traceId": "some-uuid-here"
}
```

## 📚 OpenAPI Documentation

After adding the necessary dependencies, you can access the OpenAPI documentation and Swagger UI through the following URLs:

- OpenAPI JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs) 📋
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) 🖥️