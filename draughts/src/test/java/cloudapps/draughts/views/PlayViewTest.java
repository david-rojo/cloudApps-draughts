package cloudapps.draughts.views;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import cloudapps.draughts.controllers.PlayController;
import cloudapps.draughts.models.Color;
import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.utils.Console;

@ExtendWith(MockitoExtension.class)
class PlayViewTest {

	private final static String BLACKS_MOVES_PROMPT = "Mueven las negras: ";
	
	@Mock
    PlayController playController;

    @Mock
    Console console;

    @InjectMocks
    View playView;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGivenPlayViewWhenCorrectFormatThenOk() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(BLACKS_MOVES_PROMPT))
        	.thenReturn("44.53");
        playView.visit(playController);
        verify(playController)
        	.move(new Coordinate(3, 3), new Coordinate(4, 2));
    }

    @Test
    void testGivenPlayViewWhenInteractWithEmptyThenError() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(BLACKS_MOVES_PROMPT))
        	.thenReturn("")
        	.thenReturn("44.53");
        playView.visit(playController);
        verify(playController)
        	.move(new Coordinate(3, 3), new Coordinate(4, 2));
    }

    @Test
    void testGivenPlayViewWhenInteractWithBadFormatThenError() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(BLACKS_MOVES_PROMPT))
        	.thenReturn("c4.53")
        	.thenReturn("44.53");
        playView.visit(playController);
        verify(playController)
        	.move(new Coordinate(3, 3), new Coordinate(4, 2));
    }

    @Test
    void testGivenPlayViewWhenInteractWithRangeOutOfBoundsThenError() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(BLACKS_MOVES_PROMPT))
        	.thenReturn("103.411")
        	.thenReturn("32.41");
        playView.visit(playController);
        verify(playController)
        	.move(new Coordinate(2, 1), new Coordinate(3, 0));
    }
    
    @Test
    void testGivenPlayViewWhenInteractWithCancelOperationThenShouldCancel() {
    	when(playController.getColor()).thenReturn(Color.BLACK);
    	when(console.readString(anyString())).thenReturn("-1");

    	playView.visit(playController);
    	verify(playController).cancel();
    }
    
}
