import javax.swing.JDialog;
import java.util.*; 
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JTextField; 
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.activation.*; 
import javax.swing.JTextArea; 
import javax.swing.Box;
import javax.swing.JButton; 
public class project {
	public static void main(String []args) throws IOException{ 
		JTextField username = new JTextField(); JTextField password = new JPasswordField();
		Object[] authenticate = {"UserName", username, "Password", password};
		
		String[] answer = { "True" , "False"}; 
		JPanel ques = new JPanel(); 
		String[] storedQarr = new String[10]; 
		Scanner K = new Scanner(System.in);
		File F = new File("UsersInfo_004.txt");
		Scanner fs = new Scanner (F); 
		
		 
		int d=1; 
		boolean stu=false;
		int R=0; 
		int row=0; 
		int col;
		
		int score = 0; 
		String Ans=null; 
		String fileAns=null; 
		String StudentNamef=null; 
		String StudentNameL=null; 
		int info = 0; 
		double secTime; 
		boolean login = false; 
		boolean login2 = false; 
		boolean cont= true; 
		String[] ansArr = new String[10];
		String[] storedCorrectA = new String[10]; 
		String UserN; 
		String UserP;
		int count2=1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"); 
		LocalDateTime now = LocalDateTime.now(); 
		LocalDate localDate = LocalDate.now();
		do {
			int count = 1; int userInfoCount=0,answersCount=0; 
			FileReader UI = new FileReader(F); 
			LineNumberReader UIFR = new LineNumberReader(UI); 
			while(UIFR.readLine()!=null) {userInfoCount++; }
			String[][] UserInfo = new String[userInfoCount-1][6];
			count=1;d=1;score=0;  
		long startTime = System.currentTimeMillis();
		File ansFile = new File("Answers.txt"); 
		Scanner ansSc = new Scanner(ansFile); 
		FileReader AFS = new FileReader(ansFile); 
		LineNumberReader AFNR = new LineNumberReader(AFS);
		while(AFNR.readLine()!= null) { answersCount++;}
		String[] ansArrFile = new String[answersCount]; 
		
		while (ansSc.hasNext()) 
		{for(int e = 0; e <ansArrFile.length;e++) {
			ansArrFile[e] = ansSc.next(); 
		}
		}
		while (fs.hasNext()) {
		for (row = 0 ; row < UserInfo.length; row++) {//scans the file and puts all the user info into a two dimensional array "UserInfo". 
			for (col = 0 ; col < UserInfo[row].length; col++) {
				UserInfo[row][col] = fs.next(); 
			}
		}
		} 
		do {
		int OP= JOptionPane.showConfirmDialog(null,authenticate, "LOGIN", JOptionPane.OK_CANCEL_OPTION); 
		if(OP == JOptionPane.CANCEL_OPTION)System.exit(0);
		if (OP == -1) { System.exit(0);}
		if (OP == JOptionPane.OK_OPTION)
		/*System.out.print("\nPlease enter UserName and Password \nUsername: "); //a do while loop to begin 
		UserN = K.nextLine(); 
		System.out.print("Password:");
		UserP = K.nextLine();*/
		for(col = 0; col < 1; col++) {
		for (row = 1; row < 27; row++) {
			if(username.getText().equalsIgnoreCase(UserInfo[row][col])) {login=true; 
			
				}//scans the file for the user name credentials and prints login if its correct. 
		}
		}
		for(col = 1; col < 2; col ++) {
			for(row = 1; row < 27; row++) {//scans the file for the password and prints successful if the password is correct and produces "Login Successful is all is well
				if(password.getText().equalsIgnoreCase(UserInfo[row][col])) {//if login is unsuccessful it prints Login unsuccessful and the boolean stays false. 
					login2 = true; //boolean changes to true, loop exits. 
				}
				}
				
			}if((login == false)|| (login2==false)) { //boolean remains false 
				JOptionPane.showMessageDialog(null, "Login failed ");count++;
		}else{JOptionPane.showMessageDialog(null, "Login Successful"); } //counts the login attempts 
		while (count == 4) {//if the login fails 3 times, this message prints
		JOptionPane.showMessageDialog(null,"Too many failed Login Attempts.Goodbye"); System.exit(0); }
		
		}while((login == false || login2==false) && (count <= 3)); //if user input is correct the first time, the loop exits. if the user input is incorrect, they can try two more times
			File QF = new File("TestBank.txt"); //opens the file for questions
			/*FileReader QFR = new FileReader(QF); 
			LineNumberReader QFLR = new LineNumberReader(QFR); 
			while(QFLR.readLine()!=null) {testBankCount++; }*/
			Scanner QFS = new Scanner(QF); //scan the file
			String[] qArray = new String[answersCount];//places all questions in an array with 125 rows 
			while(QFS.hasNext()) {for (int i = 0; i < qArray.length;i++) {// scans the array
			qArray[i] = QFS.nextLine(); 
	}
	}
			
			for (int l = 0; l < UserInfo.length ; l++)
			for (int p = 0; p< 5;p++) 
				if(UserInfo[l][p].contains(username.getText())) 
					if(UserInfo[l][5].startsWith("St"))
						stu = true; 
			if(stu == true) {

			
Random rand = new Random(); 
for(int c=0;c<10;c++) {
int randQassign = rand.nextInt(100)+1;
//Scans the questions array and selects 10 random questions and asks the user for a true
for (int x = 0; x<1;x++) {				// or false response after every question.
/*System.out.println("\n"+ qArray[randQassign]);
System.out.println("Answer(True/False): ");
Scanner UserAns = new Scanner(System.in); 
Ans = UserAns.nextLine();
while(!(Ans.equalsIgnoreCase("true") || Ans.equalsIgnoreCase("false")|| Ans.equalsIgnoreCase("T") || Ans.equalsIgnoreCase("F")))
	{
	System.out.print("Input invalid \nplease enter an acceptable answer \n(True/False) or (T/F):");
	Ans = UserAns.nextLine();
}*/
//ques.add(new JLabel(qArray[randQassign]));
JLabel label = new JLabel(); 
label.setText(qArray[randQassign]);
storedQarr[c] = qArray[randQassign];
R = JOptionPane.showOptionDialog(null,label, "Question #" + d, 
JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,answer,null);
}
if (R == -1) { System.exit(0);}
 if(R == 0){
ansArr[c]= "TRUE"; 
storedCorrectA[c] = ansArrFile[randQassign];}
if(R == 1){
ansArr[c]= "FALSE";
storedCorrectA[c] = ansArrFile[randQassign];}
d++;}

for (int x = 0; x < UserInfo.length ; x++)
{for (int y = 0; y< 4;y++) {
	if(UserInfo[x][y].contains(username.getText())) {
		StudentNamef = UserInfo[x][2]; 
		StudentNameL = UserInfo[x][3];
}
}
}
					

	}
			if(stu == false) { 
				/*JOptionPane choice = new JOptionPane();
				JDialog box = null; 
				JPanel place = new JPanel(); 
				place.setLayout(new GridLayout(4,0));*/
				String[] select = {"1. Register a new student", " 2. Display Stats", " 3. Add new questions", "4. Email Students" }; 
				/* JButton[] buttons = new JButton[select.length];
				 for(int i = 0; i < select.length;i++) { 
					 buttons[i] = new JButton(select[i]);
					 place.add(buttons[i]);
				 }
				 
				 choice.add(place);
				 box = choice.createDialog(" Administrator"); 
				box.addInputMethodListener(null); 
				box.setVisible(true);*/
				 
			
				//Object[] AdminInput = {"New User: First Name", info, "New User: Last Name", info1,"New User: UserName", info2, "New User: Email", info3};
				int val; 
				String[][] dumbarr = new String [userInfoCount-1][6];
				val= JOptionPane.showOptionDialog(null,null, "Admin Selection", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,select,select[2] );
				if(val == 0) { instructor(); System.exit(0);}
				if(val ==1) {Selection(); System.exit(0);} 
				if (val == 2) {questions();System.exit(0);}
				if(val == 3) { mailOption(UserInfo); System.exit(0);
				if (val == -1) { System.exit(0);}
				}
			}
						long estimatedTime = System.currentTimeMillis() - startTime;
	System.out.println(estimatedTime/1000 + "Seconds");
	 secTime = estimatedTime/1000; 
	double minTime = estimatedTime/60000; 
	//String fileName = "StudentNamef +"_COSC_236_Quiz_" + "_%s" %tB %<te, %tY_",date + ".txt"
	File Final = new File(username.getText() +"_COSC_236_Quiz_" + dtf.format(now)+ ".txt");
	PrintWriter OF = new PrintWriter(Final);
	for(int a = 0; a<10 ; a++) {
		if(storedCorrectA[a].equals(ansArr[a]) || (storedCorrectA[a].charAt(0) == ansArr[a].charAt(0))) {
			score++;
		}
		}OF.println("First Name: "+ StudentNamef); OF.println("Last Name: " + StudentNameL);
		OF.println("Score: " + score+"/10");
					OF.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - - - "); 
					OF.println("Your Answers | Correct Answers | Questions");
			for(int i = 0; i <10; i++){ 
				  OF.println( ansArr[i] + "\t " + storedCorrectA[i] + " \t" + qArray[i] ); }
			File otherF = new File("StudentStats.txt"); 
			FileWriter otherFW = new FileWriter(otherF,true);
			PrintWriter otherPW = new PrintWriter(otherFW);
			otherPW.println(StudentNamef + "\t" + StudentNameL + "\t" + secTime + "\t" + score);
		/*OF.println("Elapsed Time:" + secTime+" seconds");
		OF.println("Your Answers:");
		for (String val: ansArr) { OF.print(val + " ");}
		OF.println("\n Correct Answers:");
		for(String val:storedCorrectA){OF.print(val + " "); }*/
		OF.close();
		ansSc.close();
		otherPW.close();
		AFNR.close();
	int str = JOptionPane.showConfirmDialog(null,"Are You done?",null, JOptionPane.YES_NO_OPTION); 	
	//System.out.println("\nPlease enter UserName:"); //a do while loop to begin 
	System.out.print(str);
	//UserN = K.nextLine(); 
	if(str == JOptionPane.YES_OPTION)  
		cont = false;
	if(str == JOptionPane.NO_OPTION)
		cont = true; 
		}while(cont == true);

		System.out.println("First Name: "+ StudentNamef); System.out.println("Last Name: " + StudentNameL);
		System.out.println("Score: " + score+"/10");
		System.out.println("Elapsed Time:" + secTime +" seconds");
		System.out.println("Your Answers | Correct Answers | Questions");
		for(int i = 0; i <10; i++){ 
			  System.out.println( ansArr[i] + "\t " + storedCorrectA[i] + " \t" + storedQarr[i] ); }
		
		}
	public static void instructor() throws IOException {
		JTextField info=new JTextField();
		JTextField info1 = new JTextField(); 
		JTextField info2 = new JTextField(); 
		JTextField info3 = new JTextField(); 
		//	string examples = "";
		// char[] array = examples.toCharAr
		String[] pass = {" "," "," ", " "," "," "}; 
		String newPass;
		Random rand = new Random(); 
		//String password = "     "; 
		int pos;
		String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","S","T","U","V","X","Y","Z"};
		
		for(int i = 0; i< 6 ; i++) {
			pos = rand.nextInt(20) + 1 ; 
			pass[i] = letters[pos];   
			
			}StringBuilder builder = new StringBuilder();
			for(String s : pass) {
			    builder.append(s);
			}
			newPass = String.join("", pass);
			
			 
			Object[] AdminInput = {"New User: First Name", info, "New User: Last Name", info1,"New User: UserName", info2, "New User: Email", info3};
					int OP = JOptionPane.showConfirmDialog(null, AdminInput, "Option #1",JOptionPane.OK_CANCEL_OPTION );
		FileWriter FW = new FileWriter("UsersInfo_004.txt", true);
				PrintWriter OF = new PrintWriter(FW);
				/*for(int i = 0; i<5; i++) {
					password.charAt[i].equals(pass[i]);
				}*/
				OF.println(info2.getText() + "\t"  + newPass + "\t"+info.getText() + "\t" + info1.getText() + "\t"  + info3.getText()+ "\t Student"); OF.close();
			
	//	if (val ==1) {
			//String E=" ",D=" "; double B=0; int e=0;
			//Selection(D, D, B, e); 
		//}
		
			} 
	public static void Selection() throws IOException {int count=0;
	double p;
	double sum = 0;
	double small = Double.MAX_VALUE; 
	double smallTime = Double.MAX_VALUE; 
	double classAvg; 
	double highVal=0;
	File FA = new File("StudentStats.txt"); 
	FileReader fr = new FileReader(FA); 
	LineNumberReader lineread = new LineNumberReader(fr); 
	String str;
	
	String[][] InfoArr;
	//Ammend.println(StudentNamef + "\t" + StudentNameL + "\t" + secTime + "\t" + score);
	
	Scanner Af = new Scanner(FA); while(lineread.readLine() !=null) {
		count++;//System.out.println(count);
		}
	lineread.close();
	InfoArr = new String[count-1][4];
	double[][] numArr = new double[count-2][2]; 
	while(Af.hasNext()) {
		for(int i = 0; i<InfoArr.length; i++) {
			for(int y=0;y<InfoArr[i].length;y++) {
			InfoArr[i][y] = Af.next();			
		}}
	}
	for(int i=1;i<InfoArr.length;i++)
	{for(int y =2;y<InfoArr[i].length; y++) {
		p = Double.parseDouble(InfoArr[i][y]); 
		numArr[i-1][y-2] = p;
	}
	
	}
	for(int i=0;i<numArr.length;i++)
	{for(int y =0;y<1; y++) {
	if(numArr[i][y]<smallTime) { smallTime = numArr[i][y];}
	}}
	for(int i=0;i<numArr.length;i++)
	{for(int y =1;y<numArr[i].length; y++) {
	//System.out.println(numArr[i][y]);
	sum += numArr[i][y]; 
	 
	if(numArr[i][y] > highVal) { highVal = numArr[i][y] ;}
	if(numArr[i][y]<small) { small = numArr[i][y];}
	}}classAvg = sum/(count-1);
	//System.out.println(str + count);}
	
	//String infoArr[] = str.split(" ");
	
	/*for(int o=1;o < InfoArr.length;o++){
		for(int q =2;q<InfoArr[0].length;q++){
			p =Integer.parseInt(InfoArr[1][2]);
		System.out.println(p);}
	}*/

	
		
	
	
			/*if(i>0 && y>1) {
			 p = Integer.parseInt(InfoArr[i][y]); 
			System.out.print(p);
			}
			} }}for(int i= 0;i<InfoArr.length ; i++) {
				for(int y=0;y<InfoArr[i].length; y++) { System.out.print(InfoArr[i][y]); }*/
			//Ammend.close();
			Af.close();
	/*for(int i=0;i < infoNumArr.length ;i++)
		for(int y=0;y < 3;y++) {
			System.out.print(count);
			//int p = Integer.parseInt(InfoArr[i][2]);
			if(infoNumArr[i][y] > highVal) { highVal = infoNumArr[i][y] ;}*/
		//}
JOptionPane.showMessageDialog(null,new Object[] { "The Highest Score is: " +highVal,
		"The class average is: " +classAvg,
		"The lowest score is: " +small+ "/10", 
		"The shortest duration is: " + smallTime + " seconds"});
	}

	public static void questions() throws IOException{
		
		String newQues;String newAns;
		FileWriter OF = new FileWriter("TestBank.txt",true);
		FileWriter FW = new FileWriter("Answers.txt", true); 
		PrintWriter PW = new PrintWriter(OF); 
		PrintWriter PW2 = new PrintWriter(FW); 
		
		String choice = JOptionPane.showInputDialog("How many questions would you like to enter?(NUMERIC VALUES):");
		int qNum = Integer.parseInt(choice);
		if (qNum==1){
		
		 newQues = JOptionPane.showInputDialog("Please enter your question"); 
		newAns= JOptionPane.showInputDialog("Answer(TRUE/FALSE):");
		PW.println(newQues);
		PW2.println(newAns);
		}
		if(qNum > 1) { 
			
			int count2=1;
			File F = new File("Instructor_Test_Bank.txt");
			File otherF = new File("Instructor_Answers.txt"); 
			PrintWriter otherOF = new PrintWriter(F);
			PrintWriter anotherOF = new PrintWriter(otherF); 
			while(count2 <= qNum) { 
			newQues = JOptionPane.showInputDialog("Question #" + count2);
			newAns = JOptionPane.showInputDialog("Answer #"+count2); 
				count2++;
				PW.println(newQues);
				PW2.println(newAns);
			}
		/*Scanner otherK = new Scanner(otherF); 
		Scanner K =new Scanner(F);
		while (K.hasNextLine()){
		PW.println(K.nextLine()); 
		}
		while (otherK.hasNextLine()) {PW2.print(otherK.nextLine()); } */
		otherOF.close();anotherOF.close();
		}
		PW.close();
		PW2.close();
		 
	}
	public static void mailOption(String UserInfo[][])throws IOException{ 
		Object[] student = {"ONE", "ALL"};
		int select = JOptionPane.showOptionDialog(null,"Would you like to send a Message to a few Students or All?", "Please choose 1",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null,student,null);
		if(select == 0) {
		//open a Joption page for Email login, 
		JTextField MailName = new JTextField(); 
		JTextField MailPass= new JPasswordField();
		//JTextField input = new JTextField(); 
		JTextArea mess = new JTextArea(10,30); 
		JTextField sub = new JTextField(); 
		//JScrollPane s = new JScrollPane(mess); 
		JTextField to = new JTextField(); 
		String[] choose = {"send", "cancel"}; 
		Object[] authenticate = {"Email", MailName, "Password", MailPass};
		Object[] message = {"To", to,"Subject",sub,"Message",mess }; 
		JOptionPane.showConfirmDialog(null, authenticate, "Login", JOptionPane.OK_CANCEL_OPTION);
		JOptionPane.showOptionDialog(null, message, "Email",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,choose,null);  
		//open three different textfields for sender info, subject and info 
		//declare necessary variables and get user inputs, 
		try { 
			String host = "smtp.gmail.com"; 
			String user = MailName.getText();
			String pass = MailPass.getText(); 
			String recipient = to.getText(); 
			String subject =  sub.getText(); 
			String From= MailName.getText();
			String input = mess.getText(); 
			boolean sessionDebug = false; 
			Properties stuff = System.getProperties(); 
			
			stuff.put("mail.smtp.starttls.enable", "true"); 
			stuff.put("mail.smtp.host", host); 
			stuff.put("mail.smtp.port", "587");
			stuff.put("mail.smtp.auth", "true");
			stuff.put("mail.smtp.starttls.required", "true");
			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider()); 
			Session mailSession = Session.getDefaultInstance(stuff,null); 
			mailSession.setDebug(sessionDebug); 
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(From));
			InternetAddress[] address = {new InternetAddress(recipient)};
			msg.setRecipients(Message.RecipientType.TO, address); 
			msg.setSubject(subject); msg.setSentDate(new Date());
			msg.setText(input);
			
			Transport transport = mailSession.getTransport("smtp"); 
			transport.connect(host,user,pass); 
			transport.sendMessage(msg,msg.getAllRecipients()); 
			transport.close();
			JOptionPane.showConfirmDialog(null, "message sent successfully"); 
			
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "nope"); 
		}
		}
		System.out.print(select);
		if (select == 1) {
			/*int count=0;
				String [] dummystuff= new String[4];
			 File F = new File("dummyemails.txt"); 
			 Scanner K= new Scanner(F); 
			 
			while (K.hasNextLine()) {
				for(int i=0;i<4;i++) {dummystuff[i] = K.nextLine(); }}
			 for(String val:dummystuff) {System.out.print(val); }
			 K.close();*/
			 try {
				String host = "smtp.gmail.com";
				JTextArea mess=new JTextArea(10,30); 
				JTextField sub = new JTextField();
				JTextField from = new JTextField(); 
				JTextField pass = new JPasswordField();
				String[] choose = {"send", "cancel"}; 
				Object[] authenticate = {"Email", from, "Password", pass};
				Object[] message = {"Subject",sub,"Message",mess}; 
				JOptionPane.showConfirmDialog(null, authenticate, "Login", JOptionPane.OK_CANCEL_OPTION);
				JOptionPane.showConfirmDialog(null, message, "Email",JOptionPane.OK_CANCEL_OPTION);  
				for(int i =1; i < 5; i++) {
				String recipient = UserInfo[i][5]; 
			boolean sessionDebug = false; 
			Properties stuff = System.getProperties(); 
			
			stuff.put("mail.smtp.starttls.enable", "true"); 
			stuff.put("mail.smtp.host", host); 
			stuff.put("mail.smtp.port", "587");
			stuff.put("mail.smtp.auth", "true");
			stuff.put("mail.smtp.starttls.required", "true");
			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider()); 
			Session mailSession = Session.getDefaultInstance(stuff,null); 
			mailSession.setDebug(sessionDebug); 
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from.getText()));
			InternetAddress[] address = {new InternetAddress(UserInfo[i][5])};
			msg.setRecipients(Message.RecipientType.TO, address); 
			msg.setSubject(sub.getText()); msg.setSentDate(new Date());
			msg.setText(mess.getText());
			
			Transport transport = mailSession.getTransport("smtp"); 
			transport.connect(host,from.getText(),pass.getText()); 
			transport.sendMessage(msg,msg.getAllRecipients()); 
			transport.close();}
			JOptionPane.showMessageDialog(null, "message sent successfully",null,JOptionPane.INFORMATION_MESSAGE);
			
		}catch
			(Exception ex)
		{
			//JOptionPane.showConfirmDialog(null, "nope"); 
			//System.out.println(count);
		}
		}
		
			/*int count=0; 
			int row=0,col=0;
			File F= new File("UsersInfo_004.txt");
			FileReader f = new FileReader(F); 
			LineNumberReader ln = new LineNumberReader(f);
			
			Scanner fs = new Scanner(F); 
			while (ln.readLine()!=null) {
				count++; 
					}	
			System.out.println(count);
			String[][] UserInfo = new String[count-2][6]; 
			while (fs.hasNext()) {
			for(int i = 0; i<UserInfo.length; i++) {
				for(int y=0; y<UserInfo[i].length;y++) { 
					UserInfo[i][y] = fs.nextLine();
					
				}
			}
			for(int i = 0; i<UserInfo.length; i++) {
				for(int y=0; y<UserInfo[i].length;y++)
					System.out.print(UserInfo[i][y]);}
			fs.close();}*/
		
		

				
			
			}
		// send email 
	}
 
	

	

		


