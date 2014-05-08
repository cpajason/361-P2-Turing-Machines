import java.util.ArrayList;

/**
 * This is the State class for a Turing Machine Simulator.
 * It is meant to encapsulate a state in a Turing Machine:
 * the number (label) of the state, an ArrayList of its
 * transitions, and a boolean to indicate whether this is
 * a halting state.
 * 
 * @author Jason Allen
 * @author Nathan Henninger
 * @author Matt Weaver
 *
 */
public class State {
	
	private int number;
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	private boolean halt;
	
	// Constructor
	public State(int number) {
		this.number = number;
	}
	
	/**
	 * Adds a new transition to this state.
	 * 
	 * @param input The integer to be read from the tape.
	 * @param nextState The integer value of the next state the machine must go to.
	 * @param writeSymbol The integer to be written to the tape.
	 * @param direction The string representation of the direction to move on the tape.
	 */
	public void addTransition(int input, int nextState, int writeSymbol, String direction) {
		transitions.add(new Transition(input, nextState, writeSymbol, direction));
	}

	/**
	 * Returns an ArrayList of this state's transitions.
	 * 
	 * @return transitions An ArrayList<Transition> of this state's transitions.
	 */
	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	/**
	 * Sets the transitions of this state.
	 * 
	 * @param transitions An ArrayList<Transition> of the new transitions.
	 */
	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	/**
	 * Returns a boolean which indicates whether this is a halting state.
	 * 
	 * @return halt A boolean indicating whether this is a halting state.
	 */
	public boolean isHalt() {
		return halt;
	}

	/**
	 * Sets the halting property of this transition.
	 * 
	 * @param halt A boolean indicating whether this is a halting state.
	 */
	public void setHalt(boolean halt) {
		this.halt = halt;
	}

	/**
	 * Returns the state number of this state.
	 * 
	 * @return number The integer number of this state.
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the state number of this state.
	 * 
	 * @param number The integer number of this state.
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Returns a string representation of this state.
	 * 
	 * @return The state's number as a string.
	 */
	public String toString() {
		return "" + number;
	}
	
}
