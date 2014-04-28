import java.util.ArrayList;

public class State {
	
	private int number;
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	private boolean halt;
	
	public State(int number) {
		this.setNumber(number);
	}
	
	public void addTransition(int nextState, int writeSymbol, String direction) {
		transitions.add(new Transition(nextState, writeSymbol, direction));
	}
	
	private class Transition {
		
		private int nextState;
		private int writeSymbol;
		private String direction;
		
		public Transition(int nextState, int writeSymbol, String direction) {
			this.setNextState(nextState);
			this.setWriteSymbol(writeSymbol);
			this.setDirection(direction);
		}

		public int getNextState() {
			return nextState;
		}

		public void setNextState(int nextState) {
			this.nextState = nextState;
		}

		public int getWriteSymbol() {
			return writeSymbol;
		}

		public void setWriteSymbol(int writeSymbol) {
			this.writeSymbol = writeSymbol;
		}

		public String getDirection() {
			return direction;
		}

		public void setDirection(String direction) {
			this.direction = direction;
		}
		
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
	
}
