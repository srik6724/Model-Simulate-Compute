package Solutions;

class Interleaving_String {
  /*public boolean isInterleave(String s1, String s2, String s3) {
    int len1 = s1.length(); 
    int len2 = s2.length(); 
    int len3 = s3.length(); 
    if((len1 + len2) != len3) {
        return false; 
    }
    boolean indxState[][] = new boolean[len1+1][len2+1]; 
    indxState[0][0] = true; 
    
    for(int indx1 = 1; indx1 < indxState.length; indx1++) {
        indxState[indx1][0] = indxState[indx1-1][0] && (s1.charAt(indx-1) == s3.charAt(indx1-1)); 
    }
    for(int indx2 = 1; indx2 < indxState[0].length; indx2++) {
        indxState[0][indx2] = indxState[0][indx2-1] && (s2.charAt(indx2-1) == s3.charAt(indx2-1)); 
    }
    for(int indx1 = 1; indx1 < indxState.length; indx1++) {
        for(int indx2 = 1; indx2 < indxState[0].length; indx2++) {
            indxState[indx1][indx2] = (indxState[indx1-1][indx2]); 
        }
    }
    return indxState[len1][len2]; 
}*/
}
