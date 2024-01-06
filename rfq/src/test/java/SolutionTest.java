import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    Rfq rfq;

    @BeforeEach
    void beforeEachTestMethod() {
        rfq = new Rfq();
    }

    // @formatter:off
    /**
     * The problem is split into three parts. Start with the first one, then follow up with the second
     * and the third part. See part 2 description on line 207, the part 3 description is on the line 282
     *
     * <p>We will be writing a Request For Quote (RFQ) class. Each instance should keep track of all
     * statuses that are applied to that instance.
     *
     * <p>There are 3 possible processes: - out_for_pricing - revise_and_resubmit - under_review
     *
     * <p>Each process has a set/static duration (the number of days it is expected to be active) and
     * belongs in a hierarchy. An RFQ can have any number of processes applied to them at any day.
     * However, an RFQ shows only one active status at time. This is determined by whether the status is
     * active during a given day, and the status's rank in the hierarchy. Below is the status hierarchy
     * from strongest to weakest, and the number of days that they are active.
     *
     * <p>Hierarchy out_for_pricing > revise_and_resubmit > under_review
     *
     * <p>Durations - out_for_pricing - 7 days - revise_and_resubmit - 4 days - under_review - 10 days
     *
     * <p>Example: - (A) out_for_pricing on day 2 - (B) revise_and_resubmit on day 6 - (C) under_review
     * on day 1
     *
     * <p>A A A A A A A B B B B C C C C C C C C C C 1 2 3 4 5 6 7 8 9 10
     */
    // @formatter:on

    @Test
    void handlesOneStatusAtATime() {
        rfq.apply(Status.OUT_FOR_PRICING, 1);
        rfq.apply(Status.REVISE_AND_RESUBMIT, 9);

        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(1));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(2));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(3));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(4));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(5));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(6));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(7));
        // OUT_FOR_PRICING expires
        assertEquals(List.of(), rfq.statusAt(8));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(9));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(10));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(11));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(12));
        // REVISE_AND_RESUBMIT expires
        assertEquals(List.of(), rfq.statusAt(13));
    }

    @Test
    void handlesTwoStatuses() {
        rfq.apply(Status.UNDER_REVIEW, 1);
        rfq.apply(Status.REVISE_AND_RESUBMIT, 4);

        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(1));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(2));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(3));
        // at day 4, REVISE_AND_RESUBMIT should be returned, even
        // though UNDER_REVIEW has not expired. REVISE_AND_RESUBMIT is stronger
        // so REVISE_AND_RESUBMIT should be returned for as long as it is
        // the strongest status.
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(4));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(5));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(6));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(7));
        // REVISE_AND_RESUBMIT   expires, UNDER_REVIEW takes over again
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(8));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(9));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(10));
        assertEquals(List.of(), rfq.statusAt(11));
    }

    @Test
    void handlesMultipleStatuses() {
        rfq.apply(Status.UNDER_REVIEW, 2);
        rfq.apply(Status.OUT_FOR_PRICING, 3);
        rfq.apply(Status.REVISE_AND_RESUBMIT, 7);

        assertEquals(List.of(), rfq.statusAt(1));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(2));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(3));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(4));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(5));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(6));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(7));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(8));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(9));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(10));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(11));
        assertEquals(List.of(), rfq.statusAt(12));
    }

    @Test
    void handlesStatusesAppliedMultipleTimes() {
        rfq.apply(Status.UNDER_REVIEW, 1);
        rfq.apply(Status.REVISE_AND_RESUBMIT, 7);
        rfq.apply(Status.UNDER_REVIEW, 9);

        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(1));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(2));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(3));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(4));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(5));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(6));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(7));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(8));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(9));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(10));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(11));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(12));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(13));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(14));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(15));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(16));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(17));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(18));
        assertEquals(List.of(), rfq.statusAt(19));
    }

    @Test
    void handlesMultipleStatusesAppliedMultipleTimes() {
        rfq.apply(Status.UNDER_REVIEW, 1);
        rfq.apply(Status.REVISE_AND_RESUBMIT, 3);
        rfq.apply(Status.OUT_FOR_PRICING, 4);
        rfq.apply(Status.UNDER_REVIEW, 5);
        rfq.apply(Status.OUT_FOR_PRICING, 6);
        rfq.apply(Status.UNDER_REVIEW, 8);
        rfq.apply(Status.REVISE_AND_RESUBMIT, 10);

        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(1));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(2));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(3));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(4));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(5));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(6));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(7));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(8));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(9));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(10));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(11));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(12));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(13));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(14));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(15));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(16));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(17));
        assertEquals(List.of(), rfq.statusAt(18));
    }

    /**
     * Construction processes also are impacted by delays.
     * <p>
     * In addition to the 3 statuses already available (tier 1), there are 2 additional statuses that need to be considered (tier 2): “awaiting_approval” and “closed”.
     * This means an RFQ can be hold two active statuses, one in each tier. However, for when the status is closed there is no tier 1 status.
     * The "closed" status also has an "indefinite" duration.
     * <p>
     * --- Hierarchy---
     * T2: closed > awaiting_approval
     * T1: out_for_pricing > revise_and_resubmit > under_review
     * <p>
     * --- Durations ---
     * - awaiting_approval     -  6 days
     * - closed                -  indefinite
     */
   @Test
    void handlesAwaitingApproval() {
        rfq.apply(Status.UNDER_REVIEW, 1);
        rfq.apply(Status.AWAITING_APPROVAL, 6);
        rfq.apply(Status.UNDER_REVIEW, 8);
        rfq.apply(Status.AWAITING_APPROVAL, 9);
        rfq.apply(Status.OUT_FOR_PRICING, 10);

        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(1));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(2));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(3));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(4));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(5));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(6));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(7));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(8));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(9));
        assertEquals(List.of(Status.OUT_FOR_PRICING, Status.AWAITING_APPROVAL), rfq.statusAt(10));
        assertEquals(List.of(Status.OUT_FOR_PRICING, Status.AWAITING_APPROVAL), rfq.statusAt(11));
        assertEquals(List.of(Status.OUT_FOR_PRICING, Status.AWAITING_APPROVAL), rfq.statusAt(12));
        assertEquals(List.of(Status.OUT_FOR_PRICING, Status.AWAITING_APPROVAL), rfq.statusAt(13));
        assertEquals(List.of(Status.OUT_FOR_PRICING, Status.AWAITING_APPROVAL), rfq.statusAt(14));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(15));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(16));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(17));
        assertEquals(List.of(), rfq.statusAt(18));
    }

   @Test
    void handlesClosed() {
        rfq.apply(Status.UNDER_REVIEW, 1);
        rfq.apply(Status.AWAITING_APPROVAL, 6);
        rfq.apply(Status.CLOSED, 8);
        rfq.apply(Status.AWAITING_APPROVAL, 12);
        rfq.apply(Status.OUT_FOR_PRICING, 14);

        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(1));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(2));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(3));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(4));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(5));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(6));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(7));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(8));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(9));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(10));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(11));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(12));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(13));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(14));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(15));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(16));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(17));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(18));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(19));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(20));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(21));
        assertEquals(List.of(Status.CLOSED), rfq.statusAt(22));
    }

    /**
     * Construction processes also are impacted by estimations.
     * <p>
     * In addition to the 5 statuses already available, there are 2 additional statuses that need to be considered (tier 3): “rough_estimate” and “final_estimate”.
     * This means an RFQ can be hold three active statuses, one in each tier. However, for when the status is "final_estimate" there is no tier 1 or 2 status.
     * <p>
     * --- Hierarchy---
     * T3: final_estimate > rough_estimate
     * T2: closed > awaiting_approval
     * T1: out_for_pricing > revise_and_resubmit > under_review
     * <p>
     * --- Durations ---
     * - rough_estimate  -  3 days
     * - final_estimate  -  2 days
     */

    @Test
    void handlesRoughEstimate() {
        rfq.apply(Status.UNDER_REVIEW, 1);
        rfq.apply(Status.AWAITING_APPROVAL, 3);
        rfq.apply(Status.ROUGH_ESTIMATE, 5);

        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(1));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(2));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(3));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(4));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL, Status.ROUGH_ESTIMATE), rfq.statusAt(5));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL, Status.ROUGH_ESTIMATE), rfq.statusAt(6));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL, Status.ROUGH_ESTIMATE), rfq.statusAt(7));
        assertEquals(List.of(Status.UNDER_REVIEW, Status.AWAITING_APPROVAL), rfq.statusAt(8));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(9));
        assertEquals(List.of(Status.UNDER_REVIEW), rfq.statusAt(10));
        assertEquals(List.of(), rfq.statusAt(11));
    }

   @Test
    void handlesFinalEstimate() {
        rfq.apply(Status.REVISE_AND_RESUBMIT, 2);
        rfq.apply(Status.AWAITING_APPROVAL, 3);
        rfq.apply(Status.FINAL_ESTIMATE, 4);

        assertEquals(List.of(), rfq.statusAt(1));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT), rfq.statusAt(2));
        assertEquals(List.of(Status.REVISE_AND_RESUBMIT, Status.AWAITING_APPROVAL), rfq.statusAt(3));
        assertEquals(List.of(Status.FINAL_ESTIMATE), rfq.statusAt(4));
        assertEquals(List.of(Status.FINAL_ESTIMATE), rfq.statusAt(5));
        assertEquals(List.of(Status.AWAITING_APPROVAL), rfq.statusAt(6));
        assertEquals(List.of(Status.AWAITING_APPROVAL), rfq.statusAt(7));
        assertEquals(List.of(Status.AWAITING_APPROVAL), rfq.statusAt(8));
        assertEquals(List.of(), rfq.statusAt(9));
    }

    @Test
    void handlesFinalEstimateAfterRoughEstimate() {
        rfq.apply(Status.OUT_FOR_PRICING, 1);
        rfq.apply(Status.ROUGH_ESTIMATE, 2);
        rfq.apply(Status.FINAL_ESTIMATE, 3);

        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(1));
        assertEquals(List.of(Status.OUT_FOR_PRICING, Status.ROUGH_ESTIMATE), rfq.statusAt(2));
        assertEquals(List.of(Status.FINAL_ESTIMATE), rfq.statusAt(3));
        assertEquals(List.of(Status.FINAL_ESTIMATE), rfq.statusAt(4));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(5));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(6));
        assertEquals(List.of(Status.OUT_FOR_PRICING), rfq.statusAt(7));
        assertEquals(List.of(), rfq.statusAt(8));
    }
}


// Your previous Plain Text content is preserved below:

// Pad for Mostafa Elsaghir - Senior Software Engineer