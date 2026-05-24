class Solution {
    public int[] plusOne(int[] digits) {     
       int len = digits.length;  
       int car = 1; int sum = 0;
       for(int i= len-1; i>=0; i--){
            int curr = digits[i];
            sum = (sum*10) + ((curr+car)%10);
            //digits[i]= (curr+car)%10;
            car = (curr+car)/10;   
       }
       if(car!=0){
         sum = (sum*10)+car; len++;
       }
       
    
       int[] res = new int[len];
       for(int i=0; i<len; i++){
        res[i]=sum%10;
        sum = sum/10;
       }

       return res; 
    }
}
