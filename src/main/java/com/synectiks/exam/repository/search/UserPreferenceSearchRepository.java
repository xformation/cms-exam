package com.synectiks.exam.repository.search;

import com.synectiks.exam.domain.UserPreference;
import com.synectiks.exam.utils.JPASearchRepository;

/**
// * Spring Data Elasticsearch repository for the {@link //UserPreference} entity.
 */
public interface UserPreferenceSearchRepository extends JPASearchRepository<UserPreference, Long> {
}
