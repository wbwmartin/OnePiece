package tripAdvisor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCalendar {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime( dateFormat.parse( "2015-10-20" ) );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add( Calendar.DATE, 1 );
		cal.add( Calendar.DATE, 1 );
		System.out.println(cal.getTime());
	}
}
