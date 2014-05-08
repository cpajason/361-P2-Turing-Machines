/**
 * This is the Transition class for a Turing Machine Simulator.
 * It is meant to encapsulate a delta function in a Turing Machine:
 * the tape input, the next state the machine moves to, the output
 * to the tape, and the direction to move on the tape.
 * 
 * @author Jason Allen
 * @author Nathan Henninger
 * @author Matt Weaver
 *
 */
public class Transition {
		
		private int input;
		private int nextState;
		private int writeSymbol;
		private String direction;
		
		// Constructor
		public Transition(int input, int nextState, int writeSymbol, String direction) {
			this.setInput(input);
			this.setNextState(nextState);
			this.setWriteSymbol(writeSymbol);
			this.setDirection(direction);
		}

		/**
		 * Returns the next state
		 * 
		 * @return nexState An integer representing the next state.
		 */
		public int getNextState() {
			return nextState;
		}

		/**
		 * Sets the next state
		 * 
		 * @param nextState An integer representing the next state.
		 */
		public void setNextState(int nextState) {
			this.nextState = nextState;
		}

		/**
		 * Returns the member of the tape alphabet which is written during the
		 * execution of this transition.
		 * 
		 * @return writeSymbol An integer to write on the tape.
		 */
		public int getWriteSymbol() {
			return writeSymbol;
		}

		/**
		 * Sets the member of the tape alphabet which is written during the
		 * execution of this transition.
		 * 
		 * @param writeSymbol An integer to write on the tape.
		 */
		public void setWriteSymbol(int writeSymbol) {
			this.writeSymbol = writeSymbol;
		}

		/**
		 * Returns the direction to move on the tape during the
		 * execution of this transition, either "L" or "R."
		 * 
		 * @return direction A String representing left or right.
		 */
		public String getDirection() {
			return direction;
		}

		/**
		 * Sets the direction to move on the tape during the
		 * execution of this transition, either "L" or "R."
		 * 
		 * @param direction A string representing left or right.
		 */
		public void setDirection(String direction) {
			this.direction = direction; // TODO could use some input validation
		}

		/**
		 * Returns the tape input specific to this transition function.
		 * 
		 * @return input An integer representing what is read from the tape,
		 * specific to this transition function.
		 */
		public int getInput() {
			return input;
		}

		/**
		 * Sets the tape input specific to this transition function.
		 * 
		 * @param input An integer representing what is read from the tape,
		 * specific to this transition function.
		 */
		public void setInput(int input) {
			this.input = input;
		}
		
		/**
		 * Returns a string representation of this transition.
		 * 
		 * @return A string listing all the elements of this transition.
		 */
		public String toString() {
			return "Input: " + input + ", nextState: " + nextState + ", writeSymbol: " + writeSymbol + ", direction: " + direction;
		}
		
}
