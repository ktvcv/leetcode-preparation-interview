package leetcode.easy;

public class _191Numberof1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(32));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        int res = 0;

        for(int i = 0; i < 32; i++){
            if((n&1) == 1){
                res++;
            }
            //right shift
            n = n >> 1;
        }

        return res;
    }
}
