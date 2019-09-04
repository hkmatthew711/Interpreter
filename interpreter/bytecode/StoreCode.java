package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import javax.print.DocFlavor;

public class StoreCode extends ByteCode
{
    private String offset;
    private String id;
    private int val;

    @Override
    public void init(ArrayList<String> str)
    {
        offset = str.get(0);
        id = str.get(1);
    }

    @Override
    public void executeProgram(VirtualMachine VM)
    {
        VM.storeCode(Integer.parseInt(offset));
        val = VM.peek();
    }

    @Override
    public String toString()
    {
        return "STORE " + offset + " " + id + " " + id + " = " + val + "\n[]";
    }
}
