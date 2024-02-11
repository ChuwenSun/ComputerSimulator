
package computerSimulator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Instruction {
	String instructionString;
	int operandCount;
	List<String> operands;

	public Instruction(String instructionString, List<String> operands) {
		this.instructionString = instructionString;
		this.operandCount = operands.size();
		this.operands = operands;
	}
	
    @Override
    public String toString() {
        return "Instruction: " + instructionString + ", Operand Count: " + operandCount + ", Operands: " + operands;
    }

}

public class Assembler {
	
	public static void main(String[] args) {
		/*
		 * Specify the file path for input file
		 */		
		String filePath = "D:/EclipseWorkSpace/computerSimulator/inputFiles/sampleInput2";
		String outputPath = "D:/EclipseWorkSpace/computerSimulator/output/output.txt";
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(new File(outputPath));
            // More print statements as needed
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		
		/* Create a ArrayList to store every line of instruction in the input file */
		List<Instruction> instructions = new ArrayList<>();

		int loc = 0;
		try {
			/* Read the input files line by line */
			List<String> inputLines = Files.readAllLines(Paths.get(filePath));
			/*
			 * for every line, split them by the space, before the space is the instruction
			 * string, after the space is the operands
			 */			
			for (String line : inputLines) {
				String[] parts = line.split(" ", 2);
				String instructionString = parts[0];
				List<String> operands = new ArrayList<>();
				if (parts.length > 1) {
					operands = Arrays.asList(parts[1].split(","));
				}
				/*
				 * Genenrate a instruction object to represent a line in the input file
				 */				
				Instruction instruction = new Instruction(instructionString, operands);
				instructions.add(instruction);
				System.out.println("Instruction line read and added into Assembler: " + instructionString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO: Change println to actually translating each instruction and print them into output file
		for (Instruction instruction : instructions) {
			loc = InstructionTranslator.translateInstruction(printer, loc, instruction.instructionString, instruction.operands);
			printer.println();
		}
		printer.close();
	}
}
