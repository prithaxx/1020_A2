//This class allows the user to play the final game
import java.awt.event.KeyEvent;
import java.util.Scanner;
public class Game{
    private static Map gameMap;
    private static Hero theHero;
    //Calls all the necessary methods to 
    //set the final game
    public static void main(String[] args){
        theHero=FileLoader.loadHero("HeroFile.txt");
        System.out.print(theHero.toString()+"\n-----------");
        System.out.print(theHero.getItemsCollected());
        //System.out.println(theHero.damageBonus());
        System.out.println("\n-----------\n");
        gameMap=FileLoader.loadMap("MapFile.txt");
        System.out.println(gameMap.toString());
        playGame();
    }
    //Returns int values depending upon which
    //arrow key has been pressed
    private static int getInput(){
        if(StdDraw.isKeyPressed(KeyEvent.VK_UP))
            return 0;
        else if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
            return 1;
        else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN))
            return 2;
        else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
            return 3;
        else
            return -1;
    }
    //plays the actual game by moving the hero,
    //collecting the items and printing the final
    //items in the hero's loot bag
    public static void playGame(){
        //damageBonus() calculates the total number 
        //of items in the hero inventory
        int totalItems=theHero.damageBonus();
        gameMap.addItems(totalItems);
        gameMap.initHeroLocation();
        System.out.println(gameMap.toString());
        for(int i=0;i<totalItems;i++){
            Item itemType=new Item("Item "+Integer.toString(i));
            theHero.collectItem(itemType);
        }
        while(totalItems!=0){
            int direction= getInput();
            if(direction>=0 && direction<4){
                char position=gameMap.processInput(direction);
                System.out.println(gameMap.toString());
                int itemsCollected=0;
                for(int i=0;i<totalItems;i++){
                    if(!gameMap.toString().contains(Integer.toString(i)))
                        itemsCollected++;
                    if(itemsCollected==totalItems){ 
                        System.out.println("----------------");
                        System.out.println(theHero.getName()+ "has survived with "+theHero.getHP()+" HP remaining.\nIn Loot bag you have ");
                        System.out.print(theHero.getItemsCollected());
                        System.exit(0);
                    }
                }
            }
            //stops the output for 100ms for visual pleasure
            StdDraw.show(100);
        }
    }
}