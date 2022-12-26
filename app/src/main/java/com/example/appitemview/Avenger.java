package com.example.appitemview;


public class Avenger
{
    int image; //img leva mate
    String name,weapon;

    Avenger(){}//default constructor

    Avenger(int image, String name,String weapon){  //parameterized constructor
        this.image = image;
        this.name = name;
        this.weapon = weapon;
    }

    // press right click and got to generate and then getter and setter of all variables

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
