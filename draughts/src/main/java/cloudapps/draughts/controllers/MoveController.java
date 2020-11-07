package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.models.Error;
import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;

class MoveController extends Controller {

	private static final int MINIMUM_COORDINATES = 2;

    protected MoveController(Game game, State state) {
        super(game, state);
    }

    public Error move(Coordinate... coordinates) {
        assert coordinates.length >= MoveController.MINIMUM_COORDINATES;
		for(Coordinate coordinate: coordinates)
			assert coordinate != null;
		Error error = this.game.move(coordinates);
		if (this.game.isBlocked())
			this.state.next();
		return error;
	}

}