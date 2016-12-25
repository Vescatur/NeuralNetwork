package nl.edmi.NeuralNetwork;

/**
 * Created by Ivan on 25-12-2016.
 */
public final class GameManager {

    private GameManager(){

    }



    public static int FightTwoCells(BettingCell cell1,BettingCell cell2,double hand1,double hand2,double rand1,double rand2){
        double inzet;

        double FirstMoveCell1 = cell1.FirstMove(rand1);
        double FirstMoveCell2 = cell2.FirstMove(rand2);

        if(FirstMoveCell1>FirstMoveCell2){
            inzet = FirstMoveCell1;
        }else{
            inzet = FirstMoveCell2; 
        }

        double SecondMoveCell1 = cell1.SecondMove(rand1, hand1, inzet);
        double SecondMoveCell2 = cell2.SecondMove(rand2, hand2, inzet);

        double ThirdMoveCell1 = cell1.ThirdMove(rand1, hand1, FirstMoveCell1, FirstMoveCell2, SecondMoveCell1, SecondMoveCell2);
        double ThirdMoveCell2 = cell2.ThirdMove(rand2, hand2, FirstMoveCell2, FirstMoveCell1, SecondMoveCell2, SecondMoveCell1);
        System.out.println(FirstMoveCell1);
        System.out.println(FirstMoveCell2);

        System.out.println(SecondMoveCell1);
        System.out.println(SecondMoveCell2);

        System.out.println(ThirdMoveCell1);
        System.out.println(ThirdMoveCell2);
        return 1;
    }
}
