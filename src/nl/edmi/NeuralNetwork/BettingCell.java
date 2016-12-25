package nl.edmi.NeuralNetwork;

/**
 * Created by Ivan on 25-12-2016.
 */
public class BettingCell {

    public BettingCell(){

    }

    public double FirstMove(double random){
        return 0.5+(random/2);
    }

    public double SecondMove(double random,double hand,double inzet){
        return hand;
    }

    public double ThirdMove(double random,double hand,double inzet){
        return 1;
    }




    public String toString(){
        return "hey";
    }
}
