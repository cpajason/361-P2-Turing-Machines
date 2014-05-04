import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Machine {
	
	State[] states;
	int numStates;
	String input;
	int numSymbols;
	
	public Machine(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		numStates = Integer.parseInt(scan.nextLine().trim());
		states = new State[numStates];
		numSymbols = Integer.parseInt(scan.nextLine().trim());
		
		for (int currState = 0; currState < numStates - 1; currState++) {
			states[currState] = new State(currState);
			states[currState].setHalt(false);
			for (int trans = 0; trans < numSymbols + 1; trans++) {
				StringTokenizer st = new StringTokenizer(scan.nextLine(), ",");
				while (st.hasMoreTokens()) {
					int nextState = Integer.parseInt(st.nextToken());
					int writeSymbol = Integer.parseInt(st.nextToken());
					String direction = st.nextToken();
					states[currState].addTransition(trans, nextState, writeSymbol, direction);
				}
			}
		}
		states[numStates - 1] = new State(numStates - 1);
		states[numStates - 1].setHalt(true);
		if (scan.hasNextLine()) {
			input = scan.nextLine().trim();
		}
		else {
			input = "0";
		}
	}
	
	public int run() {
		
		// convert input to an ArrayList for infinite 2-way tape
		ArrayList<Integer> tape = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			tape.add(Character.getNumericValue(input.charAt(i)));
		}
		
		int position = 0;
		State currState = states[position];
		Transition currTrans = currState.getTransitions().get(tape.get(position));
		System.out.println("" + currState.getNumber());
		
		while (!currState.isHalt()) {
			
			int writeSymbol = currTrans.getWriteSymbol();
			String direction = currTrans.getDirection();
			
			// write the symbol for the transition
			tape.set(position, new Integer(writeSymbol));
			
			// move L or R by changing the position
			if (direction.equals("L")) {
				position -= 1;
			}
			else {
				position += 1;
			}
			
			// if we are off the known tape, we must add a blank spot on the tape (0 in this program)
			if (position < 0) {
				tape.add(0, new Integer(0));
				position = 0;
			}
			if (position >= tape.size()) {
				tape.add(new Integer(0));
			}
			
			// move to the next state
			currState = states[currTrans.getNextState()];
			if (!currState.isHalt()) {
				currTrans = currState.getTransitions().get(tape.get(position));
			}
			
			System.out.println("" + currState.getNumber());
		}
		int score = 0;
		for (int i = 0; i < tape.size(); i++) {
			score += tape.get(i);
		}
		
		return score;
	}
	
}
