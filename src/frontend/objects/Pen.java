package frontend.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Pen {

	private List<Coords> myPath = new ArrayList<Coords>();
	private Color myColor = Color.BLACK;
	private boolean PEN_UP = true;

	public Pen(Turtle t) {
		if(PEN_UP){
			myPath.add(new Coords(t.getX(), t.getY()));
		}
	}

	public void addTurtleCoords(double x, double y) {
		if(PEN_UP){
			myPath.add(new Coords(x,y));
		}
	}

	public void toggle(boolean toggle){
		PEN_UP = toggle;
	}
	
	public boolean isPenUp() {
		return PEN_UP;
	}

	public void changeColor(Color c) {
		myColor = c;
	}
	
	public double getColorComponents() {
		return myColor.getRGB();
	}

	public void paint(Graphics g) {
		if(myPath.size() > 1){
			for(int i = 1; i < myPath.size(); i++){
				g.setColor(myColor);
				g.drawLine((int)myPath.get(i).getX(), (int)myPath.get(i).getY(), (int)myPath.get(i-1).getX(), (int)myPath.get(i-1).getY());
			}
		}
	}

}