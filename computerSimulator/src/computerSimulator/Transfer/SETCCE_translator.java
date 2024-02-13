package computerSimulator.Transfer;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class SETCCE_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands, String opcode) {
		String binaryStr = "";
		if(operands.size() != 1) {
			throw new IllegalArgumentException("ERROR!!!!! SETCCE wrong operands.size():  " + operands.size());
		}else {
			String Opcode = Translator.opcodeToBinary(opcode);
			
			String R = Translator.rIxToBinary(operands.get(0));
			binaryStr = Opcode + R + "00000000";
//			System.out.println("Opcode: " + Opcode + " R: " + R + " IX: " + IX + " I: " + I + " Add: " + Address);
			printer.print(Translator.sixDigitLoc(loc) + " ");
			printer.print(Translator.binaryToOctal(binaryStr));
		}
		return loc + 1;
		
		
	}

}
