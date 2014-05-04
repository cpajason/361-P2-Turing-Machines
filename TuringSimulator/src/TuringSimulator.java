import java.io.File;
import java.io.FileNotFoundException;

public class TuringSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		Machine m = new Machine(new File(args[0]));
		int score = m.run();
		System.out.println("Score: " + score);
	}

}
