package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;

class CancelController extends Controller {

    protected CancelController(Game game, State state) {
        super(game, state);
    }

    public void cancel() {
		this.game.cancel();
		this.state.next();
	}

}