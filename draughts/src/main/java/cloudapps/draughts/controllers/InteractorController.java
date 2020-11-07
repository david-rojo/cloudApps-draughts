package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.Piece;
import cloudapps.draughts.models.State;

public abstract class InteractorController extends Controller {

	protected InteractorController(Game game, State state) {
		super(game, state);
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}

	abstract public void accept(InteractorControllersVisitor controllersVisitor);

}
