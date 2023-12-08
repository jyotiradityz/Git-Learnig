import java.util.*;

public class CommitteeExecutionOrder {
    private Map<String, List<String>> dependencies;
    private Map<String, Boolean> visited;
    private List<String> executionOrder;
    private Set<String> committees;

    public CommitteeExecutionOrder() {
        dependencies = new HashMap<>();
        visited = new HashMap<>();
        executionOrder = new ArrayList<>();
        committees = new HashSet<>();
    }

    public void addDependency(String committee, List<String> dependentOn) {
        dependencies.put(committee, dependentOn);
        committees.add(committee);
        for (String dependent : dependentOn) {
            committees.add(dependent);
        }
    }

    public List<String> topologicalSort() {
        for (String committee : committees) {
            visited.put(committee, false);
        }

        for (String committee : committees) {
            if (!visited.get(committee)) {
                dfs(committee);
            }
        }

        Collections.reverse(executionOrder);
        return executionOrder;
    }

    private void dfs(String committee) {
        visited.put(committee, true);
        List<String> dependents = dependencies.get(committee);
        if (dependents != null) {
            for (String dependent : dependents) {
                if (!visited.get(dependent)) {
                    dfs(dependent);
                }
            }
        }
        executionOrder.add(committee);
    }

    public static void main(String[] args) {
        CommitteeExecutionOrder acses = new CommitteeExecutionOrder();

        // Define dependencies based on the provided information
        acses.addDependency("Review Board", Arrays.asList("Registration", "Paper", "Poster"));
        acses.addDependency("Hospitality", Arrays.asList("Finance", "Food"));
        acses.addDependency("Registration", Arrays.asList("Finance"));
        acses.addDependency("Finance", Arrays.asList("Approval from TEQIP coordinator"));
        acses.addDependency("Session", Arrays.asList("Approval from TEQIP coordinator", "Review Board"));
        acses.addDependency("Approval from TEQIP coordinator", Arrays.asList("Review Board"));
        acses.addDependency("Approval from director", Arrays.asList("Review Board"));
        acses.addDependency("Food", Arrays.asList("Finance"));

        List<String> linearOrder = acses.topologicalSort();

        // Output the linear order of execution
        System.out.println("Linear Order of Execution:");
        for (String committee : linearOrder) {
            System.out.println(committee);
        }
    }
}
