// src/main/java/com/example/demoapp/repository/SoftwareRepository.java
package com.example.demoapp.repository;

import com.example.demoapp.model.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SoftwareRepository extends JpaRepository<Software, Long> {
    List<Software> findByUploadedBy(String uploadedBy);
    
    // Add category-related queries
    List<Software> findByCategory(String category);
    
    // Get distinct categories
    @Query("SELECT DISTINCT s.category FROM Software s WHERE s.category IS NOT NULL")
    List<String> findDistinctCategories();
}
