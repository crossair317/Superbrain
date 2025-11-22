import java.util.Scanner;

public class Spiel
{
    private int punktestand1 = 0;
    private int punktestand2 = 2;
    public int cycleCount = 0;
    public int dauer1 = 0;
    public int dauer2 = 0;
    private int start = 0;
    private int end = 0;
    private int currentUser = 67;
    private Thread t = new Thread() {}

    Spiel()
    {
        currentUser = retrieveCurrentUserIndex();
    }

    while(true){

    switch(currentUser){

        case 1: dauer1 = dauer1 + (end - start); t.sleep(100);break;
        case 2: dauer2 = dauer2 + (end - start); t.sleep(100);break;
        default: t.sleep(100); break;

    }

}


    void einmalSpielen(int currentUser){



        start = (int)(System.currentTimeMillis()/1000);

        boolean ergebnis = rateEinmal(currentUser);

        end = (int)(System.currentTimeMillis()/1000);

        if(ergebnis && currentUser == 1){

            punktestand1 = punktestand1 + 1;

            System.out.println("Spieler " + currentUser + " dein Punktestand ist "   + punktestand1);

            dauer1 = dauer1 + (end - start);

        }

        else if(ergebnis && currentUser == 2){

            punktestand2 = punktestand2 + 1;

            System.out.println("Spieler " + currentUser + " dein Punktestand ist "   + punktestand1);

            dauer2 = dauer2 + (end - start);

        }

        cycleCount++;

    }

    boolean rateEinmal(int currentUser)
    {
        int loesung = 0;
        int operatorIndex = zufallsOperator();
        int randomRange = 0;

        switch(operatorIndex){

            case 0: randomRange = 20; break;
            case 1: randomRange = 20; break;
            case 2: randomRange = 10; break;
            case 3: randomRange = 10; break;

        }

        int zahl1 = zufallszahl(randomRange);
        int zahl2 = zufallszahl(randomRange);

        char operator = 'a';

        switch (operatorIndex){

        case 0: loesung = zahl1 + zahl2; operator = '+'; break;
        case 1: loesung = zahl1 - zahl2; operator = '-'; break;
        case 2: loesung = zahl1 * zahl2; operator = '*'; break;
        case 3: loesung = zahl1 / zahl2; operator = '/'; break;

    }

        System.out.println("Spieler " + currentUser + ", Wie viel ist " + zahl1 + "" + operator + "" + zahl2 + "?");

        int antwort = leseZahl();

        if(antwort == loesung) {

            System.out.println("Super! Richtig gerechnet.");

            return true;

        }

        else {

            System.out.println("Leider falsch. Richtig war: " + loesung);

            return false;

        }

    }

    int retrieveCurrentUserIndex(){

        if(cycleCount == 0 || cycleCount % 2 == 0){

            return 1;

        }
        else if(cycleCount % 2 == 1){

            return 2;

        }

        else

            return 0;

    }

    int zufallszahl(int n)
    {
        return new java.util.Random().nextInt(n);
    }

    int leseZahl()
    {
        int i = new Scanner(System.in).nextInt();
        return i;
    }

    int zufallsOperator(){

        int n = new java.util.Random().nextInt(3);

        return n;

    }

    void gameEnd(){

        System.out.println("Das Spiel ist zu Ende");

        System.out.println("Spieler 1 dein Punktestand ist " + punktestand1 + " und du hast " + dauer1 + " sekunden gebraucht");
        System.out.println("Spieler 2 dein Punktestand ist " + punktestand2  + " und du hast " + dauer2 + " sekunden gebraucht");

        System.out.println("Der Sieger ist: " + Math.max(punktestand1, punktestand2));

    }


}


