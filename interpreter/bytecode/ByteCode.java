package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public abstract class ByteCode
{
    public abstract void init(ArrayList<String> str);

    public abstract void executeProgram(VirtualMachine VM);

    @Override
    public  abstract String toString();

}
