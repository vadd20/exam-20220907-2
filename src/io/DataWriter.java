package io;

import entity.Realty;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class DataWriter {

    private static final String RESULT_FILENAME = "data\\result.txt";

    public static void write(List<Realty> realties) throws IOException {
        try (var bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RESULT_FILENAME)))) {
            for (Realty realty : realties) {
                var sb = new StringBuilder()
                        .append(realty.getType()).append(", ").append(realty.getAddress()).append(" - ")
                        .append(realty.getIntersections());
                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }
}
