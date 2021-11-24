package lab4;

import com.sun.jdi.Value;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.util.Objects;
import java.util.Set;

public class Character {

    @Size(min=2, message = "Name must be longer than 1 character")
    @Pattern(regexp = "[a-z]*", message = "Name must consists only from letter")
    private String name;

    @Min(value = 1, message = "Health cannot be less than 1")
    @Max(value = 9999, message = "Health cannot be more than 9999")
    private double health;

    @Size(min=2, message = "Name must be longer than 1 character")
    @Pattern(regexp = "[A-Z][a-z]*", message = "Name must consists only from letter, and first letter must be UpperCase")
    private String nameOfAttack;

    @Min(value = 1, message = "Attack cannot be less than 1")
    @Max(value = 500, message = "Attack cannot be more than 500")
    private double attack;

    @Min(value = -100, message = "Protection cannot be less than -100")
    @Max(value = 100, message = "Protection cannot be more than 100")
    private double protection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public String getNameOfAttack() {
        return nameOfAttack;
    }

    public void setNameOfAttack(String nameOfAttack) {
        this.nameOfAttack = nameOfAttack;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getProtection() {
        return protection;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }

    public static class Builder {

        private Character newCharacter;

        public Builder() {
            newCharacter = new Character();
        }

        public Builder withName(String name){
            newCharacter.name = name;
            return this;
        }

        public Builder withHealth(double health){
            newCharacter.health = health;
            return this;
        }

        public Builder withNameOfAttack(String nameOfAttack){
            newCharacter.nameOfAttack= nameOfAttack;
            return this;
        }

        public Builder withAttack(double attack){
            newCharacter.attack = attack;
            return this;
        }

        public Builder withProtection(double protection){
            newCharacter.protection = protection;
            return this;
        }

        public Character build()
        {
            validate(newCharacter);
            return newCharacter;
        }

    }

    private static void validate(Character character) throws IllegalArgumentException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


        Set<ConstraintViolation<Character>> check = validator.validate(character);

        StringBuilder sb = new StringBuilder();

        for(ConstraintViolation<Character> i : check){
            sb.append("Error value "+i.getInvalidValue() + " because " + i.getMessage());
            sb.append("\n");
        }

        if(sb.length() > 0){
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", nameOfAttack='" + nameOfAttack + '\'' +
                ", attack=" + attack +
                ", protection=" + protection +
                '}';
    }
}
