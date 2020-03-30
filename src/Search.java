import java.io.*;
import java.util.ArrayList;

public abstract class Search {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected static ArrayList<Integer> open = new ArrayList<>();
    protected static ArrayList<Integer> closed = new ArrayList<>();
    protected static int graphSize;
    private static int currentIndex = -1;

    public static int[][] createGraph() {
        try {
            FileInputStream inputStream = new FileInputStream("graph.txt");
            byte[] str = new byte[inputStream.available()];
            inputStream.read(str);
            String text = new String(str);

            String[] numbers = text.split("\\D");
            graphSize = next(numbers);
            int[][] graph = new int[graphSize][graphSize];

            System.out.println("Матрица смежности графа");
            for (int i = 0; i < graphSize; ++i) {
                for (int j = 0; j < graphSize; ++j) {
                    graph[i][j] = next(numbers);
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
            inputStream.close();
            return  graph;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int getAndSetStart() {
        try {
            System.out.println("От 0 до 9: ");
            System.out.print("Введите начальную вершину: ");
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Неверные координаты");
            e.printStackTrace();
            return 0;
        }
    }

    public static int getAndSetFinish() {
        try {
            System.out.print("Введите конечную вершину: ");
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //From String to int
    private static Integer next(String[] numbers) {
        ++currentIndex;
        while (currentIndex < numbers.length
                && numbers[currentIndex].equals(""))
            ++currentIndex;
        return currentIndex < numbers.length ? Integer
                .parseInt(numbers[currentIndex]) : null;
    }

    public static void print(ArrayList<Integer> list) {
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
