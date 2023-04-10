package com.oxiane.katas.roman;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/oxiane/katas/roman")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "{pretty, html:target/roman-tests.html")
public class RunCucumberTest {
}
