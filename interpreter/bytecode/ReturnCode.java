package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReturnCode extends ByteCode
{
    private String label;

    @Override
    public void init(ArrayList<String> str)
    {
        if(!str.isEmpty())
        {
            label = str.get(0);
        }
        else
        {
            label = "NULL";
        }
    }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        VM.popFrame();
        int result = VM.returnPop();
        VM.setPC(result);
    }

    @Override
    public String toString()
    {
        if(label.equals("NULL"))
        {
            return "RETURN \n";
        }
        else
        {
            return "RETURN factorial  exit\n" + label + "\n";
        }
    }
}
