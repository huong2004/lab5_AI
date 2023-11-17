package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
        List<Node> explored = new ArrayList<>();

        Node initialNode = new Node(model.getInitialState());
        frontier.add(initialNode);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            if (model.equals(current)) {
                return current; 
            }

            explored.add(current);

            List<Node> neighbors = current.generateNeighbors(); 

            for (Node neighbor : neighbors) {
                if (!explored.contains(neighbor) && !frontier.contains(neighbor)) {
                    frontier.add(neighbor);
                }
            }
        }

        return null; // If the priority queue is empty and the goal state is not found, return null
    
	}
	
