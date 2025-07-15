package Practice.Neetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinWindowSubstr {
    public String minWindow2ndtry(String s, String t) {
        HashMap<Character, Integer> tfreqMap = getFreqMap(new StringBuilder(t));

        int minWinLen = Integer.MAX_VALUE;
        int minWinStart = -1;

        //        Integer i=0, j=s.length()-1;
        //        if(compareMap(sfreqMap, tfreqMap)){
        //            int win = j-i+1;
        //            if(minWin > win){
        //                minWin = win;
        //                minWinStart = i;
        //            }
        //
        //        }else {
        //            return "";
        //        }

        int j = 0;
        int i = 0;

        StringBuilder sub = new StringBuilder();
        HashMap<Character, Integer> sfreqMap = getFreqMap(sub);

        while (j < s.length()) {
            sub.append(s.charAt(j));
            sfreqMap.merge(s.charAt(j), 1, Integer::sum);

            // if (compareMap(sfreqMap, tfreqMap)) {
            //     //record
            //     int winLen = j - i + 1;
            //     if (minWinLen > winLen) {
            //         minWinLen = winLen;
            //         minWinStart = i;
            //     }
            //     j++;
            //     break;
            // }

            if (compareMap(sfreqMap, tfreqMap)) {

                //record & shrink as well
                while (compareMap(sfreqMap, tfreqMap)) {
                    int winLen = j - i + 1;
                    if (minWinLen > winLen) {
                        minWinLen = winLen;
                        minWinStart = i;
                    }

                    // Try shrinking from the left
                    sfreqMap.compute(s.charAt(i), (k, v) -> v - 1);
                    sub.deleteCharAt(0);
                    i++;
                }

                j++;
                break;
            }

            j++;
        }

        for (; j < s.length(); j++) {
            sub.append(s.charAt(j));
            sfreqMap.merge(s.charAt(j), 1, Integer::sum);

            while (i < j && compareMap(sfreqMap, tfreqMap)) {
                boolean shifted = false;

                //shift i
                sfreqMap.compute(s.charAt(i), (k, v) -> v - 1);
                sub.deleteCharAt(0); //first index of substr
                i++;

                // present
                if (compareMap(sfreqMap, tfreqMap)) {
                    //finalize
                    shifted = true;
                } else { //revert
                    i--;
                    sfreqMap.compute(s.charAt(i), (k, v) -> v + 1);
                    sub.insert(0, s.charAt(i)); //add char at start
                }

                //record
                int winLen = j - i + 1;
                if (minWinLen > winLen) {
                    minWinLen = winLen;
                    minWinStart = i;
                }

                if (!shifted) {
                    break;
                }
            }
        }

        if (minWinLen != Integer.MAX_VALUE)
            return s.substring(minWinStart, minWinStart + minWinLen);
        else
            return "";
    }

    private HashMap<Character, Integer> getFreqMap(CharSequence s) {
        HashMap<Character, Integer> m = new HashMap<>();

        for (char c1 = 'a', c2 = 'A'; c1 <= 'z' && c2 <= 'Z'; c1++, c2++) {
            m.put(c1, 0);
            m.put(c2, 0);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.merge(c, 1, Integer::sum);
        }
        return m;
    }

    private boolean compareMap(HashMap<Character, Integer> sfreqMap, HashMap<Character, Integer> tfreqMap) {
        for (Map.Entry<Character, Integer> entry : tfreqMap.entrySet()) {
            if (sfreqMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }



/*  while(i<j && compareMap(sfreqMap, tfreqMap)){
            boolean shifted = false;

//          shift  i
            sfreqMap.compute(s.charAt(i), (k,v) -> v-1);
            i++;

            if(i<=j && compareMap(sfreqMap, tfreqMap)){
                //finalize
                shifted = true;
            }else {
                i--; //revert
                sfreqMap.compute(s.charAt(i), (k,v) -> v+1);

            }

//          shift j
            sfreqMap.compute(s.charAt(j), (k,v) -> v-1);
            j--;

            if(i<=j && compareMap(sfreqMap, tfreqMap)){
                //finalize
                shifted = true;
            }else {
                j++; //revert
                sfreqMap.compute(s.charAt(j), (k,v) -> v+1);

            }

            int win = j-i+1;
            if(minWin > win){
                minWin = win;
                minWinStart = i;
            }

            if(!shifted){
                break;
            }
        }

        if(minWinStart == -1){
            return "";
        }
        else {
            return s.substring(minWinStart, minWinStart+minWin);
        }*/

    protected class Result {
        private Integer minWinLen;
        private Integer minWinStart;

        protected Result(Integer minWinLen, Integer minWinStart) {
            this.minWinLen = minWinLen;
            this.minWinStart = minWinStart;
        }

        protected Integer getMinWinLen() {
            return minWinLen;
        }

        protected void setMinWinLen(Integer minWinLen) {
            this.minWinLen = minWinLen;
        }

        protected Integer getMinWinStart() {
            return minWinStart;
        }

        protected void setMinWinStart(Integer minWinStart) {
            this.minWinStart = minWinStart;
        }
    }

    public String minWindow2(String s, String t) {
        Integer minWinLen = Integer.MAX_VALUE, minWinStart = -1;
        Result result = new Result(minWinLen, minWinStart);

        int l = 0, r = 0;

        HashMap<Character, Integer> sFreqMap = getFreqMap(new StringBuilder());
        HashMap<Character, Integer> tFreqMap = getFreqMap(new StringBuilder(t));

        Integer have = 0, need = 0;
        // only count non-zero frequencies in tFreqMap
        for (char c : tFreqMap.keySet()) {
            if (tFreqMap.get(c) > 0) need++;
        }


        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            if (tFreqMap.get(c) != 0) {
                sFreqMap.compute(c, (k, v) -> v + 1);
                if (Objects.equals(sFreqMap.get(c), tFreqMap.get(c))) {
                    have++;
                }
            }
            //have ++ logic
//            if (tFreqMap.get(c) != 0) {
//                int oldFreq = sFreqMap.get(c);
//                sFreqMap.compute(c, (k, v) -> v + 1);
//                if (oldFreq < tFreqMap.get(c) && sFreqMap.get(c).equals(tFreqMap.get(c))) {
//                    have++;
//                }
//            }

            //match & record
            if (match(have, need)) {
//                record(l,r,minWinLen, minWinStart);

                //try shrinking if not match revert
                do {
                    char c1 = s.charAt(l);
                    l++;
                    if (tFreqMap.get(c1) != 0) {
                        boolean toChange1 = false, toChange2 = false;
                        if (sFreqMap.get(c1) >= tFreqMap.get(c1)) {
                            toChange1 = true;
                        }
                        sFreqMap.compute(c1, (k, v) -> v - 1);
                        if (sFreqMap.get(c1) < tFreqMap.get(c1)) {
                            toChange2 = true;
                        }
                        if (toChange1 && toChange2) {
                            have--;
                        }
                    }
                    // have -- shrinking logic
//                    if (tFreqMap.get(c1) != 0) {
//                        int oldFreq = sFreqMap.get(c1);
//                        sFreqMap.compute(c1, (k, v) -> v - 1);
//                        if (oldFreq == tFreqMap.get(c1) && sFreqMap.get(c1) < tFreqMap.get(c1)) {
//                            have--;
//                        }
//                    }
                } while (match(have, need));

                if (!match(have, need)) {
                    //revert the last change
                    l--;
                    char c1 = s.charAt(l);
                    if (tFreqMap.get(c1) != 0) {
                        boolean toChange1 = false, toChange2 = false;
                        if (sFreqMap.get(c) < tFreqMap.get(c)) {
                            toChange1 = true;
                        }
                        sFreqMap.compute(c1, (k, v) -> v + 1);
                        if (sFreqMap.get(c1) >= tFreqMap.get(c1)) {
                            toChange2 = true;
                        }
                        if (toChange1 && toChange2) {
                            have++;
                        }
                    }
                    //have++ logic for revert to l side
//                    if (tFreqMap.get(c1) != 0) {
//                        int oldFreq = sFreqMap.get(c1);
//                        sFreqMap.compute(c1, (k, v) -> v + 1);
//                        if (oldFreq < tFreqMap.get(c1) && sFreqMap.get(c1).equals(tFreqMap.get(c1))) {
//                            have++;
//                        }
//                    }
                }

                if (match(have, need)) {
                    record(l, r, result);
                }
            }
        }

        return result.getMinWinLen().equals(Integer.MAX_VALUE) ? "" : s.substring(result.getMinWinStart(), result.getMinWinStart() + result.getMinWinLen());
    }

    private void record(int l, int r, Result result) {
        int winLen = r - l + 1;
        if (result.getMinWinLen() > winLen) {
            result.setMinWinStart(l);
            result.setMinWinLen(winLen);
        }
    }

    private boolean match(HashMap<Character, Integer> sFreqMap, HashMap<Character, Integer> tFreqMap) {
        for (Map.Entry<Character, Integer> entry : tFreqMap.entrySet()) {
            if (sFreqMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean match(Integer have, Integer need) {
        return have.equals(need);
    }


    public String minWindow3(String s, String t) {
        int start = -1, end = -1, minWindowLength = Integer.MAX_VALUE;

        HashMap<Character, Integer> tFreqMap = getFreqMapNew(t);
        HashMap<Character, Integer> sFreqMap = new HashMap<>();

        int i=0, j=0;
        int have = 0, need = tFreqMap.size();

        //expand j till match found
//        capture every j
//        j++
//        match found stop
        for(;;){
            char c = s.charAt(j);

            //process this char only if it is from t
            if(tFreqMap.containsKey(c)){
                sFreqMap.merge(c, 1, Integer::sum);
                if(Objects.equals(sFreqMap.get(c), tFreqMap.get(c))){
                    have++;
                }
            }

            j++;

            if(have == need){
                break;
            }
        }

        //calc substring
        int len = j-i+1;
        if(minWindowLength > len){
            start = i;
            end = j;
            minWindowLength = len;
        }

        //next j values we will process here

        for(; j<s.length(); j++){
        // process the new char at j
          //process this char only if it is from t
            char c = s.charAt(j);
            if(tFreqMap.containsKey(c)){
                sFreqMap.merge(c, 1, Integer::sum);
//                already a match
//                try shrinking window from left side till possible (match condition is valid)
                while (tFreqMap.containsKey(s.charAt(i)) && sFreqMap.get(s.charAt(i)) >= tFreqMap.get(s.charAt(i))){
                    char ch = s.charAt(i);
                    int oldSFreq = sFreqMap.get(ch);
                    int newSFreq = oldSFreq - 1;
                    boolean match = newSFreq >= tFreqMap.get(ch);
                    if (match) {
                        // finalize
                        i++;
                        sFreqMap.put(ch, newSFreq);

                        //calc substring
                        len = j - i + 1;
                        if (minWindowLength > len) {
                            start = i;
                            end = j;
                            minWindowLength = len;
                        }
                    }
                }
            }
        }

        return (Integer.MAX_VALUE ==  minWindowLength) ? "" : s.substring(start, end);
    }

    private HashMap<Character, Integer> getFreqMapNew(String t) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqMap.merge(c, 1, Integer::sum);
        }
        return freqMap;
    }
}