package nl.edmi.NeuralNetwork;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ivan on 19/12/2016.
 */
public class NeuralNet {

    int inputLayer = 2;
    int hiddenLayer = 3;
    int outputLayer = 1;

    ArrayList<ArrayList<ArrayList<Double>>> synaps;
    // synaps[colum][nodeFrom][nodeTo]
    ArrayList<ArrayList<Double>> node;


    public NeuralNet(){
        node = new ArrayList<ArrayList<Double>>();
        for (int colum=0; colum < 3; colum++) {
            node.add(new ArrayList<Double>());

            for (int nodeT=0; nodeT < inputLayer; nodeT++) {
                node.get(0).add(0.0);
            }

            for (int nodeT=0; nodeT < hiddenLayer; nodeT++) {
                node.get(1).add(0.0);
            }

            for (int nodeT=0; nodeT < outputLayer; nodeT++) {
                node.get(2).add(0.0);
            }
        }
        //Arrays.toString(node);

        synaps = new ArrayList<ArrayList<ArrayList<Double>>>();
        for (int colum=0; colum < 2; colum++) {
            synaps.add(new ArrayList<ArrayList<Double>>());
            for (int nodeFrom=0; nodeFrom < 3; nodeFrom++) {
                synaps.get(colum).add(new ArrayList<Double>());
                for (int nodeTo=0; nodeTo < 3; nodeTo++) {
                    System.out.println(colum);
                    System.out.println(nodeFrom);
                    System.out.println(nodeTo);
                    System.out.println("------");
                    synaps.get(colum).get(nodeFrom).add(1.0);
                }
            }
        }

    }

    public double CalculateOutput(int[] inputs){
       return 0;
    }
}
