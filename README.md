# Bank Console Application

- This is a simple banking application that allows users to perform basic banking transactions such as withdrawals, deposits, and transfers.
- It uses `Java RMI (Remote Method Invocation)` to enable communication between client and server components.

## Structure

The application consists of the following classes:

- **CompteBancaire:** Represents a bank account, containing information such as the account owner, account number, code secret, and balance.
- **CompteBancaireInterface:** Defines the remote methods that can be invoked on a CompteBancaire object.
- **Client:** The client-side application that allows users to interact with the bank accounts.
- **Server:** The server-side application that creates and manages the bank accounts.

## Usage

1. Compile all the Java classes using the following command:

   ```java
   javac *.java

2. Start the server by running the Server class:

    ```java
    java serveur.Server

3. Start the client by running the Client class:

    ```java
    java serveur.Client
   
4. Follow the prompts in the client application to perform banking operations.
  
## Additional Information
The code is written in Java and uses the [RMI](https://docs.oracle.com/javase/7/docs/technotes/guides/rmi/hello/hello-world.html) framework for remote communication.
The project is structured into a single package named `serveur`.
The code could be further improved by adding comments and refactoring for better readability and maintainability.

## Author
[Wissem Grari](https://github.com/wissemgrari)
