TaskApp
A full‑stack task management application with:
✅ Spring Boot backend (Java, MongoDB)
✅ Angular frontend (Material UI)
✅ AI assistance (via OpenAI API)

🚀 Features
Create, view, update, and delete tasks.

***some functionalities are yet to be added (update task, mark as completed, etc, but you get the idea)

Tasks are stored in MongoDB.

Integrated AI assistance to guide you on how to approach each task.

Clean, responsive UI with Angular Material.

🏗️ Project Structure
scss
Copy
Edit
TaskApp
 ├─ backend   (Spring Boot + MongoDB)
 └─ frontend  (Angular + Material Design)
⚙️ Backend Setup (Spring Boot)
1️⃣ Prerequisites
Java 17+

Maven

MongoDB running locally or on your server.

2️⃣ Configuration
Inside backend/src/main/resources/application.properties, update these to your environment:

properties
Copy
Edit
spring.application.name=demo                # Change to your preferred app name
spring.data.mongodb.database=taskmanager    # Change to your MongoDB database name
spring.data.mongodb.host=localhost          # Change to your MongoDB host
spring.data.mongodb.port=27017              # Change to your MongoDB port
If you’re using MongoDB Atlas or a URI, you can instead set:

properties
Copy
Edit
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<yourcluster>/<yourdb>
3️⃣ Collection Name
In backend/src/main/java/com/example/demo/model/Task.java you will see:

java
Copy
Edit
@Document(collection = "tasks")
public class Task {
    // ...
}
👉 Change "tasks" to whatever collection name you want for your MongoDB data.

Example:

java
Copy
Edit
@Document(collection = "my_custom_tasks")
4️⃣ Run the Backend
From the backend folder:

bash
Copy
Edit
./mvnw spring-boot:run
By default, the backend runs on http://localhost:8080.

🎨 Frontend Setup (Angular)
1️⃣ Prerequisites
Node.js and npm installed

Angular CLI installed globally:

bash
Copy
Edit
npm install -g @angular/cli
2️⃣ Install and Run
From the frontend folder:

bash
Copy
Edit
npm install
ng serve
By default, the frontend runs on http://localhost:4200.

🤖 AI Assistance
The backend integrates with OpenAI’s Chat API.
add you api key to this part -  headers.setBearerAuth(""); (in the aiservices class)

✅ Notes
Replace MongoDB configs with your own.

Replace @Document(collection = "tasks") with your own collection name if desired.

Make sure to keep secrets (like API keys) out of your commits.

📌 Tech Stack
Backend: Java 17, Spring Boot 3, MongoDB

Frontend: Angular 17, Angular Material

AI: OpenAI GPT API

