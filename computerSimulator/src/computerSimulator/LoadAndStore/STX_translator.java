package computerSimulator.LoadAndStore;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class STX_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands, String opcode) {
		String binaryStr = "";
		if(operands.size() != 2 && operands.size() != 3) {
			throw new IllegalArgumentException("ERROR!!!!! STX wrong operands.size():  " + operands.size());
		}else {
			String Opcode = Translator.opcodeToBinary(opcode);
			String R = Translator.rIxToBinary("0");
			String IX = Translator.rIxToBinary(operands.get(0));
			String I = "0";
			if(operands.size() == 3 && operands.get(2).equals("1")) {
				I = "1";
			}
			String Address = Translator.addressToBinary(operands.get(1));
			binaryStr = Opcode + R + IX + I + Address;
//			System.out.println("Opcode: " + Opcode + " R: " + R + " IX: " + IX + " I: " + I + " Add: " + Address);
			printer.print(Translator.sixDigitLoc(loc) + " ");
			printer.print(Translator.binaryToOctal(binaryStr));
		}
		return loc + 1;
		
		
	}

}
