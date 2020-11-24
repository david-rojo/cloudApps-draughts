package cloudapps.draughts.views;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import cloudapps.draughts.controllers.InteractorController;
import cloudapps.draughts.controllers.InteractorControllersVisitor;
import cloudapps.draughts.controllers.PlayController;
import cloudapps.draughts.controllers.ResumeController;
import cloudapps.draughts.controllers.StartController;
import cloudapps.draughts.models.Color;
import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.models.Error;
import cloudapps.draughts.models.Piece;
import cloudapps.draughts.utils.Console;
import cloudapps.draughts.utils.YesNoDialog;

public class View implements InteractorControllersVisitor {

	private static final String TITTLE = "Draughts";
	private static final String MESSAGE = "¿Queréis jugar otra";
	private static final String COLOR_PARAM = "#color";
    private static final String[] COLOR_VALUES = { "blancas", "negras" };
    private static final String PROMPT = "Mueven las " + View.COLOR_PARAM + ": ";
    private static final String CANCEL_FORMAT = "-1";
    private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
    private static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";
    private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
    
    private Console console;
    private YesNoDialog yesNoDialog;
    private String string;
    
    public View(){
    	this.console = new Console();
    	this.yesNoDialog = new YesNoDialog();
    }

    public void interact(InteractorController controller) {
        assert controller != null;
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        assert startController != null;
        this.console.writeln(View.TITTLE);
        this.write(startController);
        startController.start();
    }

    @Override
    public void visit(PlayController playController) {
        assert playController != null;
        Error error;
        do {
            error = null;
            this.string = this.read(playController.getColor());
            if (this.isCanceledFormat())
                playController.cancel();
            else if (!this.isMoveFormat()) {
                error = Error.BAD_FORMAT;
                this.writeError();
            } else {
                error = playController.move(this.getCoordinates());
                this.write(playController);
                if (error == null && playController.isBlocked())
                    this.writeLost();
            }
        } while (error != null);
    }

    @Override
    public void visit(ResumeController resumeController) {
        assert resumeController != null;
        if (this.yesNoDialog.read(View.MESSAGE))
            resumeController.reset();
        else
            resumeController.next();
    }
    
    private String read(Color color) {
        final String titleColor = View.PROMPT.replace(View.COLOR_PARAM ,View.COLOR_VALUES[color.ordinal()]);
        return this.console.readString(titleColor);
    }

    private boolean isCanceledFormat() {
        return string.equals(View.CANCEL_FORMAT);
    }

    private boolean isMoveFormat() {
        return Pattern.compile(View.MOVEMENT_FORMAT).matcher(string).find();
    }

    private void writeError(){
        this.console.writeln(View.ERROR_MESSAGE);
    }

    private Coordinate[] getCoordinates() {
        assert this.isMoveFormat();
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        while (string.length() > 0){
            coordinateList.add(Coordinate.getInstance(string.substring(0, 2)));
            string = string.substring(2, string.length());
            if (string.length() > 0 && string.charAt(0) == '.')
                string = string.substring(1, string.length());
        }
        Coordinate[] coordinates = new Coordinate[coordinateList.size()];
        for(int i=0; i< coordinates.length; i++){
            coordinates[i] = coordinateList.get(i);
        }
        return coordinates;
    }

    private void writeLost() {
        this.console.writeln(LOST_MESSAGE);
    }
    
    void write(InteractorController controller) {
        assert controller != null;
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        for (int i = 0; i < DIMENSION; i++)
            this.writePiecesRow(i, controller);
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for (int i = 0; i < DIMENSION; i++)
            this.console.write((i + 1) + "");
        this.console.writeln();
    }

    private void writePiecesRow(final int row, InteractorController controller) {
        this.console.write((row + 1) + "");
        for (int j = 0; j < controller.getDimension(); j++) {
            Piece piece = controller.getPiece(new Coordinate(row, j));
            if (piece == null)
                this.console.write(" ");
            else 
                this.console.write(piece.getCode());
        }
        this.console.writeln((row + 1) + "");
    }

}
