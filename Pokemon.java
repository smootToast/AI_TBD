import java.util.*;

public class Pokemon{

    String name;
    int attack, defense, speed;
    double health, currentHP;
    Type pokeType;
    Moves[] moveList = new Moves[4];

    public Pokemon(String name, double health, int attack, int defense, int speed, int typeNum) {
        this.name = name;
        this.health = health;
        currentHP = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        pokeType = new Type(typeNum);
       
    }
    
    public boolean isFainted(){
        if(currentHP == 0)
            return true;
        return false;
    }

    public void heal(){
        currentHP = health;
    }

    //setter method only really needed for health, other stats should remain the same (for now)
    public void setHealth(double damage) {
        currentHP = currentHP - damage;
        if(currentHP < 0)
            currentHP = 0;
    }
    public void insertMoves(Moves move) {
        for(int i = 0; i < 4; i++)
            if(moveList[i] == null){
                moveList[i] = move;
                break;
            }
                
    }
    //getter methods
    public String getName() {
        return name;
    }
    public double getHP() {
        return health;
    }
    public int getAtk() {
        return attack;
    }
    public int getDef() {
        return defense;
    }
    public int getSpd() {
        return speed;
    }
    public Type getPokeType(){
        return pokeType;
    }
    public double getCurrHP(){
        return currentHP;
    }
    public Moves[] getMoveList() {
        return moveList;
    }

    public void changeName(String name){
        this.name = name;
    }

    public String getMoveName(int i){
        return moveList[i].getName();
    }

    public void printMoves(){
        for(int i = 0; i < 4; i++){
            int k = i + 1;
            System.out.println(k + ": " + moveList[i].getName());
        }
    }
    
}
