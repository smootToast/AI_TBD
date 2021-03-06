import java.util.*;

//This object is the stat "type" of a Pokemon.
//Utilizes the type to do effectiveness checks.
//Those checks being utilized under heuristic function calculations and damage calculations.
class Type{
    
    //The order of appearance - from left to right / top to bottom.
    //Normal, Fire, Water, Grass, Electric, Ice, Fighting, 
    //Poison, Ground, Flying, Psychic, Bug, Rock, Ghost, Dragon
    //Type effectiveness is valued as the following:
    //0 = no effect
    //0.5 = not very effective
    //1 = neutral
    //2 = super effective
    private double[][] type = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 0, 1},      
        {1, 0.5, 0.5, 2, 1, 2, 1, 1, 1, 1, 1, 2, 0.5, 1, 0.5},     
        {1, 2, 0.5, 0.5, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0.5},     
        {1, 0.5, 2, 0.5, 1, 1, 1, 0.5, 2, 0.5, 1, 0.5, 2, 1, 0.5},
        {1, 1, 2, 0.5, 0.5, 1, 1, 1, 0, 2, 1, 1, 1, 1, 0.5},
        {1, 0.5, 0.5, 2, 1, 0.5, 1, 1, 2, 2, 1, 1, 1, 1, 2},
        {2, 1, 1, 1, 1, 2, 1, 0.5, 1, 0.5, 0.5, 0.5, 2, 0, 1},
        {1, 1, 1, 2, 1, 1, 1, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 1},
        {1, 2, 1, 0.5, 2, 1, 1, 2, 1, 0, 1, 0.5, 2, 1, 1},
        {1, 1, 1, 2, 0.5, 1, 2, 1, 1, 1, 1, 2, 0.5, 1, 1},
        {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 0.5, 1, 1, 1, 1},
        {1, 0.5, 1, 2, 1, 1, 0.5, 0.5, 1, 0.5, 2, 1, 1, 0.5, 1},
        {1, 2, 1, 1, 1, 2, 0.5, 1, 0.5, 2, 1, 2, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}
    };

    private String typeName;
    private int typeNum;

    public Type(int num){
        typeNum = num;
        switch(num) {
            case 0:
                typeName = "normal";
                break;
            case 1:
                typeName = "fire";
                break;
            case 2:
                typeName = "water";
                break;
            case 3:
                typeName = "grass";
                break;
            case 4:
                typeName = "electric";
                break;
            case 5:
                typeName = "ice";
                break;
            case 6:
                typeName = "fighting";
                break;
            case 7:
                typeName = "poison";
                break;
            case 8:
                typeName = "ground";
                break;
            case 9:
                typeName = "flying";
                break;
            case 10:
                typeName = "psychic";
                break;
            case 11:
                typeName = "bug";
                break;
            case 12:
                typeName = "rock";
                break;
            case 13:
                typeName = "ghost";
                break;
            case 14:
                typeName = "dragon";
                break;
                
            default:
                System.out.println("Error, no type found");
                break;
        }
    }

    public int getTypeNum(){
        return typeNum;
    }

    public String getTypeName(){
        return typeName;
    }

    public double getEffectiveness(Type targetDEF) {        
        return type[typeNum][targetDEF.typeNum];
    }
    
    public void changeTypeNum(int i) {
        typeNum = i;
    }
}
