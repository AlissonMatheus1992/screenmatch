package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
