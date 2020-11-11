package cloudapps.draughts.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.GameBuilder;
import cloudapps.draughts.models.State;
import cloudapps.draughts.models.StateValue;

class StartControllerTest {

	@Test
	void testGivenStartControllerWhenStartThenInGameState() {
		Game game = new GameBuilder().build();
		State state = new State();
		StartController startController = new StartController(game, state);
		assertThat(state.getValueState(), is(StateValue.INITIAL));
		startController.start();
		assertThat(state.getValueState(), is(StateValue.IN_GAME));
	}
}
