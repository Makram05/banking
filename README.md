<b>Banking Spring Boot REST API<b><br>
This project is a simple Banking System REST API built using Spring Boot. It provides a set of endpoints to manage user accounts, including functionality to create accounts, retrieve account details, deposit and withdraw money, and delete accounts.

Features:
1.Create an Account: Allows users to create a new account by providing their name and initial balance.<br>
2. Get Account Details by ID: Retrieve the details of a specific account by providing the account ID.<br>
3.Get All Account Details: Fetch a list of all accounts in the system.<br>
4.Deposit Money: Deposit funds into an account, which updates the account balance accordingly.<br>
5.Withdraw Money: Withdraw funds from an account, with balance deduction and sufficient funds check.<br>
6.Delete Account: Delete an account by its ID from the system.<br>

API Endpoints:<br>
POST /accounts: Create a new account.<br>
GET /accounts/{id}: Get account details by account ID.<br>
GET /accounts: Get details of all accounts.<br>
PUT /accounts/deposit/{id}: Deposit money into the account by account ID.<br>
PUT /accounts/withdraw/{id}: Withdraw money from the account by account ID.<br>
DELETE /accounts/{id}: Delete an account by account ID.<br>

Technologies Used:<br>
Spring Boot: For building the REST API.<br>
Java: The programming language.<br>
H2 Database: Used as the in-memory database to store account data (can be replaced with another database).<br>
Spring Data JPA: For ORM and database interactions.<br>
