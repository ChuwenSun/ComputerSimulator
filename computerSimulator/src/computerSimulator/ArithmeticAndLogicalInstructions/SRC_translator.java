package computerSimulator.ArithmeticAndLogicalInstructions;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class SRC_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands) {
		String binaryStr = "";
		if(operands.size() != 4) {
			throw new IllegalArgumentException("ERROR!!!!! RRC wrong operands.size():  " + operands.size());
		}else {
			String Opcode = Translator.opcodeToBinary(31);
			String R = Translator.rIxToBinary(operands.get(0));
			String Count = Translator.countToBinary( operands.get(1) );
			
			String LR = operands.get(2);
			String AL = operands.get(3);
			
			binaryStr = Opcode + R + AL + LR + "00" + Count;
//			System.out.println("Opcode: " + Opcode + " R: " + R + " IX: " + IX + " I: " + I + " Add: " + Address);
			printer.print(Translator.sixDigitLoc(loc) + " ");
			printer.print(Translator.binaryToOctal(binaryStr));
		}
		return loc + 1;
		
		
	}

}
