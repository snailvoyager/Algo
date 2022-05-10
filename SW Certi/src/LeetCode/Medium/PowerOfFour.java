package LeetCode.Medium;

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        //2진수이면서 4진수만 걸러내기 1010101010101010101010101010101
        return (n > 0) && (n & (n-1)) == 0 && (n & 0x55555555) != 0;
    }
}
