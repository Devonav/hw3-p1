// Please do not remove package imports because these are used by the autograder.
import java.io.*;
import java.util.*;
import java.util.stream.*;
// you can write to stdout for debugging purposes, e.g. System.out.println("this is a debug message"); 
class solution {
    public static int TwoBreakDistance(List<List<Integer>> P, List<List<Integer>> Q) {
        List<Edge> PEdges = genomeToEdges(P);
        List<Edge> QEdges = genomeToEdges(Q);
        List<Edge> combinedEdges = new ArrayList<>();
        combinedEdges.addAll(PEdges);
        combinedEdges.addAll(QEdges);

        int cycles = findCycles(combinedEdges);
        int blocks = P.stream().mapToInt(List::size).sum();
        return blocks - cycles;
    }

    private static List<Edge> genomeToEdges(List<List<Integer>> genome) {
        List<Edge> edges = new ArrayList<>();
        for (List<Integer> chromosome : genome) {
            for (int i = 0; i < chromosome.size(); i++) {
                int a = chromosome.get(i);
                int b = chromosome.get((i + 1) % chromosome.size());
                edges.add(new Edge(Math.min(a, -b), Math.max(a, -b)));
            }
        }
        return edges;
    }

    private static int findCycles(List<Edge> edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (Edge edge : edges) {
            adjList.computeIfAbsent(edge.a, k -> new ArrayList<>()).add(edge.b);
            adjList.computeIfAbsent(edge.b, k -> new ArrayList<>()).add(edge.a);
        }

        Set<Integer> visited = new HashSet<>();
        int cycles = 0;

        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, adjList, visited);
                cycles++;
            }
        }

        return cycles;
    }

    private static void dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                for (int neighbor : adjList.get(current)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    static class Edge {
        int a, b;

        Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}