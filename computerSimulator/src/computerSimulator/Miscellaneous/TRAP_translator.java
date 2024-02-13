package computerSimulator.Miscellaneous;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class TRAP_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands, String opcode){	
		
		String Opcode = Translator.opcodeToBinary(opcode);
		String TrapCode = Translator.countToBinary(operands.get(0));
		String binaryStr = Opcode + "000000" + TrapCode;
		printer.print(Translator.sixDigitLoc(loc) + " ");
		printer.print(Translator.binaryToOctal(binaryStr));
		
		return loc+1;
	}

}
