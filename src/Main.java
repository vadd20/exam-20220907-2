import entity.Realty;
import entity.Visit;
import io.DataLoader;
import io.DataWriter;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Realty> realties = DataLoader.readRealtyData();
        List<Visit> visits = DataLoader.readVisitData(realties);

        DataProcessor dataProcessor = new DataProcessor();
        List<Realty> processedRealties = dataProcessor.process(visits, realties);

        DataWriter.write(realties);
    }
}