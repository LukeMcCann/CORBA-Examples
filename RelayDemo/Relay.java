import ClientAndServer.*;

import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.CORBA.*;

import java.io.*;


class RelayServant extends RelayPOA {
    
    private ORB orb;
    private ClientAndServer.HelloWorld server;
    
    public RelayServant(ORB orb_val) {
	// store reference to ORB
	orb = orb_val;

	// look up the server
	try {
	    // read in the 'stringified IOR'
      	    BufferedReader in = new BufferedReader(new FileReader("server.ref"));
      	    String stringified_ior = in.readLine();

	    // get object reference from stringified IOR
      	    org.omg.CORBA.Object server_ref = 		
		orb.string_to_object(stringified_ior);
	    server = ClientAndServer.HelloWorldHelper.narrow(server_ref);
	} catch (Exception e) {
	    System.out.println("ERROR : " + e) ;
	    e.printStackTrace(System.out);
	}
    }
    
    public String fetch_message() {
	System.out.println("fetch_message called by client.  Calling server..");
	
	String messageFromServer = server.hello_world();
	System.out.println("message from server = " + messageFromServer 
			   + "Now forwarding to client..");
	
	return messageFromServer;
    }
}

public class Relay {
    
    public static void main(String args[]) {
	try {
	    // create and initialize the ORB
	    ORB orb = ORB.init(args, null);
	    
	    // get reference to rootpoa & activate the POAManager
	    POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	    rootpoa.the_POAManager().activate();
	    
	    // create servant and register it with the ORB
	    RelayServant relayRef = new RelayServant(orb);
	    
	    // Get the 'stringified IOR'
	    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(relayRef);
            String stringified_ior = orb.object_to_string(ref);
	    
    	    // Save IOR to file
            BufferedWriter out = new BufferedWriter(new FileWriter("relay.ref"));
            out.write(stringified_ior);
	    out.close();
	    
	    // wait for invocations from clients
	    System.out.println("Relay started.  Waiting for clients...");
            orb.run();

	} catch (Exception e) {
	    System.err.println("ERROR: " + e);
	    e.printStackTrace(System.out);
	}
    }
}

