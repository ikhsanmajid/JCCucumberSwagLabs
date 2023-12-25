package com.juaracoding.utils;

public enum TestCase {
    T1("User Login with invalid password"),
    T2("User Login with invalid username"),
    T3("User Login with empty password"),
    T4("User Login with empty username"),
    T5("User Login with empty password and username"),
    T6("User Login Valid"),
    T7("User Logout from Session"),
    T8("User add items to cart"),
    T9("User check items Sauce Labs Backpack"),
    T10("User check items Sauce Labs Bike Light"),
    T11("User input empty LastName"),
    T12("User input empty FirstName"),
    T13("User input empty PostalCode"),
    T14("User input empty shipping address"),
    T15("User input valid shipping address"),
    T16("User finish checkout"),
    T17("User back to page products");


    private String testCaseName;

    TestCase(String value){
        testCaseName = value;
    }

    public String getTestCaseName() {
        return testCaseName;
    }
}
