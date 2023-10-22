myDevOpsProject Guide
This guide provides step-by-step instructions on how to set up and run the myDevOpsProject locally, install its dependencies with Maven, and deploy it on Kubernetes (Minikube).

Project Overview
myDevOpsProject is an example DevOps project consisting of a series of microservices. The project includes two main services: Producer Service and Consumer Service. The Producer Service generates a message and sends it to the Consumer Service via RabbitMQ. The Consumer Service receives and processes this message.

Producer Service
The Producer Service includes the following components:

Spring Boot Application: It produces a message and sends it through RabbitMQ.
Swagger API Documentation: Accessible at http://localhost:8080/swagger-ui.html.
Consumer Service
The Consumer Service includes the following components:

Spring Boot Application: It receives messages from RabbitMQ and processes them.
Swagger API Documentation: Accessible at http://localhost:8081/swagger-ui.html.
Installing Dependencies with Maven
Requirements:

Git
Java JDK 17
Apache Maven
Clone the Project:
Download the project repository to your local machine from GitHub or another hosting platform.

bash
Copy code
git clone https://github.com/yourusername/myDevOpsProject.git
Navigate to the Project Directory:
Using the terminal or command prompt, navigate to the root directory of your project.

bash
Copy code
cd myDevOpsProject
Install Project Dependencies:
Run the following command to download the project's dependencies.

bash
Copy code
mvn clean install
Running on Kubernetes with Minikube
Install Minikube:

Download and install Minikube.
Start Minikube:
Start Minikube by using the following command:

bash
Copy code
minikube start
Deploy Kubernetes Applications:

Navigate to the producer-service and consumer-service directories.
Deploy applications on Kubernetes using the k8s-deployment.yaml file for both services.
bash
Copy code
kubectl apply -f k8s-deployment.yaml
Access Services:

Producer Service: kubectl port-forward svc/producer-service 8080:8080
Consumer Service: kubectl port-forward svc/consumer-service 8081:8081
Swagger Documentation:

Producer Service Swagger Documentation: http://localhost:8080/swagger-ui.html
Consumer Service Swagger Documentation: http://localhost:8081/swagger-ui.html
This guide will help you run the myDevOpsProject locally, install dependencies using Maven, and deploy it to Kubernetes. You can use this guide to set up your project for local development and deployment on Kubernetes.