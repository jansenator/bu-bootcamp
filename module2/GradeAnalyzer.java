/**
 * GradeAnalyzer.java
 *
 * Reads integer scores from a text file, computes summary statistics
 * (average, highest, lowest, and letter-grade bands), and writes a report.
 *
 * @author Jansen Rensma
 * Note: a GitHub Copilot "learn" agent was referenced while writing this
 * code; it teaches the concepts involved rather than providing answers.
 */
import java.io.*;
import java.util.ArrayList;

/**
 * Analyzes student grade scores: loads them from a file, calculates
 * summary statistics, and produces a report.
 */
public class GradeAnalyzer {

    // Var to keep track track of skipped lines
    private static int skippedLines = 0;

    /**
     * Program entry point. Orchestrates the three steps of the analysis:
     * read the scores, calculate statistics (average, highest, lowest,
     * letter-grade bands), then write and print the report.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // read scores from file
        String filename = "scores.txt";
        ArrayList<Integer> scores = readScores(filename);

        // Make sure the file is not empty by checking how many score are returned
        if (scores.size() < 1) {
            System.out.print("There are no scores in the file!");
            return;
        }

        // calculate stats
        double average = calculateAverage(scores);

        int initialGrade = scores.get(0);
        int highestGrade = initialGrade;
        int lowestGrade = initialGrade;

        for (int score : scores) {
            if (score > highestGrade) {
                highestGrade = score;
            }

            if (score < lowestGrade) {
                lowestGrade = score;
            }
        }

        ArrayList<Integer> letterGradeCount = gradeBandCount(scores);


        String writeFilename = "report.txt";
        writeReport(
            skippedLines,
            scores,
            average,
            highestGrade,
            lowestGrade,
            letterGradeCount,
            writeFilename);
    }

    /**
     * Reads scores from a text file, one score per line.
     * Blank lines are skipped; non-numeric lines are reported and ignored,
     * so only valid integers are collected.
     *
     * @param filename path of the file to read
     * @return list of valid scores found in the file (possibly empty)
     */
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {

                    // Validate that the line is an integer before adding it
                    try {
                        int grade = Integer.parseInt(line.trim());

                        // is the grade valid? (0-100)
                        if (grade >= 0 && grade <= 100) {
                            scores.add(grade);                            
                        } else {
                            System.out.println("There was a grade that was not between 0 and 100.");
                            
                            // update skippedLines count
                            skippedLines++;
                        }
                    } catch (NumberFormatException e) {

                        // Notify there was a none-Integer
                        System.out.println("There was a none Integer in your grades.");

                        // update skippedLines count
                        skippedLines++;
                    }
                // line is empty - update skippedLines
                } else {
                    skippedLines++;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    };

    /**
     * Computes the arithmetic mean of the scores.
     *
     * @param scores list of scores to average
     * @return the average, or 0.0 if the list is empty
     */
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        } else {
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }

            return (double) sum / scores.size();

        }
    }

    /**
     * Counts how many scores fall into each letter-grade band:
     * A (90+), B (80-89), C (70-79), D (60-69), F (below 60).
     *
     * @param scores list of scores to classify
     * @return list of five counts in the order [A, B, C, D, F]
     */
    public static ArrayList<Integer> gradeBandCount(ArrayList<Integer> scores) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {

            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        ArrayList<Integer> gradeband = new ArrayList<>();
        gradeband.add(countA);
        gradeband.add(countB);
        gradeband.add(countC);
        gradeband.add(countD);
        gradeband.add(countF);

        return gradeband;
    }

    /**
     * Prints the report to the console and writes it to the output file.
     *
     * @param scores     the list of scores that was analyzed
     * @param avg        the average score
     * @param high       the highest score
     * @param low        the lowest score
     * @param outputFile name of the file the report is written to
     */
    public static void writeReport(
            int skippedLines,
            ArrayList<Integer> scores,
            double avg,
            int high,
            int low,
            ArrayList<Integer> bands,
            String outputFile) {

        // Create BufferedWriter and FileWriter to write to report.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writeLine(writer, "");

            writeLine(writer, "=== Grade Analysis Report ===");
            writeLine(writer, String.format("Invalid lines: %d", skippedLines));

            writeLine(writer, "");

            writeLine(writer, String.format("Average score: %.2f", avg));
            writeLine(writer, String.format("Highest score: %d", high));
            writeLine(writer, String.format("Lowest score:  %d", low));

            writeLine(writer, "");

            writeLine(writer, "Grade distribution:");
            writeLine(writer, String.format("%-14s %d", "A (90-100):", bands.get(0)));
            writeLine(writer, String.format("%-14s %d", "B (80-89):", bands.get(1)));
            writeLine(writer, String.format("%-14s %d", "C (70-79):", bands.get(2)));
            writeLine(writer, String.format("%-14s %d", "D (60-69):", bands.get(3)));
            writeLine(writer, String.format("%-14s %d", "F (below 60):", bands.get(4)));

            // Catch if error writing to file
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
    }

    // writeReport helper
    public static void writeLine(BufferedWriter writer, String line) throws IOException {
        // Write the line
        writer.append(line);

        // new line
        writer.newLine();

        // Output to terminal
        System.out.println(line);

    }
}