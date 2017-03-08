package nl.edmi.NeuralNetwork;

import java.util.ArrayList;

/**
 * Created by Ivan on 01/02/2017.
 */
public class BettingNeuralNetCell extends BettingCell {

    private NeuralNet Net1;
    private NeuralNet Net2;
    private NeuralNet Net3;


    public BettingNeuralNetCell(){
        int[] Layers1 = {1,3,2,2};
        Net1 = new NeuralNet(Layers1);
        int[] Layers2 = {4,5,4,3,2,2};
        Net2 = new NeuralNet(Layers2);
        int[] Layers3 = {4,5,4,3,2,2};
        Net3 = new NeuralNet(Layers3);
    }

    // answer[0] = 0.2 <-> 0.8 -> hoeveel je bied van 5<->10
    // answer[1] = 0.5 -> onder 0.5 is doorgaan
    public BetAnswer FirstMove(double random){
        double[] input = {random};
        ArrayList<Double> answerList = Net1.CalculateOutput(input);
        BetAnswer answer = new BetAnswer(answerList.get(0),answerList.get(1));

        return answer;
    }

    // answer[0] = 0.2 <-> 0.8 -> hoeveel je bied van 0<->10
    // answer[1] = 0.5 -> onder 0.5 is doorgaan
    public BetAnswer SecondMove(double random,double hand,double inzet,double verlies){
        double[] input = {random,hand,inzet,verlies};
        ArrayList<Double> answerList = Net2.CalculateOutput(input);
        BetAnswer answer = new BetAnswer(answerList.get(0),answerList.get(1));
        return answer;
    }

    // answer[0] = 0.5 -> onder 0.5 is doorgaan
    public BetAnswer ThirdMove(double random,double hand,double inzet,double verlies){
        double[] input = {random,hand,inzet,verlies};
        ArrayList<Double> answerList = Net3.CalculateOutput(input);
        BetAnswer answer = new BetAnswer(answerList.get(0),answerList.get(1));
        return answer;
    }

    public BettingCell Clone(){
        BettingNeuralNetCell Cell =  new BettingNeuralNetCell();
        Cell.Net1 = Net1.Clone();
        Cell.Net2 = Net2.Clone();
        Cell.Net3 = Net3.Clone();
        return Cell;
    }
}
