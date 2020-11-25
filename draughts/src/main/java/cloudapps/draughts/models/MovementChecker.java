package cloudapps.draughts.models;

class MovementChecker {
	
	private MovementCheck movementCheck;
	
	public MovementChecker() {
		
		MovementCheck correctMovementCheck = new CorrectMovementCheck();
		MovementCheck notEmptyTargetCheck = new NotEmptyTargetCheck(correctMovementCheck);
		MovementCheck oppositePieceCheck = new OppositePieceCheck(notEmptyTargetCheck);
		
        this.movementCheck = new EmptyOriginCheck(oppositePieceCheck);
	}
	
	public Error check(Movement movement) {
        return movementCheck.check(movement);
    }

}
