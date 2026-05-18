public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    int max=0;    
    for(int i=0;i<s.length();i++){
        String temp="";
        for(int j=1+i;j<s.length();j++){
            char ch=s.charAt(j); 
            if( temp.indexOf(ch)!=-1){
                break;
            }
            temp=temp+ch;
            if(temp.length()>max){
                max=temp.length();
            }
        }
    } 
    return max; 
    }
    public static void main(String args[]){
        String s="abcabcbb";
        LongestSubstring obj=new LongestSubstring();
        int result=obj.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}    

