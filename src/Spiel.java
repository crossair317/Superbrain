import java.util.Scanner;

public class Spiel {
    private int points1 = 0;
    private int points2 = 0;
    public int cycleCount = 0;
    public int duration1 = 0;
    public int duration2 = 0;
    private int start = 0;
    private int end = 0;

    // the game runs 1 cycle with this method being called
    void einmalSpielen(int currentUser) {

        // time begins to be tracked
        start = (int)(System.currentTimeMillis()/1000);

        // the player has entered his answer
        boolean ergebnis = playerEnteringANumber(currentUser);

        // time tracking ended, start and end are now set
        end = (int)(System.currentTimeMillis()/1000);

        // decides if the right awnser is provided
        if(ergebnis && currentUser == 1){
            points1 = points1 + 1;
            System.out.println("Spieler " + currentUser + " dein Punktestand ist "   + points1);
            duration1 = duration1 + (end - start); // The time duration the player takes is being calculated
        }
        else if(ergebnis && currentUser == 2){
            points2 = points2 + 1;
            System.out.println("Spieler " + currentUser + " dein Punktestand ist "   + points2);
            duration2 = duration2 + (end - start);
        }

        cycleCount++;

    }

    boolean playerEnteringANumber(int currentUser)
    {
        int solution = 0;
        int operatorIndex = randomOperator(); // decides a random number between 0-3
        int randomRange1 = 0;
        int randomRange2 = 0;
        char operator = 'a';

        // the range for the numbers to be generated is being decided.
        // if the operator is either + or - the range will be lower than * or /
        switch(operatorIndex){
            case 0: randomRange1 = 20; break;
            case 1: randomRange1 = 20; break;
            case 2: randomRange1 = 10; break;
            case 3: randomRange1 = 10; randomRange2 = 1; break; // avoid division by zero
        }

        // numbers used for calculations
        int number1 = randomNumber(randomRange1, randomRange1);
        int number2 = randomNumber(randomRange1, randomRange2);

        // operator is being assigned a value through operatorIndex
        switch (operatorIndex){
            case 0: solution = number1 + number2; operator = '+'; break;
            case 1: solution = number1 - number2; operator = '-'; break;
            case 2: solution = number1 * number2; operator = '*'; break;
            case 3: solution = number1 / number2; operator = '/'; break;
        }

        // game begins
        System.out.println("Spieler " + currentUser + ", Wie viel ist " + number1 + "" + operator + "" + number2 + "?");

        int antwort = inputNumber(); // player has to write the solution

        // checks if his answer matches the solution
        if(antwort == solution) {
            System.out.println("Super! Richtig gerechnet.");
            return true;
        }
        else {
            System.out.println("Leider falsch. Richtig war: " + solution);
            return false;
        }
    }

    // decides what player is playing right now by
    // checking if cyclecount is an even or uneven number
    int retrieveCurrentUserIndex(){
        return cycleCount % 2 == 0 ? 1 : 2;
    }

    // generating a random number between 2 given numbers
    int randomNumber(int n, int n2) {
        return new java.util.Random().nextInt(n) + n2;
    }

    // the method where the player has to type the solution to the calculation
    int inputNumber() {
        int i = new Scanner(System.in).nextInt();
        return i;
    }

    int randomOperator(){
        int n = new java.util.Random().nextInt(3);
        return n;
    }

    void gameEnd(){
        System.out.println("Das Spiel ist zu Ende");
        System.out.println("Spieler 1 dein Punktestand ist " + points1 + " und du hast " + duration1 + " sekunden gebraucht");
        System.out.println("Spieler 2 dein Punktestand ist " + points2 + " und du hast " + duration2 + " sekunden gebraucht");
        System.out.println("Der Sieger ist: " + Math.max(points1, points2));
    }
}
