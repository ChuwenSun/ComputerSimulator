package computerSimulator.Transfer;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class RFS_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands, String opcode) {
		String binaryStr = "";
		if(operands.size() != 1) {
			throw new IllegalArgumentException("ERROR!!!!! RFS wrong operands.size():  " + operands.size());
		}else {
			String Opcode = Translator.opcodeToBinary(opcode);
			
			String Immed = Translator.addressToBinary(operands.get(0));
			binaryStr = Opcode + "00000" + Immed;
//			System.out.println("aslkfnlaskfnlkansfklnaslfk" + binaryStr);
//			System.out.println("Opcode: " + Opcode + " R: " + R + " IX: " + IX + " I: " + I + " Add: " + Address);
			printer.print(Translator.sixDigitLoc(loc) + " ");
			printer.print(Translator.binaryToOctal(binaryStr));
		}
		return loc + 1;
		
		
	}

}
