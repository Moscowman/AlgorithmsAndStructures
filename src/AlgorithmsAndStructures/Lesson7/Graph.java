package AlgorithmsAndStructures.Lesson7;

import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;
    private int[][] weightMat;
    private boolean isOriented;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
        this.weightMat = new int[maxVertexCount][maxVertexCount];
        isOriented = false;
    }

    public Graph(int maxVertexCount, boolean isOriented) {
        this(maxVertexCount);
        this.isOriented = isOriented;
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    public void addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][endIndex] = true;
        if (!isOriented) {
            adjMat[endIndex][startIndex] = true;
        }
    }

    public void addEdge(String startLabel, String endLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][endIndex] = true;
        weightMat[startIndex][endIndex] = weight;
        if (!isOriented) {
            adjMat[endIndex][startIndex] = true;
            weightMat[endIndex][startIndex] = weight;
        }
    }

    public void addEdge(Edge edge) {
        addEdge(edge.startLabel, edge.endLabel, edge.weight);
    }

    public class Edge {
        public String startLabel;
        public String endLabel;
        public int weight;
    }

    public void addEdges(String startLabel, String secondLabel, String... others) {
        addEdge(startLabel, secondLabel);
        for (String other : others) {
            addEdge(startLabel, other);
        }
    }

    public void addEdges(Edge... edges) {
        for (Edge edge : edges) {
            addEdge(edge);
        }
    }

    private int indexOf(String vertexLabel) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexLabel.equals(vertexList.get(i).getLabel())) {
                return  i;
            }
        }
        return -1;
    }


    public int getVertexSize() {
        return vertexList.size();
    }

    public void display() {
        for (int i = 0; i < getVertexSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getVertexSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, stack);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(vertex, stack);
            }
            else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, queue);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(vertex, queue);
            }
            else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    public int[] deykstra(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        resetVertexState();

        int[] minimalPath = new int[vertexList.size()];
        minimalPath[startIndex] = 0;
        ArrayList<String>[] pathes = new ArrayList[minimalPath.length];
        for (int i = 0; i < minimalPath.length; i++) {
            pathes[i] = new ArrayList<String>();
        }

        for (int i = 0; i < minimalPath.length; i++) {
            if (i != startIndex) {
                minimalPath[i] = Integer.MAX_VALUE;
            }
        }

        while (true) {
            int minIndex = findLeastMinimalPath(minimalPath);
            if (minIndex == -1) {break;}
            vertexList.get(minIndex).setVisited(true);
            for (int i = 0; i < minimalPath.length; i++) {
                if (vertexList.get(i).getVisited() || !adjMat[minIndex][i]) {
                    continue;
                }
                if (minimalPath[i] > minimalPath[minIndex] + weightMat[minIndex][i]) {
                    minimalPath[i] = minimalPath[minIndex] + weightMat[minIndex][i];
                    pathes[i] = (ArrayList<String>)pathes[minIndex].clone();
                    pathes[i].add(vertexList.get(i).getLabel());
                }
            }
        }

        System.out.println("Алгоритм Дейкстры\n");

        for (int i = 0; i < minimalPath.length; i++) {
            System.out.println("Длина пути от вершины " + startLabel + " до вершины " + vertexList.get(i).getLabel() + " = " + minimalPath[i]);
            System.out.println("Путь до вершины " + pathes[i].toString());
        }

        return minimalPath;
    }



    private int findLeastMinimalPath(int[] minimalPath) {
        int minD = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < minimalPath.length; i++) {
            if (vertexList.get(i).getVisited()) {
                continue;
            }
            if (minimalPath[i] < minD) {
                minD = minimalPath[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < getVertexSize(); i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).getVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Vertex vertex, Stack<Vertex> stack) {
        System.out.println(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }
    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        System.out.println(vertex);
        queue.add(vertex);
        vertex.setVisited(true);
    }
}
