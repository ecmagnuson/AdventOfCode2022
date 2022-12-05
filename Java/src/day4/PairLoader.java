package day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

//Pair object
class Pair {

	private int p1_min;
	private int p1_max;

	private int p2_min;
	private int p2_max;

	public Pair(String line) {
		String[] lines = line.replace(",", "-").split("-");

		this.p1_min = Integer.parseInt(lines[0]);
		this.p1_max = Integer.parseInt(lines[1]);

		this.p2_min = Integer.parseInt(lines[2]);
		this.p2_max = Integer.parseInt(lines[3]);
	}

	protected boolean fullyContains() {
		return (this.p1_min <= this.p2_min && this.p1_max >= this.p2_max)
				|| (this.p2_min <= this.p1_min && this.p2_max >= this.p1_max);
	}
	
	protected boolean overlaps() {
		return this.p1_min <= this.p2_max && this.p2_min <= this.p1_max;
	}
}

public class PairLoader {

	protected static List<String> readLines(String filename) throws IOException {
		return Files.readAllLines(new File(filename).toPath());
	}

	public static void main(String[] args) throws IOException {

		List<String> lines = readLines(new File(System.getProperty("user.dir")) + "/inputs/inputDay4");

		//Part One
		int part1Count = 0 , part2Count = 0;
		
		for (String line : lines) {
			Pair pair = new Pair(line);
			if (pair.fullyContains()) {
				part1Count++;
			}
			if (pair.overlaps()) {
				part2Count++;
			}
		}
		System.out.println("Part 1 answer: " + part1Count); //509 for me
		System.out.println("Part 2 answer: " + part2Count); //870 for me
	}

}
