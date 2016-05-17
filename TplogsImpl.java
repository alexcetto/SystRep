
import java.util.*;
import java.io.*;
import org.omg.CORBA.IntHolder;
import org.omg.CORBA.StringHolder;

import Tplogs.TplogsPOA;
/*
UsefulLinks
https://docs.oracle.com/javase/8/docs/technotes/guides/idl/jidlExample3.html
http://www.javacoffeebreak.com/articles/javaidl/javaidl.html
http://gsraj.tripod.com/corba/chapter/javaidl_2.html
*/



public class TplogsImpl extends TplogsPOA {
	private file mainLog;
	private boolean free;
	private ArrayList<String> relais; // Not sure how to represent the relais

	public TplogsImpl() {
		mainLog = new File("mainLog.txt");
		relais = new ArrayList<String>();
		free = true;
	}

	/*
	Save realis in the list
	*/
	public void addRelai(String relaiID){ // Again how do I represent a relai
		relais.add(relaiID);

	}
	/*
	mah how
	*/
	public void writeToMainLog(File relaiLog){ 
		free = false;
		Scanner sc = new Scanner(relaiLog);
		PrintWriter logwriter = new PrintWriter(mainLog);

		while(sc.hasNextLine()){
			String line = sc.nextLine();
			logwriter.write(line);

		}
		logwriter.flush();
		free = true;
	}

	public boolean isMainLogAvailable(){
		return free;

	}

	/*
	Use the relais list to broadcast to the other relais to wait?
	*/
   public void iAmWritingToMainLog(){


   }
   /*
	Dont really understand the meaning of this one
   */
  public boolean canIWriteToMainLog(){


  }
  /*
	Or this one
  */
  public boolean mainLogIsFree(){


  }
	
	
}

