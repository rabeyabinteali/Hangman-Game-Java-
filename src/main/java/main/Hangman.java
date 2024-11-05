package main;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
public class Hangman{
	static Random random = new Random();
	static Scanner input = new Scanner(System.in);
	static int lives=7;
	static int nameCharCount=0;
	static int charCount=0;
	static int correctCharCount=0;
	static char[] guessedCharacters= new char[36];
	public static ArrayList<String> ReadFromFile(String filePath) throws IOException{
                    ArrayList<String> arr= new ArrayList<String>();
		    FileInputStream file= null;
		    InputStreamReader filein=null;
		    BufferedReader fileReader= null;
		    String s=null;
		    try{
		    file= new FileInputStream(filePath);
		    filein= new InputStreamReader(file);
		    fileReader= new BufferedReader(filein);
		    }
		    catch(FileNotFoundException e){
		    System.out.println("File Not Found");
		    }
		    do{
		        try {
		         arr.add(fileReader.readLine());
		        } catch (IOException ex) {
		            Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    }
		    while(fileReader.ready()==true);
		        try {
		            filein.close();
		            file.close();
		        } catch (IOException ex) {
		            Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    return arr;
		    }
        public static void WriteInFile(String filepath,ArrayList<String>valuelist){
                try {
                    FileWriter fw = new FileWriter(filepath);
                    for(int i=0;i<valuelist.size();i++){
                        fw.append(valuelist.get(i));
                        fw.append("\n");
                    }
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
        }
        public static String getHint(String word, String filepath){
            String ans=null;
            try {
			ArrayList<String> movies = ReadFromFile(filepath);
			for(int i=0;i<movies.size();i+=2){
                            if(word.equalsIgnoreCase(movies.get(i))){
                                ans= movies.get(i+1);
                                break;
                            }
                        }
		}
		catch(Exception e) {
			System.out.println(e);
		}
            return ans;
        }
        public static int randomIndexGenerator(int size){
            int x=random.nextInt(size);
                        if(x%2==1){
                            x--;
                        }
            return x;
        }
	public static String randomNameGenerator(String filepath) {
		String name=null;
                ArrayList<String>last11=new ArrayList<String>();
		try {
			ArrayList<String> movies = ReadFromFile(filepath);
                        last11=ReadFromFile("C:\\Users\\rabey\\OneDrive\\Documents\\NetBeansProjects\\Hangman\\src\\main\\java\\main\\Last11GivenWordList.txt");
                        int x= randomIndexGenerator(movies.size());
                        for(int i=0;i<last11.size();i++){
                                if(movies.get(x).equalsIgnoreCase(last11.get(i))){
                                    int temp=x;
                                    while(x==temp){
                                        x=randomIndexGenerator(movies.size());
                                    }
                                    break;
                                }
                        }
                        name=movies.get(x);
                    }
                catch(Exception e) {
			System.out.println(e);
                }
		int y=0;
		for(char i='a'; i<='z'; i++) {
			if(name.toLowerCase().contains(Character.toString(i))) {
				y++;
			}
		}
		for(char j='0'; j<='9';j++) {
			if(name.toLowerCase().contains(Character.toString(j))) {
				y++;
			}
		}
		nameCharCount=y;
                name=name.toLowerCase();
                if(last11.size()==11){
                            last11.remove(0);
                }
                last11.add(name);
                WriteInFile("C:\\Users\\rabey\\OneDrive\\Documents\\NetBeansProjects\\Hangman\\src\\main\\java\\main\\Last11GivenWordList.txt",last11);
                return name;
		
	}
        public static String randomConsolationMessage(){
            int ran=0;
            ArrayList<String> messages= new ArrayList<String>();
            try {
                messages = ReadFromFile("C:\\Users\\rabey\\OneDrive\\Documents\\NetBeansProjects\\Hangman\\src\\main\\java\\main\\ConsolationMessage.txt");
                ran=random.nextInt(messages.size());
            } catch (IOException ex) {
                Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
            }
            return messages.get(ran);
                        
        }
        public static void updateHighScore(int score, String playername){
            try {
                        String names[]=playername.split(" ");
                        playername=names[0];
                        int flag=0;
			ArrayList<String> highscores = ReadFromFile("C:\\Users\\rabey\\OneDrive\\Documents\\NetBeansProjects\\Hangman\\src\\main\\java\\main\\HangmanHighScore.txt");
                        for(int i=1;i<=highscores.size();i+=2){
                            int s=0,p=1;
                            String sc=highscores.get(i);
                            for(int j=sc.length()-1;j>=0;j--){
                                s+=(Character.getNumericValue(sc.charAt(j))*p);
                                p*=10;
                            }
                            if(highscores.size()<20){
                                if(score>=s){
                                    highscores.add(i-1,playername);
                                    highscores.add(i, Integer.toString(score));
                                    flag--;
                                    break;
                                }
                            }else if(score>=s){
                                highscores.add(i-1,playername);
                                highscores.add(i, Integer.toString(score));
                                flag--;
                                break;
                            }
                        }
                        if(flag==0){
                            highscores.add(playername);
                            highscores.add(Integer.toString(score));
                        }
                        int breakpoint=20;
                        if(highscores.size()<20){
                            breakpoint=highscores.size();
                        }
                        ArrayList<String>update=new ArrayList<String>();
                        for(int i=0;i<breakpoint;i++){
                            update.add(highscores.get(i));
                        }
                        WriteInFile("C:\\Users\\rabey\\OneDrive\\Documents\\NetBeansProjects\\Hangman\\src\\main\\java\\main\\HangmanHighScore.txt",update);
		}
            catch(Exception e) {
			System.out.println(e);
		}
        }
        public static int returnHighestScore(){
            int hs=0;
            try{
                ArrayList<String> highscores = ReadFromFile("C:\\Users\\rabey\\OneDrive\\Documents\\NetBeansProjects\\Hangman\\src\\main\\java\\main\\HangmanHighScore.txt");
                String sc=highscores.get(1);
                int p=1;
                for(int j=sc.length()-1;j>=0;j--){
                    hs+=(Character.getNumericValue(sc.charAt(j))*p);
                    p*=10;
                }
            }catch(Exception e){
                System.out.println(e);
            }
            return hs;
        }
	public static String returnGappedString(String movieName, String guessed) {
		char [] nameUpdate = movieName.toCharArray();
		char [] nameCopy= movieName.toCharArray();
		char [] chars=null;
                String name="";
		if(guessed!=null) {
		 chars = guessed.toCharArray();
		}
		for(int j=0; j<nameUpdate.length;j++) {
			if((nameCopy[j]=='a')||(nameCopy[j]=='e')||(nameCopy[j]=='o')||(nameCopy[j]=='i')||(nameCopy[j]=='u')){
				nameUpdate[j]='*';
			}
			else if(nameCopy[j]==' ') {
				nameUpdate[j]='/';
			}
			else {
				nameUpdate[j]='-';
			}
		}
		if(guessed !=null) {
			for(int i=0; i<chars.length;i++) {
				for(int j=0; j<nameCopy.length;j++) {
					if((chars[i]==nameCopy[j])&&(nameCopy[j]!=' ')){
						nameUpdate[j]=chars[i];
					}
				}
			}
                }
                for(int i=0;i<nameUpdate.length;i++){
                    name+=(Character.toString(nameUpdate[i]));
                }
                
                return name;
	}
	public static char playerEntry() {
		System.out.println("Enter your guess: ");
		String ch= input.next();
		return ch.toLowerCase().charAt(0);
	}
        public static int returnCorrectCharCount(String name){
            int count=0;
            name=name.toLowerCase();
            for(char i='a'; i<='z'; i++) {
                for(int in=0;in<name.length();in++){
                    if(i==name.charAt(in)){
                        count++;
                        break;
                    }
                }
            }
            for(char j='0'; j<='9';j++) {
                for(int in=0;in<name.length();in++){
                    if(j==name.charAt(in)){
                        count++;
                        break;
                    }
                }
            }
            for(int i=0;i<name.length();i++){
                if(name.charAt(i)=='.'){
                    count++;
                    break;
                }
            }
            for(int i=0;i<name.length();i++){
                if(name.charAt(i)==':'){
                    count++;
                    break;
                }
            }
            for(int i=0;i<name.length();i++){
                if(name.charAt(i)=='-'){
                    count++;
                    break;
                }
            }
            for(int i=0;i<name.length();i++){
                if(name.charAt(i)=='!'){
                    count++;
                    break;
                }
            }
            return count;
        }
	public static boolean statusCheck(String guess, String name) {
		guess=guess.toLowerCase();
                name=name.toLowerCase();
                return name.contains(guess);
	}
	
}