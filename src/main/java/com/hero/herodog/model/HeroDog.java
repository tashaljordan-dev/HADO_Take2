package com.hero.herodog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hero_dogs")
public class HeroDog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String breed;
    private int age;

    @Column(name = "years_diabetic")
    private int yearsDiabetic;

    @Column(name = "hero_message")
    private String heroMessage;

    @Column(name = "photo_url")
    private String photoUrl;

    public HeroDog() {}

    public HeroDog(String name, String breed, int age, int yearsDiabetic, String heroMessage, String photoUrl) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.yearsDiabetic = yearsDiabetic;
        this.heroMessage = heroMessage;
        this.photoUrl = photoUrl;
    }
    // Getters

    public Long getId() { return id; }
    public String getName() { return name;}
    public String getBreed() { return breed;}
    public int getAge () {return age;}
    public int getYearsDiabetic () {return yearsDiabetic;}
    public String  getHeroMessage () {return heroMessage;}
    public String getPhotoUrl () {return photoUrl; }

    //Setters

    public void setId(Long id) {this.id=id;}
    public void setName(String name) {this.name=name;}
    public void setBreed (String breed) {this.breed= breed;}
    public void setAge (int age) {this.age =age;}
    public void setYearsDiabetic (int yearsDiabetic) {this.yearsDiabetic= yearsDiabetic;}
    public void setHeroMessage (String heroMessage) {this.heroMessage= heroMessage;}
    public void setPhotoUrl (String photoUrl) {this.photoUrl = photoUrl;}

}
