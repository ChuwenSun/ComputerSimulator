package computerSimulator;

import java.util.List;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import computerSimulator.Miscellaneous.*;
import computerSimulator.DataAndLoc.*;
import computerSimulator.LoadAndStore.*;
import computerSimulator.Transfer.*;
import computerSimulator.ArithmeticAndLogicalInstructions.*;
import computerSimulator.IO_Operations.*;

public class InstructionTranslator {
	// Initialize the opcode hashmap
	private static final Map<String, String> opcodes = new HashMap<>();
	private static final Map<String, Translator> translatorMap = new HashMap<>();
	static {  
		//Data and Loc
        translatorMap.put("LOC", new LOC_translator());
        translatorMap.put("Data", new Data_translator());
		
		//Miscellaneous Instructions
        opcodes.put("HLT", "000"); 
        translatorMap.put("HLT", new HLT_translator());
        //Load/Store Instructions
        opcodes.put("LDR", "01");
        translatorMap.put("LDR", new LDR_translator());
        opcodes.put("STR", "02");
        translatorMap.put("STR", new STR_translator());
        opcodes.put("LDA", "03");
        translatorMap.put("LDA", new LDA_translator());
        opcodes.put("LDX", "04");
        translatorMap.put("LDX", new LDX_translator());
        opcodes.put("STX", "05");
        translatorMap.put("STX", new STX_translator());
        
        //Transfer Instructions
        opcodes.put("SETCCE", "44");
        translatorMap.put("SETCCE", new SETCCE_translator());
        opcodes.put("JZ", "06");
        translatorMap.put("JZ", new JZ_translator());
        opcodes.put("JNE", "07");
        translatorMap.put("JNE", new JNE_translator());
        opcodes.put("JCC", "10");
        translatorMap.put("JCC", new JCC_translator());
        opcodes.put("JMA", "11");
        translatorMap.put("JMA", new JMA_translator());
        opcodes.put("JSR", "12");
        translatorMap.put("JSR", new JSR_translator());
        opcodes.put("RFS", "13");
//        translatorMap.put("RFS", new RFS_translator());
        opcodes.put("SOB", "14");
        translatorMap.put("SOB", new SOB_translator());
        opcodes.put("JGE", "15");
        translatorMap.put("JGE", new JGE_translator());
        
        //Arithmetic and Logical Instructions
        opcodes.put("AMR", "16");
        translatorMap.put("AMR", new AMR_translator());
        opcodes.put("SMR", "17");
        translatorMap.put("SMR", new SMR_translator());
        opcodes.put("AIR", "20");
//        translatorMap.put("AIR", new AIR_translator());
        opcodes.put("SIR", "21");
//        translatorMap.put("SIR", new SIR_translator());
        
        opcodes.put("MLT", "22");
        translatorMap.put("MLT", new MLT_translator());
        opcodes.put("DVD", "23");
        translatorMap.put("DVD", new DVD_translator());
        opcodes.put("TRR", "24");
        translatorMap.put("TRR", new TRR_translator());
        opcodes.put("AND", "25");
        translatorMap.put("AND", new AND_translator());
        opcodes.put("ORR", "26");
        translatorMap.put("ORR", new ORR_translator());
        opcodes.put("NOT", "27");
        translatorMap.put("NOT", new NOT_translator());

        opcodes.put("SRC", "30");
        translatorMap.put("SRC", new SRC_translator());
        opcodes.put("RRC", "31");
        translatorMap.put("RRC", new RRC_translator());
        
        opcodes.put("IN", "32");
        translatorMap.put("IN", new IN_translator());
        opcodes.put("OUT", "33");
        translatorMap.put("OUT", new OUT_translator());
        opcodes.put("CHK", "34");
        translatorMap.put("CHK", new CHK_translator());
        
        //Floating Point Instructions/Vector Operations
//        opcodes.put("FADD", "35");
//        translatorMap.put("FADD", new FADD_translator());
//        opcodes.put("FSUB", "36");
//        translatorMap.put("FSUB", new FSUB_translator());
//        opcodes.put("VADD", "37");
//        translatorMap.put("VADD", new VADD_translator());
//        opcodes.put("VSUB", "40");
//        translatorMap.put("VSUB", new VSUB_translator());
//        opcodes.put("CNVRT", "41");
//        translatorMap.put("CNVRT", new CNVRT_translator());
//        opcodes.put("LDFR", "42");
//        translatorMap.put("LDFR", new LDFR_translator());
//        opcodes.put("STFR", "43");
//        translatorMap.put("STFR", new STFR_translator());
    }
	

    // TODO: Add other translation methods here

    // General method to translate a instruction, parameters are the instructionString and the operands
    public static int translateInstruction(PrintWriter printer, int loc, String instructionString, List<String> operands) {
        // Specific translation method will be called to translate  instruction
    	Translator translator = translatorMap.get(instructionString);
    	if (translator == null) {
    		//TODO: ERROR!!
    		System.out.println("ERROR translator NULL");
    	}
    	return translator.translate(printer, loc, operands);
    	
//    	switch (instructionString) {
//            case "HLT":
//                return translate(operands);
//            case "STR":
//                return translateSTR(operands);
//            default:
//                return "Unknown instruction!!!";
        
    }
}
