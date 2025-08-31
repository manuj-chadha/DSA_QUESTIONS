class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int[] dp=new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp, 1);
        int maxi=1;
        int lastIndex=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(arr[i]%arr[prev]==0){
                    if(dp[i]<dp[prev]+1){
                        dp[i]=dp[prev]+1;
                        hash[i]=prev;
                    }
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }
        List<Integer> list=new ArrayList<>();
        list.add(arr[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            list.add(0, arr[lastIndex]);
        }
        return list;
    }
}