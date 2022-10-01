class Solution {
    static boolean[] visited;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        for (int i=0; i<numCourses; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<prerequisites.length; i++) {
            degree[prerequisites[i][1]]++;
            list[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        int count = 0;      //degree 0 count
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int i=0; i<list[course].size(); i++) {
                int pre = list[course].get(i);
                degree[pre]--;
                if (degree[pre] == 0) {
                    queue.add(pre);
                    count++;
                }
            }
        }
        
        return count == numCourses;
    }
    
    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;
        
        visited = new boolean[numCourses];
        ArrayList[] adjacentList = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            adjacentList[i] = new ArrayList<Integer>();
        }
        
        for (int i=0; i<prerequisites.length; i++) {
            adjacentList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for (int i=0; i<numCourses; i++) {
            if (!findCycle(adjacentList, i))
                return false;
        }
        
        return true;
    }
    
    public boolean findCycle(ArrayList[] adjacentList, int x) {
        if (visited[x])
            return false;
        
        visited[x] = true;
        for (int i=0; i<adjacentList[x].size(); i++) {
            if (!findCycle(adjacentList, (int)adjacentList[x].get(i)))
                return false;
        }
        visited[x] = false;
        return true;
    }

}