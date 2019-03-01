package ParamTest;


/**
* ParamTest/MyServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ParamTest.idl
* Friday, 1 March 2019 15:15:56 o'clock GMT
*/

public abstract class MyServerPOA extends org.omg.PortableServer.Servant
 implements ParamTest.MyServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("op1", new java.lang.Integer (0));
    _methods.put ("op3", new java.lang.Integer (1));
    _methods.put ("op4", new java.lang.Integer (2));
    _methods.put ("op5", new java.lang.Integer (3));
    _methods.put ("stringCubeInOut", new java.lang.Integer (4));
    _methods.put ("print", new java.lang.Integer (5));
    _methods.put ("addNums", new java.lang.Integer (6));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // ParamTest/MyServer/op1
       {
         String a1 = in.read_string ();
         ParamTest.stringSeqHolder s = new ParamTest.stringSeqHolder ();
         this.op1 (a1, s);
         out = $rh.createReply();
         ParamTest.stringSeqHelper.write (out, s.value);
         break;
       }

       case 1:  // ParamTest/MyServer/op3
       {
         ParamTest.my_structHolder m = new ParamTest.my_structHolder ();
         this.op3 (m);
         out = $rh.createReply();
         ParamTest.my_structHelper.write (out, m.value);
         break;
       }

       case 2:  // ParamTest/MyServer/op4
       {
         ParamTest.stringArrayHolder sa = new ParamTest.stringArrayHolder ();
         this.op4 (sa);
         out = $rh.createReply();
         ParamTest.stringArrayHelper.write (out, sa.value);
         break;
       }

       case 3:  // ParamTest/MyServer/op5
       {
         org.omg.CORBA.StringHolder ws = new org.omg.CORBA.StringHolder ();
         String $result = null;
         $result = this.op5 (ws);
         out = $rh.createReply();
         out.write_wstring ($result);
         out.write_wstring (ws.value);
         break;
       }

       case 4:  // ParamTest/MyServer/stringCubeInOut
       {
         ParamTest.stringCubeHolder sc = new ParamTest.stringCubeHolder ();
         sc.value = ParamTest.stringCubeHelper.read (in);
         this.stringCubeInOut (sc);
         out = $rh.createReply();
         ParamTest.stringCubeHelper.write (out, sc.value);
         break;
       }

       case 5:  // ParamTest/MyServer/print
       {
         String s = in.read_string ();
         this.print (s);
         out = $rh.createReply();
         break;
       }

       case 6:  // ParamTest/MyServer/addNums
       {
         double n1 = in.read_double ();
         double n2 = in.read_double ();
         org.omg.CORBA.DoubleHolder n3 = new org.omg.CORBA.DoubleHolder ();
         boolean $result = false;
         $result = this.addNums (n1, n2, n3);
         out = $rh.createReply();
         out.write_boolean ($result);
         out.write_double (n3.value);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ParamTest/MyServer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public MyServer _this() 
  {
    return MyServerHelper.narrow(
    super._this_object());
  }

  public MyServer _this(org.omg.CORBA.ORB orb) 
  {
    return MyServerHelper.narrow(
    super._this_object(orb));
  }


} // class MyServerPOA
