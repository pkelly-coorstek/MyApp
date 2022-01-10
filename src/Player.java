

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
        int activeStack = stack;
        int activeBet = inHandBet;
        String activeName = name;
        if (amount > activeStack) {
            System.out.println("Invalid bet, insufficient chips in stack.");
        } else {
            activeStack = activeStack - amount;
            activeBet = activeBet + amount;
            System.out.println(activeName + " put in " + activeBet + " chips. They have " + activeStack + " chips left in their stack.");
            inHandBet = activeBet;            
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


