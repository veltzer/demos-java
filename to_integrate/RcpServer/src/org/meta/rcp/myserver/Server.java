package org.meta.rcp.myserver;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.core.model.ServerDelegate;

public class Server extends ServerDelegate {

	@Override
	public void configurationChanged() {
		super.configurationChanged();
		trace("configurationChanged");
	}

	@Override
	public void dispose() {
		super.dispose();
		trace("dispose");
	}

	@Override
	public ServerPort[] getServerPorts() {
		ServerPort[] ret = super.getServerPorts();
		trace("getServerPorts");
		return ret;
	}

	@Override
	protected void initialize() {
		super.initialize();
		trace("initialize");
	}

	@Override
	public void saveConfiguration(IProgressMonitor monitor) {
		try {
			super.saveConfiguration(monitor);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		trace("saveConfiguration");
	}

	@Override
	public void setDefaults(IProgressMonitor monitor) {
		super.setDefaults(monitor);
		trace("setDefaults");
	}

	@Override
	public IStatus canModifyModules(IModule[] arg0, IModule[] arg1) {
		trace("canModifyModules");
		return null;
	}

	@Override
	public IModule[] getChildModules(IModule[] modules) {
		trace("getChildModules");
		for (IModule x : modules) {
			trace("modules is " + x.getName());
		}
		return null;
	}

	@Override
	public IModule[] getRootModules(IModule arg0) {
		trace("getRootModules");
		return null;
	}

	@Override
	public void modifyModules(IModule[] modules, IModule[] arg1,
			IProgressMonitor arg2) {
		trace("modifyModules");
		for (IModule x : modules) {
			trace("modules is " + x.getName());
		}
	}

	private void trace(String string) {
		System.out.println(string);
	}

}
