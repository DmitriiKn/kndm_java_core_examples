import java.util.*;

public class CycleFind {

    // Stack to keep track of the current path (for detecting cycles)
    Set<String> visiting = new HashSet<>();
    // Set to track already visited nodes (to avoid reprocessing)
    Set<String> visited = new HashSet<>();
    // To store the path (cycle) if found
    List<String> stack = new ArrayList<>();

    // DFS recursive function to detect cycle
    private boolean dfs(String node, Map<String, List<String>> graph, String startNode) {
        // If the node is already in the current path, we found a cycle
        if (visiting.contains(node)) {
            stack.add(node);  // Add to stack to show cycle
            return true;
        }

        // If it's already fully processed (no cycle through this node), skip it
        if (visited.contains(node)) {
            return false;
        }

        // Mark the node as part of the current path
        visiting.add(node);

        // Explore all dependencies (adjacent nodes)
        for (String neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (dfs(neighbor, graph, startNode)) {
                stack.add(node);  // Add to stack on the way back
                if (node.equals(startNode)) {
                    return true;  // Stop once cycle is complete
                }
                return true;  // Continue if we are still in the cycle
            }
        }

        // Finished exploring this node, mark it as fully visited
        visiting.remove(node);
        visited.add(node);

        return false;
    }

    // Function to detect cyclic dependencies
    public List<String> findCyclicDependencies(Map<String, List<String>> graph, String startNode) {

        // Call DFS for the startNode
        if (dfs(startNode, graph, startNode)) {
            // Reverse the stack to get the correct cycle order
            Collections.reverse(stack);
            return stack;
        }

        // Return empty list if no cycle is found
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        CycleFind finder = new CycleFind();

        // Example dependency graph
        Map<String, List<String>> dependencies = new HashMap<>();
        dependencies.put("A", List.of("B", "C"));
        dependencies.put("B", List.of("C", "D"));
        dependencies.put("C", List.of("E"));
        dependencies.put("D", List.of("A"));  // Cycle: A -> B -> D -> A
        dependencies.put("E", List.of());

        String startNode = "A";
        List<String> cycle = finder.findCyclicDependencies(dependencies, startNode);

        if (!cycle.isEmpty()) {
            System.out.println("Cyclic dependency found: " + cycle);
        } else {
            System.out.println("No cyclic dependencies found.");
        }
    }
}
