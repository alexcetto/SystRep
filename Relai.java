import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.omg.CORBA.IntHolder;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

//import Tplogs.Log; // Probs dont need it rght?

public class Relai{

public static void main(String [] args) {

		try {

			//Initialisation de l'ORB
			ORB orb = ORB.init(args, null);

			//Recuperation de la reference de l'objet mandataire (proxy) du service de nommage 
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			//Recuperation de la reference du servant grace au service de nommage 
			String name = "Update";
			Tplogs log = TplogsHelper.narrow(ncRef.resolve_str(name));
			
			//Checks before to se if ready to write to
			if(log.isMainLogAvailable){

					/*
						After the logs are collected from the other clients in the subnetwork
						 and concatenated into one this file is to be sent to the server, to write
						 to the mainLog
						   
					*/
			}

		}catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} 
			
	}	
		
}