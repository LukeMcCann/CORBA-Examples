package ParamTest;


/**
* ParamTest/MyServerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ParamTest.idl
* Friday, 1 March 2019 15:15:56 o'clock GMT
*/

public interface MyServerOperations 
{
  void op1 (String a1, ParamTest.stringSeqHolder s);
  void op3 (ParamTest.my_structHolder m);
  void op4 (ParamTest.stringArrayHolder sa);
  String op5 (org.omg.CORBA.StringHolder ws);
  void stringCubeInOut (ParamTest.stringCubeHolder sc);
  void print (String s);
  boolean addNums (double n1, double n2, org.omg.CORBA.DoubleHolder n3);
} // interface MyServerOperations
