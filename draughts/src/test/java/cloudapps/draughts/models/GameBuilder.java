package cloudapps.draughts.models;

public class GameBuilder {
	
	private Game game;
	private Board board;
	
	public GameBuilder() {
		this.board = new Board();
		this.game = new Game(this.board);
	}
	
	public Game build() {
		return this.game;
	}
	
	public GameBuilder rows(String... rows) {
		assert rows.length == Coordinate.getDimension();
		for (int i=0; i<rows.length; i++) {
			assert rows[i].length() == Coordinate.getDimension();
			this.setRow(this.board, i, rows[i]);
		}
		return this;
	}
	
	private void setRow(Board board, int row, String string) {
		for (int j = 0; j < string.length(); j++) {
			Color color = this.getColor(string.charAt(j));
			if (color != null) {
				Piece piece = new Pawn(color);
				if (Character.isUpperCase(string.charAt(j)))
					piece = new Draught(color);
				this.board.put(new Coordinate(row, j), piece);
			}
		}	
	}

	private Color getColor(char character) {
		switch (character) {
		case 'b':
		case 'B':
			return Color.WHITE;
		case 'n':
		case 'N':
			return Color.BLACK;
		default:
			return null;
		}
	}

}
