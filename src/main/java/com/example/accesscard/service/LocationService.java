package com.example.accesscard.service;

import com.example.accesscard.entity.Location;
import com.example.accesscard.repository.LocationRepository;
import com.example.accesscard.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;


    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    public Optional<Location> findByLocationId(int locationId){
        return locationRepository.findByLocationId(locationId);
    }

    public List<Location> findAllLocationsUnder(int parentId) {
        if(!locationRepository.findByLocationId(parentId).isPresent())
            return Collections.emptyList();

        List<Location> locations = locationRepository.findAll();
        return findAllLocationsUnder(parentId, locations);
    }

    public List<Location> findAllLocationsUnder(int parentId, List<Location> locations) {
        Map<Integer, List<Location>> locationsByParentId = locations.stream().collect(Collectors.groupingBy(l -> l.getParentLocationId()));
        List<Location> allLocations = new ArrayList<>();
        Location parentLocation = locations.stream().filter(l -> l.getLocationId() == parentId).findAny().orElse(null);
        if(Objects.isNull(parentLocation))
            return Collections.emptyList();

        Queue<Location> parents = new LinkedList<>();
        parents.add(parentLocation);

        while(!parents.isEmpty()){
            Location parent = parents.poll();
            allLocations.add(parent);
            List<Location> children = locationsByParentId.get(parent.getLocationId());

            if(!Util.isEmpty(children)) {
                children.remove(parent);//if location is parent of itself (i.e it doesn't have parent ) then we have to remove it from children, otherwise never ending recursion will happen
                parents.addAll(children);
            }
        }
        return allLocations;
    }

}
