package hello;

import java.rmi.RemoteException;


public interface Greet extends javax.ejb.EJBObject
{
	String getHelloMessage(String name) throws RemoteException;
}