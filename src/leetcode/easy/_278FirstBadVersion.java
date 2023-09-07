package leetcode.easy;

public class _278FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }
    public static int firstBadVersion(int n) {
        int start = 1;
        int finish = n;
        int med = 0;
        while(start < finish){
            med = start + (finish - start) / 2;
            boolean next = isBadVersion(med);
            if (next){
                finish = med;
            } else{
                start  = med + 1;
            }

        }

        return start;

    }

    private static boolean isBadVersion(final int try1) {
        if (try1 == 2){
            return true;
        }
        return false;
    }
}
