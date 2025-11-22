class Main {
    public static void main(String[] args) {

        var Spiel = new Spiel();

        while (Spiel.duration1 <= 30 && Spiel.duration2 <= 30) {
            int currentUser = Spiel.retrieveCurrentUserIndex();
            Spiel.einmalSpielen(currentUser);
        }

        Spiel.gameEnd();

    }

}
