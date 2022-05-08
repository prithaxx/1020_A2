//This class reads data from various files and also throws Exceptions
import java.io.*;
import java.util.Scanner;
public class FileLoader{
    private static char[][] mapArray;
    //Controls the testing of files
    public static void main (String[] args) throws IOException{ 
        FileLoader obj= new FileLoader();
        obj.loadMap("MapFile.txt");
    }
    //Reads the file and throws Exception if there is any 
    public static Map loadMap(String fileName){
        try{
            FileReader theFile = new FileReader(fileName);
            BufferedReader inFile = new BufferedReader(theFile);
            String output = inFile.readLine();
            Scanner scan; 
            int i=0;
            String line="";
            //Reads the file
            while(output!=null){ 
                scan=new Scanner(output);
                 //reads the length of the 2D array 
                 //and passes them as sizes
                while(scan.hasNextInt()){
                    i=scan.nextInt();
                    mapArray=new char[i][scan.nextInt()];
                }
                 //reads and extracts the map data from the file
                while(scan.hasNext()){
                    line+=scan.next();
                }
                output=inFile.readLine();
            }
            int totalRow=0, totalCol=0;
            //fills the 2D array with the map data
            for(int r=0;r<mapArray.length;r++){
                for(int c=0;c<mapArray[0].length;c++){
                     mapArray[r][c]=line.charAt(totalCol+totalRow);
                     if(c!=mapArray[0].length-1)
                     totalRow++;
                }
                totalCol++;
            }
            //releases control of the file
            theFile.close(); 
        }
        //catches the Exception, prints the type of Exception
        //and its stacktrace
        catch(Exception e){ 
            System.out.println("\nSorry something went wrong.");
            System.out.println(e.toString());
            e.printStackTrace();
        }
        Map object=new Map(mapArray);
        return object;
    }
    //Reads the Hero file and throws Exceptions if there are any
    public static Hero loadHero(String heroFile){
        int heroHP=0;
        String heroName="";
        Hero theHero=null;
        try{
            FileReader theFile = new FileReader(heroFile);
            BufferedReader inFile = new BufferedReader(theFile);
            Scanner scan; 
            //contains the name of the hero
            heroName = inFile.readLine();
            //contains the HP
            heroHP = Integer.parseInt(inFile.readLine()); 
            //contains the number of items in inventory
            int inventory = Integer.parseInt(inFile.readLine()); 
            theHero = new Hero(heroName, heroHP);
            String item = inFile.readLine();
            //collects all the items from the file
            for(int i=0;i<inventory;i++){
                Item itemType = new Item(item);
                theHero.collectItem(itemType);
                item=inFile.readLine();
            }
            //releases control of the file
            theFile.close(); 
        }
        //throws exception if the File is Not Found
        catch (IOException e){ 
            System.out.println(e.toString());
            e.printStackTrace();          
        }
        //throws exception if file has wrong format
        catch (NumberFormatException e){ 
            System.out.println(e.toString());
            e.printStackTrace();
        }
         //throws exceptions of any other kind
        catch(Exception e){
            System.out.println("Sorry something went wrong.");
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return theHero;
    }
}