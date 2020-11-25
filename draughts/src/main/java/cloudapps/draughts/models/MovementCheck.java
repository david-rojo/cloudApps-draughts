package cloudapps.draughts.models;

public abstract class MovementCheck {

	private final MovementCheck nextMovementCheckHandler;

	public MovementCheck(MovementCheck movementCheckHandler) {
		this.nextMovementCheckHandler = movementCheckHandler;
	}

	protected Error nextMovement(Movement movement) {
		if (this.nextMovementCheckHandler == null) {
			return Error.NULL;
		}
		return this.nextMovementCheckHandler.check(movement);
	}

	public abstract Error check(Movement movement);
}
