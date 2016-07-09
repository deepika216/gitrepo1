
public class Card {
	int seq;
	public Card(int seq) {
		this.seq = seq;
	}
	
	public char getPip() {
		return "23456789TJQKA".charAt(this.seq % 13);
	}
	
	public char getSuit() {
		return "CDHS".charAt(this.seq / 13);
	}
	
	public String toString() {
		return String.valueOf(this.seq);
	}

}
