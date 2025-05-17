package org.tutorials.response;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Data
public class ApiResponse<T> {
    private String code;
    private String title;
    private String message;
    private Data<T> data;
    private String traceId;

    @lombok.Data
    public static class Data<T> {
        private List<T> rows;
        private PageInfo page;
    }

    @lombok.Data
    public static class PageInfo {
        private int pageNumber;
        private int pageSize;
        private long totalElements;
        private int totalPages;
    }

    public static <T> ApiResponse<T> success(Page<T> page) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode("S0001");
        response.setMessage("Success.");
        response.setTraceId(UUID.randomUUID().toString());

        Data<T> data = new Data<>();
        data.setRows(page.getContent());

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNumber(page.getNumber());
        pageInfo.setPageSize(page.getSize());
        pageInfo.setTotalElements(page.getTotalElements());
        pageInfo.setTotalPages(page.getTotalPages());

        data.setPage(pageInfo);
        response.setData(data);

        return response;
    }

    public static <T> ApiResponse<T> success(T item) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode("S0001");
        response.setMessage("Success.");
        response.setTraceId(UUID.randomUUID().toString());

        Data<T> data = new Data<>();
        data.setRows(item != null ? Collections.singletonList(item) : Collections.emptyList());

        response.setData(data);

        return response;
    }

    public static <T> ApiResponse<T> success() {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode("S0001");
        response.setMessage("Success.");
        response.setTraceId(UUID.randomUUID().toString());

        Data<T> data = new Data<>();
        data.setRows(Collections.emptyList());

        response.setData(data);

        return response;
    }

    public static <T> ApiResponse<T> error(String code, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(null);
        return response;
    }

}