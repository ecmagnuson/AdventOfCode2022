package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {

    private static List<Stack<Character>> reverseStacks(List<Stack<Character>> stacks) {
	List<Stack<Character>> reverseStacks = new ArrayList<>();
	for (int i = 0; i < 10; i++) {
	    reverseStacks.add(new Stack<Character>());
	}

	for (int i = 0; i < stacks.size(); i++) {
	    while (!stacks.get(i).empty()) {
		Character c = stacks.get(i).pop();
		reverseStacks.get(i).push(c);
	    }
	}
	return reverseStacks;
    }

    protected static List<Stack<Character>> parseStacks(String[] lines) {
	List<Stack<Character>> stacks = new ArrayList<>();
	// leaving stacks.get(0) blank to line up with inputs later that are 1 indexed
	for (int i = 0; i < 10; i++) {
	    stacks.add(new Stack<Character>());
	}

	for (int i = 0; i < lines.length - 1; i++) {
	    for (int j = 1, k = 1; k < lines[i].length(); j++, k += 4) {
		if (lines[i].charAt(k) != ' ') {
		    stacks.get(j).push(lines[i].charAt(k));
		}
	    }
	}
	return reverseStacks(stacks);
    }

    // part1
    protected static void moveStacks1(String instructions, List<Stack<Character>> stacks) {

	String[] instructionsList = instructions.split("\n");
	// found this for future reference
	// https://github.com/zebalu/advent-of-code-2022/blob/master/aoc2022/src/main/java/io/github/zebalu/aoc2022/Day05.java
	Pattern pattern = Pattern.compile("move (\\d+) from (\\d) to (\\d)");

	for (String line : instructionsList) {
	    Matcher matcher = pattern.matcher(line);
	    if (matcher.matches()) {
		int numToMove = Integer.parseInt(matcher.group(1));
		int from = Integer.parseInt(matcher.group(2));
		int to = Integer.parseInt(matcher.group(3));
		for (int i = 0; i < numToMove; i++) {
		    stacks.get(to).push(stacks.get(from).pop());
		}
	    }
	}

	String message = "";
	for (Stack<Character> stack : stacks) {
	    if (!stack.empty()) {
		message += stack.peek();
	    }
	}
	System.out.println(message); // GRTSWNJHH
    }

    // part1
    protected static void moveStacks2(String instructions, List<Stack<Character>> stacks) {
	String[] instructionsList = instructions.split("\n");

	Pattern pattern = Pattern.compile("move (\\d+) from (\\d) to (\\d)");

	for (String line : instructionsList) {
	    Matcher matcher = pattern.matcher(line);
	    if (matcher.matches()) {
		int numToMove = Integer.parseInt(matcher.group(1));
		int from = Integer.parseInt(matcher.group(2));
		int to = Integer.parseInt(matcher.group(3));

		Stack<Character> tempStack = new Stack<>();

		// There is a bug in here somewhere
		// This is the right idea but it is the wrong answer
		// No idea right now...
		// I've tested this works and puts things in original order
		while (numToMove != 0) {
		    if (stacks.get(from).empty()) {
			break;
		    }
		    tempStack.push(stacks.get(from).pop());
		    numToMove--;
		}
		while (!tempStack.empty()) {
		    stacks.get(to).push(tempStack.pop());
		}
		

	    }
	}
	String message = "";
	for (Stack<Character> stack : stacks) {
	    if (!stack.empty()) {
		message += stack.peek();
	    }
	}
	System.out.println(message); //
    }

    public static void main(String[] args) throws IOException {

	String input = Files
		.readString(Paths.get(System.getProperty("user.dir") + "/inputs/inputDay5"));

	String[] parts = input.split("\n\n");
	String[] lines = parts[0].split("\n");

	List<Stack<Character>> stacks = parseStacks(lines);
	moveStacks1(parts[1], stacks);
	moveStacks2(parts[1], stacks);
    }
}
