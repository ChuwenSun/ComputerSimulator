package computerSimulator.DataAndLoc;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class Data_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands, String opcode){	
		
		//print nothing, just update the loc
		if(operands.size() == 1) {
			printer.print(Translator.sixDigitLoc(loc) + " ");
			if(operands.get(0).equals("End")) {
				//End means 1024
				printer.print(Translator.toSixDigit(Integer.toOctalString(1024)));
			}else {

				
				printer.print(Translator.toSixDigit(Integer.toOctalString(Integer.parseInt(operands.get(0)))) );
			}

		}else {
			printer.print("Data ERORR!!!!!!!!!!!!!!!! Too many operands");
			System.out.print("Data ERORR!!!!!!!!!!!!!!!! Too many operands");
		}
		return loc + 1;
	}

}
