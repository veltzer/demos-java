/*
 * Created on Feb 9, 2006
 */
package dp.state;

public class DisabledState extends AbstractDeviceState
{

	public DisabledState(NetworkDevice device)
	{
		super(device);
	}

	public void enable()
	{
		device.setState( device.ENABLED_STATE );
	}

}