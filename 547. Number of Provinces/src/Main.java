import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        findCircleNum(new int[][]{
                {1,1,0},{1,1,0},{0,0,1}
        });
    }

    public static int findCircleNum(int[][] isConnected) {
        List<Integer> cities = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            cities.add(i);
        }
        List<Set<Integer>> provinces = new ArrayList<>();

        while (!cities.isEmpty()) {
            Set<Integer> currentProvince = new HashSet<>();
            List<Integer> citiesToVisit = new ArrayList<>();
            citiesToVisit.add(cities.get(0));
            while (!citiesToVisit.isEmpty()) {
                Integer cityVisited = citiesToVisit.remove(0);
                cities.remove(cityVisited);
                currentProvince.add(cityVisited);
                for (int i = 0; i < isConnected.length; i++) {
                    if (isConnected[cityVisited][i] == 1 && !currentProvince.contains(i)) {
                        citiesToVisit.add(i);
                    }
                }
            }
            provinces.add(currentProvince);
        }
        return provinces.size();
    }
}