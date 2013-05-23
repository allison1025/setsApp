package edu.ucsf.rbvi.setsApp.internal.tasks;

import java.util.ArrayList;
import java.util.Collection;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.util.ListSingleSelection;

public class MoveSetTask extends AbstractTask {

	private SetsManager mgr;
	@Tunable(description="Enter name of new set:")
	public String newSet;
	@Tunable(description="Select network:")
	public ListSingleSelection<CyNetwork> networks;
	@Tunable(description="Select set to move:")
	public ListSingleSelection<String> selectSet;
	private String movingSet;
	
	public MoveSetTask(SetsManager manager, Collection<CyNetwork> networkManager) {
		mgr = manager;
		selectSet = new ListSingleSelection<String>(mgr.getSetNames());
		networks = new ListSingleSelection<CyNetwork>(new ArrayList<CyNetwork>(networkManager));
		movingSet = null;
	}
	
	public MoveSetTask(SetsManager manager, Collection<CyNetwork> networkManager, String movingSetName) {
		mgr = manager;
		selectSet = null;
		networks = new ListSingleSelection<CyNetwork>(new ArrayList<CyNetwork>(networkManager));
		movingSet = movingSetName;
	}
	
	@Override
	public void run(TaskMonitor arg0) throws Exception {
		if (selectSet != null)
			mgr.moveSet(selectSet.getSelectedValue(), newSet, networks.getSelectedValue());
		else
			mgr.moveSet(movingSet, newSet, networks.getSelectedValue());
	}

}