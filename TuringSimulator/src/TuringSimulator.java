import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TuringSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length == 0) {
		  System.err.println("Usage: java TuringSimulator filename");
		  System.exit(0);
		}
	  
		Machine m = new Machine(new File(args[0]));
	  ArrayList<Integer> tape = m.run();
		
		int score = 0;
    for (int i = 0; i < tape.size(); i++) {
      int cellContents = tape.get(i);
      System.out.print(cellContents);
      score += cellContents;
    }
    System.out.println();
		
		System.out.println("Score: " + score);
	}

}
