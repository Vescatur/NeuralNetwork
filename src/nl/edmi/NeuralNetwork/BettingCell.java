package nl.edmi.NeuralNetwork;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ivan on 25-12-2016.
 */
public class BettingCell {

    double cost=0;

    public BettingCell(){

    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // answer[0] = 0.2 <-> 0.8 -> hoeveel je bied van 5<->10
    // answer[1] = 0.5 -> onder 0.5 is doorgaan
    public BetAnswer FirstMove(double random){
        BetAnswer answer = new BetAnswer(random/2,0.0);
        return answer;
    }

    // answer[0] = 0.2 <-> 0.8 -> hoeveel je bied van 0<->10
    // answer[1] = 0.5 -> onder 0.5 is doorgaan
    public BetAnswer SecondMove(double random,double hand,double inzet,double verlies){
            return new BetAnswer(hand,0.0);
    }

    // answer[0] = 0.5 -> onder 0.5 is doorgaan
    public BetAnswer ThirdMove(double random,double hand,double inzet,double verlies){
        if(random==0.8){
            return new BetAnswer(hand,0.0);
        }else{
            return new BetAnswer(hand,0.0);
        }
    }




    public String toString(){
        return "hey";
    }
}
