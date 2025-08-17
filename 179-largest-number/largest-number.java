class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String[] values=new String[n];
        for(int i=0;i<n;i++){
            values[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(values, (a, b) -> (b+a).compareTo(a+b));

        if(values[0].equals("0")) return "0";

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<values.length;i++){
            sb.append(values[i]);
        }
        return sb.toString();
    }
}