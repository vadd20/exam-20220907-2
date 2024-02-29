package io;

import entity.Employee;
import entity.Realty;
import entity.Visit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DataLoader {

    private static final String EMPLOYEE_FILENAME = "data\\employee.csv";
    private static final String REALTY_FILENAME = "data\\realty.csv";
    private static final String VISIT_FILENAME = "data\\visit.csv";
    private static final String SEPARATOR = ";";

    /**
     * Чтение сущностей сотрудников из файла.
     *
     * @return список сущностей сотрудников
     */
    private static List<Employee> readEmployeeData() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(EMPLOYEE_FILENAME))) {
            return lines
                    .map(line -> line.split(SEPARATOR))
                    .map(data -> new Employee(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3]
                    ))
                    .toList();
        }
    }

    public static List<Realty> readRealtyData() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(REALTY_FILENAME))) {
            return lines
                    .map(line -> line.split(SEPARATOR))
                    .map(data -> new Realty(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2]
                    ))
                    .toList();
        }
    }

    public static List<Visit> readVisitData(List<Realty> realties) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        List<Employee> employees = readEmployeeData();

        try (Stream<String> lines = Files.lines(Paths.get(VISIT_FILENAME))) {
            return lines
                    .map(line -> line.split(SEPARATOR))
                    .map(data -> new Visit(
                                    Employee.findById(employees, Long.parseLong(data[0])),
                                    Realty.findById(realties, Long.parseLong(data[1])),
                                    LocalDateTime.parse(data[2], formatter),
                                    LocalDateTime.parse(data[3], formatter)
                            )
                    ).toList();
        }
    }


}