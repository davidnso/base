package primelab;
import java.util.Random;
public class Coin {
private String sideUp; 
private int Hcount=0;; 
private int Tcount=0;
Coin(){ 
 Random rand = new Random();
int r =  rand.nextInt(2)+1; 
if(r==1) {
	sideUp = "Heads"; 
}
else { sideUp = "Tails"; }
}
public String sideUp() {
	return sideUp;
	
}
public void toss() { 
	Random rand = new Random();
	int r =  rand.nextInt(2)+1; 
	if(r==1) {
		sideUp = "Heads"; 
		Hcount++; 
	}
	else { sideUp = "Tails"; Tcount++; }
	}
public String getSideUp() { 
	return sideUp; 
}
public int getHcount() { 
	return Hcount; 
}
public int getTcount() { 
	return Tcount; 
}
}

