package cloudapps.draughts.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;
import cloudapps.draughts.models.StateValue;

class ResumeControllerTest {

	@Test
    void givenResumeControllerWhenResumeGameMoveToInitialStateThenOk() {
        Game game = new Game();
        State state = new State();
        ResumeController resumeController = new ResumeController(game, state);
        assertThat(state.getValueState(), is(StateValue.INITIAL));
        resumeController.next();
        assertThat(state.getValueState(), is(StateValue.IN_GAME));
        resumeController.next();
        assertThat(state.getValueState(), is(StateValue.FINAL));
        resumeController.reset();
        assertThat(state.getValueState(), is(StateValue.INITIAL));
    }
	
	@Test
    void givenResumeControllerWhenResumeGameExitNextThenError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			Game game = new Game();
	        State state = new State();
	        ResumeController resumeController = new ResumeController(game, state);
	        assertThat(state.getValueState(), is(StateValue.INITIAL));
	        resumeController.next();
	        assertThat(state.getValueState(), is(StateValue.IN_GAME));
	        resumeController.next();
	        assertThat(state.getValueState(), is(StateValue.FINAL));
	        resumeController.next();
	        assertThat(state.getValueState(), is(StateValue.EXIT));
	        resumeController.next();
		});
    }
}
