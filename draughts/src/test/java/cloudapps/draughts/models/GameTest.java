package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GameTest {
	
	protected Game game;
	
	private Coordinate coordinate(int row, int column) {
		return new Coordinate(row, column);
	}
	
	private Color color(Coordinate coordinate) {
		return this.game.getColor(coordinate);
	}
	
	private Piece piece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}
	
	private Error move(Coordinate... coordinates) {
		return this.game.move(coordinates);
	}
	
	@Test
	void testWhenResetThenRestartPiecesPlaces() {
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"        ",
				"  n     ",
				"        ",
				"        ",
				"        ",
				"        ");
		this.game.reset();
		assertThat(color(coordinate(6,1)), is(Color.WHITE));
		assertThat(color(coordinate(0,1)), is(Color.BLACK));
		assertThat(color(coordinate(4,4)), not(Color.BLACK));
		assertThat(color(coordinate(4,4)), not(Color.WHITE));
	}
	
	@Test
	void testWhenEmptyCoordinateThenNullPiece() {
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"        ",
				"  n     ",
				"        ",
				"        ",
				"        ",
				"        ");		
		assertNull(piece(coordinate(6,1)));
	}
	
	@Test
	void testWhenBlockedPawnThenBlockedGame() {
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"  n     ",
				" n      ",
				"b       ");		
		assertTrue(this.game.isBlocked());
	}
	
	@Test
	void testWhenBlockedDraughtThenBlockedGame() {
		this.game = GameBuilder.game(
				"        ",
				" n   n  ",
				"  n n   ",
				"   B    ",
				"  n n   ",
				" n   n  ",
				"        ",
				"        ");		
		assertTrue(this.game.isBlocked());
	}
	
	@Test
	void testWhenVerticalMoveThenError() {
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"        ",
				"   n    ",
				"    b   ",
				"        ",
				"        ",
				"        ");		
		Error error = move(coordinate(4,4), coordinate(3,4));
		assertThat(error, is(Error.NOT_DIAGONAL));
	}
	
	@Test
	void testWhenValidPairThenNoError() {
		this.game = GameBuilder.game(
				"        ",
				"   n    ",
				"        ",
				"   n    ",
				"    b   ",
				"        ",
				"        ",
				"        ");		
		Error error = move(coordinate(4,4), coordinate(2,2), coordinate(0,4));
		assertNull(error);
	}
	
	@Test
	void testWhenPairMoveErrorThenRestorePieces() {
		this.game = GameBuilder.game(
				"    n   ",
				"   n    ",
				"        ",
				"   N    ",
				"    b   ",
				"        ",
				"        ",
				"        ");		
		Error error = move(coordinate(4,4), coordinate(2,2), coordinate(0,4));
		assertThat(error, is(Error.NOT_EMPTY_TARGET));
		assertTrue(piece(coordinate(1,3)) instanceof Pawn);
		assertTrue(piece(coordinate(3,3)) instanceof Draught);
	}
	
	@Test
	void testWhenDraughtVerticalMoveThenError() {		
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"        ",
				"        ",
				"    B   ",
				"        ",
				"        ",
				"        ");		
		Error error = move(coordinate(4,4), coordinate(1,3));
		assertThat(error, is(Error.NOT_DIAGONAL));
	}
	
	@Test
	void testWhenDraughtEatsTwoWithoutSpacesThenError() {		
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"  n     ",
				"   n    ",
				"    B   ",
				"        ",
				"        ",
				"        ");		
		Error error = move(coordinate(4,4), coordinate(0,0));
		assertThat(error, is(Error.TOO_MUCH_EATINGS));
	}
	
	
    

}
