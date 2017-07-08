
public class javaPractice {

	public static void main(String[] args) {
		String mySt1="this is java code";
		String mySt2="this is java code";
		String myst3="this is diffrent than st1 and st2";
		
		if(mySt1.equals(mySt2))
		{
			System.out.println("St1 and St2 are equal and length of ST1 is=" + mySt1.length()
			+" and character at index number 17 is "+mySt1.charAt(16));
		}else {
			System.out.println("St1 and St2 are not equal");
		}
		
		if(mySt1.equals(myst3))
		{
			System.out.println("St1 and St3 are equal");
		}else {
			System.out.println("St1 and St3 are not equal");
		}
		
		String mySt[]=new String[3];
		for(int i=0;i<mySt.length;i++){
			mySt[i]="this is array string "+(i+1);
		}
		for(int i=0;i<mySt.length;i++){
			System.out.println(mySt[i]);
		}
	

	}

}
