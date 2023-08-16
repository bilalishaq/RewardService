package com.work.rewardservice.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "RewardService API",
                version = "0.1.0",
                description = "APIs to computer Reward Points as per purchases"
        ),
        servers = {
                @Server(url = "/", description = "Server")
        }
)

public class OpenApiDefinition {

}
