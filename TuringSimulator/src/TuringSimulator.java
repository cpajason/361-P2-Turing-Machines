import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This is the driver class for a Turing Machine Simulator.
 * 
 * @author Jason Allen
 * @author Nathan Henninger
 * @author Matt Weaver
 *
 */
public class TuringSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 1) {
		  System.err.println("Usage: java TuringSimulator filename");
		  System.exit(0);
		}
	  
		Machine m = null;
		try {
		m = new Machine(new File(args[0]));
		}
		catch (Exception e){
			System.err.println("Could not open file.");
			System.exit(1);
		}
		
		// Since we got this far, we can safely assume m != null
		Tape tape = m.run();
		System.out.println("run() complete.");
		tape.reset();
		int score = 0;
		while (tape.hasRight()) {
			int cellContents = tape.get();
			score += cellContents;
			System.out.print(cellContents);
			tape.right();
		}
		System.out.println();
		System.out.println("score:" + score);
	}

}
