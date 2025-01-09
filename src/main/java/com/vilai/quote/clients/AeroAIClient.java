package com.vilai.quote.clients;

import ai.chargebee.Result;
import ai.chargebee.models.Task;
import ai.chargebee.AeroAIEnvironment;
import org.json.JSONObject;

public class AeroAIClient {

    public String init(String prompt) throws Exception {
        AeroAIEnvironment clientEnv = AeroAIEnvironment.configure()
                .setConsumerAppName("your-ms-app-name")
                .setTaskDefnBranch("preview#maadhava.muralidharan@chargebee.com")
                .setSandboxAPIKey("sk-aero-ai-sandbox-8c64abff-94c8-474a-ad47-9d96cf4ecd28")
                .setSiteName("hackathon-2025");

        JSONObject input = new JSONObject()
                .put("User Query", prompt);

        Task.CreateRequest request = Task.create()
                .taskDefnId("test.hackathon_task_1")
                .taskInput(input);

        // Send the request and get the result
        Result result = request.request();

        // Retrieve the task from the result
        Task task = result.task();
        System.out.println("Task Result: " + task.result());
        return task.result().toString();
    }
}