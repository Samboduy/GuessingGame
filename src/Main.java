import java.util.Random;
import java.util.Scanner;

public class Main {

    public static boolean getFact() {
        return fact;
    }

    public static void setFact(boolean newFact) {
        fact=newFact;
    }

    private static boolean fact;


       int Number(){
        Random random = new Random();
        return(random.nextInt(100));                   //Skapar en slumpad siffra från 0 - 100 och returnerar den när man kallar på metoden.
    }
      boolean check(int random, int guess){
           setFact(false);

        if(random==guess)
            setFact(true);
        else if (random>guess) {
            Gui.getLog().append("Too low, guess again!\n");
        }                                                       //Jämför värdet av gissningen med nummert vi har genererat och beroende på om det är större mindre eller samma ändra vi vad som returneras.

        else
            Gui.getLog().append("too high, guess again!\n");
        return(getFact());
    }

    public static void main(String[] args) {
        new Gui();
        }
    }
