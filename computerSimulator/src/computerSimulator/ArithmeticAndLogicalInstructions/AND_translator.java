package computerSimulator.ArithmeticAndLogicalInstructions;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class AND_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands) {
		String binaryStr = "";
		if(operands.size() != 1 && operands.size() != 2) {
			throw new IllegalArgumentException("ERROR!!!!! AND wrong operands.size():  " + operands.size());
		}else {
			String Opcode = Translator.opcodeToBinary(25);
			//TODO: check rx and ry can only be 0 or 2
			String rx = Translator.rIxToBinary(operands.get(0));
			String ry = Translator.rIxToBinary(operands.get(1));
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
