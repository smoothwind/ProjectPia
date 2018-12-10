package com.rdd.pia.repositories;

import com.rdd.pia.model.ArchivedPiaUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author mic
 */
@Repository
public interface ArchiveUserJpaRepository  extends CrudRepository<ArchivedPiaUser,Long>{
    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity must not be {@literal null}.
     * @return the saved entity will never be {@literal null}.
     */
    @Override
    <S extends ArchivedPiaUser> S save(S entity);
}
