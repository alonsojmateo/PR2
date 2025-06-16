package ort.pr.dos.patrones.decorator.enemies;

public class ArmorDecorator extends EnemyDecorator {

    public ArmorDecorator(Enemy enemy) {
        super(enemy);
    }

    @Override
    public Double takeDamage() {
        return this.enemy.takeDamage() / 1.5;
    }
}
