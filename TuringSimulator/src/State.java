import java.util.ArrayList;

public class State {
	
	private int number;
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	private boolean halt;
	
	public State(int number) {
		this.number = number;
	}
	
	public void addTransition(int input, int nextState, int writeSymbol, String direction) {
		transitions.add(new Transition(input, nextState, writeSymbol, direction));
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	public boolean isHalt() {
		return halt;
	}

	public void setHalt(boolean halt) {
		this.halt = halt;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String toString() {
		return "" + number;
	}
	
}
