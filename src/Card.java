public class Card {

    private String suit;
    private String rank;
    private int rankNum;
    private int order;
    private boolean isFace;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
        try {
            rankNum = Integer.parseInt(rank);
            order = rankNum;
            isFace = false;
        } catch (NumberFormatException e) {
            if (rank.equals("Ace")){
                isFace = false;
                order = 14;
                rankNum = 11;
            } else {
                rankNum = 10;
                isFace = true;
                if (rank.equals("King")){
                    order = 13;
                } else if (rank.equals("Queen")){
                    order = 12;
                } else if (rank.equals("Jack")){
                    order = 11;
                }
            }
        }
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getRankNum() {
        return rankNum;
    }

    public boolean isFace() {
        return isFace;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString(){
        return rank + " of " + suit;
    }
}
