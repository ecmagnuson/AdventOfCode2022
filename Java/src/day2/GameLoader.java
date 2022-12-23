package day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Game {

    private static Map<String, String> win = Map.of("R", "S", "P", "R", "S", "P");

    private static Map<String, Integer> choicePoints = Map.of("R", 1, "P", 2, "S", 3);

    private static Map<String, String> convert = Map.of("A", "R", "B", "P", "C", "S", "X", "R", "Y",
	    "P", "Z", "S");

    private String them;
    private String me;
    private String endCondition; // part2 how the game needs to end

    // Game converts to standard R,P,S
    public Game(final String line) {
	this.them = convert.get(line.substring(0, 1));
	this.me = convert.get(line.substring(2, 3));
	this.endCondition = line.substring(2, 3);
    }

    protected boolean iWin() {
	return win.get(this.me) == this.them;
    }

    protected int part1CountMyPoints() {
	int count = 0;
	// points I get for my choice
	count += choicePoints.get(this.me);
	// draw
	if (this.them == this.me) {
	    count += 3;
	}
	// I win.
	if (iWin()) {
	    count += 6;
	}
	return count;
    }

    protected int part2CountMyPoints() {
	int count = 0;

	// I lose
	if (this.endCondition.equals("X")) {
	    this.me = win.get(this.them);
	}

	// We draw
	else if (this.endCondition.equals("Y")) {
	    this.me = this.them;
	    count += 3;
	}

	// I win
	else if (this.endCondition.equals("Z")) {

	    // looping over a HashMap is kind of sad :(
	    for (Entry<String, String> entry : win.entrySet()) {
		if (entry.getValue().equals(this.them)) {
		    this.me = entry.getKey();
		}
	    }
	    count += 6;
	}
	// add points from me.
	count += choicePoints.get(this.me);
	return count;
    }
}

public class GameLoader {

    protected static List<String> readLines(String filename) throws IOException {
	return Files.readAllLines(new File(filename).toPath());
    }

    public static void main(String[] args) throws IOException {

	List<String> lines = readLines(
		new File(System.getProperty("user.dir")) + "/inputs/inputDay2");

	int part1Count = 0, part2Count = 0;

	for (String line : lines) {
	    Game game1 = new Game(line);
	    part1Count += game1.part1CountMyPoints();

	    Game game2 = new Game(line);
	    part2Count += game2.part2CountMyPoints();
	}

	System.out.println(part1Count); // 13446
	System.out.println(part2Count); // 13509
    }

}
