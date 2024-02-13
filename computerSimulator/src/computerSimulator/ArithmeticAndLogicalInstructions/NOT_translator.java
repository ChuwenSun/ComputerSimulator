package computerSimulator.ArithmeticAndLogicalInstructions;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class NOT_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands, String opcode) {
		String binaryStr = "";
		if(operands.size() != 1) {
			throw new IllegalArgumentException("ERROR!!!!! NOT wrong operands.size():  " + operands.size());
		}else {
			String Opcode = Translator.opcodeToBinary(opcode);
			//TODO: check rx can only be 0 or 2
			String rx = Translator.rIxToBinary(operands.get(0));
			String ry = Translator.rIxToBinary("0");
			String I = "0";
			if(operands.size() == 4 && operands.get(3).equals("1")) {
				I = "1";
			}
			String Address = Translator.addressToBinary("00000");
			binaryStr = Opcode + rx + ry + I + Address;
//			System.out.println("Opcode: " + Opcode + " R: " + R + " IX: " + IX + " I: " + I + " Add: " + Address);
			printer.print(Translator.sixDigitLoc(loc) + " ");
			printer.print(Translator.binaryToOctal(binaryStr));
		}
		return loc + 1;
		
		
	}

}
