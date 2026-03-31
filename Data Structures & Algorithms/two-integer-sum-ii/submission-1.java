class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> mymap = new HashMap<>();
        int arr[] = new int[2];
        for(int i = 0; i<numbers.length; i++){
            if(mymap.containsKey(numbers[i]))
                arr = new int[]{mymap.get(numbers[i]), i+1};
            else
                mymap.put(target-numbers[i], i+1);
        }
        return arr;
    }
}
