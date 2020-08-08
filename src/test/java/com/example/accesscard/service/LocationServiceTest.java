package com.example.accesscard.service;

import com.example.accesscard.entity.Location;
import com.example.accesscard.simulation.data.LocationDataLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocationServiceTest {

    @Test
    public void locationTreeTest(){
        LocationService locationService = new LocationService();
        List<Location> children = locationService.findAllLocationsUnder(7, LocationDataLoader.get());
        Assertions.assertEquals(2, children.size());
        Assertions.assertEquals(Arrays.asList(7, 8), children.stream().map(Location::getLocationId).collect(Collectors.toList()));

        children = locationService.findAllLocationsUnder(1, LocationDataLoader.get());
        Assertions.assertEquals(8, children.size());
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), children.stream().map(Location::getLocationId).collect(Collectors.toList()));

        children = locationService.findAllLocationsUnder(8, LocationDataLoader.get());
        Assertions.assertEquals(1, children.size());
        Assertions.assertEquals(Arrays.asList(8), children.stream().map(Location::getLocationId).collect(Collectors.toList()));

        children = locationService.findAllLocationsUnder(2, LocationDataLoader.get());
        Assertions.assertEquals(7, children.size());
        Assertions.assertEquals(Arrays.asList(2, 3, 4, 5, 6, 7, 8), children.stream().map(Location::getLocationId).collect(Collectors.toList()));
    }
}
