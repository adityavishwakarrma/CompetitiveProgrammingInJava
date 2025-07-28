package Practice.Neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LongestRepeatingCharReplacement {

//    static int getMaxLen(HashMap<Character, Integer> windowHm,  int k){
//
//        int minV = Integer.MAX_VALUE;
//        int maxV = Integer.MIN_VALUE;
//        for (Integer value : windowHm.values()) {
//            minV = Math.min(minV, value);
//            maxV = Math.max(maxV, value);
//        }
//
//        if(windowHm.size() == 1){
//            return minV;
//        }
//
//        boolean isValidHm = minV <= k;
//        if(isValidHm){
//            return minV+maxV;
//        } else {
//            return k+maxV;
//        }
//    }
//
//    static public int characterReplacement(String s, int k) {
//
//        if(s.isEmpty()){
//            return 0;
//        }
//
//        class CharCount{
//            char c;
//            int count;
//            int i;
//            int j;
//
//            public CharCount(char c, int count, int i, int j) {
//                this.c = c;
//                this.count = count;
//                this.i = i;
//                this.j = j;
//            }
//
//            public char getC() {
//                return c;
//            }
//
//            public void setC(char c) {
//                this.c = c;
//            }
//
//            public int getCount() {
//                return count;
//            }
//
//            public void setCount(int count) {
//                this.count = count;
//            }
//
//            public int getI() {
//                return i;
//            }
//
//            public void setI(int i) {
//                this.i = i;
//            }
//
//            public int getJ() {
//                return j;
//            }
//
//            public void setJ(int j) {
//                this.j = j;
//            }
//        }
//
//        int maxLen = 0;
//
//        ArrayList<CharCount> l = new ArrayList<>();//single blocks
//        l.add(new CharCount(s.charAt(0), 1, 0, 0));
//
//        for(int ind=1; ind<s.length(); ind++){
//            char ch = s.charAt(ind);
//            if(Objects.equals(l.get(l.size()-1).getC(), ch)){
//                CharCount last = l.get(l.size()-1);
//                last.setJ(ind);
//                last.setCount(last.getCount()+1);
//            }
//            else {
//                l.add(new CharCount(ch, 1,ind, ind));
//            }
//        }
//
//        if(k==0){
//            for (var e : l)
//                maxLen = Math.max(maxLen, e.getCount());
//
//            return maxLen;
//        }
//
//        int bestStart = -1, bestEnd = -1;
//
//        int start = 0, end = 0;
//        HashMap<Character, Integer> windowHm = new HashMap<>();
//
//        //combining blocks for constructing a window
//        int len = 0;
//
//        //initialize the window with first block
//        CharCount cc = l.get(0);
//        windowHm.merge(cc.getC(), cc.getCount(), Integer::sum);
//        end = cc.getJ();
//        len = getMaxLen(windowHm, k);
//        if(maxLen < len){
//            maxLen = len;
//            bestStart = start;
//            bestEnd = end;
//        }
//
//        //second
//        if(l.size() > 1){
//            cc = l.get(1);
//            windowHm.merge(cc.getC(), cc.getCount(), Integer::sum);
//            end = cc.getJ();
//            len = getMaxLen(windowHm, k);
//            if(maxLen < len){
//                maxLen = len;
//                bestStart = start;
//                bestEnd = end;
//            }
//        }
//
//
//        //remaining
//        for(int ind=2; ind<l.size(); ind++){
//            cc = l.get(ind); //one block at a time
//
//            if(windowHm.containsKey(cc.getC())){
//                windowHm.merge(cc.getC(), cc.getCount(), Integer::sum);
//                end = cc.getJ();
//            }
//            else {
//                //start new window from last itr
//                //of course not to forget the current one
//                windowHm = new HashMap<>();
//
//                cc = l.get(ind-1);
//
//                windowHm.put(cc.getC(), cc.getCount());
//                start = cc.getI();
//
//                CharCount curr = l.get(ind);
//                windowHm.put(curr.getC(), curr.getCount());
//                end = curr.getJ();
//            }
//
//            len = getMaxLen(windowHm, k);
//            if(maxLen < len){
//                maxLen = len;
//                bestStart = start;
//                bestEnd = end;
//            }
//        }
//
//        return maxLen;
//    }

   static public int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int start = 0, end = 0, n = s.length();

        int maxLen = 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put(str[start], 1);
        maxLen = 1;

        while(end < n){                                 // yaha par start < end nahi ayega, ayega bhi to start <= end ayega
//            hm.merge(str[end], 1, Integer::sum);   // this is the last mistake which is corrected now


            System.out.println("StartEnd" + start + " " + end + " returning isPossible:" + possible(hm, k));
            while (start < end && !possible(hm, k)){    // start < end laga sakte hai yaha par
//                hm.compute(str[start], (key,value) -> value-1);
                hm.merge(str[start], -1, Integer::sum);
                start++;
            }
            if(!possible(hm, k)){
                start--;
                hm.compute(str[start], (key,value) -> value+1);
            }

            if(maxLen < end-start+1){
                    maxLen = end-start+1;
                    System.out.print(" changing this time len: " + maxLen + "\n" );
            }

            if(++end < n)
                hm.merge(str[end], 1, Integer::sum);
//            end++;
        }

        return maxLen;
    }

   static private boolean possible(HashMap<Character, Integer> hm, int k) {
        if(hm.size() == 2) {
            int minV = Integer.MAX_VALUE;
            int maxV = Integer.MIN_VALUE;
            for (Integer value : hm.values()) {
                minV = Math.min(minV, value);
                maxV = Math.max(maxV, value);
            }

            boolean isValidHm = minV <= k;
            System.out.print(minV + " " + k + " ...." + hm.toString() + "...." + "\n");
            return isValidHm;
        }
        else if (hm.size() == 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s="AABABBA";
        int k=1;

        System.out.println("ans " + characterReplacement(s, k));

    }
}
