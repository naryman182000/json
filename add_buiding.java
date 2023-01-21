/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import jakarta.json.JsonObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class add_buiding {

    

    public static void add_building(JSONArray buildings,String path) {

        Scanner input = new Scanner(System.in);
        System.out.print("enter the number of buildings ");
        int iterations = input.nextInt();
        for (int i = 0; i < iterations; i++) {

            JSONParser jsonParser = new JSONParser();
            //First Employee
            //Object obj = jsonParser.parse(new FileReader("H:\\year 4\\mavenproject2\\src\\main\\java\\com\\mycompany\\mavenproject2\\employees.json"));
            JSONObject building = new JSONObject();
            //JsonObject jsonObject = (JsonObject) obj;
            System.out.print("enter the BlName ");
            String BlName = input.next();
            building.put("BlName", BlName);
            System.out.print("enter the FoundationYear ");
            String FoundationYear = input.next();
            building.put("FoundationYear", FoundationYear);
            System.out.print("enter the city ");
            String city = input.next();
            building.put("city", city);
            buildings.add(building);

            //Write JSON file
            try ( FileWriter file = new FileWriter(path)) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(buildings.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void final_add() throws IOException {
        JSONParser jsonParser = new JSONParser();
        String path="H:\\year 4\\mavenproject2\\src\\main\\java\\com\\mycompany\\mavenproject2\\buildings.json";
        File b = new File("H:\\year 4\\mavenproject2\\src\\main\\java\\com\\mycompany\\mavenproject2\\buildings.json");
        if (!b.exists()) {
            b.createNewFile();
            JSONArray buildings = new JSONArray();

            add_building(buildings,path);

        } else {
            try ( FileReader reader = new FileReader("H:\\year 4\\mavenproject2\\src\\main\\java\\com\\mycompany\\mavenproject2\\buildings.json")) {
                //Read JSON file

                Object obj = jsonParser.parse(reader);

                JSONArray buildings = (JSONArray) obj;
                add_building(buildings,path);
                System.out.println(buildings);

                //Iterate over employee array
            } catch (FileNotFoundException e) {
                System.out.println("file not found!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        final_add();

    }

}
