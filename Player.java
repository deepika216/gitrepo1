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
		
		/*ArrayList<Card> clubcards = new ArrayList<Card>() {{
			for (Card crd :cards) {
				if (crd.seq < 13) {
					add(new Card(crd.seq));
				}
				if(crd.seq == 12) {
					add(0,new Card(-1));
				}
			}
		}};
		
		ArrayList<Card> diamondcards = new ArrayList<Card>() {{
			for (Card crd :cards) {
				if (crd.seq > 12 && crd.seq < 26) {
					add(new Card(crd.seq));
				}
				if(crd.seq == 25) {
					add(0,new Card(12));
				}
			}
		}};
		
		ArrayList<Card> heartcards = new ArrayList<Card>() {{
			for (Card crd :cards) {
				if (crd.seq > 25 && crd.seq < 39) {
					add(new Card(crd.seq));
				}
				if(crd.seq == 38) {
					add(0,new Card(25));
				}
			}
		}};
		
		ArrayList<Card> spadecards = new ArrayList<Card>() {{
			for (Card crd :cards) {
				if (crd.seq > 38 && crd.seq < 52) {
					add(new Card(crd.seq));
				}
				if(crd.seq == 51) {
					add(0,new Card(38));
				}
			}
		}};*/
		
		
		
		for(int i = 1; i < cards.size(); ++i) {
			
			if ((cards.get(i).seq - cards.get(i - 1).seq == 1) && ((cards.get(i).seq <= 12 && cards.get(i - 1).seq >= 0) || (cards.get(i).seq <= 25 && cards.get(i - 1).seq >= 13) || (cards.get(i).seq <= 38 && cards.get(i - 1).seq >= 26) || (cards.get(i).seq <= 51 && cards.get(i - 1).seq >= 39))) {
				if ((cards.get(i + 1).seq - cards.get(i).seq == 1) && ((cards.get(i + 1).seq <= 12 && cards.get(i).seq >= 0) || (cards.get(i + 1).seq <= 25 && cards.get(i).seq >= 13) || (cards.get(i + 1).seq <= 38 && cards.get(i).seq >= 26) || (cards.get(i + 1).seq <= 51 && cards.get(i).seq >= 39)))  {
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
		}
		return false;
	}
}
