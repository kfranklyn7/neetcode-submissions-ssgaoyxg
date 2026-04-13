class Solution {
    Map<Integer,List<Integer>> preReq;
    Set<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preReq = new HashMap<Integer,List<Integer>>();
        visited = new HashSet<>();
        for(int i = 0;i <numCourses;i++){
            preReq.put(i,new ArrayList<Integer>());
        }
        for(int i = 0;i < prerequisites.length;i++){
            preReq.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0; i < numCourses;i++){
            if(!dfs(i)) return false;
        }
        return true;

    }
    public boolean dfs(int curr){
        if(visited.contains(curr)){
            return false;
        }
        if(preReq.get(curr).isEmpty()){
            return true;
        }
        visited.add(curr);
        for(int i : preReq.get(curr)){
            if (!dfs(i)){
                return false;
            }
        }
        visited.remove(curr);
        preReq.put(curr,new ArrayList<>());
        return true;

    }
}
