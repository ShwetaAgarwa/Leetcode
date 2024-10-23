import java.util.*;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int gcdLength = gcd(str1.length(), str2.length());
        
        String candidate = str1.substring(0, gcdLength);
        
        if (canConstruct(str1, candidate) && canConstruct(str2, candidate)) {
            return candidate;
        }
        
        return "";
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private boolean canConstruct(String str, String candidate) {
        int repeatCount = str.length() / candidate.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < repeatCount; i++) {
            sb.append(candidate);
        }
        
        return sb.toString().equals(str);
    }
}
