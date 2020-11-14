package cloudapps.draughts.views;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ 
	PlayViewTest.class, 
	ResumeViewTest.class})
public class AllViewTest {

}
