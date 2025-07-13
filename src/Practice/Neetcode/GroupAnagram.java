package Practice.Neetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagram {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, ArrayList<String>> group = new HashMap<>();
//
//        for(String s: strs){
//            TreeMap<Character, Integer> treeMap = new TreeMap<>();
//            for(char c: s.toCharArray()){
//                if(!treeMap.containsKey(c))
//                    treeMap.put(c, 1);
//                else treeMap.put(c, 1+treeMap.get(c));
//            }
//
//            String countMap = treeMap.toString();
//            if(!group.containsKey(countMap)){
//                ArrayList arrayList = new ArrayList<>();
//                arrayList.add(s);
//                group.put(countMap, arrayList);
//            }
//            else {
//                group.get(countMap).add(s);
//            }
//        }
//
//        return new ArrayList<>(group.values());
//    }
public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> group = new HashMap<>();

    for(var s: strs){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char c: s.toCharArray()){
            freqMap.computeIfPresent(c, (k,v)->v+1);
            freqMap.putIfAbsent(c,1);
        }
        String hash = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> (char) c)
                .map(c -> {
                            StringBuilder str = new StringBuilder();
                            str.append(c).append(freqMap.getOrDefault(c, 0));
                            return str;
                        }
                ).collect(Collectors.joining()).toString();

//        group.computeIfPresent(hash, (k,v) -> {
//            v.add(s);
//            return v;
//        });
//        group.computeIfAbsent(hash, e -> {
//            List<String> objects = new ArrayList<>();
//            objects.add(s);
//            return objects;
//        });

        group.computeIfAbsent(hash, e -> new ArrayList<>()).add(s);

    }

    return new ArrayList<>(group.values());
}
}
