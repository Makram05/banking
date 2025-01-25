<b>Banking Spring Boot REST API<b><br>
This project is a simple Banking System REST API built using Spring Boot. It provides a set of endpoints to manage user accounts, including functionality to create accounts, retrieve account details, deposit and withdraw money, and delete accounts.

Features:
1.Create an Account: Allows users to create a new account by providing their name and initial balance.<br>
2. Get Account Details by ID: Retrieve the details of a specific account by providing the account ID.<br>
3.Get All Account Details: Fetch a list of all accounts in the system.<br>
4.Deposit Money: Deposit funds into an account, which updates the account balance accordingly.<br>
5.Withdraw Money: Withdraw funds from an account, with balance deduction and sufficient funds check.<br>
6.Delete Account: Delete an account by its ID from the system.<br>

API Endpoints:
POST /accounts: Create a new account.
GET /accounts/{id}: Get account details by account ID.
GET /accounts: Get details of all accounts.
PUT /accounts/deposit/{id}: Deposit money into the account by account ID.
PUT /accounts/withdraw/{id}: Withdraw money from the account by account ID.
DELETE /accounts/{id}: Delete an account by account ID.

Technologies Used:
Spring Boot: For building the REST API.
Java: The programming language.
H2 Database: Used as the in-memory database to store account data (can be replaced with another database).
Spring Data JPA: For ORM and database interactions.
