package slogo;

import java.awt.Color;
import java.util.Date;
import java.util.List;

import frontend.View;
import backend.Backend;

/**
 * Accessible by backend, used to call commands on turtles given the turtle IDs and parameters 
 * appropriate to a specific command.
 */
public class Controller {

	private Backend myBackend;
	private View myView;
	private List<Integer> myActiveTurtleIDs;
	
	public double sendText(String s) throws InstantiationException, IllegalAccessException {
		resyncActiveTurtleIDs(); //for now, just ensure that all existing turtles are active
		double parse = myBackend.parse(s, myActiveTurtleIDs);
		myView.getCanvas().repaint();
		return parse;
	}
	
	public void sendLanguage(String language) {
		myBackend.setLanguage(language);
	}

	public void instantiate(Backend be, View v) {
		myBackend = be;
		myView = v;
		myActiveTurtleIDs = v.getCanvas().getAllTurtleIDs();
	}

	public void move(double amount, int id) {
		myView.getCanvas().getTurtle(id).move(amount);
	}

	public void rotate(double angle, int id) {
		myView.getCanvas().getTurtle(id).rotate(angle);
	}

	public void setHeading(double angle, int id){
		myView.getCanvas().getTurtle(id).setHeading(angle);
		myView.getCanvas().repaint();
	}

	public void setXY(double x, double y, int id){
		myView.getCanvas().getTurtle(id).setXY(x, y);
	}

	public void togglePen(boolean toggle, int id){
		myView.getCanvas().getTurtle(id).getPen().toggle(toggle);
	}

	public void clearAll() {
		myView.getCanvas().clear();
	}
	
	
	
	public void resyncActiveTurtleIDs() {
		myActiveTurtleIDs = myView.getCanvas().getAllTurtleIDs();
	}
	
	public void syncActiveTurtleIDs(List<Integer> newActiveTurtleIDs) {
		myActiveTurtleIDs = newActiveTurtleIDs;
	}
//	
//	public void addToActiveTurtleIDs(double id) {
//		myActiveTurtleIDs.add((int) id);
//	}
//	
//	public void deleteFromActiveTurtleID(double id) {
//		myActiveTurtleIDs.remove((int) id);
//	}
	
	public double getX(int id) {
		return myView.getCanvas().getTurtle(id).getX();
	}
	
	public double getY(int id) {
		return myView.getCanvas().getTurtle(id).getY();
	}
	
	public void moveToHome(int id) {
		myView.getCanvas().getTurtle(id).setXY(0, 0);
	}
	
	public double getHeading(int id) {
		return myView.getCanvas().getTurtle(id).getHeading();
	}
	
	public boolean isPenUp(int id) {
		return myView.getCanvas().getTurtle(id).getPen().isPenUp();
	}
	
	public double getColorIndex(int id) {
		return myView.getCanvas().getTurtle(id).getPen().getColorComponents();
	}
	
	public void setPenColor(double colorIndex, int id){
		myView.getCanvas().getTurtle(id).getPen().changeColor(new Color((int)colorIndex));
	}
	
	public void addTurtle(double id) {
		myView.getCanvas().addTurtle((int)id);
	}

}