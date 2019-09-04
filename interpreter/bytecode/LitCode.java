package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LitCode extends ByteCode
{
    private String id;
    private String value;
    private int numArgs;

    @Override
    public void init(ArrayList<String> str)
    {
        if (str.size() == 1)
        {
            this.numArgs = 1;
            this.id = str.get(0);
            this.value = null;
        }
        else
        {
            this.numArgs = 2;
            this.id = str.get(0);
            this.value = str.get(1);
        }

    }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        VM.push(Integer.parseInt(id));
    }

    @Override
    public String toString()
    {
        if(value != null)
        {
            return "LIT " + id + "\t\tint " + value + "\n[]";
        }
        else
        {
            return "LIT " + id + " \n[]";
        }
    }
}
