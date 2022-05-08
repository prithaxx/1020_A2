//Creates and returns new items for the game
public class Item{
    private String itemName; 
    public Item(String itemName){
        this.itemName=itemName;
    }
    //gets a random name of an item from the GameData class
    public Item(){ 
        itemName=GameData.getRandomItemName();
    }
    //returns the name of the item
    public String toString(){ 
        return itemName;
    }
}