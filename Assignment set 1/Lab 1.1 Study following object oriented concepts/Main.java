// This is a demonstration of the previous concepts in Java Programming Language (you can also 
public class Main 
{
    public static void main(String[] args)
    {
        AClass aClass = new AClass(1, 2.0f, "c"); // aClass is a reference to an AClass object. The object is created using the constructor.
        
        aClass.displayValues();

        aClass.a = 10; // field a has public acces. We can modify it from here
        //aClass.b = 14f; field b is private. We don't have acces to it from outside of the class
        //aClass.c = 15f; field c is protected. We don't have acces to it from here
        
        aClass.displayValues();

        BClass bClass = new BClass(5, 10, "someString", 5); 

        System.out.println(bClass instanceof BClass);
        System.out.println(bClass instanceof AClass);
        // as we can see both of these println methods return true. Since BClass extends AClass, BClass is also an AClass.

        AClass bClass2 = new BClass(10, 10, "polymorphism", 5); // this is polymorphism
        // we can use a reference of type AClass to refer to a BClass object

        bClass2.displayValues();

        bClass2.doStuff(); // even though bClass2 is declared as AClass, the overriden method is going to be executed instead of the base method

        bClass2.displayValues();

        IDoMoreStuff cClass = new CClass(); // another way to use polymorphism with interfaces

        cClass.doMoreStuff();

        //DClass x = new DClass(); we cannot do that since DClass is abstract
        DClass y = new EClass();

        y.implementedMethod();

        ((EClass)y).doMoreStuff(); // since y is declared as a DClass we need to cast it to EClass to access the methods from there
    }
}

// this is a class
class AClass {

    // these are member datas of AClass ()
    public int a;
    private float b;
    protected String c;

    // this is the constructor of AClass
    public AClass(int a, float b, String c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // these are method members of AClass
    public void doStuff()
    {
        a = 10;
        b = 5f;
        c = "NewString";

    }

    public void displayValues()
    {
        System.out.println(a + " " + b + " " + c);
    }

}

class BClass extends AClass {

    long d;

    public BClass(int a, float b, String c, long d)
    {
        // we must call the constructor from AClass first
        super(a, b, c);

        this.d = d;
    }

    // We can override methods from the base class
    @Override
    public void doStuff()
    {
        // we can call the method from the superclass here
        super.doStuff();

        a = 15;
        //b = 15;  Since b is private we can't access is from here
        c = "new extended String";
    }

    public void doExtraStuff()
    {
        d = 22;
    }

    public void displayNewValues()
    {
        System.out.println(d);
    }
}

// This is an interface
interface IDoMoreStuff {
    // methods declared in the interface must be implemented when we implement IDoMoreStuff
    void doMoreStuff();
}

class CClass implements IDoMoreStuff
{

    // this method needs to be implemented since the class inherits IDoMoreStuff
    @Override
    public void doMoreStuff() {
        BClass bClass = new BClass(10, 10, "c", 15);
        
        bClass.d = 10; // since d has package access (default) it can be accessed from here

        System.out.println(bClass.d);
    }

}

// this is an abstract class. It cannot be instanciated.
abstract class DClass {

    protected int x;

    protected abstract void abstractMethod();

    public void implementedMethod()
    {
        System.out.println("This method is implemented inside the abstract class");
    }
}

// Java doesn't support multiple inheritance
// A class can only inherit one class but in can implement multiple interfaces
class EClass extends DClass implements IDoMoreStuff{

    @Override
    public void doMoreStuff() {
        x = 10;

        abstractMethod();
    }

    @Override
    protected void abstractMethod() {
        System.out.println("implementing the abstract method");
    }

    public void printX()
    {
        System.out.println(x);
    }
}