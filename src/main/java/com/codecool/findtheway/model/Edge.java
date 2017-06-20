package com.codecool.findtheway.model;


public class Edge {
    private Vertex source;
    private Vertex destination;
    private int weight;
    private int costs;

    public Edge(Vertex source, Vertex destination, int weight, int costs) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.costs = costs;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getCosts() {
        return costs;
    }

    public Vertex getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }
}
