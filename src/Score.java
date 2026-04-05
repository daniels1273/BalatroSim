import java.util.ArrayList;

public class Score {

    private int chips;
    private int mult;
    private ArrayList<Card> hand;
    private ArrayList<Integer> cardNums;

    public Score(ArrayList<Card> cards){
        cardNums = new ArrayList<Integer>();
        hand = sortCards(cards);
        countCards();
        System.out.println(hand);
        chips = 0;
        mult = 0;
    }

    public static int calculateHand(ArrayList<Card> cards){
        int highestScore = 0;
        return 0;
    }

    private boolean isFiveOfAKind(){
        for (int i = 0; i < hand.size() - 1; i++){
            Card curCard = hand.get(i);
            Card nextCard = hand.get(i + 1);
            if (!curCard.getRank().equals(nextCard.getRank())){
                return false;
            }
        }
        return true;
    }

    private boolean isFourOfAKind(){
        for (int num : cardNums){
            if (num >= 4){
                return true;
            }
        }
        return false;
    }

    private boolean isStraight(){
        for (int i = 0; i < hand.size() - 1; i++){
            int curRank = hand.get(i).getOrder();
            int nextRank = hand.get(i + 1).getOrder();
            if (nextRank != curRank + 1){
                return false;
            }
        }
        return true;
    }

    private boolean isFlush(){
        for (int i = 0; i < hand.size() - 1; i++){
            Card curCard = hand.get(i);
            Card nextCard = hand.get(i + 1);
            if (!curCard.getSuit().equals(nextCard.getSuit())){
                return false;
            }
        }
        return true;
    }

    private boolean isFullHouse(){
        boolean pairTrue = false;
        boolean TOKTrue = false;
        for (int num : cardNums){
            if (num == 3){
                TOKTrue = true;
            } else if (num == 2){
                pairTrue = true;
            }
        }
        return pairTrue && TOKTrue;
    }

    private boolean isTwoPair(){
        boolean hasPair = false;
        for (int num : cardNums){
            if (num >= 2 && hasPair){
                return true;
            } else if (num >= 2){
                hasPair = true;
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(){
        for (int num : cardNums){
            if (num >= 3){
                return true;
            }
        }
        return false;
    }

    private boolean isPair(){
        for (int num : cardNums){
            if (num >= 2){
                return true;
            }
        }
        return false;
    }

    private boolean isHigh(){
        return !isFiveOfAKind() && !isFourOfAKind() && !isStraight() && !isFlush() && !isFullHouse() && !isTwoPair() && !isThreeOfAKind() && !isPair();
    }

    private ArrayList<Card> sortCards(ArrayList<Card> cards){
        for (int i = 0; i < cards.size() - 1; i++){
            int lowest = i;
            Card curCard = cards.get(i);
            for (int j = i + 1; j < cards.size(); j++){
                Card nextCard = cards.get(j);
                if (curCard.getOrder() > nextCard.getOrder()){
                    lowest = j;
                    curCard = nextCard;
                }
            }
            Card temp = cards.set(i, cards.get(lowest));
            cards.set(lowest, temp);
        }
        return cards;
    }

    private void countCards(){
        for (int i = 2; i < 15; i++){
            int counter = 0;
            for (Card card : hand) {
                if (card.getOrder() == i) {
                    counter++;
                }
            }
            cardNums.add(counter);
        }
    }
}
