import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StrLineAppender {


	private static final String NL = System.getProperty("line.separator");

	public static void main(final String[] args) {

		final File left = new File(args[0]);
		final File right = new File(args[0]);
		final File combined = new File(System.getProperty("user.home") + "/combinedFile.txt");

		FileWriter combyWriter = null;
		try {
			combyWriter = new FileWriter(combined);
		}
		catch (final IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(-1);
		}

		FileReader leftRead = null;
		FileReader rightRead = null;
		try {
			leftRead = new FileReader(left);
			rightRead = new FileReader(right);
		}
		catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}

		final BufferedReader leftIn = new BufferedReader(leftRead);
		final BufferedReader rightIn = new BufferedReader(rightRead);

		String leftLine;
		String rightLine;

		try {
			while ((leftLine = leftIn.readLine()) != null) {
				final StringBuilder combyLine = new StringBuilder();
				rightLine = rightIn.readLine();
				if (rightLine != null) {
					combyLine.append(leftLine).append(rightLine);
					combyWriter.append(combyLine.toString()).append(NL);
				}
				else {
					combyLine.append(leftLine).append(NL);
				}
			}
		}
		catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}

		try {
			combyWriter.flush();
		}
		catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
