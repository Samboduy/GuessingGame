import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int Number(){
        Random random = new Random();
        return(random.nextInt(100));                   //Skapar en slumpad siffra från 0 - 100 och returnerar den när man kallar på metoden.
    }
    private static int check(int random, int guess){
        int x=0;
        if(random==guess)
            x =3;
        if(random>guess)                //Jämför värdet av gissningen med nummert vi har genererat och beroende på om det är större mindre eller samma ändra vi vad som returneras.
            x=2;
        if(guess>random)
            x=1;
        return(x);
    }

    public static void main(String[] args) {
        boolean onOff =true;
        while(onOff) {
            Scanner scanner = new Scanner(System.in);
            boolean button = true;
            int number = Number();                   //Hämtar ett slumpat nummer från Number metoden.
            int guesses = 0;
            System.out.println("Gissa på ett nummer mellan 1 - 100!");

            while (button) {
                guesses++;
                int gissning = scanner.nextInt();
                
                if (check(number, gissning) == 3) {             //Ifall dom två värdena är samma så bryts lopen och man får möjlighet att börja om med ett nytt nummer.
                    System.out.println("Grattis du gissade rätt!!");
                    System.out.println("Det tog " + guesses + " för att hitta rätt nummer.");
                    button = false;
                }
                else if (check(number, gissning) == 1)
                    System.out.println("För höght gissa igen!");
                else if (check(number, gissning) == 2)
                    System.out.println("För lågt gissa igen!");
            }
            System.out.println("Vill du spela igen Ja/Nej ?");
            String val = scanner.next();                //Tar ett input och kollat ifall användaren vill fortsätta spela.
            if(val.equalsIgnoreCase("Nej"))
                onOff=false;
        }
    }
}