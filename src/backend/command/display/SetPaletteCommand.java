package backend.command.display;

import backend.command.Command;

public class SetPaletteCommand extends Command {
	private static final int myParameterCount = 4;
	
	public SetPaletteCommand(){
		super(myParameterCount);
	}
	
	public double execute(){
		double colorIndex = myParameters.get(0).execute(); //Color index
		double r = myParameters.get(1).execute(); //r
		double g = myParameters.get(2).execute(); //g
		double b = myParameters.get(3).execute(); //b
		//myController.updatePalette(colorIndex, r, g, b);
		//code not finished because frontend has not allowed for colors to be added to the palette
		return colorIndex;
	}
}
