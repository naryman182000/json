/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenproject2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Mavenproject2 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1-search element");
            System.out.println("2-delete element");
            System.out.println("3-add element");
            System.out.println("4-view array");
            System.out.println("5-exit");
            int selection = input.nextInt();
            if (selection == 1) {
                search obj = new search();
                obj.search_item();

            } else if (selection == 2) {
                delete obj = new delete();
                obj.delete_building();
            } else if (selection == 3) {
                add_buiding obj = new add_buiding();
                obj.final_add();
            } else if (selection == 4) {
                search obj = new search();
                obj.view();
            } else {
                break;
            }

        }

    }
}
