package cloudapps.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import cloudapps.draughts.controllers.ResumeController;
import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;
import cloudapps.draughts.utils.YesNoDialog;

@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

	@Mock
	ResumeController resumeController;

	@Mock
	YesNoDialog yesNoDialog;

    @InjectMocks
    ResumeView resumeView;
    
	@BeforeEach
	public void initMocks() {
        resumeController = new ResumeController(new Game(), new State());
		MockitoAnnotations.initMocks(this);
	}
    
    @Test
    public void testGivenResumeViewWhenContinueThenClear(){
        when(yesNoDialog.read("¿Queréis jugar otra?")).thenReturn(true);
		resumeView.interact(resumeController);
		verify(resumeController).reset();
    }
}
