package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class WriteCode extends ByteCode
{
    @Override
    public void init(ArrayList<String> str) { }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        Integer value = VM.peek();
        System.out.println("WRITE\n" + value.toString());
    }

    @Override
    public String toString()
    {
        return "WRITE \n[]";
    }
}
