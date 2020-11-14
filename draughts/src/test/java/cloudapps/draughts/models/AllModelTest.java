package cloudapps.draughts.models;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ 
	BoardTest.class, 
	CoordinateTest.class,
	DirectionTest.class,
	GameBuilderTest.class,
	GameTest.class,
	PieceTest.class,
	StateTest.class,
	TurnTest.class})
class AllModelTest {

}
