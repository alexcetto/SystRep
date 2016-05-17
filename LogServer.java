import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class LogServer{


	public static void main( String args []) {

		try {
			
			//Initialisation de l�ORB
			ORB orb = ORB.init(args, null);

			//Recuperation de reference de l'adaptateur d'objets racine
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			
			//Initialisation de l'objet servant
			TplogsImpl log = new TplogsImpl();

			//Recuperation de la reference du servant
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(log);
			//Forum href = ForumHelper.narrow(ref);

			//Recuperation de la reference de l'objet mandataire (proxy) du service de nommage 
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			//Conversion
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			//"Enregistrement" dans le service de nommage
			String name = "Logserver";
			NameComponent path[] = ncRef.to_name(name);
			//ncRef.rebind(path, href);
			ncRef.rebind(path, ref);

			//Mise en attente des requetes
			System.out.println("Server ready and waiting ...");
			orb.run();

		} catch (InvalidName e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (WrongPolicy e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (AdapterInactive e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (ServantNotActive e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (NotFound e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (CannotProceed e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}
}