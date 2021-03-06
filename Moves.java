import java.util.*; 

//Moves class is an instance of an object utilizing Pokemon's move data.
//Source of the stats come from the game's original code to their moves.
public class Moves {
    int damage, accuracy, pp;
    String moveName;
    Type typeMove;

    public Moves(int damage, int accuracy, int pp, String moveName, Type typeMove) {
        this.damage = damage;
        this.accuracy = accuracy;
        this.pp = pp;
        this.moveName = moveName;
        this.typeMove = typeMove;
    }

    public Type getType(){
        return typeMove;
    }

    public int getDamage(){
        return damage;
    }

    public int getAccuracy(){
        return accuracy;
    }

    //PP = power points, i.e. how many times a moved can be used.
    public int getPP(){
        return pp;
    }
    
    public String getName(){
        return moveName;
    } 
}