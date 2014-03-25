package frontend.workspace;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import frontend.Canvas;
import frontend.View;

public class MenuView extends JMenuBar{
	private static View myView;
	private JMenu myFiles;
	private JMenu myPreferences;
	private JMenu myHelp;
	private Canvas myCanvas;

	
	public MenuView(View v) {
		myView = v;
		myCanvas = v.getCanvas();
		addMenus();
		setVisible(true);
	}
	
	//ignore for now
	public MenuView(String title) {
		super();
	}

	private void addMenus() {
		this.add(createFilesMenu());
		this.add(createPreferencesMenu());
		this.add(createHelpMenu());
	}

	private JFileChooser getFileChooser() {
		return myView.getChooser();
	}
	
	private JMenu createFilesMenu() {
		myFiles = new JMenu("Files");
		myFiles.setMnemonic('F');
		
		final JMenuItem FILES_LOAD = new JMenuItem("Load file");
		FILES_LOAD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myView.createNewWorkspace();
			}
		});
		
		final JMenuItem FILES_SAVE = new JMenuItem("Save file");
		FILES_SAVE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myView.saveFile();
			}
		});

		final JMenuItem FILES_EXIT = new JMenuItem("EXIT");
		FILES_EXIT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myView.quit();
				JOptionPane.showMessageDialog(FILES_EXIT, "Exit-->booyah!");
			}
		});

		myFiles.add(FILES_LOAD);
		myFiles.add(FILES_SAVE);
		myFiles.add(FILES_EXIT);
		
		return myFiles;
	}
	
	private JMenu createPreferencesMenu() {
		myPreferences = new JMenu("Preferences");
		myPreferences.setMnemonic('P');

		final JMenuItem PREF_LOAD = new JMenuItem("Load preferences");
		PREF_LOAD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		final JMenuItem PREF_SAVE = new JMenuItem("Save preferences");
		PREF_SAVE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
		final JMenuItem PREF_COLOR = new JMenuItem("Change pen color");
		PREF_COLOR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JColorChooser.showDialog(new JFrame(), "Pick your color", Color.PINK);
			}
		});

		final JMenuItem PREF_IMAGE = new JMenuItem("Change turtle image");
		PREF_IMAGE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(myCanvas);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					BufferedImage img = null;
					try {
						img = ImageIO.read(new File(chooser.getSelectedFile().getAbsolutePath()));
						myCanvas.changeTurtle(img);
					} catch (IOException e1) {
						//TODO
					}
				}
			}           
		});
		
		myPreferences.add(PREF_LOAD);
		myPreferences.add(PREF_SAVE);
		myPreferences.add(PREF_COLOR);
		
		return myPreferences;
	}
	
	private JMenu createHelpMenu() {
		myHelp = new JMenu("Help");
		myHelp.setMnemonic('H');
		
		final JMenuItem HELP_COMMANDS = new JMenuItem("Help");
		HELP_COMMANDS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
	                String url = 
	                        "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
	                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	            }
	            catch (java.io.IOException error) {
	                System.out.println(error.getMessage());
	            }
			}
		});
		
		myHelp.add(HELP_COMMANDS);
		
		return myHelp;
	}

	protected void initUI() {
		JFrame frame = new JFrame(MenuView.class.getSimpleName());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MenuView(myView).initUI();
			}
		});
	}
}
