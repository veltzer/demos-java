package core.instrument.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * This is a very simple bytecode transformer object which does no bytecode
 * manipulation
 */
public class SimpleTransformer implements ClassFileTransformer {

	public SimpleTransformer() {
		super();
	}

	public byte[] transform(ClassLoader loader, String className,
			Class<?> redefiningClass, ProtectionDomain domain, byte[] bytes)
					throws IllegalClassFormatException {
		System.out.println("Loading class: " + className);
		return bytes;
	}
}
