//This class makes the basic structure of the map
public class Map{
    private char[][] mapArray;
    private int heroRow;
    private int heroCol;
    //Sets all the tiles as open by initializing them with '.'
    public Map(int rows, int cols){
        mapArray=new char[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                mapArray[i][j]='.';
            }
        }
    }
    //Helps to test different types of maps from other classes
    public Map(char[][] mapTemplate){
        int rows=mapTemplate.length;
        int cols=mapTemplate[0].length;
        mapArray=new char[rows][cols];
        for(int i=0;i<rows;i++){
            mapArray[i]=new char[mapTemplate[i].length];
            for(int j=0;j<cols;j++){
                mapArray[i][j]=mapTemplate[i][j];
            }
        }
    }
    //Returns a String format of the updated map
    public String toString(){
        String temp="";
        for(int i=0;i<mapArray.length;i++){
            for(int j=0;j<mapArray[i].length;j++){
                temp+=mapArray[i][j];
            }
            temp+="\n";
        }
        return temp;
    }
    //Adds walls to the map
    public void addWalls(){
        int col=mapArray[0].length;
        int row=mapArray.length;
        //finds the number of periods in the string map
        int length=toString().length()-mapArray.length;
        //puts a wall if in the boundary else leaves it open
        for(int i=0;i<mapArray.length;i++){
            for(int j=0;j<mapArray[0].length;j++){
                for(int k=0;k<length;k++){
                    if(j==col-1||i==row-1||(i==0&&j!=0)||(j==0&&i!=0)||(i==0&&j==0)){
                        mapArray[i][j]='X';
                    }
                    else{
                        char ch=toString().charAt(k);
                        mapArray[i][j]=ch;
                    }
                }
                System.out.print(mapArray[i][j]);
            }
            System.out.println();
        }
    }
    //Checks if tiles can be set for a given size of a 2D array
    public boolean setTile(int row, int col, char value){
        //if 2D is null, map doesn't exist
        if(mapArray!=null){ 
            //Crashes if row or column length is less than zero 
            //or greater than the provided array size
            if(row>=0 && row<=mapArray.length && col>=0 && col<=mapArray[0].length){
                return true;
            }
            else{
                System.out.println("Out of Range");
                return false;
            }
        }
        else{
            System.out.println("No map exists");
            return false;
        }
    }
    //Adds item numbers to random locations of the map
    //avoids the walls and each number refers that presence
    //of an item in the map
    public void addItems(int numOfItems){
        int posX, posY;
        for(int i=0;i<numOfItems;i++){
            posX=GameData.randomRoll(1,mapArray.length-1);
            posY=GameData.randomRoll(1,mapArray[0].length-1);
            if(mapArray[posX][posY]=='.')
                mapArray[posX][posY]=Character.forDigit(i,10);
            else{
                posX=GameData.randomRoll(1,mapArray.length-1);
                posY=GameData.randomRoll(1,mapArray[0].length-1);
            }
        }
    }
    //Checks if a hero is present in a map or not
    //if hero is not present, it assigns a random location
    //for hero, which does not overlap with any positions
    //of 'X's or items
    public void initHeroLocation(){
        boolean heroFound=false;
        //Finds the position of hero in map
        for(int i=0;i<mapArray.length;i++){
            for(int j=0;j<mapArray[0].length;j++){
                if(mapArray[i][j]=='H'){
                    heroRow=i;
                    heroCol=j;
                    heroFound=true;
                }
            }
        }
        //assigns a random unique location to hero
        if(!heroFound){
            heroRow=GameData.randomRoll(1,mapArray.length-1);
            heroCol=GameData.randomRoll(1,mapArray[0].length-1);
            if(mapArray[heroRow][heroCol]!='.'){
                heroRow=GameData.randomRoll(1,mapArray.length-1);
                heroCol=GameData.randomRoll(1,mapArray[0].length-1);
                mapArray[heroRow][heroCol]='H';
            }
            mapArray[heroRow][heroCol]='H';
        }
    }
    //Checks if a move is valid or not
    //if hero tries to move on a 'X' tile
    //method returns false, or else returns true
    private boolean isValidMove(int row, int col){
        if(mapArray[row][col]=='X')
            return false;
        else 
            return true;
    }
    //if the move is valid, it changes the 
    //position of hero. Also changes the new
    // locations of hero to 'H'
    private char applyMove(int endRow, int endCol){
        if(isValidMove(endRow,endCol)){
            heroRow=endRow;
            heroCol=endCol;
        }
        mapArray[heroRow][heroCol]='H';
        return mapArray[heroRow][heroCol];
    }
    //Moves the hero tile by changing the row and
    //column accordingly with the arrow key pressed.
    //Modifies the previous trailing tiles that the
    //hero has moved onto to '.' 
    public char processInput(int direction){
        if(mapArray[heroRow][heroCol]!='X')
        mapArray[heroRow][heroCol]='.';
        if(direction==0 && mapArray[heroRow-1][heroCol]!='X')
            heroRow-=1;
        else if(direction==1 && mapArray[heroRow][heroCol+1]!='X')
            heroCol+=1;
        else if(direction==2 && mapArray[heroRow+1][heroCol]!='X')
            heroRow+=1;
        else if(direction==3 && mapArray[heroRow][heroCol-1]!='X')
            heroCol-=1;
        if(isValidMove(heroRow, heroCol))
            return applyMove(heroRow, heroCol);
        else
            return 'X';
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        