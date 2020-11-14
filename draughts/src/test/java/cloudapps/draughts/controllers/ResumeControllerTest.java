package cloudapps.draughts.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;
import cloudapps.draughts.models.StateValue;

class ResumeControllerTest {

	private ResumeController resumeController;
    private State state;
    
    @BeforeEach
    void before() {
    	state = new State();
    	resumeController = new ResumeController(new Game(), state);
    }
	
	@Test
    void givenResumeControllerWhenResumeGameMoveToInitialStateThenOk() {
        resumeController.next();
        resumeController.next();
        resumeController.reset();
        assertThat(state.getValueState(), is(StateValue.INITIAL));
    }
	
	@Test
    void givenResumeControllerWhenResumeGameExitNextThenError() {
		Assertions.assertThrows(AssertionError.class, () -> {
	        resumeController.next();
	        resumeController.next();
	        resumeController.next();
	        resumeController.next();
		});
    }
}
