package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LoadCode extends ByteCode
{
    private String offset;
    private String id;
    private int numArgs;

    @Override
    public void init(ArrayList<String> str)
    {
        if(!str.isEmpty())
        {
            offset = str.get(0);
            numArgs = str.size();
            if(str.size() == 2)
            {
                id = str.get(1);
            }
        }
    }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        VM.loadCode(Integer.parseInt(offset));
    }

    @Override
    public String toString()
    {
        if(this.numArgs != 1)
        {
            return "LOAD " + offset + " " + id + "\n[]";
        }
        else
        {
            return "LOAD " + offset + " " + id + "\t<load " + id + ">\n[]";
        }
    }
}
