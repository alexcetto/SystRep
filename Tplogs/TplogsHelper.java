package Tplogs;


/**
* Tplogs/TplogsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Tplogs.idl
* den 16 maj 2016 kl 22:48 CEST
*/

abstract public class TplogsHelper
{
  private static String  _id = "IDL:Tplogs/Tplogs:1.0";

  public static void insert (org.omg.CORBA.Any a, Tplogs.Tplogs that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Tplogs.Tplogs extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Tplogs.TplogsHelper.id (), "Tplogs");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Tplogs.Tplogs read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_TplogsStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Tplogs.Tplogs value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Tplogs.Tplogs narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Tplogs.Tplogs)
      return (Tplogs.Tplogs)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Tplogs._TplogsStub stub = new Tplogs._TplogsStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Tplogs.Tplogs unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Tplogs.Tplogs)
      return (Tplogs.Tplogs)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Tplogs._TplogsStub stub = new Tplogs._TplogsStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
