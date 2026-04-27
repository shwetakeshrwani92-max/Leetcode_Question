class Binary {
    public int hammingWeight(int n) {
    return Integer.bitCount(n);  
    }
    public static void main(String[] args){
        Binary obj=new Binary();
        System.out.println(obj.hammingWeight(11));
    }
}