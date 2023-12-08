import javax.swing.*;
import java.awt.*;

public class Gui extends Main {

    public static JTextArea getLog() {
        return log;
    }

    public static void setLog(JTextArea newLog) {
        log = newLog;
    }

    static private JTextArea log;

    public JButton getAnswer() {
        return answer;
    }

    public void setAnswer(JButton answer) {
        this.answer = answer;
    }

    private JButton answer;

    public JTextField getUserInput() {
        return userInput;
    }

    public void setUserInput(JTextField userInput) {
        this.userInput = userInput;
    }

    private JTextField userInput;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    private int guesses = 0;



     static boolean gameOn;

    Gui() {
        //skapar en ny frame och ser till så den tar upp hela skärmen
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Panel för där en knapp samt textfield ska vara
        JPanel bottom = new JPanel();
        setAnswer(new JButton("Answer"));

        //userinput är textfielden, ställer samt in textfields storlek
        setUserInput(new JTextField());
        getUserInput().setColumns(10);
        //En ny label med text samt ställer in font
        JLabel text = new JLabel("Guess a number between 1 - 100!");
        text.setFont(new Font("Serif", Font.BOLD, 25));
        //skapar en ny textarea
        setLog(new JTextArea());

        //ställer in textarean's storlek och ser till så att man inte kan ändra på texten i den
        getLog().setColumns(50);
        getLog().setRows(60);
        getLog().setEditable(false);

        //ny Panel som ska sitta centern av framen
        JPanel center = new JPanel();
        center.add(new JScrollPane(getLog()), BorderLayout.CENTER);

        // ny panel som ska sitta topen av framen
        JPanel top = new JPanel();

        top.add(text);

        //lägger till knappen och textfield i panel bottom
        bottom.add(userInput);
        bottom.add(answer);
        //lägger till allt i framen
        frame.add(center, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.add(top, BorderLayout.NORTH);

        //setNumber får in ett nytt random nummer
        setNumber(Number());

        /*Actionlistener till knappen, varje gång man klickar så ökar antalet gissningar med ett.
            parsar det man skrivit till en int och skickar det till check metoden i main
            om check metoden returnar true så får man ett meddelande som berättar att man har vunnit också resettar spelet.
            använder en try catch så att om man skrivir in något ogiltigt så får spelaren reda på det i textarean
        */
        getAnswer().addActionListener(e -> {

            gameOn = true;
            try {

                for (int i = 0;gameOn;i++){
                    setGuesses(getGuesses() + 1);
                    int guess =
                            Integer.parseInt(getUserInput().getText());;
                    if (check(getNumber(), guess)) {
                        JOptionPane.showMessageDialog(null,
                                "Congratulations! You Guessed Right! It took " +
                                        getGuesses() + " guess/es to find the right number",
                                "Victory", JOptionPane.PLAIN_MESSAGE);

                        reset();

                    }
                    Gui.gameOn=false;
                }

            } catch (Exception exception) {
                getLog().append("Error something went wrong, try again!");
                System.out.println(exception.getMessage());
                gameOn=false;

            }


        });

        frame.setVisible(true);

    }
    /*Reset metoden tar fram textarean och ställer in texten till null vilket tar bort all text,
    Samt ställer in antalet gissningar till noll. Ställer in ett nyt random nummer med Number metoden.
    * */

    public void reset() {
        getLog().setText(null);
        setGuesses(0);
        setNumber(Number());
        gameOn=false;
    }


}
