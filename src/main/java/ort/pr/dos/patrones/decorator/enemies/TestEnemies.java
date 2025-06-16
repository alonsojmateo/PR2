package ort.pr.dos.patrones.decorator.enemies;

public class TestEnemies {
    public static void main(String[] args) {
        Enemy enemy = new BaseEnemy();
        Enemy enemyWithHelmet = new HelmetDecorator(enemy);
        Enemy enemyWithHelmetAndArmor = new ArmorDecorator(enemyWithHelmet);
        System.out.println(enemyWithHelmetAndArmor.takeDamage());
    }
}
