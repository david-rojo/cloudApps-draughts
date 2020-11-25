package cloudapps.draughts.models;

class NotEmptyTargetCheck extends MovementCheck {

	public NotEmptyTargetCheck(MovementCheck next) {
        super(next);
    }

    @Override
    public Error check(Movement movement) {

        if (!movement.getBoard().isEmpty(movement.getCoordinates()[movement.getPair() + 1])) {
            return Error.NOT_EMPTY_TARGET;
        }
        return this.nextMovement(movement);
    }
}
