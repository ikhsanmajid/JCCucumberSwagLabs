package com.juaracoding.utils;

public enum TestCase {
    T1("User Login Valid");

    private String testCaseName;

    TestCase(String value){
        testCaseName = value;
    }

    public String getTestCaseName() {
        return testCaseName;
    }
}
