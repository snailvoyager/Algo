class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i=0; i<candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = candidates[i];
            list.add(candidates[i]);
            find(sum, i, result, list, candidates, target);
        }
        
        return result;
    }
    
    public void find(int sum, int idx, List<List<Integer>> result, List<Integer> list, int[] candidates, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i=idx; i<candidates.length; i++) {
            list.add(candidates[i]);
            find(sum + candidates[i], i, result, list, candidates, target);
            list.remove(list.size()-1);
        }
    }
}