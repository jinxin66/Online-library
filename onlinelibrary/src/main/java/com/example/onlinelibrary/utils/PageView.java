package com.example.onlinelibrary.utils;

/**
 * Class PageView description
 *
 * @version 1.0, 2013-2-3
 */
public class PageView {

    private int[] showPages ;

    public int[] getShowPages() {
        return showPages;
    }

    // The left edge(the head) of the Pages number
    private static final int HEADPAGE = 2;
    /*
     * Using the following three parameter, you can change the pages showing.
     * For example "HEADPAGE-MIDPAGE-TAILPAGE" is "2-5-2" It means that there
     * will be 2 indexes at the left edge, 5 in the middle and 2 at the right
     * edge, other indexes instead by "...". The performance just like this:
     * [1][2]...[4][5][6][7][8]...[11][12]
     */
    // The middle of the Pages number
    private static final int MIDPAGE = 5;
    // The right edge(the tail) of the Pages number
    private static final int TAILPAGE = 2;

    private Page page;

    public void setShowPages(int[] showPages) {
        this.showPages = showPages;
    }

    /**

     * Constructor PageView documentation comment.
     *
     * @param page page
     */
    public PageView(Page page) {
        this.page = page;
        showPages();
    }
/*    public PageView(Page page,String title) {
        this.page = page;
        this.TITLE = title;
    }*/


    /**
     * Method showHeadPages documentation comment.
     *
     * @return head array of page
     */
    private int[] showHeadPages() {
        int currentPage = page.currentPage();
        int[] showHeadPages = new int[0];
        int minPage = currentPage - MIDPAGE / 2;

        if (minPage > 1) {

            // calculate the head length
            int showMidPagesLength = Math.min(minPage - 1, HEADPAGE);

            showHeadPages = new int[showMidPagesLength];

            for (int i = 0; i < showMidPagesLength; i++) {
                showHeadPages[i] = i + 1;
            }
        }

        return showHeadPages;
    }

    /**
     * Method showMidPages documentation comment.
     *
     * @return middle array of page
     */
    private int[] showMidPages() {
        int currentPage = page.currentPage();
        int totalPage = page.getTotalPage();
        int[] showMidPages = new int[0];
        int minPage = currentPage - MIDPAGE / 2;
        int maxPage = currentPage + (MIDPAGE - 1) / 2;

        if ((minPage >= 1) && (maxPage <= totalPage)) {
            showMidPages = new int[MIDPAGE];

            for (int i = 0; i < MIDPAGE; i++) {
                showMidPages[i] = minPage + i;
            }
        } else if (minPage >= 1) {
            int showMidPagesLength = Math.min(MIDPAGE, totalPage - minPage + 1);

            if (totalPage * 2 - (showMidPagesLength + maxPage) > HEADPAGE) {
                showMidPagesLength = showMidPagesLength + maxPage - totalPage;
            }

            showMidPages = new int[showMidPagesLength];

            for (int i = 0; i < showMidPagesLength; i++) {
                showMidPages[i] = totalPage - showMidPagesLength + 1 + i;
            }
        } else if (maxPage <= totalPage) {
            int showMidPagesLength = Math.min(MIDPAGE, maxPage);

            if (showMidPagesLength - minPage + 1 < totalPage - TAILPAGE) {
                showMidPagesLength = showMidPagesLength - minPage + 1;
            }

            showMidPages = new int[showMidPagesLength];

            for (int i = 0; i < showMidPagesLength; i++) {
                showMidPages[i] = 1 + i;
            }
        } else {
            int showMidPagesLength = Math.min(MIDPAGE, totalPage);

            showMidPages = new int[showMidPagesLength];

            for (int i = 0; i < showMidPagesLength; i++) {
                showMidPages[i] = 1 + i;
            }
        }

        return showMidPages;
    }

    /**
     * Method showPages documentation comment.
     *
     * @return array of pages
     */
    public final int[] showPages() {
        int[] head = showHeadPages();
        int[] mid = showMidPages();
        int[] tail = showTailPages();
        int heads = 0;
        int tails = 0;

        /* If it need "..." instead, I use heads and tails to identity */
        if ((0 != head.length) && (0 != mid.length) && (head[head.length - 1] + 1 < mid[0])) {
            heads = 1;
        }

        if ((0 != tail.length) && (0 != mid.length) && (mid[mid.length - 1] + 1 < tail[0])) {
            tails = 1;
        }

        showPages = new int[head.length + mid.length + tail.length + heads + tails];

        for (int i = 0; i < head.length; i++) {
            showPages[i] = head[i];
        }

        // Here, I use "0" identity "..."
        if (heads == 1) {
            showPages[head.length] = 0;
        }

        for (int i = 0; i < mid.length; i++) {
            showPages[head.length + heads + i] = mid[i];
        }

        // The same with heads. Here, I use "0" identity "..."
        if (tails == 1) {
            showPages[head.length + mid.length + heads] = 0;
        }

        for (int i = 0; i < tail.length; i++) {
            showPages[head.length + mid.length + heads + tails + i] = tail[i];
        }

        return showPages;
    }
    
/*    public int[] getShowPages() {
		return showPages();
	}

	public void setShowPages(int[] showPages) {
		this.showPages = showPages;
	}
*/
	public static int getHeadpage() {
		return HEADPAGE;
	}

	public static int getMidpage() {
		return MIDPAGE;
	}

	public static int getTailpage() {
		return TAILPAGE;
	}

	/**
     * Method showTailPages documentation comment.
     *
     * @return tail array of page
     */
    private int[] showTailPages() {
        int currentPage = page.currentPage();
        int totalPage = page.getTotalPage();
        int[] showTailPages = new int[0];
        int maxPage = currentPage + (MIDPAGE - 1) / 2;

        if (maxPage < totalPage) {

            // calculate the tail length
            int showMidPagesLength = Math.min(totalPage - maxPage, TAILPAGE);

            showTailPages = new int[showMidPagesLength];

            for (int i = 0; i < showMidPagesLength; i++) {
                showTailPages[i] = totalPage - showMidPagesLength + i + 1;
            }
        }

        return showTailPages;
    }

    /**
     * Method getPage documentation comment.
     *
     * @return page
     */
    public Page getPage() {
        return page;
    }

    /**
     * Method setPage documentation comment.
     *
     * @param page page
     */
    public final void setPage(Page page) {
        this.page = page;
    }
}
