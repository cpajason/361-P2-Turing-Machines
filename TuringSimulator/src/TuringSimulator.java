import java.io.File;
import java.io.FileNotFoundException;

public class TuringSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		Machine m = new Machine(new File(args[0]));
	}

}
