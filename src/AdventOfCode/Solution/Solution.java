package AdventOfCode.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<int[]> readInputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> reports = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            reports.add(arr);
        }
        return reports;
    }

    private static boolean isSafe(int[] report) {
        int length = report.length;
        boolean increasing = false, decreasing = false;
        for (int i = 0; i < length - 1; i++) {
            if (report[i] > report[i + 1]) {
                decreasing = true;
            } else if (report[i] < report[i + 1]) {
                increasing = true;
            }
            if ((increasing && decreasing) || (report[i] == report[i + 1])) {
                return false;
            }
        }
        for (int i = 0; i < length - 1; i++) {
            if (Math.abs(report[i] - report[i + 1]) > 3) {
                return false;
            }
        }
        return true;
    }
    public static int redNosedReport() throws IOException {
        List<int[]> reports = readInputs();
        int safe = 0;
        for(int[] report : reports) {
            if(isSafe(report))
                safe++;
        }
        return safe;
    }

    public static void main(String[] args) throws IOException {
        int solution = redNosedReport();
        System.out.println(solution);
    }
}
