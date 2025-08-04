//Problem: 5. Longest Palindrome Substring
// Given a string s, return the longest palindrome string s
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        String longestPalindrome = "";
        for(int i=0;i<s.length();i++){
            String odd = expand(s,i,i);                              //the string can be of odd or even length. If odd length then we expand from the same index or center
            String even = expand(s,i,i+1);                           //If even length then we expand from the respective index and index+1 as it will have two centers
            String longest = odd.length()>even.length()?odd:even;    
            if(longest.length()>longestPalindrome.length()){         //Store the longest palindrome
                longestPalindrome = longest;
            }
        }
        return longestPalindrome;
    }
    public String expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){    //if it is a palindrome then expand
            left--;
            right++;
        }
        return (s.substring(left+1,right));
    }
}
