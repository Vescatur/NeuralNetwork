package nl.edmi.NeuralNetwork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan on 20-12-2016.
 */
public class EvolutionTest {

    int Turn = 0;
    Cell[] cells;
    int NumberOfCells = 100;
    public EvolutionTest(){

    }

    public void start() {

        cells = new Cell[NumberOfCells];
        for (int i=0; i < NumberOfCells; i++) {
            cells[i] = new Cell();
        }



        while(true) {
            turn();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {


            }
        }
    }

    public void turn() {
        System.out.println("---------------");
        System.out.println(Turn++);
        for (int i=0; i < NumberOfCells; i++) {
            cells[i].setCost(cost(cells[i]));

        }

        Arrays.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return (o1.toString().compareTo(o2.toString()));
            }
        });
        System.out.println(Arrays.asList(cells));
        //for (int i=0; i < NumberOfCells; i++) {
        //    System.out.println(cells[i].getCost());
        //}
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
