package ort.pr.dos.patrones.composite.mcchombo;

import java.util.stream.IntStream;

public class TestMcChombo {
    public static void main(String[] args) {
        IndividualProduct fries = new IndividualProduct("fries", 10);
        IndividualProduct burger = new IndividualProduct("burguer", 20);
        IndividualProduct soda = new IndividualProduct("soda", 30);

        McChombo chomboOne = new McChombo("Chombo One");

        chomboOne.add(fries);
        chomboOne.add(burger);
        chomboOne.add(soda);

        System.out.println(chomboOne);
        System.out.println(fries);
    }
}
