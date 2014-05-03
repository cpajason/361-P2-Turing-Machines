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
		numStates = Integer.parseInt(scan.nextLine());
		states = new State[numStates];
		numSymbols = Integer.parseInt(scan.nextLine());
		
		for (int currState = 0; currState < numStates - 1; currState++) {
			states[currState] = new State(currState);
			states[currState].setHalt(false);
			for (int trans = 0; trans < numSymbols; trans++) {
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
	
	public void run() {
		
		// convert input to an ArrayList for infinite 2-way tape
		ArrayList<Integer> tape = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			tape.add(Character.getNumericValue(input.charAt(i)));
		}
		
		int position = 0;
		State currState = states[position];
		Transition currTrans = currState.getTransitions().get(tape.get(position));
		
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
				// if we a legitimate input symbol to read to the right of the head, base the new transition off it
				if (tape.size() > position + 1) {
					currTrans = currState.getTransitions().get(tape.get(position + 1));
				}
				// otherwise, we know it's blank (0), so get the blank transitions
				else {
					currTrans = currState.getTransitions().get(0);
				}
			}
		}
		System.out.println(tape);
	}
	
}
