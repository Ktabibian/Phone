package com.zipcodewilmington.phonebook;

//import java.util.List;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phoneBook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = map;
    }

    public PhoneBook() {
        this.phoneBook= new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> phoneNums = new ArrayList<>();
        phoneNums.add(phoneNumber);
        phoneBook.put(name, phoneNums);
    }

    public void addAll(String name, String... phoneNumbers) {
        phoneBook.put(name, new ArrayList<>(Arrays.asList(phoneNumbers)));
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phoneBook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        List<String> names = getAllContactNames();
        for(String name : names){
            if(lookup(name).contains(phoneNumber)){
                return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> toAdd = new ArrayList<>(phoneBook.keySet());
        return toAdd;
    }

    public Map<String, List<String>> getMap() {
        return this.phoneBook;
    }
}
