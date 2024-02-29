package entity;

import java.time.LocalDateTime;

public record Visit(Employee employee, Realty realty, LocalDateTime from, LocalDateTime to) {
}
