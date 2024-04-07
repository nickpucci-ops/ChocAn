package project4;

public class Card {
    private String memberName;
    private int memberNumber;

    public Card(String memberName, int memberNumber) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

}