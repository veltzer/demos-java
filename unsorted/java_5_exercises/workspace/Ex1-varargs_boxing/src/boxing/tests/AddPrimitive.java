/*
 * EqualsPrimitive.java
 *
 * Created on May 2, 2005, 5:26 AM
 */

package boxing.tests;

import boxing.*;

/**
 *
 * @author pix
 */
public class AddPrimitive extends PerformaceTest {
    int i;

    public void init() { i=0; }
    public void cycle() { i+=1; }
    public void done() {}
}