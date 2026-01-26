import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keysInHand = new HashSet<>();
        Set<Integer> keysUsed = new HashSet<>();
        keysInHand.add(0);

        while (!keysInHand.isEmpty()){
            Set<Integer> unusedKeysInHand = new HashSet<>();
            for (Integer key: keysInHand){
                keysUsed.add(key);
                unusedKeysInHand.addAll(rooms.get(key));
                unusedKeysInHand.removeAll(keysUsed);
            }
            keysInHand = unusedKeysInHand;
        }

        return keysUsed.size() == rooms.size();

    }
}