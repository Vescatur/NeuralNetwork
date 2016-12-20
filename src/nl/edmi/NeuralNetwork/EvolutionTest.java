package nl.edmi.NeuralNetwork;

/**
 * Created by Ivan on 20-12-2016.
 */
public class EvolutionTest {

    int Turn = 0;


    public EvolutionTest(){

    }

    public void start() {
        while(true) {
            turn();
        }
    }

    public void turn() {
        System.out.println(Turn++);
        Cell cell = new Cell();
        double[] input = {1.0, 1.0};
        System.out.println(cell.GetScore(input));
    }

    public double cost(Cell cell){
        double sum=0;

        double[] input1 = {1.0, 1.0};
        double score1 = cell.GetScore(input1);
        sum += Math.abs(score1-0.8);

        double[] input2 = {0.0, 1.0};
        double score2 = cell.GetScore(input2);
        sum += Math.abs(score2-0.2);

        double[] input3 = {1.0, 0.0};
        double score3 = cell.GetScore(input3);
        sum += Math.abs(score3-0.2);

        double[] input4 = {0.0, 0.0};
        double score4 = cell.GetScore(input4);
        sum += Math.abs(score4-0.2);
        return sum;
    }
}
