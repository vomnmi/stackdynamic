public class DynamicIntArray {
	private int[] data;
	private int size = 0;

	public DynamicIntArray() {
		this.data = new int[10];
	}
	public void add(int element) {
		if(size == data.length) {
			resize();
		}
		data[size++] = element;
	}

	public void remove(int index) {
		if(index < 0 || index >= size) {
			System.out.println("Wrong index");
			return;
		}

		for (int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}
		size--;
	}

	private void resize() {
		int[] resizedArr = new int[(int)(data.length * 1.5)];
		for (int i = 0; i < data.length; i++) {
			resizedArr[i] = data[i];
		}
		data = resizedArr;
	}

	public int getSize() {
		return size;
	}

	public void insert(int index, int element) {
		if(size == data.length) {
			resize();
		}
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = element;
		size++;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append("[" + data[i] + "]");
		}
		return sb.toString();
	}

	public boolean isEmpty() {
		return size == 0;
	}
}

class Main {
	public static void main(String[] args) {
		DynamicIntArray array = new DynamicIntArray();
		for (int i = 0; i < 20; i++) {
			array.add(i);
		}
		System.out.println(array);
		array.remove(10);
		System.out.println(array);
		array.remove(10);
		System.out.println(array);
		array.insert(10, 77);
		System.out.println(array);

	}
}