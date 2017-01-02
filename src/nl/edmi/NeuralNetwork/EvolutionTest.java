package nl.edmi.NeuralNetwork;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan on 20-12-2016.
 */
public class EvolutionTest {

    int Turn = 0;
    Cell[] cells;
    int NumberOfCells = 10000;

    Random rand = new Random();

    public EvolutionTest(){

    }

    public void start() {

        cells = new Cell[NumberOfCells];
        for (int i=0; i < NumberOfCells; i++) {
            cells[i] = new Cell();
        }

        while(true) {
            for(int i = 0;i<20;i++) {
                turn();
            }
            /*try {
                //TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }*/

            System.out.println("---------------");
            System.out.println(Turn);
            if(cells[0].getCost()==0.0) {
                System.out.println("Prefect score!!!");
            }
            double[] input1 = {1.0, 1.0};
            double score1 = cells[0].GetScore(input1);
            if(cells[0].getCost()==0.0){
                System.out.println(cells[0].Net.nodes);
            }
            double[] input2 = {0.0, 1.0};
            double score2 = cells[0].GetScore(input2);
            if(cells[0].getCost()==0.0){
                System.out.println(cells[0].Net.nodes);
            }
            double[] input3 = {1.0, 0.0};
            double score3 = cells[0].GetScore(input3);
            if(cells[0].getCost()==0.0){
                System.out.println(cells[0].Net.nodes);
            }
            double[] input4 = {0.0, 0.0};
            double score4 = cells[0].GetScore(input4);
            if(cells[0].getCost()==0.0){
                System.out.println(cells[0].Net.nodes);
            }
            System.out.println(score1);
            System.out.println(score2);
            System.out.println(score3);
            System.out.println(score4);





            System.out.println("Score lijst per 10%");
            System.out.println(cells[0].getCost());
            for (int i = 1;i<11;i++){
                System.out.println(cells[NumberOfCells*i/10-1].getCost());
            }

            System.out.println(Arrays.asList(cells));
        }
    }

    public void turn() {

        Turn++;
        for (int i=NumberOfCells/2; i < NumberOfCells; i++) {
            cells[i] = cells[rand.nextInt(NumberOfCells)].Clone();
        }

        for (int i=0; i < NumberOfCells; i++) {
            cells[i].setCost(cost(cells[i]));
        }

        Arrays.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return new BigDecimal(o1.toString()).compareTo(new BigDecimal(o2.toString()));
            }
        });




    }

    public double cost(Cell cell){
        double sum=0;

        double[] input1 = {1.0, 1.0};
        double score1 = cell.GetScore(input1);
        if(score1<0.8) {
            sum += Math.pow(Math.abs(score1 - 0.8),2)+0.1;
        }else{
            sum += Math.pow(Math.abs(score1 - 0.8),2);
        }
        double[] input2 = {0.0, 1.0};
        double score2 = cell.GetScore(input2);
        if(score2<0.8) {
            sum += Math.pow(Math.abs(score2 - 0.8),2)+0.1;
        }else{
            sum += Math.pow(Math.abs(score2 - 0.8),2);
        }
        double[] input3 = {1.0, 0.0};
        double score3 = cell.GetScore(input3);
        if(score3<0.8) {
            sum += Math.pow(Math.abs(score3 - 0.8),2)+0.1;
        }else{
            sum += Math.pow(Math.abs(score3 - 0.8),2);
        }
        double[] input4 = {0.0, 0.0};
        double score4 = cell.GetScore(input4);
        if(score4>0.2) {
            sum += Math.pow(Math.abs(score4 - 0.2),2)+0.1;
        }else{
            sum += Math.pow(Math.abs(score4 - 0.2),2);
        }
        return sum;
    }
}
