package lab4;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String args[]) {

        try {
            Character character = new Character.Builder()
                    .withName("Character")
                    .withHealth(50)
                    .withNameOfAttack("Fireball")
                    .withAttack(15)
                    .withProtection(25)
                    .build();
            System.out.println(character);
        }catch (IllegalArgumentException e){System.out.println(e.getMessage());}

    }
}
