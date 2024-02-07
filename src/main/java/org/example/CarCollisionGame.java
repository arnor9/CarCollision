package org.example;

import java.util.Random;

class Obstacle{
    public void setIntensity(int random){

    }
}
class Truck extends Obstacle{

}

class Pillar extends Obstacle{

}

class Life extends Obstacle{

}
class Score{
    public void increment() {

    }
}

class Car{
    private int lives;
    public void setLives(int lives) {
        this.lives = lives;
    }
    public boolean hasLives() {
        if (lives > 0){
            return true;
        }
        return false;
    }
    public int getLives() {
        return lives;
    }
    public void hit(Obstacle o) {
    }
}

public class CarCollisionGame {
    public static void main(String[] args) {
        Random random = new Random();
        if (args.length > 0) {
            random.setSeed(Long.parseLong(args[0]));
        }
        Car c = new Car();
        c.setLives(10);

        Score s = new Score();
        while(c.hasLives()) {
            if (random.nextDouble() < .75) {
                System.out.println("Ouch! Obstacle hit!");
                Obstacle o = null;
                double r = random.nextDouble();
                if (r < 0.4) {
                    o = new Truck(); // this should decrease the number of lives
                    System.out.println("  That was a truck!");
                } else if ( r > 0.6) {
                    o = new Pillar(); // this should decrease the number of lives
                    System.out.println("  That was a pillar!");
                } else {
                    o = new Life(); // this should increase the number of lives
                    System.out.println("  That was a new life! Hurray :)");
                }
                o.setIntensity(1 + random.nextInt(3));
                c.hit(o);
                System.out.println("  Car has now " + c.getLives() + " lives");
            } else {
                System.out.println("No obstacles hit");
            }
            s.increment();
        }

        System.out.println("Game over");
        System.out.println("Final score is " + s);
    }
}