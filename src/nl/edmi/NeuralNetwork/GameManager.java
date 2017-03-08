package nl.edmi.NeuralNetwork;

import java.util.ArrayList;

/**
 * Created by Ivan on 25-12-2016.
 */
public final class GameManager {

    private GameManager() {

    }

    private static double CalculateInzet(BetAnswer a1, BetAnswer a2) {
        return Math.max(a1.getInzet(), a2.getInzet());
    }

    private static double CalculateVerlies(BetAnswer a1, BetAnswer a2) {
        return Math.max(a2.getInzet() - a1.getInzet(),0);
    }

    private static void hey() {

    }
    //return hoeveel cell l een verdient
    public static double RoundTwoCells(BettingCell cell1, BettingCell cell2,boolean printing){
        double score = 0;
        double[][] scoreBijCategory = new double[4][11];

        for(int hand1=0;hand1<=10;hand1++){
            for(int hand2=0;hand2<=10;hand2++){
                for(int rand1=0;rand1<=10;rand1++){
                    for(int rand2=0;rand2<=10;rand2++){
                        double ScoreFight = FightTwoCells(cell1,cell2,hand1,hand2,rand1,rand2);
                        score+=ScoreFight;
                        scoreBijCategory[0][hand1] += ScoreFight;
                        scoreBijCategory[1][hand2] += ScoreFight;
                        scoreBijCategory[2][rand1] += ScoreFight;
                        scoreBijCategory[3][rand2] += ScoreFight;
                    }
                }
            }
        }
        if(printing) {
            for (int Category = 0; Category < 4; Category++) {
                for (int Variable = 0; Variable <= 10; Variable++) {
                    if (Category == 0) {
                        System.out.print("hand1");
                    } else if (Category == 1) {
                        System.out.print("hand2");
                    } else if (Category == 2) {
                        System.out.print("rand1");
                    } else if (Category == 3) {
                        System.out.print("rand2");
                    }
                    System.out.print(" ");
                    System.out.print(Variable);
                    System.out.print(" ");

                    System.out.println(scoreBijCategory[Category][Variable]);
                }
            }
        }
        return score;
    }

    //return hoeveel cell1 verdient
    public static double FightTwoCells(BettingCell cell1, BettingCell cell2, double hand1, double hand2, double rand1, double rand2) {

        BetAnswer FirstMoveCell1 = cell1.FirstMove(rand1 / 10);
        BetAnswer FirstMoveCell2 = cell2.FirstMove(rand2 / 10);
        FirstMoveCell1.FirstRoundInzet();
        FirstMoveCell2.FirstRoundInzet();

        if (FirstMoveCell1.getStoppen() || FirstMoveCell2.getStoppen()) {
            return 0.0;
        }

        double inzet = CalculateInzet(FirstMoveCell1, FirstMoveCell2);
        double verlies1 = CalculateVerlies(FirstMoveCell1, FirstMoveCell2);
        double verlies2 = CalculateVerlies(FirstMoveCell2, FirstMoveCell1);
        BetAnswer SecondMoveCell1 = cell1.SecondMove(rand1 / 10, hand1 / 10, inzet / 10, verlies1 / 10);
        BetAnswer SecondMoveCell2 = cell2.SecondMove(rand2 / 10, hand2 / 10, inzet / 10, verlies2 / 10);

        if (SecondMoveCell1.getStoppen() && SecondMoveCell2.getStoppen()) {
            return 0.0;
        } else if (SecondMoveCell1.getStoppen() || SecondMoveCell2.getStoppen()) {
            double winner = 0;
            double verlies = 0;
            if (SecondMoveCell1.getStoppen()) {
                winner = -1;
                verlies = verlies1;
            } else {
                winner = 1;
                verlies = verlies2;
            }
            return winner * (inzet - verlies);
        }


        inzet = inzet + CalculateInzet(SecondMoveCell1, SecondMoveCell2);
        verlies1 = CalculateVerlies(SecondMoveCell1, SecondMoveCell2);
        verlies2 = CalculateVerlies(SecondMoveCell2, SecondMoveCell1);
        BetAnswer ThirdMoveCell1 = cell1.ThirdMove(rand1 / 10, hand1 / 10, inzet / 20, verlies1 / 10);
        BetAnswer ThirdMoveCell2 = cell2.ThirdMove(rand2 / 10, hand2 / 10, inzet / 20, verlies2 / 10);

        if (ThirdMoveCell1.getStoppen() && ThirdMoveCell2.getStoppen()) {
            return 0.0;
        } else if (ThirdMoveCell1.getStoppen() || ThirdMoveCell2.getStoppen()) {
            double winner = 0;
            double verlies = 0;
            if (ThirdMoveCell1.getStoppen()) {
                winner = -1;
                verlies = verlies1;
            } else {
                winner = 1;
                verlies = verlies2;
            }
            return winner * (inzet - verlies);
        }


        if(hand1==hand2){
            return 0;
        }else if(hand1>hand2){
            return inzet;
        }else{
            return inzet*-1;
        }




    }
}
