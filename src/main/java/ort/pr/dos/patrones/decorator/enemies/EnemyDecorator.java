package ort.pr.dos.patrones.decorator.enemies;

public abstract class EnemyDecorator implements Enemy {

    protected Enemy enemy;

    public EnemyDecorator(Enemy enemy) {
        this.enemy = enemy;
    }
}
