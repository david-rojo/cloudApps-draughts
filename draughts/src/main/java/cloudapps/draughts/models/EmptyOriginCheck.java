package cloudapps.draughts.models;

class EmptyOriginCheck extends MovementCheck {

	public EmptyOriginCheck(MovementCheck next) {
        super(next);
    }

    @Override
    public Error check(Movement movement) {

    	if (movement.getBoard().isEmpty(movement.getCoordinates()[movement.getPair()])) {
            return Error.EMPTY_ORIGIN;
        }
        return this.nextMovement(movement);
    }

}
