import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchGraph {

	BFS2Node startNode;
	BFS2Node goalNode;

	public BreadthFirstSearchGraph(BFS2Node start, BFS2Node goalNode) {
		this.startNode = start;
		this.goalNode = goalNode;
	}

	public boolean compute() {

		if (this.startNode.equals(goalNode)) {
			System.out.println("Goal Node Found!");
			System.out.println(startNode);
		}

		Queue<BFS2Node> queue = new LinkedList<>();
		ArrayList<BFS2Node> explored = new ArrayList<>();
		queue.add(this.startNode);
		//explored.add(startNode);

		while (!queue.isEmpty()) {
			BFS2Node current = queue.remove();
			if (current.equals(this.goalNode)) {
				System.out.println(explored);
				return true;
			} else {
				if (current.getChildren().isEmpty())
					return false;
				else {
					for (BFS2Node node : current.getChildren()) {
						if (!queue.contains(node)) {
							queue.add(node);
						}
					}
				}
			}
			explored.add(current);
		}

		return false;

	}

	public static void main(String args[]) {
		BFS2Node station1 = new BFS2Node("1.Westminster", null, null);
		BFS2Node station2 = new BFS2Node("2.Waterloo", station1, null);
		BFS2Node station3 = new BFS2Node("3.Trafalgar Square", station1, station2);
		BFS2Node station4 = new BFS2Node("4.Canary Wharf", station2, station3);
		BFS2Node station5 = new BFS2Node("5.London Bridge", station4, station3);
		BFS2Node station6 = new BFS2Node("6.Tottenham Court Road", station5,
				station4);

		BreadthFirstSearchGraph bfs = new BreadthFirstSearchGraph(station6, station1);

		if (bfs.compute())
			System.out.print("Path Found!");
	}

}

/**
 * The Node class represents a station in this tutorial and will as such have a
 * string representing the station's name. As well as an ArrayList of nodes that
 * will store any instantiated nodes children.
 */
class BFS2Node {

	// A Unique Identifier for our node
	String stationName;
	// An arraylist containing a list of Nodes that
	// This node is directly connected to - It's child nodes.
	BFS2Node leftChild;
	BFS2Node rightChild;

	BFS2Node(String stationName, BFS2Node firstChild, BFS2Node secondChild) {
		this.stationName = stationName;
		this.leftChild = firstChild;
		this.rightChild = secondChild;
	}

	public String toString() {
		return " " + stationName;
	}

	public ArrayList<BFS2Node> getChildren() {
		ArrayList<BFS2Node> childNodes = new ArrayList<>();
		if (this.leftChild != null) {
			childNodes.add(leftChild);
		}
		if (this.rightChild != null) {
			childNodes.add(rightChild);
		}
		return childNodes;
	}

	// An auxiliary function which allows
	// us to remove any child nodes from
	// our list of child nodes.
	public boolean removeChild(BFS2Node n) {
		return false;
	}

}
