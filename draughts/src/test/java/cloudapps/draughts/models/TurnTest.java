package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnTest {

	private Turn turn;

	@BeforeEach
	public void before() {
		this.turn = new Turn();
	}

	@Test
	void testGivenNewTurnIsWhitesTurn() {
		assertThat(turn.getColor(), is(Color.WHITE));
	}
	
	@Test
	void testGivenNewTurnWhenChangeTurnThenIsOtherTurn() {
		this.turn.change();
		assertThat(turn.getColor(), is(Color.BLACK));
	}

	@Test
	void testGivenNewTurnWhenChangeTurnTwoTimesThenIsTheSameTurn() {
		this.turn.change();
		this.turn.change();
		assertThat(turn.getColor(), is(Color.WHITE));
	}
}
