package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;

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
	public void accept(InteractorControllersVisitor controllersVisitor) {
		assert controllersVisitor != null;
		controllersVisitor.visit(this);
	}

}