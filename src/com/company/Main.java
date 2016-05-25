package com.company;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setLocation(new River());

        for (int i = 0; i < 5; i++){
            person.setProfession();
        }
    }
}

// Context
class Person{
    private Location location;
    public void setLocation(Location l){
        this.location = l;
    }
    public void setProfession(){
        location.setProfession(this);
    }
}

// State
interface Location{
    public void setProfession(Person context);
}
class Forest implements Location{
    @Override
    public void setProfession(Person context) {
        System.out.println("I see animal, I'm hunter!");
        context.setLocation(new River());
    }
}
class River implements Location{
    @Override
    public void setProfession(Person context) {
        System.out.println("I'm on the river, I'm fisherman!");
        context.setLocation(new MushroomMeadow());
    }
}
class MushroomMeadow implements Location{
    @Override
    public void setProfession(Person context) {
        System.out.println("I'm on the mushroom meadow, I'm mushroomer!");
        context.setLocation(new Forest());
    }
}
