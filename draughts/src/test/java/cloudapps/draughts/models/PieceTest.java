package cloudapps.draughts.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PieceTest {
	
	@Test
    void testGivenPieceWhenIsAdvancedThenTrue(){
        assertTrue(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(4,1)));
        assertTrue(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(3,2)));
    }

    @Test
    void testGivenPieceWhenNotIsAdvancedThenFalse(){
        assertFalse(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(6,1)));
        assertFalse(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(5,2)));
        assertFalse(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(2,3)));
        assertFalse(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(1,2)));
    }

}
