/*
 * Created on Feb 10, 2006
 */
package dp.observer.factory.logger;

public class ConsoleLogger implements LoggerObserver
{

	public ConsoleLogger()
	{
		super();
	}

	public void onLogRequest(String messageLine)
	{
		System.out.println(messageLine);
	}

}