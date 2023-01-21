/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import jakarta.json.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class delete {
     public static Scanner input=new Scanner(System.in);
    public static void delete_building() {

        JSONParser jsonParser = new JSONParser();

        try ( FileReader reader = new FileReader("H:\\year 4\\mavenproject2\\src\\main\\java\\com\\mycompany\\mavenproject2\\buildings.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray buildings = (JSONArray) obj;
            JSONArray delete = delete_item(buildings);
            System.out.println(buildings);
            try ( FileWriter file = new FileWriter("H:\\year 4\\mavenproject2\\src\\main\\java\\com\\mycompany\\mavenproject2\\buildings.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(delete.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

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

    public static JSONArray delete_item(JSONArray ja) {
        System.out.println(ja);
        System.out.println("1-delete by city");
        System.out.println("2-delete by FoundationYear");
        System.out.println("3-delete by building_name");
        int selection = input.nextInt();
        boolean flag = false;
        switch (selection) {
            case 1:
                System.out.println("enter the city");
                String city = input.next();

                for (int i = 0; i < ja.size(); i++) {
                    JSONObject jsn = new JSONObject();
                    jsn = (JSONObject) ja.get(i);

                    if (jsn.get("city").equals(city)) {
                        flag = true;
                        ja.remove(i);
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
                        ja.remove(i);
                        flag = true;
                    }
                }
                break;
            case 3:
                System.out.println("enter the building number");
                String building_number = input.next();
                for (int i = 0; i < ja.size(); i++) {
                    JSONObject jsn = new JSONObject();
                    jsn = (JSONObject) ja.get(i);
                    if (jsn.get("building number").equals(building_number)) {
                        ja.remove(i);
                        flag = true;
                    }
                }
                break;
        }
        if (flag == false) {
            System.out.println("item not found");
        }
        return ja;

    }

    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
       

    }

}
