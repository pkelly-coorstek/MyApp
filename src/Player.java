

public class Player {
    String name;
    boolean inHand;
    int stack;
    int inHandBet;
    CardsDeck.Card cardOne;
    CardsDeck.Card cardTwo;

    public Player(String name, int stack, CardsDeck.Card cardOne, CardsDeck.Card cardTwo) {
        this.name = name;
        this.stack = stack;
        inHandBet = 0;
        inHand = false;
        this.cardOne = cardOne;
        this.cardTwo = cardTwo;
    }

    public void makeBet(int amount) {
        if (amount > stack) {
            System.out.println("Invalid bet, insufficient chips in stack.");
        } else {
            stack = stack - amount;
            inHandBet = inHandBet + amount;
            System.out.println(name + " put in " + inHandBet + " chips. They have " + stack + " chips left in their stack.");     
        }



    }

    @Override
    public String toString() {
        return "{" +
            " name='" + this.name + "'" +
            ", inHand='" + this.inHand + "'" +
            ", stack='" + this.stack + "'" +
            ", inHandBet='" + this.inHandBet + "'" +
            ", cardOne='" + this.cardOne + "'" +
            ", cardTwo='" + this.cardTwo + "'" +
            "}";
    }


    



}


