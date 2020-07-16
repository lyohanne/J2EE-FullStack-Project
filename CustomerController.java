package com.luv2code.web.customer;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
int queryChoice;
private static final long serialVersionUID = 1L;

private CustomerDbUtil customerDbUtil;

@Resource(name="jdbc/web_student_tracker")
private DataSource dataSource;

@Override
public void init() throws ServletException {
super.init();

// create our student db util ... and pass in the conn pool / datasource
try {
customerDbUtil = new CustomerDbUtil(dataSource);
}
catch (Exception exc) {
throw new ServletException(exc);
}
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

try {
// read the "command" parameter
String theCommand = request.getParameter("command");
if (theCommand == null) {
theCommand = "FIRSTPAGE";
}

String[] commands = theCommand.split(",");
String commandOne = commands[0];


// if the command is missing, then default to listing students
// if (commandOne == null) {
// commandOne = "FIRSTPAGE";
// }

// route to the appropriate method
switch (commandOne) {

case "FIRSTPAGE":
firstPage(request, response);
break;

case "LIST":
listCustomers(request, response);

break;

case "ADD":
addStudent(request, response);
break;

case "LOAD":
loadStudent(request, response);
break;

case "UPDATE":
updateStudent(request, response);
break;

case "DELETE":
deleteCustomer(request, response);
break;

default:
firstPage(request, response);
// listCustomers(request, response);
// listItems(request, response);
}}



catch (Exception exc) {
throw new ServletException(exc);
}

}

private void firstPage(HttpServletRequest request, HttpServletResponse response)
throws Exception {


// send to jsp page: update-student-form.jsp
RequestDispatcher dispatcher =
request.getRequestDispatcher("/selectform.jsp");
dispatcher.forward(request, response);
}

private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
throws Exception {

// read student id from form data
String theCustomerId = request.getParameter("customerId");

// delete student from database
customerDbUtil.deleteCustomer(theCustomerId);

// send them back to "list students" page
listCustomers(request, response);
}

private void updateStudent(HttpServletRequest request, HttpServletResponse response)
throws Exception {

// read student info from form data
int customerId = Integer.parseInt(request.getParameter("customerId"));
String customerFirstName = request.getParameter("customerFirstName");
String customerLastName = request.getParameter("customerLastName");
String customerAddress = request.getParameter("customerAddress");

// create a new student object
Customer theCustomer = new Customer(customerId, customerFirstName, customerLastName, customerAddress);

// perform update on database
customerDbUtil.updateStudent(theCustomer);

// send them back to the "list students" page
listCustomers(request, response);

}

private void loadStudent(HttpServletRequest request, HttpServletResponse response)
throws Exception {

// read student id from form data
String theCustomerId = request.getParameter("customerId");

// get student from database (db util)
Customer theCustomer = customerDbUtil.getCustomer(theCustomerId);

// place student in the request attribute
request.setAttribute("THE_CUSTOMER", theCustomer);

// send to jsp page: update-student-form.jsp
RequestDispatcher dispatcher =
request.getRequestDispatcher("/update-student-form.jsp");
dispatcher.forward(request, response);
}

private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

// read customer info from form data
String customerFirstName = request.getParameter("firstName");
String customerLastName = request.getParameter("lastName");
String customerAddress = request.getParameter("address");

// create a new customer object
Customer theCustomer = new Customer(customerFirstName, customerLastName, customerAddress);

// add the customer to the database
customerDbUtil.addCustomer(theCustomer);

// send back to main page (the student list)
listCustomers(request, response);
}

private void listCustomers(HttpServletRequest request, HttpServletResponse response)
throws Exception {
try {
// read the "sql" parameter
String theCommand = request.getParameter("command");
if (theCommand == null) {
theCommand = "LIST,all";
}

String[] commands = theCommand.split(",");
String commandTwo = commands[1];



// if the selectSqlQuery parameter is missing, then default to running the first script in DB method
// if (selectSqlQuery == null) {
// selectSqlQuery = "all";
//}

// route to the appropriate method
switch (commandTwo) {

case "all":
queryChoice= 1;
break;

case "bobby":
queryChoice = 2;
break;

case "idthree":
queryChoice = 3;
break;

case "likeYo":
queryChoice = 4;
break;

case "annaormimi":
queryChoice = 5;
break;

case "firstnamein":
queryChoice = 6;
break;

case "notalfred":
queryChoice = 7;
break;

case "fullname":
queryChoice = 8;
break;



default:
queryChoice= 1;
}}

catch (Exception exc) {
throw new ServletException(exc);
}
// get customers from db util
List<Customer> customers = customerDbUtil.getCustomers(queryChoice);

// add customers to the request
request.setAttribute("CUSTOMER_LIST", customers);

// get items from db util
List<Item> items = customerDbUtil.getItems();

// add items to the request
request.setAttribute("ITEM_LIST", items);

// get items from db util
List<Manufacturer> manufacturers = customerDbUtil.getManufacturers();

// add items to the request
request.setAttribute("MANUFACTURER_LIST", manufacturers);

// get items from db util
List<Store> stores = customerDbUtil.getStores();

// add items to the request
request.setAttribute("STORE_LIST", stores);

// get items from db util
List<Promotion> promotions = customerDbUtil.getPromotions();

// add items to the request
request.setAttribute("PROMOTION_LIST", promotions);

// send to JSP page (view)
RequestDispatcher dispatcher = request.getRequestDispatcher("/list-customers.jsp");
dispatcher.forward(request, response);
}



}