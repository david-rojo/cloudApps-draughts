package cloudapps.draughts.models;

import java.util.ArrayList;
import java.util.List;

public class Movement {
	
	private Board board;
	private Turn turn;
	private Coordinate[] coordinates;
	private MovementChecker movementChecker;
	
	public Movement(Board board, Turn turn, Coordinate... coordinates) {
		this.board = board;
		this.turn = turn;
		this.coordinates = coordinates;
		this.movementChecker = new MovementChecker(this.board, this.turn);
	}
	
	public Error move() {
		Error error = null;
		List<Coordinate> removedCoordinates = new ArrayList<Coordinate>();
		List<Piece> removedPieces = new ArrayList<Piece>();
		int pair = 0;
		do {
			error = this.movementChecker.isCorrectPairMove(pair, coordinates);
			if (error == null) {
				this.pairMove(removedCoordinates, removedPieces, pair, coordinates);
				pair++;
			}
		} while (pair < coordinates.length - 1 && error == null);
		error = this.isCorrectGlobalMove(error, removedCoordinates, coordinates);
		if (error == null)
			this.turn.change();
		else
			this.unMovesUntilPair(removedCoordinates, removedPieces, pair, coordinates);
		return error;
	}
	
	private Error isCorrectGlobalMove(Error error, List<Coordinate> removedCoordinates, Coordinate... coordinates){
		if (error != null)
			return error;
		if (coordinates.length > 2 && coordinates.length > removedCoordinates.size() + 1)
			return Error.TOO_MUCH_JUMPS;
		return null;
	}
	
	private void pairMove(List<Coordinate> removedCoordinates, List<Piece> removedPieces, int pair, 
			Coordinate... coordinates) {
		Coordinate forRemoving = this.getBetweenDiagonalPiece(pair, coordinates);
		if (forRemoving != null) {
			removedCoordinates.add(0, forRemoving);
			removedPieces.add(this.board.getPiece(forRemoving));
			this.board.remove(forRemoving);
		}
		this.board.move(coordinates[pair], coordinates[pair + 1]);
		if (this.board.getPiece(coordinates[pair + 1]).isLimit(coordinates[pair + 1])) {
			Color color = this.board.getColor(coordinates[pair + 1]);
			this.board.remove(coordinates[pair + 1]);
			this.board.put(coordinates[pair + 1], new Draught(color));
		}
	}
	
	private void unMovesUntilPair(List<Coordinate> removedCoordinates, List<Piece> removedPieces, int pair,
			Coordinate... coordinates) {
		for (int j = pair; j > 0; j--)
			this.board.move(coordinates[j], coordinates[j - 1]);
		for(int i=0; i<removedCoordinates.size(); i++) {
			this.board.put(removedCoordinates.get(i), removedPieces.get(i));
		}
	}
	
	private Coordinate getBetweenDiagonalPiece(int pair, Coordinate... coordinates) {
		assert coordinates[pair].isOnDiagonal(coordinates[pair + 1]);
		List<Coordinate> betweenCoordinates = coordinates[pair].getBetweenDiagonalCoordinates(coordinates[pair + 1]);
		if (betweenCoordinates.isEmpty())
			return null;
		for (Coordinate coordinate : betweenCoordinates) {
			if (this.board.getPiece(coordinate) != null)
				return coordinate;
		}
		return null;
	}

}
