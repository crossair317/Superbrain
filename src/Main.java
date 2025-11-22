import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        var Spiel = new Spiel();

        while (Spiel.dauer1 <= 30 && Spiel.dauer2 <= 30) {
            int currentUser = Spiel.retrieveCurrentUserIndex();
            Spiel.einmalSpielen(currentUser);
        }

        Spiel.gameEnd();

    }

}
