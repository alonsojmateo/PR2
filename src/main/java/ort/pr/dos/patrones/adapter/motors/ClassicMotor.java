package ort.pr.dos.patrones.adapter.motors;

public class ClassicMotor implements Motor {
    private String name;

    public ClassicMotor(String name) {
        this.name = name;
    }

    @Override
    public void on() {
        System.out.println("ClassicMotor " + name + " on");
    }

    @Override
    public void acelerate() {
        System.out.println("ClassicMotor " + name + " acelerate");

    }

    @Override
    public void off() {
        System.out.println("ClassicMotor " + name + " off");
    }
}
