package cloudapps.draughts.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BoardTest {

	private final static int VALID_ORIGIN_COORDINATE_X = 7;
	private final static int VALID_ORIGIN_COORDINATE_Y = 0;
	private final static int VALID_TARGET_COORDINATE_X = 5;
	private final static int VALID_TARGET_COORDINATE_Y = 2;
	private final static int INVALID_COORDINATE_X = 8;
	private final static int INVALID_COORDINATE_Y = 8;
	private final static Color COLOR = Color.WHITE;
	
	private Board board;
	private Coordinate originCoordinate;
	private Coordinate targetCoordinate;
	private Coordinate invalidCoordinate;
	
	@BeforeEach
	public void before() {
		board = new Board();
		originCoordinate = new Coordinate(VALID_ORIGIN_COORDINATE_X, VALID_ORIGIN_COORDINATE_Y);
		targetCoordinate = new Coordinate(VALID_TARGET_COORDINATE_X, VALID_TARGET_COORDINATE_Y);
		invalidCoordinate = new Coordinate(INVALID_COORDINATE_X, INVALID_COORDINATE_Y);
	}
	
	@Test
	public void testGivenBoardWhenGetPieceWithNullCoordinateThenGetAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.board.getPiece(null);
		});	
	}
	
	@Test
	public void testGivenValidCoordinateAndValidPieceThenPutAndGetOk() {
		Piece piece = new Pawn(COLOR);
		this.board.put(originCoordinate, piece);
		assertThat(this.board.getPiece(originCoordinate), is(notNullValue()));
		assertThat(this.board.getPiece(originCoordinate), is(piece));
		assertThat(this.board.getPiece(originCoordinate).getColor(), is(COLOR));
	}
	
	@Test
	public void testGivenInvalidCoordinateAndValidPieceThenPutArrayIndexOutOfBoundsError() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.board.put(invalidCoordinate, new Pawn(COLOR));
		});		
	}
	
	@Test
	public void testGivenNullCoordinateThenRemoveAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.board.remove(null);
		});		
	}
	
	@Test
	public void testGivenInvalidCoordinateThenRemoveArrayIndexOutOfBoundsError() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.board.remove(invalidCoordinate);
		});		
	}
	
	@Test
	public void testGivenValidCoordinateAndValidPieceThenRemoveOk() {
		Piece piece = new Pawn(COLOR);
		this.board.put(originCoordinate, piece);
		assertThat(this.board.getPiece(originCoordinate), is(notNullValue()));
		assertThat(this.board.getPiece(originCoordinate), is(piece));
		assertThat(this.board.getPiece(originCoordinate).getColor(), is(COLOR));
		this.board.remove(originCoordinate);
		assertThat(this.board.getPiece(originCoordinate), is(nullValue()));
	}
	
	@Test
	public void testGivenNullOriginCoordinateThenMoveAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.board.move(null, originCoordinate);
		});	
	}
	
	@Test
	public void testGivenValidOriginValidTargetThenMoveOk() {
		Piece piece = new Pawn(COLOR);
		this.board.put(originCoordinate, piece);
		assertThat(this.board.getPiece(originCoordinate), is(notNullValue()));
		assertThat(this.board.getPiece(originCoordinate), is(piece));
		assertThat(this.board.getPiece(originCoordinate).getColor(), is(COLOR));
		this.board.move(originCoordinate, targetCoordinate);
		Piece movedPiece = this.board.getPiece(targetCoordinate);
		assertThat(movedPiece, is(notNullValue()));
		assertThat(movedPiece, is(piece));
		assertThat(movedPiece.getColor(), is(COLOR));
	}

	@Test
	public void testGivenValidOriginValidTargetWith1PieceThenGetBetweenDiagonalPieces1Piece() {
		Piece piece = new Pawn(COLOR);
		this.board.put(new Coordinate(6,1), piece);
		List<Piece> pieces = this.board.getBetweenDiagonalPieces(originCoordinate, targetCoordinate);
		assertThat(pieces, is(notNullValue()));
		assertThat(pieces.size(), is(1));
		assertThat(pieces.get(0), is(piece));
	}
	
	@Test
	public void testGivenValidOriginValidTargetWithoutPiecesThenGetBetweenDiagonalPiecesEmpty() {
		List<Piece> pieces = this.board.getBetweenDiagonalPieces(originCoordinate, targetCoordinate);
		assertThat(pieces.isEmpty(), is(true));
	}
	
	@Test
	public void testGivenValidOriginValidTargetWith1PieceThenGetAmountBetweenDiagonalPieces1() {
		Piece piece = new Pawn(COLOR);
		this.board.put(new Coordinate(6,1), piece);
		int pieces = this.board.getAmountBetweenDiagonalPieces(originCoordinate, targetCoordinate);
		assertThat(pieces, is(notNullValue()));
		assertThat(pieces, is(1));
	}
	
	@Test
	public void testGivenValidOriginValidTargetWithoutPiecesThenGetAmountBetweenDiagonalPieces0() {
		int pieces = this.board.getAmountBetweenDiagonalPieces(originCoordinate, targetCoordinate);
		assertThat(pieces, is(notNullValue()));
		assertThat(pieces, is(0));
	}
	
}
