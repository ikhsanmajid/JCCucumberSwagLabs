package com.juaracoding;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/features/1_Login.feature", "src/main/resources/features/2_Logout.feature", "src/main/resources/features/3_Checkout.feature"},
        glue = "com.juaracoding",
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests{
}