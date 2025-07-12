package Practice.Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encodeDecode {
//    public String encode(List<String> strs) {
//        if(strs.size() == 0){
//            return null;
//        }
//
//        List<List<String>> strsInt = new ArrayList<>();
//        for(int i=0; i<strs.size(); i++){
//            List<String> sInt = new ArrayList<>();
//
//            String s = strs.get(i);
//            if(s.length() == 0){
//                sInt.add("0");
//            }
//            else if(s.length() == 1){
//                sInt.add(String.valueOf(s.charAt(0)-'\0'));
//            }
//            else
//            for(char c: s.toCharArray()){
//                sInt.add(String.valueOf(c-'\0'));
//                sInt.add(" ");
//            }
//
//            strsInt.add(sInt);
//        }
//
//        StringBuilder ans = new StringBuilder();
//        if(strsInt.size() == 1){
//            ans.append(strsInt.getFirst());
//        }
//        else {
//            strsInt.forEach(sInt -> {ans.append(sInt); ans.append('+');});
//        }
//        return ans.toString();
//    }
//
//    public List<String> decode(String str) {
//        List<String> ans = new ArrayList<>();
//
//        if(str == null){
//            return ans;
//        }
//
//       //no numeric ones are called to be exception
//
//        String[] split = str.split("\\+");
//        for (String s : split) {
//            String[] split1 = s.split(" ");
//            StringBuilder string  = new StringBuilder();
//            for(String split1str : split1)
//             string.append((char) (Integer.parseInt(s)));
//            ans.add(string.toString());
//        }
//        return ans;
//    }


//    public String encode(List<String> strs) {
//        if(strs.size() == 0){
//            return null;
//        }
//
//        List<List<String>> strsInt = new ArrayList<>();
//        for(int i=0; i<strs.size(); i++){
//            List<String> sInt = new ArrayList<>();
//
//            String s = strs.get(i);
//            if(s.length() == 0){
//                sInt.add(String.valueOf(Integer.MAX_VALUE));
//            }
//            else if(s.length() == 1){
//                sInt.add(String.valueOf(s.charAt(0)-'\0'));
//            }
//            else
//                for(char c: s.toCharArray()){
//                    sInt.add(String.valueOf(c-'\0'));
//                    sInt.add(" ");
//                }
//
//            strsInt.add(sInt);
//        }
//
//        StringBuilder ans = new StringBuilder();
//        if(strsInt.size() == 1){
//            ans.append(strsInt.get(0));
//        }
//        else {
//            strsInt.forEach(sInt -> {
//                        sInt.forEach(s -> {ans.append(s);});
//                        ans.append('+');
//                    }
//            );
//        }
//        return ans.toString();
//    }
//
//    public List<String> decode(String str) {
//        List<String> ans = new ArrayList<>();
//
//        if(str == null){
//            return ans;
//        }
//
//        //no numeric ones are called to be exception
//
//        String[] split = str.split("\\+");
//        for (String s : split) {
//            String[] split1 = s.split(" ");
//
//            for(var e: split1)
//                System.out.print(", " + e);
//
//            System.out.print("\n");
//            StringBuilder string  = new StringBuilder();
//
//            if(split1.length == 1){
//                int integer = Integer.parseInt(split1[0]);
//                if (Integer.MAX_VALUE != integer) {
//                    string.append((char) integer);
//                }
//            }
//            else
//                for(String split1str : split1)
//                    string.append((char) (Integer.parseInt(split1str)));
//            ans.add(string.toString());
//        }
//        return ans;
//    }

//***********second
//    public String encode(List<String> strs) {
//        if(strs.size() == 0){
//            return null;
//        }
//
//        List<List<String>> strsInt = new ArrayList<>();
//        for(int i=0; i<strs.size(); i++){
//            List<String> sInt = new ArrayList<>();
//
//            String s = strs.get(i);
//            if(s.length() == 0){
//                sInt.add(String.valueOf(Integer.MAX_VALUE-10));
//            }
//            else if(s.length() == 1){
//                sInt.add(String.valueOf(s.charAt(0)-'\0'));
//            }
//            else
//                for(char c: s.toCharArray()){
//                    sInt.add(String.valueOf(c-'\0'));
//                    sInt.add(" ");
//                }
//
//            strsInt.add(sInt);
//        }
//
//        StringBuilder ans = new StringBuilder();
//        if(strsInt.size() == 1){
//            ans.append(strsInt.get(0));
//        }
//        else {
//            strsInt.forEach(sInt -> {
//                        sInt.forEach(s -> {ans.append(s);});
//                        ans.append('+');
//                    }
//            );
//        }
//        return ans.toString();
//    }
//
//    public List<String> decode(String str) {
//        List<String> ans = new ArrayList<>();
//
//        if(str == null){
//            return ans;
//        }
//
//        //no numeric ones are called to be exception
//
//        String[] split = str.split("\\+");
//        for (String s : split) {
//            String[] split1 = s.split(" ");
//
//            System.out.print("\n");
//            StringBuilder string  = new StringBuilder("");
//
//            if(split1.length == 1){
//                String sp = split1[0].replace("[","").replace("]","");
//                int integer = Integer.parseInt(sp);
//                if (Integer.MAX_VALUE-10 != integer) {
//                    string.append((char) integer);
//                }
//                else {
//                    string.append("");
//                }
//            }
//            else
//                for(String split1str : split1)
//                    string.append((char) (Integer.parseInt(split1str)));
//            ans.add(string.toString());
//        }
//        return ans;
//    }
    //["VeryLongStringWithoutAnySpacesOrSpecialCharactersRepeatedManyTimesVeryLongStringWithoutAnySpacesOrSpecialCharactersRepeatedManyTimes"]






    //new way, my way

    public static String encode(List<String> strs) {
        String ans = "";
        String enc = "";
        for(int i=0; i<strs.size(); i++){
            String s = strs.get(i);
            enc = "";

                for (Character c : s.toCharArray()) {
                    if (c.equals(Character.MIN_VALUE)) {
                        enc += Character.MAX_VALUE;
                    } else
                        enc += (char) (c - 1);
                }
//                System.out.println("enc:"+enc);

            ans += enc + ",";
        }

        return ans;
    }

    public static List<String> decode(String str) {
        String[] strs = str.split(",", -1);
        List<String> ans = new ArrayList<>();

        for(String s: strs){
            String dec = "";

            for(Character c: s.toCharArray()){
                char decChar = 0;
                if(c.equals(Character.MAX_VALUE)){
                    decChar = Character.MIN_VALUE;
                }
                else {
                   decChar = (char)(c+1);
                }
                dec += decChar;
            }

//            System.out.println("dec" + dec);
            ans.add(dec);
        }

        ans.removeLast();

        return ans;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList(""));
        String a = encode(strs);
        System.out.println(a);
        List<String> result = decode(a);
        System.out.println(result);

        System.out.println(result.size());  // Output: 1
        System.out.println("->" + result.getFirst() + "<-");  // Output: -><-

//        String ans = ",";
//        String[] result = ans.split(",",-1);
//        System.out.println(Arrays.toString(result));
    }
}
