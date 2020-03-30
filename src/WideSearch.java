public class WideSearch extends Search {
    public static boolean breadthSearch() {
        int[][] graph = createGraph();
        open.add(getAndSetStart());
        int finish = getAndSetFinish();

        while (!open.isEmpty()) {
            int currentVertex = open.get(0);
            if (currentVertex == finish) return true;
            else {
                open.remove(0);
                closed.add(currentVertex);
                for (int i = 0; i < graphSize; i++)
                    if (!open.contains(i) & !closed.contains(i))
                        if (graph[currentVertex][i] == 1) open.add(i);
            }
            print(open);
        }
        return false;
    }
}
