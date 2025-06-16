package ort.pr.dos.patrones.decorator.enemies;


public class BaseEnemy implements Enemy {

    @Override
    public Double takeDamage() {
        return 10.0;
    }
}
