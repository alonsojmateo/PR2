package ort.pr.dos.patrones.decorator.enemies;

public class HelmetDecorator extends EnemyDecorator {

    public HelmetDecorator(Enemy enemy) {
        super(enemy);
    }

    @Override
    public Double takeDamage() {
        return this.enemy.takeDamage() / 2;
    }
}
