import java.util.ArrayList;

public class Betting {

    public static int Round(ArrayList<Player> players, int pot, ArrayList<CardsDeck.Card> board) {
        ArrayList<Player> betPlayers = players;
        ArrayList<Player> activePlayers = new ArrayList<>();

        for (Player player : betPlayers) {
            if (player.inHand = true && player.stack != 0) {
                activePlayers.add(player);
            }
        }
        boolean continueHand = true;
        if (betPlayers.size() > 1) {
            int maxBet = 0;
            while (continueHand) {

                for (Player player : betPlayers) {
                    if (player.inHandBet == maxBet && maxBet != 0) {
                        System.out.println("skip");
                    } else if (player.stack > 0 && player.inHand) {

                        System.out.println(player.name + " it is your turn.");
                        actionloop: while (true) {
                            System.out.println("The board is currently " + board);
                            System.out.println("There are currently " + pot + " chips in the pot.");
                            System.out.println("You have a stack of " + player.stack + " chips, and a current bet of "
                                    + player.inHandBet + " chips for this round.");
                            System.out.println("The current max bet is " + maxBet + " chips.");
                            System.out.println(
                                    "Your current cards are the " + player.cardOne + " and " + player.cardTwo + ".");
                            System.out.println("Please choose your action: (b)et, (c)heck/call, or (f)old.");

                            String actionChoice = "";
                            actionChoice = Main.sc.next();
                            switch (actionChoice) {
                                case "f":
                                    pot = pot + player.inHandBet;
                                    player.inHandBet = 0;
                                    player.inHand = false;
                                    Spacer.SpaceText(10);
                                    System.out.println(player.name + " folds.");
                                    break actionloop;
                                case "c":
                                    if ((player.inHandBet + player.stack) < maxBet) {
                                        System.out.println("Call for less but this situation is not yet handled.");
                                        break;
                                    } else if (player.inHandBet < maxBet) {
                                        int callAmount = maxBet - player.inHandBet;
                                        System.out
                                                .println("The max bet(" + maxBet + ") is greater than your current bet("
                                                        + player.inHandBet + ") so you cannot check.");
                                        System.out.println(
                                                "Would you like to call for " + (callAmount) + " chips? (y/n)");
                                        String callReply = "";
                                        callReply = Main.sc.next();
                                        if (callReply.equals("y")) {
                                            player.makeBet(callAmount);
                                            pot = pot + callAmount;
                                            Spacer.SpaceText(10);
                                            break actionloop;
                                        } else if (callReply.equals("n")) {
                                            Spacer.SpaceText(10);
                                            System.out.println("check/call cancelled");
                                            break;
                                        } else {
                                            Spacer.SpaceText(10);
                                            System.out.println("invalid input, try again");
                                            break;
                                        }
                                    }
                                    Spacer.SpaceText(10);
                                    System.out.println(player.name + " checks.");
                                    break actionloop;
                                case "b":
                                    int betDifference = maxBet - player.inHandBet;
                                    System.out
                                            .println(player.name + ", you must bet at least " + betDifference
                                                    + " chips.");
                                    System.out.print(player.name + " choose your bet size: ");
                                    int betSize = 0;
                                    betSize = Main.sc.nextInt();
                                    if (betSize < betDifference) {
                                        Spacer.SpaceText(10);
                                        System.out.println("Invalid Bet: Bet was too small.");
                                        break;
                                    } else if (betSize > player.stack) {
                                        Spacer.SpaceText(10);
                                        System.out.println("Invalid Bet: Not enough chips in stack.");
                                        break;
                                    } else {
                                        player.makeBet(betSize);
                                        pot = pot + betSize;
                                        maxBet = player.inHandBet;
                                        Spacer.SpaceText(10);
                                        break actionloop;
                                    }
                                default:
                                    Spacer.SpaceText(10);
                                    break;
                            }
                        }
                    }
                }
                int continueHandCount = 0;
                for (Player player : activePlayers) {
                    if (player.inHand && player.inHandBet == maxBet) {
                        continueHandCount = continueHandCount + 1;
                    } else if (player.inHand == false) {
                        continueHandCount = continueHandCount + 1;
                    } else {
                    }
                }
                if (continueHandCount == activePlayers.size()) {
                    continueHand = false;
                } else {
                    continueHandCount = 0;
                }

            }

        }
        int maxBet = 0;
        while (continueHand) {

            for (Player player : betPlayers) {
                if (player.inHandBet == maxBet && maxBet != 0) {
                    System.out.println("skip");
                } else if (player.stack > 0 && player.inHand) {

                    System.out.println(player.name + " it is your turn.");
                    actionloop: while (true) {
                        System.out.println("The board is currently " + board);
                        System.out.println("There are currently " + pot + " chips in the pot.");
                        System.out.println("You have a stack of " + player.stack + " chips, and a current bet of "
                                + player.inHandBet + " chips for this round.");
                        System.out.println("The current max bet is " + maxBet + " chips.");
                        System.out.println(
                                "Your current cards are the " + player.cardOne + " and " + player.cardTwo + ".");
                        System.out.println("Please choose your action: (b)et, (c)heck/call, or (f)old.");

                        String actionChoice = "";
                        actionChoice = Main.sc.next();
                        switch (actionChoice) {
                            case "f":
                                pot = pot + player.inHandBet;
                                player.inHandBet = 0;
                                player.inHand = false;
                                Spacer.SpaceText(10);
                                System.out.println(player.name + " folds.");
                                break actionloop;
                            case "c":
                                if ((player.inHandBet + player.stack) < maxBet) {
                                    System.out.println("Call for less but this situation is not yet handled.");
                                    break;
                                } else if (player.inHandBet < maxBet) {
                                    int callAmount = maxBet - player.inHandBet;
                                    System.out.println("The max bet(" + maxBet + ") is greater than your current bet("
                                            + player.inHandBet + ") so you cannot check.");
                                    System.out.println("Would you like to call for " + (callAmount) + " chips? (y/n)");
                                    String callReply = "";
                                    callReply = Main.sc.next();
                                    if (callReply.equals("y")) {
                                        player.makeBet(callAmount);
                                        pot = pot + callAmount;
                                        Spacer.SpaceText(10);
                                        break actionloop;
                                    } else if (callReply.equals("n")) {
                                        Spacer.SpaceText(10);
                                        System.out.println("check/call cancelled");
                                        break;
                                    } else {
                                        Spacer.SpaceText(10);
                                        System.out.println("invalid input, try again");
                                        break;
                                    }
                                }
                                Spacer.SpaceText(10);
                                System.out.println(player.name + " checks.");
                                break actionloop;
                            case "b":
                                int betDifference = maxBet - player.inHandBet;
                                System.out
                                        .println(player.name + ", you must bet at least " + betDifference + " chips.");
                                System.out.print(player.name + " choose your bet size: ");
                                int betSize = 0;
                                betSize = Main.sc.nextInt();
                                if (betSize < betDifference) {
                                    Spacer.SpaceText(10);
                                    System.out.println("Invalid Bet: Bet was too small.");
                                    break;
                                } else if (betSize > player.stack) {
                                    Spacer.SpaceText(10);
                                    System.out.println("Invalid Bet: Not enough chips in stack.");
                                    break;
                                } else {
                                    player.makeBet(betSize);
                                    pot = pot + betSize;
                                    maxBet = player.inHandBet;
                                    Spacer.SpaceText(10);
                                    break actionloop;
                                }
                            default:
                                Spacer.SpaceText(10);
                                break;
                        }
                    }
                }
            }
            int continueHandCount = 0;
            for (Player player : activePlayers) {
                if (player.inHand && player.inHandBet == maxBet) {
                    continueHandCount = continueHandCount + 1;
                } else if (player.inHand == false) {
                    continueHandCount = continueHandCount + 1;
                } else {
                }
            }
            if (continueHandCount == activePlayers.size()) {
                continueHand = false;
            } else {
                continueHandCount = 0;
            }

        }
        for (Player player : activePlayers) {
            player.inHandBet = 0;
        }

        return pot;

    }
}
