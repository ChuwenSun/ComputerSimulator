package computerSimulator;

import java.util.List;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import computerSimulator.Miscellaneous.*;
import computerSimulator.DataAndLoc.*;
import computerSimulator.LoadAndStore.*;
import computerSimulator.Transfer.*;


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
//        translatorMap.put("JCC", new JCC_translator());
        opcodes.put("JMA", "11");
        opcodes.put("JSR", "12");
        opcodes.put("RFS", "13");
        opcodes.put("SOB", "14");
        opcodes.put("JGE", "15");
        
        //Arithmetic and Logical Instructions
        opcodes.put("AMR", "16");
        opcodes.put("SMR", "17");
        opcodes.put("AIR", "20");
        opcodes.put("SIR", "21");
        
        opcodes.put("MLR", "22");
        opcodes.put("DVD", "23");
        opcodes.put("TRR", "24");
        opcodes.put("AND", "25");
        opcodes.put("ORR", "26");
        opcodes.put("NOT", "27");

        opcodes.put("SRC", "30");
        opcodes.put("RRC", "31");
        
        opcodes.put("IN", "32");
        opcodes.put("OUT", "33");
        opcodes.put("CHK", "34");
        
        //Floating Point Instructions/Vector Operations
        opcodes.put("FADD", "35");
        opcodes.put("FSUB", "36");
        opcodes.put("VADD", "37");
        opcodes.put("VSUB", "40");
        opcodes.put("CNVRT", "41");
        opcodes.put("LDFR", "42");
        opcodes.put("STFR", "43");
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
