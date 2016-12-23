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

    public Cell Clone(){
        Cell cell = new Cell();

        for (int colum=0; colum < cell.Net.nodes.size()-1; colum++) {
            for (int nodeFrom=0; nodeFrom < cell.Net.nodes.get(colum).size(); nodeFrom++) {
                for (int nodeTo=0; nodeTo < cell.Net.nodes.get(colum+1).size(); nodeTo++) {
                    cell.Net.synaps.get(colum).get(nodeFrom).set(nodeTo,((Math.random()-0.5)/5)+Net.synaps.get(colum).get(nodeFrom).get(nodeTo));
                }
            }
        }

        return cell;
    }

}
