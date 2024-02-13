package computerSimulator.Miscellaneous;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class HLT_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands, String opcode){	
		printer.print(Translator.sixDigitLoc(loc) + " 000000");
		return loc+1;
	}

}
