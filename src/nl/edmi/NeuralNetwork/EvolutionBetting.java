package nl.edmi.NeuralNetwork;

/**
 * Created by Ivan on 25-12-2016.
 */
public class EvolutionBetting {

    public EvolutionBetting(){
        BettingCell cell1 = new BettingCell();
        BettingCell cell2 = new BettingCell();

        GameManager.FightTwoCells(cell1,cell2,1,0.5,0.3,0.8);
    }

}
