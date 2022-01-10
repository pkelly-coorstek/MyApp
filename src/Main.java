import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int pot;
        CardsDeck Deck = new CardsDeck();
        int numberOfPlayers = 0;
        ArrayList<Player> Players = new ArrayList<>();
        ArrayList<CardsDeck.Card> Board = new ArrayList<>();

        System.out.print("Please Enter the Number of Players:");
        numberOfPlayers = sc.nextInt();

        for (int i = 0; i < numberOfPlayers; i++) {
            int playerNumber = i+1;
            System.out.print("Please enter a name for Player " + playerNumber + ":");
            String pName = sc.next();
            System.out.print("Please enter a starting stack for Player " + playerNumber + ":");
            int pStack =sc.nextInt();
            CardsDeck.Card pCardOne = Deck.pullRandom();
            CardsDeck.Card pCardTwo = Deck.pullRandom();
            Player newPlayer = new Player(pName, pStack, pCardOne, pCardTwo);
            Players.add(newPlayer);
            Spacer.SpaceText(4);           
        }
        
        int buttonPosition = 0;
        System.out.println(buttonPosition);
        int gameOn = 1;

        while(gameOn == 1) {
            Board.clear();
            Deck.reset();
            pot = 0;
            pot = Betting.Round(Players, pot, Board);
            Board.add(Deck.pullRandom());
            Board.add(Deck.pullRandom());
            Board.add(Deck.pullRandom());
            Spacer.SpaceText(4);
            System.out.println("Dealing the Flop");
            Spacer.SpaceText(4);
            pot = Betting.Round(Players, pot, Board);
            Board.add(Deck.pullRandom());
            Spacer.SpaceText(4);            
            System.out.println("Dealing the Turn");
            Spacer.SpaceText(4);
            pot = Betting.Round(Players, pot, Board);
            Board.add(Deck.pullRandom());
            Spacer.SpaceText(4);
            System.out.println("Dealing the River");
            Spacer.SpaceText(4);
            pot = Betting.Round(Players, pot, Board);


            playerCheck(Players);
            Collections.rotate(Players, -1);
            

            System.out.print("Continue game? (1):");
            gameOn = sc.nextInt();


        }
        sc.close();
    }
    
    public static void playerCheck(ArrayList<Player> playerInput) {
        ArrayList<Player> deletePlayer = new ArrayList<>();
        for (Player checkPlayer : playerInput) {
            if (checkPlayer.stack <= 0) {
                deletePlayer.add(checkPlayer);
            }
        }
        playerInput.removeAll(deletePlayer);

    }
    

}

