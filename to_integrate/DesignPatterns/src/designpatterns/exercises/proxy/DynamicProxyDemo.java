package designpatterns.exercises.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class DynamicProxyDemo {
	private static class DynamicDoableProxy implements InvocationHandler {
		private Doable reference;

		public DynamicDoableProxy(Doable ireference) {
			reference = ireference;
		}

		public Object invoke(Object proxy, Method method, Object[] args)
				throws Exception {
			// System.out.println("InvocationHandler called:" + "\n\tmethod = "
			// + method);
			// we can change any argument we like

			/*
			 * if (args != null) { System.out.println("\targs = "); for (int i =
			 * 0; i < args.length; i++) System.out.println("\t\t" + args[i]); }
			 */
			// We can choose how to invoke the reference
			return method.invoke(reference, args);
			// return null ;
		}
	}

	public static void main(String[] clargs) {
		try {
			Doable reference = new DoableAction();
			Doable proxy = (Doable) Proxy.newProxyInstance(
					Doable.class.getClassLoader(), new Class<?>[] {
							Doable.class
			}, new DynamicDoableProxy(reference));
			long startTime, endTime;
			startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000; ++i) {
				proxy.doIt();
			}
			endTime = System.currentTimeMillis() - startTime;
			System.out.println("Proxy time: " + endTime);
			startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000; ++i) {
				reference.doIt();
			}
			endTime = System.currentTimeMillis() - startTime;
			System.out.println("Direct time: " + endTime);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
