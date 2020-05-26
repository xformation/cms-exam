package com.synectiks.exam.business.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.synectiks.exam.config.ApplicationProperties;
import com.synectiks.exam.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.synectiks.exam.config.ApplicationProperties;

@Component
public class CommonService {

    private final static Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    RestTemplate restTemplate;

    @Nullable
    public<T> List<T> getList(String url) {
        List<T> temp = this.restTemplate.getForObject(url, List.class);
        return temp;
    }

    @Nullable
    public<T> T getObject(String url, Class<T> cls) {
        T temp = this.restTemplate.getForObject(url, cls);
        return temp;
    }

    public<T> T postObject(String url, Object obj, Class<T> cls) {
        T temp = this.restTemplate.postForObject(url, obj, cls);
        return temp;
    }

    public List<Subject> findAllSubject() {
        logger.debug("Getting all subjects ");
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSubjectUrl = prefUrl+"/api/subject-by-filters";
        Subject[] temp = this.restTemplate.getForObject(prefSubjectUrl, Subject[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Subject> list = Arrays.asList(temp);
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public List<Department> findAllDepartment() {
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefDepartmentUrl = prefUrl+"/api/department-by-filters";
        Department[] temp = this.restTemplate.getForObject(prefDepartmentUrl, Department[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Department> departmentList = Arrays.asList(temp);
        Collections.sort(departmentList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return departmentList;
    }

    public List<Batch> findAllBatches() {
        logger.debug("Retrieving all Batches ");
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBatchUrl = prefUrl+"/api/batch-by-filters";
        Batch[] temp = this.restTemplate.getForObject(prefBatchUrl, Batch[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Batch> batchList = Arrays.asList(temp);
        Collections.sort(batchList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        return batchList;
    }

    public List<Branch> findAllBranch() {
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBranchUrl = prefUrl+"/api/branch-by-filters";
        Branch[] temp = this.restTemplate.getForObject(prefBranchUrl, Branch[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Branch> branchList = Arrays.asList(temp);
        Collections.sort(branchList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return branchList;
    }

    public List<Section> findAllSections() {
        logger.debug("Retrieving all Section");
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/section-by-filters";
        Section[] temp = this.restTemplate.getForObject(prefSectionUrl, Section[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Section> sectionList = Arrays.asList(temp);
        Collections.sort(sectionList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        return sectionList;
    }


}
