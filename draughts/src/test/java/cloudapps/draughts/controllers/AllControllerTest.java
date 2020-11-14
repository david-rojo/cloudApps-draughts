package cloudapps.draughts.controllers;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ 
	PlayControllerTest.class, 
	ResumeControllerTest.class,
	StartControllerTest.class})
public class AllControllerTest {

}
