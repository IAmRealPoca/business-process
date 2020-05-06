package com.company.businessprocess.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;

//@NoArgsConstructor
//@AllArgsConstructor
public class PagingAndSortingBuilder {
    public static Pageable buildPageableObj(Integer page, Integer size, String sortField, String sortOrder) {
        Sort.Direction direction = Sort.Direction.ASC;
        if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
            direction = Sort.Direction.fromString(sortOrder);
        }
        if (ObjectUtils.isEmpty(page)) {
            page = 0;
        }
        if (ObjectUtils.isEmpty(size)) {
            size = Integer.MAX_VALUE;
        }

        if (!BusinessProcessStringUtils.isBlankAndEmpty(sortField)) {
            Sort sort = Sort.by(direction, sortField);
            Pageable pageable = PageRequest.of(page, size, sort);
            return pageable;
        } else {
            Pageable pageable = PageRequest.of(page, size);
            return pageable;
        }
    }

    public static Pageable buildPageableObj(PagingAndSortingOption option) {
        return buildPageableObj(option.getPage(), option.getSize(), option.getSortField(), option.getSortOrder());
    }
}
