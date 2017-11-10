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
		
		tp.addNode(200, 200, new TreeNode());
		tp.addNode(400, 200, new TreeNode());
		tp.addNode(430, 300, new TreeNode());
		tp.addNode(500, 200, new TreeNode());
		tp.addNode(500, 400, new TreeNode());
		tp.addNode(300, 300, new TreeNode());
		tp.addNode(200, 400, new TreeNode());
		tp.addNode(450, 500, new TreeNode());
		
		tp.addNode(300, 100, station);
		new JViewer(tp);
	}
}
