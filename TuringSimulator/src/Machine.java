import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This is the Machine class for a Turing Machine Simulator.
 * It is meant to encapsulate a turing machine itself with a
 * set of states, input and tape alphabets, and transition
 * functions.
 * 
 * @author Jason Allen
 * @author Nathan Henninger
 * @author Matt Weaver
 *
 */
public class Machine {
	
	State[] states;
	int numStates;
	String input;
	int numSymbols;
	
	// Constructor
	public Machine(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		
		// Number of states
		numStates = Integer.parseInt(scan.nextLine().trim());
		states = new State[numStates];
		// Number of symbols
		numSymbols = Integer.parseInt(scan.nextLine().trim());
		
		// Everything else is state transitions
		for (int currState = 0; currState < numStates - 1; currState++) {
			states[currState] = new State(currState);
			states[currState].setHalt(false);
			for (int trans = 0; trans < numSymbols + 1; trans++) {
				// Transition format: nextState,writeSymbol (currSymbol and currState come from the line #)
			  StringTokenizer st = new StringTokenizer(scan.nextLine(), ",");
				while (st.hasMoreTokens()) {
					int nextState = Integer.parseInt(st.nextToken());
					int writeSymbol = Integer.parseInt(st.nextToken());
					String direction = st.nextToken();
					states[currState].addTransition(trans, nextState, writeSymbol, direction);
				}
			}
		}
		// Set up the accept state
		states[numStates - 1] = new State(numStates - 1);
		states[numStates - 1].setHalt(true);
		if (scan.hasNextLine()) {
			input = scan.nextLine().trim();
		}
		else {
		  // Set to 0, to ensure the tape has somewhere for the tape head to point
			input = "0";
		}
	}
	
	/**
	 * Simulate execution of the Turing Machine.
	 * 
	 * @return tape An ArrayList<Integer> representation of the tape after
	 * the machine halts.
	 */
	public Tape run() {
		// convert input to an ArrayList for infinite 2-way tape
		Tape tape = new Tape(input);
		
		State currState = states[0];
		Transition currTrans = currState.getTransitions().get(tape.get());
		
		while (!currState.isHalt()) {
			int writeSymbol = currTrans.getWriteSymbol();
			String direction = currTrans.getDirection();
			
			// write the symbol for the transition
			tape.set(writeSymbol);
			
			// move L or R by changing the position
			if (direction.equals("L")) {
				tape.left();
			}
			else {
				tape.right();
			}
			
			// move to the next state
			currState = states[currTrans.getNextState()];
			if (!currState.isHalt()) {
				currTrans = currState.getTransitions().get(tape.get());
			}
			//System.out.println("Loop");
		}
		
		return tape;
	}
	
}
