package nl.edmi.NeuralNetwork;

/**
 * Created by Ivan on 01/02/2017.
 */
public class BetAnswer {

    private double inzet;
    private boolean stoppen;

    public BetAnswer(double inzet, double stoppen){
        this.inzet = (Math.min(Math.max(0.1,inzet),0.9)-0.1)*12.5;
        this.stoppen = stoppen >0.8;
    }

    public double getInzet(){
        return inzet;
    }

    public boolean getStoppen(){
        return stoppen;
    }
    public String toString(){
        return Double.toString(inzet)+" "+Boolean.toString(stoppen);
    }

    public void FirstRoundInzet() {
        inzet = inzet/2+5;
    }
}
