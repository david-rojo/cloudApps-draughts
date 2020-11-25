package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Color;
import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.models.Error;
import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;
import cloudapps.draughts.views.View;

public class PlayController extends InteractorController {

	private CancelController cancelController;
	private MoveController moveController;

	public PlayController(Game game, State state) {
		super(game, state);
		this.cancelController = new CancelController(game, state);
		this.moveController = new MoveController(game, state);
	}

	public Error move(Coordinate... coordinates) {
		return this.moveController.move(coordinates);
	}

	public void cancel() {
		this.cancelController.cancel();
	}

	public Color getColor() {
		return this.game.getTurnColor();
	}

	public boolean isBlocked() {
		return this.game.isBlocked();
	}

	@Override
	public void control() {
        Error error;
        View view = new View();
        do {
            error = null;
            String string = view.read(this.getColor());
            if (view.isCanceledFormat(string))
            	this.cancel();
            else if (!view.isMoveFormat(string)) {
                error = Error.BAD_FORMAT;
                view.writeError();
            } else {
                error = this.move(view.getCoordinates(string));
                this.writeGame();
                if (error == null && this.isBlocked())
                	view.writeLost();
            }
        } while (error != null);
		
	}

}