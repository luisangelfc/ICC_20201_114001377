public class HeyJude{
    public static String HEY = "Hey Jude ";
    public static String DON = "don't ";
    public static String MAK = "make it bad.";
    public static String BEA = "be afraid.";
    public static String LET = "let me down.";
    public static String TAK = "Take a sad song and make it better.";
    public static String YOW = "You were made to go out and get her.";
    public static String YOH = "You have found her, now go and get her.";
    public static String REM = "Remember to ";
    public static String LEH = "let her into you heart.";
    public static String LES = "let her into your skin.";
    public static String THE = "Then you ";
    public static String CAN = "can start ";
    public static String BEG = "begin ";
    public static String TOM = "to make it better ";
    public static String BET = "better ";
    public static String NA  = "na ";

    public static String AND = "And anytime you feel the pain, hey Jude, refrain,\n"
	                            + "Don’t carry the world upon your shoulders.\n"
                                    + "For well you know that it’s a fool who plays it cool\n"
	                            + "By making his world a little colder.";

    public static String SOL = "So let it out and let it in, hey Jude, begin,\n"
	                            + "You’re waiting for someone to perform with.\n"
	                            + "And don’t you know that it’s just you, hey jude, you’ll do,\n"
	                            + "The movement you need is on your shoulder.";

    public static void main(String[] args){
int h=1;
int xd=1;
	for(h=1; h<=5;h++){
	System.out.println("\n");
	System.out.print(HEY);
		System.out.print(DON);

		if(xd<=4){
		switch(xd){
		case 1:				
		System.out.print (MAK + "\n" + TAK);
		xd=2;
		break;
		case 2:
		System.out.print(BEA + YOW);
		xd=3;
		break;
		case 3:
		System.out.print(LET + YOH);
		xd=4;
		break;
		case 4:
		System.out.print (MAK + "\n" + TAK);
		xd =5;
		break;
		default:
		}
		}		
		 
		if( xd==2 || xd==5){
		System.out.println("\n" + REM);
		if(xd==5){
		System.out.print(LES);
		}
		if(xd==4){
		System.out.println(LEH);
		}
		while (h==1){
		System.out.println(LEH);
		h=2;
		
		}


		
		}

		System.out.print("\n" + THE);		
				
		if(h==2 || h==4 ){
		System.out.print(CAN);
		}
		if(h==3 || h==5){
		System.out.print(BEG + TOM);
		if(h==3){
		System.out.println("\n" + "\n" + AND + "\n" + "\n" );	
		}
		if(h==5){
			
			for(int i=0; i<=3; i++){
			System.out.print("\n" + BET);
			}
		        
		}		
			
			for(int i=1; i<=9; i++){
			System.out.print("\n" + NA);
			}
		}
		if(h==2 || h==4){
		System.out.print(TOM + "\n");
		if(h==4){
		System.out.println("\n" + "\n" + SOL + "\n"  );
		for(int i=1; i<=9; i++){
			System.out.print(NA + "\n");
			}
		}
		}

        }
    }   
}

	


   
	

       
       
