import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player {
	
	 ArrayList<Card> cards = new ArrayList<Card>();
	
	public Player(ArrayList<Card> cards) {
		this.cards.addAll(cards);
	}
	
	public  boolean checkPureSequence() {
		Collections.sort(cards, new Comparator<Card>() {
			   public int compare(Card c1, Card c2) {
			      if (c1.seq > c2.seq) {
			    	  return 1;
			      } else if (c1.seq < c2.seq) {
			    	  return -1;
			      }
			      return 0;
			   }
			});
		
		boolean AceClub = false;
		boolean AceDiamond = false;
		boolean AceHeart = false;
		boolean AceSpade = false;
		for (Card crd :cards) {
			if (crd.seq == 12)
				AceClub = true;
			if (crd.seq == 25)
				AceDiamond = true;
			if (crd.seq == 38)
				AceHeart = true;
			if (crd.seq == 51)
				AceSpade = true;
		}
		
		
		for(int i = 2; i < cards.size(); ++i) {
			
			if ((cards.get(i).seq - cards.get(i - 2).seq == 2) && ((cards.get(i).getSuit() == cards.get(i - 2).getSuit()) ))   {
					return true;
				}
				if(cards.get(i - 1).seq == 0 && cards.get(i).seq == 1 && AceClub) {
					return true;
				}
				if(cards.get(i - 1).seq == 13 && cards.get(i).seq == 14 && AceDiamond) {
					return true;
				}
				if(cards.get(i - 1).seq == 26  && cards.get(i).seq == 27 && AceHeart) {
					return true;
				}
				if(cards.get(i - 1).seq == 39 && cards.get(i).seq == 40 && AceSpade) {
					return true;
				}
		}
		return false;
	}
}
