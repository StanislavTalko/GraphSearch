public class DepthSearch extends Search {
    public static boolean depthSearch() {
        int[][] graph = createGraph();
        open.add(0, getAndSetStart());
        int finish = getAndSetFinish();

        while (!open.isEmpty()) {
            int currentVertex = open.get(0);
            if (currentVertex == finish) return true;
            else {
                open.remove(0);
                closed.add(currentVertex);
                for (int i = 0; i < graphSize; i++)
                    if (!open.contains(i) | !closed.contains(i))
                        if (graph[currentVertex][i] == 1) open.add(0, i);
            }
            print(open);
        }
        return false;
    }
}
