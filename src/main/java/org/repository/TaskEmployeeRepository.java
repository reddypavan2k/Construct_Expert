package org.repository;

import java.sql.SQLException;

public interface TaskEmployeeRepository {
    void AffectEmployeeToTask(Long idTask, Long idEmployee) throws SQLException, ClassNotFoundException;
    void UpdateEmployeeAvailability(Long id) throws SQLException, ClassNotFoundException;
}
