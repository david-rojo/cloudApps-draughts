package cloudapps.draughts.views;

import cloudapps.draughts.controllers.ResumeController;
import cloudapps.draughts.utils.YesNoDialog;

class ResumeView extends SubView {

    private static final String MESSAGE = "¿Queréis jugar otra";
    
    private YesNoDialog yesNoDialog;

    ResumeView(){
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    void interact(ResumeController resumeController) {
        assert resumeController != null;
        if (this.yesNoDialog.read(ResumeView.MESSAGE))
            resumeController.reset();
        else
            resumeController.next();
    }

}
