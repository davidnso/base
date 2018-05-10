package application;
	
import java.awt.Font;
import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Stage window; 
	Scene scene1,scene2,scene3;
	public void start(Stage primaryStage) throws IOException {
		boolean login=false;
		try {
			FlowPane root = new FlowPane();
			//Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene);
			window = primaryStage; 
			
				
			TextField username = new TextField(); 
			TextField password = new PasswordField(); 
			Button L = new Button("Login"); 
			GridPane grid= new GridPane(); 
			grid.setPadding(new Insets(10,10,10,10));
			grid.setHgap(5); 
			grid.setVgap(10);
			Label user = new Label("Username: "); Label pass= new Label("Password"); 
			Label label = new Label("Hello, Please Login");
			
			GridPane.setConstraints(label, 0, 0);
			GridPane.setConstraints(user,0,1);GridPane.setConstraints(username, 1,1);
			GridPane.setConstraints(pass, 0, 2);GridPane.setConstraints(password, 1,2);
			GridPane.setConstraints(L,1,3);
			//label.setFont(Font.BOLD);
			//HBox layout1 = new HBox(user,username);
			//HBox layout2= new HBox(pass, password); 
			//layout2.setSpacing(10.0);layout2.setPadding(new Insets(20));
			//layout1.setSpacing(10.0);
			//layout1.setPadding(new Insets(10,10,10,10));
		
		//	username.setMaxSize(150, 5);password.setMaxSize(150, 5);
			grid.getChildren().addAll(label,user,username,pass,password,L);
			//grid.add(user, 0,3);grid.add(username,1,0); grid.add(password,0,1 );grid.add(login, 1,1);
	
			//layout1.setAlignment(Pos.CENTER);
			Label question = new Label("This is a question that must be answered"); 
			Button T = new Button("True"); Button F = new Button("False"); 
			VBox qbox= new VBox(question); 
			HBox ans = new HBox(T,F); 
			Label question2 = new Label("another one");
			//qbox.setSpacing(10);
			root.getChildren().addAll(qbox,ans);
			//root.getChildren().add(question2);// root.getChildren().add(ans); 
			
			scene1 = new Scene(grid,350,400);
			scene2 = new Scene(root,350,400); 
			window.setScene(scene1);
			window.setTitle("Quiz program"); 
			window.show();
			//L.setOnAction(this);
			//SignIn(username.getText(),password.getText(),login);
			if(SignIn(username.getText(),password.getText(),login) ==true) {
				L.setOnAction(e-> window.setScene(scene2));}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
public boolean SignIn(String U,String P,boolean c) throws IOException { 
	int count=0; 
	c=false;
	File aF =new File("UsersInfo_004.txt"); 
	FileReader ln = new FileReader("UsersInfo_004.txt"); 
	LineNumberReader LNR = new LineNumberReader(ln);
	while (LNR.readLine() !=null) {count++;}
	LNR.close();
	String[][] UserInfo = new String[28][6]; 
	Scanner fs = new Scanner(aF);	
	System.out.print(count);
	while(fs.hasNext()) {
		for(int i =0; i<UserInfo.length; i++) {for(int y = 0; y<UserInfo[0].length;y++) {
			UserInfo[i][y] = fs.next(); 
			//System.out.print(UserInfo[26][4]);
		}
	}
		for(int i =0; i<UserInfo.length; i++) {for(int y = 0; y<UserInfo[i].length;y++) {
			
			System.out.println(UserInfo[i][y]);
		}
	}
	}for(int col = 0; col < 1; col++) {
		for (int row = 1; row < 28; row++) {
			if(U.equalsIgnoreCase(UserInfo[row][col])) {c=true; 
			
				}//scans the file for the user name credentials and prints login if its correct. 
		}
		}
	fs.close();
	return c;
}

	
}


