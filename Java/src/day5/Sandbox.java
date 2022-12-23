package day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sandbox {

    public static void main(String[] args) {

	List<Stack<Character>> stacks = new ArrayList<>();

	Stack<Character> stack1 = new Stack<>();
	stack1.push('A');
	stack1.push('B');
	stack1.push('C');
	stack1.push('D');
	stack1.push('E');
	stack1.push('F');

	Stack<Character> stack2 = new Stack<>();

	stacks.add(new Stack<Character>());
	stacks.add(stack1);
	stacks.add(stack2);

	int numToMove = 2;
	int from = 1;
	int to = 2;

	System.out.println(stacks);

	System.out.println();

	Stack<Character> tempStack = new Stack<>();
	
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
	

	
	System.out.println();
	
	numToMove = 2;
	from = 2;
	to = 1;

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

	System.out.println(stacks);

    }

}
