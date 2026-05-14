public class LarPalindrome {
    public String longestPalindrome(String s) {
        int n=s.length();
     for(int i=0;i<s.length()/2;i++){
        if(s.charAt(i)==s.charAt(n-1-i)){  
            String temp= s.substring(i,n-i);
            return temp;
        }
     }
     return " ";   
    }
    public static void main(String args[]){
        String s="babad";
        LarPalindrome obj=new LarPalindrome();
        String res=obj.longestPalindrome(s);
        System.out.print(res);
    }
}    

