package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;

class Controller {

    protected Game game;
    protected State state;

    protected Controller(Game game, State state) {
        assert game != null;
        assert state != null;
        this.game = game;
        this.state = state;
    }

    public int getDimension() {
        return this.game.getDimension();
    }

}
