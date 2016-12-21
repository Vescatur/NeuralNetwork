package nl.edmi.NeuralNetwork;

import java.util.ArrayList;

/**
 * Created by Ivan on 20-12-2016.
 */
public class Cell {
    NeuralNet Net;
    private double cost;

    public Cell(){
        Net = new NeuralNet();

        for (int colum=0; colum < Net.nodes.size()-1; colum++) {
            for (int nodeFrom=0; nodeFrom < Net.nodes.get(colum).size(); nodeFrom++) {
                for (int nodeTo=0; nodeTo < Net.nodes.get(colum+1).size(); nodeTo++) {
                    Net.synaps.get(colum).get(nodeFrom).set(nodeTo,Math.random()*2-1);
                }
            }
        }
    }

    public String toString(){
        return cost +"";
    }

    public double GetScore(double[] input) {
        return Net.CalculateOutput(input);
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

}
