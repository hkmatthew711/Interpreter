package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GotoCode extends ByteCode
{
    private String label;


    @Override
    public void init(ArrayList<String> str)
    {
        label = str.get(0);
    }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        VM.setPC(Integer.parseInt(label));
    }

    @Override
    public String toString()
    {
        return "GOTO " + label + "\n";
    }

    public void setLabel(int index)
    {
        label = Integer.toString(index);
    }

    public String getLabel()
    {
        return label;
    }
}
