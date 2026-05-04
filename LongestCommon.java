class LongestCommon {
    public String longestCommonPrefix(String[] strs) {
    if(strs==null || strs.length==0){
        return " ";
    }
    String prefix=strs[0];
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=ch){
                return prefix.substring(0,i);
                }
            }
        }  
        return prefix;  
    }   
public static void main(String args[]){    
String strs[]={"flower","flow","flight"};
LongestCommon obj=new LongestCommon ();
String result=obj.longestCommonPrefix(strs);
System.out.println(result);
}
}
