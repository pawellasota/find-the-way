package com.codecool.findtheway.reader;


import com.codecool.findtheway.model.Edge;
import com.codecool.findtheway.model.Vertex;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TripReader {

    private List<Vertex> nodes = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();
    private Vertex start;
    private Vertex end;
    private String filePath;

    public TripReader(String fileName) throws IOException{
        this.filePath = new File("").getAbsolutePath()+"/src/test/resources/files/"+fileName;
        this.setNodes();
        this.setEdges();
    }

    public List<Vertex> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    private List<String> readFile() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            List<String> outputList = new ArrayList<>();
            String line;
            while ((line = in.readLine()) != null) {
                outputList.add(line);
            }
            return outputList;
        }
    }

    private void setNodes() throws IOException, ArrayIndexOutOfBoundsException, NumberFormatException {
        List<String> readedFileinList = this.readFile();
        for (String line : readedFileinList) {
            String[] tripArray = line.split(" ");
            if (tripArray.length == 2) {
                this.start = this.getVertexBy(tripArray[0]);
                this.end = this.getVertexBy(tripArray[1]);
                break;
            }
            if (!this.nodes.contains((this.getVertexBy(tripArray[0])))) {
                nodes.add(new Vertex(tripArray[0]));
            }
            if (!this.nodes.contains((this.getVertexBy(tripArray[1])))) {
                nodes.add(new Vertex(tripArray[1]));
            }
        }
    }

    private void setEdges() throws IOException, ArrayIndexOutOfBoundsException, NumberFormatException{
        List<String> readedFileinList = this.readFile();
        for (String line : readedFileinList) {
            String[] tripArray = line.split(" ");
            if (tripArray.length == 2) {
                break;
            }
            Vertex source = getVertexBy(tripArray[0]);
            Vertex destiny = getVertexBy(tripArray[1]);
            if (!(Integer.valueOf(tripArray[2]).getClass().equals(Integer.class))) {
                throw new NumberFormatException();
            }
            int weight = Integer.parseInt(tripArray[2]);
            int costs = Integer.parseInt(tripArray[2]);
            this.edges.add( new Edge(source, destiny, 0, costs));
        }
    }

        private Vertex getVertexBy(String name) {
        for (Vertex node : this.nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

}
