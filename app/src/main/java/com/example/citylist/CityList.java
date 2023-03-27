package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }
    public void delete(City city)
    {
        if(!cities.contains(city))
        {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    public int count()
    {
        return cities.size();//list.size() to return list size
    }

    public List<City> getCitiesSort(int x)
    {
        List<City> cityList=cities;
        if(x==0)
        {
            Collections.sort(cityList);
            return cityList;
        }
        else
        {
            Collections.sort(cityList,new Comparator<City>()
            {
                @Override
                public int compare(City city1, City city2) {
                    return city1.getProvinceName().compareTo(city2.getProvinceName());
                }
            });
        }
        return cityList;//finally returns the sorted list according to province name
    }

}
