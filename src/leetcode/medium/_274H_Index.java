package leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class _274H_Index {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1,3,1}));
    }
    public static int hIndex(int[] citations) {


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
            max = Math.max(max, citations[i]);
        }

        int[] countArray = new int[max + 1];

        for (int i = 0; i < citations.length; i++){
            for (int j = 0; j < countArray.length; j++) {
                if (citations[i] >= j){
                    countArray[j]++;
                }
            }
        }

        int maxInd = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (i <= countArray[i]){
                maxInd = i;
            }
        }

        return maxInd;

    }

//    public static void main(String[] args) {
//        Map<String, UserStats>[] stats = new Map[2];
//
//        HashMap<String, UserStats> stringUserStatsHashMap = new HashMap<>();
//        HashMap<String, UserStats> stringUserStatsHashMap1 = new HashMap<>();
//        stringUserStatsHashMap.put("1", new UserStats(Optional.of(1L)));
//        stringUserStatsHashMap.put("2", new UserStats(Optional.of(4L)));
//
//        stringUserStatsHashMap1.put("k1", new UserStats(Optional.of(1L)));
//        stringUserStatsHashMap1.put("2", new UserStats(Optional.of(4L)));
//
//        stats[0] = stringUserStatsHashMap;
//        stats[1] = stringUserStatsHashMap1;
//
//
//        System.out.println(count(stats));
//    }
//
//    static Map<Long, Long> count(Map<String, UserStats>... visits) {
//
//       if (visits == null || visits.length == 0){
//           return Collections.emptyMap();
//       }
//
//       List<Map.Entry<String, UserStats>> filtered =  Arrays.stream(visits)
//           .filter(Objects::nonNull)
//           .flatMap(visit -> visit.entrySet().stream())
//           .filter(visitEntry -> isValidLongKey(visitEntry.getKey()))
//           .filter(visitEntry ->
//               visitEntry.getValue() != null && visitEntry.getValue().getVisitCount().isPresent())
//           .toList();
//
//       Map<Long, Long> map = new HashMap<>();
//        for (Map.Entry<String, UserStats> entry : filtered){
//            Long keyLong = Long.parseLong(entry.getKey());
//           if(!map.containsKey(keyLong)){
//               map.put(keyLong, entry.getValue().getVisitCount().get());
//           } else {
//               map.computeIfPresent(keyLong, (k, v) -> v + entry.getValue().getVisitCount().get());
//           }
//        }
//
//        return map;
//    }
//
//    private static boolean isValidLongKey(String key){
//        try{
//            Long.parseLong(key);
//            return true;
//        } catch(NumberFormatException nfe){
//            return false;
//        }
//    }
}
