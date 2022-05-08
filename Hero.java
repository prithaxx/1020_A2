//Contains all the necessary information about the Hero
public class Hero{
    private String name;
    private int currentHP;
    private final int STARTING_HP=8;
    private ItemList inventory;
    private final int MIN_DAMAGE=1;
    private final int MAX_DAMAGE=4;
    //sets name and HP of the hero.
    //creates a new ItemList object
    public Hero(String name, int currentHP){
        this.name=name;
        this.currentHP=currentHP;
        inventory=new ItemList(); 
    }
    //sets name and HP of the hero.
    //creates a new ItemList object
    public Hero(){ 
        name=GameData.getRandomName();
        currentHP=STARTING_HP;
        inventory=new ItemList(); 
    }
    //returns a random name for the Hero
    public String getName(){ 
        return name;
    }
    //returns the initial hit points of the hero
    public int getHP(){ 
        return currentHP;
    }
    //changes the name and HP to string and returns them
    public String toString(){ 
        return"Current Hero: "+getName()+"\nCurrent HP: "+getHP();
    }
    //adds a new item in the inventory
    public void collectItem(Item newItem){ 
        inventory.addItem(newItem);
    }
    //returns all the items that have been collected by the hero
    public String getItemsCollected(){ 
        return inventory.toString();
    }
    //returns a random number after rolling dice as damage hits
    public int damageDealt(){ 
        return GameData.randomRoll(MIN_DAMAGE,MAX_DAMAGE);
    }
    //returns the current number of items in the inventory
    public int damageBonus(){ 
        return inventory.itemCount();
    }
    //returns the updated HP after losing a treasure to a monster
    public int takeDamage(int damageAmount){ 
        return currentHP-damageAmount;
    }
}