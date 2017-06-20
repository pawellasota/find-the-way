package com.codecool.findtheway;


import com.codecool.findtheway.engine.DijkstraEngine;
import com.codecool.findtheway.model.Graph;
import com.codecool.findtheway.model.Vertex;
import com.codecool.findtheway.reader.TripReader;
import com.codecool.findtheway.ui.Ui;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            TripReader tripReader = new TripReader("cities.txt");
            Graph graph = new Graph(tripReader.getNodes(), tripReader.getEdges());
            DijkstraEngine dijkstra = new DijkstraEngine(graph);
            dijkstra.execute(tripReader.getStart());
            List<Vertex> path = dijkstra.getPath(tripReader.getEnd());
            Integer costs = dijkstra.getCosts(path);
            Ui.displayTrip(path, costs);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
