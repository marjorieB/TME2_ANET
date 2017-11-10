import jbotsim.Node;
import jbotsim.Topology;
import jbotsim.ui.CommandListener;
import jbotsim.ui.JTopology;
import jbotsim.ui.JViewer;

public class Main {
	public static void main(String[] args) {
		StationNode station = new StationNode(); 
		station.setSize(15);
		
		final Topology tp = new Topology(600, 600);	
		tp.setCommunicationRange(150);
		
		tp.addNode(200, 200, new SensorNode());
		tp.addNode(400, 200, new SensorNode());
		tp.addNode(430, 300, new SensorNode());
		tp.addNode(500, 200, new SensorNode());
		tp.addNode(500, 400, new SensorNode());
		tp.addNode(300, 300, new SensorNode());
		tp.addNode(200, 400, new SensorNode());
		tp.addNode(450, 500, new SensorNode());
		
		tp.addNode(300, 100, station);
		//new JViewer(tp);
		
		JTopology jtp = new JTopology(tp);
		jtp.addCommand("Update values");
		jtp.addCommandListener(new CommandListener() {
		       public void onCommand(String command) {
		           if (command.equals("Update values")) {
		               for (Node node : tp.getNodes()) { 
		            	   if (node instanceof SensorNode) {
		            		   ((SensorNode)node).sense();
		            	   }
		            	   else {
		            		   ((StationNode)node).sense();
		            	   }
		               }
		           }
		       }
		   });
		new JViewer(jtp);
	}
}
