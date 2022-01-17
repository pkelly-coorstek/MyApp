import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int pot;
        CardsDeck deck = new CardsDeck();
        int numberOfPlayers = 0;
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<CardsDeck.Card> board = new ArrayList<>();

        System.out.print("Please Enter the Number of Players:");
        numberOfPlayers = sc.nextInt();

        for (int i = 0; i < numberOfPlayers; i++) {
            int playerNumber = i+1;
            System.out.print("Please enter a name for Player " + playerNumber + ":");
            String pName = sc.next();
            System.out.print("Please enter a starting stack for Player " + playerNumber + ":");
            int pStack =sc.nextInt();
            CardsDeck.Card pCardOne = deck.pullRandom();
            CardsDeck.Card pCardTwo = deck.pullRandom();
            Player newPlayer = new Player(pName, pStack, pCardOne, pCardTwo);
            players.add(newPlayer);
            Spacer.SpaceText(4);           
        }
        
        int buttonPosition = 0;
        System.out.println(buttonPosition);
        int gameOn = 1;

        while(gameOn == 1) {
            board.clear();
            deck.reset();
            Betting.resetPlayers(players);
            pot = 0;
            pot = Betting.round(players, pot, board);
            board.add(deck.pullRandom());
            board.add(deck.pullRandom());
            board.add(deck.pullRandom());
            Spacer.SpaceText(4);
            System.out.println("Dealing the Flop:" + board);
            Spacer.SpaceText(4);
            pot = Betting.round(players, pot, board);
            board.add(deck.pullRandom());
            Spacer.SpaceText(4);            
            System.out.println("Dealing the Turn: " + board);
            Spacer.SpaceText(4);
            pot = Betting.round(players, pot, board);
            board.add(deck.pullRandom());
            Spacer.SpaceText(4);
            System.out.println("Dealing the River: " + board);
            Spacer.SpaceText(4);
            pot = Betting.round(players, pot, board);


            playerCheck(players);
            Collections.rotate(players, -1);
            

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

