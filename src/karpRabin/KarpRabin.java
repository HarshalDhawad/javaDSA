package karpRabin;

public class KarpRabin {
    private final int PRIME = 101;

    public double calculateHash(String str){
        double hash = 0;
        for(int i=0;i<str.length();i++){
            hash += str.charAt(i) * Math.pow(PRIME , i);
        }
        return hash;
    }
    public double updateHash(double prevhash , char oldchar , char newchar , int patternlength ){
        double newhash = (prevhash - oldchar) / PRIME;
        newhash+= newchar * Math.pow(PRIME,patternlength-1);
        return newhash;
    }

    public void search(String text , String pattern){
        int patternlength = pattern.length();
        double texthash = calculateHash(text.substring(0,pattern.length()));
        double patternhash = calculateHash(pattern);

        for(int i=0;i<text.length()-patternlength;i++){
            if(texthash==patternhash){
                if(text.substring(i,i+patternlength).equals(pattern)){
                    System.out.println("found a match at index"+i);
                }
            }
            if(i<text.length()-patternlength){
                texthash=updateHash(texthash,text.charAt(i),text.charAt(patternlength+i),patternlength);
            }
        }

    }
}
