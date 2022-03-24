import java.util.HashMap;
import java.util.Map;

public class Blackjack {
    Map<String, Integer> nipeCardsValeuMap = new HashMap<>();

    public Blackjack() {
        nipeCardsValeuMap.put("ace", 11);
        nipeCardsValeuMap.put("two", 2);
        nipeCardsValeuMap.put("three", 3);
        nipeCardsValeuMap.put("four", 4);
        nipeCardsValeuMap.put("five", 5);
        nipeCardsValeuMap.put("six", 6);
        nipeCardsValeuMap.put("seven", 7);
        nipeCardsValeuMap.put("eight", 8);
        nipeCardsValeuMap.put("nine", 9);
        nipeCardsValeuMap.put("ten", 10);
        nipeCardsValeuMap.put("jack", 10);
        nipeCardsValeuMap.put("queen", 10);
        nipeCardsValeuMap.put("king", 10);
        nipeCardsValeuMap.put("other", 0);
    }

    public int parseCard(String card) { return nipeCardsValeuMap.get(card); }

    public boolean isBlackjack(String card1, String card2) { return parseCard(card1) + parseCard(card2) == 21 ? true : false; }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        boolean returnW = isBlackjack && dealerScore != parseCard("ace") && dealerScore != parseCard("ten");
        boolean returnS = isBlackjack && dealerScore == parseCard("ace") || dealerScore == parseCard("ten");
        return returnW ? "W" : returnS ? "S" : "P";
    }

    public String smallHand(int handScore, int dealerScore) {
        boolean returnS = handScore > 11 && handScore < 17 && dealerScore < 7;
        return handScore > 16 ? "S" : returnS ? "S" : "H";
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
