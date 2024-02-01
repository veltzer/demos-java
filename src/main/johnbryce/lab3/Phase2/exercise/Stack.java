package johnbryce.lab3.Phase2.exercise;

import java.util.ArrayList;

public class Stack {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public synchronized int pop() {
		while (arrayList.size() == 0) {
			try {
				System.out.println(
						Thread.currentThread().getName() + " is waiting");
				wait();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println(Thread.currentThread().getName() + " poped number "
				+ arrayList.get(arrayList.size() - 1));
		return arrayList.remove(arrayList.size() - 1);
	}

	public synchronized void push(int num) {
		notifyAll();
		arrayList.add(num);
		System.out.println(
				Thread.currentThread().getName() + " pushed number " + num);
	}
}
