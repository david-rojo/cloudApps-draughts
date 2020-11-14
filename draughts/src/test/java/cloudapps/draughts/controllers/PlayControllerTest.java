package cloudapps.draughts.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import cloudapps.draughts.models.Color;
import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.models.Error;
import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.GameBuilder;
import cloudapps.draughts.models.State;

class PlayControllerTest {
	
	private PlayController playController;
	
	private Game game;


	@Test
	void testGivenPlayControllerWhenValidMoveThenMoved() {
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"        ",
				"  b     ",
				"        ",
				"        ",
				"        ",
				"        ");				
		this.playController = new PlayController(this.game, new State());
		Coordinate origin = new Coordinate(3,2);
		Coordinate target = new Coordinate(2,1);
		this.playController.move(origin, target);
		assertNull(this.playController.getPiece(origin));
	}
	
	@Test
	void testGivenPlayControllerWhenValidMoveThenTurnChanged() {
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"        ",
				"  b     ",
				"        ",
				"        ",
				"        ",
				"        ");				
		this.playController = new PlayController(this.game, new State());
		Coordinate origin = new Coordinate(3,2);
		Coordinate target = new Coordinate(2,1);
		this.playController.move(origin, target);
		assertThat(this.playController.getColor(), is(Color.BLACK));
	}
	
	@Test
	void testGivenPlayControllerWhenInvalidMoveThenError() {
		this.game = GameBuilder.game(
				"        ",
				"        ",
				"        ",
				"  b     ",
				"        ",
				"        ",
				"        ",
				"        ");	
		this.playController = new PlayController(this.game, new State());
		Coordinate origin = new Coordinate(3, 2);
		Coordinate target = new Coordinate(4, 2);
		Error error = this.playController.move(origin, target);
		assertThat(error, is(Error.NOT_DIAGONAL));
	}

}
