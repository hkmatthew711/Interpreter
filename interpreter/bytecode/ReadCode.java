package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReadCode extends ByteCode
{
    @Override
    public void init(ArrayList<String> str) { }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        int result = VM.read();
        VM.push(result);

    }

    @Override
    public String toString()
    {
        return "READ \n[]";
    }
}
