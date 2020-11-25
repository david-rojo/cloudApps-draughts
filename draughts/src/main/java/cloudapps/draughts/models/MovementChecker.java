package cloudapps.draughts.models;

import java.util.List;

public class MovementChecker {
	
	private Board board;
	private Turn turn;
	private MovementCheck movementCheck;
	
	public MovementChecker(Board board, Turn turn) {
		
		MovementCheck correctMovementCheck = new CorrectMovementCheck();
		MovementCheck notEmptyTargetCheck = new NotEmptyTargetCheck(correctMovementCheck);
		MovementCheck oppositePieceCheck = new OppositePieceCheck(notEmptyTargetCheck);
		
        this.movementCheck = new EmptyOriginCheck(oppositePieceCheck);
	}
	
//	public Error isCorrectPairMove(int pair, Coordinate... coordinates) {
//		assert coordinates[pair] != null;
//		assert coordinates[pair + 1] != null;
//		if (board.isEmpty(coordinates[pair]))
//			return Error.EMPTY_ORIGIN;
//		if (this.turn.getOppositeColor() == this.board.getColor(coordinates[pair]))
//			return Error.OPPOSITE_PIECE;
//		if (!this.board.isEmpty(coordinates[pair + 1]))
//			return Error.NOT_EMPTY_TARGET;
//		List<Piece> betweenDiagonalPieces = 
//			this.board.getBetweenDiagonalPieces(coordinates[pair], coordinates[pair + 1]);
//		return this.board.getPiece(coordinates[pair]).isCorrectMovement(betweenDiagonalPieces, pair, coordinates);
//	}
	
	public Error check(Movement movement) {
        return movementCheck.check(movement);
    }

}
