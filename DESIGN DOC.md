SLogo Design Document
=====

Front End (Ashley & Dennis)
===
Our GUI will utilize Swing components. Packages are listed below:

-Send to backend information from the console (Possibly in a giant string). 
We need to figure out how to represent line breaks?
Should we preprocess the comments for the backend?

-Get turtle movements from backend

-Controller: 
This class will read the input string from the TextView and pass it to the appropriate parsers for processing; stores button state and its mapped keyboard mnemonic, enable flag when pressed, etc.
listeners. 
Objects derived from ActionListener and EventListener subclasses will be instantiated when end-user interacts with IDE and always running for keystroke inputs and looking to see if they match mapped bindings.  They will then pass handle to the controller.
model.

-Turtle:
Turtle object to be instantiated in the beginning; has the following traits
movements:

	forward, back
	take in values
	rotation/orientation
	left, right
	take in values

The turtle has a set movement method

Turtle keeps track of its own coordinates

There are methods that act on the turtle

The turtle has a set attribute method (for color maybe?)


-Model:
Instantiates and manipulates a Controller object, deals with parsers

-View:
GUI will designate a components for text manipulation.

-SLogoButton:
super class: JButton

-TextView:
super class: JFrame/JTextComponent
Creates, displays, and updates a text field JComponent

-Canvas:
super class: JPanel
This content pane is implemented within a frame with super class JFrame.  The canvas object displays and updates the turtle object(s) stored in an ArrayList (to allow multiple turtle objects) and paints/re-paints on the Canvas grid by pen.
Push/pop methods in a queue for the commands sent from the backend
Can have multiple turtle objects on it?
Edge detection/no edges
A separate queue class for turtle commands?
History?



BackEnd (Willy & Grace)
===
Four main components:

--Tokenizer (class): splits strings from inputs into tokens of individual words/numbers/etc., split by white spaces

--Parser (class): uses tokens to build commands, checks to see if each string is a start to a new command, a number, etc. and instantiate each command as appropriate, and create a list of commands (which will be passed into the Executor class)

--Command (package of classes, each command represented by a class): defines each individual command (some may be recursively implemented, some commands call other commands, etc.); holds 

--Executor (class): actually executing the commands in proper order as dictated by the user; will call commands in command package sequentially


To Add a New Command:
===

1) In the command package of the Backend package, create a class for the command in the appropriate sub-package, and make sure it extends Command.

2) Be sure to implement the method execute() in your new command class, which should return a double value as appropriate.

3) Add the command string(s) and the class path to the language properties files
