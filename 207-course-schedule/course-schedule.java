import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjList.get(prerequisiteCourse).add(course);
        }
        int[] visited = new int[numCourses];
        Arrays.fill(visited, -1);

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == -1 && hasCycle(adjList, course, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjList, int course, int[] visited) {
        if (visited[course] == 1) {
            return true; 
        }
        if (visited[course] == 0) {
            return false; 
        }
        visited[course] = 1; 

        // Explore neighbors
        for (int neighbor : adjList.get(course)) {
            if (hasCycle(adjList, neighbor, visited)) {
                return true; 
            }
        }
        visited[course] = 0;
        return false;
    }
}
