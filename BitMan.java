public class BitMan {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
        return  Integer.MAX_VALUE;
        }
        return dividend/divisor; 
    }
    public static void main(String args[]){
        BitMan D1=new BitMan();
        System.out.println(D1.divide(10,3));
        System.out.println(D1.divide(7,-3));
    }
} 

