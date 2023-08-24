package leetcode.easy;

public class _190ReverseBits {
    public int reverseBits(int n) {
        //1101
        //1011

        int res = 0;// 0000

        for(int i = 0; i < 32; i++){
            //left shift
            res = res << 1;//0001, 0010, 0100
            if((n&1) == 1){
                res++;
            }
            //right shift
            n = n >> 1;
        }

        return res;

    }
}
