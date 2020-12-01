package ifEx;

public class swith_case_Ex {

	public static void main(String[] args) {
		int rank = 1;
		String medal;
		switch(rank){
			case 1: medal = "Gold";
			break;
			case 2: medal = "Silver";
			break;
			case 3: medal = "Bronze";
			break;
			default: medal = "None";
			break;
			
			
		}
		System.out.println(medal);

	}

}
