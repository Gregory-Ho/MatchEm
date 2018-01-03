/*
 * Gregory Ho
 * Computer Studies
 * ICS3U1-01
 * 23 January 2016
 * Culminating Activity
 * Game : Match' Em
 * Game Introduction:
 * The player will have to match up all the cards. The cards will be briefly revealed for 6 seconds. After the 6 seconds are up the player will have
 * to match the cards up.
 * When a card is selected the first card is shown but not the second. Your score is determined by the amount of card selections the player has made.
 * 
 * Change Log(From Prev. Version):
 * (Major)Added A Replay Button So Users Can Restart The Game And Skip The Loading Screen
 * The Loading Screen Does Not Display When Replaying The Game
 * The CountDown To Game Start Has Been Reduced
 * Game Mechanics Have Not Changed
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MemoryGame
{

	static int replaycounter = 0;
	final static JPanel background = new JPanel(); // Create the panel
	static JFrame window = new JFrame("Match eM'"); // Create the frame

	public static void Setup() throws InterruptedException
	{ // Create the
		// method that
		// is
		// essentially
		// the whole
		// game

		background.setBackground(Color.WHITE); // Set the panel to have a white
												// background

		JLabel welcome = new JLabel("Welcome!"); // Create the Label that will
													// be
													// the Welcome Text
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 72)); // Set the
																		// font
																		// of
																		// the
																		// label
																		// (size
																		// 72)

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the
																// operation
																// when user
																// clicks 'X'
		window.setResizable(false); // Dont Allow the user to rezise the window
		window.setVisible(true);// Make the frame visible
		window.setSize(1062, 820); // Set the frame's size

		background.add(Box.createRigidArea(new Dimension(1062, 300)));// Waste
																		// space
																		// to
																		// format
																		// components
		background.add(welcome); // Add the welcome label to the panel
		window.add(background);// Add the panel to the frame

		Thread.sleep(5000); // Stop execution in the current thread as a delay

	}

	public static void Game() throws InterruptedException
	{
		background.removeAll(); // Remove all components in the panel
		background.revalidate(); // Refresh the panel
		background.repaint();

		JLabel menu = new JLabel("Match Em'"); // Create the title for the
												// menu
		menu.setForeground(Color.BLUE); // Set the colour of the title
		menu.setFont(new Font("Times New Roman", Font.BOLD, 90));// Set the
																	// font
																	// of
																	// the
																	// title

		JButton start = new JButton("Start!"); // Create the Start Button
		start.setFont(new Font("Times New Roman", Font.BOLD, 48)); // Set
																	// the
																	// font
																	// of
																	// the
																	// text
																	// in
																	// the
																	// button
		start.setForeground(Color.RED);// Set the colour of the text in the
										// button
		start.setToolTipText("Click Me To Start The Game!");// Set a tip for
															// the
															// button
		start.setPreferredSize(new Dimension(600, 100)); // Set the
															// preferred
															// size of the
															// button (force
															// layout
															// manager to
															// allow the
															// button
															// to be this
															// size

		ActionListener StartClicked = new ActionListener()
		{ // Create an
			// actionListener
			// for the
			// start
			// button
			public void actionPerformed(ActionEvent e)
			{

				Thread thread1 = new Thread(new Runnable()
				{ // Put code in
					// a
					// thread so the
					// GUI
					// components
					// update from
					// the thread
					// instead of
					// the EDT
							public void run()
							{

								// Countdown to game start

								String CountNum = null; // String to hold the
														// countdown numbers
								JLabel countdown = new JLabel(CountNum); // Create
																			// the
																			// label
																			// that
																			// will
																			// display
																			// the
																			// numbers
								countdown.setFont(new Font("Times New Roman", // Set
																				// the
																				// font
										Font.BOLD, 90));
								countdown.setForeground(Color.BLACK); // Set the
																		// Font
																		// Colour

								for (int i = 3; i > 0; i--)
								{ // Iterate 1-5 so
									// assign and
									// show the
									// countdown
									// values

									CountNum = String.valueOf(i); // Convert
																	// integer
																	// to string

									countdown.setText(CountNum); // Set the text
																	// of the
																	// label

									background.removeAll(); // Remove all
															// components
									background.add(Box.createRigidArea(new Dimension( // Waste
																						// space
																						// to
																						// format
																						// the
																						// poistion
																						// of
																						// the
																						// text
											1062, 350)));

									background.add(countdown);// Add the
																// component to
																// the panel
									background.revalidate(); // Refresh the
																// panel to show
																// new changes
									background.repaint();

									try
									{
										Thread.sleep(700); // Delay execution
															// for 1 second to
															// correspond with
															// the countdown
									}
									catch (InterruptedException e1)
									{
										e1.printStackTrace();
									}
								}

								countdown.setText("Go!"); // Print 'Go!' to tell
															// the user the game
															// has begun

								background.removeAll(); // Remove all components
								background.add(Box.createRigidArea(new Dimension(1062, 350))); // Waste
																								// space
																								// to
																								// format
																								// the
																								// labels
								background.add(countdown); // Add the label to
															// the panel
								background.revalidate(); // Refresh the panel to
															// show changes
								background.repaint();

								try
								{
									Thread.sleep(300); // Pause the execution so
														// the user can see the
														// Go! text
								}
								catch (InterruptedException e1)
								{
									e1.printStackTrace();
								}

								// Show Cards for Brief time (6.5 secs)

								background.removeAll(); // Clear the components
														// of the panel
								background.revalidate();
								background.repaint();

								background.setLayout(new GridLayout(4, 7, 5, 5)); // Set
																					// the
																					// panel's
																					// layout
																					// to
																					// GridLayout
																					// with
																					// 4
																					// rows,
																					// 7
																					// columns
																					// and
																					// 5px
																					// spacing

								// Generate Random Numbers to randomzie image
								// locations
								// on screen

								final ArrayList<Integer> rndImgNum = new ArrayList<Integer>(); // Declare
																								// arrayList
								for (int i = 0; i <= 13; i++)
								{ // Assign
									// numbers
									// 0-14(image
									// file
									// names) to the
									// arrayList for
									// sorting
									rndImgNum.add(new Integer(i));
								}
								Collections.shuffle(rndImgNum); // Shuffle the
																// int
																// values in the
																// array
																// list to
																// randomize
																// card
																// placement
																// order

								final JButton[] cards = new JButton[14]; // Create
																			// the
																			// Buttons
																			// using
																			// arrays
																			// (set
																			// 1)
								final JButton[] cards2 = new JButton[14]; // Button
																			// Arrays
																			// (set
																			// 2)
								// There will be two sets so the user can match
								// the cards

								for (int i = 0; i <= 13; i++)
								{ // Iterate
									// through all
									// the Button
									// arrays and
									// set its
									// randomly
									// assigned
									// image as its
									// Icon for set
									// 1
									cards[i] = new JButton(); // Initialize the
																// button
									cards[i].setIcon(new ImageIcon(MemoryGame.class.getResource(rndImgNum.get(i)
											+ ".png")));// Assign
														// the
														// image
									cards[i].setActionCommand("cx" + (i)); // Assign
																			// an
																			// action
																			// command
																			// to
																			// each
																			// button
																			// so
																			// i
																			// can
																			// identify
																			// each
																			// button
									background.add(cards[i]); // Add the buttons
																// to the panel
								}

								// Generate the matching set of cards

								final ArrayList<Integer> rndImgNum2 = new ArrayList<Integer>(); // Declare
																								// arrayList
								for (int i = 0; i <= 13; i++)
								{ // Assign
									// numbers
									// 0-14(image
									// file
									// names) to the
									// arrayList for
									// sorting
									rndImgNum2.add(new Integer(i));
								}
								Collections.shuffle(rndImgNum2); // Shuffle the
																	// int
																	// values in
																	// the
																	// array
																	// list to
																	// randomize
																	// card
																	// placement
																	// order

								for (int i = 0; i <= 13; i++)
								{// Iterate
									// through all
									// the Button
									// arrays and
									// set its
									// randomly
									// assigned
									// image as its
									// Icon for set
									// 2

									cards2[i] = new JButton(); // Initialize the
																// button
									cards2[i].setIcon(new ImageIcon(MemoryGame.class.getResource(rndImgNum2.get(i)
											+ ".png")));// Assign
														// an
														// Image
									cards2[i].setActionCommand("cy" + (i));// Assign
																			// an
																			// action
																			// command
																			// to
																			// each
																			// button
																			// so
																			// i
																			// can
																			// identify
																			// each
																			// button
																			// later
									background.add(cards2[i]); // Add the
																// Buttons to
																// the panel
								}

								for (int i = 0; i <= 13; i++)
								{ // Iterate
									// through each
									// array for
									// each set and
									// set their
									// border to
									// empty so the
									// button is
									// only a
									// imageIcon
									// with no
									// borders
									cards[i].setBorder(BorderFactory.createEmptyBorder());
									cards2[i].setBorder(BorderFactory.createEmptyBorder());
								}

								// Refresh the window so that the user will be
								// able to see the Cards for 6.5 seconds

								background.revalidate();
								background.repaint();

								try
								{
									Thread.sleep(8000); // Delay so user can see
														// the cards
								}
								catch (InterruptedException e1)
								{
									e1.printStackTrace();
								}

								for (int i = 0; i <= 13; i++)
								{ // Iterate
									// through each
									// array and set
									// its ImageIcon
									// to the
									// backside of a
									// card to hide
									// the cards
									cards[i].setIcon(new ImageIcon(MemoryGame.class.getResource("cover.png")));
									cards2[i].setIcon(new ImageIcon(MemoryGame.class.getResource("cover.png")));
								}

								ActionListener match = new ActionListener()
								{ // Create
									// the
									// ActionListener
									// that
									// will
									// register
									// when
									// the
									// user
									// clicks
									// on
									// a
									// card

									int cardsPicked = 0; // Keep track if the
															// user has already
									Integer fCardImg; // Keep track of the card
									// image for the: First
									// Selection
									int sCardImg; // Second Selection to compare
									int fCardArryIndx; // Keep track of the
														// array's Index for
														// each card selection
														// so i can change its
														// ImageIcon later
									int sCardArryIndx; // Second card's array
														// Index
									int score = 0; // Keep track of the amount
													// of clicks the user has
													// made, that will be its
													// Score at the end of the
													// game
									int cardsLeft = 14; // Keep track of the
														// amout of card matches
														// left so i know when
														// to show the End of
														// Game screen
									String fClickCardSet; // Keep track of the
															// set of cards of
															// the card that the
															// user selected for
															// : First selection
									String sClickCardSet;// Second Selection
									String fCardID = " "; // Keep track of the
															// card's
															// actionCommand so
															// that i know if
															// the user has
															// clicked the same
															// card, otherwise
															// the program will
															// register that as
															// a match
									String sCardID = ""; // This is get rid of
															// one of the bugs
															// in the game

									// User Cant Click Same Card Twice to
									// Remove it

									public void actionPerformed( // What to do
																	// when a
																	// card is
																	// clicked
											ActionEvent ButtonID)
									{

										score++; // Add one to the score(user
													// has clicked once)
										cardsPicked++; // Add one to the number
														// of cards picked to
														// keep track if the
														// user is picking its
														// first or second card
														// to match

										// First Card Choice

										if (cardsPicked == 1)
										{ // Register that
											// its the
											// user's first
											// card
											// selection
											String actionCommandID = ButtonID // Get
																				// the
																				// Action
																				// Command
																				// of
																				// the
																				// card
													.getActionCommand();
											fCardID = actionCommandID; // Store
																		// the
																		// action
																		// command
																		// to
																		// remove
																		// same
																		// card
																		// clicked
																		// bug
											String arrayID = actionCommandID // Figure
																				// out
																				// which
																				// set
																				// of
																				// cards
																				// the
																				// card
																				// selected
																				// belongs
																				// to
													.substring(0, 2);
											if (arrayID.equals("cx"))
											{ // Card
												// belongs
												// to
												// first
												// set
												arrayID = actionCommandID // Get
																			// the
																			// card's
																			// button
																			// index
																			// which
																			// corresponds
																			// to
																			// the
																			// index
																			// of
																			// the
																			// arraylist
																			// holding
																			// the
																			// shuffled
																			// image
																			// numbers
														.substring(2);
												cards[Integer.parseInt(arrayID)]
														.setIcon(new ImageIcon(MemoryGame.class.getResource(rndImgNum
																.get(Integer.parseInt(arrayID))
																+ ".png"))); // Set
												// the
												// card's
												// imageIcon
												// to
												// its
												// revealed
												// ImageIcon

												fCardImg = rndImgNum.get(Integer // Assign
																					// the
																					// image
																					// number
																					// to
																					// compare
																					// later
														.parseInt(arrayID));
												fCardArryIndx = (Integer.parseInt(arrayID)); // Store
																								// the
																								// array's
																								// Index
												fClickCardSet = "cx"; // Store the
																		// set ID
																		// value

												background.revalidate(); // Refresh
																			// the
																			// panel
												background.repaint();

											}
											else if (arrayID.equals("cy"))
											{ // Card
												// belongs
												// to
												// the
												// second
												// set
												// of
												// cards
												arrayID = actionCommandID // Get the
																			// Index
																			// value
																			// of
																			// the
																			// card's
																			// button
																			// and
																			// arrayList
																			// index
																			// ID
														.substring(2);
												cards2[Integer.parseInt(arrayID)].setIcon(new ImageIcon(
														MemoryGame.class.getResource(rndImgNum2.get(Integer
																.parseInt(arrayID))
																+ ".png"))); // Switch
																				// imageIcons
																				// to
																				// the
																				// cards
																				// revealed
																				// imageIcon
																				// (cover
																				// ->
																				// card
																				// image)

												fCardImg = rndImgNum2.get(Integer.parseInt(arrayID)); // Store
																										// the
																										// image
																										// number
												fCardArryIndx = (Integer.parseInt(arrayID)); // Store
																								// the
																								// card's
																								// array
																								// Index
												fClickCardSet = "cy"; // Store the
																		// set ID
																		// value

												background.revalidate(); // Refresh
																			// the
																			// panel
												background.repaint();
											}
										}

										// Second Card Choice

										else if (cardsPicked == 2)
										{ // Register
											// that the
											// card
											// selected
											// it the
											// user's
											// second
											// choice
											String actionCommandID = ButtonID.getActionCommand(); // Get
																									// the
																									// actionCommand
																									// of
																									// the
																									// card
																									// selected
											sCardID = actionCommandID; // Store the
																		// action
																		// command
																		// to remove
																		// the same
																		// card
																		// selected
																		// bug
											if (fCardID == sCardID)
											{ // If the user
												// has
												// selected
												// the same
												// card do
												// nothing
												// except
												// subtract
												// the added
												// score and
												// cardsPicked
												// values
												score--;
												cardsPicked--;
											}
											else
											{ // User has selected two
												// different cards (valid)
												String arrayID = actionCommandID.substring(0, 2); // Get
																									// the
																									// set
																									// ID
																									// value
												if (arrayID.equals("cx"))
												{ // Card
													// is of
													// set 1
													arrayID = actionCommandID.substring(2); // Get
																							// the
																							// Index
																							// values
													cards[Integer.parseInt(arrayID)].setIcon(new ImageIcon(
															MemoryGame.class.getResource(rndImgNum.get(Integer
																	.parseInt(arrayID))
																	+ ".png"))); // Switch
																					// ImageIcons
																					// from
																					// cover
																					// to
																					// actual
																					// card
																					// image

													sCardImg = rndImgNum.get(Integer.parseInt(arrayID)); // Store
																											// the
																											// image
																											// number
													sCardArryIndx = (Integer.parseInt(arrayID)); // Store
																									// the
																									// card's
																									// array
																									// Index
													sClickCardSet = "cx"; // Store
																			// the
																			// set's
																			// ID
																			// value

													cardsPicked = 0; // Reset the
																		// cardsPicked
																		// value to
																		// 0 so the
																		// user can
																		// pick
																		// another
																		// two cards
																		// to match

												}
												else if (arrayID.equals("cy"))
												{ // Card
													// is
													// of
													// set
													// 2
													arrayID = actionCommandID.substring(2); // Get
																							// the
																							// Index
																							// values
													cards2[Integer.parseInt(arrayID)].setIcon(new ImageIcon(
															MemoryGame.class.getResource(rndImgNum2.get(Integer
																	.parseInt(arrayID))
																	+ ".png"))); // Switch
																					// ImageIcons
																					// to
																					// the
																					// card's
																					// actual
																					// image

													sCardImg = rndImgNum2.get(Integer.parseInt(arrayID)); // Store
																											// the
																											// image
																											// number
													sCardArryIndx = (Integer.parseInt(arrayID));// Store
																								// the
																								// card's
																								// array
																								// Index
													sClickCardSet = "cy"; // Store
																			// the
																			// set's
																			// ID
																			// value

													cardsPicked = 0; // Reset the
																		// cardsPicked
																		// value to
																		// 0 so the
																		// user can
																		// pick
																		// another
																		// two cards
																		// to match

												}

												background.revalidate(); // Refresh
																			// the
																			// panel
												background.repaint();

												// Logic for determining if the
												// cards picked are matching

												// Matching Card
												if (fCardImg == sCardImg)
												{ // Image
													// numbers
													// are
													// the
													// same,
													// it's
													// a
													// match

													if (fClickCardSet.equals("cx"))
													{ // Frist
														// Card
														// is
														// from
														// set
														// 1
														cards[fCardArryIndx].setIcon(new ImageIcon(MemoryGame.class
																.getResource("blank.png"))); // Make
																								// the
																								// card
																								// disapear
																								// so
																								// i
																								// can
																								// keep
																								// the
																								// cards
																								// in
																								// it's
																								// original
																								// order
																								// due
																								// to
																								// FlowLayout
														cards[fCardArryIndx].setVisible(false); // Hide
																								// the
																								// component
																								// so
																								// the
																								// user
																								// can't
																								// click
																								// on
																								// the
																								// button
													}
													else if (fClickCardSet.equals("cy"))
													{ // First
														// Card
														// is
														// from
														// set
														// 2
														cards2[fCardArryIndx].setIcon(new ImageIcon(MemoryGame.class
																.getResource("blank.png"))); // Make
														// the
														// card
														// disapear
														cards2[fCardArryIndx].setVisible(false); // Hide
																									// the
																									// component
													}

													if (sClickCardSet.equals("cx"))
													{ // Second
														// card
														// is
														// from
														// set
														// 1
														cards[sCardArryIndx].setIcon(new ImageIcon(MemoryGame.class
																.getResource("blank.png"))); // Make
														// the
														// card
														// disapear
														cards[sCardArryIndx].setVisible(false); // Hide
																								// the
																								// component
													}
													else if (sClickCardSet.equals("cy"))
													{ // Second
														// card
														// is
														// from
														// set
														// 2
														cards2[sCardArryIndx].setIcon(new ImageIcon(MemoryGame.class
																.getResource("blank.png"))); // Make
														// the
														// card
														// disapear
														cards2[sCardArryIndx].setVisible(false);// Hide
																								// the
																								// component
													}

													cardsLeft--; // Subtract 1 from
																	// the amout of
																	// possible card
																	// matches so i
																	// know
																	// when the game
																	// is over(no
																	// more cards to
																	// match)

													// Player has matched up all
													// cards-
													// Game Over!

													if (cardsLeft == 0)
													{ // Tells
														// me
														// there
														// are
														// no
														// more
														// cards
														// remaining
														// for
														// the
														// user
														// to
														// match.
														// The
														// Game
														// is
														// now
														// over
														background.removeAll();// Clear
																				// the
																				// screen,
																				// remove
																				// components
																				// and
																				// refresh
																				// the
																				// screen
														background.revalidate();
														background.repaint();

														JLabel congrats = new JLabel(); // Create
																						// a
																						// new
																						// label
																						// that
																						// will
																						// show
																						// a
																						// congratulations
																						// image
														congrats.setIcon(new ImageIcon(MemoryGame.class
																.getResource("congrats.png"))); // Assign
																								// the
														// congratulations
														// image

														JLabel results = new JLabel(); // Create
																						// a
																						// new
																						// label
																						// that
																						// will
																						// give
																						// the
																						// player
																						// his/her
																						// results
														results.setText("You Matched eM' With A Score of " + score); // Tell
																														// the
																														// user
																														// their
																														// results
														results.setFont(new Font("Times New Roman", Font.BOLD, 42)); // Set
																														// the
																														// font
																														// of
																														// the
																														// results

														JButton replay = new JButton("Play Again!"); // Create
																										// the
																										// Play
																										// Again
																										// Button
														replay.setFont(new Font("Times New Roman", Font.BOLD, 48)); // Set
																													// the
																													// font
																													// of
																													// the
																													// text
																													// in
																													// the
																													// button
														replay.setForeground(Color.BLUE);// Set
																							// the
																							// colour
																							// of
																							// the
																							// text
																							// in
																							// the
																							// button
														replay.setToolTipText("Click Me To Play The Game Again!");// Set
																													// a
																													// tip
																													// for
																													// the
														// button
														replay.setPreferredSize(new Dimension(600, 100)); // Set
																											// the
																											// preferred
																											// size
																											// of
																											// the
																											// button
																											// (force
																											// layout
																											// manager
																											// to
																											// allow
																											// the
																											// button
																											// to
																											// be
																											// this
																											// size
														ActionListener ReplayClicked = new ActionListener()
														{ // Create
															// an
															// //
															// actionListener
															// for the replay
															// button
															public void actionPerformed(ActionEvent e)
															{
																// Thread thread2 = new
																// Thread(new Runnable()
																// {
																// public void run() {
																replaycounter = 1;
																System.out.println(replaycounter);
																try
																{
																	Game();
																}
																catch (InterruptedException e1)
																{

																	e1.printStackTrace();
																}
																// }
																// });
															}
															//
														};

														replay.addActionListener(ReplayClicked);// Add
																								// actionlistener
																								// to
																								// replay
																								// button

														background.setLayout(new FlowLayout()); // Reset
																								// the
																								// layout
																								// manager
																								// to
																								// FlowLayout
														background.add(Box.createRigidArea(new Dimension(1062, 200))); // Waste
																														// space
																														// to
																														// format
																														// the
																														// labels
														background.add(congrats); // Add
																					// the
																					// congrats
																					// image
																					// label
														background.add(Box.createRigidArea(new Dimension(1062, 100))); // Waste
																														// space
																														// to
																														// format
																														// the
																														// labels
														background.add(results);// Add
																				// the
																				// results
																				// component
														background.add(Box.createRigidArea(new Dimension(1062, 75)));
														background.add(replay);

													}
												}

												// Non-Matching Card

												else if (fCardImg != sCardImg)
												{ // The
													// Cards
													// selected
													// are
													// not
													// the
													// same,
													// they
													// do
													// not
													// match,
													// cover
													// the
													// cards
													// again
													// and
													// let
													// user
													// re-try
													if (fClickCardSet.equals("cx"))
													{ // Card
														// is
														// from
														// set
														// 1
														cards[fCardArryIndx].setIcon(new ImageIcon(MemoryGame.class
																.getResource("cover.png"))); // Reset
														// the
														// IconImage
														// of
														// the
														// button
														// to
														// the
														// cover
														// image

													}
													else if (fClickCardSet.equals("cy"))
													{ // Card
														// is
														// from
														// set
														// 2
														cards2[fCardArryIndx].setIcon(new ImageIcon(MemoryGame.class
																.getResource("cover.png")));// Reset
														// the
														// IconImage
														// of
														// the
														// button
														// to
														// the
														// cover
														// image

													}

													if (sClickCardSet.equals("cx"))
													{ // Card
														// is
														// from
														// set
														// 1
														cards[sCardArryIndx].setIcon(new ImageIcon(MemoryGame.class
																.getResource("cover.png")));// Reset
														// the
														// IconImage
														// of
														// the
														// button
														// to
														// the
														// cover
														// image

													}
													else if (sClickCardSet.equals("cy"))
													{ // Card
														// is
														// from
														// set
														// 2
														cards2[sCardArryIndx].setIcon(new ImageIcon(MemoryGame.class
																.getResource("cover.png")));// Reset
														// the
														// IconImage
														// of
														// the
														// button
														// to
														// the
														// cover
														// image

													}

												}

											}
										}
									}
								};

								for (int i = 0; i < cards.length; i++)
								{ // Add
									// Actionlistener
									// to
									// each
									// Button
									// in
									// the
									// two
									// arrays
									cards[i].addActionListener(match);
									cards2[i].addActionListener(match);
								}

								background.revalidate(); // Refresh panel
								background.repaint();

							}
						});

				thread1.start(); // Start Thread 1 (bulk of code)

			}
		};

		start.addActionListener(StartClicked); // Add an actionlistener for
												// the
												// Start Button

		background.add(Box.createRigidArea(new Dimension(1062, 200)));// Waste
																		// space
																		// to
																		// format
																		// text
		background.add(menu);// Add label to panel
		background.add(Box.createRigidArea(new Dimension(1062, 200)));// Waste
																		// space
																		// to
																		// format
																		// text
		background.add(start);// Add Start Button
		window.revalidate(); // Refresh Frame

		// } while (replaycounter == 0);
	}

	public static void main(String[] args) throws InterruptedException
	{
		Setup();// Run The Setup
		Game(); // Run The Game

	}

}
