package ParamTest;


/**
* ParamTest/stringFieldHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ParamTest.idl
* Friday, 1 March 2019 15:15:56 o'clock GMT
*/

public final class stringFieldHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[][] = null;

  public stringFieldHolder ()
  {
  }

  public stringFieldHolder (String[][] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ParamTest.stringFieldHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ParamTest.stringFieldHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ParamTest.stringFieldHelper.type ();
  }

}
