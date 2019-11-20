import java.util.*;
import javafx.util.Pair;

public class Graph {
    private ArrayList<Vertex> Vertices = new ArrayList<>();
    public int infinity = Integer.MAX_VALUE; //setting a variable to the number closest to infinity as we can get

    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        Vertices.add(v);
    }

    public Vertex getvertex(String s) {
        for (Vertex v : Vertices) {
            if (v.Name == s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge = new Edge(from, to);
        newedge.distance = dist;
        newedge.time = tim;
    }

    public Pair<Integer, Map<Vertex, Vertex>> ShortestDistance(Vertex source, Vertex zink) {
        Map<Vertex, Vertex> PredecessorMap = new HashMap<>();
        Map<Vertex, Integer> DistanceMap = new HashMap<>();

        // initialize arrays
        for (Vertex v : Vertices) {
            DistanceMap.put(v, infinity);
            PredecessorMap.put(v, null);

        }
        DistanceMap.replace(source, 0);
        distanceVertex(source, PredecessorMap, DistanceMap);

        return (new Pair<Integer, Map<Vertex, Vertex>>(DistanceMap.get(zink), PredecessorMap));
    }
    public Pair<Integer, Map<Vertex, Vertex>> ShortestTime(Vertex source, Vertex destination) {
        Map<Vertex, Vertex> PredecessorMapTime = new HashMap<>();
        Map<Vertex, Integer> DistanceMapTime = new HashMap<>();
        //initialize arrays

        for (Vertex v : Vertices) {
            DistanceMapTime.put(v, infinity);
            PredecessorMapTime.put(v, null);
        }
        DistanceMapTime.replace(source, 0);
        timeVertex(source, PredecessorMapTime, DistanceMapTime);
        return (new Pair<Integer, Map<Vertex, Vertex>>(DistanceMapTime.get(destination), PredecessorMapTime));
    }

    public void distanceVertex(Vertex vertex, Map<Vertex, Vertex> predecessorMap, Map<Vertex, Integer> distanceMap) {
        System.out.println("Vertex analyze");
        for (int i = 0; i < vertex.OutEdges.size(); i++) {
            System.out.println("Edge analyze");
            if (vertex.OutEdges.get(i).distance + distanceMap.get(vertex) < distanceMap.get(vertex.OutEdges.get(i).getTovertex()) || predecessorMap.get(vertex.OutEdges.get(i).getTovertex()) == null) {
                distanceMap.replace(vertex.OutEdges.get(i).getTovertex(), vertex.OutEdges.get(i).distance + distanceMap.get(vertex));
                predecessorMap.replace(vertex.OutEdges.get(i).getTovertex(), vertex);
                distanceVertex(vertex.OutEdges.get(i).getTovertex(), predecessorMap, distanceMap);
                System.out.println("Path found");
            }
        }
    }


        public void timeVertex(Vertex vertex, Map<Vertex, Vertex> predecessorMap, Map<Vertex,Integer> DistanceMapTime){
            System.out.println("Setting time distance from " + vertex.Name);
            for (int i = 0; i < vertex.OutEdges.size() ;i++) {
                if (vertex.OutEdges.get(i).time+DistanceMapTime.get(vertex)<DistanceMapTime.get(vertex.OutEdges.get(i).getTovertex()) || predecessorMap.get(vertex.OutEdges.get(i).getTovertex()) == null) {
                    DistanceMapTime.replace(vertex.OutEdges.get(i).getTovertex(),vertex.OutEdges.get(i).time+DistanceMapTime.get(vertex));
                    predecessorMap.replace(vertex.OutEdges.get(i).getTovertex(),vertex);
                    System.out.println(vertex.Name + " to " + vertex.OutEdges.get(i).getTovertex().Name + " is " + vertex.OutEdges.get(i).time);
                    timeVertex(vertex.OutEdges.get(i).getTovertex(),predecessorMap,DistanceMapTime);
                    System.out.println("path found");
                }
            }
    }
}



class Vertex{
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();
    public  Vertex(String id){
        Name=id;
    }
    public void addOutEdge(Edge outedge){
        OutEdges.add(outedge);
    }
    public ArrayList<Edge> getOutEdges(){return OutEdges;}
}

class Edge{
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance=0;
    public int time=0;

    public Vertex getTovertex() {
        return tovertex;
    }

    public Edge(Vertex from, Vertex to){
        fromvertex=from;
        tovertex=to;
        fromvertex.addOutEdge(this);
        //If not directional
        tovertex.addOutEdge(this);
    }
}