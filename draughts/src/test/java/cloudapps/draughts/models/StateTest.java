package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class StateTest {

	private State state;

    public StateTest() {
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenGetValueStateThenIsInitial() {
    	assertThat(StateValue.INITIAL, is(this.state.getValueState()));
    }

    @Test
    public void testGivenNewStateWhenDoNextAndGetValueStateThenIsInGame() {
        this.state.next();
        assertThat(StateValue.IN_GAME, is(this.state.getValueState()));
    }

    @Test
    public void testGivenNewStateWhenDoTwoNextAndGetValueStateThenIsResult() {
        this.state.next();
        this.state.next();
        assertThat(StateValue.FINAL, is(this.state.getValueState()));
    }

    @Test
    public void testGivenNewStateWhenDoThreeNextAndGetValueStateThenIsExit() {
        this.state.next();
        this.state.next();
        this.state.next();
        assertThat(StateValue.EXIT, is(this.state.getValueState()));
    }
}
