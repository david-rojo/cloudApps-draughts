package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class DirectionTest {

	@Test
	void testGivenDirectionAndCoordinateWhenSameDirectionThenFalse() {
		assertThat(Direction.NW.isOnDirection(new Coordinate(7, 7)), is(false));
		assertThat(Direction.NE.isOnDirection(new Coordinate(3, 7)), is(false));
		assertThat(Direction.NE.isOnDirection(new Coordinate(0, 0)), is(false));
	}
}
