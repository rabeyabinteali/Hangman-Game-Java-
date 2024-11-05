/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author rabey
 */
import java.io.IOException;
import java.util.ArrayList;
public class TestRunner {
    public static void main(String args[]) throws IOException{
        String filepath="C:\\Users\\rabey\\OneDrive\\Desktop\\Sample.txt";
        String file="C:\\Users\\rabey\\OneDrive\\Documents\\NetBeansProjects\\James\\src\\main\\java\\main\\BollywoodMovieName.txt";
        ArrayList<String>words=Hangman.ReadFromFile(file);
        ArrayList<String>movienames =new ArrayList<String>();
        for(int i=0;i<words.size();i++){
            String s="";
            s=words.get(i);
            if(i%2==1){
                s=s+" Star Cast: ";
            }
            System.out.println(s);
            movienames.add(s);
            
        }          
          //System.out.println();
        Hangman.WriteInFile(file, movienames);
    }
}
