class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k)-atmost(nums, k-1);
    }
    public int atmost(int[] nums, int k){
        int start=0;
        int end=0;
        int size=nums.length;
        int unique=0;
        int count=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        while(end<size){
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            if(map.get(nums[end])==1) unique++;
            while(unique>k){
                map.put(nums[start], map.get(nums[start])-1);
                if(map.get(nums[start])==0) unique--;
                
                start++;
            }
            count+=end-start+1;
            end++;
        }
        return count;
    }




    // public int subarraysWithKDistinct(int[] nums, int k) {
    //     return atleast(nums, k)-atleast(nums, k+1);
    // }
    // private int atleast(int[] nums, int k){
    //     int start=0;
    //     int end=0;
    //     int total=0;
    //     int unique=0;
    //     int length=nums.length;
    //     HashMap<Integer, Integer> map=new HashMap<>();
    //     while(end<length){
    //         map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
    //         if(map.get(nums[end])==1) unique++;
    //         while(unique>=k){
    //             total+=length-end;
    //             map.put(nums[start], map.get(nums[start])-1);
    //             if(map.get(nums[start])==0) unique--;
    //             start++;
    //         }
    //         end++;
    //     }
    //     return total;
    // }
}