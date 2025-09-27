class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        subset(nums, 0, list, new ArrayList<>());
        return list;
    }
    private void subset(int[] nums, int index, List<List<Integer>> list, List<Integer> subList){
        if(index==nums.length){
            list.add(new ArrayList<>(subList));
            return;
        } 
        subset(nums, index+1, list, subList);
        subList.add(nums[index]);
        subset(nums, index+1, list, subList);
        subList.remove(subList.size()-1);
    }
}