package computerSimulator;

import java.io.PrintWriter;
import java.util.List;

public interface Translator {
	int translate(PrintWriter printer, int loc, List<String> operands);
	
	// fill up a string with 0 in the front till it has 6 digit
	static String toSixDigit(String str) {
		String output = "";
		for (int i = 0; i < 6 - str.length(); i++) {
			output += "0";
		}
		output += str;
		return output;
	}
	// return a six Digit Loc String in Octal(This is the first column)
	static String sixDigitLoc(int loc) {
		String octalStr = Integer.toOctalString(loc);
		return Translator.toSixDigit(octalStr);
	}
	
	// return opcode in a 6-digits String form
	static String opcodeToBinary(int opcode) {
		//turn the opcodes into a binary string and then turn it fill it up to 6 digit 
		return Translator.toSixDigit(Integer.toBinaryString(opcode));	
	}
	
	// return operand r in a 2-digits String form
	static String rIxToBinary(String r) {
		
		String binaryR = Integer.toBinaryString(Integer.parseInt(r));
		if(binaryR.length() == 1) {
			// "1" and "0" need a 0 in the front to be two-digits: "01", "00"
			binaryR = "0" + binaryR;
		}
		return binaryR;
	}
	
	//return operand address in a 5-digits String form
	static String addressToBinary(String address) {
		String binaryAdd = Integer.toBinaryString(Integer.parseInt(address));
		int length = binaryAdd.length();
		for (int i = 0; i < 5 - length; i++) {
			binaryAdd = "0" + binaryAdd;
		}
		return binaryAdd;
	}
	
	//return a 6 digits octal string from a 16 digits binary string
	static String binaryToOctal(String binaryStr) {
        if (binaryStr == null || binaryStr.length() != 16 || !binaryStr.matches("[01]+")) {
            throw new IllegalArgumentException("Input must be a 16-digit binary number.");
        }

        // Convert binary string to a long integer
        long number = Long.parseLong(binaryStr, 2);

        // Convert the long to an octal string
        String octalStr = Long.toOctalString(number);

        // Adding 0s in the front to a 6-digits string
        while (octalStr.length() < 6) {
            octalStr = "0" + octalStr;
        }

        return octalStr;
	}
}
