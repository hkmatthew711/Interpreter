package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode
{
    private String pop;
    private int numPop;

    @Override
    public void init(ArrayList<String> str)
    {
        if(!str.isEmpty())
        {
            pop = str.get(0);
            this.numPop = Integer.parseInt(pop);
        }
    }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        VM.pop();
    }

    @Override
    public String toString()
    {
        return "POP " + pop + "\n";
    }
}
