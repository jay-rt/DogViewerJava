package com.hands_on_android.dogviewerjava.network.model;

public class Breed implements Comparable<Breed> {
    private String breed;
    private String subBreed;

    public Breed(String breed, String subBreed) {
        this.breed = breed;
        this.subBreed = subBreed;
    }

    public String getBreed() {
        return breed.substring(0,1).toUpperCase() + breed.substring(1);
    }

    public String getSubBreed() {
        if(subBreed != null){
            subBreed = subBreed.substring(0,1).toUpperCase() + subBreed.substring(1);
        }
        return subBreed;
    }

    public String getTitle() {
        if(subBreed == null){
            return getBreed();
        }else{
            return getSubBreed() + " " + getBreed();
        }
    }

    @Override
    public int compareTo(Breed o) {
        int compareBreed = breed.compareTo(o.breed);
        if (compareBreed != 0) {
            return compareBreed;
        }
        return getTitle().compareTo(o.getTitle());
    }
}
