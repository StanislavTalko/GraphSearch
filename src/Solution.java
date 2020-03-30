import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите метод поиска: " +
                "1 - в ширину, " +
                "2 - в глубину, " +
                "3 - рекурсивно ");
        int method = 0;
        try {
            method = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (method) {
            case 1:
                if (WideSearch.breadthSearch()) System.out.println("Путь существует");
                else System.out.println("Путь не существует");
                break;
            case 2:
                if (DepthSearch.depthSearch()) System.out.println("Путь существует");
                else System.out.println("Путь не существует");
                break;
            case 3:
                if (RecursiveSearch.recursiveDepthSearch(Search.getAndSetStart()))
                    System.out.println("Путь существует");
                else System.out.println("Путь не существует");
                break;
        }
    }
}
