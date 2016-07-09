
public class Class {
	public static void main(String args[]) {
		Rummy obj = new Rummy();
		System.out.println("13 cards after shuffling are :");
		System.out.println(obj.getCards());
		System.out.println(obj.isWinningHand());
	}
}
