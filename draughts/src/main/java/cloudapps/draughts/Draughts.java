package cloudapps.draughts;

import cloudapps.draughts.controllers.InteractorController;
import cloudapps.draughts.controllers.Logic;

class Draughts {
    
    private Logic logic;

    private Draughts(){
        this.logic = new Logic();
    }

    private void play() {
        InteractorController controller;
		do {
			controller = this.logic.getController();
			if (controller != null)
				controller.control();
		} while (controller != null); 
    }

    public static void main(String[] args){
        new Draughts().play();
    }
    
}