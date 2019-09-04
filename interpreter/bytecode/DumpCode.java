package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode
{
    private String bool;

    @Override
    public void init(ArrayList<String> str)
    {
        bool = str.get(0);
    }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        if(bool.equals("ON"))
        {
            VM.setDumping(true);
        }
        else if(bool.equals("OFF"))
        {
            VM.setDumping(false);
        }
    }

    @Override
    public String toString()
    {
        return "DUMP ";
    }
}
