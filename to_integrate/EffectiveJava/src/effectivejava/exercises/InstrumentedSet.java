package effectivejava.exercises;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class InstrumentedSet<E> extends ForwardingSet<E> {
	private int addCount = 0;

	public InstrumentedSet(Set<E> set) {
		super(set);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public static void main(String[] args) {
		InstrumentedSet<String> s = new InstrumentedSet<String>(
				new TreeSet<String>());
		s.addAll(Arrays.asList("Accordion", "Banjo", "Kazoo"));
		System.out.println(s.addCount);
	}
}
