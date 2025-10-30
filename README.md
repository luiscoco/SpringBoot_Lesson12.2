# SpringBoot_Lesson12.2

## Propmt for the Code Agent (Codex, Gemini Code Assistant or Copilot)

**Context**:

My Spring Boot 3.3 application is already configured for tracing.

I now want to add a custom span around a specific business method to measure its performance, using only the existing TaskController/TaskService/Task code (no new Product classes).

**Task**:

Create a custom span for a method within the TaskService and have TaskController call it.

**Constraints**:

The custom span should be named "check-inventory-status".

The method should simulate a delay.

**Steps**:

Assume a TaskService class exists.

Create a new public method in TaskService called getInventoryStatus(Long taskId).

Inside the method, simulate a 300ms delay using Thread.sleep(300).

Annotate the method with Micrometer Tracing’s @NewSpan(name = "check-inventory-status").

Modify the existing TaskController GET /tasks/{id} handler to call taskService.getInventoryStatus(id) before returning the task.

Provide instructions to rebuild, run, and test.

**Deliverables**:

The full code for the modified TaskService method:

@NewSpan(name = "check-inventory-status")

public String getInventoryStatus(Long taskId) {

try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

return "IN_STOCK";

}

The line to add to TaskController:

taskService.getInventoryStatus(id);

Verification steps: Explain how to find the new trace in Jaeger and what to look for (the custom "check-inventory-status" span). 

Include that the service name is product-service and the span should be a child of the controller’s main span with ~300ms duration.

**Acceptance Criteria**:

The application compiles and runs.

When a request is made to GET /tasks/{id} and you view the trace in Jaeger, you see a new span named "check-inventory-status".

This new span is a child of the controller’s main HTTP span.

The duration of the "check-inventory-status" span is approximately 300ms, clearly visible in the trace timeline.
