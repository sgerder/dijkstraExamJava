import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class GraphTests {

    public static void main(String[] args) {
        GraphTests TestGraph= new GraphTests();
        Graph g = TestGraph.portThreeGraph()    ;
        Vertex source = g.getvertex("10"); /*for the project we have been instructed to start at node 10 || if the user wants to test the given letter graph insert mygraph instead
        of portThreeGraph*/
        Vertex zink = g.getvertex("6"); //end node
        Pair<Integer, Map<Vertex, Vertex>> results=g.ShortestDistance(source, zink);
        Pair<Integer, Map<Vertex, Vertex>> timeResults = g.ShortestTime(source, zink);
        Vertex current = zink;
        Vertex currentTime = zink;
        ArrayList<Vertex> Path = new ArrayList<>();
        ArrayList<Vertex> PathTime = new ArrayList<>();
        Path.add(zink);
        PathTime.add(zink);
        while ((current != source) && (results.getValue().get(current)!=null))
        {
            current=results.getValue().get(current);
            Path.add(0,current);
        }
        System.out.println();
        System.out.println("The shortest destination path with current input is: ");

        for(Vertex v : Path)
        {
            System.out.print(v.Name);
            if (v!=zink)
                System.out.print("->");
        }

        while ((currentTime != source) && (timeResults.getValue().get(currentTime)!=null))  //doing the same thing as instructed above, with time instead.
        {
            currentTime=timeResults.getValue().get(currentTime);
            PathTime.add(0,currentTime);
        }

        System.out.println();
        System.out.println("The shortest time path with current input is: ");

        for(Vertex v : PathTime)
        {
            System.out.print(v.Name);
            if (v!=zink)
                System.out.print("->");
        }


    }
    public Graph portThreeGraph() {
        Graph portThreeGraph = new Graph();
        final Vertex One = portThreeGraph.addvertex("1");
        final Vertex Two = portThreeGraph.addvertex("2");
        final Vertex Three = portThreeGraph.addvertex("3");
        final Vertex Four = portThreeGraph.addvertex("4");
        final Vertex Five = portThreeGraph.addvertex("5");
        final Vertex Six = portThreeGraph.addvertex("6");
        final Vertex Seven = portThreeGraph.addvertex("7");
        final Vertex Eight = portThreeGraph.addvertex("8");
        final Vertex Nine = portThreeGraph.addvertex("9");
        final Vertex Ten = portThreeGraph.addvertex("10");

        portThreeGraph.newedge(One,Two,10,10000);
        portThreeGraph.newedge(One,Four,20,10000);
        portThreeGraph.newedge(One,Five,20,10000);
        portThreeGraph.newedge(One,Six,5,10000);
        portThreeGraph.newedge(One,Seven,15,10000);
        portThreeGraph.newedge(Two,Three,5,10000);
        portThreeGraph.newedge(Two,Four,10,10000);
        portThreeGraph.newedge(Three,Two,15,10000);
        portThreeGraph.newedge(Three,Four,5,10000);
        portThreeGraph.newedge(Four,Five,10,10000);
        portThreeGraph.newedge(Five,Six,5,10000);
        portThreeGraph.newedge(Seven,Six,10,10000);
        portThreeGraph.newedge(Eight,Seven,5,10000);
        portThreeGraph.newedge(Eight,One,5,10000);
        portThreeGraph.newedge(Eight,Two,20,10000);
        portThreeGraph.newedge(Nine,Eight,20,10000);
        portThreeGraph.newedge(Nine,Two,15,10000);
        portThreeGraph.newedge(Nine,Ten,10,10000);
        portThreeGraph.newedge(Ten,Two,5,10000);
        portThreeGraph.newedge(Ten,Three,5,10000);

        return portThreeGraph;
    }



    public Graph mygraph()
    {
        Graph mygraph= new Graph();
        final Vertex A = mygraph.addvertex("A");
        final Vertex B = mygraph.addvertex("B");
        final Vertex C = mygraph.addvertex("C");
        final Vertex D = mygraph.addvertex("D");
        final Vertex E = mygraph.addvertex("E");
        final Vertex F = mygraph.addvertex("F");

        mygraph.newedge(A,B,1,2);
        mygraph.newedge(A,C,5,1);
        mygraph.newedge(A,D,4,6);
        mygraph.newedge(B,C,3,2);
        mygraph.newedge(B,D,2,3);
        mygraph.newedge(B,E,2,4);
        mygraph.newedge(C,F,1,8);
        mygraph.newedge(C,E,2,2);
        mygraph.newedge(D,F,2,7);
        mygraph.newedge(E,F,3,6);

        return mygraph;

    }


    }
