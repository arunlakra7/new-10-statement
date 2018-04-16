# new-10-statement

A Restful web service with spring for New10 which is responsible for consuming an XML CAMT transactions file and returning :

1. A summary of net balance, per month. (net balance = (end balance) - (start balance))
2. The number of days in debt (end-of-day balance <0) during the three most recent months.

# How to run the application:

Command line instructions after downloading and unzipping the repository: 

1. cd unzipped_repo
2. mvn spring-boot:run

# How to use the application:

Use Postman or Advanced REST client to perform the rest calls

1. Monthly Net balance

-> Perform a post request to "http://localhost:8080/api/statement/monthly-balance" with your XML CAMT transactions file in body.
-> Will return a list of net balance of months present in the statement with value and which month and year the value belongs to.

2. No of days under debt

-> Perform a post request to "http://localhost:8080/api/statement/days-in-debt" with your XML CAMT transactions file in body.
-> Will return number of days when end of day balance was under zero in last three months.


