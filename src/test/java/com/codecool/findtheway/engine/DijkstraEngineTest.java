package com.codecool.findtheway.engine;


import com.codecool.findtheway.model.Graph;
import com.codecool.findtheway.model.Vertex;
import com.codecool.findtheway.reader.TripReader;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DijkstraEngineTest {

    private DijkstraEngine dijkstraEngine;
    private TripReader tripReader;
    private Graph graph;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception{
        this.tripReader = new TripReader("cities.txt");
        this.graph = new Graph(tripReader.getNodes(), tripReader.getEdges());
        this.dijkstraEngine = new DijkstraEngine(graph);
    }

    @Test
    void testIfGetPathReturnsShortestPath(){
        List<Vertex> expectedPath = new ArrayList<>();
        expectedPath.addAll(Arrays.asList(new Vertex("Warsaw"),
                                          new Vertex("London"),
                                          new Vertex("Athens")));
        this.dijkstraEngine.execute(this.tripReader.getStart());
        List<Vertex> path = this.dijkstraEngine.getPath(this.tripReader.getEnd());
        assertEquals(expectedPath, path);
    }

    @Test
    void testIfGetCostsReturnsProperTravelCosts() {
        Integer expectedCosts = 950; //Warsaw - Athens trip cost
        this.dijkstraEngine.execute(this.tripReader.getStart());
        List<Vertex> path = this.dijkstraEngine.getPath(this.tripReader.getEnd());
        assertEquals(expectedCosts, this.dijkstraEngine.getCosts(path));
    }
}