package gamealgo;

import java.util.Scanner;
import java.util.Random;

public class GameAlgo
{
    private static int choiceNumber;
    private static boolean isPlaying = true;
    private static Scanner scan;
    private static Heroes user,opponent;
    
    public static void main(String[] args) throws InterruptedException
    {
       scan = new Scanner(System.in);
       
        OUTER:
        while (isPlaying)
        {
            System.out.print("\n\n"
                    + "Welcome to kepap legends\n"
                    + "=====================================================\n"
                    + "1 - Start Game\n"
                    + "2 - Exit\n"
                    + "=====================================================\n"
                    + "Input: ");
            
            String input = scan.next().trim();
            
            if (tryParse(input))
            {
                choiceNumber = Integer.parseInt(input.trim());
                switch (choiceNumber)
                {
                    case 1:
                        System.out.print("\nLoading..");
                        for(int i = 0; i <= 6; i++)
                        {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        
                        System.out.print("\n\n"
                                + "Choose your hero: \n"
                                + "=====================================================\n"
                                + "1 - Nayeon\n"
                                + "2 - Chaeyoung\n"
                                + "3 - Mina\n"
                                + "4 - Back to Main Menu\n"
                                + "=====================================================\n"
                                + "Input: ");
                        
                        input = scan.next().trim();
                        if(tryParse(input))
                        {
                            choiceNumber = Integer.parseInt(input.trim());
                            switch(choiceNumber)
                            {
                                case 1:
                                    if(finalChampion("Nayeon"))
                                    {
                                        user = new Heroes("Nayeon", "HI! I am Nayeonie...", new String[]{"Charm", "Health" ,"Aegyo"}, 100, new int[]{10, 15, 20});
                                        enemyAppears();
                                        championAndOpponentStatus();
                                        printStatus();
                                        
                                        if(opponent.getHealthPoints() == 0)
                                        {
                                            System.out.print("\n" + user.getHeroName() + " wins!\n"
                                                    + user.getHeroName() + ": " + user.getHeroTalk());
                                        }
                                        else if(user.getHealthPoints() == 0)
                                        {
                                            System.out.print("\n" + opponent.getHeroName() + " wins!\n"
                                                    + opponent.getHeroName() + ": " + opponent.getHeroTalk());
                                        }
                                        else if(opponent.getHealthPoints() == 0 && user.getHealthPoints() == 0)
                                        {
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        break;
                                    }
                                    
                                    break;
                                    
                                case 2:
                                    if(finalChampion("Chaeyoung"))
                                    {
                                        user = new Heroes("Chaeyoung", "HI! I am Chaeyoung...", new String[]{"Rap", "Health" ,"MiChaeng Charm"}, 100, new int[]{5, 15, 40});
                                        enemyAppears();
                                        championAndOpponentStatus();
                                        printStatus();
                                        if(opponent.getHealthPoints() == 0)
                                        {
                                            System.out.print("\n" + user.getHeroName() + " wins!\n"
                                                    + user.getHeroName() + ": " + user.getHeroTalk());
                                        }
                                        else if(user.getHealthPoints() == 0)
                                        {
                                            System.out.print("\n" + opponent.getHeroName() + " wins!\n"
                                                    + opponent.getHeroName() + ": " + opponent.getHeroTalk());
                                        }
                                        else if(opponent.getHealthPoints() == 0 && user.getHealthPoints() == 0)
                                        {
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        break;
                                    }
                                    break;
                                
                                case 3:
                                    if(finalChampion("Mina"))
                                    {
                                        user = new Heroes("Mina", "HI! I am Minari...", new String[]{"Ballet", "Health" ,"MiChaeng Charm"}, 100, new int[]{10, 15, 40});
                                        enemyAppears();
                                        championAndOpponentStatus();
                                        printStatus();
                                        if(opponent.getHealthPoints() == 0)
                                        {
                                            System.out.print("\n" + user.getHeroName() + " wins!\n"
                                                    + user.getHeroName() + ": " + user.getHeroTalk());
                                        }
                                        else if(user.getHealthPoints() == 0)
                                        {
                                            System.out.print("\n" + opponent.getHeroName() + " wins!\n"
                                                    + opponent.getHeroName() + ": " + opponent.getHeroTalk());
                                        }
                                        else if(opponent.getHealthPoints() == 0 && user.getHealthPoints() == 0)
                                        {
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        break;
                                    }
                                    break;
                                
                                case 4:
                                    System.out.print("\nLoading..");
                                    for(int i = 0; i <= 6; i++)
                                    {
                                        Thread.sleep(500);
                                        System.out.print(".");
                                    }
                                    break;
                            }
                        }
                        
                        break;
                    case 2:
                        break OUTER;
                    default:
                        System.out.println("Please input digits 1 or 2 only");
                        break;
                }
            }
            else
            {
                System.out.println("Please input digits 1 or 2 only");
            }
        }
    }
    
    private static void userAbility(int abilityNumber)
    {
        
        Random ran = new Random();
        int damage = 0;
        
        switch(abilityNumber)
        {
            case 0: 
                damage = ran.nextInt(user.getFirstAbilityDamage());
                opponent.setHealthPoints(opponent.getHealthPoints() - damage);
                System.out.print("\n\n"
                    +user.getHeroName() + " used " + user.getFirstAbilityName());
                break;
            case 1: 
                damage = ran.nextInt(user.getSecondAbilityDamage());
                user.setHealthPoints(user.getHealthPoints() + damage);
                if(user.getHealthPoints() > 100)
                {
                    user.setHealthPoints(100);
                }
                System.out.print("\n\n"
                    +user.getHeroName() + " used " + user.getSecondAbilityName());
                break;
            case 2: 
                damage = ran.nextInt(user.getThirdAbilityDamage());
                opponent.setHealthPoints(opponent.getHealthPoints() - damage);
                System.out.print("\n\n"
                    +user.getHeroName() + " used " + user.getThirdAbilityName());
                break;
        }
        if(user.getHealthPoints() < 0)
        {
            user.setHealthPoints(0);
        }
    }
    
    private static void opponentAbility()
    {
        Random ran = new Random();
        int damage = 0;
        
        switch(ran.nextInt(2))
        {
            case 0: 
                damage = ran.nextInt(opponent.getFirstAbilityDamage());
                user.setHealthPoints(user.getHealthPoints() - damage);
                System.out.print("\n\n"
                    +opponent.getHeroName() + " used " + opponent.getFirstAbilityName());
                break;
            case 1: 
                damage = ran.nextInt(opponent.getSecondAbilityDamage());
                opponent.setHealthPoints(opponent.getHealthPoints() + damage);
                if(opponent.getHealthPoints() > 100)
                {
                    opponent.setHealthPoints(100);
                }
                System.out.print("\n\n"
                    +opponent.getHeroName() + " used " + opponent.getSecondAbilityName());
                break;
            case 2: 
                damage = ran.nextInt(opponent.getThirdAbilityDamage());
                user.setHealthPoints(user.getHealthPoints() - damage);
                System.out.print("\n\n"
                    +opponent.getHeroName() + " used " + opponent.getThirdAbilityName());
                break;
        }
        if(opponent.getHealthPoints() < 0)
        {
            opponent.setHealthPoints(0);
        }
    }
    
    private static void enemyAppears()
    {
        System.out.print("\nThe Boss Appears!");
        opponent = new Heroes("IU", "IU: Hello STU-P-I-D~", new String[]{"Charm", "Health" ,"Aegyo"}, 100, new int[]{15, 20, 25});
    }
    
    private static Boolean finalChampion(String heroName)
    {
        System.out.print("\nYou choose " + heroName + ", is it your final choice? ");
        scan = new Scanner(System.in);
        String isFinal = scan.next();
        
        if(isFinal.equalsIgnoreCase("yes"))
        {
            return true;
        }
        else if(isFinal.equalsIgnoreCase("no"))
        {
            return false;
        }
        
        return false;
    }
    
    private static boolean tryParse(String value)
    {
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    private static void printStatus()
    {
        System.out.print("\n\n"
            + "Status: \n"
            + user.getHeroName() + ": " + user.getHealthPoints() + "\n"
            + opponent.getHeroName() + ": " + opponent.getHealthPoints() + "\n");
    }
    
    private static void championAndOpponentStatus()
    {
        while(user.getHealthPoints() > 0 && opponent.getHealthPoints() > 0)
        {
            printStatus();
            System.out.print("=====================================================\n"
                   + "What will you do?\n"
                   + "1 - " + user.getFirstAbilityName() + ": " + user.getFirstAbilityDamage() + "hp\n"
                   + "2 - " + user.getSecondAbilityName() + ": " + user.getSecondAbilityDamage() + "hp\n"
                   + "3 - " + user.getThirdAbilityName() + ": " + user.getThirdAbilityDamage() + "hp\n"
                   + "4 - Run (Back to Main Menu)\n"
                   + "=====================================================\n"
                   + "Input: ");
            String input = scan.next().trim();
            if(tryParse(input))
            {
              choiceNumber = Integer.parseInt(input.trim());
                switch(choiceNumber)
                {
                   case 1:
                        userAbility(0);
                        opponentAbility();
                        break;

                   case 2:
                        userAbility(1);
                        opponentAbility();
                        break;

                   case 3:
                        userAbility(2);
                        opponentAbility();
                        break;

                   default:
                        System.out.print("\n\n"
                                + user.getHeroName() + "run!");
                        opponent.setHealthPoints(0); 
                        user.setHealthPoints(0);
                        break;
                }
            }
        }
    }
}
