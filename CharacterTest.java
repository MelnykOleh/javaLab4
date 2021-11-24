package lab4test;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lab4.Character;
public class CharacterTest {

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testNameNegativeDataProvider")
    public void testNameNegative(String name, double health, String nameOfAttack, double attack){
        Character obj = new Character.Builder().withName(name).withHealth(health).withNameOfAttack(nameOfAttack).withAttack(attack).build();
        assertEquals(obj.getName(),name);
    }

    @DataProvider
    public Object[][] testNameNegativeDataProvider(){
        return new Object[][] {{"character-one", 50, "Fireball", 20}};
    }

    @Test(dataProvider = "testNamePositiveDataProvider")
    public void testHealthPositive(String name, double health, String nameOfAttack, double attack){
        Character obj = new Character.Builder().withName(name).withHealth(health).withNameOfAttack(nameOfAttack).withAttack(attack).build();
        assertEquals(obj.getName(),name);
    }

    @DataProvider
    public Object[][] testNamePositiveDataProvider(){
        return new Object[][] {{ "character", 50, "Fireball", 20}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testHealthNegativeDataProvider")
    public void testHealthNegative( double health, String nameOfAttack, double attack, double protection){
        Character obj = new Character.Builder().withHealth(health).withNameOfAttack(nameOfAttack).withAttack(attack).withProtection(protection).build();
        assertEquals(obj.getHealth(),health);
    }

    @DataProvider
    public Object[][] testHealthNegativeDataProvider(){
        return new Object[][] {{-10, "Fireball", 20, 35}};
    }

    @Test(dataProvider = "testHealthPositiveDataProvider")
    public void testHealthPositive(double health, String nameOfAttack, double attack, double protection){
        Character obj = new Character.Builder().withHealth(health).withNameOfAttack(nameOfAttack).withAttack(attack).withProtection(protection).build();
        assertEquals(obj.getHealth(),health);
    }

    @DataProvider
    public Object[][] testHealthPositiveDataProvider(){
        return new Object[][] {{ 50, "Fireball", 20, 35}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testNameOfAttackNegativeDataProvider")
    public void testNameOfAttackNegative(String name, String nameOfAttack, double attack, double protection){
        Character obj = new Character.Builder().withName(name).withNameOfAttack(nameOfAttack).withAttack(attack).withProtection(protection).build();
        assertEquals(obj.getNameOfAttack(),nameOfAttack);
    }

    @DataProvider
    public Object[][] testNameOfAttackNegativeDataProvider(){
        return new Object[][] {{"character", "Fireball-777", 20, 35}};
    }

    @Test(dataProvider = "testNameOfAttackPositiveDataProvider")
    public void testNameOfAttackPositive(String name,double health, String nameOfAttack,  double attack, double protection){
        Character obj = new Character.Builder().withName(name).withHealth(health).withNameOfAttack(nameOfAttack).withAttack(attack).withProtection(protection).build();
        assertEquals(obj.getNameOfAttack(),nameOfAttack);
    }

    @DataProvider
    public Object[][] testNameOfAttackPositiveDataProvider(){
        return new Object[][] {{"character", 50, "Fireball", 20, 35}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testAttackNegativeDataProvider")
    public void testAttackNegative(String name, double health,  double attack, double protection){
        Character obj = new Character.Builder().withName(name).withHealth(health).withAttack(attack).withProtection(protection).build();
        assertEquals(obj.getAttack(),attack);
    }

    @DataProvider
    public Object[][] testAttackNegativeDataProvider(){
        return new Object[][] {{"character", 50, 10000, 35}};
    }

    @Test(dataProvider = "testAttackPositiveDataProvider")
    public void testNamePositive(String name, double health,  double attack, double protection){
        Character obj = new Character.Builder().withName(name).withHealth(health).withAttack(attack).withProtection(protection).build();
        assertEquals(obj.getAttack(),attack);
    }

    @DataProvider
    public Object[][] testAttackPositiveDataProvider(){
        return new Object[][] {{"character", 50, 20, 35}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testProtectionNegativeDataProvider")
    public void testProtectionNegative(String name, double health, String nameOfAttack, double protection){
        Character obj = new Character.Builder().withName(name).withHealth(health).withNameOfAttack(nameOfAttack).withProtection(protection).build();
        assertEquals(obj.getProtection(),protection);
    }

    @DataProvider
    public Object[][] testProtectionNegativeDataProvider(){
        return new Object[][] {{"character", 50, "Fireball", -350}};
    }

    @Test(dataProvider = "testProtectionPositiveDataProvider")
    public void testProtectionPositive(String name, double health, String nameOfAttack,double attack, double protection){
        Character obj = new Character.Builder().withName(name).withHealth(health).withNameOfAttack(nameOfAttack).withAttack(attack).withProtection(protection).build();
        assertEquals(obj.getProtection(),protection);
    }

    @DataProvider
    public Object[][] testProtectionPositiveDataProvider(){
        return new Object[][] {{"character", 50, "Fireball", 40, 35}};
    }


}
