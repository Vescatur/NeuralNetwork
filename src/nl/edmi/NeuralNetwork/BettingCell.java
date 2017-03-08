package nl.edmi.NeuralNetwork;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Ivan on 25-12-2016.
 */
public class BettingCell  implements Comparable<BettingCell> {

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
        if(random==0.5){
            BetAnswer answer = new BetAnswer(0,1.0);

        }
        BetAnswer answer = new BetAnswer(0,0.0);
        return answer;
    }

    // answer[0] = 0.2 <-> 0.8 -> hoeveel je bied van 0<->10
    // answer[1] = 0.5 -> onder 0.5 is doorgaan
    public BetAnswer SecondMove(double random,double hand,double inzet,double verlies){
            if(hand >= 0.7){
                return new BetAnswer(0.2,0.0);
            }else{
                return new BetAnswer(0,1.0);
            }
    }

    // answer[0] = 0.5 -> onder 0.5 is doorgaan
    public BetAnswer ThirdMove(double random,double hand,double inzet,double verlies){
        return new BetAnswer(0.2,0.0);
    }

    public BettingCell Clone(){
        return new BettingCell();
    }

    public String toString(){
        return "hey";
    }




    public int compare(BettingCell o1, BettingCell o2) {
        if(o1.cost==o2.cost) {
            return 0;
        }else if(o1.cost<o2.cost){
            return -1;
        }else{
            return 1;
        }
    }

    @Override
    public int compareTo(BettingCell o) {
        return compare(o,this);
    }
}