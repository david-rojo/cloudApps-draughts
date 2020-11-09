package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GameBuilderTest {
	
	private GameBuilder gameBuilder;
	
	@BeforeEach
	public void before() {
		this.gameBuilder = new GameBuilder();
	}
	
	@Test
	public void testGivenGameBuilderWhenIncorrectRowsNumberThenError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.gameBuilder.rows(
					"        ",
					"        ",
					"        ",
					"        ",
					"        ",
					"        ",
					"        ").build();
		});		
	}
	
	@Test
	public void testGivenGameBuilderWhenIncorrectRowsLengthThenError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.gameBuilder.rows(
					"         ",
					"       ",
					"        ",
					"        ",
					"        ",
					"        ",
					"        ",
					"        ").build();
		});	
	}

	@Disabled
	@Test
	public void testGivenGameBuilderWhenIncorrectCharactersThenError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.gameBuilder.rows(
					"        ",
					"        ",
					"        ",
					"        ",
					" x      ",
					"        ",
					"        ",
					"        ").build();
		});	
	}
	
	@Test
	public void testGivenGameBuilderWhenCorrectRowsThenOk() {
		Game game = this.gameBuilder.rows(
				"    n   ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"       b").build();
		assertThat(game.getColor(new Coordinate(5,0)), is(nullValue()));
		assertThat(game.getColor(new Coordinate(0, 4)), is(Color.BLACK));
		assertThat(game.getColor(new Coordinate(7, 7)), is(Color.WHITE));
		assertThat(game.getColor(new Coordinate(5,5)), is(nullValue()));		
	}
	
	

}
