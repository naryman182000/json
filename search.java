/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import static com.mycompany.mavenproject2.delete.delete_item;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author hgh
 */
public class search {
    public static Scanner input=new Scanner(System.in);
    public static void view(){
        JSONParser jsonParser = new JSONParser();

        try ( FileReader reader = new FileReader("H:\\year 4\\mavenproject2\\src\\main\\java\\com\\mycompany\\mavenproject2\\buildings.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray builfingsList = (JSONArray) obj;
            System.out.println(obj);
            //System.out.println(employeeList);
            

            //Iterate over employee array
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
    public static void search_item() {

        JSONParser jsonParser = new JSONParser();

        try ( FileReader reader = new FileReader("H:\\year 4\\mavenproject2\\src\\main\\java\\com\\mycompany\\mavenproject2\\buildings.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray builfingsList = (JSONArray) obj;
            search_for_ciry(builfingsList);
            //System.out.println(employeeList);
            

            //Iterate over employee array
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Write JSON file
    }
    public static JSONArray search_for_ciry(JSONArray ja) {
        System.out.println("1-search by city");
        System.out.println("2-search by FoundationYear");
        System.out.println("3-search by building number");
        int selection = input.nextInt();
        JSONArray result = new JSONArray();
        boolean flag = false;
        switch (selection) {
            case 1:
                System.out.println("enter the city");
                String city = input.next();

                for (int i = 0; i < ja.size(); i++) {
                    JSONObject jsn = new JSONObject();
                    jsn = (JSONObject) ja.get(i);

                    if (jsn.get("city").equals(city)) {
                        result.add(jsn);
                        flag = true;
                    }
                }
                break;

            case 2:
                System.out.println("enter the FoundationYear");
                String FoundationYear = input.next();
                for (int i = 0; i < ja.size(); i++) {
                    JSONObject jsn = new JSONObject();
                    jsn = (JSONObject) ja.get(i);
                    if (jsn.get("FoundationYear").equals(FoundationYear)) {
                        result.add(jsn);
                        flag = true;
                    }
                }
                break;
            case 3:
                System.out.println("enter the building_name");
                String BlName = input.next();
                for (int i = 0; i < ja.size(); i++) {
                    JSONObject jsn = new JSONObject();
                    jsn = (JSONObject) ja.get(i);
                    if (jsn.get("BlName").equals(BlName)) {
                        result.add(jsn);
                        flag = true;
                    }
                }
                break;
        }
        if (flag == false) {
            System.out.println("item not found");
        }else{System.out.println(result);}
        return result;

    }
    public static void main(String[] args){
        search_item();
    }
}
