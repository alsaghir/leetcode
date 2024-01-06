import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Rfq {

    private final Map<Status, Integer> t1 =
            Map.of(
                    Status.OUT_FOR_PRICING,
                    7,
                    Status.REVISE_AND_RESUBMIT,
                    4,
                    Status.UNDER_REVIEW,
                    10);
    private final Map<Status, Integer> t2 = Map.of(Status.CLOSED, 0, Status.AWAITING_APPROVAL, 6);
    private final Map<Status, Integer> t3 =
            Map.of(Status.ROUGH_ESTIMATE, 3, Status.FINAL_ESTIMATE, 2);

    private final Map<Integer, List<Status>> statusByDay = new HashMap<>();
    private final List<Integer> closedDays = new LinkedList<>();

    /**
     * Sets a status for a given day, and depending on the status, any following days. Honors status
     * durations, hierarchies, and tiers.
     *
     * @param status Status to be applied for the given day.
     * @param dayNumber Day to apply the status.
     */
    public void apply(Status status, Integer dayNumber) {
        Integer duration = null;
        if (t1.containsKey(status)) {
            duration = t1.get(status);
        } else if (t2.containsKey(status)) {
            duration = t2.get(status);
        } else {
            duration = t3.get(status);
        }

        for (int i = dayNumber; i < dayNumber + duration; i++) {
            statusByDay.computeIfAbsent(i, k -> new ArrayList<>()).add(status);
        }

        if (status == Status.CLOSED) {
            closedDays.add(dayNumber);
            closedDays.sort((o1, o2) -> Integer.compare(o2, o1));
        }

        if (!closedDays.isEmpty() && dayNumber >= closedDays.get(0)) {
            for (int i = closedDays.get(0); i <= closedDays.get(0) + dayNumber + duration; i++) {
                statusByDay.computeIfAbsent(i, k -> new ArrayList<>()).add(Status.CLOSED);
            }
        }
    }

    /**
     * Given a day number, returns a list of status for that day. If multiple status are available,
     * use the order: Tier 1 status, Tier 2 status, Tier 3 status
     *
     * @param dayNumber Day to retrieve the status list for
     * @return List of applicable statuses for the day. If no statuses exist for the day number,
     *     return an empty List
     */
    public List<Status> statusAt(Integer dayNumber) {
        List<Status> result = new ArrayList<>();
        result.add(
                statusByDay.getOrDefault(dayNumber, new ArrayList<>()).stream()
                        .filter(t1::containsKey)
                        .max(Comparator.comparingInt(Status::getPriority))
                        .orElse(null));

        result.add(
                statusByDay.getOrDefault(dayNumber, new ArrayList<>()).stream()
                        .filter(t2::containsKey)
                        .max(Comparator.comparingInt(Status::getPriority))
                        .orElse(null));

        result.add(
                statusByDay.getOrDefault(dayNumber, new ArrayList<>()).stream()
                        .filter(t3::containsKey)
                        .max(Comparator.comparingInt(Status::getPriority))
                        .orElse(null));

        result.removeIf(Objects::isNull);

        if (result.contains(Status.FINAL_ESTIMATE)) return List.of(Status.FINAL_ESTIMATE);
        if (result.contains(Status.CLOSED)) return List.of(Status.CLOSED);

        return result;
    }
}
