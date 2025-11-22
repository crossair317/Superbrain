import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        var Spiel = new Spiel();

        int currentUser = Spiel.retrieveCurrentUserIndex();

        while (Spiel.dauer1 <= 30 || Spiel.dauer2 <= 30) {

            Spiel.einmalSpielen(currentUser);

        }

        if(Spiel.dauer1 >= 1 || Spiel.dauer2 >= 30) {

            Spiel.gameEnd();

        }

    }

}

