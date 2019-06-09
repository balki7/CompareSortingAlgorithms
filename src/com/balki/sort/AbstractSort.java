package com.balki.sort;


/**
 * @author Balkı
 * @since 23/03/2019
 */
public abstract class AbstractSort implements Sort {
    private long numberOfComparisons;
    private long numberOfAssignments;

    public AbstractSort(){
        numberOfComparisons = 0;
        numberOfAssignments = 0;
    }

    @Override
    public long getNumberOfComparisons() {
        return this.numberOfComparisons;
    }

    @Override
    public long getNumberOfAssignments() {
        return this.numberOfAssignments;
    }

    @Override
    public void reset(){
        this.numberOfComparisons = 0;
        this.numberOfAssignments = 0;
    }

    protected void incComparisons(){
        this.numberOfComparisons++;
    }

    protected void incAssignments(){
        this.numberOfAssignments++;
    }
}
