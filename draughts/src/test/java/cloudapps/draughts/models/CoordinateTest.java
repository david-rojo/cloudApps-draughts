package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoordinateTest {

	private final static int VALID_ORIGIN_COORDINATE_X = 0;
	private final static int VALID_ORIGIN_COORDINATE_Y = 7;
	private final static int VALID_TARGET_COORDINATE_X = 7;
	private final static int VALID_TARGET_COORDINATE_Y = 0;
	private final static int INVALID_COORDINATE_X = 8;
	private final static int INVALID_COORDINATE_Y = 8;
	
	private Coordinate originCoordinate;
	private Coordinate targetCoordinate;
	private Coordinate invalidCoordinate;
	private final static Color COLOR = Color.WHITE;
	
	@BeforeEach
	public void before() {
		originCoordinate = new Coordinate(VALID_ORIGIN_COORDINATE_X, VALID_ORIGIN_COORDINATE_Y);
		targetCoordinate = new Coordinate(VALID_TARGET_COORDINATE_X, VALID_TARGET_COORDINATE_Y);
		invalidCoordinate = new Coordinate(INVALID_COORDINATE_X, INVALID_COORDINATE_Y);
	}
	
	@Test
	public void testFirstCoordinateThenGetIsFirstOk() {
		assertThat(originCoordinate.isFirst(), is(true));
	}
	
	@Test
	public void testNotFirstCoordinateThenGetIsFirstKo() {
		assertThat(targetCoordinate.isFirst(), is(false));
	}
	
	@Test
	public void testLastCoordinateThenGetIsLastOk() {
		assertThat(targetCoordinate.isLast(), is(true));
	}
	
	@Test
	public void testNotLastCoordinateThenGetIsLastKo() {
		assertThat(originCoordinate.isLast(), is(false));
	}
}
