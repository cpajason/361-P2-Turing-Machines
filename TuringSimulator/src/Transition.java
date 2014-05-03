
public class Transition {
		
		private int input;
		private int nextState;
		private int writeSymbol;
		private String direction;
		
		public Transition(int input, int nextState, int writeSymbol, String direction) {
			this.setInput(input);
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

		public int getInput() {
			return input;
		}

		public void setInput(int input) {
			this.input = input;
		}
		
		public String toString() {
			return "Input: " + input + ", nextState: " + nextState + ", writeSymbol: " + writeSymbol + ", direction: " + direction;
		}
		
}
