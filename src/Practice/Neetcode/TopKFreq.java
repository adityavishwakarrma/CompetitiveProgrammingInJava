package Practice.Neetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFreq {

    class Pair{
        int num;
        Integer count;

        public Pair(Integer count, int num) {
            this.count = count;
            this.num = num;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int e :  nums){
            if(!countMap.containsKey(e))
                countMap.put(e, 1);
            else countMap.put(e, 1+countMap.get(e));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2)->p2.count.compareTo(p1.count));
        for(var e: countMap.entrySet()){
            pq.offer(new Pair(e.getKey(), e.getValue()));
        }

        int[] ans = new int[k];
        int i=0;
        while(k-- > 0){
            Pair poll = pq.poll();
            assert poll != null;
            ans[i++] = poll.num;
        }

        return ans;
    }
}
