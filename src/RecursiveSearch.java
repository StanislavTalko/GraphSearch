import java.util.ArrayList;
import java.util.List;

public class RecursiveSearch extends Search { ;
    static int[][] graph = createGraph();
    static List<Integer> path = new ArrayList<>();
    static int finish = getAndSetFinish();

    public static boolean recursiveDepthSearch(int currentVertex) {
        if (currentVertex == finish) {
            System.out.println(path);
            return true;
        } else {
            closed.add(currentVertex);
            for (int i = 0; i < graphSize; i++) {
                if (!closed.contains(i)) {
                    if (graph[currentVertex][i] == 1) {
                        path.add(i);
                        if (recursiveDepthSearch(i) == true) return true;
                    }
                }
            }
        }
        return false;
    }
}
