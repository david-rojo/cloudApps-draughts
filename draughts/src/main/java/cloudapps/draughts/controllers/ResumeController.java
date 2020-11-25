package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;
import cloudapps.draughts.views.View;

public class ResumeController extends InteractorController {

	public ResumeController(Game game, State state) {
        super(game, state);
	}

	public void next() {
        this.state.next();
	}

	public void reset() {
		this.state.reset();
		this.game.reset();
	}

	@Override
	public void control() {
        if (new View().playAgain())
            this.reset();
        else
            this.next();
		
	}

}
