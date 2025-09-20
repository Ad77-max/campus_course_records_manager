package edu.ccrm.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generic searchable interface using generics
 * Demonstrates generic interface with type parameters and functional interfaces
 * @param <T> Type of entity to search
 */
public interface Searchable<T> {
    
    /**
     * Search entities based on custom criteria
     * @param criteria Predicate function to filter entities
     * @return List of matching entities
     */
    List<T> search(Predicate<T> criteria);
    
    /**
     * Find entity by unique identifier
     * @param id Unique identifier
     * @return Optional containing the entity if found
     */
    Optional<T> findById(String id);
    
    /**
     * Get all entities
     * @return List of all entities
     */
    List<T> findAll();
    
    /**
     * Count total entities
     * @return Total count of entities
     */
    default long count() {
        return findAll().size();
    }
    
    /**
     * Check if entity exists by ID
     * @param id Entity identifier
     * @return true if entity exists
     */
    default boolean exists(String id) {
        return findById(id).isPresent();
    }
    
    /**
     * Check if any entities exist
     * @return true if at least one entity exists
     */
    default boolean isEmpty() {
        return count() == 0;
    }
}