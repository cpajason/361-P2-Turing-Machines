import java.io.File;
import java.io.FileNotFoundException;
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
			for (int trans = 0; trans < numSymbols; trans++) {
				StringTokenizer st = new StringTokenizer(scan.nextLine(), ",");
				while (st.hasMoreTokens()) {
					int nextState = Integer.parseInt(st.nextToken());
					int writeSymbol = Integer.parseInt(st.nextToken());
					String direction = st.nextToken();
					states[currState].addTransition(nextState, writeSymbol, direction);
				}
			}
		}
		
		input = scan.nextLine();
		
	}
	
	public void run() {
		
	}
	
}
