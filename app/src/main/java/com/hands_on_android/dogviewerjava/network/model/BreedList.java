package com.hands_on_android.dogviewerjava.network.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BreedList {
    @Json(name= "message")
    Map<String, List<String>> breedListMap;

    public List<Breed> getBreeds() {
        ArrayList<Breed> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: breedListMap.entrySet()){
            String breed = entry.getKey();
            List<String> subBreed = entry.getValue();

            if (subBreed == null){
                result.add(new Breed(breed, null));
            }else{
                for (String sb: subBreed) {
                    result.add(new Breed(breed, sb));
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
