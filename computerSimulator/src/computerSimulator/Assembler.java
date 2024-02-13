
package computerSimulator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;



/* 
 * Instruction Class is for one instruction line from the input file
 * which includes: 
 * a <String> instructionString, e.g. LDR, IN, JCC and etc.
 * a < List<String> >, for storing all the operands
 */
class Instruction {
	String instructionString;
	List<String> operands;

	public Instruction(String instructionString, List<String> operands) {
		this.instructionString = instructionString;
		this.operands = operands;
	}
	
	//toString method for easy debugging process
    @Override
    public String toString() {
        return "Instruction: " + instructionString + ", Operand Count: " + operands.size() + ", Operands: " + operands;
    }

}

public class Assembler {
	
	public static void main(String[] args) {
//		scanner is for detecting keyboard input for input filepath and output filepath	
		Scanner scanner = new Scanner(System.in);
//		String filePath = "D:/EclipseWorkSpace/ComputerSimulator_Git/ComputerSimulator/computerSimulator/inputFiles/test.txt";
//		String outputPath = "D:/EclipseWorkSpace/ComputerSimulator_Git/ComputerSimulator/computerSimulator/output/output.txt";
        
		
		// Prompt the user for the input file path
        System.out.print("Enter the input file path: ");
        String inputFilePath = scanner.nextLine();

        // Prompt the user for the output file path
        System.out.print("Enter the output file path: ");
        String outputFilePath = scanner.nextLine();
        
        //Close the Scanner
        scanner.close();
        
        //Initialize the printer to print into outputFilePath
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(new File(outputFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		
		/* 
		 * Create a ArrayList to store every line of instruction in the input file 
		 */
		List<Instruction> instructions = new ArrayList<>();

		/* 
		 * initialize the loc integer to record the current memory 
		 * location which is reponsible for the first column of output
		 */
		int loc = 0;
		try {
			/* Read the input files line by line */
			List<String> inputLines = Files.readAllLines(Paths.get(inputFilePath));
			/*
			 * for every line, split them by the space, before the space is the instruction
			 * string, after the space is the operands. Extra spaces are removed
			 */			
			for (String line : inputLines) {
				String[] parts = line.split("\\s+", 2);
				String instructionString = parts[0];
				List<String> operands = new ArrayList<>();
				if (parts.length > 1) {
				    operands = Arrays.asList(parts[1].trim().split("\\s*,\\s*"));
				}
				
				
//				Generate a instruction object to represent a line in the input file and store into the arraylist
				Instruction instruction = new Instruction(instructionString, operands);
				instructions.add(instruction);
				System.out.println("Instruction line read and added into Assembler: " + instructionString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		 * Translation process: translating every instruction read from the input file,
		 * and print the machine code into output file
		 */	
			for (Instruction instruction : instructions) {
			// update the current memory loc while printing out machine code
			loc = InstructionTranslator.translateInstruction(printer, loc, instruction.instructionString, instruction.operands);
			printer.println();
		}
		System.out.println("Output finished! Please check " + outputFilePath);
		printer.close();
	}
}
