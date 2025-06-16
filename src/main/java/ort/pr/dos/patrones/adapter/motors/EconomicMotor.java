package ort.pr.dos.patrones.adapter.motors;

public class EconomicMotor implements Motor {

    private String name;

    public EconomicMotor(String name) {
        this.name = name;
    }


    @Override
    public void on() {
        System.out.println("EconomicMotor " + name + " on");
    }

    @Override
    public void acelerate() {
        System.out.println("EconomicMotor " + name + " acelerate");
    }

    @Override
    public void off() {
        System.out.println("EconomicMotor " + name + " off");
    }
}
