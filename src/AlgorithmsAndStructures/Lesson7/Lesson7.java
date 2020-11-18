package AlgorithmsAndStructures.Lesson7;

public class Lesson7 {
    public static void main(String[] args) {
        Graph graph = new Graph(10, false);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");
        graph.addEdge("Москва", "Тула", 200);
        graph.addEdge("Тула", "Липецк", 150);
        graph.addEdge("Липецк", "Воронеж", 210);
        graph.addEdge("Москва", "Рязань", 170);
        graph.addEdge("Рязань", "Тамбов", 240);
        graph.addEdge("Тамбов", "Саратов", 80);
        graph.addEdge("Саратов", "Воронеж", 60);
        graph.addEdge("Москва", "Калуга", 100);
        graph.addEdge("Калуга", "Орел", 270);
        graph.addEdge("Орел", "Курск", 95);
        graph.addEdge("Курск", "Воронеж", 85);


        int[] pathes = graph.deykstra("Москва");

    }
}
