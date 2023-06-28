# Digital Chief Test Task

## Setup Instructions

### Clone the repository:

1. On GitHub, navigate to the repository.
2. Copy the repository URL.
3. Open your terminal or command prompt.
4. Run the following command to clone the repository to your local machine:
Example: `git clone https://github.com/your-username/your-repo.git`

### Build your application:

1. Navigate to the cloned repository on your local machine.
2. Make sure you have Gradle installed.
3. Run the Gradle build command to build your application:
   Example: `gradle build`

### Run docker compose file

1. Navigate to the cloned repository: Example: `cd your-repo`
2. Deploy the Docker Compose file: Example: `docker-compose up -d`
3. Verify the deployment:
Run the following command to check the running containers: `docker ps`
4. You should see the digital-chief-test-task container listed, indicating that the PostgreSQL container is running.

### Access and test your deployed application:

1. Open a web browser and navigate to the Swagger UI page:
URL: http://localhost:8080/swagger-ui/index.html
2. On the Swagger UI page, you will see a list of available endpoints and API documentation for your application. 
3. Expand the desired endpoint to see the available HTTP methods (GET, POST, PUT, DELETE).

### Test values for Swagger for each REST method

#### POST /api/v1/universities

- Request Body (JSON):
```json
{
 "name": "Example University",
 "location": "City",
 "address": "123 Example Street",
 "foundationYear": "1990-01-01"
}
```

#### GET /api/v1/universities

* No input parameters required.

#### GET /api/v1/universities/{id}

* Path Parameter:
id: 1 (assuming the ID exists in the database)

#### PUT /api/v1/universities/{id}

* Path Parameter:
  id: 1 (assuming the ID exists in the database)
- Request Body (JSON):
```json
{
  "name": "Updated University",
  "location": "USA",
  "address": "456 Updated Street",
  "foundationYear": "1990-01-01"
}
```
#### DELETE /api/v1/universities/{id}
* Path Parameter:
  id: 1 (assuming the ID exists in the database)


** You can use similar test values for the `FacultyController` endpoints as well.
