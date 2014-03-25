package backend.command;

import java.util.ArrayList;

/**
 * Allows backend to recognize an opening square bracket as the beginning of a chain of commands
 * which are somehow related/packaged together
 */
public class Bracket extends Command {
	private ArrayList<Double> myValues; 
	
	public Bracket(){
		super();
		myValues = new ArrayList<Double>();
		myParameterCount = Integer.MAX_VALUE;
	}

	@Override
	public double execute() {
		for(Parameter p : myParameters){
			p.setRepCount(myRepcount);
			double pFinal = p.execute();
//			System.out.println("final value of p: " + pFinal);
			myValues.add(pFinal);
		}
		if(myValues.size() < 2)
			return 0;
		else {
			return myValues.get(myValues.size() - 2);
		}
	}
	

	public boolean equals(Object obj){
		Bracket s = (Bracket)obj;
		return this.myParameters.equals(s.myParameters);
	}

}
