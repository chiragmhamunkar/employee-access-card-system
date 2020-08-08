package com.example.accesscard.simulation.data;

import com.example.accesscard.entity.Location;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*
*
* This is just to load sample data
*
* */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationDataLoader {

    public static List<Location> get(){
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1, "India", 1));
        locations.add(new Location(2, "Maharastra", 1));
        locations.add(new Location(3, "Mumbai", 2));
        locations.add(new Location(4, "Pune", 2));
        locations.add(new Location(5, "Navi Mumbai", 3));
        locations.add(new Location(6, "Central Mumbai", 3));
        locations.add(new Location(7, "Ghansoli", 5));
        locations.add(new Location(8, "Reliance Corporate Park", 7));
        return locations;
    }
}
