package cloudapps.draughts.controllers;

import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.Piece;
import cloudapps.draughts.models.State;
import cloudapps.draughts.views.View;

public abstract class InteractorController extends Controller {

	protected InteractorController(Game game, State state) {
		super(game, state);
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}
	
	public abstract void control();
	
	protected void writeGame() {
		final int DIMENSION = this.getDimension();
		View view = new View();
		view.writeNumbersLine(DIMENSION);
        for (int i = 0; i < DIMENSION; i++)
            this.writePiecesRow(view, i);
        view.writeNumbersLine(DIMENSION);
	}
	
	private void writePiecesRow(View view, final int row) {
        view.write((row + 1) + "");
        for (int j = 0; j < this.getDimension(); j++) {
            Piece piece = this.getPiece(new Coordinate(row, j));
            if (piece == null)
            	view.write(" ");
            else 
            	view.write(piece.getCode());
        }
        view.writeln((row + 1) + "");
    }
	
}
