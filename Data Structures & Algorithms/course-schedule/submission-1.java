class Solution {
    Map<Integer,List<Integer>> preReq;
    Set<Integer> visited;//use set for cycle detection
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preReq = new HashMap<Integer,List<Integer>>();
        visited = new HashSet<>();
        for(int i = 0;i <numCourses;i++){
            preReq.put(i,new ArrayList<Integer>());//make a map of all courses and their list of pre-reqs
        }
        for(int i = 0;i < prerequisites.length;i++){
            preReq.get(prerequisites[i][0]).add(prerequisites[i][1]);//add pre-req for course
        }
        for(int i=0; i < numCourses;i++){
            if(!dfs(i)) return false;//if course contains a loop of pre-reqs return false
        }
        return true; //otherwise return true

    }
    public boolean dfs(int curr){
        if(visited.contains(curr)){
            return false;//course cycle detected
        }
        if(preReq.get(curr).isEmpty()){
            return true;//no pre-req means we can always complete this
        }
        visited.add(curr);
        for(int i : preReq.get(curr)){
            if (!dfs(i)){
                return false;
            }
        }
        visited.remove(curr);
        return true;

    }
}
