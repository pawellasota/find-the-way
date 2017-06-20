package com.codecool.findtheway.ui;


import com.codecool.findtheway.model.Vertex;

import java.util.List;

public class Ui {

    public static void displayTrip(List<Vertex> path, Integer costs) {
        System.out.println("Shortest trip:");
        for (Vertex vertex : path) {
            System.out.println(Integer.toString(path.indexOf(vertex)+1)+". "+vertex.getName());
        }
        System.out.println("Overall costs: " + costs);
    }
}
