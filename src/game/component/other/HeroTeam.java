package game.component.other;

import java.util.ArrayList;
import java.util.List;

import game.HeroAndMonster;
import game.component.attr.Movable;
import game.component.live.hero.Hero;
import game.component.live.hero.HeroModel;
import utils.printUtil;
import utils.scannerUtil;

public class HeroTeam implements Movable{

    private int size;
    private List<Hero> team;
    private int currRow;
    private int currCol;
    private boolean isEmpty;
    private HeroAndMonster game;

    public HeroTeam(int size, HeroAndMonster game){
        this.size = size;
        this.team = new ArrayList<>(size);
        this.isEmpty = true;
        this.game = game;
        init();
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void printHeroOpt(){
        printUtil.printWithBoundary("Hero List");

        HeroModel.print();
        printUtil.printBoundary();



    }
    public void init(){

        printHeroOpt();
        for(int i=0; i<this.size; i++){

            int n = i+1;

            printUtil.printYellow("Creating No."+n+" hero...");
            while(true){
                String input = scannerUtil.readLine("Please copy down one name of the hero you want to add. (Enter Q/q to quit)");
                if(input.equalsIgnoreCase("q")){
                    game.setOver();
                    return;
                }

                Hero hero = HeroModel.createHero(input.trim());
                if(hero == null){
                    printUtil.printError("invalid name input!");
                }else{
                    if(isContain(hero)){
                        printUtil.printError("you cannot create duplicate heroes!");
                    }else{
                        team.add(hero);
                        printUtil.printGreen("Successfully create new Hero: "+ hero.getName());
                        printUtil.print();
                        this.isEmpty = false;
                        break;
                    }
                }
            }
        }
    }
    
    public boolean isContain(Hero find){
        for(Hero hero:team){
            if(hero.equals(find)){
                return true;
            }
        }
        return false;
    }

    public void move(int row, int col){
        currRow = row;
        currCol = col;
    }

    public void printHeroInTeam(){
        printUtil.printWithBoundary("Heroes in your team");
        for(Hero hero: team){
            printUtil.print(hero.getName());
        }
    }

    public void printTeamInfo(){
        int i=1;
        for(Hero hero: team){
            printUtil.printDotBoundary("Team member "+hero.getName()+" info");
            hero.printHeroInfo();
            i++;
        }
        printUtil.print();
    }

    public int getRow(){
        return currRow;
    }

    public int getCol(){
        return currCol;
    }

    public int getHeroNum(){
        return size;
    }

    public List<Hero> getTeamList(){
        return team;
    }

    public Hero findHero(String name){
        for(Hero hero: team){
            if(hero.getName().equals(name)){
                return hero;
            }
        }
        return null;
    }


}
