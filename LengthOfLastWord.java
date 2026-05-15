public class LengthOfLastWord {
    public int length(String s) {
     int i=s.length()-1; 
     int count=0;
     while(i>=0 && s.charAt(i)==' '){
        i--;
     }  
     while(i>=0 && s.charAt(i)!=' '){
        count++;
        i--;
     } 
     return count; 
    }
    public static void main(String args[]){
     String s="Hello World";
     LengthOfLastWord obj=new LengthOfLastWord();
     System.out.println(obj.length(s));   
    }    
}    

