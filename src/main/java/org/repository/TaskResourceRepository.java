package org.repository;


import org.dto.ResourceDTO;

import java.sql.SQLException;
import java.util.List;

public interface TaskResourceRepository {
    void AffectResourceToTask(Long id, List<ResourceDTO> resourceDTOList) throws SQLException, ClassNotFoundException;
    void UpdateResourceQuantity(List<ResourceDTO> resourceDTOList) throws SQLException, ClassNotFoundException;
}
