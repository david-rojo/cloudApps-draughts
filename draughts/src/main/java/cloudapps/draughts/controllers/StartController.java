package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;
import cloudapps.draughts.views.View;

public class StartController extends InteractorController {

	public StartController(Game game, State state) {
        super(game, state);
	}

	public void start() {
        this.state.next();
	}

	@Override
	public void control() {
		View view = new View();
		view.writeTitle();
		this.writeGame();
        this.start();		
	}
	
}
