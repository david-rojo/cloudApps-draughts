package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BoardTest {
	
	private Board board;
	private Coordinate originCoordinate;
	private Coordinate targetCoordinate;
	private Coordinate invalidCoordinate;
	private Pawn whitePawn;
	
	@BeforeEach
	public void before() {
		this.board = new Board();
		this.originCoordinate = new Coordinate(7, 0);
		this.targetCoordinate = new Coordinate(5, 2);
		this.invalidCoordinate = new Coordinate(8, 8);
		this.whitePawn = new Pawn(Color.WHITE);
	}
	
	@Test
	void testGivenBoardWhenGetPieceWithNullCoordinateThenAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.board.getPiece(null);
		});	
	}
	
	@Test
	void testGivenValidCoordinateAndValidPieceThenPutAndGetOk() {
		this.board.put(this.originCoordinate, this.whitePawn);
		assertThat(this.board.getPiece(originCoordinate), is(notNullValue()));
		assertThat(this.board.getPiece(originCoordinate), is(this.whitePawn));
		assertThat(this.board.getPiece(originCoordinate).getColor(), is(Color.WHITE));
	}
	
	@Test
	void testGivenInvalidCoordinateAndValidPieceThenPutArrayIndexOutOfBoundsError() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.board.put(this.invalidCoordinate, this.whitePawn);
		});		
	}
	
	@Test
	void testGivenNullCoordinateThenRemoveAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.board.remove(null);
		});		
	}
	
	@Test
	void testGivenInvalidCoordinateThenRemoveArrayIndexOutOfBoundsError() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.board.remove(this.invalidCoordinate);
		});		
	}
	
	@Test
	void testGivenValidCoordinateAndValidPieceThenRemoveOk() {
		this.board.put(this.originCoordinate, this.whitePawn);
		this.board.remove(this.originCoordinate);
		assertThat(this.board.getPiece(this.originCoordinate), is(nullValue()));
	}
	
	@Test
	void testGivenNullOriginCoordinateThenMoveAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.board.move(null, this.originCoordinate);
		});	
	}
	
	@Test
	void testGivenValidOriginValidTargetThenMoveOk() {
		this.board.put(this.originCoordinate, this.whitePawn);
		this.board.move(this.originCoordinate, this.targetCoordinate);
		Piece movedPiece = this.board.getPiece(this.targetCoordinate);
		assertThat(movedPiece, is(notNullValue()));
		assertThat(movedPiece, is(this.whitePawn));
		assertThat(movedPiece.getColor(), is(Color.WHITE));
	}

	@Test
	void testGivenValidOriginValidTargetWith1PieceThenGetBetweenDiagonalPieces1Piece() {
		this.board.put(new Coordinate(6,1), this.whitePawn);
		List<Piece> pieces = this.board
				.getBetweenDiagonalPieces(this.originCoordinate, this.targetCoordinate);
		assertThat(pieces, is(notNullValue()));
		assertThat(pieces.size(), is(1));
		assertThat(pieces.get(0), is(this.whitePawn));
	}
	
	@Test
	void testGivenValidOriginValidTargetWithoutPiecesThenGetBetweenDiagonalPiecesEmpty() {
		List<Piece> pieces = this.board
				.getBetweenDiagonalPieces(this.originCoordinate, this.targetCoordinate);
		assertThat(pieces.isEmpty(), is(true));
	}
	
	@Test
	void testGivenValidOriginValidTargetWith1PieceThenGetAmountBetweenDiagonalPieces1() {
		this.board.put(new Coordinate(6,1), this.whitePawn);
		int pieces = this.board
				.getAmountBetweenDiagonalPieces(this.originCoordinate, this.targetCoordinate);
		assertThat(pieces, is(notNullValue()));
		assertThat(pieces, is(1));
	}
	
	@Test
	void testGivenValidOriginValidTargetWithoutPiecesThenGetAmountBetweenDiagonalPieces0() {
		int pieces = this.board
				.getAmountBetweenDiagonalPieces(this.originCoordinate, this.targetCoordinate);
		assertThat(pieces, is(notNullValue()));
		assertThat(pieces, is(0));
	}
	
}
