import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Rummy {
	Player player;
	final List<Card> pack = new ArrayList<Card>() {

	{
		for (int i = 0; i < 52; ++i) {
		add(new Card(i));
		}
		add(new Card(100));
		add(new Card(100));
	}};
	
	public Rummy() {
		Collections.shuffle(pack);
		player = new Player( new ArrayList<Card>(){{
			for (int i = 0; i < 13; i++) {
				add(pack.get(i));
			}
		}});
	}
	
	public ArrayList<Card> getCards() {
		return player.cards;
	}
	
	public String isWinningHand() {
		if(!player.checkPureSequence()) {
			return "not a winning hand";
		}
		return "winning Hand";
		
	}
}
