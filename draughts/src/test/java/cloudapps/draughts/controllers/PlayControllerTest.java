package cloudapps.draughts.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import cloudapps.draughts.models.Color;
import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.GameBuilder;
import cloudapps.draughts.models.State;

public class PlayControllerTest {
	
	private PlayController playController;
	
	@Test
	public void testGivenPlayControllerWhenMoveThenOk() {
		Game game = new GameBuilder().build();
		playController = new PlayController(game, new State());
		Coordinate origin = new Coordinate(5, 0);
		Coordinate target = new Coordinate(4, 1);
		playController.move(origin, target);
		assertThat(playController.getColor(), is(Color.WHITE));
//		assertThat(game.isBlocked(), is(false));
	}

}
