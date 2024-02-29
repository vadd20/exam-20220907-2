import entity.Realty;
import entity.Visit;

import java.util.Comparator;
import java.util.List;

public class DataProcessor {

    public List<Realty> process(List<Visit> visits, List<Realty> realties) {

        for (int i = 0; i < visits.size(); i++) {
            for (int j = i + 1; j < visits.size(); j++) {
                Visit firstVisit = visits.get(i);
                Visit secondVisit = visits.get(j);
                if (firstVisit.realty().equals(secondVisit.realty())
                        && (secondVisit.from().isAfter(firstVisit.from()) && secondVisit.from().isBefore(firstVisit.to())
                        || secondVisit.to().isAfter(firstVisit.from()) && secondVisit.to().isBefore(firstVisit.to()))) {
                    firstVisit.realty().setIntersections(firstVisit.realty().getIntersections() + 1);
                }
            }
        }

        return sortRealties(realties);
    }

    private List<Realty> sortRealties(List<Realty> realties) {
        return realties.stream()
                .sorted(Comparator
                        .comparing(Realty::getIntersections).reversed()
                        .thenComparing(Realty::getType)
                        .thenComparing(Realty::getAddress)).toList();
    }
}
