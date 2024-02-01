package org.meta.rcp.myserver;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.launching.AbstractJavaLaunchConfigurationDelegate;
import org.eclipse.jdt.launching.ExecutionArguments;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.VMRunnerConfiguration;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerCore;
import org.eclipse.wst.server.core.ServerUtil;
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;

public class Launch extends AbstractJavaLaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) {
		trace("launch in mode " + mode);

		IServer server;
		try {
			server = ServerUtil.getServer(configuration);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		if (server == null) {
			trace("Launch configuration could not find server");
			// throw CoreException();
			return;
		}
		ServerBehaviour dlg = (ServerBehaviour) server
				.loadAdapter(ServerBehaviourDelegate.class, null);
		dlg.setServerStatePub(IServer.STATE_STARTING);

		if (server.shouldPublish() && ServerCore.isAutoPublishing()) {
			server.publish(IServer.PUBLISH_INCREMENTAL, monitor);
		}

		String mainTypeName = "myclass";

		IVMInstall vm;
		try {
			vm = verifyVMInstall(configuration);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		IVMRunner runner = vm.getVMRunner(mode);
		if (runner == null) {
			runner = vm.getVMRunner(ILaunchManager.RUN_MODE);
		}

		// Program & VM args
		String pgmArgs;
		String vmArgs;
		String[] envp;
		try {
			pgmArgs = getProgramArguments(configuration);
			vmArgs = getVMArguments(configuration);
			envp = getEnvironment(configuration);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}

		ExecutionArguments execArgs = new ExecutionArguments(vmArgs, pgmArgs);

		// VM-specific attributes
		// Map<?,?> vmAttributesMap = getVMSpecificAttributesMap(configuration);

		// Classpath
		// String[] classpath = getClasspath(configuration);
		String[] classpath = {
				"/home/mark/tmp"
		};

		// Create VM config
		File workingDir;
		try {
			workingDir = verifyWorkingDirectory(configuration);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		String workingDirName = null;
		if (workingDir != null) {
			workingDirName = workingDir.getAbsolutePath();
		}

		VMRunnerConfiguration runConfig = new VMRunnerConfiguration(
				mainTypeName, classpath);
		runConfig.setProgramArguments(execArgs.getProgramArgumentsArray());
		runConfig.setVMArguments(execArgs.getVMArgumentsArray());
		runConfig.setWorkingDirectory(workingDirName);
		runConfig.setEnvironment(envp);
		// runConfig.setVMSpecificAttributesMap(vmAttributesMap);

		// Bootpath
		String[] bootpath;
		try {
			bootpath = getBootpath(configuration);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		if (bootpath != null && bootpath.length > 0) {
			runConfig.setBootClassPath(bootpath);
		}
		trace("starting print of class path...");
		for (String part : runConfig.getClassPath()) {
			trace(part);
		}
		trace("finished print of class path...");

		try {
			setDefaultSourceLocator(launch, configuration);
			runner.run(runConfig, launch, monitor);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}

		dlg.setProcess(launch.getProcesses()[0]);
		dlg.setServerStatePub(IServer.STATE_STARTED);
	}

	private void trace(String string) {
		System.out.println(string);
	}
}
