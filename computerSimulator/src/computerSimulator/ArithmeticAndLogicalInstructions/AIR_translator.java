package computerSimulator.ArithmeticAndLogicalInstructions;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class AIR_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands, String opcode) {
		String binaryStr = "";
		if(operands.size() != 2) {
			throw new IllegalArgumentException("ERROR!!!!! AIR wrong operands.size():  " + operands.size());
		}else {
			String Opcode = Translator.opcodeToBinary(opcode);
			String R = Translator.rIxToBinary(operands.get(0));

			String immed = Translator.addressToBinary(operands.get(1));
			binaryStr = Opcode + R + "000" + immed;
			printer.print(Translator.sixDigitLoc(loc) + " ");
			printer.print(Translator.binaryToOctal(binaryStr));
		}
		return loc + 1;
		
		
	}

}
