class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;

        Set<Integer> seen = new HashSet<>();

        int sum = 0;
        while(n>=0){
            if(n==0)
                {
                    if(sum==1)
                        return true;
                    if(seen.contains(sum))
                        return false;
                    else
                        seen.add(sum);
                    n = sum;
                    sum = 0;
                }
            sum+=Math.pow(n%10,2);
            n/=10;
        }

        return false;
    }
}
