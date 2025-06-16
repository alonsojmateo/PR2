package ort.pr.dos.patrones.state.tamagochi;



public class TamagochiTest {
    public static void main(String[] args) {
        Tamagochi test = new Tamagochi("Mango", new Triste());
        System.out.println(test);
        test.comer();
        System.out.println(test);
    }
}
