package nl.edmi.NeuralNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ivan on 25-12-2016.
 */
public class EvolutionBetting {
    int Turn = 0;
    BettingCell[] BettingCells;
    int NumberOfCells = 100;
    BettingCell TestCell;
    Random rand = new Random();
    ArrayList<double[][]> Scores;

    public EvolutionBetting(){

        TestCell = new BettingCell();

        BettingCells = new BettingCell[NumberOfCells];
        for (int i=0; i < NumberOfCells; i++) {
            BettingCells[i] = new BettingNeuralNetCell();
            BettingCells[i].setCost(GameManager.RoundTwoCells(BettingCells[i],TestCell,false));
        }

        while(true) {
            for (int i = 0; i < 1; i++) {
                turn();
            }
            System.out.println("Score lijst per 10%");
            System.out.println(BettingCells[0].getCost());
            for (int i = 1;i<11;i++){
                System.out.println(BettingCells[NumberOfCells*i/10-1].getCost());
            }

            for (int i=0; i < NumberOfCells; i++) {
                //System.out.println(BettingCells[i].getCost());
            }
        }
    }

    public void turn() {
        Turn++;

        for (int i=NumberOfCells/2; i < NumberOfCells; i++) {
            BettingCells[i] = BettingCells[rand.nextInt(NumberOfCells)].Clone();
        }

        for (int i=NumberOfCells/2; i < NumberOfCells; i++) {
            BettingCells[i].setCost(GameManager.RoundTwoCells(BettingCells[i],TestCell,false));
        }
        Arrays.sort(BettingCells);
        GameManager.RoundTwoCells(BettingCells[0],TestCell,true);

    }
}
