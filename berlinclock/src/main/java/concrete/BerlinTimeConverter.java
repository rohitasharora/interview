package concrete;

import interfaces.TimeConverter;

public class BerlinTimeConverter implements TimeConverter {

	private static final String YELLOW = "Y";
	private static final String RED = "R";
	private static final String ORANGE = "O";

	@Override
	public String convertTime(String aTime) {
		return processBerlinTime(inputTimeValidator(aTime));
	}

	private String processBerlinTime(String[] list){
		if(list!=null && list.length == 3){
			StringBuilder s = new StringBuilder();
			Integer hrs= Integer.parseInt(list[0]);
			Integer mins= Integer.parseInt(list[1]);
			Integer secs= Integer.parseInt(list[2]);

			//top lamp
			if(secs%2==0){
				s.append(YELLOW);
			}
			else{
				s.append(ORANGE);
			}
			s.append('\n');
			

			//top hours
			for(int i = 1; i<=(hrs/5) ; i++){
				s.append(RED);
			}
			for(int i = 1; i<=4-(hrs/5) ; i++){
				s.append(ORANGE);
			}
			s.append('\n');


			//bottom hours
			int botHrs = hrs%5;
			for(int i = 1; i<=botHrs ; i++){
				s.append(RED);
			}
			for(int i = 1; i<=4-botHrs ; i++){
				s.append(ORANGE);
			}
			s.append('\n');



			//top minutes
			for(int i = 1; i<=(mins/5) ; i++){
				if(i%3 == 0)
					s.append(RED);
				else
					s.append(YELLOW);
			}
			for(int i = 0; i<11-(mins/5) ; i++){
				s.append(ORANGE);
			}
			s.append('\n');

			//bottom minutes
			int botMins = mins%5;
			for(int i = 1; i<=botMins ; i++){
				s.append(YELLOW);
			}
			for(int i = 1; i<=4-botMins ; i++){
				s.append(ORANGE);
			}
			return s.toString();
		}
		return null;
	}

	private String[] inputTimeValidator(String aTime){
		if(aTime != null && !aTime.isEmpty()){
			String[] list = aTime.split(":");
			if(list!=null && list.length == 3){
				validateHrs(list[0]);
				validateMinsOrSecs(list[1], true);
				validateMinsOrSecs(list[2], false);
			}else{
				throw new IllegalArgumentException("Input invalid");
			}
			return list;
		}else{
			throw new IllegalArgumentException("Input null/empty");
		}
	}

	private void validateHrs(String hrs){
		if(hrs!=null){
			Integer temp = Integer.parseInt(hrs);
			if(!(temp>=0 && temp <=24)){
				throw new IllegalArgumentException("Input hours invalid");
			}
			//else{System.out.println(temp);}
		}
	}
	private void validateMinsOrSecs(String minsOrSecs, boolean min){
		if(minsOrSecs!=null){
			Integer temp = Integer.parseInt(minsOrSecs);
			if(!(temp>=0 && temp <=60)){
				if(min)
					throw new IllegalArgumentException("Input minutes invalid");
				else
					throw new IllegalArgumentException("Input seconds invalid");
			}
			//else{System.out.println(temp);}
		}
	}

}
