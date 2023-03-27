package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    /**
     * This method is used to delete a city
     */
    @Test
    public void deletecity()
    {
        CityList cityList = new CityList();
        City city1= new City("Narsingdi","Dhaka");
        City city2 = new City("Teligati","Khulna");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertTrue(!cityList.getCities().contains(city1));
    }


    /**
     * this method is used to show the exception while deleting a city if the city doesn't exist in the list
     */
    @Test
    public void deleteException()
    {
        CityList cityList = new CityList();
        City city1= new City("Narsingdi","Dhaka");
        City city2 = new City("Teligati","Khulna");
        cityList.add(city1);
        cityList.add(city2);
        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class,()->{
            cityList.delete(city1);
        });
    }

    /**
     * this method is used to count the number of cites in the list
     */
    @Test
    public void testCount()//unit test for count
    {
        CityList cityList=new CityList();
        City city1=new City("Bandarban","Chittagong");
        City city2=new City("Dinajpur","Rangpur");
        City city3=new City("Khustia","Khulna");
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        assertEquals(3,cityList.count());
    }


    /**
     * this method is used to sort the city by city or province name
     * A flag is used to select the sorting procedure
     * if flag==0 then the list will be sorted using city name
     * if the flag==1 then the list will be sorted using province name
     */
    @Test
    public void TestSort()//unit test for sorting
    {
        CityList cityList=mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city1=new City("Aazipur","Dhaka");
        cityList.add(city1);
        assertEquals(0,city1.compareTo(cityList.getCitiesSort(1).get(1)));

    }
}
