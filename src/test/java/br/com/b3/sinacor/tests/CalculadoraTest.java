package br.com.b3.sinacor.tests;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import br.com.b3.sinacor.regression.AppConfiguration;
import br.com.b3.sinacor.regression.BaseTestCase;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Calculadora.feature"}, 
glue = { "br.com.b3.sinacor.stepDefinition" }, 
plugin = {"html:target/cucumber-html-report","json:target/cucumber.json"},
format = {"pretty", "html:target/reports/cucumber/html",
        "json:target/cucumber.json", "usage:target/usage.jsonx", "junit:target/junit.xml"}
		,tags = {"@winium"})

@ContextConfiguration(classes= AppConfiguration.class)
public class CalculadoraTest extends BaseTestCase {

}