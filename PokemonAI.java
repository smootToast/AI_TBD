import java.util.*; 

//Battle simulation is done under this class.
//No PokemonAI object is created, this counts as our driver class.
//All Pokemon trainers and Pokemon are created under this class.
public class PokemonAI{
    static PokemonTeam player = new PokemonTeam("player");
        
    static PokemonTeam Leader1 = new PokemonTeam("Adam");
    static PokemonTeam Leader2 = new PokemonTeam("Bertha");
    static PokemonTeam Leader3 = new PokemonTeam("Ivan");
    static PokemonTeam Leader4 = new PokemonTeam("Shrek");
    static PokemonTeam Leader5 = new PokemonTeam("Harrison");
    static PokemonTeam Leader6 = new PokemonTeam("Ethan");
    static PokemonTeam Leader7 = new PokemonTeam("Kelly");
    static PokemonTeam Leader8 = new PokemonTeam("Vardan");
    
    public static void main(String[] args) throws InterruptedException{     
        String name;
        int res = -1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Poke-Battle Emulator!");
        while(res != 1 && res != 0){
            System.out.println("Enter 1 to start a new adventure! Enter 0 to exit.");
            res = scanner.nextInt();
            if(res == 1){

                Scanner scanz = new Scanner(System.in);
                System.out.println("Hello there! Welcome to the world of POKEMON! My name is OAK! People call me the POKEMON PROF!");
                Thread.sleep(2000);
                System.out.println("This world is inhabited by creatures called POKEMON!");
                Thread.sleep(2000);
                System.out.println("For some people, POKEMON are pets. Others use them for fights. Myself...I study POKEMON as a profession.");
                Thread.sleep(2000);
                System.out.println("First, what is your name?");
                name = scanz.nextLine();
                System.out.println("Right! So your name is " + name + "!");
                Thread.sleep(2000);
                System.out.println( name + "!" + " Your very own POKEMON legend is about to unfold!");
                Thread.sleep(2000);
                System.out.println("A world of dreams and adventures with POKEMON awaits! Let's go!");

                player.trainerName = name;
                generateTeams();
                System.out.println("A New Challenger has appeared! " + Leader1.getName() + " wants to battle!");
                doBattle(new Battle(player, Leader1));
                player.healAll();

                System.out.println("A New Challenger has appeared! " + Leader2.getName() + " wants to battle!");
                doBattle(new Battle(player, Leader2));
                player.healAll();

                System.out.println("A New Challenger has appeared! " + Leader3.getName() + " wants to battle!");
                doBattle(new Battle(player, Leader3));
                player.healAll();

                System.out.println("A New Challenger has appeared! " + Leader4.getName() + " wants to battle!");
                doBattle(new Battle(player, Leader4));
                player.healAll();

                System.out.println("A New Challenger has appeared! " + Leader5.getName() + " wants to battle!");
                doBattle(new Battle(player, Leader5));
                player.healAll();

                System.out.println("A New Challenger has appeared! " + Leader6.getName() + " wants to battle!");
                doBattle(new Battle(player, Leader6));
                player.healAll();

                System.out.println("A New Challenger has appeared! " + Leader7.getName() + " wants to battle!");
                doBattle(new Battle(player, Leader7));
                player.healAll();

                System.out.println("A New Challenger has appeared! " + Leader8.getName() + " wants to battle!");
                doBattle(new Battle(player, Leader8));
                player.healAll();

                System.out.println("You've defeated all challengers! Congratulations!");
                System.exit(0);
            }else if(res == 0){
                System.exit(0);
            }else{
                System.out.println("Invalid input. Try again!");
            }
        }

    }

    //The current "GUI" of the simulator.
    public static void printBattle(Battle currentBattle){
        System.out.println(player.trainerName + " has sent out " + currentBattle.currentPokemon.getName());
        Pokemon userPoke = currentBattle.currentPokemon;
        Pokemon enemyPoke = currentBattle.enemyCurrent;
        System.out.println("---------------------");
        System.out.println(userPoke.getName());
        
        System.out.println(userPoke.getCurrHP() + "/" + userPoke.getHP());
        System.out.println("---------------------");
        System.out.println(enemyPoke.getName());
        
        System.out.println(enemyPoke.getCurrHP() + "/" + enemyPoke.getHP());
        System.out.println("---------------------");
    }

    //Battle simulator.
    public static void doBattle(Battle currentBattle){
        Scanner scan = new Scanner(System.in);

        while(!currentBattle.userTeam.allFainted() && !currentBattle.enemyTeam.allFainted()){
            
            printBattle(currentBattle);
            System.out.println("Attack by entering [1] or switch by entering [2]?");

            int playOp = scan.nextInt(); 

            // Your move.
            if(playOp == 1){ 
                 currentBattle.chooseMove();
            } 

            // Your opponent's move.
            if(playOp == 2){
                System.out.println("Choose your Pokemon.");
                
                currentBattle.switchPokemon();
            } 
            if(player.allFainted() || currentBattle.enemyTeam.allFainted()){
                break;
            }
        }
    }

    static void generateTeams(){
        Type normal = new Type(0);
        Type fire = new Type(1);
        Type water = new Type(2);
        Type grass = new Type(3);
        Type electric = new Type(4);
        Type ice = new Type(5);
        Type fighting = new Type(6);
        Type poison = new Type(7);
        Type ground = new Type(8);
        Type flying = new Type(9);
        Type psychic = new Type(10);
        Type bug = new Type(11);
        Type rock = new Type(12);
        Type ghost = new Type(13);
        Type dragon = new Type(14);

        //Initialize teams.
        
        

        //Generate all the Pokemon.

//PLAYER
        //Charizard, Player
        Pokemon charizard = new Pokemon("Charizard", 359, 266, 268,  298, 1);
        Moves fireBlast = new Moves(120, 85, 8, "Fire Blast", fire);
        Moves flamethrower = new Moves(95, 100, 24, "Flamethrower", fire);
        Moves ancientPwr = new Moves(60, 100, 8, "Ancient Power", rock);
        Moves fly = new Moves(90, 95, 24, "Fly", flying);
        charizard.insertMoves(fireBlast);
        charizard.insertMoves(flamethrower);
        charizard.insertMoves(fly);
        charizard.insertMoves(ancientPwr);
        //Venusaur, Player
        Pokemon venusaur = new Pokemon("Venusaur", 363, 262, 298,258, 3);
        Moves earthquake = new Moves(100, 100, 16, "Earthquake", ground);
        Moves bodySlam = new Moves(85, 100, 24, "Body Slam", normal);
        Moves nrgBall = new Moves(90, 100, 16, "Energy Ball", grass);
        Moves sludgeBomb = new Moves(90, 100, 16, "Sludge Bomb", poison);
        venusaur.insertMoves(earthquake);
        venusaur.insertMoves(bodySlam);
        venusaur.insertMoves(nrgBall);
        venusaur.insertMoves(sludgeBomb);
        //Blastoise, Player
        Pokemon blastoise = new Pokemon("Blastoise", 361, 264, 298, 254, 2);
        Moves dragonPulse = new Moves(85, 100, 16, "Dragon Pulse", dragon);
        Moves hydroPump = new Moves(110, 80, 8, "Hydro Pump", water);
        blastoise.insertMoves(bodySlam);
        blastoise.insertMoves(earthquake);
        blastoise.insertMoves(dragonPulse);
        blastoise.insertMoves(hydroPump);

        //Insert mon for Player
        player.insertPokemon(charizard);
        player.insertPokemon(venusaur);
        player.insertPokemon(blastoise);

//LEADER 1
        //Geodude, Leader 1
        Pokemon geodude = new Pokemon("Geodude", 221, 196, 236, 96, 12);
        Moves brickBreak = new Moves(75, 100, 24, "Brick Break", fighting);
        geodude.insertMoves(ancientPwr);
        geodude.insertMoves(bodySlam);  
        geodude.insertMoves(brickBreak);
        geodude.insertMoves(earthquake);
        
        
        //Sandshrew, Leader 1
        Pokemon sandshrew = new Pokemon("Sandshrew", 241, 186, 206, 116, 8);
        Moves focusPunch = new Moves(150, 100, 32, "Focus Punch", fighting);
        Moves poisonJab = new Moves(80, 100, 32, "Poison Jab", poison);
        
        
        sandshrew.insertMoves(brickBreak);
        sandshrew.insertMoves(focusPunch);
        sandshrew.insertMoves(poisonJab);
        sandshrew.insertMoves(bodySlam);
        
        //Onix, Leader 1
        Pokemon onix = new Pokemon("Onix", 211, 126, 356, 176, 12);
        onix.insertMoves(bodySlam);
        onix.insertMoves(earthquake);
        onix.insertMoves(ancientPwr);
        onix.insertMoves(dragonPulse);


//LEADER 2
        //Pidgeot, Leader 2
        Pokemon pidgeot = new Pokemon("Pidgeot", 307, 196, 186, 238, 9);
        Moves braveBird = new Moves(120, 100, 24, "Brave Bird", flying);
        Moves hurricane = new Moves(110, 70, 16, "Hurricane", flying);
        Moves uTurn = new Moves(70, 100, 32, "U-Turn", bug);
        pidgeot.insertMoves(braveBird);
        pidgeot.insertMoves(hurricane);
        pidgeot.insertMoves(uTurn);
        pidgeot.insertMoves(fly);
        //Hitmonchan, Leader 2
        Pokemon hitmonchan = new Pokemon("Hitmonchan", 241, 246, 194, 188, 6);
        Moves closeCombat = new Moves(120, 100, 8, "Close Combat", fighting);
        Moves firePunch = new Moves(75, 100, 24, "Fire Punch", fire);
        Moves icePunch = new Moves(75, 100, 24, "Ice Punch", ice);
        Moves thunderPunch = new Moves(75, 100, 24, "Thunder Punch", electric);
        hitmonchan.insertMoves(closeCombat);
        hitmonchan.insertMoves(firePunch);
        hitmonchan.insertMoves(icePunch);
        hitmonchan.insertMoves(thunderPunch);
        //Electabuzz, Leader 2
        Pokemon electabuzz = new Pokemon("ELectabuzz", 211, 126, 356, 176, 12);
        Moves thunder = new Moves(110, 70, 16, "Thunder", electric);
        electabuzz.insertMoves(bodySlam);
        electabuzz.insertMoves(thunder);
        electabuzz.insertMoves(icePunch);
        electabuzz.insertMoves(firePunch);

//LEADER 3
        //Flareon, Leader 3
        Pokemon flareon = new Pokemon("Flareon", 271, 296, 256, 166, 1);
        Moves hyperVoice = new Moves(90, 100, 16, "Hyper Voice", normal);
        flareon.insertMoves(bodySlam);
        flareon.insertMoves(fireBlast);
        flareon.insertMoves(flamethrower);
        flareon.insertMoves(hyperVoice);
        //Jolteon, Leader 3
        Pokemon jolteon = new Pokemon("Jolteon", 271, 256, 226, 296, 4);
        Moves shadowBall = new Moves(80, 100, 24, "Shadow Ball", ghost);
        Moves discharge = new Moves(80, 100, 24, "Discharge", electric);
        jolteon.insertMoves(hyperVoice);
        jolteon.insertMoves(thunder);
        jolteon.insertMoves(shadowBall);
        jolteon.insertMoves(discharge);
        //Vaporeon, Leader 3
        Pokemon vaporeon = new Pokemon("Vaporeon", 401, 256, 226, 166, 2);
        Moves blizzard = new Moves(110, 70, 8, "Blizzard", ice);
        vaporeon.insertMoves(blizzard);
        vaporeon.insertMoves(hyperVoice);
        vaporeon.insertMoves(shadowBall);
        vaporeon.insertMoves(hydroPump);



//LEADER 4
        //Starmie, Leader 4
        Pokemon starmie = new Pokemon("Starmie", 261, 236, 206, 266, 2);
        Moves psychicMove = new Moves(90, 100, 16, "Psychic", psychic);
        Moves iceBeam = new Moves(90, 100, 16, "Ice Beam", ice);
        starmie.insertMoves(iceBeam);
        starmie.insertMoves(hydroPump);
        starmie.insertMoves(psychicMove);
        starmie.insertMoves(thunder);
        //Blastoise, Leader 4
        //Seadra, Leader 4
        Pokemon seadra = new Pokemon("Seadra", 251, 226, 226, 206, 2);
        Moves waterfall = new Moves(80, 100, 16, "Waterfall", water);
        seadra.insertMoves(waterfall);
        seadra.insertMoves(dragonPulse);
        seadra.insertMoves(iceBeam);
        seadra.insertMoves(hydroPump);
        Pokemon blastoise2 = new Pokemon("Blastoise", 361, 264, 298, 254, 2);
        blastoise2.insertMoves(bodySlam);
        blastoise2.insertMoves(earthquake);
        blastoise2.insertMoves(dragonPulse);
        blastoise2.insertMoves(hydroPump);



//LEADER 5
        //Magmar, Leader 5
        Pokemon magmar = new Pokemon("Magmar", 333, 288, 212, 284, 1);
        Moves hyperBeam = new Moves(150, 90, 5, "Hyper Beam", normal);
        magmar.insertMoves(fireBlast);
        magmar.insertMoves(bodySlam);
        magmar.insertMoves(flamethrower);
        magmar.insertMoves(hyperBeam);
        //Arcanine, Leader 5
        Pokemon arcanine = new Pokemon("Arcanine", 321, 256, 196, 226, 1);
        Moves superPwr = new Moves(120, 100, 8, "Super Power", fighting);
        Moves psychicFangs = new Moves(85, 100, 16, "Psychic Fangs", psychic);
        arcanine.insertMoves(superPwr);
        arcanine.insertMoves(psychicFangs);
        arcanine.insertMoves(fireBlast);
        arcanine.insertMoves(dragonPulse);
        //Charizard, Leader 5
        Pokemon charizard2 = new Pokemon("Charizard", 359, 266, 268,  298, 1);
        charizard2.insertMoves(fireBlast);
        charizard2.insertMoves(flamethrower);
        charizard2.insertMoves(fly);
        charizard2.insertMoves(ancientPwr);


//LEADER 6
        //Venusaur, Leader 6
        //Tangela, Leader 6
        Pokemon tangela = new Pokemon("Tangela", 271, 236, 266, 156, 3);
        Moves leafStorm = new Moves(130, 90, 8, "Leaf Storm", grass);
        Moves vinewhip = new Moves(45, 100, 25, "Vine Whip", grass);
        tangela.insertMoves(vinewhip);
        tangela.insertMoves(nrgBall);
        tangela.insertMoves(leafStorm);
        tangela.insertMoves(sludgeBomb);
        //Vileplume, Leader 6
        Pokemon vileplume = new Pokemon("Vileplume", 291, 256, 216, 136, 3);
        Moves drainPunch = new Moves(75, 100, 16, "Drain Punch", fighting);
        vileplume.insertMoves(drainPunch);
        vileplume.insertMoves(nrgBall);
        vileplume.insertMoves(sludgeBomb);
        vileplume.insertMoves(bodySlam);

        Pokemon venusaur2 = new Pokemon("Venusaur", 363, 262, 298,258, 3);
        venusaur2.insertMoves(earthquake);
        venusaur2.insertMoves(bodySlam);
        venusaur2.insertMoves(nrgBall);
        venusaur2.insertMoves(sludgeBomb);


//LEADER 7
        //Articuno, Leader 7
        Pokemon articuno = new Pokemon("Articuno", 321, 226, 286, 206, 5);
        Moves extrasensory = new Moves(80, 100, 32, "Extrasensory", psychic);
        articuno.insertMoves(blizzard);
        articuno.insertMoves(ancientPwr);
        articuno.insertMoves(braveBird);
        articuno.insertMoves(extrasensory);
        //Moltres, Leader 7
        Pokemon moltres = new Pokemon("Moltres", 321, 286, 216, 216, 1);
        moltres.insertMoves(fireBlast);
        moltres.insertMoves(ancientPwr);
        moltres.insertMoves(braveBird);
        moltres.insertMoves(extrasensory);
        //Zapdos, Leader 7
        Pokemon zapdos = new Pokemon("Zapdos", 321, 286, 216, 236, 4);
        zapdos.insertMoves(thunder);
        zapdos.insertMoves(ancientPwr);
        zapdos.insertMoves(braveBird);
        zapdos.insertMoves(extrasensory);



//LEADER 8
        //Dragonite, Leader 8
        Pokemon dragonite = new Pokemon("Dragonite", 323, 304, 236, 196, 14);
        Moves dracoMeteor = new Moves(130, 90, 8, "Draco Meteor", dragon);
        dragonite.insertMoves(bodySlam);
        dragonite.insertMoves(dracoMeteor);
        dragonite.insertMoves(iceBeam);
        dragonite.insertMoves(thunder);
        //Mewtwo, Leader 8
        Pokemon mewtwo = new Pokemon("Mewtwo", 353, 344, 216, 296, 10);
        Moves thunderBolt = new Moves(90, 100, 24, "Thunderbolt", electric);
        mewtwo.insertMoves(shadowBall);
        mewtwo.insertMoves(psychicMove);
        mewtwo.insertMoves(thunderBolt);
        mewtwo.insertMoves(iceBeam);
        //Mew, Leader 8
        Pokemon mew = new Pokemon("Mew", 341, 236, 236, 236, 10);
        mew.insertMoves(shadowBall);
        mew.insertMoves(psychicMove);
        mew.insertMoves(thunderBolt);
        mew.insertMoves(braveBird);
//POKEMON TEAM INSERTION
        
        //Leader 1
        Leader1.insertPokemon(geodude);
        Leader1.insertPokemon(seadra);
        Leader1.insertPokemon(vileplume);           
        //Leader 2
        Leader2.insertPokemon(pidgeot);
        Leader2.insertPokemon(hitmonchan);
        Leader2.insertPokemon(arcanine);         
        //Leader 3
        Leader3.insertPokemon(flareon);
        Leader3.insertPokemon(jolteon);
        Leader3.insertPokemon(vaporeon);    
        //Leader 4
        Leader4.insertPokemon(magmar);
        Leader4.insertPokemon(sandshrew);
        Leader4.insertPokemon(blastoise2);
        //Leader 5
        Leader5.insertPokemon(starmie);
        Leader5.insertPokemon(charizard2);
        Leader5.insertPokemon(electabuzz);
        //Leader 6
        Leader6.insertPokemon(venusaur2);
        Leader6.insertPokemon(tangela);
        Leader6.insertPokemon(onix);
        //Leader 7
        Leader7.insertPokemon(articuno);
        Leader7.insertPokemon(moltres);
        Leader7.insertPokemon(zapdos);
        //Leader 8
        Leader8.insertPokemon(dragonite);
        Leader8.insertPokemon(mew);
        Leader8.insertPokemon(mewtwo);
    }
    
}
