package com.example.onlinelibrary.utils;

import java.util.List;

/**
 * Class Page description goes here.
 *
 * @version 1.0, 2013-2-3
 */
public class Page {

    // Warnings

    /** Field description */
    public static final int warnings = 0;

    // Zero

    /** Field description */
    public static final int ZERO = 0;

    // One

    /** Field description */
    public static final int ONE = 1;

    // The default page size

    /** Field description */
    public static final int DEFAULT_PAGESIZE = 10;

    // The default page number

    /** Field description */
    public static final int DEFAULT_PAGENUM = 1;

    // The default total count

    /** Field description */
    public static final int DEFAULT_TOTALCOUNT = ZERO;
    private int             pageSize           = DEFAULT_PAGESIZE;
    private int             totalCount         = DEFAULT_TOTALCOUNT;
    private int             totalPage          = DEFAULT_PAGENUM;
    private int             pageNum            = DEFAULT_PAGENUM;
    private List<?>         items;

    /**
     *
     * Constructor Page documentation comment.
     *
     */
    public Page() {}

    /**
     *
     * Constructor Page documentation comment.
     *
     * @param items
     *            items of page
     * @param totalCount
     *            total count
     */
    public Page(List<?> items, int totalCount) {
        setItems(items);
        setTotalCount(totalCount);
        setTotalPage(calculateTotalPage());
    }

    /**
     *
     * Constructor Page documentation comment.
     *
     * @param items
     *            items of page
     * @param totalCount
     *            total count
     * @param pageNum
     *            page number
     */
    public Page(List<?> items, int totalCount, int pageNum) {
        setItems(items);
        setTotalCount(totalCount);
        setTotalPage(calculateTotalPage());
        setPageNum(pageNum);
    }

    /**
     *
     * Constructor Page documentation comment.
     *
     * @param items
     *            items of page
     * @param totalCount
     *            total count
     * @param pageNum
     *            page number
     * @param pageSize
     *            page size
     */
    public Page(List<?> items, int totalCount, int pageNum, int pageSize) {
        setItems(items);
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setTotalPage(calculateTotalPage());
        setPageNum(pageNum);
    }

    /**
     *
     * Method calculateTotalPage documentation comment.
     *
     * @return total page
     */
    public final int calculateTotalPage() {
        return (totalCount == ZERO)
               ? DEFAULT_PAGENUM
               : (totalCount % pageSize == ZERO)
                 ? totalCount / pageSize
                 : DEFAULT_PAGENUM + totalCount / pageSize;
    }

    /**
     *
     * Method currentPage documentation comment.
     *
     * @return page number
     */
    public final int currentPage() {
        return pageNum;
    }

    /**
     *
     * Method firstPage documentation comment.
     *
     * @return first page
     */
    public final int firstPage() {
        return DEFAULT_PAGENUM;
    }

    /**
     *
     * Method lastPage documentation comment.
     *
     * @return total page
     */
    public final int lastPage() {
        return totalPage;
    }

    /**
     *
     * Method nextPage documentation comment.
     *
     * @return next page
     */
    public final int nextPage() {
        int nextPage = pageNum + ONE;

        return (nextPage <= totalPage)
               ? nextPage
               : totalPage;
    }

    /**
     *
     * Method previousPage documentation comment.
     *
     * @return previous page
     */
    public final int previousPage() {
        int previousPage = pageNum - ONE;

        return (previousPage >= DEFAULT_PAGENUM)
               ? previousPage
               : DEFAULT_PAGENUM;
    }

    /**
     *
     * Method retrievePage documentation comment.
     *
     * @param totalCount
     *            total count
     */
    public final void retrievePage(int totalCount) {
        setTotalCount(totalCount);
        setTotalPage(calculateTotalPage());
        retrievePageNum();
    }

    /**
     *
     * Method retrievePageNum documentation comment.
     *
     */
    private void retrievePageNum() {
        this.pageNum = (pageNum <= DEFAULT_PAGENUM)
                       ? DEFAULT_PAGENUM
                       : (pageNum <= totalPage)
                         ? pageNum
                         : totalPage;
    }

    /**
     *
     * Method getItems documentation comment.
     *
     * @return page items
     */
    public final List<?> getItems() {
        return items;
    }

    /**
     *
     * Method setItems documentation comment.
     *
     * @param items
     *            page items
     */
    public final void setItems(List<?> items) {
        this.items = items;
    }

    /**
     *
     * Method getPageNum documentation comment.
     *
     * @return page number
     */
    public final int getPageNum() {
        return pageNum;
    }

    /**
     *
     * Method setPageNum documentation comment.
     *
     * @param pageNum
     *            page number
     */
    public final void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     *
     * Method getPageSize documentation comment.
     *
     * @return page size
     */
    public final int getPageSize() {
        return pageSize;
    }

    /**
     *
     * Method setPageSize documentation comment.
     *
     * @param pageSize
     *            page size
     */
    public final void setPageSize(int pageSize) {
        this.pageSize = (pageSize <= ZERO)
                        ? DEFAULT_PAGESIZE
                        : pageSize;
    }

    /**
     *
     * Method getTotalCount documentation comment.
     *
     * @return total count
     */
    public final int getTotalCount() {
        return totalCount;
    }

    /**
     *
     * Method setTotalCount documentation comment.
     *
     * @param totalCount
     *            total count
     */
    public final void setTotalCount(int totalCount) {
        this.totalCount = (totalCount <= DEFAULT_TOTALCOUNT)
                          ? DEFAULT_TOTALCOUNT
                          : totalCount;
    }

    /**
     *
     * Method getTotalPage documentation comment.
     *
     * @return total page
     */
    public final int getTotalPage() {
        return totalPage;
    }

    /**
     *
     * Method setTotalPage documentation comment.
     *
     * @param totalPage
     *            total page
     */
    public final void setTotalPage(int totalPage) {
        this.totalPage = (totalPage <= DEFAULT_PAGENUM)
                         ? DEFAULT_PAGENUM
                         : totalPage;
    }
}
