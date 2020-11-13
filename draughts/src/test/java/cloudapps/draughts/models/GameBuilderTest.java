package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameBuilderTest {
	
	private Game game;
	
	private static Game game(String... rows) {
		return new GameBuilder().rows(rows).build();
	}
	
	@Test
	void testGivenGameBuilderWhenIncorrectRowsNumberThenError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.game = game(
					"        ",
					"        ",
					"        ",
					"        ",
					"        ",
					"        ",
					"        ");
		});		
	}
	
	@Test
	void testGivenGameBuilderWhenIncorrectRowsLengthThenError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.game = game(
					"         ",
					"       ",
					"        ",
					"        ",
					"        ",
					"        ",
					"        ",
					"        ");
		});	
	}
	
	@Test
	void testGivenGameBuilderWhenCorrectRowsThenOk() {
		this.game = game(
				"    n   ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"       b");
		assertThat(game.getColor(new Coordinate(5,0)), is(nullValue()));
		assertThat(game.getColor(new Coordinate(0, 4)), is(Color.BLACK));
		assertThat(game.getColor(new Coordinate(7, 7)), is(Color.WHITE));
		assertThat(game.getColor(new Coordinate(5,5)), is(nullValue()));		
	}	

}
