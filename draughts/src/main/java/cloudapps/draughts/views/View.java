package cloudapps.draughts.views;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import cloudapps.draughts.models.Color;
import cloudapps.draughts.models.Coordinate;
import cloudapps.draughts.utils.Console;
import cloudapps.draughts.utils.YesNoDialog;

public class View {

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
    
    public View(){
    	this.console = new Console();
    	this.yesNoDialog = new YesNoDialog();
    }
    
    public String read(Color color) {
        final String titleColor = View.PROMPT.replace(View.COLOR_PARAM ,View.COLOR_VALUES[color.ordinal()]);
        return this.console.readString(titleColor);
    }

    public boolean isCanceledFormat(String string) {
        return string.equals(View.CANCEL_FORMAT);
    }

    public boolean isMoveFormat(String string) {
        return Pattern.compile(View.MOVEMENT_FORMAT).matcher(string).find();
    }

    public void writeError(){
        this.console.writeln(View.ERROR_MESSAGE);
    }

    public Coordinate[] getCoordinates(String string) {
        assert this.isMoveFormat(string);
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

    public void writeLost() {
        this.console.writeln(LOST_MESSAGE);
    }

    public void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for (int i = 0; i < DIMENSION; i++)
            this.console.write((i + 1) + "");
        this.console.writeln();
    }
    
    public void writeTitle() {
    	this.console.writeln(View.TITTLE);
    }

	public boolean playAgain() {
		return this.yesNoDialog.read(View.MESSAGE);
	}
	
	public void write(String message) {
		this.console.write(message);
	}
	
	public void writeln(String message) {
		this.console.writeln(message);
	}

}
