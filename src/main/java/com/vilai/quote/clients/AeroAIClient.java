package com.vilai.quote.clients;

import ai.chargebee.Result;
import ai.chargebee.models.Task;
import ai.chargebee.AeroAIEnvironment;
import com.vilai.quote.models.QuotePromptRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AeroAIClient {

    @Value("${aero.ai.consumer.name}")
    private String consumerAppName;

    @Value("${aero.ai.task.defn.branch}")
    private String taskDefnBranch;

    @Value("${aero.ai.sandbox.api.key}")
    private String sandboxApiKey;

    @Value("${aero.ai.site.name}")
    private String siteName;

    private AeroAIEnvironment clientEnv;

    // Initialize the AeroAIEnvironment
    public void init() {
        clientEnv = AeroAIEnvironment.configure()
                .setConsumerAppName(consumerAppName)
                .setTaskDefnBranch(taskDefnBranch)
                .setSandboxAPIKey(sandboxApiKey)
                .setSiteName(siteName);
    }

    public String retrievePrompt(QuotePromptRequest prompt) throws Exception {
        if (clientEnv == null) {
            throw new IllegalStateException("AeroAIEnvironment is not initialized. Call init() first.");
        }

        System.out.println(prompt.getContractStartDate());
        System.out.println(prompt.getContractEndDate());
        JSONObject input = new JSONObject().put("query", prompt.getPrompt())
                .put("contract_date_from", String.valueOf(prompt.getContractStartDate()))
                .put("contract_date_to", String.valueOf(prompt.getContractEndDate()));

        Task.CreateRequest request = Task.create()
                .taskDefnId("test.hackathon_task_2")
                .taskInput(input);

        // Send the request and get the result
        Result result = request.request();

        // Retrieve the task from the result
        Task task = result.task();
        System.out.println("Task Result: " + task.result());
        return task.result().toString();
    }
}