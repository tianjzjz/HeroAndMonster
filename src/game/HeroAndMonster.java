package game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import game.component.live.hero.Hero;
import game.component.live.monster.Monster;
import game.component.live.monster.MonsterAttr;
import game.component.live.monster.MonsterModel;
import game.component.other.Bag;
import game.component.other.HeroTeam;
import game.world.Board;
import game.world.arena.Arena;
import game.world.cell.Cell;
import game.world.cell.CommonCell;
import game.world.cell.InaccessibleCell;
import game.world.cell.MarketCell;
import utils.configUtil;
import utils.printUtil;
import utils.randomUtil;
import utils.scannerUtil;

public class HeroAndMonster {

    private Board board;
    private int boardSize;
    private int heroNum;
    private boolean over;
    private HeroTeam team;

    public HeroAndMonster(){

        // welcome

        printUtil.println("           WELCOME!               ");
        printUtil.println("Get ready to start your adventure!");

        // create the board for the game
        boardSize = configUtil.getConfigInt("boardSize", 8);
        board = new Board(boardSize,this);

        // set the board with three types of cell
        int inaccessiblePercent = configUtil.getConfigInt("inaccessiblePercent", 20);
        int marketPercent = configUtil.getConfigInt("marketPercent", 30);
        int commonPercent = 100-inaccessiblePercent-marketPercent;
        int cellNum = boardSize*boardSize;
        int inaccessNum = (int) (cellNum * inaccessiblePercent*0.01);
        int marketNum = (int)(cellNum*marketPercent*0.01);

        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                int rand = randomUtil.nextInt(100);
                if((rand<inaccessiblePercent )&& inaccessNum>0){
                    board.setCell(i, j, new InaccessibleCell(this));
                    inaccessNum--;
                    continue;
                }if((rand<(inaccessiblePercent+marketPercent))&& marketNum>0){
                    board.setCell(i, j, new MarketCell(this));
                    marketNum--;
                    continue;
                }else{
                    board.setCell(i, j, new CommonCell(this));
                }
                
            }
        }

        // obtain number of heroes in the team
        heroNum = setHeroNum();

        // create a team
        team = new HeroTeam(heroNum,this);

        if(team.isEmpty()){
            over = true;
            printUtil.printGreen("BYE!!");
            return;
        }

        initPosition();
   
    }

    public int setHeroNum(){
        int heroNum = scannerUtil.readInt("Enter a number 1-3 to set the size of your team: ");
        while(heroNum>3 || heroNum<1){
            printUtil.printRedBackground("ERROR INPUT: You should enter an integer between 1 to 3");
            heroNum = scannerUtil.readInt("Try again! Enter a numer: ");
        }
        return heroNum;
    }

    /**
     * init a random position on the board
     */
    public void initPosition(){
        while(true){
            int row = randomUtil.nextInt(boardSize);
            int col = randomUtil.nextInt(boardSize);

            if(board.isCommon(row, col)){
                team.move(row, col);
                board.move(row,col);
                break;
            }
        }
    }

    public void setPosition(int row, int col){
        team.move(row, col);
        board.move(row, col);
    }

    public void start(){
        while(!over){
            board.printBoard();
            opera();
        }
        printUtil.printBlueBackground("      GAME OVER       ");
    }

    public Hero pickHero(){
        team.printHeroInTeam();
        while(true){
            String choice = scannerUtil.readLine("Copy the name of Hero you wnant to operate:");
            printUtil.print();

            Hero hero = team.findHero(choice.trim());
            if(hero == null){
                printUtil.printError("Cannot find this hero in your team!");
            }else{
                return hero;
            }
        }
    }  

    public void operaBag() {
        Hero hero = pickHero();
        Bag bag = hero.getBag();
        operateBag(bag);
    }

        /**
     * action on bag
     */
    public void operateBag(Bag bag){
        while(true){
            bag.printBagOpt();
            String input = scannerUtil.readLine("Your Choice:");
            if(input.equalsIgnoreCase("b")){
                return;
            }else if(input.equalsIgnoreCase("w")){
                bag.weaponChoice();
            }else if(input.equalsIgnoreCase("a")){
                bag.armorChoice();
            }else if(input.equalsIgnoreCase("p")){
                bag.usePotion();
            }else if(input.equalsIgnoreCase("i")){
                bag.printBagInfo();
            }else if(input.equalsIgnoreCase("q")){
                setOver();
                return;

            }else{
                printUtil.printError("Invalid Command!");
            }
        }
    }
    

    public void printInfo() {
        team.printTeamInfo();
    }



    // process the game
    public void opera(){
        while(true){
            board.printBoardMenu();

            // print the menu
            String choice = scannerUtil.readLine("Your choice:");
            if(choice.equalsIgnoreCase("q")){
                over = true;
                return;
            }else if(choice.equalsIgnoreCase("b")){
                printUtil.print("openning bag...");
                operaBag();
            }
            else if(readOpt(choice)){
                if(board.isMarket()){
                    // printUtil.print("You encounter a market.");
                    board.processMarket();
                }else if(board.isCommon(team.getRow(), team.getCol())){
                    printUtil.print("Your team enters a common space!");
                    if(isEncounterFight()){
                        fight();

                    }
                }
            }
            if(over){
                return;
            }else{
                board.printBoard();

            }

        }

    }

    public void setOver(){
        over = true;
    }

    public boolean moveUp(){
        if(team.getRow()==0){
            printUtil.printError("You cannot make a movement up!");
            return false;
        }else if(!board.canMove(team.getRow()-1, team.getCol())){
            return false;
        }else{
            setPosition(team.getRow()-1, team.getCol());
            // printUtil.print("Successfully move up");

            return true;
        }
    }

    public boolean moveDown(){
        if(team.getRow()==(boardSize-1)){
            printUtil.printError("You cannot make a movement down!");
            return false;
        }else if(!board.canMove(team.getRow()+1, team.getCol())){
            return false;
            
        } else{
            setPosition(team.getRow()+1, team.getCol());
            // printUtil.print("Successfully move down");

            return true;
        }
    }

    public boolean moveLeft(){
        if(team.getCol()==0){
            printUtil.printError("You cannot make a movement left!");
            return false;
        }else if (!board.canMove(team.getRow(), team.getCol()-1)){
            return false;
        }
        else{
            setPosition(team.getRow(), team.getCol()-1);
            // printUtil.print("Successfully move left");

            return true;
        }
    }
    public boolean moveRight(){
        if(team.getCol()==(boardSize-1)){
            printUtil.printError("You cannot make a movement right!");
            return false;
        }else if( !board.canMove(team.getRow(), team.getCol()+1)){
            return false;
        }else{
            setPosition(team.getRow(), team.getCol()+1);
            // printUtil.print("Successfully move right");

            return true;
        }
    }
    

    public boolean readOpt(String input){
        // printUtil.print("you input "+input);

        if(input.equalsIgnoreCase("w")){
            // printUtil.print("you input w");
            return moveUp();
        }else if(input.equalsIgnoreCase("s")){
            // printUtil.print("you input s");

            return moveDown();
        }else if(input.equalsIgnoreCase("a")){
            // printUtil.print("you input a");

            return moveLeft();
        }else if(input.equalsIgnoreCase("d")){
            // printUtil.print("you input d");

            return moveRight();
        }else if(input.equalsIgnoreCase("i")){
            // printUtil.print("you input i");

            printInfo();
            return false;
        }else{
            printUtil.printError("invalid command");
            return false;
        }




    }

    public void fight(){
        printUtil.printWithBoundary("Get Ready to your Fight!");
        List<Monster> monsterList = createMonster(team.getTeamList());

        printUtil.print("Oooops! There is/are "+ monsterList.size()+" monsters! Your team need to defeat all!");

        printUtil.print();

        Arena arena = new Arena(team.getTeamList(), monsterList, this);

        arena.fight();
        boolean allFaint = true;

        for(Hero hero: team.getTeamList()){
            if(hero.isAlive()){
                allFaint=false;
            }
        }
        if(allFaint){
            setOver();
        }
    }

    public List<Monster> createMonster(List<Hero> list){
        int highestLevel = 0;
        for(Hero hero: list){
            if(hero.getLevel()>highestLevel){
                highestLevel = hero.getLevel();
            }
        }

        List<MonsterAttr> monsterAttrList = MonsterModel.getMonster();
        Collections.shuffle(monsterAttrList);
        List<Monster> monsterList = new ArrayList<>(heroNum);

        for(MonsterAttr monster: monsterAttrList){
            if(monsterList.size()==heroNum){
                break;
            }
            if(monster.getLevel()==highestLevel){
                monsterList.add(MonsterModel.createMonster(monster));
            }
        }
        while(monsterList.size()<heroNum){
            monsterList.add(monsterList.get(0));

        }

        return monsterList;
    }

    public boolean isEncounterFight(){
        int prob = configUtil.getConfigInt("fightProb", 90);
        if(randomUtil.nextInt(100)<prob){
            printUtil.print("Unfortunately, your team encounter a fight!");
            return true;
        }
        printUtil.printGreen("You guys are so luck! There are no monsters there!");
        return false;

    }



}
