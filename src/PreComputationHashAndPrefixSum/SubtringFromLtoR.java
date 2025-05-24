package PreComputationHashAndPrefixSum;

import java.util.Scanner;

public class SubtringFromLtoR {

    public static void main(String[] args) {
        final int N = 100000+10;
        int[][] hsh = new int[N][26];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        for(int i=0; i<n; i++){
            hsh[i+1][s.charAt(i)-'a']++;

            //hashing of Char
            // for where its indexes are present, hsh[i+1] stores it
            // lets convert it to prefixSum (easy for us to find the sum between L to R)
        }

        for(int i=0; i<26; i++){
            for(int j=1; j<=n; j++){
                hsh[j][i] += hsh[j-1][i];
            }
        }

        int q = sc.nextInt();
        while(q-- > 0){
            int l = sc.nextInt(), r = sc.nextInt();
            int oddCount = 0;
            for(int i=0; i<26; i++){
                int charCt = hsh[r][i] - hsh[l-1][i];

                if(charCt % 2 != 0){
                    oddCount++;
                }
            }
            if(oddCount > 1) System.out.println("No");
            else System.out.println("Yes");
        }
    }
}
