package cloudapps.draughts;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import cloudapps.draughts.controllers.AllControllerTest;
import cloudapps.draughts.models.AllModelTest;
import cloudapps.draughts.views.AllViewTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ 
    AllModelTest.class, 
    AllControllerTest.class, 
    AllViewTest.class } )
public final class AllTest {

}
