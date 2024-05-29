## Getting Started

This project is an HTTP service providing endpoints for user management.

### Prerequisites

- Java Development Kit (JDK) 17 


## Usage

Use tools like Postman or Curl to test the endpoints:

### GET Request:

```bash
curl http://localhost:8080/user/jsmith
```

### Post Request:

```bash
curl -X POST http://localhost:8080/user -H 'Content-Type: application/json' -d '{"username": "jsmith", "telephone": 12345678, "language": "java", "id": 1}'
```

## Limitations
Currently, the code only supports a single-node environment and does not support horizontal scaling. If horizontal scaling is required, distributed KV storage and a load balancer need to be implemented.

## TODO and Improvements

- **Implement HTTPS for enhanced security:** 

- **Add interceptors for preventing attacks and enforcing security policies:**
 
- **Implement rate limiting to control the number of requests per second (QPS):**

- **Conduct load testing to measure the performance under different levels of concurrent POST and GET requests:**

- **Ensure exactly-once semantics and idempotency for POST requests to maintain data consistency and reliability:**

