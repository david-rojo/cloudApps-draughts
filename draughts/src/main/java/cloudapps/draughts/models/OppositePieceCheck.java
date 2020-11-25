package cloudapps.draughts.models;

public class OppositePieceCheck extends MovementCheck {

	public OppositePieceCheck(MovementCheck next) {
        super(next);
    }

    @Override
    public Error check(Movement movement) {

    	if (movement.getTurn().getOppositeColor() == movement.getBoard()
        		.getColor(movement.getCoordinates()[movement.getPair()])) {
            return Error.OPPOSITE_PIECE;
        }
        return this.nextMovement(movement);
    }
}
