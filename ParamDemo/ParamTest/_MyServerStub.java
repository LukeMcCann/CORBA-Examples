package ParamTest;


/**
* ParamTest/_MyServerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ParamTest.idl
* Friday, 1 March 2019 15:15:56 o'clock GMT
*/

public class _MyServerStub extends org.omg.CORBA.portable.ObjectImpl implements ParamTest.MyServer
{

  public void op1 (String a1, ParamTest.stringSeqHolder s)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("op1", true);
                $out.write_string (a1);
                $in = _invoke ($out);
                s.value = ParamTest.stringSeqHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                op1 (a1, s        );
            } finally {
                _releaseReply ($in);
            }
  } // op1

  public void op3 (ParamTest.my_structHolder m)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("op3", true);
                $in = _invoke ($out);
                m.value = ParamTest.my_structHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                op3 (m        );
            } finally {
                _releaseReply ($in);
            }
  } // op3

  public void op4 (ParamTest.stringArrayHolder sa)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("op4", true);
                $in = _invoke ($out);
                sa.value = ParamTest.stringArrayHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                op4 (sa        );
            } finally {
                _releaseReply ($in);
            }
  } // op4

  public String op5 (org.omg.CORBA.StringHolder ws)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("op5", true);
                $in = _invoke ($out);
                String $result = $in.read_wstring ();
                ws.value = $in.read_wstring ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return op5 (ws        );
            } finally {
                _releaseReply ($in);
            }
  } // op5

  public void stringCubeInOut (ParamTest.stringCubeHolder sc)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("stringCubeInOut", true);
                ParamTest.stringCubeHelper.write ($out, sc.value);
                $in = _invoke ($out);
                sc.value = ParamTest.stringCubeHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                stringCubeInOut (sc        );
            } finally {
                _releaseReply ($in);
            }
  } // stringCubeInOut

  public void print (String s)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("print", true);
                $out.write_string (s);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                print (s        );
            } finally {
                _releaseReply ($in);
            }
  } // print

  public boolean addNums (double n1, double n2, org.omg.CORBA.DoubleHolder n3)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addNums", true);
                $out.write_double (n1);
                $out.write_double (n2);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                n3.value = $in.read_double ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return addNums (n1, n2, n3        );
            } finally {
                _releaseReply ($in);
            }
  } // addNums

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ParamTest/MyServer:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _MyServerStub
