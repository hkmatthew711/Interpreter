package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;


public class Program {

    private ArrayList<ByteCode> program;
    private static HashMap<String, Integer>LabelTable;


    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public void addByteCode(ByteCode byteCode)
    {
        program.add(byteCode);
    }


    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program)
    {
        LabelTable = new HashMap<>();
        for(int i = 0; i < program.getSize(); i++)
        {
            ByteCode addr1 = program.getCode(i);

            if(addr1 instanceof GotoCode)
            {
                LabelTable.put(((GotoCode)addr1).getLabel(), i);
            }

            if(addr1 instanceof LabelCode)
            {
                LabelTable.put(((LabelCode)addr1).getLabel(), i);
            }
        }

        for(int i = 0; i < program.getSize(); i++)
        {
            ByteCode addr2 = program.getCode(i);

            if(addr2 instanceof FalseBranchCode)
            {
                if (LabelTable.containsKey(((FalseBranchCode) addr2).getLabel()))
                {
                    ((FalseBranchCode) addr2).setLabel(LabelTable.get(((FalseBranchCode) addr2).getLabel()));
                }
            }

            if(addr2 instanceof GotoCode)
            {
                if(LabelTable.containsKey(((GotoCode)addr2).getLabel()))
                {
                    ((GotoCode)addr2).setLabel(LabelTable.get(((GotoCode)addr2).getLabel()));
                }
            }

            if(addr2 instanceof CallCode)
            {
                if(LabelTable.containsKey(((CallCode)addr2).getLabel()))
                {
                    ((CallCode)addr2).setLabel(LabelTable.get(((CallCode)addr2).getLabel()));
                }
            }
        }
    }
}
