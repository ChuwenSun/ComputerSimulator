package computerSimulator.DataAndLoc;

import java.io.PrintWriter;
import java.util.List;

import computerSimulator.Translator;

public class LOC_translator implements Translator{

	@Override
	public int translate(PrintWriter printer, int loc, List<String> operands){		
		//print nothing, just update the loc
		if(operands.size() == 1) {
			loc = Integer.parseInt(operands.get(0));
		}else {
			printer.print("Loc ERORR!!!!!!!!!!!!!!!! Too many operands");
			System.out.print("Loc ERORR!!!!!!!!!!!!!!!! Too many operands");
		}
		return loc;
	}

}
