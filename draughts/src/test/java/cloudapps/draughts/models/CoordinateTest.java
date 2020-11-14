package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordinateTest {

	private Coordinate originCoordinate;
	private Coordinate targetCoordinate;
	private Coordinate invalidCoordinate;
	private final static Color COLOR = Color.WHITE;
	
	@BeforeEach
	public void before() {
		originCoordinate = new Coordinate(0, 7);
		targetCoordinate = new Coordinate(7, 0);
		invalidCoordinate = new Coordinate(8, 8);
	}
	
	@Test
	void testFirstCoordinateThenGetIsFirstThenTrue() {
		assertThat(originCoordinate.isFirst(), is(true));
	}
	
	@Test
	void testNotFirstCoordinateThenGetIsFirstThenFalse() {
		assertThat(targetCoordinate.isFirst(), is(false));
	}
	
	@Test
	void testLastCoordinateThenGetIsLastThenTrue() {
		assertThat(targetCoordinate.isLast(), is(true));
	}
	
	@Test
	void testNotLastCoordinateThenGetIsLastThenFalse() {
		assertThat(originCoordinate.isLast(), is(false));
	}
	
	@Test
	void testIsLastWhenRowIsNotWithinDownLimitThenError() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Coordinate.getInstance("00").isLast();
		});	
	}
	
	@Test
	void testIsLastWhenRowIsNotWithinUpperLimitThenError() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Coordinate.getInstance("99").isLast();
		});	
	}
	
	@Test
	void testIsLastWhenRowIsIncludedInLimitButNotLastThenFalse() {
		assertThat(Coordinate.getInstance("77").isLast(), is(Boolean.FALSE));
	}
	
	@Test
	void testIsLastWhenRowIsLastThenTrue() {
		assertThat(Coordinate.getInstance("88").isLast(), is(Boolean.TRUE));
	}
	
	@Test
	void testIsFirstWhenRowIsNotWithinDownLimitThenError() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Coordinate.getInstance("00").isFirst();
		});	
	}
	
	@Test
	void testIsFirstWhenRowIsNotWithinUpperLimitThenError() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Coordinate.getInstance("99").isFirst();
		});	
	}
	
	@Test
	void testIsLastWhenRowIsIncludedInLimitButNotFirstThenFalse() {
		assertThat(Coordinate.getInstance("33").isLast(), is(Boolean.FALSE));
	}
	
	@Test
	void testIsBlackRowColIsWhitePositionThenFalse() {
		for (int row=1; row<=8; row=row+2) {
			for (int col=1; col<=8; col=col+2) {
				assertThat(Coordinate.getInstance(row + "" + col).isBlack(), is(Boolean.FALSE));
			}
		}
	}
	
	@Test
	void testIsBlackRowColIsBlackPositionThenFalse() {
		for (int row=2; row<=8; row=row+2) {
			for (int col=2; col<=8; col=col+2) {
				assertThat(Coordinate.getInstance(row + "" + col).isBlack(), is(Boolean.FALSE));
			}
		}
	}
	
	@Test
	void testGetInstanceWhenCoordinatesOutOfRangeThenNull() {
		for (String input : Arrays.asList("00", "99", "29")) {
			assertNull(Coordinate.getInstance(input));
		}
	}
	
	@Test
	void testGetInstanceWhenCoordinateIsInRangeThenOk() {
		assertThat(Coordinate.getInstance("12"), is(new Coordinate(0, 1)));
		assertThat(Coordinate.getInstance("28"), is(new Coordinate(1, 7)));
		assertThat(Coordinate.getInstance("33"), is(new Coordinate(2, 2)));		
	}
	
	@Test
	void testGetInstanceWhenInputIsNotParseableIntThenNull() {
		assertNull(Coordinate.getInstance("bn"));
	}
	
	@Test
	void testDirectionsWhenDiagonalThenOk() {		
		assertThat(Coordinate.getInstance("44").getDirection(Coordinate.getInstance("62")), is(Direction.NW));
		assertThat(Coordinate.getInstance("44").getDirection(Coordinate.getInstance("55")), is(Direction.NE));
		assertThat(Coordinate.getInstance("44").getDirection(Coordinate.getInstance("11")), is(Direction.SW));
		assertThat(Coordinate.getInstance("44").getDirection(Coordinate.getInstance("17")), is(Direction.SE));
	}
	
	@Test
	void testDirectionsWhenUpOrDownThenError() {
		assertNull(Coordinate.getInstance("44").getDirection(Coordinate.getInstance("34")));
		assertNull(Coordinate.getInstance("44").getDirection(Coordinate.getInstance("43")));
		assertNull(Coordinate.getInstance("44").getDirection(Coordinate.getInstance("54")));
		assertNull(Coordinate.getInstance("44").getDirection(Coordinate.getInstance("45")));
	}
	
	
}
