# Two Break Distance Calculation

This repository contains a solution for computing the Two-Break Distance between two genomes, represented as circular chromosomes.

## Problem Description

The **Two-Break Distance** is a concept in computational biology used to calculate the minimum number of two-break operations required to transform one genome into another. A two-break operation cuts two edges and then reconnects the four resulting ends in a different configuration. 

The **Two-Break Distance** can be calculated using the formula:

Distance = Number of blocks - Number of cycles



Where:
- A **block** is an adjacency between genes in the genome.
- A **cycle** is a connected component formed when combining edges from both genomes.

## Solution Overview

The algorithm works as follows:
1. **Convert genomes to edges**: Represent the genomes as edge lists.
2. **Combine edges**: Merge edges from both genomes.
3. **Find cycles**: Use depth-first search (DFS) to count the number of cycles in the combined edge list.
4. **Calculate distance**: Subtract the number of cycles from the total number of blocks.

## Input Format

The method `TwoBreakDistance` takes two inputs:
- `P`: A list of chromosomes representing the first genome.
- `Q`: A list of chromosomes representing the second genome.

Each chromosome is represented as a list of integers, where positive integers indicate a gene, and negative integers represent the reversed orientation of a gene.

## Output

The method returns an integer representing the Two-Break Distance between the two genomes.

## Example Usage

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> P = Arrays.asList(Arrays.asList(1, 2, 3, 4));
        List<List<Integer>> Q = Arrays.asList(Arrays.asList(1, -3, -4, -2));

        int result = solution.TwoBreakDistance(P, Q);
        System.out.println("Two-Break Distance: " + result); // Output: 2
    }
}
Implementation Details
Methods
TwoBreakDistance(List<List<Integer>> P, List<List<Integer>> Q)

Main method that calculates the Two-Break Distance.
genomeToEdges(List<List<Integer>> genome)

Converts a genome into a list of edges.
findCycles(List<Edge> edges)

Counts the number of cycles in the combined edge list using DFS.
dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited)

Helper method for DFS traversal.
Edge

Helper class to represent an edge between two nodes.
Complexity
Time Complexity: 
𝑂
(
𝑛
+
𝑚
)
O(n+m), where 
𝑛
n is the number of genes, and 
𝑚
m is the number of edges in the combined adjacency list.
Space Complexity: 
𝑂
(
𝑛
+
𝑚
)
O(n+m), for the adjacency list and visited set.
Notes
The input genomes are assumed to represent circular chromosomes.
The implementation handles both positive and negative gene orientations by normalizing edges.
