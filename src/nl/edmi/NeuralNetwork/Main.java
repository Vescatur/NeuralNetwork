package nl.edmi.NeuralNetwork;

public class Main {

    public Main(){
        NeuralNet Net = new NeuralNet();
        double[] inputs = {1.0,1.0};
        System.out.println(Net.CalculateOutput(inputs));
    }

    public static void main(String[] args) {
        new Main();
 	    System.out.println("stop");
    }
}

