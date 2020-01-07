package com.youxuan.common.utils.result;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Jebe
 * @Date: 2019/12/19 11:14
 * @Desc 分页记过对象
 */
public class PageResult<T> {

    /**
     * 总共多少页
     */
    private Long totalPage;

    /**
     * 当前页
     */
    private Long currentPage;

    /**
     * 一页多少条
     */
    private Long pageSize;

    /**
     * 总共多少条数据
     */
    private Long totalSize;

    /**
     * 结果数据，code：200
     */
    private List<T> list = Collections.emptyList();

    /**
     * 扩展信息内容
     */
    private Object extra;

    public PageResult(Long totalPage, Long currentPage, Long pageSize) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public PageResult(Long totalPage, Long currentPage, Long pageSize, List<T> list) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.list = list;
    }

    public PageResult(Long totalPage, Long currentPage, Long pageSize, Long totalSize, List<T> list) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.list = list;
    }

    public PageResult( Long totalPage, Long currentPage, Long pageSize, Long totalSize, List<T> list, Object extra) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.list = list;
        this.extra = extra;
    }

    PageResult() {
    }

    public Object getExtra() {
        return extra;
    }

    public PageResult<T> setExtra(Object extra) {
        this.extra = extra;
        return this;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public PageResult<T> setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public PageResult<T> setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public PageResult<T> setPageSize(Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public List<T> getList() {
        return this.list;
    }

    public PageResult<T> setList(List<T> list) {
        this.list = list;
        return this;
    }
    
    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }
}
