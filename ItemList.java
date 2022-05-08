//Inventory of items for the hero
//Stores all the items that the hero as found in the game
public class ItemList{
    private int currentItemCount;
    private Item[] itemTypes= new Item[100]; 
    //sets the size of the rray to zero
    public ItemList(){
        currentItemCount=0;
    }
    //returns the number of items inside the array 
    public int itemCount(){ 
        return currentItemCount;
    }
    //adds a new item to the array
    public void addItem(Item newItem){ 
        itemTypes[currentItemCount]=newItem;
        currentItemCount++;
    }
    //returns all the items that are in the array
    public String toString(){ 
        String temp="";
        for(int i=0;i<currentItemCount;i++){
            temp=temp+"\n"+itemTypes[i];
        }
        return temp;
    }
}