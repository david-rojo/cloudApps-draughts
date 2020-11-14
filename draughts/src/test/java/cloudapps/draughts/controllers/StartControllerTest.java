package cloudapps.draughts.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;
import cloudapps.draughts.models.StateValue;

class StartControllerTest {

	private StartController startController;
    private State state;
    
    @BeforeEach
    void before() {
    	state = new State();
    	startController = new StartController(new Game(), state);
    }
    
	@Test
	void testGivenStartControllerWhenStartThenInGameState() {
		startController.start();
		assertThat(state.getValueState(), is(StateValue.IN_GAME));
	}
}
