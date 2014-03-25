package backend.command.math;

import java.util.Random;

import backend.command.Command;

public class RandomCommand extends Command{
	private final static int myParameterCount = 1;
	
	public RandomCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		Random r = new Random();
		return r.nextDouble() * myParameters.get(0).execute();
	}

}
