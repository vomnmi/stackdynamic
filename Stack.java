public class Stack {
	int[] stack;
	int topIndex;

	public Stack() {
		this.stack = new int[10];
	}

	public void push(int element) {
		if(topIndex == stack.length) {
			resize();
		}
		stack[topIndex++] = element;
	}

	public int pop() {
		if(stack.length == 0) {
			System.out.println("Stack is empty!");
			return -1;
		}
		return stack[topIndex-- - 1];

	}

	public int top() {
		if(stack.length == 0) {
			System.out.println("Stack is empty!");
			return -1;
		}
		return stack[topIndex - 1];
	}

	private void resize() {
		int[] resizedStack = new int[(int)(stack.length * 1.5)];
		for (int i = 0; i < stack.length; i++) {
			resizedStack[i] = stack[i];
		}
		stack = resizedStack;
	}

	public boolean isEmpty() {
		return topIndex == 0;
	}

	public int getSize() {
		return topIndex;
	}

	public void print() {
		for (int i = 0; i < topIndex; i++) {
			System.out.print("[" + stack[i] + ']');	
		}
		System.out.println();
	}

}

class Main {
	public static void main(String[] args) {
		Stack stack = new Stack();
		for (int i = 0; i < 11; i++) {
			stack.push(i);
		}
		stack.print();

		System.out.println(stack.pop());
		System.out.println(stack.top());
		stack.print();
	}
}