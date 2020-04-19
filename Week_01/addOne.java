package Week_01;

public class addOne {
    public int[] plusOne(int[] digit) {
        int len = digit.length;
        for(int i = (len-1);i>=0;i--){
            digit[i] ++ ;
            if(digit[i]!=10){
                break ;
            }else{
                digit[i] = 0;
            }
            
        }
        if(digit[0]==0){
            digit = new int[len+1];
            digit[0] =1;
        }
        return digit;
    }
}