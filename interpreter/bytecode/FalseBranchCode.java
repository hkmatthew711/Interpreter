package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class FalseBranchCode extends ByteCode
{
    private String label;
    int address;

    @Override
    public void init(ArrayList<String> str)
    {
        label = str.get(0);
    }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        if(VM.pop() == 0)
        {
            VM.setPC(Integer.parseInt(label));
        }

    }

    @Override
    public String toString()
    {
        return "FALSEBRANCH " + label + "\n[]";
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
