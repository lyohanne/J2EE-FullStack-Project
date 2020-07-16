package com.luv2code.web.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CustomerDbUtil {


private DataSource dataSource;

public CustomerDbUtil(DataSource theDataSource) {
dataSource = theDataSource;
}

public List<Customer> getCustomers(int queryType) throws Exception {

int i = 1;
List<Customer> customers = new ArrayList<>();
Connection myConn = null;
Statement myStmt = null;
ResultSet myRs = null;
try {
// get a connection
myConn = dataSource.getConnection();

// create sql statement
String sql = "select * from customer order by last_name";
String sql2 = "select first_name, last_name FROM customer where first_name= 'Bobby'";
String sql3 = "select * from customer where customer_id = 3";
String sql4 = "select * from customer where last_name like '%Yo%'";
String sql5 = "select * from customer where first_name = 'Anna' or first_name = 'Mimi'";
String sql6 = "select * from customer where first_name in ('Carmen', 'Liya', 'Tanya')";
String sql7 = "select * from customer where first_name !='Alfred'";
String sql8 = "select customer_id, first_name, last_name, CONCAT(first_name, ' ', last_name) as full_name\r\n" +" FROM student ORDER BY id";

myStmt = myConn.createStatement();
switch (queryType) {
case 1:
myRs=myStmt.executeQuery(sql);
break;

case 2:
myRs=myStmt.executeQuery(sql2);
break;

case 3:
myRs=myStmt.executeQuery(sql3);
break;

case 4:
myRs=myStmt.executeQuery(sql4);
break;


case 5:
myRs=myStmt.executeQuery(sql5);
break;

case 6:
myRs=myStmt.executeQuery(sql6);
break;

case 7:
myRs=myStmt.executeQuery(sql7);
break;

case 8:
myRs=myStmt.executeQuery(sql8);
break;



default:
myRs=myStmt.executeQuery(sql);

}
// execute query
// process result set
while (myRs.next()) {

int customerId;
String customerFirstName;;
String customerLastName;
String customerAddress;

switch (queryType) {
case 2:
customerId = 000;
customerFirstName = myRs.getString("first_name");
customerLastName = myRs.getString("last_name");
customerAddress = "Not Retrieved";
break;

case 8:
customerId = myRs.getInt("customer_id");;
customerFirstName = myRs.getString("first_name");
customerLastName = myRs.getString("last_name");
customerAddress = myRs.getString("full_name");
break;

default:
customerId = myRs.getInt("customer_id");
customerFirstName = myRs.getString("first_name");
customerLastName = myRs.getString("last_name");
customerAddress = myRs.getString("address");

}



// create new student object
Customer tempCustomer = new Customer(customerId, customerFirstName, customerLastName, customerAddress);

// add it to the list of students
customers.add(tempCustomer);
}

return customers;
}
finally {


// close JDBC objects
close(myConn, myStmt, myRs);
}
}

public List<Item> getItems() throws Exception {

List<Item> items = new ArrayList<>();

Connection myConn = null;
Statement myStmt = null;
ResultSet myRs = null;

try {
// get a connection
myConn = dataSource.getConnection();

// create sql statement
String sql = "select * from item order by item_code";

myStmt = myConn.createStatement();

// execute query
myRs = myStmt.executeQuery(sql);

// process result set
while (myRs.next()) {

// retrieve data from result set row
int itemId = myRs.getInt("item_id");
String itemCode = myRs.getString("item_code");
String itemDescription = myRs.getString("item_description");

// create new student object
Item tempItem = new Item(itemId, itemCode, itemDescription);

// add it to the list of students
items.add(tempItem);
}

return items;
}
finally {
// close JDBC objects
close(myConn, myStmt, myRs);
}
}

public List<Manufacturer> getManufacturers() throws Exception {

List<Manufacturer> manufacturers = new ArrayList<>();

Connection myConn = null;
Statement myStmt = null;
ResultSet myRs = null;

try {
// get a connection
myConn = dataSource.getConnection();

// create sql statement
String sql = "select * from manufacturer order by manufact_id";

myStmt = myConn.createStatement();

// execute query
myRs = myStmt.executeQuery(sql);

// process result set
while (myRs.next()) {

// retrieve data from result set row
int manufactId = myRs.getInt("manufact_id");
String manufactName = myRs.getString("manufact_name");
String manufactAddress = myRs.getString("manufact_address");

// create new student object
Manufacturer tempManufacturer = new Manufacturer(manufactId, manufactName, manufactAddress);

// add it to the list of students
manufacturers.add(tempManufacturer);
}

return manufacturers;
}
finally {
// close JDBC objects
close(myConn, myStmt, myRs);
}
}
public List<Store> getStores() throws Exception {

List<Store> stores = new ArrayList<>();

Connection myConn = null;
Statement myStmt = null;
ResultSet myRs = null;

try {
// get a connection
myConn = dataSource.getConnection();

// create sql statement
String sql = "select * from store order by store_id";

myStmt = myConn.createStatement();

// execute query
myRs = myStmt.executeQuery(sql);

// process result set
while (myRs.next()) {

// retrieve data from result set row
int storeId = myRs.getInt("store_id");
String storeName = myRs.getString("store_name");
String storeAddress = myRs.getString("store_address");

// create new student object
Store tempStore = new Store(storeId, storeName, storeAddress);

// add it to the list of students
stores.add(tempStore);
}

return stores;
}
finally {
// close JDBC objects
close(myConn, myStmt, myRs);
}
}
public List<Promotion> getPromotions() throws Exception {

List<Promotion> promotions = new ArrayList<>();

Connection myConn = null;
Statement myStmt = null;
ResultSet myRs = null;

try {
// get a connection
myConn = dataSource.getConnection();

// create sql statement
String sql = "select * from promotions order by promotion_id";

myStmt = myConn.createStatement();

// execute query
myRs = myStmt.executeQuery(sql);

// process result set
while (myRs.next()) {

// retrieve data from result set row
int promoId = myRs.getInt("promotion_id");
String promoStart = myRs.getString("promotion_date_start");
String promoEnd = myRs.getString("promotion_date_end");
double promoPercent = myRs.getDouble("promotion_percent");

// create new student object
Promotion tempPromotion = new Promotion(promoId, promoStart, promoEnd, promoPercent);

// add it to the list of students
promotions.add(tempPromotion);
}

return promotions;
}
finally {
// close JDBC objects
close(myConn, myStmt, myRs);
}
}

private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

try {
if (myRs != null) {
myRs.close();
}

if (myStmt != null) {
myStmt.close();
}

if (myConn != null) {
myConn.close();   // doesn't really close it ... just puts back in connection pool
}
}
catch (Exception exc) {
exc.printStackTrace();
}
}



public void addCustomer(Customer theCustomer) throws Exception {

Connection myConn = null;
PreparedStatement myStmt = null;

try {
// get db connection
myConn = dataSource.getConnection();

// create sql for insert
String sql = "insert into customer "
  + "(first_name, last_name, address) "
  + "values (?, ?, ?)";

myStmt = myConn.prepareStatement(sql);

// set the param values for the student
myStmt.setString(1, theCustomer.getCustomerFirstName());
myStmt.setString(2, theCustomer.getCustomerLastName());
myStmt.setString(3, theCustomer.getCustomerAddress());

// execute sql insert
myStmt.execute();
}
finally {
// clean up JDBC objects
close(myConn, myStmt, null);
}
}

public Customer getCustomer(String theCustomerId) throws Exception {

Customer theCustomer = null;

Connection myConn = null;
PreparedStatement myStmt = null;
ResultSet myRs = null;
int customerId;

try {
// convert student id to int
customerId = Integer.parseInt(theCustomerId);

// get connection to database
myConn = dataSource.getConnection();

// create sql to get selected student
String sql = "select * from customer where customer_id=?";

// create prepared statement
myStmt = myConn.prepareStatement(sql);

// set params
myStmt.setInt(1, customerId);

// execute statement
myRs = myStmt.executeQuery();

// retrieve data from result set row
if (myRs.next()) {
String firstName = myRs.getString("first_name");
String lastName = myRs.getString("last_name");
String address = myRs.getString("address");

// use the studentId during construction
theCustomer = new Customer(customerId, firstName, lastName, address);
}
else {
throw new Exception("Could not find customer id: " + customerId);
}

return theCustomer;
}
finally {
// clean up JDBC objects
close(myConn, myStmt, myRs);
}
}

public void updateStudent(Customer theCustomer) throws Exception {

Connection myConn = null;
PreparedStatement myStmt = null;

try {
// get db connection
myConn = dataSource.getConnection();

// create SQL update statement
String sql = "update customer "
+ "set first_name=?, last_name=?, address=? "
+ "where customer_id=?";

// prepare statement
myStmt = myConn.prepareStatement(sql);

// set params
myStmt.setString(1, theCustomer.getCustomerFirstName());
myStmt.setString(2, theCustomer.getCustomerLastName());
myStmt.setString(3, theCustomer.getCustomerAddress());
myStmt.setInt(4, theCustomer.getCustomerId());

// execute SQL statement
myStmt.execute();
}
finally {
// clean up JDBC objects
close(myConn, myStmt, null);
}
}

public void deleteCustomer(String theCustomerId) throws Exception {

Connection myConn = null;
PreparedStatement myStmt = null;

try {
// convert student id to int
int customerId = Integer.parseInt(theCustomerId);

// get connection to database
myConn = dataSource.getConnection();

// create sql to delete student
String sql = "delete from customer where customer_id=?";

// prepare statement
myStmt = myConn.prepareStatement(sql);

// set params
myStmt.setInt(1, customerId);

// execute sql statement
myStmt.execute();
}
finally {
// clean up JDBC code
close(myConn, myStmt, null);
}
}

}
