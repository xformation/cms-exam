package com.synectiks.exam.repository.search;

import com.synectiks.exam.domain.User;
import com.synectiks.exam.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends JPASearchRepository<User, Long> {
}
