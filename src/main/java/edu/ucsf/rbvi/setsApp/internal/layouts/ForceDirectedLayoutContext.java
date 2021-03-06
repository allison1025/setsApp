package edu.ucsf.rbvi.setsApp.internal.layouts;

import org.cytoscape.work.Tunable;

public class ForceDirectedLayoutContext {
  @Tunable(description="Iterations",
           tooltip="The number of iterations to run the algorithm. The higher the number, the better the accuracy yet longer run-time.")
  public int iterations = 100;

  @Tunable(description="Node mass",
           tooltip="The higher the node mass, the less nodes move around the network")
  public double nodeMass = 3.0;

  @Tunable(description="Spring coefficient for connected nodes",
           tooltip="The higher this number is, the more that network topology affects the layout. This value is the negative log of the effective coefficient.")
  public double edgeSpringCoeffNLog = 4;

  @Tunable(description="Spring length for connected nodes")
  public double edgeSpringLength = 50.0;

  @Tunable(description="Spring coefficient for nodes in the same set",
           tooltip="The higher this number is, the more that set membership affects the layout. This value is the negative log of the effective coefficient.")
  public double groupSpringCoeffNLog = 7;

  @Tunable(description="Spring length for nodes in the same set")
  public double groupSpringLength = 50.0;
  
  @Tunable(description="No overlapping nodes (y/n)", 
		  tooltip="Increase node mass for less node overlap when this feature is enabled.")
  public boolean disableOverlapping = false;
 
  @Tunable(description="Spring length for nodes in the same set")
  public double overlapForce = 500.0;
}