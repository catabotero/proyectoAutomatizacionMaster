package com.tns.pruebas;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features",
        glue={"com.tns.pruebas.steps"},
        format = {"pretty","html:target/cucumber", "json:target/cucumber.json"})
public class Runner  { }