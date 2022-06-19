public class BitsSample {
    public static void main(String[] args) {
        Integer num=24;

        System.out.println(Integer.toBinaryString(num));
        System.out.println(findNthBits(num,1));
        System.out.println( 15>>1);
    }
    public static int findNthBits(int number, int bit){
        int mask = (1<<bit);
        int result = (number & mask);
        return result;
    }
}
