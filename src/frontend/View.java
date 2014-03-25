package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import frontend.workspace.MenuView;
import frontend.workspace.TabPanel;
import slogo.Controller;

@SuppressWarnings("serial")
public class View extends JFrame{
	private static final Dimension DEFAULT_BOUNDS = new Dimension(500,500);
	private int myWorkspaceCount = 0;
	private ArrayList<View> myWorkspaces;
	private JLabel myPosition, myHeading, myId;
	private JFileChooser myChooser;
	private JTabbedPane TABS;
	private int TAB_COUNT = 1;
	private Controller myController;
	private Canvas CURRENT_CANVAS;
	private TabPanel CURRENT_TAB;
	
	//private List<Workspace> myWorkSpaces = new ArrayList<Workspace>();

	public View (Controller c, Dimension bounds) {
		//myResources = ResourceBundle.getBundle();
		myController = c;
		TABS = new JTabbedPane();
		CURRENT_TAB = new TabPanel(myController, this);
		TABS.addTab("Tab" + (TABS.getTabCount() + 1) , CURRENT_TAB);
		this.setJMenuBar(new MenuView(this));
		this.getContentPane().add(TABS);
		
		pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

	//we can replace this with message Dialog (popup from JFrame), 
	//take in parameter ResourceBundle/Constants file and search for Error message string
//	public void showMessage (String message) {
//		myHistoryTextArea.append(message + "\n");
//	}
//
//	public void clearCommands () {
//		myHistoryTextArea.append("");
//	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	public Canvas getCanvas(){
		return CURRENT_TAB.getCanvas();
	}
	
	public void addTab(){
		TabPanel tab = new TabPanel(myController, this);
		TABS.addTab("Tab" + (TABS.getTabCount() + 1) , tab);
		
	}
	
	public void createNewWorkspace() {
		myWorkspaceCount++;
		View v = new View(myController, DEFAULT_BOUNDS);
		TABS.addTab("Workspace " + myWorkspaceCount, v);
		myWorkspaces.add(v);
	}

	public JFileChooser getChooser() {
		return myChooser;
	}
}
