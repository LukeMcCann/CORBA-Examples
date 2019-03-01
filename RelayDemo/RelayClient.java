import ClientAndServer.*;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.io.*;


public class RelayClient {
    public static void main(String args[]) {
	try {
	    // create and initialize the ORB
	    ORB orb = ORB.init(args, null);
	    
	    // read in the 'stringified IOR' of the Relay
	    
      	    BufferedReader in = new BufferedReader(new FileReader("relay.ref"));
      	    String stringified_ior = in.readLine();
	    
	    // get object reference from stringified IOR
      	    org.omg.CORBA.Object server_ref = 		
		orb.string_to_object(stringified_ior);
	    
	    ClientAndServer.Relay relay = 
		ClientAndServer.RelayHelper.narrow(server_ref);
	    
	    // call the Relay
	    System.out.println("Calling relay...");
	    
	    String result = relay.fetch_message();
	    System.out.println("Result = " + result);
	    
	} catch (Exception e) {
	    System.out.println("ERROR : " + e) ;
	    e.printStackTrace(System.out);
	}
    }
}
