package cloudapps.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import cloudapps.draughts.controllers.ResumeController;
import cloudapps.draughts.models.Game;
import cloudapps.draughts.models.State;
import cloudapps.draughts.utils.YesNoDialog;

@ExtendWith(MockitoExtension.class)
class ResumeViewTest {

	@Mock
	ResumeController resumeController;

	@Mock
	YesNoDialog yesNoDialog;

    @InjectMocks
    ResumeView resumeView;
    
	@BeforeEach
	public void initMocks() {
        resumeController = new ResumeController(new Game(), new State());
		MockitoAnnotations.openMocks(this);
	}
    
    @Test
    void testGivenResumeViewWhenContinueThenClear(){
        when(yesNoDialog.read(anyString())).thenReturn(true);
		resumeView.interact(resumeController);
		verify(resumeController).reset();
    }
    
    @Test
    void testGivenResumeViewWhenNotContinueThenNext(){
        when(yesNoDialog.read(anyString())).thenReturn(false);
		resumeView.interact(resumeController);
		verify(resumeController).next();
    }
}
